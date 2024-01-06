package Windows.Panels.MenuConfiguracion;

import Controllers.Control_Configuracion;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_Preferencias;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author César Eduardo
 */
public class Panel_Configuracion_Preferencias extends javax.swing.JPanel 
{
    
    private Empleado empleado;
    private Dialog_Configuracion_Preferencias dialog;

    public Panel_Configuracion_Preferencias(ConfiguracionUsuario configuracionusuario, Empleado usuario, Dialog_Configuracion_Preferencias dialog) 
    {
        initComponents();
        btn_Aplicar.requestFocusInWindow();
        
        empleado = usuario;
        this.dialog = dialog;
        
        ConfiguracionElegida(configuracionusuario);
        AplicarTema(configuracionusuario, empleado);
    }
    
    
    public int ObtenerComponente(String Eleccion)
    {
        int Componente = 0;
        switch (Eleccion)
        {
            case "Registrar Producto": Componente = 1; break;
            case "Consultar Producto": Componente = 2; break;
            case "Modificar Producto": Componente = 3; break;
            case "Eliminar Producto": Componente = 4; break;
            
            case "Registrar Empleado": Componente = 5; break;
            case "Consultar Empleado": Componente = 6; break;
            case "Modificar Empleado": Componente = 7; break;
            case "Eliminar Empleado": Componente = 8; break;
        }
        
        return Componente;
    }
    
    
    public void AplicarTema(ConfiguracionUsuario configuracionusuario, Empleado empleado)
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        int Tema = configuracionusuario.getTema();
        
        Color Color1 = controlconfiguracion.ObtenerColor1(Tema);
        Color Color2 = controlconfiguracion.ObtenerColor2(Tema);
        Color Color3 = controlconfiguracion.ObtenerColor3(Tema);
        Color Color4 = controlconfiguracion.ObtenerColor4(Tema);
        
        Color arrowColor = Color3;
        Color selectedColor = Color2;
        
        this.setBackground(Color2);
        panel_Interfaz.setBackground(Color2);
        
        btn_Aplicar.setBackground(Color3);
        btn_Aplicar.setForeground(Color1);
        
        btn_Restablecer.setBackground(Color4);
        btn_Restablecer.setForeground(Color1);
        
        lbl_Componentes.setForeground(Color1);
        lbl_Dos.setForeground(Color1);
        lbl_Intefaz.setForeground(Color1);
        lbl_Tema.setForeground(Color1);
        lbl_Tipos.setForeground(Color1);
        lbl_Uno.setForeground(Color1);
        
        Border border = BorderFactory.createLineBorder(Color.white, 1); // 2 es el grosor del borde
        
        Control_Configuracion.Propiedades customUI = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        cmb_Tipo.setUI(customUI);
        cmb_Tipo.setForeground(Color1);
        
        Control_Configuracion.Propiedades customUI2 = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        cmb_Tema.setUI(customUI2);
        cmb_Tema.setForeground(Color1);
        
        Control_Configuracion.Propiedades customUI3 = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        cmb_Uno.setUI(customUI3);
        cmb_Uno.setForeground(Color1);
        
        Control_Configuracion.Propiedades customUI4 = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        cmb_Dos.setUI(customUI4);
        cmb_Dos.setForeground(Color1);
    }
    
    
    public void ConfiguracionElegida(ConfiguracionUsuario configuracionusuario)
    {
        int Tema = configuracionusuario.getTema();
        int Cmp1 = configuracionusuario.getComponente1() - 1;
        int Cmp2 = configuracionusuario.getComponente2() - 1;
        
        cmb_Tema.setSelectedIndex(Tema);
        cmb_Uno.setSelectedIndex(Cmp1);
        cmb_Dos.setSelectedIndex(Cmp2);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Interfaz = new javax.swing.JPanel();
        lbl_Intefaz = new javax.swing.JLabel();
        btn_Aplicar = new javax.swing.JButton();
        lbl_Tema = new javax.swing.JLabel();
        cmb_Tema = new javax.swing.JComboBox<>();
        lbl_Tipos = new javax.swing.JLabel();
        cmb_Tipo = new javax.swing.JComboBox<>();
        lbl_Componentes = new javax.swing.JLabel();
        lbl_Uno = new javax.swing.JLabel();
        cmb_Uno = new javax.swing.JComboBox<>();
        lbl_Dos = new javax.swing.JLabel();
        cmb_Dos = new javax.swing.JComboBox<>();
        btn_Restablecer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(320, 357));
        setPreferredSize(new java.awt.Dimension(320, 357));
        setLayout(new java.awt.GridBagLayout());

        panel_Interfaz.setBackground(new java.awt.Color(255, 255, 255));
        panel_Interfaz.setFocusCycleRoot(true);
        panel_Interfaz.setFocusTraversalPolicyProvider(true);
        panel_Interfaz.setNextFocusableComponent(panel_Interfaz);

        lbl_Intefaz.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Intefaz.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Intefaz.setText("Interfaz");

        btn_Aplicar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Aplicar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Aplicar.setText("Aplicar cambios");
        btn_Aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AplicarActionPerformed(evt);
            }
        });

        lbl_Tema.setText("Tema");

        cmb_Tema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Claro", "Obscuro", "Moderno Obscuro" }));
        cmb_Tema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_TemaItemStateChanged(evt);
            }
        });

        lbl_Tipos.setText("Tipo de interfaz");

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl_Componentes.setText("Componentes de la interfaz");

        lbl_Uno.setText("1");

        cmb_Uno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrar Producto", "Consultar Producto", "Modificar Producto", "Eliminar Producto", "Registrar Empleado", "Consultar Empleado", "Modificar Empleado", "Eliminar Empleado" }));

        lbl_Dos.setText("2");

        cmb_Dos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrar Producto", "Consultar Producto", "Modificar Producto", "Eliminar Producto", "Registrar Empleado", "Consultar Empleado", "Modificar Empleado", "Eliminar Empleado" }));

        btn_Restablecer.setBackground(new java.awt.Color(255, 51, 51));
        btn_Restablecer.setForeground(new java.awt.Color(255, 255, 255));
        btn_Restablecer.setText("Restablecer interfaz");

        javax.swing.GroupLayout panel_InterfazLayout = new javax.swing.GroupLayout(panel_Interfaz);
        panel_Interfaz.setLayout(panel_InterfazLayout);
        panel_InterfazLayout.setHorizontalGroup(
            panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmb_Tema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Intefaz, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Tema, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Tipos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Componentes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_InterfazLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_InterfazLayout.createSequentialGroup()
                                .addComponent(lbl_Dos)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Dos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_InterfazLayout.createSequentialGroup()
                                .addComponent(lbl_Uno)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Uno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Aplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Restablecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panel_InterfazLayout.setVerticalGroup(
            panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Intefaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Tema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Tema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_Tipos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_Componentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Uno)
                    .addComponent(cmb_Uno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Dos)
                    .addComponent(cmb_Dos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_Aplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btn_Restablecer))
        );

        add(panel_Interfaz, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AplicarActionPerformed
        //Obtiene los datos de las configuraciones elegidas
        int Tema = cmb_Tema.getSelectedIndex();
        String Eleccion1 = cmb_Uno.getSelectedItem().toString();
        String Eleccion2 = cmb_Dos.getSelectedItem().toString();
        int ID_Empleado = empleado.getID_Empleado();
        
        //Crea el objeto de la configuracion
        ConfiguracionUsuario configuracionusuario = new ConfiguracionUsuario();
        
        //Se agregan los datos de la configuracion al onjeto
        configuracionusuario.setComponente1(ObtenerComponente(Eleccion1));
        configuracionusuario.setComponente2(ObtenerComponente(Eleccion2));
        configuracionusuario.setTema(Tema);
        configuracionusuario.setIDUsuario(ID_Empleado);
        
        System.out.println("Va bien");
        
        //Se crea el objeto controlconfiguracion y se ejecuta el metodo para insertar la configuracion a la BD
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        controlconfiguracion.NuevaConfiguracion(configuracionusuario);
        
        //Aqui quiero que se llame al metodo para cerrar el dialog
        dialog.ReiniciarIntefaz(empleado, configuracionusuario);
    }//GEN-LAST:event_btn_AplicarActionPerformed

    private void cmb_TemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TemaItemStateChanged
        String Eleccion = cmb_Tema.getSelectedItem().toString();
        int Numero = cmb_Tema.getSelectedIndex();
        
        System.out.println("El tema " + Eleccion + "Es el numero " + Numero);
    }//GEN-LAST:event_cmb_TemaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aplicar;
    private javax.swing.JButton btn_Restablecer;
    private javax.swing.JComboBox<String> cmb_Dos;
    private javax.swing.JComboBox<String> cmb_Tema;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JComboBox<String> cmb_Uno;
    private javax.swing.JLabel lbl_Componentes;
    private javax.swing.JLabel lbl_Dos;
    private javax.swing.JLabel lbl_Intefaz;
    private javax.swing.JLabel lbl_Tema;
    private javax.swing.JLabel lbl_Tipos;
    private javax.swing.JLabel lbl_Uno;
    private javax.swing.JPanel panel_Interfaz;
    // End of variables declaration//GEN-END:variables
}
