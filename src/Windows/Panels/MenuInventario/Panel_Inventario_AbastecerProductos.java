//Este Codigo ya fue Optimizado
package Windows.Panels.MenuInventario;

import Controllers.Control_Configuracion;
import Controllers.Control_Producto;
import Controllers.Control_Sonido;
import Models.ConfiguracionUsuario;
import Models.Tema;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author César Eduardo
 */

public class Panel_Inventario_AbastecerProductos extends javax.swing.JPanel 
{

    public Panel_Inventario_AbastecerProductos(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
        aplicarTema(configuracionusuario);
        cargarTabla();
    }

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Aplicar el Tema a la Interfaz
    public void aplicarTema(ConfiguracionUsuario configuracionUsuario)
    {
        Control_Configuracion controlConfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionUsuario.getTema();
        tema = controlConfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color4 = Color.decode(tema.getColor4());
        Color color5 = Color.decode(tema.getColor5());

        lbl_Titulo.setForeground(color1);
        lbl_Eliminar.setForeground(color1);
        lbl_Busqueda.setForeground(color1);
        lbl_CodigoSurtir.setForeground(color1);
        lbl_SurtirProducto.setForeground(color1);
        lbl_CantidadSurtir.setForeground(color1);
        lbl_CodigoEliminar.setForeground(color1);
        lbl_CantidadEliminar.setForeground(color1);
        
        txt_Busqueda.setCaretColor(color1);
        txt_CodigoSurtir.setCaretColor(color1);
        txt_CantidadSurtir.setCaretColor(color1);
        txt_CodigoEliminar.setCaretColor(color1);
        txt_CantidadEliminar.setCaretColor(color1);
        
        txt_Busqueda.setForeground(color1);
        txt_CodigoSurtir.setForeground(color1);
        txt_CantidadSurtir.setForeground(color1);
        txt_CodigoEliminar.setForeground(color1);
        txt_CantidadEliminar.setForeground(color1);
        
        btn_Surtir.setForeground(color1);
        lista_Busqueda.setForeground(color1);
        lista_Busqueda.setSelectionForeground(color1);

        lista_Busqueda.setBackground(color2);
        tabla_Busqueda.setBackground(color2);
        
        txt_Busqueda.setBackground(color2);
        txt_CodigoSurtir.setBackground(color2);
        txt_CantidadSurtir.setBackground(color2);
        txt_CodigoEliminar.setBackground(color2);
        txt_CantidadEliminar.setBackground(color2);

        panel_Surtir.setBackground(color2);
        panel_Tabla.setBackground(color2);
        panel_Buscar.setBackground(color2);
        panel_Eliminar.setBackground(color2);
        
        btn_Surtir.setBackground(color3);
        
        txt_Busqueda.setSelectionColor(color3);
        txt_CodigoSurtir.setSelectionColor(color3);
        txt_CantidadSurtir.setSelectionColor(color3);
        txt_CodigoEliminar.setSelectionColor(color3);
        txt_CantidadEliminar.setSelectionColor(color3);
        
        tabla_Busqueda.setSelectionBackground(color3);
        lista_Busqueda.setSelectionBackground(color3);
        
        this.setBackground(color4);
        btn_Eliminar.setBackground(color5);

        
        tabla_Busqueda.setForeground(color1);
        JTableHeader header = tabla_Busqueda.getTableHeader();
        header.setBackground(color3); 
        header.setForeground(color1);
        header.repaint(); 
    }

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Cargar todos los Productos de la base de datos en la tabla
    public void cargarTabla()
    {
        Control_Producto controlProducto = new Control_Producto();
        DefaultTableModel model;
        
        model = controlProducto.cargarProductos();
        tabla_Busqueda.setModel(model);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Resaltar un un Producto en la Tabla
    public void buscarItemTabla(int id) 
    {
        for (int fila = 0; fila < tabla_Busqueda.getRowCount(); fila++) 
        {
            Object valorID = tabla_Busqueda.getValueAt(fila, 0);  // Índice 0 para la columna "ID"

            if (valorID != null && valorID.equals(id)) 
            {
                tabla_Busqueda.changeSelection(fila, 0, false, false);
                tabla_Busqueda.requestFocusInWindow();
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Buscar = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_Busqueda = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_Busqueda = new javax.swing.JList<>();
        panel_Surtir = new javax.swing.JPanel();
        lbl_SurtirProducto = new javax.swing.JLabel();
        lbl_CodigoSurtir = new javax.swing.JLabel();
        txt_CodigoSurtir = new javax.swing.JTextField();
        lbl_CantidadSurtir = new javax.swing.JLabel();
        txt_CantidadSurtir = new javax.swing.JTextField();
        btn_Surtir = new javax.swing.JButton();
        panel_Tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Busqueda = new javax.swing.JTable();
        panel_Eliminar = new javax.swing.JPanel();
        lbl_Eliminar = new javax.swing.JLabel();
        lbl_CodigoEliminar = new javax.swing.JLabel();
        txt_CodigoEliminar = new javax.swing.JTextField();
        lbl_CantidadEliminar = new javax.swing.JLabel();
        txt_CantidadEliminar = new javax.swing.JTextField();
        btn_Eliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(464, 522));

        panel_Buscar.setBackground(new java.awt.Color(153, 153, 153));

        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Titulo.setText("Inventario");

        lbl_Busqueda.setText("Buscar un Producto");

        txt_Busqueda.setMinimumSize(new java.awt.Dimension(0, 0));
        txt_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyReleased(evt);
            }
        });

        lista_Busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_BusquedaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lista_Busqueda);

        javax.swing.GroupLayout panel_BuscarLayout = new javax.swing.GroupLayout(panel_Buscar);
        panel_Buscar.setLayout(panel_BuscarLayout);
        panel_BuscarLayout.setHorizontalGroup(
            panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(lbl_Titulo)
                    .addComponent(lbl_Busqueda)
                    .addComponent(txt_Busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_BuscarLayout.setVerticalGroup(
            panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Busqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        panel_Surtir.setBackground(new java.awt.Color(153, 153, 153));

        lbl_SurtirProducto.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_SurtirProducto.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SurtirProducto.setText("Surtir Producto");

        lbl_CodigoSurtir.setForeground(new java.awt.Color(0, 0, 0));
        lbl_CodigoSurtir.setText("Codigo");

        txt_CodigoSurtir.setMinimumSize(new java.awt.Dimension(0, 0));

        lbl_CantidadSurtir.setForeground(new java.awt.Color(0, 0, 0));
        lbl_CantidadSurtir.setText("Cantidad");

        txt_CantidadSurtir.setMinimumSize(new java.awt.Dimension(0, 0));

        btn_Surtir.setText("Surtir");
        btn_Surtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SurtirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_SurtirLayout = new javax.swing.GroupLayout(panel_Surtir);
        panel_Surtir.setLayout(panel_SurtirLayout);
        panel_SurtirLayout.setHorizontalGroup(
            panel_SurtirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SurtirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_SurtirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_CantidadSurtir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btn_Surtir)
                    .addComponent(lbl_SurtirProducto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_CodigoSurtir, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_CodigoSurtir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_CantidadSurtir, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_SurtirLayout.setVerticalGroup(
            panel_SurtirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SurtirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_SurtirProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_CodigoSurtir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CodigoSurtir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_CantidadSurtir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CantidadSurtir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Surtir)
                .addContainerGap())
        );

        panel_Tabla.setBackground(new java.awt.Color(153, 153, 153));

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
        tabla_Busqueda.setMinimumSize(new java.awt.Dimension(0, 0));
        tabla_Busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_BusquedaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_Busqueda);

        javax.swing.GroupLayout panel_TablaLayout = new javax.swing.GroupLayout(panel_Tabla);
        panel_Tabla.setLayout(panel_TablaLayout);
        panel_TablaLayout.setHorizontalGroup(
            panel_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panel_TablaLayout.setVerticalGroup(
            panel_TablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_Eliminar.setBackground(new java.awt.Color(153, 153, 153));

        lbl_Eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Eliminar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Eliminar.setText("Eliminar Existencias");

        lbl_CodigoEliminar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_CodigoEliminar.setText("Codigo");

        lbl_CantidadEliminar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_CantidadEliminar.setText("Cantidad");

        btn_Eliminar.setBackground(new java.awt.Color(102, 102, 102));
        btn_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_EliminarLayout = new javax.swing.GroupLayout(panel_Eliminar);
        panel_Eliminar.setLayout(panel_EliminarLayout);
        panel_EliminarLayout.setHorizontalGroup(
            panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_EliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Eliminar)
                    .addGroup(panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_CantidadEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(lbl_Eliminar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_CodigoEliminar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_CodigoEliminar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_CantidadEliminar, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_EliminarLayout.setVerticalGroup(
            panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_EliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_CodigoEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CodigoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_CantidadEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CantidadEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Eliminar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Surtir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Surtir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento para realizar busquedas en tiempo real al teclear en el txt_Busqueda
    private void txt_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyReleased
        String busqueda = txt_Busqueda.getText();
        
        Control_Producto controlproducto = new Control_Producto();
        DefaultListModel<String> model;

        try 
        {
            int codigo = Integer.parseInt(busqueda);
            model = controlproducto.consultaConCodigo(codigo);
        } 
        
        catch (NumberFormatException e) 
        {
            model = controlproducto.consultaConNombre(busqueda);
        }
        
        if (busqueda.equals(""))
        {
            model.clear();
        }
        
        lista_Busqueda.setModel(model);
    }//GEN-LAST:event_txt_BusquedaKeyReleased
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento que Resalta en la tabla el Producto que que haya sido clickeado en los resultados de la Busqueda
    private void lista_BusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_BusquedaMouseClicked
        if (evt.getClickCount() == 1) 
        {
            int index = lista_Busqueda.locationToIndex(evt.getPoint());
            if (index >= 0) 
            {
                Object selectedValue = lista_Busqueda.getModel().getElementAt(index);

                // Utilizar una expresión regular para encontrar el valor del ID
                String regex = "ID Producto: (\\d+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(selectedValue.toString());

                if (matcher.find()) 
                {
                    String id = matcher.group(1);
                    int ID = Integer.parseInt(id);
                    txt_CodigoSurtir.setText(String.valueOf(ID));
                    buscarItemTabla(ID);
                }
            }
        }
    }//GEN-LAST:event_lista_BusquedaMouseClicked

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento que Escribe en el txt_CodigoSurtir el Codigo del producto que haya sido Clickeado en la tabla
    //para facilitar el traba al usuario
    private void tabla_BusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_BusquedaMouseClicked
        int filaSeleccionada = tabla_Busqueda.getSelectedRow();

        // Verificamos si se hizo clic en una fila válida
        if (filaSeleccionada != -1) 
        {
            // Obtener el valor de la primera columna (columna del ID)
            Object valorID = tabla_Busqueda.getValueAt(filaSeleccionada, 0);

            // Verificar si el valor es un entero antes de intentar convertirlo
            if (valorID instanceof Integer) 
            {
                String ID = String.valueOf(valorID);
                txt_CodigoSurtir.setText(ID);
                
            } else 
            {
                System.out.println("La columna del ID no contiene un valor válido.");
            }
        }
    }//GEN-LAST:event_tabla_BusquedaMouseClicked

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento para realizar el Proceso para surtir un Producto
    private void btn_SurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SurtirActionPerformed
        Control_Sonido controlsonidos = new Control_Sonido();
        
        try 
        {
            int Codigo = Integer.parseInt(txt_CodigoSurtir.getText());
            int Cantidad = Integer.parseInt(txt_CantidadSurtir.getText());

            Control_Producto controlproducto = new Control_Producto();
            controlproducto.surtirProducto(Codigo, Cantidad);
        } 
        
        catch (NumberFormatException e) 
        {
            controlsonidos.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        catch (Exception e) 
        {
            controlsonidos.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        finally
        {
            txt_CodigoSurtir.setText("");
            txt_CantidadSurtir.setText("");
            cargarTabla();
        }
    }//GEN-LAST:event_btn_SurtirActionPerformed

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento para realizar el Proceso para Desurtir un Producto
    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        Control_Sonido controlsonidos = new Control_Sonido();
        try 
        {
            int Codigo = Integer.parseInt(txt_CodigoEliminar.getText());
            int Cantidad = Integer.parseInt(txt_CantidadEliminar.getText());

            Control_Producto controlproducto = new Control_Producto();
            controlproducto.desurtirProducto(Codigo, Cantidad);
        } 
        
        catch (NumberFormatException e) 
        {
            controlsonidos.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        catch (Exception e) 
        {
            // Manejar otras excepciones que puedan ocurrir
            controlsonidos.reproducirSonidoError1();
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        finally
        {
            txt_CodigoEliminar.setText("");
            txt_CantidadEliminar.setText("");
            cargarTabla();
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Surtir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Busqueda;
    private javax.swing.JLabel lbl_CantidadEliminar;
    private javax.swing.JLabel lbl_CantidadSurtir;
    private javax.swing.JLabel lbl_CodigoEliminar;
    private javax.swing.JLabel lbl_CodigoSurtir;
    private javax.swing.JLabel lbl_Eliminar;
    private javax.swing.JLabel lbl_SurtirProducto;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JList<String> lista_Busqueda;
    private javax.swing.JPanel panel_Buscar;
    private javax.swing.JPanel panel_Eliminar;
    private javax.swing.JPanel panel_Surtir;
    private javax.swing.JPanel panel_Tabla;
    private javax.swing.JTable tabla_Busqueda;
    private javax.swing.JTextField txt_Busqueda;
    private javax.swing.JTextField txt_CantidadEliminar;
    private javax.swing.JTextField txt_CantidadSurtir;
    private javax.swing.JTextField txt_CodigoEliminar;
    private javax.swing.JTextField txt_CodigoSurtir;
    // End of variables declaration//GEN-END:variables
}
