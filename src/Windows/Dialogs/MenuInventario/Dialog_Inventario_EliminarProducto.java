package Windows.Dialogs.MenuInventario;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuInventario.Panel_Inventario_EliminarProducto;
import javax.swing.*;

public class Dialog_Inventario_EliminarProducto extends JDialog 
{

    public Dialog_Inventario_EliminarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Eliminar Producto");
        Panel_Inventario_EliminarProducto panel = new Panel_Inventario_EliminarProducto(configuracionusuario);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
}