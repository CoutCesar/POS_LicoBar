//Este Codigo ya fue Optimizado
package Windows.Panels.MenuAdministracion;

import Controllers.Control_Configuracion;
import Controllers.Control_Administracion;
import Models.ConfiguracionUsuario;
import Models.Tema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.plaf.ComboBoxUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author César Eduardo
 */

public class Panel_Administracion_RendimientoProductos extends javax.swing.JPanel 
{
    ConfiguracionUsuario configuracionUsuario;
    
    public Panel_Administracion_RendimientoProductos(ConfiguracionUsuario configuracion) 
    {
        initComponents();
        configuracionUsuario = configuracion;    
        aplicarTema();
        crearEstructuraDatos();
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Aplicar el Tema a la Interfaz
    public void aplicarTema()
    {
        Control_Configuracion controlConfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionUsuario.getTema();
        tema = controlConfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color4 = Color.decode(tema.getColor4());
        
        lbl_Periodo.setForeground(color1);
        lbl_Ganancias.setForeground(color1);
        
        cmb_Periodo.setForeground(color1);
        
        cmb_Periodo.setBackground(color2);
        
        Panel_Grafica.setBackground(color2);
        Panel_Ganancias.setBackground(color2);
        
        this.setBackground(color4);
        
        ComboBoxUI customUI = controlConfiguracion.createCustomComboBoxUI(color3, color2);
        cmb_Periodo.setUI(customUI);
        cmb_Periodo.setForeground(color1);
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Crear la Estructura de la Grafica
    public void crearEstructuraDatos() 
    {
        Control_Administracion controlAdministracion = new Control_Administracion();
        ArrayList<Integer> ventas;
        ArrayList<String> productos;
        ArrayList<Integer> ids;

        int Periodo = cmb_Periodo.getSelectedIndex();

        productos = controlAdministracion.crearModeloNombresProductos();
        ids = controlAdministracion.consultarCodigosProductos();

        if (Periodo == 0) 
        {
            ventas = controlAdministracion.crearModeloVentasDiarias(ids);
            String Tipo = "Ventas de Hoy";
            crearGrafica(ventas, productos, ids, Tipo);
        } 
        
        else if (Periodo == 1) 
        {
            ventas = controlAdministracion.crearModeloVentasSemanales(ids);
            String Tipo = "Ventas de esta Semana";
            crearGrafica(ventas, productos, ids, Tipo);
        } 
        
        else 
        {
            ventas = controlAdministracion.crearModeloVentasMensuales(ids);
            String Tipo = "Ventas de este Mes";
            crearGrafica(ventas, productos, ids, Tipo);
        }
    }   
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo par Crear la Grafica
    public void crearGrafica(ArrayList<Integer> ventas, ArrayList<String> productos, ArrayList<Integer> ids, String nombre) 
    {
        DefaultCategoryDataset datosGrafica = new DefaultCategoryDataset();

        int tamaño = ids.size();
        for (int i = 0; i < tamaño; i++)
        {
            datosGrafica.addValue(ventas.get(i), "Ganancias", productos.get(i));
        }

        JFreeChart grafica = ChartFactory.createBarChart("", "", "Ventas", datosGrafica, PlotOrientation.HORIZONTAL, false, false, false);
        aplicarTemaGrafica(grafica);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Aplicar el Tema a la Grafica
    public void aplicarTemaGrafica(JFreeChart grafica)
    {
        Control_Configuracion controlconfiguracion = new Control_Configuracion();
        Tema tema = new Tema();
        
        int IdTema = configuracionUsuario.getTema();
        tema = controlconfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color4 = Color.decode(tema.getColor4());
        Color color5 = Color.decode(tema.getColor5());
        
        //Declaracion de las fuentes
        Font SubTitulo = new Font("Segoe UI", Font.PLAIN, 11);
        Font Dato = new Font("Segoe UI", Font.PLAIN, 11);
        
        //Declaracion del plot
        CategoryPlot Plot = (CategoryPlot) grafica.getPlot();
        
        //Configuracion de las barras
        BarRenderer renderer = new BarRenderer();
        renderer.setShadowVisible(false); //Se desactiva la sombra de las barras
        renderer.setSeriesPaint(0, color3); //Cambia el color de las barras
        renderer.setBarPainter(new StandardBarPainter()); //Crea un nuvo estilo para las barras
        renderer.setSeriesPaint(0, color3); //Se le quita el degradado
        Plot.setRenderer(renderer); //Se le agregan las nuevas barras al plot
        
        //Configuracion del eje X
        ValueAxis rangeAxis = Plot.getRangeAxis(0);
        rangeAxis.setAxisLinePaint(color1); //Cambia el color de la linea del eje X
        rangeAxis.setLabelFont(SubTitulo); //Cambia la fuente del titulo del eje X
        rangeAxis.setLabelPaint(color1); //Cambia el color del titulo del eje X
        rangeAxis.setTickLabelPaint(color1); //Cambia el color de los datos del eje X
        rangeAxis.setTickLabelFont(Dato); //Cambia la fuente de los datos del eje X
        
        //Configuracion del eje Y
        CategoryAxis domainAxis = Plot.getDomainAxis(); 
        domainAxis.setAxisLinePaint(color1); //Cambia el color de la linea del eje Y
        domainAxis.setLabelFont(SubTitulo); //Cambia la fuente del titulo del eje Y
        domainAxis.setLabelPaint(color1); //Cambia el color del titulo del eje Y
        domainAxis.setTickLabelFont(Dato); //Cambia la fuente de los datos del eje Y
        domainAxis.setTickLabelPaint(color1); // Cambia el color de los datos del eje Y
        
        //Configuracion del plot
        Plot.setRangeGridlinePaint(color1); //Cambia el color de las lineas divisoras
        Plot.setBackgroundPaint(color2); //Cambia el fondo del plot
        Plot.setOutlinePaint(color3); //Cambia el color del borde de la grafica
        
        //Configuracion de la grafica
        grafica.setBackgroundPaint(color2); //Cambia color de fondo de la grafica
        grafica.setBorderPaint(color1); //Cambia el color del borde
        
        
        //Mostrar Grafica
        ChartPanel PanelGrafica = new ChartPanel(grafica);
        //PanelGrafica.setPreferredSize(new Dimension(374, 221));
        PanelGrafica.setPreferredSize(new Dimension(300, PanelGrafica.getPreferredSize().height));
        
        Panel_Grafica.setLayout(new BorderLayout());
        Panel_Grafica.add(PanelGrafica, BorderLayout.CENTER);

        // Hacer que el panel se redibuje
        Panel_Grafica.revalidate();
        Panel_Grafica.repaint();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Ganancias = new javax.swing.JPanel();
        lbl_Ganancias = new javax.swing.JLabel();
        lbl_Periodo = new javax.swing.JLabel();
        cmb_Periodo = new javax.swing.JComboBox<>();
        ScrollPane_Grafica = new javax.swing.JScrollPane();
        Panel_Grafica = new javax.swing.JPanel();

        Panel_Ganancias.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Ganancias.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Ganancias.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Ganancias.setText("Rendimiento de los productos");

        lbl_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Periodo.setText("Tipo de Análisis");

        cmb_Periodo.setBackground(new java.awt.Color(255, 255, 255));
        cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis de hoy", "Análisis Semanal", "Análisis Mensual" }));
        cmb_Periodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_PeriodoItemStateChanged(evt);
            }
        });

        Panel_Grafica.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout Panel_GraficaLayout = new javax.swing.GroupLayout(Panel_Grafica);
        Panel_Grafica.setLayout(Panel_GraficaLayout);
        Panel_GraficaLayout.setHorizontalGroup(
            Panel_GraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        Panel_GraficaLayout.setVerticalGroup(
            Panel_GraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        ScrollPane_Grafica.setViewportView(Panel_Grafica);

        javax.swing.GroupLayout Panel_GananciasLayout = new javax.swing.GroupLayout(Panel_Ganancias);
        Panel_Ganancias.setLayout(Panel_GananciasLayout);
        Panel_GananciasLayout.setHorizontalGroup(
            Panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_GananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_Grafica)
                    .addGroup(Panel_GananciasLayout.createSequentialGroup()
                        .addGroup(Panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Ganancias)
                            .addGroup(Panel_GananciasLayout.createSequentialGroup()
                                .addComponent(lbl_Periodo)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_GananciasLayout.setVerticalGroup(
            Panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_GananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Ganancias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Periodo)
                    .addComponent(cmb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_Grafica)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Ganancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Ganancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento para Cambiar de tipo de Grafica
    private void cmb_PeriodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_PeriodoItemStateChanged
        Panel_Grafica.removeAll();
        crearEstructuraDatos();
    }//GEN-LAST:event_cmb_PeriodoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Ganancias;
    private javax.swing.JPanel Panel_Grafica;
    private javax.swing.JScrollPane ScrollPane_Grafica;
    private javax.swing.JComboBox<String> cmb_Periodo;
    private javax.swing.JLabel lbl_Ganancias;
    private javax.swing.JLabel lbl_Periodo;
    // End of variables declaration//GEN-END:variables
}
