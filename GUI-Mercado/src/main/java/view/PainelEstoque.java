package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Controller.ProdutoControl;
import Model.Produtos;
import app.Connection.ProdutosDAO;

public class PainelEstoque extends JPanel {

   
    private JTextField codigoField;
    private JTextField quantidadeField;
    private JTextField valorField;
    private JTextField nomeProdutoField;
    private JButton cadastrar;
    private JButton editar;
    private JButton apagar;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Produtos> produtos;

    public PainelEstoque() {
        // Initialize components
       
        codigoField = new JTextField(10);
        quantidadeField = new JTextField(10);
        valorField = new JTextField(10);
        nomeProdutoField = new JTextField(10);

        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        // Add components to the panel
        
        add(new JLabel("Código:"));
        add(codigoField);
        add(new JLabel("Quantidade:"));
        add(quantidadeField);
        add(new JLabel("Valor:"));
        add(valorField);
        add(new JLabel("Nome do Produto:"));
        add(nomeProdutoField);
        add(cadastrar);
        add(editar);
        add(apagar);
        add(new JScrollPane(table));  // Add a JScrollPane for the table

        // Action listeners for buttons
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProdutoControl operacoes = new ProdutoControl(produtos, tableModel, table);
                    operacoes.cadastrar(
                           
                            codigoField.getText(),
                            quantidadeField.getText(),
                            valorField.getText(),
                            nomeProdutoField.getText()
                    );
                    limparCampos();
                    atualizarTabela();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PainelEstoque.this,
                            "Erro ao cadastrar: Verifique os campos numéricos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(PainelEstoque.this, "Erro ao cadastrar: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProdutoControl operacoes = new ProdutoControl(produtos, tableModel, table);
                    operacoes.atualizar(
                           
                            codigoField.getText(),
                            quantidadeField.getText(),
                            valorField.getText(),
                            nomeProdutoField.getText()
                    );
                    limparCampos();
                    atualizarTabela();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PainelEstoque.this,
                            "Erro ao atualizar dados no banco de dados: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProdutoControl operacoes = new ProdutoControl(produtos, tableModel, table);
                    int escolha = JOptionPane.showConfirmDialog(null, "Deseja Apagar?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (escolha == JOptionPane.YES_OPTION) {
                        operacoes.apagar(valorField.getText());
                        limparCampos();
                        atualizarTabela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PainelEstoque.this,
                            "Erro ao apagar dados no banco de dados: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void limparCampos() {
       
        codigoField.setText("");
        quantidadeField.setText("");
        valorField.setText("");
        nomeProdutoField.setText("");
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
