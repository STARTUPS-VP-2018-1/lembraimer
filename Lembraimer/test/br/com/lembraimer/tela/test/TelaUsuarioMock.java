package br.com.lembraimer.tela.test;

import javax.swing.JOptionPane;

public class TelaUsuarioMock extends javax.swing.JFrame {
    
    private String nomePaciente;
    private String nomeResponsavel;
    private Integer telefoneResponsavel;
    private String endereco;
    private String horarioMedicamento;
    private String lembretes;

    
    
    public TelaUsuarioMock() {
        initComponents();

    }
    
    public TelaUsuarioMock(String nomePaciente, String nomeResponsavel, Integer telefoneResponsavel, String endereco, String horarioMedicamento, String lembretes, String remedio) {
        initComponents();
        this.nomePaciente = nomePaciente;
        this.nomeResponsavel = nomeResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
        this.endereco = endereco;
        this.horarioMedicamento = horarioMedicamento;
        this.lembretes = lembretes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoQuemSouEu = new javax.swing.JButton();
        botaoOndeMoro = new javax.swing.JButton();
        botaoMeusHorarios = new javax.swing.JButton();
        botaoResponsavel = new javax.swing.JButton();
        botaoMeusLembretes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lembraimer");

        botaoQuemSouEu.setText("Quem Sou Eu");
        botaoQuemSouEu.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botaoQuemSouEu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoQuemSouEuActionPerformed(evt);
            }
        });

        botaoOndeMoro.setText("Onde Moro");
        botaoOndeMoro.setMaximumSize(new java.awt.Dimension(95, 23));
        botaoOndeMoro.setMinimumSize(new java.awt.Dimension(95, 23));
        botaoOndeMoro.setPreferredSize(new java.awt.Dimension(97, 23));
        botaoOndeMoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOndeMoroActionPerformed(evt);
            }
        });

        botaoMeusHorarios.setText("Meus Horários");
        botaoMeusHorarios.setPreferredSize(new java.awt.Dimension(97, 23));
        botaoMeusHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMeusHorariosActionPerformed(evt);
            }
        });

        botaoResponsavel.setText("Responsável");
        botaoResponsavel.setPreferredSize(new java.awt.Dimension(97, 23));
        botaoResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoResponsavelActionPerformed(evt);
            }
        });

        botaoMeusLembretes.setText("Meus Lembretes");
        botaoMeusLembretes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botaoMeusLembretes.setMaximumSize(new java.awt.Dimension(101, 23));
        botaoMeusLembretes.setMinimumSize(new java.awt.Dimension(101, 23));
        botaoMeusLembretes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMeusLembretesActionPerformed(evt);
            }
        });

        jLabel1.setText("v0.1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoMeusHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(botaoQuemSouEu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoMeusLembretes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoOndeMoro, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(botaoResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoOndeMoro, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(botaoQuemSouEu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(botaoMeusHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(botaoMeusLembretes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoQuemSouEuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoQuemSouEuActionPerformed
        
        JOptionPane.showMessageDialog(null, "Seu nome é: " + this.nomePaciente); 
    }//GEN-LAST:event_botaoQuemSouEuActionPerformed

    private void botaoMeusLembretesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMeusLembretesActionPerformed
        
        JOptionPane.showMessageDialog(null, "Seus lembretes são " + this.lembretes);
    }//GEN-LAST:event_botaoMeusLembretesActionPerformed

    private void botaoOndeMoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOndeMoroActionPerformed
        
        JOptionPane.showMessageDialog(null, "Sua casa fica na rua " + this.endereco);
    }//GEN-LAST:event_botaoOndeMoroActionPerformed

    private void botaoMeusHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMeusHorariosActionPerformed
        
        JOptionPane.showMessageDialog(null, "Tomar remédio ás " + this.horarioMedicamento);
    }//GEN-LAST:event_botaoMeusHorariosActionPerformed

    private void botaoResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoResponsavelActionPerformed
       
        JOptionPane.showMessageDialog(null, "Seu responsável é " + this.nomeResponsavel + " com o telefone " + this.telefoneResponsavel);
    }//GEN-LAST:event_botaoResponsavelActionPerformed

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
            java.util.logging.Logger.getLogger(TelaUsuarioMock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarioMock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarioMock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarioMock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuarioMock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoMeusHorarios;
    private javax.swing.JButton botaoMeusLembretes;
    private javax.swing.JButton botaoOndeMoro;
    private javax.swing.JButton botaoQuemSouEu;
    private javax.swing.JButton botaoResponsavel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
   
}
