//Este Codigo ya fue Optimizado
//Falta arreglar un Bug
package Windows.Panels.MenuConfiguracion;

import Controllers.Control_Configuracion;
import Controllers.Control_Empleado;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import Models.Tema;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_Preferencias;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author César Eduardo
 */

public class Panel_Configuracion_CambiarContrasena extends javax.swing.JPanel 
{    
    private Empleado empleado;
    private Dialog_Configuracion_Preferencias dialog;

    public Panel_Configuracion_CambiarContrasena(ConfiguracionUsuario configuracionusuario, Empleado usuario) 
    {
        initComponents();
        lbl_ErrorContrasena.setVisible(false);
        lbl_ErrorConfirmacion.setVisible(false);
        empleado = usuario;
        aplicarTema(configuracionusuario);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Aplicar el Tema a la Interfaz
    public void aplicarTema(ConfiguracionUsuario configuracionusuario)
    {
        Control_Configuracion controlConfiguracion = new Control_Configuracion();
        Tema tema;// = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlConfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        
        lbl_Confirmacion.setForeground(color1);
        lbl_ContrasenaActual.setForeground(color1);
        lbl_ContrasenaNueva.setForeground(color1);
        lbl_CambiarContrasena.setForeground(color1);

        txt_ContrasenaActual.setForeground(color1);
        txt_NuevaContrasena.setForeground(color1);
        txt_ConfirmarContrasena.setForeground(color1);
        
        btn_Cambiar.setForeground(color1);
        
        txt_ContrasenaActual.setBackground(color2);
        txt_NuevaContrasena.setBackground(color2);
        txt_ConfirmarContrasena.setBackground(color2);
        
        this.setBackground(color2);
        panel_Interfaz.setBackground(color2);
        
        btn_Cambiar.setBackground(color3);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Interfaz = new javax.swing.JPanel();
        lbl_CambiarContrasena = new javax.swing.JLabel();
        btn_Cambiar = new javax.swing.JButton();
        lbl_ContrasenaActual = new javax.swing.JLabel();
        lbl_ContrasenaNueva = new javax.swing.JLabel();
        txt_NuevaContrasena = new javax.swing.JTextField();
        lbl_Confirmacion = new javax.swing.JLabel();
        txt_ConfirmarContrasena = new javax.swing.JTextField();
        txt_ContrasenaActual = new javax.swing.JTextField();
        lbl_ErrorConfirmacion = new javax.swing.JLabel();
        lbl_ErrorContrasena = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(320, 357));
        setPreferredSize(new java.awt.Dimension(320, 357));
        setLayout(new java.awt.GridBagLayout());

        panel_Interfaz.setBackground(new java.awt.Color(255, 255, 255));
        panel_Interfaz.setFocusCycleRoot(true);
        panel_Interfaz.setFocusTraversalPolicyProvider(true);
        panel_Interfaz.setNextFocusableComponent(panel_Interfaz);

        lbl_CambiarContrasena.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_CambiarContrasena.setForeground(new java.awt.Color(0, 3, 24));
        lbl_CambiarContrasena.setText("Cambiar Contraseña");

        btn_Cambiar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Cambiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cambiar.setText("Cambiar Contraseña");
        btn_Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CambiarActionPerformed(evt);
            }
        });

        lbl_ContrasenaActual.setText("Contraseña Actual");

        lbl_ContrasenaNueva.setText("Nueva Contraseña");

        lbl_Confirmacion.setText("Confirmar Contraseña");

        lbl_ErrorConfirmacion.setForeground(java.awt.Color.red);
        lbl_ErrorConfirmacion.setText("Las contraseñas no coinciden");

        lbl_ErrorContrasena.setForeground(java.awt.Color.red);
        lbl_ErrorContrasena.setText("La contraseña es incorrecta");

        javax.swing.GroupLayout panel_InterfazLayout = new javax.swing.GroupLayout(panel_Interfaz);
        panel_Interfaz.setLayout(panel_InterfazLayout);
        panel_InterfazLayout.setHorizontalGroup(
            panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Cambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_InterfazLayout.createSequentialGroup()
                        .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_CambiarContrasena)
                            .addGroup(panel_InterfazLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_ContrasenaActual)))
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_InterfazLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ContrasenaNueva)
                            .addComponent(lbl_Confirmacion)
                            .addGroup(panel_InterfazLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_NuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_ErrorConfirmacion)))))
                    .addGroup(panel_InterfazLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ErrorContrasena)
                            .addComponent(txt_ContrasenaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_InterfazLayout.setVerticalGroup(
            panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_CambiarContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ContrasenaActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ContrasenaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorContrasena)
                .addGap(18, 18, 18)
                .addComponent(lbl_ContrasenaNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_NuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_Confirmacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_ConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorConfirmacion)
                .addGap(34, 34, 34)
                .addComponent(btn_Cambiar)
                .addContainerGap())
        );

        add(panel_Interfaz, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento para Ejecutar el Proceso para Cambiar la Contrasena
    private void btn_CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CambiarActionPerformed
        int id = empleado.getID_Empleado();
        
        String contrasenaOriginal = empleado.getContrasena();
        String contraenaActual = txt_ContrasenaActual.getText();
        String contrasenaNueva = txt_NuevaContrasena.getText();
        String confirmacion = txt_ConfirmarContrasena.getText();
        
        Control_Empleado controlEmpleado = new Control_Empleado();
        
        Color colorDefault = UIManager.getColor("TextField.border");
        LineBorder bordeError = new LineBorder(Color.RED);
        LineBorder bordeCorrecto = new LineBorder(colorDefault);
        
        if (contrasenaOriginal.equals(contraenaActual))
        {
            lbl_ErrorContrasena.setVisible(false);
            txt_ContrasenaActual.setBorder(bordeCorrecto);
            
            if (contrasenaNueva.equals(confirmacion))
            {
                lbl_ErrorConfirmacion.setVisible(false);
                txt_ConfirmarContrasena.setBorder(bordeCorrecto);
                controlEmpleado.cambiarContrasena(contrasenaNueva, id);
            }
            
            else 
            {
                lbl_ErrorConfirmacion.setVisible(true);
                txt_ConfirmarContrasena.setBorder(bordeError);
            }
        }
        
        else 
        {
            lbl_ErrorContrasena.setVisible(true);
            txt_ContrasenaActual.setBorder(bordeError);
            System.out.println("Contrasena mal");
        }
        
        txt_ContrasenaActual.setText("");
        txt_NuevaContrasena.setText("");
        txt_ConfirmarContrasena.setText("");
    }//GEN-LAST:event_btn_CambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cambiar;
    private javax.swing.JLabel lbl_CambiarContrasena;
    private javax.swing.JLabel lbl_Confirmacion;
    private javax.swing.JLabel lbl_ContrasenaActual;
    private javax.swing.JLabel lbl_ContrasenaNueva;
    private javax.swing.JLabel lbl_ErrorConfirmacion;
    private javax.swing.JLabel lbl_ErrorContrasena;
    private javax.swing.JPanel panel_Interfaz;
    private javax.swing.JTextField txt_ConfirmarContrasena;
    private javax.swing.JTextField txt_ContrasenaActual;
    private javax.swing.JTextField txt_NuevaContrasena;
    // End of variables declaration//GEN-END:variables
}
