package Windows.Dialogs.MenuRecursosHumanos;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_ConsultarEmpleado;
import javax.swing.*;

public class Dialog_Recursos_ConsultarEmpleado extends JDialog 
{

    public Dialog_Recursos_ConsultarEmpleado(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Consultar Empleado");
        Panel_Inventario_ConsultarEmpleado panel = new Panel_Inventario_ConsultarEmpleado(configuracionusuario);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
}
