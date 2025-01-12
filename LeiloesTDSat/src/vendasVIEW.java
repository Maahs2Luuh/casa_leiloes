
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        carregarProdutosVendidos();  // Carregar os produtos vendidos ao inicializar a tela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("vendasVIEW");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vendas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 18))); // NOI18N

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço", "Status"
            }
        ));
        jScrollPane1.setViewportView(tableVendas);

        jScrollPane2.setViewportView(jScrollPane1);

        btnVoltar.setText("< Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnVoltar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();  // Fecha a janela atual
    }//GEN-LAST:event_btnVoltarActionPerformed

    /*
    "Criada a tela de Vendas para listar produtos vendidos"
    */
    // Método para carregar os produtos vendidos na tabela
    private void carregarProdutosVendidos() {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        ArrayList<ProdutosDTO> produtosVendidos = produtosDAO.listarProdutosVendidos();
        // Obtendo o modelo da tabela
        DefaultTableModel model = (DefaultTableModel) tableVendas.getModel();
        // Limpar a tabela antes de adicionar novos produtos
        model.setRowCount(0);
        // Adicionando os dados dos produtos vendidos na tabela
        for (ProdutosDTO produto : produtosVendidos) {
            Object[] row = new Object[4];
            row[0] = produto.getId();
            row[1] = produto.getNome();
            row[2] = produto.getPreco();
            row[3] = produto.getStatus();
            
            model.addRow(row); // Adicionando a linha à tabela
        }
    }

    public static void main(String args[]) {

         // Exibindo a tela de vendas
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendasVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableVendas;
    // End of variables declaration//GEN-END:variables
}
