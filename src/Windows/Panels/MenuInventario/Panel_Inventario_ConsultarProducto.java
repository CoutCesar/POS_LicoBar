package Windows.Panels.MenuInventario;

import Controllers.Control_Configuracion;
import Controllers.Control_Producto;
import Models.ConfiguracionUsuario;
import Models.Tema;
import java.awt.Color;
import javax.swing.SwingWorker;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author César Eduardo
 */
public class Panel_Inventario_ConsultarProducto extends javax.swing.JPanel {

    public Panel_Inventario_ConsultarProducto(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        aplicarTema(configuracionusuario);
        CargarTabla();
    }

    //Aplica el tema al panel
    public void aplicarTema(ConfiguracionUsuario configuracionusuario)
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionusuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());

        lbl_Titulo.setForeground(color1);
        lbl_Busqueda.setForeground(color1);
        lbl_TipoBusqueda.setForeground(color1);
        
        txt_Busqueda.setCaretColor(color1);
        txt_Busqueda.setForeground(color1);
        
        cmb_Tipo.setForeground(color1);
        
        this.setBackground(color2);
        SubPanel.setBackground(color2);
        cmb_Tipo.setBackground(color2);
        txt_Busqueda.setBackground(color2);
        tabla_Busqueda.setBackground(color2);
        
        txt_Busqueda.setSelectionColor(color3);
        tabla_Busqueda.setSelectionBackground(color3);

        //Propiedades customUI = new Propiedades(color3, color2);
        ComboBoxUI customUI = controlconfiguracion.createCustomComboBoxUI(color3, color2);
        cmb_Tipo.setUI(customUI);
        
        tabla_Busqueda.setForeground(color1);
        JTableHeader header = tabla_Busqueda.getTableHeader();
        header.setBackground(color3); 
        header.setForeground(color1);
        header.repaint(); 
    }

    //Muestra todos los producto en la tabla
    public void CargarTabla()
    {
        Control_Producto controlproducto = new Control_Producto();
        DefaultTableModel model = new DefaultTableModel();
        
        model = controlproducto.cargarProductos();
        tabla_Busqueda.setModel(model);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        SubPanel = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_TipoBusqueda = new javax.swing.JLabel();
        cmb_Tipo = new javax.swing.JComboBox<>();
        lbl_Busqueda = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Busqueda = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(470, 400));
        setLayout(new java.awt.GridBagLayout());

        SubPanel.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Consultar un producto");

        lbl_TipoBusqueda.setText("Tipo de busqueda");

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar con codigo", "Buscar con nombre" }));
        cmb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_TipoActionPerformed(evt);
            }
        });

        lbl_Busqueda.setText("Codigo");

        txt_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyReleased(evt);
            }
        });

        tabla_Busqueda.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_Busqueda.setMinimumSize(new java.awt.Dimension(10, 10));
        jScrollPane1.setViewportView(tabla_Busqueda);

        javax.swing.GroupLayout SubPanelLayout = new javax.swing.GroupLayout(SubPanel);
        SubPanel.setLayout(SubPanelLayout);
        SubPanelLayout.setHorizontalGroup(
            SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SubPanelLayout.createSequentialGroup()
                        .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_TipoBusqueda)
                            .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Busqueda)
                            .addComponent(txt_Busqueda)))
                    .addGroup(SubPanelLayout.createSequentialGroup()
                        .addComponent(lbl_Titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        SubPanelLayout.setVerticalGroup(
            SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TipoBusqueda)
                    .addComponent(lbl_Busqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(SubPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
    //Hace busquedas en tiempo real
    private void txt_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyReleased
        int Tipo = cmb_Tipo.getSelectedIndex();

        if (Tipo == 0) 
        {
            try {
                int Codigo = Integer.parseInt(txt_Busqueda.getText());

                SwingWorker<DefaultTableModel, Void> worker = new SwingWorker<DefaultTableModel, Void>() {
                    @Override
                    protected DefaultTableModel doInBackground() throws Exception 
                    {
                        Control_Producto controlproducto = new Control_Producto();
                        DefaultTableModel model = new DefaultTableModel();
                        return controlproducto.busquedaConCodigo(Codigo);
                    }

                    @Override
                    protected void done() 
                    {
                        try {
                            DefaultTableModel model = get();
                            tabla_Busqueda.setModel(model);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                };

                worker.execute();
            } catch (NumberFormatException e) 
            {
                Control_Producto controlproducto = new Control_Producto();
                tabla_Busqueda.setModel(controlproducto.cargarProductos());
            }
        } 
        
        else 
        {
            String Nombre = txt_Busqueda.getText();

            SwingWorker<DefaultTableModel, Void> worker = new SwingWorker<DefaultTableModel, Void>() 
            {
                @Override
                protected DefaultTableModel doInBackground() throws Exception 
                {
                    Control_Producto controlproducto = new Control_Producto();
                    DefaultTableModel model = new DefaultTableModel();
                    return controlproducto.busquedaConNombre(Nombre);
                }

                @Override
                protected void done() 
                {
                    try {
                        DefaultTableModel model = get();
                        tabla_Busqueda.setModel(model);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            worker.execute();
        }
    }//GEN-LAST:event_txt_BusquedaKeyReleased

    private void cmb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_TipoActionPerformed
        int Tipo = cmb_Tipo.getSelectedIndex();
        
        if (Tipo == 0) lbl_Busqueda.setText("Codigo");
        else lbl_Busqueda.setText("Nombre");
    }//GEN-LAST:event_cmb_TipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SubPanel;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Busqueda;
    private javax.swing.JLabel lbl_TipoBusqueda;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTable tabla_Busqueda;
    private javax.swing.JTextField txt_Busqueda;
    // End of variables declaration//GEN-END:variables
}
