package Windows.Panels.MenuRecursosHumanos;

import Controllers.Control_Configuracion;
import Controllers.Control_Empleado;
import Controllers.Control_Sonido;
import Controllers.Control_Validacion;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import Models.Tema;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author César Eduardo
 */
public class Panel_Inventario_RegistrarEmpleado extends javax.swing.JPanel {

    public Panel_Inventario_RegistrarEmpleado(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        AplicarTema(configuracionusuario);
    }
    
////////////////////////////////////////////////////////////////////////////////
//Aplica la configuracion del tema al panel    
    public void AplicarTema(ConfiguracionUsuario configuracionusuario)
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color Color1 = Color.decode(tema.getColor1());
        Color Color2 = Color.decode(tema.getColor2());
        Color Color3 = Color.decode(tema.getColor3());
        Color Color4 = Color.decode(tema.getColor4());
        Color Color5 = Color.decode(tema.getColor5());
        
        Color arrowColor = Color3;
        Color selectedColor = Color2;
        
        this.setBackground(Color2);
        jPanel1.setBackground(Color2);
        
        btn_Registrar.setBackground(Color3);
        btn_Registrar.setForeground(Color1);
        
        btn_Cancelar.setBackground(Color2);
        btn_Cancelar.setForeground(Color1);
        
        lbl_Id.setForeground(Color1);
        lbl_Nombre.setForeground(Color1);
        lbl_Puesto.setForeground(Color1);
        lbl_Titulo.setForeground(Color1);
        
        txt_Id.setCaretColor(Color1);
        txt_Nombre.setCaretColor(Color1);
        
        txt_Id.setBackground(Color2);
        txt_Id.setForeground(Color1);
        
        txt_Nombre.setBackground(Color2);
        txt_Nombre.setForeground(Color1);
        
        Border border = BorderFactory.createLineBorder(Color.white, 1); // 2 es el grosor del borde
        //Control_Configuracion.Propiedades customUI = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        ComboBoxUI customUI = controlconfiguracion.createCustomComboBoxUI(Color3, Color2);
        cmb_Puesto.setUI(customUI);
        cmb_Puesto.setForeground(Color1);
        
        lbl_ErrorID.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_Id = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        lbl_Puesto = new javax.swing.JLabel();
        btn_Registrar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        cmb_Puesto = new javax.swing.JComboBox<>();
        lbl_ErrorID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_Titulo1 = new javax.swing.JLabel();
        lbl_Nombre1 = new javax.swing.JLabel();
        txt_Nombre1 = new javax.swing.JTextField();
        lbl_Id1 = new javax.swing.JLabel();
        txt_Id1 = new javax.swing.JTextField();
        lbl_Puesto1 = new javax.swing.JLabel();
        btn_Registrar1 = new javax.swing.JButton();
        btn_Cancelar1 = new javax.swing.JButton();
        cmb_Puesto1 = new javax.swing.JComboBox<>();
        lbl_ErrorID1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(460, 390));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(395, 319));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Registrar un empleado");

        lbl_Nombre.setText("Nombre del empleado");

        lbl_Id.setText("ID del empleado");

        lbl_Puesto.setText("Puesto");

        btn_Registrar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Registrar.setText("Registrar");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");

        cmb_Puesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Gerente", "Jefe" }));

        lbl_ErrorID.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorID.setForeground(java.awt.Color.red);
        lbl_ErrorID.setText("Solo ingrese valores numericos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Registrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Titulo)
                            .addComponent(lbl_Nombre)
                            .addComponent(lbl_Id)
                            .addComponent(lbl_Puesto)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(txt_Id))
                                    .addComponent(lbl_ErrorID)
                                    .addComponent(cmb_Puesto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Puesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Registrar)
                    .addComponent(btn_Cancelar))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 240;
        gridBagConstraints.ipady = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(395, 319));

        lbl_Titulo1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo1.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo1.setText("Registrar un empleado");

        lbl_Nombre1.setText("Nombre del empleado");

        lbl_Id1.setText("ID del empleado");

        txt_Id1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Id1KeyReleased(evt);
            }
        });

        lbl_Puesto1.setText("Puesto");

        btn_Registrar1.setBackground(new java.awt.Color(0, 3, 24));
        btn_Registrar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Registrar1.setText("Registrar");

        btn_Cancelar1.setText("Cancelar");

        cmb_Puesto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Gerente", "Jefe" }));

        lbl_ErrorID1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorID1.setForeground(java.awt.Color.red);
        lbl_ErrorID1.setText("Solo ingrese valores numericos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Registrar1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Titulo1)
                            .addComponent(lbl_Nombre1)
                            .addComponent(lbl_Id1)
                            .addComponent(lbl_Puesto1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_Nombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(txt_Id1))
                                    .addComponent(lbl_ErrorID1)
                                    .addComponent(cmb_Puesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Nombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Id1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorID1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Puesto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Puesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Registrar1)
                    .addComponent(btn_Cancelar1))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.ipady = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -469;
        gridBagConstraints.ipady = -374;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(190, 6, 0, 0);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
////////////////////////////////////////////////////////////////////////////////    
//Detecta errores en tiempo real al presionar una tecla en jtextfiel txt_ID
    private void txt_Id1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Id1KeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Id.getText();

        boolean Error = controlvalidacion.validarEntradaFloat(Texto);
        if (Error == true)
        {
            LineBorder BordeError = new LineBorder(Color.RED);
            txt_Id.setBorder(BordeError);
            lbl_ErrorID.setVisible(true);
        }

        else
        {
            txt_Id.setBorder(UIManager.getBorder("TextField.border"));
            lbl_ErrorID.setVisible(false);
        }
    }//GEN-LAST:event_txt_Id1KeyReleased

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        try 
        {
            String Nombre = txt_Nombre.getText();
            String Contraseña = "Temporal";
            int ID = Integer.parseInt(txt_Id.getText());
            int Puesto = cmb_Puesto.getSelectedIndex();
            
            System.out.println(ID);

            Empleado empleado = new Empleado();
            empleado.setID_Empleado(ID);
            empleado.setNombre_Empleado(Nombre);
            empleado.setPuesto(Puesto);
            empleado.setContrasena(Contraseña);

            Control_Empleado controlempleado = new Control_Empleado();
            controlempleado.registrarEmpleado(empleado);
            
            txt_Nombre.setText("");
            txt_Id.setText("");
        } 
        
        catch (NumberFormatException e) 
        {
            // Manejo de excepción si ocurre un error al convertir el ID a entero
            Control_Sonido controlsonido = new Control_Sonido();
            controlsonido.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Error, siga las instrucciones", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Cancelar1;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JButton btn_Registrar1;
    private javax.swing.JComboBox<String> cmb_Puesto;
    private javax.swing.JComboBox<String> cmb_Puesto1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_ErrorID;
    private javax.swing.JLabel lbl_ErrorID1;
    private javax.swing.JLabel lbl_Id;
    private javax.swing.JLabel lbl_Id1;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Nombre1;
    private javax.swing.JLabel lbl_Puesto;
    private javax.swing.JLabel lbl_Puesto1;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Titulo1;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Id1;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Nombre1;
    // End of variables declaration//GEN-END:variables
}
