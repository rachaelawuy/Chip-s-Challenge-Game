/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author rachae
 */
public class ChipsGame extends javax.swing.JFrame implements ActionListener{

    Board b;
    Timer timer;
    String fileName;
    int level;
    /**
     * Creates new form ChipsGame
     */
    public ChipsGame() throws FileNotFoundException {
        this.fileName="src\\level 1.txt";
        level=1;
        this.b= new Board(fileName);
        this.getContentPane().add(b);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 338);
        this.setResizable(false);
        this.setVisible(true);
        timer= new Timer(200,this);
        timer.start();
        initComponents();
        labelSisaChip.setText(b.getAmountOfIC()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLevel = new javax.swing.JLabel();
        labelChip = new javax.swing.JLabel();
        labelLeft = new javax.swing.JLabel();
        labelPenunjukLevel = new javax.swing.JLabel();
        labelSisaChip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setPreferredSize(new java.awt.Dimension(460, 338));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        labelLevel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLevel.setText("LEVEL");

        labelChip.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelChip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChip.setText("Chips");

        labelLeft.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLeft.setText("left");

        labelPenunjukLevel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelPenunjukLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPenunjukLevel.setText("1");

        labelSisaChip.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSisaChip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSisaChip.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(388, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSisaChip, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPenunjukLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChip, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPenunjukLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelChip)
                .addGap(1, 1, 1)
                .addComponent(labelLeft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSisaChip, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            b.play(2);
        } else if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            b.play(4);
        } else if(evt.getKeyCode()==KeyEvent.VK_UP){
            b.play(8);
        } else {
            b.play(6);
        }
        labelSisaChip.setText(b.getAmountOfIC()-b.getPlayer().getIcTaken()+"");
        if(b.getPlayer().isFinish()){
            JOptionPane.showMessageDialog(null, "Level "+level+" selesai!");
            nextLevel();
        }
        if(!b.getPlayer().getStatus()){
            JOptionPane.showMessageDialog(null, "Kurang Beruntung");
        }
    }//GEN-LAST:event_formKeyPressed
    
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
            java.util.logging.Logger.getLogger(ChipsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChipsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChipsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChipsGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChipsGame().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ChipsGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelChip;
    private javax.swing.JLabel labelLeft;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelPenunjukLevel;
    private javax.swing.JLabel labelSisaChip;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    
    public void nextLevel(){
        level+=1;
        if(level<3){
            fileName="src\\level "+level+".txt";
            System.out.println(fileName);
            b.addLevel(fileName);
            repaint();
            labelSisaChip.setText(b.getAmountOfIC()+"");
        }
    }
}
