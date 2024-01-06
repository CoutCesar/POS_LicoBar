package Windows.Frames;
import Controllers.Control_Configuracion;
import Controllers.Control_Empleado;
import Controllers.Control_Validacion;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


/**
 *
 * @author César Eduardo
 */
    public class Frame_LogIn extends javax.swing.JFrame 
    {
        FondoPanel fondo = new FondoPanel();
        boolean BotonOjo = false;
        
        public Frame_LogIn() 
        {
            FlatLightLaf.setup();
            initComponents();
            CargarForm();
            ModificarField();
        }
    
    
        public void CargarForm()
        {
            Panel_Fondo.requestFocusInWindow();
            
            lbl_ErrorID.setVisible(false);

            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Panel_Fondo.setLayout(new GridBagLayout());

            Panel_Relleno.setVisible(false);
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = GridBagConstraints.CENTER;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            Panel_Fondo.add(Panel_Relleno, gbc);

            gbc.gridx = GridBagConstraints.CENTER;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            Panel_Fondo.add(lbl_Titulo, gbc);

            gbc.gridx = GridBagConstraints.CENTER;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.SOUTH;
            Panel_Fondo.add(Panel_Inicio, gbc);
        }
        
        
        public void ModificarField()
        {
            txt_Contrasena.setEchoChar('\u0000'); // Mostrar caracteres normales
            txt_Contrasena.setText("Contraseña");
            txt_Contrasena.setForeground(new Color(153, 153, 153));

            // Agregar un FocusListener para eliminar la leyenda al hacer clic
            txt_Contrasena.addFocusListener(new FocusAdapter() 
            {
                @Override
                public void focusGained(FocusEvent e) 
                {
                    if (new String(txt_Contrasena.getPassword()).equals("Contraseña")) 
                    {
                        txt_Contrasena.setText("");
                        txt_Contrasena.setEchoChar('*'); // Mostrar asteriscos
                        txt_Contrasena.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) 
                {
                    if (new String(txt_Contrasena.getPassword()).isEmpty()) 
                    {
                        txt_Contrasena.setText("Contraseña");
                        txt_Contrasena.setEchoChar('\u0000'); // Mostrar caracteres normales
                        txt_Contrasena.setForeground(new Color(153, 153, 153));
                    }
                }
            });
        }
        
        
        public void cambiarVisibilidadContraseña() 
        {
            if (txt_Contrasena.getEchoChar() == '\u0000') 
            {
                // La contraseña se muestra como texto normal
                txt_Contrasena.setEchoChar('*'); // Mostrar asteriscos
            } else 
            {
                // La contraseña se muestra como asteriscos
                txt_Contrasena.setEchoChar('\u0000'); // Mostrar caracteres normales
            }
        }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Fondo = new FondoPanel();
        Panel_Inicio = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_IniciarSesion = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        btn_Iniciar = new javax.swing.JButton();
        txt_Contrasena = new javax.swing.JPasswordField();
        lbl_Ocultar = new javax.swing.JLabel();
        lbl_ErrorID = new javax.swing.JLabel();
        lbl_Titulo = new javax.swing.JLabel();
        Panel_Relleno = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_Fondo.setBackground(new java.awt.Color(0, 0, 51));
        Panel_Fondo.setMinimumSize(new java.awt.Dimension(800, 600));
        Panel_Fondo.setPreferredSize(new java.awt.Dimension(800, 600));
        Panel_Fondo.setLayout(null);

        Panel_Inicio.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Inicio.setMaximumSize(new java.awt.Dimension(250, 350));
        Panel_Inicio.setMinimumSize(new java.awt.Dimension(250, 250));
        Panel_Inicio.setPreferredSize(new java.awt.Dimension(250, 350));
        Panel_Inicio.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_IniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_IniciarSesion.setForeground(new java.awt.Color(0, 3, 24));
        lbl_IniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IniciarSesion.setText("Iniciar sesión");

        txt_Id.setForeground(new java.awt.Color(153, 153, 153));
        txt_Id.setText("ID de Usuario");
        txt_Id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_IdFocusLost(evt);
            }
        });
        txt_Id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_IdMouseClicked(evt);
            }
        });
        txt_Id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_IdKeyReleased(evt);
            }
        });

        btn_Iniciar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Iniciar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Iniciar.setText("Iniciar");
        btn_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarActionPerformed(evt);
            }
        });

        lbl_Ocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/OjoCerrado.png"))); // NOI18N
        lbl_Ocultar.setToolTipText("Mostrar Contraseña");
        lbl_Ocultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_OcultarMouseClicked(evt);
            }
        });

        lbl_ErrorID.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorID.setForeground(java.awt.Color.red);
        lbl_ErrorID.setText("Ingrese un ID numerico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Contrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Ocultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_IniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(txt_Id)
                                .addComponent(btn_Iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbl_ErrorID))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_IniciarSesion)
                .addGap(30, 30, 30)
                .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbl_ErrorID)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Ocultar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_Iniciar)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        Panel_Inicio.add(jPanel1, new java.awt.GridBagConstraints());

        Panel_Fondo.add(Panel_Inicio);
        Panel_Inicio.setBounds(270, 210, 250, 350);

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 82)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo.setText("BarFlow");
        Panel_Fondo.add(lbl_Titulo);
        lbl_Titulo.setBounds(260, 110, 330, 87);

        Panel_Relleno.setMinimumSize(new java.awt.Dimension(300, 100));
        Panel_Relleno.setPreferredSize(new java.awt.Dimension(600, 100));

        javax.swing.GroupLayout Panel_RellenoLayout = new javax.swing.GroupLayout(Panel_Relleno);
        Panel_Relleno.setLayout(Panel_RellenoLayout);
        Panel_RellenoLayout.setHorizontalGroup(
            Panel_RellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        Panel_RellenoLayout.setVerticalGroup(
            Panel_RellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Panel_Fondo.add(Panel_Relleno);
        Panel_Relleno.setBounds(340, 10, 120, 100);

        getContentPane().add(Panel_Fondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txt_IdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_IdMouseClicked
        String Contenido;
        Contenido = txt_Id.getText();
        
        if (Contenido.equals("ID de Usuario"))
        {
            txt_Id.setText("");
            txt_Id.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_IdMouseClicked

    private void txt_IdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_IdFocusLost
        String Contenido;
        Contenido = txt_Id.getText();
        
        if (Contenido.equals(""))
        {
            txt_Id.setText("ID de Usuario");
            txt_Id.setForeground(Color.decode("#999999"));
            lbl_ErrorID.setForeground(Color.BLACK);
            lbl_ErrorID.setText("");
        }
    }//GEN-LAST:event_txt_IdFocusLost

    private void lbl_OcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_OcultarMouseClicked
        String Contenido = txt_Contrasena.getText();
        
        if (!Contenido.equals("Contraseña") && !Contenido.equals(""))
        {
            Icon OjoAbierto = new ImageIcon(getClass().getResource("/Resources/Images/OjoAbierto.png"));
            Icon OjoCerrado = new ImageIcon(getClass().getResource("/Resources/Images/OjoCerrado.png"));

            //Abierto
            if (BotonOjo == false)
            {
                BotonOjo = true;
                lbl_Ocultar.setToolTipText("Ocultar Contraseña");
                lbl_Ocultar.setIcon(OjoAbierto);
                cambiarVisibilidadContraseña();
            }

            //Cerrado
            else
            {
                BotonOjo = false;
                lbl_Ocultar.setToolTipText("Mostrar Contraseña");
                lbl_Ocultar.setIcon(OjoCerrado);
                cambiarVisibilidadContraseña();
            }
        }
    }//GEN-LAST:event_lbl_OcultarMouseClicked

    private void btn_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarActionPerformed
        int ID;
        String Contrasena;

        try 
        {
            ID = Integer.parseInt(txt_Id.getText());
        } 
        
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Sale del método si hay un error en la conversión
        }

        Contrasena = txt_Contrasena.getText();

        //Control_RecursosHumanos control = new Control_RecursosHumanos();
        Control_Empleado controlempleado = new Control_Empleado();
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        
        boolean Acceso = controlempleado.IniciarSesion(ID, Contrasena);

        if (Acceso == true) 
        {
            ConfiguracionUsuario configuracionusuario = new ConfiguracionUsuario();
            configuracionusuario = controlconfiguracion.cargarConfiguracion(ID);
            
            Empleado empleado = controlempleado.CargarUsuario(ID);
                        
            Frame_MenuInicio form = new Frame_MenuInicio(empleado, configuracionusuario);
            form.setVisible(true);
            dispose();

            
        } else 
        {
            // Manejo de error si el acceso no se concede
            JOptionPane.showMessageDialog(this, "Acceso denegado. Verifica tus credenciales.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_IniciarActionPerformed

    private void txt_IdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdKeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Id.getText();

        boolean Error = controlvalidacion.validarEntradaEntera(Texto);
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
    }//GEN-LAST:event_txt_IdKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Fondo;
    private javax.swing.JPanel Panel_Inicio;
    private javax.swing.JPanel Panel_Relleno;
    private javax.swing.JButton btn_Iniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_ErrorID;
    private javax.swing.JLabel lbl_IniciarSesion;
    private javax.swing.JLabel lbl_Ocultar;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JPasswordField txt_Contrasena;
    private javax.swing.JTextField txt_Id;
    // End of variables declaration//GEN-END:variables
    
    
    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Resources/Images/Fondo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
