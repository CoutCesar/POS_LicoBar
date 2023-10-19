package Windows.Dialogs.MenuInventario;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuInventario.Panel_Inventario_ModificarProducto;
import javax.swing.*;

public class Dialog_Inventario_ModificarProducto extends JDialog 
{

    public Dialog_Inventario_ModificarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Modificar Producto");
        Panel_Inventario_ModificarProducto panel = new Panel_Inventario_ModificarProducto(configuracionusuario, this);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
    
    public void Cerrar()
    {
        dispose();
    }
}
