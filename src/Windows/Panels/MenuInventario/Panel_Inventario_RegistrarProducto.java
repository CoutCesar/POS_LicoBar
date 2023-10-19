package Windows.Panels.MenuInventario;

import Controllers.Control_Configuracion;
import Controllers.Control_Producto;
import Controllers.Control_Sonidos;
import Controllers.Control_Validacion;
import Models.ConfiguracionUsuario;
import Models.Producto;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_RegistrarProducto;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author César Eduardo
 */
public class Panel_Inventario_RegistrarProducto extends javax.swing.JPanel 
{
    private Dialog_Inventario_RegistrarProducto dialog;

    //Constructor para instanciarse en la clase Panel_Personalizable_Derecho
    public Panel_Inventario_RegistrarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        AplicarTema(configuracionusuario);
        btn_Cancelar.setVisible(false);
    }
    
    //Constructor para instanciarse en la clase Dialog_Inventario_RegistrarProducto
    public Panel_Inventario_RegistrarProducto(ConfiguracionUsuario configuracionusuario, Dialog_Inventario_RegistrarProducto dialog) {
        initComponents();
        AplicarTema(configuracionusuario);
        this.dialog = dialog;
    }
    
    //Carga el tema tema al panel
    public void AplicarTema(ConfiguracionUsuario configuracionusuario)
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        int Tema = configuracionusuario.getTema();
        
        Color Color1 = controlconfiguracion.ObtenerColor1(Tema);
        Color Color2 = controlconfiguracion.ObtenerColor2(Tema);
        Color Color3 = controlconfiguracion.ObtenerColor3(Tema);
        
        this.setBackground(Color2);
        
        lbl_Codigo.setForeground(Color1);
        lbl_Costo.setForeground(Color1);
        lbl_Nombre.setForeground(Color1);
        lbl_Titulo.setForeground(Color1);
        lbl_Venta.setForeground(Color1);
        
        txt_Nombre.setCaretColor(Color1);
        txt_Codigo.setCaretColor(Color1);
        txt_Costo.setCaretColor(Color1);
        txt_Venta.setCaretColor(Color1);
        
        btn_Cancelar.setForeground(Color1);
        btn_Registrar.setForeground(Color1);
        
        txt_Codigo.setForeground(Color1);
        txt_Costo.setForeground(Color1);
        txt_Nombre.setForeground(Color1);
        txt_Venta.setForeground(Color1);
        
        SubPanel2.setBackground(Color2);
        
        txt_Codigo.setBackground(Color2);
        txt_Costo.setBackground(Color2);
        txt_Nombre.setBackground(Color2);
        txt_Venta.setBackground(Color2);
        
        btn_Cancelar.setBackground(Color2);
        btn_Registrar.setBackground(Color3);
        
        lbl_ErrorCodigo.setVisible(false);
        lbl_ErrorVenta.setVisible(false);
        lbl_ErrorCosto.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        SubPanel2 = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_Codigo = new javax.swing.JLabel();
        txt_Codigo = new javax.swing.JTextField();
        lbl_Costo = new javax.swing.JLabel();
        txt_Costo = new javax.swing.JTextField();
        btn_Cancelar = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        lbl_ErrorCodigo = new javax.swing.JLabel();
        lbl_ErrorCosto = new javax.swing.JLabel();
        lbl_Venta = new javax.swing.JLabel();
        txt_Venta = new javax.swing.JTextField();
        lbl_ErrorVenta = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(460, 390));
        setMinimumSize(new java.awt.Dimension(10, 10));
        setPreferredSize(new java.awt.Dimension(460, 390));
        setLayout(new java.awt.GridBagLayout());

        SubPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Registrar un producto");

        lbl_Nombre.setText("Nombre del producto");

        lbl_Codigo.setText("Codigo del producto");

        txt_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CodigoKeyReleased(evt);
            }
        });

        lbl_Costo.setText("Costo del producto");

        txt_Costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CostoKeyReleased(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Registrar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Registrar.setText("Registrar");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });

        lbl_ErrorCodigo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorCodigo.setForeground(java.awt.Color.red);
        lbl_ErrorCodigo.setText("Ingrese solo valores numericos");

        lbl_ErrorCosto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorCosto.setForeground(java.awt.Color.red);
        lbl_ErrorCosto.setText("Ingrese solo valores numericos");

        lbl_Venta.setText("Costo de venta");

        txt_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_VentaKeyReleased(evt);
            }
        });

        lbl_ErrorVenta.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorVenta.setForeground(java.awt.Color.red);
        lbl_ErrorVenta.setText("Ingrese solo valores numericos");

        javax.swing.GroupLayout SubPanel2Layout = new javax.swing.GroupLayout(SubPanel2);
        SubPanel2.setLayout(SubPanel2Layout);
        SubPanel2Layout.setHorizontalGroup(
            SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanel2Layout.createSequentialGroup()
                .addGroup(SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Registrar))
                    .addGroup(SubPanel2Layout.createSequentialGroup()
                        .addGroup(SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SubPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Titulo)
                                    .addComponent(lbl_Nombre)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Codigo)))
                            .addGroup(SubPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ErrorCosto)
                                    .addComponent(lbl_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_ErrorCodigo)
                                    .addComponent(lbl_Venta)
                                    .addComponent(txt_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_ErrorVenta))))
                        .addGap(0, 256, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SubPanel2Layout.setVerticalGroup(
            SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addGap(6, 6, 6)
                .addComponent(lbl_Nombre)
                .addGap(6, 6, 6)
                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbl_Codigo)
                .addGap(6, 6, 6)
                .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Costo)
                .addGap(6, 6, 6)
                .addComponent(txt_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorCosto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Venta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SubPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Registrar))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 30, 6);
        add(SubPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
    //Evento registrar producto
    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        try 
        {
            int ID_Producto = Integer.parseInt(txt_Codigo.getText());
            float Costo = Float.parseFloat(txt_Costo.getText());
            float Venta = Float.parseFloat(txt_Venta.getText());
            String Nombre_Producto = txt_Nombre.getText();

            Control_Producto controlproducto = new Control_Producto();
            Producto producto = new Producto();

            producto.setID_Producto(ID_Producto);
            producto.setNombre_Producto(Nombre_Producto);
            producto.setCosto(Costo);
            producto.setCostoVenta(Venta);
            controlproducto.NuevoProducto(producto);
            
            txt_Nombre.setText("");
            txt_Codigo.setText("");
            txt_Costo.setText("");
            txt_Venta.setText("");
            
        } catch (NumberFormatException e) 
        {    
            Control_Sonidos controlsonido = new Control_Sonidos();
            controlsonido.ReproducirError1();
            JOptionPane.showMessageDialog(null, "Error, siga las instrucciones", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    //Detecta errores de escritura
    private void txt_CodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoKeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Codigo.getText();

        boolean Error = controlvalidacion.TextFieldEntero(Texto);
        if (Error == true)
        {
            LineBorder BordeError = new LineBorder(Color.RED);
            txt_Codigo.setBorder(BordeError);
            lbl_ErrorCodigo.setVisible(true);
        }

        else
        {
            txt_Codigo.setBorder(UIManager.getBorder("TextField.border"));
            lbl_ErrorCodigo.setVisible(false);
        }
    }//GEN-LAST:event_txt_CodigoKeyReleased

    //Detecta errores de escritura
    private void txt_CostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CostoKeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Costo.getText();

        boolean Error = controlvalidacion.TextFieldFloat(Texto);
        if (Error == true)
        {
            LineBorder BordeError = new LineBorder(Color.RED);
            txt_Costo.setBorder(BordeError);
            lbl_ErrorCosto.setVisible(true);
        }

        else
        {
            txt_Costo.setBorder(UIManager.getBorder("TextField.border"));
            lbl_ErrorCosto.setVisible(false);
        }
    }//GEN-LAST:event_txt_CostoKeyReleased

    //Detecta errores de escritura
    private void txt_VentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_VentaKeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Venta.getText();

        boolean Error = controlvalidacion.TextFieldFloat(Texto);
        if (Error == true)
        {
            LineBorder BordeError = new LineBorder(Color.RED);
            txt_Venta.setBorder(BordeError);
            lbl_ErrorVenta.setVisible(true);
        }

        else
        {
            txt_Venta.setBorder(UIManager.getBorder("TextField.border"));
            lbl_ErrorVenta.setVisible(false);
        }
    }//GEN-LAST:event_txt_VentaKeyReleased

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        dialog.Cerrar();
    }//GEN-LAST:event_btn_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SubPanel2;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JLabel lbl_Costo;
    private javax.swing.JLabel lbl_ErrorCodigo;
    private javax.swing.JLabel lbl_ErrorCosto;
    private javax.swing.JLabel lbl_ErrorVenta;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Venta;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Costo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Venta;
    // End of variables declaration//GEN-END:variables
}
