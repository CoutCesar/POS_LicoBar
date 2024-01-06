package Windows.Frames;

import Controllers.Control_Configuracion;
import Controllers.Control_Sonido;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import Models.Tema;
import Windows.Dialogs.MenuAdministracion.Dialog_Administracion_Ganancias;
import Windows.Dialogs.MenuAdministracion.Dialog_Administracion_RendimientoProductos;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_CambiarContrasena;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_Preferencias;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_Usuario;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_AbastecerProducto;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_ConsultarProducto;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_EliminarProducto;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_ModificarProducto;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_RegistrarProducto;
import Windows.Dialogs.MenuRecursosHumanos.Dialog_Recursos_ConsultarEmpleado;
import Windows.Dialogs.MenuRecursosHumanos.Dialog_Recursos_EliminarEmpleado;
import Windows.Dialogs.MenuRecursosHumanos.Dialog_Recursos_ModificarEmpleado;
import Windows.Dialogs.MenuRecursosHumanos.Dialog_Recursos_RegistrarEmpleado;
import Windows.Panels.MenuInventario.Panel_Inventario_AbastecerProductos;
import Windows.Panels.Panel_Personalizable_Derecho;
import Windows.Panels.Panel_Personalizable_Izquierda;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;


/**
 *
 * @author César Eduardo
 */
public class Frame_MenuInicio extends javax.swing.JFrame implements ActionListener 
{
    private ConfiguracionUsuario configuracionusuario;
    private Empleado empleado;
    
    public Frame_MenuInicio(Empleado usuario, ConfiguracionUsuario configuracion) 
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        
        //configuracionusuario = configuracion;
        this.configuracionusuario = configuracion;
        this.empleado = usuario;

        Control_Sonido controlsonido = new Control_Sonido();
        controlsonido.reproducirSonidoInicio();
        
        CrearMenu(configuracionusuario);
        CrearSplitPanel(configuracionusuario);
    }
    
    
    public void CrearMenu(ConfiguracionUsuario configuracionusuario) 
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color4 = Color.decode(tema.getColor4());
        Color color5 = Color.decode(tema.getColor5());
        
        JMenuBar menuBar = new JMenuBar();        

        //Se crean las opciones del menu
        JMenu Inventario = new JMenu("  Inventario  ");
        JMenu RecursosHumanos = new JMenu("  Recursos Humanos  ");
        JMenu Administracion = new JMenu("  Administración  ");
        JMenu Configuracion = new JMenu("Configuración");

        //Se crean los items del menu productos
        JMenuItem RegistrarProductos = new JMenuItem("Registrar Productos");
        JMenuItem ConsultarProductos = new JMenuItem("Consultar Productos");
        JMenuItem ModificarProductos = new JMenuItem("Modificar Productos");
        JMenuItem EliminarProductos = new JMenuItem("Eliminar Productos");
        JMenuItem AbastecerInventario = new JMenuItem("Abastecer Inventario");

        // Asignar ActionCommand para cada item del menú productos
        RegistrarProductos.setActionCommand("Registrar Productos");
        ConsultarProductos.setActionCommand("Consultar Productos");
        ModificarProductos.setActionCommand("Modificar Productos");
        EliminarProductos.setActionCommand("Eliminar Productos");
        AbastecerInventario.setActionCommand("Abastecer Inventario");

        // Agregar ActionListener a cada elemento del menú productos
        RegistrarProductos.addActionListener(this);
        ConsultarProductos.addActionListener(this);
        ModificarProductos.addActionListener(this);
        EliminarProductos.addActionListener(this);
        AbastecerInventario.addActionListener(this);

        //Se agregan los Items al menu productos
        Inventario.add(RegistrarProductos);
        Inventario.add(ConsultarProductos);
        Inventario.add(ModificarProductos);
        Inventario.add(EliminarProductos);
        Inventario.add(AbastecerInventario);

        //Se crean los items del menu Recursos humanos
        JMenuItem RegistarEmpleado = new JMenuItem("Registrar Empleado");
        JMenuItem ConsultarEmpleado = new JMenuItem("Consultar Empleado");
        JMenuItem ModificarEmpleado = new JMenuItem("Modificar Empleado");
        JMenuItem EliminarEmpleado = new JMenuItem("Eliminar Empleado");

        // Asignar ActionCommand para cada item del menú recursos humanos
        RegistarEmpleado.setActionCommand("Registrar Empleado");
        ConsultarEmpleado.setActionCommand("Consultar Empleado");
        ModificarEmpleado.setActionCommand("Modificar Empleado");
        EliminarEmpleado.setActionCommand("Eliminar Empleado");

        //Se crean los eventos de los items de recursos humanos
        RegistarEmpleado.addActionListener(this);
        ConsultarEmpleado.addActionListener(this);
        ModificarEmpleado.addActionListener(this);
        EliminarEmpleado.addActionListener(this);

        //Se agregan los items al menu recursos humanos
        RecursosHumanos.add(RegistarEmpleado);
        RecursosHumanos.add(ConsultarEmpleado);
        RecursosHumanos.add(ModificarEmpleado);
        RecursosHumanos.add(EliminarEmpleado);
        
        //Se crean los items de administracion
        JMenuItem Ganancias = new JMenuItem("Ganancias");
        JMenuItem Ventas = new JMenuItem("Ventas");
        JMenuItem RendimientoProductos = new JMenuItem("Rendimiento de Productos");

        // Asignar ActionCommand para cada item del menú administracion
        Ganancias.setActionCommand("Ganancias");
        Ventas.setActionCommand("Ventas");
        RendimientoProductos.setActionCommand("Rendimiento de Productos");

        //Se crean los eventos para los items de administracion
        Ganancias.addActionListener(this);
        Ventas.addActionListener(this);
        RendimientoProductos.addActionListener(this);
        
        //Se agregan los items al menu administracion
        Administracion.add(Ganancias);
        Administracion.add(Ventas);
        Administracion.add(RendimientoProductos);
        
        //Se crean los items para el menu configuracion
        JMenuItem Usuario = new JMenuItem("Usuario");
        JMenuItem Preferencias = new JMenuItem("Preferencias");
        JMenuItem CambiarContrasena = new JMenuItem("Cambiar Contraseña");
        
        //Se crean los ActionComand del action listener
        Usuario.setActionCommand("Usuario");
        Preferencias.setActionCommand("Preferencias");
        CambiarContrasena.setActionCommand("Cambiar Contraseña");
        
        //Se crean los eventos para configuracion
        Usuario.addActionListener(this);
        Preferencias.addActionListener(this);
        CambiarContrasena.addActionListener(this);
        
        //Se agregan los items a configuracion
        Configuracion.add(Usuario);
        Configuracion.add(Preferencias);
        Configuracion.add(CambiarContrasena);
        
        //Se agregan los menus al menubar
        menuBar.add(Inventario);
        menuBar.add(RecursosHumanos);
        menuBar.add(Administracion);
        menuBar.add(Configuracion);

        //Se agrega el menu al frame
        setJMenuBar(menuBar);
    }
    
    public void CrearSplitPanel(ConfiguracionUsuario configuracionusuario) 
    {
        //Se crean las instancias a los paneles
        //Panel_Personalizable_Izquierda PanelIzquierdo = new Panel_Personalizable_Izquierda(configuracionusuario);
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color color4 = Color.decode(tema.getColor4());
        
        
        Panel_Inventario_AbastecerProductos PanelIzquierdo = new Panel_Inventario_AbastecerProductos(configuracionusuario);
        Panel_Personalizable_Derecho PanelDerecho = new Panel_Personalizable_Derecho(configuracionusuario, empleado);
        
        //Se crea el SplitPanel
        JSplitPane PanelDoble = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, PanelIzquierdo, PanelDerecho);
        
        //Ajustes del SplitPanel
        PanelDoble.setResizeWeight(0.85);        
        PanelDoble.setDividerSize(7); 
        
        PanelDoble.setBackground(color4);
        
        //Se agrega el SplitPanel al frame
        getContentPane().add(PanelDoble);
    }
    
    
    public void ReiniciarInterfaz(Empleado usuario, ConfiguracionUsuario configuracion)
    {
        dispose();
        Frame_MenuInicio frame = new Frame_MenuInicio(usuario, configuracion);
        frame.setVisible(true);
    }
    
    
    @Override //Evento al hacer click en un item del menu
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();

        if (comando.equals("Registrar Productos")) 
        {
            // Tu código para la acción "Registrar Productos" aquí
            System.out.println("Ejecutando la acción 'Registrar Productos'");
            Dialog_Inventario_RegistrarProducto dialog = new Dialog_Inventario_RegistrarProducto(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Consultar Productos")) 
        {
            // Tu código para la acción "Consultar Productos" aquí
            System.out.println("Ejecutando la acción 'Consultar Productos'");
            Dialog_Inventario_ConsultarProducto dialog = new Dialog_Inventario_ConsultarProducto(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Modificar Productos")) 
        {
            // Tu código para la acción "Modificar Productos" aquí
            System.out.println("Ejecutando la acción 'Modificar Productos'");
            Dialog_Inventario_ModificarProducto dialog = new Dialog_Inventario_ModificarProducto(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Eliminar Productos")) 
        {
            // Tu código para la acción "Eliminar Productos" aquí
            System.out.println("Ejecutando la acción 'Eliminar Productos'");
            Dialog_Inventario_EliminarProducto dialog = new Dialog_Inventario_EliminarProducto(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Abastecer Inventario")) 
        {
            // Tu código para la acción "Eliminar Productos" aquí
            System.out.println("Ejecutando la acción 'Abastecer Productos'");
            Dialog_Inventario_AbastecerProducto dialog = new Dialog_Inventario_AbastecerProducto(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }
        
        
        else if (comando.equals("Registrar Empleado")) 
        {
            // Tu código para la acción "Registrar Empleado" aquí
            System.out.println("Ejecutando la acción 'Registrar Empleado'");
            Dialog_Recursos_RegistrarEmpleado dialog = new Dialog_Recursos_RegistrarEmpleado(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Consultar Empleado")) 
        {
            // Tu código para la acción "Consultar Empleado" aquí
            System.out.println("Ejecutando la acción 'Consultar Empleado'");
            Dialog_Recursos_ConsultarEmpleado dialog = new Dialog_Recursos_ConsultarEmpleado(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Modificar Empleado")) 
        {
            // Tu código para la acción "Modificar Empleado" aquí
            System.out.println("Ejecutando la acción 'Modificar Empleado'");
            Dialog_Recursos_ModificarEmpleado dialog = new Dialog_Recursos_ModificarEmpleado(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Eliminar Empleado")) 
        {
            // Tu código para la acción "Eliminar Empleado" aquí
            System.out.println("Ejecutando la acción 'Eliminar Empleado'");
            Dialog_Recursos_EliminarEmpleado dialog = new Dialog_Recursos_EliminarEmpleado(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Ganancias")) 
        {
            // Tu código para la acción "Ganancias" aquí
            System.out.println("Ejecutando la acción 'Ganancias'");
            Dialog_Administracion_Ganancias dialog = new Dialog_Administracion_Ganancias(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Ventas")) 
        {
            // Tu código para la acción "Ventas" aquí
            System.out.println("Ejecutando la acción 'Ventas'");
        } 
        
        else if (comando.equals("Rendimiento de Productos")) 
        {
            // Tu código para la acción "Mejores Productos" aquí
            System.out.println("Ejecutando la acción 'Rendimiento de Productos'");
            Dialog_Administracion_RendimientoProductos dialog = new Dialog_Administracion_RendimientoProductos(configuracionusuario);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } 
        
        else if (comando.equals("Usuario")) 
        {
            // Tu código para la acción "Peores Productos" aquí
            System.out.println("Ejecutando la acción 'Usuario'");
            Dialog_Configuracion_Usuario dialog = new Dialog_Configuracion_Usuario(configuracionusuario, empleado);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }
        
        else if (comando.equals("Preferencias")) 
        {
            // Tu código para la acción "Peores Productos" aquí
            System.out.println("Ejecutando la acción 'Preferencias'");
            Dialog_Configuracion_Preferencias dialog = new Dialog_Configuracion_Preferencias(configuracionusuario, empleado, this);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }
        
         else if (comando.equals("Cambiar Contraseña")) 
        {
            // Tu código para la acción "Peores Productos" aquí
            System.out.println("Ejecutando la acción 'Cambiar Contraseña'");
            Dialog_Configuracion_CambiarContrasena dialog = new Dialog_Configuracion_CambiarContrasena(configuracionusuario, empleado);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JMenuBar MenuColorExample() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


