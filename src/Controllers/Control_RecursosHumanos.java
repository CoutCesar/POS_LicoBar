package Controllers;

import Models.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Empleado;
import java.util.Set;

/**
 *
 * @author César Eduardo
 */
public class Control_RecursosHumanos 
{
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
