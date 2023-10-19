package Controllers;

import Models.Conexion;
import Models.ConfiguracionUsuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author César Eduardo
 */
public class Control_Configuracion 
{
    public void NuevaConfiguracion(ConfiguracionUsuario configuracionusuario) 
    {
        int ID = configuracionusuario.getIDUsuario();

        try (Connection conn = Conexion.obtenerConexion()) 
        {
            // Primero, actualizamos la tabla Empleado con los valores de configuracionusuario
            String consultaEmpleado = "UPDATE Configuracion SET Tema = ?, Componente1 = ?, Componente2 = ? WHERE ID_Empleado = ?";
            try (PreparedStatement stmtEmpleado = conn.prepareStatement(consultaEmpleado)) {
                stmtEmpleado.setInt(1, configuracionusuario.getTema());
                stmtEmpleado.setInt(2, configuracionusuario.getComponente1());
                stmtEmpleado.setInt(3, configuracionusuario.getComponente2());
                stmtEmpleado.setInt(4, ID);
                stmtEmpleado.executeUpdate();
            }

            // Luego, si lo deseas, puedes realizar una actualización similar en la tabla Configuracion
            // Si ambas tablas están relacionadas por ID_Empleado y siempre deben tener los mismos valores,
            // esto podría no ser necesario.
            // Aquí un ejemplo para la tabla Configuracion:
            /*
            String consultaConfiguracion = "UPDATE Configuracion SET Tema = ?, Componente1 = ?, Componente2 = ? WHERE ID_Empleado = ?";
            try (PreparedStatement stmtConfiguracion = conn.prepareStatement(consultaConfiguracion)) {
                stmtConfiguracion.setInt(1, configuracionusuario.getTema());
                stmtConfiguracion.setInt(2, configuracionusuario.getComponente1());
                stmtConfiguracion.setInt(3, configuracionusuario.getComponente2());
                stmtConfiguracion.setInt(4, ID);
                stmtConfiguracion.executeUpdate();
            }
            */
        } catch (SQLException e) {
            System.err.println("Error al actualizar la configuración: " + e.getMessage());
        }
    }

    
    
    public ConfiguracionUsuario CargarConfiguracion(int ID) 
    {
        ConfiguracionUsuario configuracionusuario = new ConfiguracionUsuario();

        try (Connection conn = Conexion.obtenerConexion()) {
            String consultaSQL = "SELECT * FROM Configuracion WHERE ID_Empleado = ?";
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setInt(1, ID);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Recuperar los valores de la fila y asignarlos al objeto ConfiguracionUsuario
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
        } catch (SQLException e) {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
        }

        return configuracionusuario;
    }

    
    public Color ObtenerColor1(int Tema)
    {
        Color Color1 = null;
        
        //Color del texto
        switch (Tema)
        {
            case 0: Color1 = Color.decode("#020304"); break; //Tema 0
            case 1: Color1 = Color.decode("#FBFBFC"); break; //Tema 1
            case 2: Color1 = Color.decode("#FBFBFC"); break; //Tema 2
        }
        return Color1;
    }
    
    
    //Color del fondo
    public Color ObtenerColor2(int Tema)
    {
        Color Color2 = null;
        
        switch (Tema)
        {
            case 0: Color2 = Color.decode("#FBFBFC"); break; //Tema 0
            case 1: Color2 = Color.decode("#1B1C1B"); break; //Tema 1
            //case 2: Color2 = Color.decode("#070D15"); break; //Tema 2
            case 2: Color2 = Color.decode("#000318"); break; //Tema 2
        }
        return Color2;
    }
    
    
    //Color de los componentes
    public Color ObtenerColor3(int Tema)
    {
        Color Color3 = null;
        
        switch (Tema)
        {
            case 0: Color3 = Color.decode("#39B6E6"); break; //Tema 0
            case 1: Color3 = Color.decode("#295096"); break; //Tema 1
            case 2: Color3 = Color.decode("#0466C8"); break; //Tema 2
        }
        return Color3;
    }
    
    
    //Color de Advertencias
    public Color ObtenerColor4(int Tema)
    {
        Color Color4 = null;
        
        switch (Tema)
        {
            case 0: Color4 = Color.decode("#ff6961"); break; //Tema 0
            case 1: Color4 = Color.decode("#D6191C"); break; //Tema 1
            case 2: Color4 = Color.decode("#65121E"); break; //Tema 2
        }
        return Color4;
    }

    
    /////////////////////////////////////////////////////////////////////////////
    //Edita el ComoboBox acorde al tema
    public static class Propiedades extends BasicComboBoxUI 
    {
        private Color arrowButtonColor;
        private Color selectedBackgroundColor;

        public Propiedades(Color arrowButtonColor, Color selectedBackgroundColor) 
        {
            this.arrowButtonColor = arrowButtonColor;
            this.selectedBackgroundColor = selectedBackgroundColor;
        }

        public static ComboBoxUI createUI(JComponent com) 
        {
            return new Propiedades(Color.BLUE, Color.decode("#070D15"));
        }
        
        @Override
        protected JButton createArrowButton() 
        {
            JButton btn = new JButton();
            btn.setIcon(new ImageIcon(getClass().getResource("/Resources/Images/Icono_ComboBox.png")));
            btn.setBackground(arrowButtonColor);
            return btn;
        }
        
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) 
        {
            g.setColor(selectedBackgroundColor);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        @Override
        protected ListCellRenderer createRenderer() 
        {
            return new DefaultListCellRenderer()
            {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                    list.setSelectionBackground(arrowButtonColor);

                    if(index!=-1){
                        //setIcon(new ImageIcon(getClass().getResource("/img/flecha.png")));
                    }
                    return this;
                }
            };
        }
    }
}