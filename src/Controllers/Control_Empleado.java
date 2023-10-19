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
    public void NuevoEmpleado(Empleado empleado) 
    {
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define la consulta SQL de inserción
            String consultaSQL = "INSERT INTO Empleado (ID_Empleado, Nombre_Empleado, Tipo_Empleado, Contraseña) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(consultaSQL);
            
                // Establece los valores de los parámetros en la consulta SQL
                stmt.setInt(1, empleado.getID_Empleado());
                stmt.setString(2, empleado.getNombre_Empleado());
                stmt.setInt(3, empleado.getPuesto());
                stmt.setString(4, empleado.getContrasena());

                // Ejecuta la consulta de inserción
                int filasAfectadas = stmt.executeUpdate();

                Control_Sonidos controlsonido = new Control_Sonidos();
                controlsonido.ReproducirCorrecto();
                JOptionPane.showMessageDialog(null, "Artículo registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al insertar empleado: " + e.getMessage());
            System.out.println(empleado.getID_Empleado());
            
            System.out.println("Verga verga verga verga verga");
            Control_Sonidos controlsonido = new Control_Sonidos();
            controlsonido.ReproducirError1();
            JOptionPane.showMessageDialog(null, "Ya existe un Empleado con ese ID", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    
    public Empleado CargarEmpleado(int ID) 
    {
        Empleado empleado = null;

        try (Connection conn = Conexion.obtenerConexion()) {
            // Define una consulta SQL que busca un registro en la tabla Empleado
            // cuyo ID_Empleado sea igual al ID proporcionado.
            String consultaSQL = "SELECT ID_Empleado, Nombre_Empleado, Tipo_Empleado FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setInt(1, ID);

                ResultSet rs = stmt.executeQuery();

                // Si se encuentra un registro, crea un objeto Empleado con los datos y lo devuelve.
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setID_Empleado(rs.getInt("ID_Empleado"));
                    empleado.setNombre_Empleado(rs.getString("Nombre_Empleado"));
                    empleado.setPuesto(rs.getInt("Tipo_Empleado"));
                    System.out.println("Se realizó la búsqueda");
                } else {
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return empleado;
    }

    
    
    public void ModificarEmpleado(Empleado empleado, int ID) 
    {
        try (Connection conn = Conexion.obtenerConexion()) {
            // Define la consulta SQL para actualizar el registro
            String consultaSQL = "UPDATE Empleado SET ID_Empleado = ?, Nombre_Empleado = ?, Tipo_Empleado = ? WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                // Establece los valores en la consulta para actualizar el registro
                stmt.setInt(1, empleado.getID_Empleado());
                stmt.setString(2, empleado.getNombre_Empleado());
                stmt.setInt(3, empleado.getPuesto());
                stmt.setInt(4, ID);

                // Ejecuta la consulta de actualización
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Se actualizó el empleado con ID " + ID);

                    Control_Sonidos controlsonido = new Control_Sonidos();
                    controlsonido.ReproducirCorrecto();

                    JOptionPane.showMessageDialog(null, "El empleado se ha modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            Control_Sonidos controlsonido = new Control_Sonidos();
            controlsonido.ReproducirError1();
            JOptionPane.showMessageDialog(null, "Error, el ID ingresado no existe o ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    public DefaultListModel<String> ConsultaIdMod(int ID) 
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) {
            // Define una consulta SQL que busca registros en la tabla Empleado
            // cuyo ID_Empleado sea igual al ID proporcionado.
            String consultaSQL = "SELECT ID_Empleado, Nombre_Empleado FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                // Establece el valor del parámetro en la consulta
                stmt.setInt(1, ID);

                ResultSet rs = stmt.executeQuery();

                // Agrega los nombres de empleados seguidos de sus IDs al modelo
                while (rs.next()) {
                    resultadosEncontrados = true; // Se encontraron resultados
                    int idEmpleado = rs.getInt("ID_Empleado");
                    String nombreEmpleado = rs.getString("Nombre_Empleado");
                    String empleadoInfo = nombreEmpleado + " (ID Empleado: " + idEmpleado + ")";
                    listModel.addElement(empleadoInfo);
                }

                if (!resultadosEncontrados) {
                    listModel.addElement("Sin resultados");
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return listModel;
    }
    
    
    public DefaultListModel<String> ConsultaNombreMod(String Nombre) 
    {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        boolean resultadosEncontrados = false; // Variable para rastrear si se encontraron resultados

        try (Connection conn = Conexion.obtenerConexion()) {
            // Define una consulta SQL que busca registros en la tabla Empleado
            // cuyo campo Nombre sea similar al nombre proporcionado.
            String consultaSQL = "SELECT ID_Empleado, Nombre_Empleado FROM Empleado WHERE Nombre_Empleado LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter antes y después del nombre.
                String patrónBusqueda = "%" + Nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los nombres de empleados seguidos de sus IDs al modelo
                while (rs.next()) {
                    resultadosEncontrados = true; // Se encontraron resultados
                    int idEmpleado = rs.getInt("ID_Empleado");
                    String nombreEmpleado = rs.getString("Nombre_Empleado");
                    String empleadoInfo = nombreEmpleado + " (ID Empleado: " + idEmpleado + ")";
                    listModel.addElement(empleadoInfo);
                }

                if (!resultadosEncontrados) {
                    listModel.addElement("Sin resultados");
                    System.out.println("No se encontró ningún empleado con el nombre proporcionado.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        return listModel;
    }
    
    
    public DefaultTableModel CargarEmpleados() 
    {
        DefaultTableModel model = new DefaultTableModel();

        // Agregar las columnas al modelo con los nombres de título especificados
        model.addColumn("ID Empleado");
        model.addColumn("Nombre Empleado");
        model.addColumn("Tipo_Empleado");

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define una consulta SQL para obtener todos los registros de la tabla Empleado
            String consultaSQL = "SELECT * FROM Empleado";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) {
                    Object[] rowData = new Object[3]; // 3 columnas
                    rowData[0] = rs.getInt("ID_Empleado");
                    rowData[1] = rs.getString("Nombre_Empleado");
                    rowData[2] = rs.getString("Tipo_Empleado");
                    model.addRow(rowData);
                }
                System.out.println("Se cargaron todos los datos de Empleado");
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al cargar los datos de Empleado: " + e.getMessage());
        }

        return model;
    }
    
    
    public DefaultTableModel ConsultaID(int ID) 
    {
        DefaultTableModel model = new DefaultTableModel();

        // Agregar las columnas al modelo con los nombres de título especificados
        model.addColumn("ID Empleado");
        model.addColumn("Nombre Empleado");
        model.addColumn("Tipo_Empleado");

        try (Connection conn = Conexion.obtenerConexion()) {
            // Define una consulta SQL que busca registros en la tabla Empleado
            // cuyo ID_Empleado sea igual al ID proporcionado.
            String consultaSQL = "SELECT * FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setInt(1, ID);
                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) {
                    Object[] rowData = new Object[3]; // 3 columnas
                    rowData[0] = rs.getInt("ID_Empleado");
                    rowData[1] = rs.getString("Nombre_Empleado");
                    rowData[2] = rs.getString("Tipo_Empleado");
                    model.addRow(rowData);
                }

                if (model.getRowCount() == 0) {
                    model.addRow(new Object[]{"Sin resultados", "", ""});
                    System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                } else {
                    System.out.println("Se encontraron resultados para el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta por ID: " + e.getMessage());
        }

        return model;
    }


    public DefaultTableModel ConsultaNombre(String Nombre) 
    {
        DefaultTableModel model = new DefaultTableModel();

        // Agregar las columnas al modelo con los nombres de título especificados
        model.addColumn("ID Empleado");
        model.addColumn("Nombre Empleado");
        model.addColumn("Tipo_Empleado");

        try (Connection conn = Conexion.obtenerConexion()) {
            // Define una consulta SQL que busca registros en la tabla Empleado
            // cuyo Nombre_Empleado sea similar al nombre proporcionado.
            String consultaSQL = "SELECT * FROM Empleado WHERE Nombre_Empleado LIKE ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                // Utiliza un patrón de búsqueda que incluya el nombre proporcionado
                // y cualquier otro carácter antes o después del nombre.
                String patrónBusqueda = "%" + Nombre + "%";
                stmt.setString(1, patrónBusqueda);

                ResultSet rs = stmt.executeQuery();

                // Agrega los datos al modelo
                while (rs.next()) {
                    Object[] rowData = new Object[3]; // 3 columnas
                    rowData[0] = rs.getInt("ID_Empleado");
                    rowData[1] = rs.getString("Nombre_Empleado");
                    rowData[2] = rs.getString("Tipo_Empleado");
                    model.addRow(rowData);
                }

                if (model.getRowCount() == 0) {
                    model.addRow(new Object[]{"Sin resultados", "", ""});
                    System.out.println("No se encontró ningún empleado con el nombre proporcionado.");
                } else {
                    System.out.println("Se encontraron resultados para el nombre proporcionado.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta por nombre: " + e.getMessage());
        }

        return model;
    }
    
    
    public void EliminarEmpleado(int id) 
    {
        Control_Sonidos controlsonido = new Control_Sonidos();

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Define la consulta SQL para eliminar el registro
            String consultaSQL = "DELETE FROM Empleado WHERE ID_Empleado = ?";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                // Establece el valor del parámetro en la consulta
                stmt.setInt(1, id);

                // Ejecuta la consulta de eliminación
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    controlsonido.ReproducirCorrecto();
                    JOptionPane.showMessageDialog(null, "El empleado fue eliminado correctamente.", "Empleado Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Se eliminó el empleado con ID_Empleado " + id);
                } else {
                    System.out.println("No se encontró ningún empleado con el ID_Empleado proporcionado.");
                }
            }
        } catch (SQLException e) 
        {
            System.err.println("Error al realizar la consulta de eliminación: " + e.getMessage());
        }
    }
}
