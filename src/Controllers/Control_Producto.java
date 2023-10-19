package Controllers;

import Models.Conexion;
import Models.Producto; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author César Eduardo
 */
public class Control_Producto 
{
    
    //Metodo para registrar un producto
    public void NuevoProducto(Producto producto) 
    {
        try (java.sql.Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "INSERT INTO Producto (ID_Producto, Nombre_Producto, Costo_Elaboracion, Costo_Venta) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, producto.getID_Producto());
                stmt.setString(2, producto.getNombre_Producto());
                stmt.setFloat(3, producto.getCosto());
                stmt.setFloat(4, producto.getCostoVenta());
                stmt.executeUpdate();
                
                Control_Sonidos controlsonido = new Control_Sonidos();
                controlsonido.ReproducirCorrecto();
                JOptionPane.showMessageDialog(null, "Artículo registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) 
        {
            Control_Sonidos controlsonido = new Control_Sonidos();
            controlsonido.ReproducirError1();
            JOptionPane.showMessageDialog(null, "Ya existe un producto con ese Codigo", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    //Codigo para obtener la informacion de un producto
    public Producto CargarProducto(int ID) 
    {
        Producto producto = null;

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL que busca un registro en la tabla Producto
            // cuyo ID_Producto sea igual al ID proporcionado.
            String consultaSQL = "SELECT ID_Producto, Nombre_Producto, Costo_Elaboracion, Costo_venta FROM Producto WHERE ID_Producto = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, ID);

                ResultSet rs = stmt.executeQuery();

                // Si se encuentra un registro, crea un objeto Producto con los datos y lo devuelve.
                if (rs.next()) 
                {
                    producto = new Producto();
                    producto.setID_Producto(rs.getInt("ID_Producto"));
                    producto.setNombre_Producto(rs.getString("Nombre_Producto"));
                    producto.setCostoVenta(rs.getFloat("Costo_Elaboracion"));
                    producto.setCosto(rs.getFloat("Costo_venta"));
                    System.out.println("Se realizó la búsqueda");
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún producto con el ID proporcionado.");
                }
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return producto;
    }

    //Hace una busqueda usando el Codigo del producto
    public DefaultTableModel ConsultaCodigo(int Codigo) 
    {
        DefaultTableModel model = new DefaultTableModel();

        // Agregar las columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Costo");
        model.addColumn("Costo venta");

        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL que busca registros en la tabla Producto
            // cuyo ID_Producto sea similar al ID proporcionado.
            String consultaSQL = "SELECT ID_Producto, Nombre_Producto, Costo_Elaboracion, Costo_venta FROM Producto WHERE ID_Producto LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el ID proporcionado
                // y cualquier otro número después del ID (ejemplo: 12% para ID=12).
                String patrónBusqueda = Codigo + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    Object[] rowData = new Object[4]; // 4 columnas
                    rowData[0] = rs.getInt("ID_Producto");
                    rowData[1] = rs.getString("Nombre_Producto");
                    rowData[2] = rs.getDouble("Costo_Elaboracion");
                    rowData[3] = rs.getDouble("Costo_venta");
                    model.addRow(rowData);
                }
                System.out.println("Se realizó la búsqueda");
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        // Si no se encontraron resultados, agrega una fila con el mensaje "Sin resultados"
        if (!resultadosEncontrados) 
        {
            Object[] sinResultados = {"Sin resultados", "", "", ""};
            model.addRow(sinResultados);
        }

        return model;
    }

    //Hace una consulta usando en Nombre del producto
    public DefaultTableModel ConsultaNombre(String Nombre) 
    {
        DefaultTableModel model = new DefaultTableModel();

        // Agregar las columnas al modelo
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Costo");
        model.addColumn("Costo venta");

        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL que busca registros en la tabla Producto
            // cuyo Nombre_Producto contenga el nombre proporcionado.
            String consultaSQL = "SELECT ID_Producto, Nombre_Producto, Costo_Elaboracion, Costo_venta FROM Producto WHERE Nombre_Producto LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter después del nombre (ejemplo: "nombre%" para "nombre").
                String patrónBusqueda = Nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    Object[] rowData = new Object[4]; // 4 columnas
                    rowData[0] = rs.getInt("ID_Producto");
                    rowData[1] = rs.getString("Nombre_Producto");
                    rowData[2] = rs.getDouble("Costo_Elaboracion");
                    rowData[3] = rs.getDouble("Costo_venta");
                    model.addRow(rowData);
                }
                System.out.println("Se realizó la búsqueda");
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        // Si no se encontraron resultados, agrega una fila con el mensaje "Sin resultados"
        if (!resultadosEncontrados) 
        {
            Object[] sinResultados = {"Sin resultados", "", "", ""};
            model.addRow(sinResultados);
        }

        return model;
    }

    //Carga toda la informacion de los productos
    public DefaultTableModel CargarDatosProducto() 
    {
        DefaultTableModel model = new DefaultTableModel();

        // Agregar las columnas al modelo con los nombres de título especificados
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Costo");
        model.addColumn("Costo venta");

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL para obtener todos los registros de la tabla Producto
            String consultaSQL = "SELECT * FROM Producto";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) {
                    Object[] rowData = new Object[4]; // 4 columnas
                    rowData[0] = rs.getInt("ID_Producto");
                    rowData[1] = rs.getString("Nombre_Producto");
                    rowData[2] = rs.getDouble("Costo_Elaboracion");
                    rowData[3] = rs.getDouble("Costo_venta");
                    model.addRow(rowData);
                }
                System.out.println("Se cargaron todos los datos de Producto");
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al cargar los datos de Producto: " + e.getMessage());
        }

        return model;
    }
    
    
    //Hace una consulta con el Codigo del producto
    public DefaultListModel<String> ConsultaCodigoMod(int Codigo) 
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL que busca registros en la tabla Producto
            // cuyo ID_Producto sea similar al ID proporcionado.
            String consultaSQL = "SELECT ID_Producto, Nombre_Producto FROM Producto WHERE ID_Producto LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el ID proporcionado
                // y cualquier otro número después del ID (ejemplo: 12% para ID=12).
                String patrónBusqueda = Codigo + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los nombres de productos seguidos de sus códigos al modelo
                while (rs.next()) {
                    resultadosEncontrados = true; // Se encontraron resultados
                    int idProducto = rs.getInt("ID_Producto");
                    String nombreProducto = rs.getString("Nombre_Producto");
                    String productoInfo = nombreProducto + " (ID Producto: " + idProducto + ")";
                    listModel.addElement(productoInfo);
                }

                if (!resultadosEncontrados) 
                {
                    listModel.addElement("Sin resultados");
                    System.out.println("No se encontró ningún producto con el ID proporcionado.");
                }
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return listModel;
    }

    //Hace una consulta con el Nombre del producto
    public DefaultListModel<String> ConsultaNombreMod(String Nombre) 
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL que busca registros en la tabla Producto
            // cuyo Nombre_Producto sea igual al nombre proporcionado.
            String consultaSQL = "SELECT ID_Producto, Nombre_Producto FROM Producto WHERE Nombre_Producto LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter después del nombre.
                String patrónBusqueda = "%" + Nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los nombres de productos seguidos de sus códigos al modelo
                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    int idProducto = rs.getInt("ID_Producto");
                    String nombreProducto = rs.getString("Nombre_Producto");
                    String productoInfo = nombreProducto + " (ID Producto: " + idProducto + ")";
                    listModel.addElement(productoInfo);
                }

                if (!resultadosEncontrados) 
                {
                    listModel.addElement("Sin resultados");
                    System.out.println("No se encontró ningún producto con el nombre proporcionado.");
                }
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return listModel;
    }

    //Metodo para modificar un producto
    public void ModificarProducto(Producto producto, int ID) 
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define la consulta SQL para actualizar el registro
            String consultaSQL = "UPDATE Producto SET ID_Producto = ?, Nombre_Producto = ?, Costo_Elaboracion = ?, Costo_venta = ? WHERE ID_Producto = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Establece los valores en la consulta para actualizar el registro
                stmt.setInt(1, producto.getID_Producto());
                stmt.setString(2, producto.getNombre_Producto());
                stmt.setFloat(3, producto.getCosto());
                stmt.setFloat(4, producto.getCostoVenta());
                stmt.setInt(5, ID);

                // Ejecuta la consulta de actualización
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {
                    System.out.println("Se actualizó el producto con ID " + ID);
                    
                    Control_Sonidos controlsonido = new Control_Sonidos();
                    controlsonido.ReproducirCorrecto();
                    
                    JOptionPane.showMessageDialog(null, "El producto se ha modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    System.out.println("No se encontró ningún producto con el ID proporcionado.");
                }
            }
        } catch (SQLException e) 
        {
            Control_Sonidos controlsonido = new Control_Sonidos();
            controlsonido.ReproducirError1();
            JOptionPane.showMessageDialog(null, "Error, el Codigo ingresado ya existe", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    
    public void EliminarProducto(int ID) 
    {
        Control_Sonidos controlsonido = new Control_Sonidos();

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define la consulta SQL para eliminar el registro
            String consultaSQL = "DELETE FROM Producto WHERE ID_Producto = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Establece el valor del parámetro en la consulta
                stmt.setInt(1, ID);

                // Ejecuta la consulta de eliminación
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {
                    controlsonido.ReproducirCorrecto();
                    JOptionPane.showMessageDialog(null, "El producto fue eliminado correctamente.\nPuedes recuperar el registro en la configuración.", "Producto Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Se eliminó el producto con ID_Empleado " + ID);
                } else 
                {
                    System.out.println("No se encontró ningún producto con el ID_Empleado proporcionado.");
                }
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta de eliminación: " + e.getMessage());
        }
    }  
}
