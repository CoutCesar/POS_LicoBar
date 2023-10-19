package Windows.Dialogs.MenuInventario;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuInventario.Panel_Inventario_ConsultarProducto;
import javax.swing.*;

public class Dialog_Inventario_ConsultarProducto extends JDialog 
{

    public Dialog_Inventario_ConsultarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Buscar Producto");
        Panel_Inventario_ConsultarProducto panel = new Panel_Inventario_ConsultarProducto(configuracionusuario);
        getContentPane().add(panel);
        pack();
    }
}