package Windows.Dialogs.MenuRecursosHumanos;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_EliminarEmpleado;
import javax.swing.*;

public class Dialog_Recursos_EliminarEmpleado extends JDialog 
{

    public Dialog_Recursos_EliminarEmpleado(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Eliminar Empleado");
        Panel_Inventario_EliminarEmpleado panel = new Panel_Inventario_EliminarEmpleado(configuracionusuario);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
}