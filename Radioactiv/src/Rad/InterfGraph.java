
package Rad;
//change
import javax.swing.JSlider;
import javax.swing.JTable;
import Rad.MyTableModel_1;


import java.util.EventListener;

import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author ENZO
 */

public class InterfGraph extends javax.swing.JFrame {

    /** Creates new form InterfGraph */
    public InterfGraph() {
        initComponents();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    private void initComponents() {//GEN-BEGIN:initComponents

        menuInit = new javax.swing.JPopupMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        Play = new javax.swing.JToggleButton();
        Stop = new javax.swing.JToggleButton();
        Pause = new javax.swing.JToggleButton();
        jSlideVitesse = new JSlider(JSlider.HORIZONTAL,1, 100000000, 1000);
        ElementsTable = new javax.swing.JScrollPane();
        jTable1 = new JTable(new MyTableModel_1());
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        jPanel1.setBounds(30, 30, 580, 440);
        jDesktopPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Play.setText("Commencer la Simulation");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        Play.setBounds(40, 600, 152, 21);
        jDesktopPane1.add(Play, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Stop.setText("Fin");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        Stop.setBounds(370, 600, 90, 21);
        jDesktopPane1.add(Stop, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Pause.setText("Pause/Reprendre");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });
        Pause.setBounds(220, 600, 118, 21);
        jDesktopPane1.add(Pause, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSlideVitesse.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlideVitesseStateChanged(evt);
            }
        });
        jSlideVitesse.setBounds(20, 660, 1330, 16);
        jDesktopPane1.add(jSlideVitesse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.getTableHeader().setReorderingAllowed(false);
        ElementsTable.setViewportView(jTable1);
        //Princip.jtabToPrint(jTable1); //test

        ElementsTable.setBounds(640, 30, 720, 580);
        jDesktopPane1.add(ElementsTable, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(20, 520, 55, 21);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.setBounds(140, 630, 830, 20);
        jDesktopPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Temps Ecoul�");
        jLabel1.setBounds(50, 630, 80, 20);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }//GEN-END:initComponents

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        Princip.playButton();
    }//GEN-LAST:event_PlayActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        Princip.stopButton();
    }//GEN-LAST:event_StopActionPerformed

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        Princip.pauseButton();
    }//GEN-LAST:event_PauseActionPerformed

    private void jSlideVitesseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlideVitesseStateChanged
        // TODO add your handling code here:
        JSlider source = jSlideVitesse;
            if (!source.getValueIsAdjusting()) {
                double Vit = (double)source.getValue()/1000;
                Princip.setdelay((int)((Vit)*Princip.getdelay()));
                    
                }
            
        
    }//GEN-LAST:event_jSlideVitesseStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Princip.testButton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JScrollPane ElementsTable;
    private javax.swing.JToggleButton Pause;
    private javax.swing.JToggleButton Play;
    private javax.swing.JToggleButton Stop;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlideVitesse;
    protected static javax.swing.JTable jTable1;
    protected static javax.swing.JTextField jTextField1;
    private javax.swing.JPopupMenu menuInit;
    // End of variables declaration//GEN-END:variables

    public static void setjTable1(){
        //clearTable(jTable1);
        //test Princip.jtabToPrint(jTable1);
        fillTable(jTable1);
        refreshTab();
    }
    
    public static JTable getjTable1(){
        return jTable1;
    }
    
    public static void refreshTab(){
        jTable1.revalidate();
        
    }
    
    public static void textsetjTextField1(String t){
        jTextField1.setText(t);
    }
    
    public static void fillTable( JTable table) {
        for (int i = 0; i < table.getRowCount(); i++){
          for(int j = 0; j < table.getColumnCount(); j++) {
              table.setValueAt(Princip.gettabElem()[i][j], i, j);
          }
       }
    }
    
    public static void clearTable( JTable table) {
        for (int i = 0; i < table.getRowCount(); i++){
          for(int j = 0; j < table.getColumnCount(); j++) {
              table.setValueAt("", i, j);
          }
       }
    }

    public void tableChanged(TableModelEvent e) {
        /*
         * Les 2 colonnes modifiables sont la 1: affiche et la 8, popini, modifiable avant le d�marrage.
         * dans 1, la valeur est boolean, dans 8 enti�re.
         * on met a jour les valeurs dans l'arraylist, puis on recr�e le tableau.
         * TODO: voir si on ne peut pas changer les valeurs du tableau plutot que refaire le tableau
         */
            int row = e.getFirstRow();
            int column = e.getColumn();
            MyTableModel_1 model = ( MyTableModel_1)e.getSource();
            String columnName = model.getColumnName(column);
            Object data = model.getValueAt(row, column);
            
            switch(column){
            case 1: {
                        boolean value=(Boolean) data;
                        if(Princip.searchAfficheTrue()!=-1){
                            At prov=Princip.getElemListeElem(row);
                            prov.setaffiche(false);
                            Princip.setElemListeElem(row,prov);
                        }
                    At prov2=Princip.getElemListeElem(row);
                    prov2.setaffiche(true);
                    Princip.setElemListeElem(row,prov2);
                }break;
                case 8: {
                            int value= (Integer) data;
                        At prov=Princip.getElemListeElem(row);
                        prov.setpopIni(value);
                        Princip.setElemListeElem(row,prov);
                    }break;
               
            }
            Princip.majTabElem();
            
        }
}
