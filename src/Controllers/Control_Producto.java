//Este codigo ya fue optimizado
//Falta mejorar las Exepciones
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
    Control_Sonido controlSonido = new Control_Sonido();
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //Metodo para registrar un nuevo Producto a la base de datos
    public void crearProducto(Producto producto) 
    {
        try (java.sql.Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "INSERT INTO Producto (ID_Producto, Nombre_Producto, Costo, Precio) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, producto.getID_Producto());
                stmt.setString(2, producto.getNombre_Producto());
                stmt.setFloat(3, producto.getCosto());
                stmt.setFloat(4, producto.getCostoVenta());
                stmt.executeUpdate();
                
                controlSonido.reproducirSonidoCorrecto();
                JOptionPane.showMessageDialog(null, "Artículo registrado exitosamente", 
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        
        catch (SQLException e) 
        {
            controlSonido.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Ya existe un producto con ese Codigo", 
                    "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para eliminar un Producto
    public void eliminarProducto(int id)
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "DELETE FROM Producto WHERE ID_Producto = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, id);

                // Ejecuta la consulta de eliminación
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {
                    controlSonido.reproducirSonidoCorrecto();
                    JOptionPane.showMessageDialog(null, 
                            "El producto fue eliminado correctamente.\nPuedes recuperar el registro en la configuración.", 
                            "Producto Eliminado", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún producto con el ID_Empleado proporcionado.");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta de eliminación: " + e.getMessage());
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para modificar un Producto
    public void modificarProducto(Producto producto, int id) 
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "UPDATE Producto SET ID_Producto = ?, Nombre_Producto = ?, Costo = ?, Precio = ? WHERE ID_Producto = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Establece los valores en la consulta para actualizar el registro
                stmt.setInt(1, producto.getID_Producto());
                stmt.setString(2, producto.getNombre_Producto());
                stmt.setFloat(3, producto.getCosto());
                stmt.setFloat(4, producto.getCostoVenta());
                stmt.setInt(5, id);

                // Ejecuta la consulta de actualización
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {
                    controlSonido.reproducirSonidoCorrecto();
                    JOptionPane.showMessageDialog(null, "El producto se ha modificado exitosamente", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún producto con el ID proporcionado.");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            controlSonido.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Error, el Codigo ingresado ya existe", 
                    "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Surtir las Existencias en el Inventario de un Producto
    public void surtirProducto(int id, int cantidad) 
    {   
        // Crear la sentencia SQL para la actualización
        String sql = "UPDATE Producto SET Existencias = Existencias + ? WHERE ID_Producto = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) 
        {
            // Establecer los valores de los parámetros en la sentencia SQL
            pst.setInt(1, cantidad);
            pst.setInt(2, id);

            // Ejecutar la actualización
            int filasActualizadas = pst.executeUpdate();

            if (filasActualizadas > 0) 
            {
                controlSonido.reproducirSonidoCorrecto();
                JOptionPane.showMessageDialog(null, "Producto abastecido con éxito.");
            } 
            
            else 
            {
                controlSonido.reproducirSonidoError1();
                JOptionPane.showMessageDialog(null, "No se encontró un producto con el Codigo " + id, 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al abastecer el producto: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registró el producto", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Desurtir las Existencias en el Inventario de un Producto
    public void desurtirProducto(int codigo, int cantidad) 
    {
        if (!consultarExistencias(codigo, cantidad)) 
        {
            try (Connection conn = Conexion.obtenerConexion(); 
                    PreparedStatement stmt = 
                            conn.prepareStatement("UPDATE Producto SET Existencias = Existencias - ? WHERE ID_Producto = ?")) 
            {
                stmt.setInt(1, cantidad);
                stmt.setInt(2, codigo);

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) 
                {   
                    controlSonido.reproducirSonidoCorrecto();
                    JOptionPane.showMessageDialog(null, "El producto fue desabastecido correctamente.", 
                            "Desabastecimiento Exitoso", JOptionPane.INFORMATION_MESSAGE);
                } 
                
                else 
                {
                    controlSonido.reproducirSonidoError1();
                    JOptionPane.showMessageDialog(null, "No se encontró un producto con el Codigo " + codigo, 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            
            catch (SQLException e) 
            {
                System.err.println("Error al desabastecer el producto: " + e.getMessage());
                controlSonido.reproducirSonidoError1();
                JOptionPane.showMessageDialog(null, "Error al desabastecer el producto.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else 
        {
            // Error: No hay suficientes existencias para desabastecer
            controlSonido.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "No hay suficientes existencias para desabastecer", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para consultar la informacion de un Producto mediante un Codigo
    public Producto cargarProducto(int codigo) 
    {
        Producto producto = null;
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Producto, Nombre_Producto, Costo, Precio FROM Producto WHERE ID_Producto = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, codigo);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) 
                {
                    producto = new Producto();
                    producto.setID_Producto(rs.getInt("ID_Producto"));
                    producto.setNombre_Producto(rs.getString("Nombre_Producto"));
                    producto.setCostoVenta(rs.getFloat("Costo"));
                    producto.setCosto(rs.getFloat("Precio"));
                } 
                
                else 
                {
                    System.out.println("No se encontró ningún producto con el Codigo proporcionado.");
                }
            }
            
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return producto;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Metodo para consultar todos los productos de la base de datos y los retorna en un DefaultTableModel
    public DefaultTableModel cargarProductos() 
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Costo");
        model.addColumn("Costo venta");
        model.addColumn("Existencias");

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT * FROM Producto";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) 
                {
                    Object[] rowData = new Object[5];
                    
                    rowData[0] = rs.getInt("ID_Producto");
                    rowData[1] = rs.getString("Nombre_Producto");
                    rowData[2] = rs.getDouble("Costo");
                    rowData[3] = rs.getDouble("Precio");
                    rowData[4] = rs.getInt("Existencias");
                    model.addRow(rowData);
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al cargar los datos de Producto: " + e.getMessage());
        }
        return model;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una busqueda con Codigo y retorna un DefaultTableModel con los resultados
    public DefaultTableModel busquedaConCodigo(int codigo) 
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Costo");
        model.addColumn("Costo venta");
        model.addColumn("Existencias");

        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {    
            String consultaSQL = 
                    "SELECT ID_Producto, Nombre_Producto, Costo, Precio, Existencias FROM Producto WHERE ID_Producto LIKE ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el ID proporcionado
                // y cualquier otro número después del ID (ejemplo: 12% para ID=12).
                String patrónBusqueda = codigo + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    Object[] rowData = new Object[5]; 
                    
                    rowData[0] = rs.getInt("ID_Producto");
                    rowData[1] = rs.getString("Nombre_Producto");
                    rowData[2] = rs.getDouble("Costo");
                    rowData[3] = rs.getDouble("Precio");
                    rowData[4] = rs.getInt("Existencias");
                    model.addRow(rowData);
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        // Si no se encontraron resultados, agrega una fila con el mensaje "Sin resultados"
        if (!resultadosEncontrados) 
        {
            Object[] sinResultados = {"Sin resultados", "", "", "", ""};
            model.addRow(sinResultados);
        }
        return model;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una busqueda con Codigo y retorna un DefaultListModel con los resultados
    public DefaultListModel<String> consultaConCodigo(int codigo) 
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Producto, Nombre_Producto FROM Producto WHERE ID_Producto LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el ID proporcionado
                // y cualquier otro número después del ID (ejemplo: 12% para ID=12).
                String patrónBusqueda = codigo + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los nombres de productos seguidos de sus códigos al modelo
                while (rs.next()) 
                {
                    resultadosEncontrados = true;
                    int idProducto = rs.getInt("ID_Producto");
                    String nombreProducto = rs.getString("Nombre_Producto");
                    String productoInfo = nombreProducto + " (ID Producto: " + idProducto + ")";
                    model.addElement(productoInfo);
                }

                if (!resultadosEncontrados) 
                {
                    model.addElement("Sin resultados");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
        return model;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una busqueda con Nombre y retorna un DefaultTableModel con los resultados
    public DefaultTableModel busquedaConNombre(String nombre) 
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Costo");
        model.addColumn("Costo venta");
        model.addColumn("Existencias");

        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Producto, Nombre_Producto, Costo, Precio, Existencias FROM Producto WHERE Nombre_Producto LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter después del nombre (ejemplo: "nombre%" para "nombre").
                String patrónBusqueda = nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) 
                {
                    resultadosEncontrados = true; // Se encontraron resultados
                    Object[] rowData = new Object[5];
                    
                    rowData[0] = rs.getInt("ID_Producto");
                    rowData[1] = rs.getString("Nombre_Producto");
                    rowData[2] = rs.getDouble("Costo");
                    rowData[3] = rs.getDouble("Precio");
                    rowData[4] = rs.getInt("Existencias");
                    model.addRow(rowData);
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        // Si no se encontraron resultados, agrega una fila con el mensaje "Sin resultados"
        if (!resultadosEncontrados) {
            Object[] sinResultados = {"Sin resultados", "", "", "", ""};
            model.addRow(sinResultados);
        }
        return model;
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para hacer una busqueda con Nombre y retorna un DefaultListModel con los resultados
    public DefaultListModel<String> consultaConNombre(String Nombre) 
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = 
                    "SELECT ID_Producto, Nombre_Producto FROM Producto WHERE Nombre_Producto LIKE ?";

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
                    model.addElement(productoInfo);
                }

                if (!resultadosEncontrados) 
                {
                    model.addElement("Sin resultados");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
        return model;
    }   


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para verificar que una Cantidad no sea mayor a la Existente en un producto
    public boolean consultarExistencias(int codigo, int cantidad) 
    {
        boolean error = false;

        try (Connection conn = 
                Conexion.obtenerConexion(); PreparedStatement stmt = 
                        conn.prepareStatement("SELECT Existencias FROM Producto WHERE ID_Producto = ?")) 
        {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) 
            {
                int existenciasActuales = rs.getInt("Existencias");

                // Verificar si la cantidad a eliminar es menor o igual a las existencias actuales
                if (cantidad > existenciasActuales) {error = true;}
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al consultar existencias: " + e.getMessage());
            error = true; // Tratar la excepción como un error
        }
        return error;
    }
}