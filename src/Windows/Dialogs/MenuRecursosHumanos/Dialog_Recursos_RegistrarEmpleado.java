package Windows.Dialogs.MenuRecursosHumanos;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_RegistrarEmpleado;
import javax.swing.*;

public class Dialog_Recursos_RegistrarEmpleado extends JDialog 
{

    public Dialog_Recursos_RegistrarEmpleado(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Registrar Empleado");
        Panel_Inventario_RegistrarEmpleado panel = new Panel_Inventario_RegistrarEmpleado(configuracionusuario);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
}