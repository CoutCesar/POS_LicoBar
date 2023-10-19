package Windows.Dialogs.MenuInventario;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuInventario.Panel_Inventario_RegistrarProducto;
import javax.swing.*;

public class Dialog_Inventario_RegistrarProducto extends JDialog 
{

    public Dialog_Inventario_RegistrarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Registrar Producto");
        Panel_Inventario_RegistrarProducto panel = new Panel_Inventario_RegistrarProducto(configuracionusuario, this);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
    
    public void Cerrar()
    {
        dispose();
    }
}

