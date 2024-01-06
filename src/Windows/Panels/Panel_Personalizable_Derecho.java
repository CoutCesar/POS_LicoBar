package Windows.Panels;

import Controllers.Control_Configuracion;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import Models.Tema;
import Windows.Panels.MenuAdministracion.Panel_Administracion_Ganancias;
import Windows.Panels.MenuAdministracion.Panel_Administracion_RendimientoProductos;
import Windows.Panels.MenuConfiguracion.Panel_Configuracion_Usuario;
import Windows.Panels.MenuInventario.Panel_Inventario_ConsultarProducto;
import Windows.Panels.MenuInventario.Panel_Inventario_EliminarProducto;
import Windows.Panels.MenuInventario.Panel_Inventario_ModificarProducto;
import Windows.Panels.MenuInventario.Panel_Inventario_RegistrarProducto;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_ConsultarEmpleado;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_EliminarEmpleado;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_ModificarEmpleado;
import Windows.Panels.MenuRecursosHumanos.Panel_Inventario_RegistrarEmpleado;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author César Eduardo
 */
public class Panel_Personalizable_Derecho extends javax.swing.JPanel 
{

    Empleado usuario;
    
    public Panel_Personalizable_Derecho(ConfiguracionUsuario configuracionusuario, Empleado empleado) 
    {
        initComponents();
        usuario = empleado;
        
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color4 = Color.decode(tema.getColor4());
        Color color5 = Color.decode(tema.getColor5());
        
        JPanel ComponenteA = ComponenteUno(configuracionusuario);
        JPanel ComponenteB = ComponenteDos(configuracionusuario);
        
        ComponenteA.setBackground(color2);
        ComponenteB.setBackground(color2);
        
        Panel_Doble.setBackground(color4);
        this.setBackground(color4);
        
        //JSplitPane PanelDoble = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ComponenteA, ComponenteB);
        Panel_Doble.setResizeWeight(0.5);
        Panel_Doble.setDividerSize(8);
        
        Panel_Doble.setLeftComponent(ComponenteA);
        Panel_Doble.setRightComponent(ComponenteB);
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
            case 9: componente = new Panel_Administracion_Ganancias(configuracionusuario); break;
            case 10: componente = new Panel_Administracion_RendimientoProductos(configuracionusuario); break;
            case 11: componente = new Panel_Configuracion_Usuario(configuracionusuario, usuario); break;
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
            case 9: componente = new Panel_Administracion_Ganancias(configuracionusuario); break;
            case 10: componente = new Panel_Administracion_RendimientoProductos(configuracionusuario); break;
            case 11: componente = new Panel_Configuracion_Usuario(configuracionusuario, usuario); break;
        }

        return componente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Doble = new javax.swing.JSplitPane();

        setBackground(new java.awt.Color(255, 255, 51));

        Panel_Doble.setBackground(new java.awt.Color(51, 51, 51));
        Panel_Doble.setForeground(new java.awt.Color(255, 51, 51));
        Panel_Doble.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel_Doble, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Doble, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane Panel_Doble;
    // End of variables declaration//GEN-END:variables
}
