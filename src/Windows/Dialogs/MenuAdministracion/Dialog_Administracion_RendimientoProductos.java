package Windows.Dialogs.MenuAdministracion;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuAdministracion.Panel_Administracion_Ganancias;
import Windows.Panels.MenuAdministracion.Panel_Administracion_RendimientoProductos;
import javax.swing.JDialog;

/**
 *
 * @author César
 */
public class Dialog_Administracion_RendimientoProductos extends JDialog 
{
    public Dialog_Administracion_RendimientoProductos(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Buscar Producto");
        Panel_Administracion_RendimientoProductos panel = new Panel_Administracion_RendimientoProductos(configuracionusuario);
        getContentPane().add(panel);
        pack();
    }
}
