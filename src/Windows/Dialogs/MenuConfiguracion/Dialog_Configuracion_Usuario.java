package Windows.Dialogs.MenuConfiguracion;

import Models.ConfiguracionUsuario;
import Models.Empleado;
import Windows.Panels.MenuConfiguracion.Panel_Configuracion_Usuario;
import javax.swing.*;

public class Dialog_Configuracion_Usuario extends JDialog 
{

    public Dialog_Configuracion_Usuario(ConfiguracionUsuario configuracionusuario, Empleado usuario) 
    {
        setTitle("Informacion ");
        Panel_Configuracion_Usuario panel = new Panel_Configuracion_Usuario(configuracionusuario, usuario, this);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
    
    public void Cerrar()
    {
        dispose();
    }
}
