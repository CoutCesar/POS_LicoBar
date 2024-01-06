//Este codigo ya fue optimizado
//Falta mejorar las Exepciones
package Controllers;

import java.sql.ResultSet;
import Models.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Models.Empleado;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author César Eduardo
 */
public class Control_Empleado 
{
    
    Control_Sonido controlSonido = new Control_Sonido();
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Registrar un nuevo Empleado en la base de datos
    public void registrarEmpleado(Empleado empleado) 
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "INSERT INTO Empleado (ID_Empleado, Nombre_Empleado, Tipo_Empleado, Contraseña) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            
            stmt.setInt(1, empleado.getID_Empleado());
            stmt.setString(2, empleado.getNombre_Empleado());
            stmt.setInt(3, empleado.getPuesto());
            stmt.setString(4, empleado.getContrasena());

            int filasAfectadas = stmt.executeUpdate();

            controlSonido.reproducirSonidoCorrecto();
            JOptionPane.showMessageDialog(null, "Artículo registrado exitosamente", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al insertar empleado: " + e.getMessage());
            controlSonido.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Ya existe un Empleado con ese ID", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Eliminar un Empleado de la base de datos
    public void eliminarEmpleado(int id) 
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "DELETE FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, id);
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {
                    controlSonido.reproducirSonidoCorrecto();
                    JOptionPane.showMessageDialog(null, "El empleado fue eliminado correctamente.", 
                            "Empleado Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún empleado con el ID_Empleado proporcionado.");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta de eliminación: " + e.getMessage());
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Modificar la informacion de un Empleado
    public void modificarEmpleado(Empleado empleado, int id) 
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {    
            String consultaSQL = 
                    "UPDATE Empleado SET ID_Empleado = ?, Nombre_Empleado = ?, Tipo_Empleado = ? WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, empleado.getID_Empleado());
                stmt.setString(2, empleado.getNombre_Empleado());
                stmt.setInt(3, empleado.getPuesto());
                stmt.setInt(4, id);

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {
                    controlSonido.reproducirSonidoCorrecto();

                    JOptionPane.showMessageDialog(null, 
                            "El empleado se ha modificado exitosamente", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            controlSonido.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Error, el ID ingresado no existe o ya está en uso", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Modificar la Contraseña de un Empleado
    public void cambiarContrasena(String nuevaContrasena, int id) 
    {
        try (Connection conexion = Conexion.obtenerConexion()) 
        {
            String consulta = "UPDATE Empleado SET Contraseña = ? WHERE ID_Empleado = ?";
            
            try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) 
            {
                pstmt.setString(1, nuevaContrasena);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                
                controlSonido.reproducirSonidoCorrecto();
                JOptionPane.showMessageDialog(null,"La contraseña ha sido cambiada correctamente.",
                        "Cambio de Contraseña Exitoso",JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al cambiar la contraseña: " + e.getMessage());
        }
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para obtener la informacion de un Empleado
    public Empleado cargarEmpleado(int id) 
    {
        Empleado empleado = null;

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Empleado, Nombre_Empleado, Tipo_Empleado FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) 
                {
                    empleado = new Empleado();
                    empleado.setID_Empleado(rs.getInt("ID_Empleado"));
                    empleado.setNombre_Empleado(rs.getString("Nombre_Empleado"));
                    empleado.setPuesto(rs.getInt("Tipo_Empleado"));
                    System.out.println("Se realizó la búsqueda");
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
        return empleado;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para cargar la informacion de los empleados en un DefaultTableModel
    public DefaultTableModel cargarEmpleados() 
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID Empleado");
        model.addColumn("Nombre Empleado");
        model.addColumn("Tipo_Empleado");

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT * FROM Empleado";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) 
                {
                    Object[] rowData = new Object[3]; // 3 columnas
                    rowData[0] = rs.getInt("ID_Empleado");
                    rowData[1] = rs.getString("Nombre_Empleado");
                    rowData[2] = rs.getString("Tipo_Empleado");
                    model.addRow(rowData);
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al cargar los datos de Empleado: " + e.getMessage());
        }

        return model;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una Consulta con ID y regresa los resultados en un DefaultTableModel
    public DefaultTableModel busquedaConID(int id) 
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID Empleado");
        model.addColumn("Nombre Empleado");
        model.addColumn("Tipo_Empleado");

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT * FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) 
                {
                    Object[] rowData = new Object[3]; // 3 columnas
                    rowData[0] = rs.getInt("ID_Empleado");
                    rowData[1] = rs.getString("Nombre_Empleado");
                    rowData[2] = rs.getString("Tipo_Empleado");
                    model.addRow(rowData);
                }

                if (model.getRowCount() == 0) 
                {
                    model.addRow(new Object[]{"Sin resultados", "", ""});
                } 
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta por ID: " + e.getMessage());
        }
        return model;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una Consulta con Nombre y regresa los resultados en un DefaultTableModel
    public DefaultTableModel busquedaConNombre(String nombre) 
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID Empleado");
        model.addColumn("Nombre Empleado");
        model.addColumn("Tipo_Empleado");

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT * FROM Empleado WHERE Nombre_Empleado LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter antes o después del nombre.
                String patrónBusqueda = "%" + nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) 
                {
                    Object[] rowData = new Object[3]; // 3 columnas
                    rowData[0] = rs.getInt("ID_Empleado");
                    rowData[1] = rs.getString("Nombre_Empleado");
                    rowData[2] = rs.getString("Tipo_Empleado");
                    model.addRow(rowData);
                }

                if (model.getRowCount() == 0) 
                {
                    model.addRow(new Object[]{"Sin resultados", "", ""});
                } 
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta por nombre: " + e.getMessage());
        }
        return model;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una Busqueda con codigo y regresa los resultados en un DefaultListModel
    public DefaultListModel<String> consultaConID(int id) 
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Empleado, Nombre_Empleado FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    int idEmpleado = rs.getInt("ID_Empleado");
                    String nombreEmpleado = rs.getString("Nombre_Empleado");
                    String empleadoInfo = nombreEmpleado + " (ID Empleado: " + idEmpleado + ")";
                    listModel.addElement(empleadoInfo);
                }

                if (!resultadosEncontrados) 
                {
                    listModel.addElement("Sin resultados");
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
        return listModel;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una busqueda con Nombre y regresa los resultados en un DefaultListModel
    public DefaultListModel<String> consultaConNombre(String nombre) 
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Empleado, Nombre_Empleado FROM Empleado WHERE Nombre_Empleado LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter antes y después del nombre.
                String patrónBusqueda = "%" + nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    int idEmpleado = rs.getInt("ID_Empleado");
                    String nombreEmpleado = rs.getString("Nombre_Empleado");
                    String empleadoInfo = nombreEmpleado + " (ID Empleado: " + idEmpleado + ")";
                    listModel.addElement(empleadoInfo);
                }

                if (!resultadosEncontrados) 
                {
                    listModel.addElement("Sin resultados");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
        return listModel;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public boolean IniciarSesion(int ID, String Contrasena) 
    {
        boolean Acceso = false;
        
        // Crear una nueva conexión
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT COUNT(*) FROM Empleado WHERE ID_Empleado = ? AND Contraseña = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, ID);
                stmt.setString(2, Contrasena);
                
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) 
                {
                    int count = rs.getInt(1);
                    Acceso = count > 0; // Si count es mayor que 0, se encontró una coincidencia
                }
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al iniciar sesión: " + e.getMessage());
        }
        
        return Acceso;
    }
    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Empleado CargarUsuario(int ID) {
    Empleado empleado = new Empleado();

    try (Connection conn = Conexion.obtenerConexion()) {
        String consultaSQL = "SELECT * FROM Empleado WHERE ID_Empleado = ?";
        try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Recuperar los valores de la fila y crear un objeto Empleado
                int idEmpleado = rs.getInt("ID_Empleado");
                String nombre = rs.getString("Nombre_Empleado");
                int tipo = rs.getInt("Tipo_Empleado");
                String contraseña = rs.getString("Contraseña");

                //empleado = new Empleado(idEmpleado, nombre, tipo, contraseña);
                empleado.setID_Empleado(idEmpleado);
                empleado.setNombre_Empleado(nombre);
                empleado.setPuesto(tipo);
                empleado.setContrasena(contraseña);
                System.out.println("Empleado cargado correctamente");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al cargar el usuario: " + e.getMessage());
    }

    return empleado;
}    
}
