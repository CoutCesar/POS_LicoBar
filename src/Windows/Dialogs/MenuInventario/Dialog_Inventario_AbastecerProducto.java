package Windows.Dialogs.MenuInventario;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuInventario.Panel_Inventario_AbastecerProductos;
import javax.swing.*;

public class Dialog_Inventario_AbastecerProducto extends JDialog 
{

    public Dialog_Inventario_AbastecerProducto(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Abastecer Productos");
        Panel_Inventario_AbastecerProductos panel = new Panel_Inventario_AbastecerProductos(configuracionusuario);
        getContentPane().add(panel);
        //setLocationRelativeTo(null);
        pack();
    }
    
    public void Cerrar()
    {
        dispose();
    }
}
