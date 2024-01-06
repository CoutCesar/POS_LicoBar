//Este codigo ya fue optimizado
//Falta mejorar las Exepciones
package Controllers;

import Models.Conexion;
import Models.ConfiguracionUsuario;
import Models.Tema;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author César Eduardo
 */
public class Control_Configuracion 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para actualizar la Configuracion de Usuario
    public void nuevaConfiguracion(ConfiguracionUsuario configuracionusuario) 
    {
        int ID = configuracionusuario.getIDUsuario();

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaEmpleado = "UPDATE Configuracion SET Tema = ?, Componente1 = ?, Componente2 = ? WHERE ID_Empleado = ?";
            
            try (PreparedStatement stmtEmpleado = conn.prepareStatement(consultaEmpleado)) 
            {
                stmtEmpleado.setInt(1, configuracionusuario.getTema());
                stmtEmpleado.setInt(2, configuracionusuario.getComponente1());
                stmtEmpleado.setInt(3, configuracionusuario.getComponente2());
                stmtEmpleado.setInt(4, ID);
                stmtEmpleado.executeUpdate();
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al actualizar la configuración: " + e.getMessage());
        }
    }

    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Consultar la Configuracion de un Usuario
    public ConfiguracionUsuario cargarConfiguracion(int id) 
    {
        ConfiguracionUsuario configuracionusuario = new ConfiguracionUsuario();

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT * FROM Configuracion WHERE ID_Empleado = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) 
                {
                    int idEmpleado = rs.getInt("ID_Empleado");
                    int tema = rs.getInt("Tema");
                    int componente1 = rs.getInt("Componente1");
                    int componente2 = rs.getInt("Componente2");

                    configuracionusuario.setIDUsuario(idEmpleado);
                    configuracionusuario.setTema(tema);
                    configuracionusuario.setComponente1(componente1);
                    configuracionusuario.setComponente2(componente2);
                }
            }
            
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
        }
        return configuracionusuario;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para consultar el ID de un Tema con su Nombre
    public int consultarIdTema(String nombre) 
    {
        int id = 0;

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT ID_Tema FROM Tema WHERE Nombre = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setString(1, nombre);

                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) 
                {
                    id = rs.getInt("ID_Tema");
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al consultar el ID del tema: " + e.getMessage());
        }
        return id;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para cargar los Nombres de los Tema en un DefaultComboBoxModel
    public DefaultComboBoxModel<String> cargarTemas() 
    {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT Nombre FROM Tema ORDER BY ID_Tema";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) 
                {
                    model.addElement(rs.getString("Nombre"));
                }
            }
        } 

        catch (SQLException e) 
        {
            System.err.println("Error al cargar los temas: " + e.getMessage());
        }
        return model;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Consultar los Colores de un Tema
    public Tema cargarTema(int idTema) 
    {
        Tema tema = new Tema();
        
        try (Connection conn = Conexion.obtenerConexion()) 
        {
            String consultaSQL = "SELECT * FROM Tema WHERE ID_Tema = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) 
            {
                stmt.setInt(1, idTema);
                
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) 
                {
                    String Nombre = rs.getString("Nombre");
                    String Color1 = rs.getString("Color1");
                    String Color2 = rs.getString("Color2");
                    String Color3 = rs.getString("Color3");
                    String Color4 = rs.getString("Color4");
                    String Color5 = rs.getString("Color5");
                    
                    tema.setNombre(Nombre);
                    tema.setID_Tema(idTema);
                    tema.setColor1(Color1);
                    tema.setColor2(Color2);
                    tema.setColor3(Color3);
                    tema.setColor4(Color4);
                    tema.setColor5(Color5);
                }
            }
        } 
        
        catch (SQLException e) 
        {
            System.err.println("Error al cargar el tema: " + e.getMessage());
        }
        return tema;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para modificar la Apariencia de los ComboBox adcorde al Tema
    public ComboBoxUI createCustomComboBoxUI(Color color3, Color color2) 
    {
        return new BasicComboBoxUI() 
        {
            @Override
            protected JButton createArrowButton() 
            {
                JButton btn = new JButton();
                btn.setIcon(new ImageIcon(getClass().getResource("/Resources/Images/Icono_ComboBox.png")));
                btn.setBackground(color3);
                return btn;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                g.setColor(color2);
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            }

            @Override
            protected ListCellRenderer createRenderer() 
            {
                return new DefaultListCellRenderer() 
                {
                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        list.setSelectionBackground(color3);

                        if (index != -1) 
                        {
                            //setIcon(new ImageIcon(getClass().getResource("/img/flecha.png")));
                        }
                        return this;
                    }
                };
            }
        };
    }
}