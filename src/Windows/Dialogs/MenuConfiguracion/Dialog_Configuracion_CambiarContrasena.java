package Windows.Dialogs.MenuConfiguracion;

import Models.ConfiguracionUsuario;
import Models.Empleado;
import Windows.Panels.MenuConfiguracion.Panel_Configuracion_CambiarContrasena;
import javax.swing.*;

public class Dialog_Configuracion_CambiarContrasena extends JDialog 
{

    public Dialog_Configuracion_CambiarContrasena(ConfiguracionUsuario configuracionusuario, Empleado usuario) 
    {
        setTitle("Cambiar Contraseña");
        Panel_Configuracion_CambiarContrasena panel = new Panel_Configuracion_CambiarContrasena(configuracionusuario, usuario);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
    
    public void Cerrar()
    {
        dispose();
    }
}
