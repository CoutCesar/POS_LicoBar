//Este codigo ya fue optimizado
//Falta mejorar las Exepciones
package Controllers;

import Models.Conexion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author César
 */

public class Control_Administracion
{
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear un Array con las Fechas de los 6 Dias anteriores al dia Actual para crear la Grafica
    public LocalDate[] calcularPeriodoSemanal() 
    {
        int tamanoPeriodo = 7;
        LocalDate fechaActual = LocalDate.now();

        List<LocalDate> diasPeriodo = new ArrayList<>();

        for (int i = 0; i < tamanoPeriodo; i++) 
        {
            LocalDate diaAnterior = fechaActual.minusDays(i);
            diasPeriodo.add(diaAnterior);
        }

        Collections.reverse(diasPeriodo);
        
        //Convierte la lista en un Array de LocalDate
        LocalDate[] periodo = diasPeriodo.toArray(new LocalDate[0]);
        return periodo;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Crear un Array con las ganancias de los dias del Periodo para la Grafica
    public ArrayList<Float> crearModeloGananciasDiarias(LocalDate[] periodo) 
    {
        ArrayList<Float> gananciasDiarias = new ArrayList<>();

        for (int i = 0; i < 7; i++) 
        {
            //Llama el metodo que Calcula las ganancias de un Dia
            float cantidad = calcularGananciaDiaria(periodo[i]); 
            gananciasDiarias.add(cantidad);
        }
        return gananciasDiarias;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para calcular las Ganancias de un Dia
    public float calcularGananciaDiaria(LocalDate fecha) 
    {
        float cantidad = 0;

        try (Connection connection = Conexion.obtenerConexion()) 
        {
            String sql = "SELECT SUM(Utilidad) AS TotalUtilidad FROM Ventas WHERE Fecha_Venta = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
            {
                preparedStatement.setString(1, fecha.toString());

                try (ResultSet resultSet = preparedStatement.executeQuery()) 
                {
                    // Verifica si hay resultados y obtén el valor de la suma
                    if (resultSet.next()) 
                    {
                        cantidad = resultSet.getFloat("TotalUtilidad");
                    }
                }
            }

        } catch (SQLException e) 
        {
            System.err.println("Error al calcular las ganancias " + e.getMessage());
        }
        return cantidad;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Crear un Array con las Fechas del Periodo para la Grafica
    public ArrayList<String> crearModeloDiasSemana(LocalDate[] periodo) 
    {
        ArrayList<String> DatosFechas = new ArrayList<>();
        
        for (int i = 0; i < 7; i++)
        {
            String Fecha = convertirFechaADia(periodo[i]);
            DatosFechas.add(Fecha);
        }
        return DatosFechas;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para convertir una Fecha en un String por ejemplo "2023-12-28" lo convierte en "Jueves 28"
    public String convertirFechaADia(LocalDate fecha) 
    {
        // Obtener el nombre del día en el idioma predeterminado del sistema
        String nombreDia = fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());

        // Obtener el número del día del mes
        int numeroDia = fecha.getDayOfMonth();

        // Crea la cadena con el formato deseado
        String dia = nombreDia + " " + numeroDia;
        
        return dia;
    }

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear un Array de Fechas del primer dia de los 11 Meses anteriores al mes Actual para la Grafica
    public LocalDate[] calcularPeriodoAnual() 
    {
        LocalDate fechaActual = LocalDate.now();

        List<LocalDate> mesesAnteriores = new ArrayList<>();
        mesesAnteriores.add(fechaActual.withDayOfMonth(1));

        // Agregar los primeros días de los 11 meses anteriores (excluyendo el mes actual)
        for (int i = 1; i <= 11; i++) 
        {
            LocalDate primerDiaMesAnterior = fechaActual.minusMonths(i).withDayOfMonth(1);
            mesesAnteriores.add(primerDiaMesAnterior);
        }

        Collections.reverse(mesesAnteriores);
        
        //Convierte la lista en un Array LocalDate
        LocalDate[] periodo = mesesAnteriores.toArray(new LocalDate[0]);
        return periodo;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public ArrayList<Float> crearModeloGananciasMensuales(LocalDate[] periodo) 
    {
        ArrayList<Float> DatosGanancias = new ArrayList<>();

        for (int i = 0; i < 12; i++) 
        {
            float cantidad = calcularGananciaMensual(periodo[i]);
            DatosGanancias.add(cantidad);
        }
        return DatosGanancias;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public float calcularGananciaMensual(LocalDate periodo) 
    {
        float cantidad = 0;

        try (Connection connection = Conexion.obtenerConexion()) {
            // Consulta SQL para sumar las utilidades de los registros del mismo mes y año
            String sql = "SELECT SUM(Utilidad) AS TotalUtilidad FROM Ventas WHERE strftime('%Y-%m', Fecha_Venta) = strftime('%Y-%m', ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Establece el valor del parámetro en la consulta
                preparedStatement.setString(1, periodo.toString());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Verifica si hay resultados y obtén el valor de la suma
                    if (resultSet.next()) {
                        cantidad = resultSet.getFloat("TotalUtilidad");
                    }
                }
            }

        } catch (SQLException e) {
            // Manejo de errores
            System.err.println("Error al calcular la cantidad del mes: " + e.getMessage());
        }

        return cantidad;
    }
    
    
public ArrayList<String> crearModeloFechasAno(LocalDate[] periodo) 
    {
        ArrayList<String> DatosFechas = new ArrayList<>();
        
        for (int i = 0; i < 12; i++) 
        {
            String Fecha = convertirFechaAMes(periodo[i]);
            DatosFechas.add(Fecha);
        }
        return DatosFechas;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public String convertirFechaAMes(LocalDate periodo) 
    {
        // Utiliza un formateador de fecha para obtener el nombre del mes y el año
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

        // Formatea la fecha y obtén el resultado como una cadena
        String mesFormateado = periodo.format(formatter);

        return mesFormateado;
    }
    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear un ArrayList con los Nombres de los Productos de la Base de Datos
    public ArrayList<String> crearModeloNombresProductos() 
    {
        ArrayList<String> nombresProductos = new ArrayList<>();

        try (Connection conexion = Conexion.obtenerConexion()) 
        {
            String consulta = "SELECT Nombre_Producto FROM Producto";

            try (PreparedStatement pst = conexion.prepareStatement(consulta);
                 ResultSet rs = pst.executeQuery()) 
            {
                while (rs.next()) 
                {
                    String nombreProducto = rs.getString("Nombre_Producto");
                    nombresProductos.add(nombreProducto);
                }
            }

        } catch (SQLException e) 
        {
            System.err.println("Error al obtener los nombres de los productos " + e.getMessage());
        }
        return nombresProductos;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear un Array con los Codigos de los Productos, es necesario para calcular las Ventas
    public ArrayList<Integer> consultarCodigosProductos() 
    {
        ArrayList<Integer> codigosProductos = new ArrayList<>();

        try (Connection conexion = Conexion.obtenerConexion()) 
        {
            String consulta = "SELECT ID_Producto FROM Producto";

            try (PreparedStatement pst = conexion.prepareStatement(consulta);
                 ResultSet rs = pst.executeQuery()) 
            {
                while (rs.next()) 
                {
                    int idProducto = rs.getInt("ID_Producto");
                    codigosProductos.add(idProducto);
                }
            }

        } catch (SQLException e) 
        {
            System.err.println("Error al obtener el Codigo de los productos: " + e.getMessage());
        }
        return codigosProductos;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Crear un Array con las Ventas del Dia para una Grafica
    public ArrayList<Integer> crearModeloVentasDiarias(ArrayList<Integer> IDs)
    {
        ArrayList<Integer> ventas = new ArrayList<>();

        LocalDate Fecha = LocalDate.now();

        for (int i = 0; i < IDs.size(); i++) 
        {
            int ID = IDs.get(i);
            int Cuenta = calcularVentasDia(Fecha, ID);
            ventas.add(Cuenta);
        }
        return ventas;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear un Array con las Ventas de la Semana para una Grafica
    public ArrayList<Integer> crearModeloVentasSemanales(ArrayList<Integer> IDs)
    {
        ArrayList<Integer> Ventas = new ArrayList();
        
        LocalDate Fecha = LocalDate.now();
        
        for (int i = 0; i < IDs.size(); i++) 
        {
            int ID = IDs.get(i);
            int Cuenta = calcularVentasSemana(Fecha, ID);
            Ventas.add(Cuenta);
        }
        return Ventas;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear un Array con las Ventas del Año para una Grafica
    public ArrayList<Integer> crearModeloVentasMensuales(ArrayList<Integer> IDs)
    {
        ArrayList<Integer> Ventas = new ArrayList();
        
        LocalDate Fecha = LocalDate.now();
        
        for (int i = 0; i < IDs.size(); i++) 
        {
            int ID = IDs.get(i);
            int Cuenta = calcularVentasMes(Fecha, ID);
            Ventas.add(Cuenta);
        }
        return Ventas;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Calcular las Ventas de un Producto en un Dia
    public int calcularVentasDia(LocalDate fecha, int id)
    {
        int ventas = 0;

        try (Connection conexion = Conexion.obtenerConexion())
        {
            // Consulta SQL para obtener la cantidad total directamente sumando la columna Cantidad
            String consulta = "SELECT SUM(vp.Cantidad) AS TotalCantidad "
                            + "FROM Venta_Producto vp "
                            + "JOIN Ventas v ON vp.ID_Venta = v.ID_Venta "
                            + "WHERE v.Fecha_Venta = ? AND vp.ID_Producto = ?";

            try (PreparedStatement pst = conexion.prepareStatement(consulta))
            {
                pst.setString(1, fecha.toString());
                pst.setInt(2, id);

                try (ResultSet rs = pst.executeQuery())
                {
                    if (rs.next())
                    {
                        ventas = rs.getInt("TotalCantidad");
                    }
                }
            }
        } 
        catch (SQLException e)
        {
            System.err.println("Error al calcular ventas del día " + e.getMessage());
        }

        return ventas;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Calcular las Ventas de un Producto en una Semana
    public int calcularVentasSemana(LocalDate fecha, int id)
    {
        int cantidadTotal = 0;

        // Obtener el primer y último día de la semana de la fecha proporcionada
        LocalDate inicioSemana = fecha.with(DayOfWeek.MONDAY);
        LocalDate finSemana = fecha.with(DayOfWeek.SUNDAY);

        try (Connection conexion = Conexion.obtenerConexion()) 
        {
            // Consulta SQL para obtener la cantidad total directamente sumando la columna Cantidad
            String consulta = "SELECT SUM(vp.Cantidad) AS TotalCantidad "
                            + "FROM Venta_Producto vp "
                            + "JOIN Ventas v ON vp.ID_Venta = v.ID_Venta "
                            + "WHERE v.Fecha_Venta BETWEEN ? AND ? AND vp.ID_Producto = ?";

            try (PreparedStatement pst = conexion.prepareStatement(consulta))
            {
                pst.setString(1, inicioSemana.toString());
                pst.setString(2, finSemana.toString());
                pst.setInt(3, id);

                try (ResultSet rs = pst.executeQuery())
                {
                    if (rs.next())
                    {
                        cantidadTotal = rs.getInt("TotalCantidad");
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("Error al calcular ventas de la semana " + e.getMessage());
        }

        return cantidadTotal;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //Metodo para Calcular las Ventas de un Producto en un Mes
    public int calcularVentasMes(LocalDate fecha, int id)
    {
        int cantidadTotal = 0;

        // Obtener el primer y último día del mes de la fecha proporcionada
        LocalDate inicioMes = fecha.withDayOfMonth(1);
        LocalDate finMes = YearMonth.from(fecha).atEndOfMonth();

        try (Connection conexion = Conexion.obtenerConexion()) 
        {
            // Consulta SQL para obtener la cantidad total directamente sumando la columna Cantidad
            String consulta = "SELECT SUM(vp.Cantidad) AS TotalCantidad "
                            + "FROM Venta_Producto vp "
                            + "JOIN Ventas v ON vp.ID_Venta = v.ID_Venta "
                            + "WHERE v.Fecha_Venta BETWEEN ? AND ? AND vp.ID_Producto = ?";

            try (PreparedStatement pst = conexion.prepareStatement(consulta))
            {
                pst.setString(1, inicioMes.toString());
                pst.setString(2, finMes.toString());
                pst.setInt(3, id);

                try (ResultSet rs = pst.executeQuery())
                {
                    if (rs.next())
                    {
                        cantidadTotal = rs.getInt("TotalCantidad");
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("Error al calcular ventas del mes " + e.getMessage());
        }

        return cantidadTotal;
    }
}

