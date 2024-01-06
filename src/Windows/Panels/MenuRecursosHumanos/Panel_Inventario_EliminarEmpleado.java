package Windows.Panels.MenuRecursosHumanos;

import Controllers.Control_Configuracion;
import Controllers.Control_Empleado;
import Controllers.Control_Sonido;
import Models.ConfiguracionUsuario;
import Models.Tema;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author César Eduardo
 */
public class Panel_Inventario_EliminarEmpleado extends javax.swing.JPanel 
{

    public Panel_Inventario_EliminarEmpleado(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        AplicarTemas(configuracionusuario);
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Aplica la configuracion del tema    
    public void AplicarTemas(ConfiguracionUsuario configuracionusuario)
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
        
        btn_Cancelar.setBackground(Color2);
        btn_Cancelar.setForeground(Color1);
        
        Border border = BorderFactory.createLineBorder(Color.white, 1); // 2 es el grosor del borde
        //Control_Configuracion.Propiedades customUI = new Control_Configuracion.Propiedades(arrowColor, selectedColor);
        ComboBoxUI customUI = controlconfiguracion.createCustomComboBoxUI(Color3, Color2);
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
        
        DefaultListModel model = new DefaultListModel();
        lista_Resultados.setModel(model);
        
        btn_Eliminar.setVisible(false);
        btn_Eliminar.setBackground(Color5);
        btn_Eliminar.setForeground(Color1);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setPreferredSize(new java.awt.Dimension(480, 295));

        SubPanel.setBackground(new java.awt.Color(204, 255, 255));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Eliminar Empleado");

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
                                .addComponent(lbl_Busqueda))
                            .addGroup(SubPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
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
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


//////////////////////////////////////////////////////////////////////////////////////////////////////
//Cambia el modo de busqueda    
    private void cmb_TipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TipoItemStateChanged
        int Tipo = cmb_Tipo.getSelectedIndex();
        
        if (Tipo == 0) lbl_Busqueda.setText("ID");
        else lbl_Busqueda.setText("Nombre");
    }//GEN-LAST:event_cmb_TipoItemStateChanged

    
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Hace una busqueda en tiempo real la teclear en el txt_Busqueda
    private void txt_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyReleased
        int Tipo = cmb_Tipo.getSelectedIndex();
        
        //Busqueda con el nombre
        if (Tipo == 1) 
        {
            String Nombre = txt_Busqueda.getText().trim();

            if (!Nombre.isEmpty()) 
            {
                SwingWorker<DefaultListModel<String>, Void> worker = new SwingWorker<DefaultListModel<String>, Void>() 
                {
                    @Override
                    protected DefaultListModel<String> doInBackground() throws Exception 
                    {
                        Control_Empleado controlempleado = new Control_Empleado();
                        return controlempleado.consultaConNombre(Nombre);
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
                            Control_Empleado controlempleado = new Control_Empleado();
                            return controlempleado.consultaConID(Codigo);
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

//////////////////////////////////////////////////////////////////////////////////////////////////////
//Prepara un regitro para pa ser eliminado de la base de datos al ser clickeado
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
                }
                
                String Seleccion = lista_Resultados.getSelectedValue();
                txt_Busqueda.setText(Seleccion);
                btn_Eliminar.setVisible(true);
            }
        }
    }//GEN-LAST:event_lista_ResultadosMouseClicked

//////////////////////////////////////////////////////////////////////////////////////////////////////
//Elimina el registro seleccionado de la base de datos
    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        // Obtener el elemento seleccionado de la lista
        String selectedItem = lista_Resultados.getSelectedValue();//.toString();

        // Extraer el ID del elemento seleccionado
        int startIndex = selectedItem.indexOf("ID Empleado: ") + 13; // Añadir 13 para saltar la parte "ID Producto: "
        int endIndex = selectedItem.indexOf(")", startIndex);
        
        String idString = selectedItem.substring(startIndex, endIndex);
        int ID = Integer.parseInt(idString.trim());

        // Extraer el nombre del elemento seleccionado
        String Nombre = selectedItem.substring(0, startIndex - 15); // Restar 15 para eliminar " (ID Producto: X)" del nombre

        Control_Sonido controlsonido = new Control_Sonido();
        controlsonido.reproducirSonidoError1();
        
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el Empelado " + Nombre + "?", "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) 
        {
            Control_Empleado controlempleado = new Control_Empleado();
            controlempleado.eliminarEmpleado(ID);
            
            DefaultListModel model = new DefaultListModel();
            lista_Resultados.setModel(model);
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
