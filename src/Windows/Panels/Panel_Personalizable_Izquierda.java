package Windows.Panels;

import Models.ConfiguracionUsuario;

/**
 *
 * @author César Eduardo
 */
public class Panel_Personalizable_Izquierda extends javax.swing.JPanel {

    public Panel_Personalizable_Izquierda(ConfiguracionUsuario configuracionusuario) 
    {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Vender = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        Panel_Vender.setBackground(new java.awt.Color(0, 3, 24));

        javax.swing.GroupLayout Panel_VenderLayout = new javax.swing.GroupLayout(Panel_Vender);
        Panel_Vender.setLayout(Panel_VenderLayout);
        Panel_VenderLayout.setHorizontalGroup(
            Panel_VenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        Panel_VenderLayout.setVerticalGroup(
            Panel_VenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(Panel_Vender, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Vender;
    // End of variables declaration//GEN-END:variables
}
