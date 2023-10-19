package Windows.Dialogs.MenuRecursosHumanos;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_ModificarEmpleado;
import javax.swing.*;

public class Dialog_Recursos_ModificarEmpleado extends JDialog 
{

    public Dialog_Recursos_ModificarEmpleado(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Modificar Empleado");
        Panel_Inventario_ModificarEmpleado panel = new Panel_Inventario_ModificarEmpleado(configuracionusuario, this);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
    
    public void Cerrar()
    {
        dispose();
    }
}