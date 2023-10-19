package Windows.Panels.MenuInventario;

import Controllers.Control_Configuracion;
import Controllers.Control_Producto;
import Controllers.Control_Sonidos;
import Models.ConfiguracionUsuario;
import Models.Producto;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

/**
 *
 * @author César Eduardo
 */
public class Panel_Inventario_EliminarProducto extends javax.swing.JPanel {

    public Panel_Inventario_EliminarProducto(ConfiguracionUsuario configuracionusuario) {
        initComponents();
        AplicarTemas(configuracionusuario);
    }
    
    
    public void AplicarTemas(ConfiguracionUsuario configuracionusuario)
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
        
        btn_Cancelar.setBackground(Color2);
        btn_Cancelar.setForeground(Color1);
        
        btn_Eliminar.setBackground(Color4);
        btn_Eliminar.setForeground(Color1);
        
        Border border = BorderFactory.createLineBorder(Color.white, 1); // 2 es el grosor del borde
        Control_Configuracion.Propiedades customUI = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        cmb_Tipo.setUI(customUI);
        cmb_Tipo.setForeground(Color1);
        
        jLabel1.setForeground(Color1);
        lbl_Busqueda.setForeground(Color1);
        lbl_Titulo.setForeground(Color1);
        
        txt_Busqueda.setCaretColor(Color1);
        
        SubPanel.setBackground(Color2);
        
        txt_Busqueda.setBackground(Color2);
        txt_Busqueda.setForeground(Color1);

        lista_Resultados.setBackground(Color2);
        lista_Resultados.setForeground(Color1);
        
        btn_Eliminar.setVisible(false);
        
        DefaultListModel model = new DefaultListModel();
        lista_Resultados.setModel(model);
    }
    
    
    public void CargarProducto(int ID)
    {
        btn_Eliminar.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        SubPanel = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb_Tipo = new javax.swing.JComboBox<>();
        lbl_Busqueda = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        btn_Eliminar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_Resultados = new javax.swing.JList<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(10, 10));
        setPreferredSize(new java.awt.Dimension(480, 295));
        setLayout(new java.awt.GridBagLayout());

        SubPanel.setBackground(new java.awt.Color(204, 255, 255));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Eliminar Producto");

        jLabel1.setText("Tipo de busqueda");

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

        btn_Eliminar.setBackground(new java.awt.Color(0, 3, 24));
        btn_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");

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
        jScrollPane3.setViewportView(lista_Resultados);

        javax.swing.GroupLayout SubPanelLayout = new javax.swing.GroupLayout(SubPanel);
        SubPanel.setLayout(SubPanelLayout);
        SubPanelLayout.setHorizontalGroup(
            SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SubPanelLayout.createSequentialGroup()
                        .addComponent(lbl_Titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SubPanelLayout.createSequentialGroup()
                        .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SubPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lbl_Busqueda)
                                .addGap(193, 195, Short.MAX_VALUE))
                            .addGroup(SubPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Busqueda))))
                    .addGroup(SubPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Eliminar)))
                .addContainerGap())
        );
        SubPanelLayout.setVerticalGroup(
            SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Busqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Eliminar)
                    .addComponent(btn_Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(SubPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_TipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TipoItemStateChanged
        int Tipo = cmb_Tipo.getSelectedIndex();
        
        if (Tipo == 0) lbl_Busqueda.setText("Codigo");
        else lbl_Busqueda.setText("Nombre");
    }//GEN-LAST:event_cmb_TipoItemStateChanged

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
                        return controlproducto.ConsultaNombreMod(Nombre);
                    }

                    @Override
                    protected void done() 
                    {
                        try 
                        {
                            DefaultListModel<String> model = get();
                            lista_Resultados.setModel(model);
                            
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
                btn_Eliminar.setVisible(false);
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
                            return controlproducto.ConsultaCodigoMod(Codigo);
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
                btn_Eliminar.setVisible(false);
            }
        }
    }//GEN-LAST:event_txt_BusquedaKeyReleased

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
                    CargarProducto(ID);
                }
                
                String Seleccion = lista_Resultados.getSelectedValue();
                txt_Busqueda.setText(Seleccion);
            }
        }
    }//GEN-LAST:event_lista_ResultadosMouseClicked

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        // Obtener el elemento seleccionado de la lista
        String selectedItem = lista_Resultados.getSelectedValue();//.toString();

        // Extraer el ID del elemento seleccionado
        int startIndex = selectedItem.indexOf("ID Producto: ") + 13; // Añadir 13 para saltar la parte "ID Producto: "
        int endIndex = selectedItem.indexOf(")", startIndex);
        
        String idString = selectedItem.substring(startIndex, endIndex);
        int ID = Integer.parseInt(idString.trim());

        // Extraer el nombre del elemento seleccionado
        String Nombre = selectedItem.substring(0, startIndex - 15); // Restar 15 para eliminar " (ID Producto: X)" del nombre

        Control_Sonidos controlsonido = new Control_Sonidos();
        controlsonido.ReproducirError1();
        
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el producto " + Nombre + "?", "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) 
        {
            Control_Producto controlproducto = new Control_Producto();
            controlproducto.EliminarProducto(ID);
            
            DefaultListModel model = new DefaultListModel();
            lista_Resultados.setModel(model);
            btn_Eliminar.setVisible(false);
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SubPanel;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_Busqueda;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JList<String> lista_Resultados;
    private javax.swing.JTextField txt_Busqueda;
    // End of variables declaration//GEN-END:variables
}
