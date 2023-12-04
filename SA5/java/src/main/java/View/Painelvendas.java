package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import Controller.ProdutoControl;
import Model.Produtos;
import app.Connection.ProdutosDAO;

public class Painelvendas extends JPanel {

    private JTextField cpfField;
    private JTextField nomeField;
    private JButton cadastrar;
    private JButton editar;
    private JButton apagar;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada;
    private List<Produtos> produtos; // Assuming Produtos is an array type, adjust as needed

    public Painelvendas() {
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Produtos"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("CPF"));
        cpfField = new JTextField(20);
        inputPanel.add(cpfField);
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        add(inputPanel);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes);

        // tabela de produtos
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // criar BD
        new ProdutosDAO().criaTabela();
        // atualizar tabela
        atualizarTabela();

        // tratamento de eventos construtor
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                }
            }
        });

        ProdutoControl operacoes = new ProdutoControl(produtos, tableModel, table);
        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // banco
        // de dados

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operacoes.cadastrar(cpfField.getText(), nomeField.getText());
                    cpfField.setText("");
                    nomeField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Painelvendas.this, "Erro ao cadastrar: O CPF deve ser numérico.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(Painelvendas.this, "Erro ao cadastrar: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Painelvendas.this, "Erro ao cadastrar: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configura a ação do botão "editar" para atualizar um registro no banco de dados
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operacoes.atualizar(cpfField.getText(), nomeField.getText());
                    cpfField.setText("");
                    nomeField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Painelvendas.this,
                            "Erro ao atualizar dados no banco de dados: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int escolha = JOptionPane.showConfirmDialog(null, "Deseja Apagar?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (escolha == JOptionPane.YES_OPTION) {
                        operacoes.apagar(cpfField.getText());
                        cpfField.setText("");
                        nomeField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Painelvendas.this,
                            "Erro ao apagar dados no banco de dados: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            tableModel.addRow(new Object[] { produto.getCpf(), produto.getNomeProduto() });
        }
    }
}
