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
import java.time.LocalDate;
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

public class Panel_Administracion_Ganancias extends javax.swing.JPanel 
{
    ConfiguracionUsuario configuracionUsuario;
    
    public Panel_Administracion_Ganancias(ConfiguracionUsuario configuracion) 
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
        Tema tema;
        
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
        
        panel_Grafica.setBackground(color2);
        panel_Ganancias.setBackground(color2);
        
        this.setBackground(color4);
        
        ComboBoxUI customUI = controlConfiguracion.createCustomComboBoxUI(color3, color2);
        cmb_Periodo.setUI(customUI);
        cmb_Periodo.setForeground(color1);
    }    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear la Estructura de la Grafica    
    public void crearEstructuraDatos()
    {
        Control_Administracion controlAdministracion = new Control_Administracion();
        ArrayList fechas = new ArrayList();
        ArrayList datos = new ArrayList();
        LocalDate[] periodo;
        
        int Tipo = cmb_Periodo.getSelectedIndex();
        
        if (Tipo == 0)
        {
            periodo = controlAdministracion.calcularPeriodoSemanal();
            datos = controlAdministracion.crearModeloGananciasDiarias(periodo);
            fechas = controlAdministracion.crearModeloDiasSemana(periodo);
            crearGrafica(datos, fechas);
            
            datos.clear();
            fechas.clear();
        }
        
        else
        {
            periodo = controlAdministracion.calcularPeriodoAnual();
            datos = controlAdministracion.crearModeloGananciasMensuales(periodo);
            fechas = controlAdministracion.crearModeloFechasAno(periodo);
            crearGrafica(datos, fechas);
            
            datos.clear();
            fechas.clear();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para crear la Grafica
    public void crearGrafica(ArrayList<Float> datos, ArrayList<String> fechas) 
    {
        DefaultCategoryDataset datosGrafica = new DefaultCategoryDataset();

        int tamano = datos.size();
        for (int i = 0; i < tamano; i++)
        {
            datosGrafica.addValue(datos.get(i), "Ganancias", fechas.get(i));
        }

        JFreeChart Grafica = ChartFactory.createBarChart("", "", "Utilidades", datosGrafica, PlotOrientation.HORIZONTAL, false, false, false);
        aplicarTemaGrafica(Grafica);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Aplicar el Tema a la Grafica    
    public void aplicarTemaGrafica(JFreeChart grafica)
    {
        Control_Configuracion controlConfiguracion = new Control_Configuracion();
        Tema tema;
        
        int IdTema = configuracionUsuario.getTema();
        tema = controlConfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        Color color3 = Color.decode(tema.getColor3());
        Color color4 = Color.decode(tema.getColor4());
        Color color5 = Color.decode(tema.getColor5());
        
        //Declaracion de las fuentes
        Font subTitulo = new Font("Segoe UI", Font.PLAIN, 11);
        Font dato = new Font("Segoe UI", Font.PLAIN, 11);
        
        //Declaracion del plot
        CategoryPlot plot = (CategoryPlot) grafica.getPlot();
        
        //Configuracion de las barras
        BarRenderer renderer = new BarRenderer();
        renderer.setShadowVisible(false); //Se desactiva la sombra de las barras
        renderer.setSeriesPaint(0, color3); //Cambia el color de las barras
        renderer.setBarPainter(new StandardBarPainter()); //Crea un nuvo estilo para las barras
        renderer.setSeriesPaint(0, color3); //Se le quita el degradado
        plot.setRenderer(renderer); //Se le agregan las nuevas barras al plot
        
        //Configuracion del eje X
        ValueAxis rangeAxis = plot.getRangeAxis(0);
        rangeAxis.setAxisLinePaint(color1); //Cambia el color de la linea del eje X
        rangeAxis.setLabelFont(subTitulo); //Cambia la fuente del titulo del eje X
        rangeAxis.setLabelPaint(color1); //Cambia el color del titulo del eje X
        rangeAxis.setTickLabelPaint(color1); //Cambia el color de los datos del eje X
        rangeAxis.setTickLabelFont(dato); //Cambia la fuente de los datos del eje X
        
        //Configuracion del eje Y
        CategoryAxis domainAxis = plot.getDomainAxis(); 
        domainAxis.setAxisLinePaint(color1); //Cambia el color de la linea del eje Y
        domainAxis.setLabelFont(subTitulo); //Cambia la fuente del titulo del eje Y
        domainAxis.setLabelPaint(color1); //Cambia el color del titulo del eje Y
        domainAxis.setTickLabelFont(dato); //Cambia la fuente de los datos del eje Y
        domainAxis.setTickLabelPaint(color1); // Cambia el color de los datos del eje Y
        
        //Configuracion del plot
        plot.setRangeGridlinePaint(color1); //Cambia el color de las lineas divisoras
        plot.setBackgroundPaint(color2); //Cambia el fondo del plot
        plot.setOutlinePaint(color3); //Cambia el color del borde de la grafica
        
        //Configuracion de la grafica
        grafica.setBackgroundPaint(color2); //Cambia color de fondo de la grafica
        grafica.setBorderPaint(color1); //Cambia el color del borde
        
        //Mostrar Grafica
        ChartPanel panelGrafica = new ChartPanel(grafica);
        panelGrafica.setPreferredSize(new Dimension(374, 221));
        
        panel_Grafica.setLayout(new BorderLayout());
        panel_Grafica.add(panelGrafica, BorderLayout.CENTER);

        // Hacer que el panel se redibuje
        panel_Grafica.revalidate();
        panel_Grafica.repaint();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Ganancias = new javax.swing.JPanel();
        lbl_Ganancias = new javax.swing.JLabel();
        lbl_Periodo = new javax.swing.JLabel();
        cmb_Periodo = new javax.swing.JComboBox<>();
        ScrollPane = new javax.swing.JScrollPane();
        panel_Grafica = new javax.swing.JPanel();

        panel_Ganancias.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Ganancias.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Ganancias.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Ganancias.setText("Ganacias");

        lbl_Periodo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Periodo.setText("Tipo de Análisis");

        cmb_Periodo.setBackground(new java.awt.Color(255, 255, 255));
        cmb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis Semanal", "Análisis Mensual" }));
        cmb_Periodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_PeriodoItemStateChanged(evt);
            }
        });

        panel_Grafica.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout panel_GraficaLayout = new javax.swing.GroupLayout(panel_Grafica);
        panel_Grafica.setLayout(panel_GraficaLayout);
        panel_GraficaLayout.setHorizontalGroup(
            panel_GraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        panel_GraficaLayout.setVerticalGroup(
            panel_GraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        ScrollPane.setViewportView(panel_Grafica);

        javax.swing.GroupLayout panel_GananciasLayout = new javax.swing.GroupLayout(panel_Ganancias);
        panel_Ganancias.setLayout(panel_GananciasLayout);
        panel_GananciasLayout.setHorizontalGroup(
            panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane)
                    .addGroup(panel_GananciasLayout.createSequentialGroup()
                        .addGroup(panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Ganancias)
                            .addGroup(panel_GananciasLayout.createSequentialGroup()
                                .addComponent(lbl_Periodo)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_GananciasLayout.setVerticalGroup(
            panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Ganancias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_GananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Periodo)
                    .addComponent(cmb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Ganancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Ganancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Evento para Cambiar de tipo de Grafica
    private void cmb_PeriodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_PeriodoItemStateChanged
        panel_Grafica.removeAll();
        crearEstructuraDatos();
    }//GEN-LAST:event_cmb_PeriodoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JComboBox<String> cmb_Periodo;
    private javax.swing.JLabel lbl_Ganancias;
    private javax.swing.JLabel lbl_Periodo;
    private javax.swing.JPanel panel_Ganancias;
    private javax.swing.JPanel panel_Grafica;
    // End of variables declaration//GEN-END:variables
}
