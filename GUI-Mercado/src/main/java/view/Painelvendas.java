package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Controller.ProdutoControl;
import Model.Produtos;
import app.Connection.ProdutosDAO;

public class PainelVendas extends JPanel {

   
   private JTextField codigoField;
   

    private JButton apagar;
    private JButton adicionar;
    private JButton  validar;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Produtos> produtos;
    private JTextField cpfField;


    public PainelVendas() {
        // Initialize components
       
        codigoField = new JTextField(10);
        cpfField = new JTextField(10);
        
        apagar = new JButton("Apagar");
        adicionar = new JButton("Adicionar");
        validar = new JButton("Validar");

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        // Add components to the panel
        
        add(new JLabel("Cpf:"));
        add(cpfField);
        add(validar);
        add(new JLabel("Código de Barra:"));
        add(codigoField);
        add(adicionar);
        add(apagar);
        add(new JScrollPane(table));  // Add a JScrollPane for the table

        // Action listeners for buttons
        

        

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProdutoControl operacoes = new ProdutoControl(produtos, tableModel, table);
                    int escolha = JOptionPane.showConfirmDialog(null, "Deseja Apagar?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (escolha == JOptionPane.YES_OPTION) {
                        operacoes.apagar(codigoField.getText());
                        limparCampos();
                        atualizarTabela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PainelVendas.this,
                            "Erro ao apagar dados no banco de dados: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void limparCampos() {
        codigoField.setText("");
        cpfField.setText("");
    
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            tableModel.addRow(new Object[]{
                    produto.getCodBarra(),
                    produto.getQuantiProduto(),
                    produto.getNomeProduto(),
                    produto.getValor()
            });
        }
    }
}
