//Este Codigo ya fue Optimizado
package Windows.Panels.MenuConfiguracion;

import Controllers.Control_Configuracion;
import Models.ConfiguracionUsuario;
import Models.Empleado;
import Models.Tema;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_Preferencias;
import Windows.Dialogs.MenuConfiguracion.Dialog_Configuracion_Usuario;
import java.awt.Color;

/**
 *
 * @author César Eduardo
 */

public class Panel_Configuracion_Usuario extends javax.swing.JPanel 
{    
    private Empleado empleado;
    private Dialog_Configuracion_Preferencias dialog;
    private ConfiguracionUsuario configuracion;
    
    //Constructor para instanciar la clase normalmente
    public Panel_Configuracion_Usuario(ConfiguracionUsuario configuracionusuario, Empleado usuario)
    {
        initComponents();
        empleado = usuario;
        configuracion = configuracionusuario;
        aplicarTema(configuracionusuario, usuario);
        cargarDatos(usuario);
    }
    
    
    //Constructor para instanciar la clase desde un JDialog
    public Panel_Configuracion_Usuario(ConfiguracionUsuario configuracionusuario, Empleado usuario, Dialog_Configuracion_Usuario dialog) 
    {
        initComponents();
        empleado = usuario;
        configuracion = configuracionusuario;
        aplicarTema(configuracionusuario, usuario);
        cargarDatos(usuario);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Aplicar el Tema a la Interfaz
    public void aplicarTema(ConfiguracionUsuario configuracionUsuario, Empleado empleado)
    {
        Control_Configuracion controlConfiguracion = new Control_Configuracion();
        Tema tema;
        
        int IdTema = configuracionUsuario.getTema();
        tema = controlConfiguracion.cargarTema(IdTema);

        Color color1 = Color.decode(tema.getColor1());
        Color color2 = Color.decode(tema.getColor2());
        
        lbl_ID.setForeground(color1);
        lbl_Puesto.setForeground(color1);
        lbl_Nombre.setForeground(color1);
        lbl_Informacion.setForeground(color1);
        
        this.setBackground(color2);
        panel_Interfaz.setBackground(color2);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Mostrar la Informacion del Empleado
    public void cargarDatos(Empleado usuario)
    {
        lbl_Nombre.setText("Nombre: " + usuario.getNombre_Empleado());
        lbl_ID.setText("Identificacion: " + usuario.getID_Empleado());
        
        int puesto = usuario.getPuesto();
        
        switch (puesto)
        {
            case 0: lbl_Puesto.setText("Puesto: Vendedor"); break;
            case 1: lbl_Puesto.setText("Puesto: Gerente"); break;
            case 2: lbl_Puesto.setText("Puesto: Jefe"); break;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Interfaz = new javax.swing.JPanel();
        lbl_Informacion = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_ID = new javax.swing.JLabel();
        lbl_Puesto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(320, 357));
        setLayout(new java.awt.GridBagLayout());

        panel_Interfaz.setBackground(new java.awt.Color(255, 255, 255));
        panel_Interfaz.setFocusCycleRoot(true);
        panel_Interfaz.setFocusTraversalPolicyProvider(true);
        panel_Interfaz.setNextFocusableComponent(panel_Interfaz);

        lbl_Informacion.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_Informacion.setForeground(new java.awt.Color(0, 3, 24));
        lbl_Informacion.setText("Información de Usuario");

        lbl_Nombre.setText("Nombre:");

        lbl_ID.setText("Identificacion:");

        lbl_Puesto.setText("Puesto:");

        javax.swing.GroupLayout panel_InterfazLayout = new javax.swing.GroupLayout(panel_Interfaz);
        panel_Interfaz.setLayout(panel_InterfazLayout);
        panel_InterfazLayout.setHorizontalGroup(
            panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_InterfazLayout.createSequentialGroup()
                        .addComponent(lbl_Informacion)
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(panel_InterfazLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ID)
                            .addComponent(lbl_Nombre)
                            .addComponent(lbl_Puesto))
                        .addContainerGap(190, Short.MAX_VALUE))))
        );
        panel_InterfazLayout.setVerticalGroup(
            panel_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_InterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Informacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_ID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Puesto)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        add(panel_Interfaz, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_Informacion;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Puesto;
    private javax.swing.JPanel panel_Interfaz;
    // End of variables declaration//GEN-END:variables
}
