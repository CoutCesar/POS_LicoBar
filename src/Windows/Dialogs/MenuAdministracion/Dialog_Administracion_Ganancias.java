package Windows.Dialogs.MenuAdministracion;

import Models.ConfiguracionUsuario;
import Windows.Panels.MenuAdministracion.Panel_Administracion_Ganancias;
import javax.swing.JDialog;

/**
 *
 * @author César
 */
public class Dialog_Administracion_Ganancias extends JDialog 
{
    public Dialog_Administracion_Ganancias(ConfiguracionUsuario configuracionusuario) 
    {
        setTitle("Buscar Producto");
        Panel_Administracion_Ganancias panel = new Panel_Administracion_Ganancias(configuracionusuario);
        getContentPane().add(panel);
        pack();
    }
}
