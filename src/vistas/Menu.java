
package vistas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import laboratoriofinal.mx.com.gm.peliculas.datos.AccesoDatosImpl;
import laboratoriofinal.mx.com.gm.peliculas.excepciones.AccesoDatosEx;


public class Menu extends javax.swing.JFrame {
    private static final String NOMBRE_ARCHIVO="C:\\LabFinal\\laboratorioFinal\\fileTxtpeliculas.txt";
    AccesoDatosImpl datos =new AccesoDatosImpl();
   
    public Menu() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemInicializar = new javax.swing.JMenuItem();
        itemAgregarPelicula = new javax.swing.JMenuItem();
        itemListarPeliculas = new javax.swing.JMenuItem();
        itemBuscarPelicula = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        menuopAcerca = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Mantenedor Peliculas");

        itemInicializar.setText("Iniciar Catalogo");
        itemInicializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInicializarActionPerformed(evt);
            }
        });
        jMenu1.add(itemInicializar);

        itemAgregarPelicula.setText("Agregar Pelicula");
        itemAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarPeliculaActionPerformed(evt);
            }
        });
        jMenu1.add(itemAgregarPelicula);

        itemListarPeliculas.setText("Listar Peliculas");
        itemListarPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListarPeliculasActionPerformed(evt);
            }
        });
        jMenu1.add(itemListarPeliculas);

        itemBuscarPelicula.setText("Buscar Pelicula");
        jMenu1.add(itemBuscarPelicula);

        itemSalir.setText("Salir");
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);

        menuopAcerca.setText("Acerca de");
        jMenuBar1.add(menuopAcerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarPeliculaActionPerformed
        new AgregarPelicula().setVisible(true);
    }//GEN-LAST:event_itemAgregarPeliculaActionPerformed

    private void itemInicializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInicializarActionPerformed
        try {
            boolean res=datos.existe(NOMBRE_ARCHIVO);
            
           if (res==false){ 
            datos.crear(NOMBRE_ARCHIVO);
            JOptionPane.showMessageDialog(null,"El archivo ha sido creado con exito");
           }else {
               JOptionPane.showMessageDialog(null,"El archivo ya existe");
           } 
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemInicializarActionPerformed

    private void itemListarPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListarPeliculasActionPerformed
        new ListarPeliculas().setVisible(true);
        
    }//GEN-LAST:event_itemListarPeliculasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAgregarPelicula;
    private javax.swing.JMenuItem itemBuscarPelicula;
    private javax.swing.JMenuItem itemInicializar;
    private javax.swing.JMenuItem itemListarPeliculas;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuopAcerca;
    // End of variables declaration//GEN-END:variables
}
