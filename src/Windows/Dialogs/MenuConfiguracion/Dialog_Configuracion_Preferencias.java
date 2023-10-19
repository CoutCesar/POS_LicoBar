package Windows.Dialogs.MenuConfiguracion;

import Models.ConfiguracionUsuario;
import Models.Empleado;
import Windows.Frames.Frame_MenuInicio;
import Windows.Panels.MenuConfiguracion.Panel_Configuracion_Preferencias;
import javax.swing.*;

public class Dialog_Configuracion_Preferencias extends JDialog 
{

    private Frame_MenuInicio Frame;
    
    public Dialog_Configuracion_Preferencias(ConfiguracionUsuario configuracionusuario, Empleado empleado, Frame_MenuInicio frame) 
    {
        setTitle("Preferencias");
        Panel_Configuracion_Preferencias panel = new Panel_Configuracion_Preferencias(configuracionusuario, empleado, this);
        getContentPane().add(panel);
        Frame = frame;
        pack();
    }
    
    public void ReiniciarIntefaz(Empleado usuario, ConfiguracionUsuario configuracion)
    {
        dispose();
        Frame.ReiniciarInterfaz(usuario, configuracion);
    }
}