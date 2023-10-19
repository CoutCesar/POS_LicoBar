package Windows.Panels;

import Controllers.Control_Configuracion;
import Models.ConfiguracionUsuario;
import Windows.Panels.MenuInventario.Panel_Inventario_ConsultarProducto;
import Windows.Panels.MenuInventario.Panel_Inventario_EliminarProducto;
import Windows.Panels.MenuInventario.Panel_Inventario_ModificarProducto;
import Windows.Panels.MenuInventario.Panel_Inventario_RegistrarProducto;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_ConsultarEmpleado;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_EliminarEmpleado;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_ModificarEmpleado;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_RegistrarEmpleado;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author César Eduardo
 */
public class Panel_Personalizable_Derecho extends javax.swing.JPanel 
{

    public Panel_Personalizable_Derecho(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        
        int Tema = configuracionusuario.getTema();
        //int Componente1 = configuracionusuario.getComponente1();
        //int Componente2 = configuracionusuario.getComponente2();
        
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        
        JPanel ComponenteA = ComponenteUno(configuracionusuario);
        ComponenteA.setBackground(controlconfiguracion.ObtenerColor2(Tema));
        
        JPanel ComponenteB = ComponenteDos(configuracionusuario);
        ComponenteB.setBackground(controlconfiguracion.ObtenerColor2(Tema));
        
        JSplitPane PanelDoble = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ComponenteA, ComponenteB);
        PanelDoble.setResizeWeight(0.5);
        PanelDoble.setDividerSize(8);

        this.add(PanelDoble);
    }
    
    
    public JPanel ComponenteUno(ConfiguracionUsuario configuracionusuario) 
    {
        JPanel componente = null;
        int Componente1 = configuracionusuario.getComponente1();

        switch(Componente1) {
            case 1: componente = new Panel_Inventario_RegistrarProducto(configuracionusuario); break;
            case 2: componente = new Panel_Inventario_ConsultarProducto(configuracionusuario); break;
            case 3: componente = new Panel_Inventario_ModificarProducto(configuracionusuario); break;
            case 4: componente = new Panel_Inventario_EliminarProducto(configuracionusuario); break;
            case 5: componente = new Panel_Inventario_RegistrarEmpleado(configuracionusuario); break;
            case 6: componente = new Panel_Inventario_ConsultarEmpleado(configuracionusuario); break;
            case 7: componente = new Panel_Inventario_ModificarEmpleado(configuracionusuario); break;
            case 8: componente = new Panel_Inventario_EliminarEmpleado(configuracionusuario); break;
        }

        return componente;
    }

    
    public JPanel ComponenteDos(ConfiguracionUsuario configuracionusuario) 
    {
        JPanel componente = null;
        int Componente2 = configuracionusuario.getComponente2();

        switch(Componente2) {
            case 1: componente = new Panel_Inventario_RegistrarProducto(configuracionusuario); break;
            case 2: componente = new Panel_Inventario_ConsultarProducto(configuracionusuario); break;
            case 3: componente = new Panel_Inventario_ModificarProducto(configuracionusuario); break;
            case 4: componente = new Panel_Inventario_EliminarProducto(configuracionusuario); break;
            case 5: componente = new Panel_Inventario_RegistrarEmpleado(configuracionusuario); break;
            case 6: componente = new Panel_Inventario_ConsultarEmpleado(configuracionusuario); break;
            case 7: componente = new Panel_Inventario_ModificarEmpleado(configuracionusuario); break;
            case 8: componente = new Panel_Inventario_EliminarEmpleado(configuracionusuario); break;
        }

        return componente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
