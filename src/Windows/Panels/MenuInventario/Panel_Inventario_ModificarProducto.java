package Windows.Panels.MenuInventario;

import Controllers.Control_Configuracion;
import Controllers.Control_Producto;
import Controllers.Control_Sonido;
import Controllers.Control_Validacion;
import Models.ConfiguracionUsuario;
import Models.Producto;
import Models.Tema;
import Windows.Dialogs.MenuInventario.Dialog_Inventario_ModificarProducto;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComboBoxUI;


/**
 *
 * @author César Eduardo
 */
public class Panel_Inventario_ModificarProducto extends javax.swing.JPanel 
{
    private Dialog_Inventario_ModificarProducto dialog;    
    String ID_Producto;
    
    //Contructor para ser instanciado en la clase Panel_Personalizable_Derecha
    public Panel_Inventario_ModificarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        AplicarTema(configuracionusuario);
        btn_Cancelar.setVisible(false);
    }
    
    //Contructor para ser instanciado en la clase Dialog_Producto_ModificarProducto
    public Panel_Inventario_ModificarProducto(ConfiguracionUsuario configuracionusuario, Dialog_Inventario_ModificarProducto dialog) 
    {
        initComponents();
        AplicarTema(configuracionusuario);
        this.dialog = dialog;
    }
    
    //Carga el tema en el panel
    public void AplicarTema(ConfiguracionUsuario configuracionusuario)
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color5 = Color.decode(tema.getColor5());

        //jPanel1.setFocusCycleRoot(true);

        lbl_Tipo.setForeground(color1);
        lbl_Titulo.setForeground(color1);
        lbl_Costo.setForeground(color1);
        lbl_Venta.setForeground(color1);
        lbl_Codigo.setForeground(color1);
        lbl_Nombre.setForeground(color1);
        lbl_Busqueda.setForeground(color1);
        
        txt_Costo.setForeground(color1);
        txt_Precio.setForeground(color1);
        txt_Codigo.setForeground(color1);
        txt_Nombre.setForeground(color1);
        txt_Busqueda.setForeground(color1);
        
        txt_Costo.setCaretColor(color1);
        txt_Precio.setCaretColor(color1);
        txt_Codigo.setCaretColor(color1);
        txt_Nombre.setCaretColor(color1);
        txt_Busqueda.setCaretColor(color1);
        
        btn_Modificar.setForeground(color1);
        btn_Cancelar.setForeground(color1);
        
        cmb_Tipo.setForeground(color1);
        lista_Resultados.setForeground(color1);
        
        this.setBackground(color2);
        
        txt_Costo.setBackground(color2);
        txt_Precio.setBackground(color2);
        txt_Codigo.setBackground(color2);
        txt_Nombre.setBackground(color2);
        txt_Busqueda.setBackground(color2);
        
        cmb_Tipo.setBackground(color2);
        btn_Cancelar.setBackground(color2);
        panel_Modificar.setBackground(color2);
        lista_Resultados.setBackground(color2);
        
        txt_Costo.setSelectionColor(color3);
        txt_Precio.setSelectionColor(color3);
        txt_Codigo.setSelectionColor(color3);
        txt_Nombre.setSelectionColor(color3);
        txt_Busqueda.setSelectionColor(color3);
        
        lista_Resultados.setSelectionBackground(color3);
        
        btn_Modificar.setBackground(color5);
        

        //Control_Configuracion.Propiedades customUI = new Control_Configuracion.Propiedades(color3, color2);
        ComboBoxUI customUI = controlconfiguracion.createCustomComboBoxUI(color3, color2);
        cmb_Tipo.setUI(customUI);
        cmb_Tipo.setForeground(color1);
        
        lbl_ErrorCodigo.setVisible(false);
        lbl_ErrorVenta.setVisible(false);
        lbl_ErrorCosto.setVisible(false);
        
        txt_Nombre.setVisible(false);
        txt_Codigo.setVisible(false);
        txt_Precio.setVisible(false);
        txt_Costo.setVisible(false);

        lbl_Nombre.setVisible(false);
        lbl_Codigo.setVisible(false);
        lbl_Costo.setVisible(false);
        lbl_Venta.setVisible(false);
        
        btn_Modificar.setVisible(false);
        
        DefaultListModel model = new DefaultListModel();
        lista_Resultados.setModel(model);
    }
    
    
    //Carga el resulatado de la busqueda
    public void CargarResultado(int ID)
    {
        Control_Producto controlproducto = new Control_Producto();
        Producto producto = controlproducto.cargarProducto(ID);
        
        txt_Nombre.setVisible(true);
        txt_Codigo.setVisible(true);
        txt_Precio.setVisible(true);
        txt_Costo.setVisible(true);
        
        lbl_Nombre.setVisible(true);
        lbl_Codigo.setVisible(true);
        lbl_Costo.setVisible(true);
        lbl_Venta.setVisible(true);
        
        btn_Modificar.setVisible(true);
        
        txt_Nombre.setText(producto.getNombre_Producto());
        txt_Codigo.setText(String.valueOf(producto.getID_Producto()));
        txt_Precio.setText(String.valueOf(producto.getCosto()));
        txt_Costo.setText(String.valueOf(producto.getCostoVenta()));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_Modificar = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_Tipo = new javax.swing.JLabel();
        cmb_Tipo = new javax.swing.JComboBox<>();
        lbl_Busqueda = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        lbl_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_Codigo = new javax.swing.JLabel();
        txt_Codigo = new javax.swing.JTextField();
        lbl_Costo = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        lbl_Venta = new javax.swing.JLabel();
        txt_Costo = new javax.swing.JTextField();
        btn_Modificar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_Resultados = new javax.swing.JList<>();
        lbl_ErrorCodigo = new javax.swing.JLabel();
        lbl_ErrorVenta = new javax.swing.JLabel();
        lbl_ErrorCosto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(398, 533));
        setLayout(new java.awt.GridBagLayout());

        panel_Modificar.setBackground(new java.awt.Color(204, 204, 204));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Modificar un producto");

        lbl_Tipo.setText("Tipo de busqueda");

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar con codigo", "Buscar con nombre" }));
        cmb_Tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_TipoItemStateChanged(evt);
            }
        });

        lbl_Busqueda.setText("Codigo");

        txt_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyReleased(evt);
            }
        });

        lbl_Nombre.setText("Nombre");

        lbl_Codigo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Codigo.setText("Codigo del producto");

        txt_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CodigoKeyReleased(evt);
            }
        });

        lbl_Costo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Costo.setText("Precio del producto");

        txt_Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PrecioKeyReleased(evt);
            }
        });

        lbl_Venta.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Venta.setText("Costo del producto");

        txt_Costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CostoKeyReleased(evt);
            }
        });

        btn_Modificar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Modificar.setText("Modificar");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        lista_Resultados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista_Resultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_ResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista_Resultados);

        lbl_ErrorCodigo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorCodigo.setForeground(java.awt.Color.red);
        lbl_ErrorCodigo.setText("Solo ingrese numeros");

        lbl_ErrorVenta.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorVenta.setForeground(java.awt.Color.red);
        lbl_ErrorVenta.setText("Solo ingrese numeros");

        lbl_ErrorCosto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_ErrorCosto.setForeground(java.awt.Color.red);
        lbl_ErrorCosto.setText("Solo ingrese numeros");

        javax.swing.GroupLayout panel_ModificarLayout = new javax.swing.GroupLayout(panel_Modificar);
        panel_Modificar.setLayout(panel_ModificarLayout);
        panel_ModificarLayout.setHorizontalGroup(
            panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ModificarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Modificar))
                    .addComponent(txt_Busqueda)
                    .addComponent(jScrollPane1)
                    .addGroup(panel_ModificarLayout.createSequentialGroup()
                        .addGroup(panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Busqueda)
                            .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Titulo)
                            .addComponent(lbl_Tipo)
                            .addGroup(panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Nombre)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_Codigo)
                                .addComponent(lbl_ErrorCodigo)
                                .addComponent(lbl_Venta)
                                .addComponent(txt_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_ErrorVenta)
                                .addComponent(lbl_Costo)
                                .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_ErrorCosto)))
                        .addGap(0, 196, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_ModificarLayout.setVerticalGroup(
            panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Tipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Busqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Codigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Venta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Costo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ErrorCosto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_ModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Modificar)
                    .addComponent(btn_Cancelar))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(panel_Modificar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
    //Realiza la busqueda de resultados en tiempo real
    private void txt_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyReleased
        int Tipo = cmb_Tipo.getSelectedIndex();
        
        //Busqueda con el nombre
        if (Tipo == 1) 
        {
            String Nombre = txt_Busqueda.getText().trim();
            System.out.println("Llego a esta ");

            if (!Nombre.isEmpty()) 
            {
                SwingWorker<DefaultListModel<String>, Void> worker = new SwingWorker<DefaultListModel<String>, Void>() 
                {
                    @Override
                    protected DefaultListModel<String> doInBackground() throws Exception 
                    {
                        Control_Producto controlproducto = new Control_Producto();
                        System.out.println("Se supone que si jala");
                        return controlproducto.consultaConNombre(Nombre);
                    }

                    @Override
                    protected void done() 
                    {
                        try 
                        {
                            DefaultListModel<String> model = get();
                            lista_Resultados.setModel(model);
                            System.out.println("Se debería de haber cargado el modelo");
                        } catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                    }
                };

                worker.execute();
            } 
            else 
            {
                // Manejar el caso cuando el cuadro de texto está vacío.
                DefaultListModel model = new DefaultListModel();
                lista_Resultados.setModel(model);
                
                txt_Nombre.setVisible(false);
                txt_Codigo.setVisible(false);
                txt_Precio.setVisible(false);
                txt_Costo.setVisible(false);
                
                lbl_Nombre.setVisible(false);
                lbl_Codigo.setVisible(false);
                lbl_Costo.setVisible(false);
                lbl_Venta.setVisible(false);
                
                lbl_ErrorCodigo.setVisible(false);
                lbl_ErrorCosto.setVisible(false);
                lbl_ErrorVenta.setVisible(false);
                
                btn_Modificar.setVisible(false);
            }
        }
        
        //Busqueda con el codigo
        else 
        {
            String textoBusqueda = txt_Busqueda.getText().trim();

            if (!textoBusqueda.isEmpty()) 
            {
                try {
                    int Codigo = Integer.parseInt(textoBusqueda);

                    SwingWorker<DefaultListModel<String>, Void> worker = new SwingWorker<DefaultListModel<String>, Void>() 
                    {
                        @Override
                        protected DefaultListModel<String> doInBackground() throws Exception 
                        {
                            Control_Producto controlproducto = new Control_Producto();
                            return controlproducto.consultaConCodigo(Codigo);
                        }

                        @Override
                        protected void done() 
                        {
                            try {
                                DefaultListModel<String> model = get();
                                lista_Resultados.setModel(model);
                            } catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                        }
                    };

                    worker.execute();
                } catch (NumberFormatException e) 
                {
                    // Manejar la excepción de formato incorrecto aquí.
                }
            } else 
            {
                DefaultListModel model = new DefaultListModel();
                lista_Resultados.setModel(model);
                
                txt_Nombre.setVisible(false);
                txt_Codigo.setVisible(false);
                txt_Precio.setVisible(false);
                txt_Costo.setVisible(false);
                
                lbl_Nombre.setVisible(false);
                lbl_Codigo.setVisible(false);
                lbl_Costo.setVisible(false);
                lbl_Venta.setVisible(false);
                
                lbl_ErrorCodigo.setVisible(false);
                lbl_ErrorCosto.setVisible(false);
                lbl_ErrorVenta.setVisible(false);
                
                btn_Modificar.setVisible(false);
                
                txt_Precio.setBorder(UIManager.getBorder("TextField.border"));
                txt_Costo.setBorder(UIManager.getBorder("TextField.border"));
                txt_Codigo.setBorder(UIManager.getBorder("TextField.border"));
            }
        }
    }//GEN-LAST:event_txt_BusquedaKeyReleased

    
    //Evento para elegir el producto a modificar
    private void lista_ResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_ResultadosMouseClicked
        if (evt.getClickCount() == 1) 
        {
            int index = lista_Resultados.locationToIndex(evt.getPoint());
            if (index >= 0) 
            {
                Object selectedValue = lista_Resultados.getModel().getElementAt(index);

                // Utilizar una expresión regular para encontrar el valor del ID
                String regex = "ID Producto: (\\d+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(selectedValue.toString());

                if (matcher.find()) 
                {
                    String id = matcher.group(1); // El primer grupo de captura corresponde al valor del ID
                    int ID = Integer.parseInt(id);
                    CargarResultado(ID);
                    
                    ID_Producto = id;
                }
                
                String Seleccion = lista_Resultados.getSelectedValue();
                txt_Busqueda.setText(Seleccion);
                
                DefaultListModel model = new DefaultListModel();
                lista_Resultados.setModel(model);
            }
        }
    }//GEN-LAST:event_lista_ResultadosMouseClicked
    
    //Detecta errores de escritura
    private void txt_CodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoKeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Codigo.getText();

        boolean Error = controlvalidacion.validarEntradaEntera(Texto);
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

        boolean Error = controlvalidacion.validarEntradaFloat(Texto);
        if (Error == true)
        {
            LineBorder BordeError = new LineBorder(Color.RED);
            txt_Costo.setBorder(BordeError);
            lbl_ErrorVenta.setVisible(true);
        }

        else
        {
            txt_Costo.setBorder(UIManager.getBorder("TextField.border"));
            lbl_ErrorVenta.setVisible(false);
        }
    }//GEN-LAST:event_txt_CostoKeyReleased

    //Detecta errores de escritura
    private void txt_PrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PrecioKeyReleased
        Control_Validacion controlvalidacion = new Control_Validacion();
        String Texto = txt_Precio.getText();

        boolean Error = controlvalidacion.validarEntradaFloat(Texto);
        if (Error == true)
        {
            LineBorder BordeError = new LineBorder(Color.RED);
            txt_Precio.setBorder(BordeError);
            lbl_ErrorCosto.setVisible(true);
        }

        else
        {
            txt_Precio.setBorder(UIManager.getBorder("TextField.border"));
            lbl_ErrorCosto.setVisible(false);
        }
    }//GEN-LAST:event_txt_PrecioKeyReleased

    //Ejecuta el codigo para la modificacion
    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        Control_Sonido controlsonido = new Control_Sonido();
        controlsonido.reproducirSonidoError1();
        
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar el producto?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        //En caso de si querer modificar
        if (confirmacion == JOptionPane.YES_OPTION) 
        {
            try 
            {
                //Codigo para hacer la modificacion
                Control_Producto controlproducto = new Control_Producto();
                int ID = Integer.parseInt(ID_Producto);

                Producto producto = new Producto();
                
                producto.setID_Producto(Integer.parseInt(txt_Codigo.getText()));
                producto.setNombre_Producto(txt_Nombre.getText());
                producto.setCosto(Float.parseFloat(txt_Costo.getText()));
                producto.setCostoVenta(Float.parseFloat(txt_Precio.getText()));

                controlproducto.modificarProducto(producto, ID);

                //Codigo para limpiar los componentes
                txt_Codigo.setText("");
                txt_Nombre.setText("");
                txt_Precio.setText("");
                txt_Costo.setText("");

                txt_Codigo.setVisible(false);
                txt_Nombre.setVisible(false);
                txt_Precio.setVisible(false);
                txt_Costo.setVisible(false);

                lbl_Codigo.setVisible(false);
                lbl_Nombre.setVisible(false);
                lbl_Costo.setVisible(false);
                lbl_Venta.setVisible(false);
                
                btn_Modificar.setVisible(false);

                DefaultListModel model = new DefaultListModel();
                lista_Resultados.setModel(model);

                txt_Busqueda.setText("");
            } 

            catch (NumberFormatException e) 
            {
                controlsonido.reproducirSonidoError1();
                JOptionPane.showMessageDialog(null, "Error, siga las instrucciones", "Error", JOptionPane.ERROR_MESSAGE);   
            }
        } 
        
        //En caso de no queres modificar el producto
        else {
            // El usuario eligió "No" o cerró el cuadro de diálogo, no realices la modificación
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

    //Cancelar modificacion
    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        dialog.Cerrar();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void cmb_TipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TipoItemStateChanged
        int Tipo = cmb_Tipo.getSelectedIndex();
        
        if (Tipo == 0) lbl_Busqueda.setText("Codigo");
        else lbl_Busqueda.setText("Nombre");
    }//GEN-LAST:event_cmb_TipoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Busqueda;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JLabel lbl_Costo;
    private javax.swing.JLabel lbl_ErrorCodigo;
    private javax.swing.JLabel lbl_ErrorCosto;
    private javax.swing.JLabel lbl_ErrorVenta;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Tipo;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Venta;
    private javax.swing.JList<String> lista_Resultados;
    private javax.swing.JPanel panel_Modificar;
    private javax.swing.JTextField txt_Busqueda;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Costo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables
}
