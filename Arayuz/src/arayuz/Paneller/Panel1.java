/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arayuz.Paneller;
import arayuz.Paneller.PanelSecenek1;
/**
 *
 * @author metin
 */
public class Panel1 extends javax.swing.JPanel {

    /**
     * Creates new form Panel1
     */
    public Panel1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secenek1 = new javax.swing.JButton();
        secenek2 = new javax.swing.JButton();
        secenek3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(909, 377));

        secenek1.setText("1.Veri Girişinde Bulun");
        secenek1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secenek1ActionPerformed(evt);
            }
        });

        secenek2.setText("2.Veri Listele");

        secenek3.setText("3.Veri Güncelle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(secenek3, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(secenek2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(secenek1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(secenek1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secenek2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secenek3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void secenek1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secenek1ActionPerformed
        Panel1.this.setVisible(false);
        Panel1.this.setEnabled(false);
    }//GEN-LAST:event_secenek1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton secenek1;
    private javax.swing.JButton secenek2;
    private javax.swing.JButton secenek3;
    // End of variables declaration//GEN-END:variables
}