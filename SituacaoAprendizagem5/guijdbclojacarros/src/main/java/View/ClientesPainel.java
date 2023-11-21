package main.java.View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.java.Connection.ClientesDAO;
import main.java.Controller.ClientesControl;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.Model.Clientes;

public class ClientesPainel extends JPanel {
    // Atributos
    private JButton cadastrar, apagar, editar;
    private JTextField clienteNomeField, clienteIdadeField, clienteSexoField, clienteRgField, clienteCpfField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor
    public ClientesPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Nome:"));
        clienteNomeField = new JTextField(20);
        inputPanel.add(clienteNomeField);

        inputPanel.add(new JLabel("Idade:"));
        clienteIdadeField = new JTextField(20);
        inputPanel.add(clienteIdadeField);

        inputPanel.add(new JLabel("Sexo:"));
        clienteSexoField = new JTextField(20);
        inputPanel.add(clienteSexoField);

        inputPanel.add(new JLabel("Rg:"));
        clienteRgField = new JTextField(20);
        inputPanel.add(clienteRgField);

        inputPanel.add(new JLabel("Cpf:"));
        clienteCpfField = new JTextField(20);
        inputPanel.add(clienteCpfField);
        add(inputPanel);

        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Salvar Edição"));
        botoes.add(apagar = new JButton("Salvar Exclusão"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Idade", "Sexo", "Rg", "Cpf" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela se ela não existir
        new ClientesDAO().criaTabela();
        // Atualizar a Tabela na Abertura da Janela
        atualizarTabela();

        // Tratamento de Eventos (Construtor)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    clienteNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    clienteIdadeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    clienteSexoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    clienteRgField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    clienteCpfField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);
        // Configura o metodo "cadastrar" do objeto operacoes com Cpfes dos campos de
        // entrada

        cadastrar.addActionListener(e -> {

            String rgText = clienteSexoField.getText();
            String cpfText = clienteCpfField.getText();
            String idadeText = clienteIdadeField.getText();

            boolean camposCadastroVazio = clienteNomeField.getText().isEmpty() || clienteIdadeField.getText().isEmpty()
                    || clienteRgField.getText().isEmpty();

            if ((!rgText.isEmpty() && !cpfText.isEmpty())) {
                try {
                    int rg = Integer.parseInt(rgText);
                    int cpf = Integer.parseInt(cpfText);
                    int idade = Integer.parseInt(idadeText);

                    if (camposCadastroVazio) {
                        JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida",
                                2);
                    } else if (idade > 18) {
                        JOptionPane.showMessageDialog(null, "É Necessário ter 18 Anos para Registrar o Cadastro", "Informação Inválida",
                                2);
                    } else {
                        operacoes.cadastrar(clienteNomeField.getText(), clienteIdadeField.getText(), clienteSexoField.getText(),
                                clienteRgField.getText(), clienteCpfField.getText());

                        // Limpa os campos de entrada após a operação de exclusão
                        clienteNomeField.setText("");
                        clienteIdadeField.setText("");
                        clienteSexoField.setText("");
                        clienteRgField.setText("");
                        clienteCpfField.setText("");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida", 2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida", 2);
            }
        });

        // Configura a ação do botão editar
        editar.addActionListener(e -> {
            // Chama o metodo "editar" do objeto operacoes com os Cpfes dos campos de
            // entrada
            String rgText = clienteRgField.getText();
            String cpfText = clienteCpfField.getText();
            String idadeText = clienteIdadeField.getText();

            boolean camposCadastroVazio = clienteNomeField.getText().isEmpty() || clienteIdadeField.getText().isEmpty()
                    || clienteRgField.getText().isEmpty();

            if ((!rgText.isEmpty() && !cpfText.isEmpty())) {
                try {
                    int rg = Integer.parseInt(rgText);
                    int cpf = Integer.parseInt(cpfText);
                    int idade = Integer.parseInt(idadeText);

                    if (camposCadastroVazio) {
                        JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida",
                                2);
                    } else if (idade > 18) {
                        JOptionPane.showMessageDialog(null, "É Necessário ter 18 Anos para Registrar o Cadastro", "Informação Inválida",
                                2);
                    }
                    
                    else {
                        operacoes.atualizar(clienteNomeField.getText(), clienteIdadeField.getText(), clienteSexoField.getText(),
                                clienteRgField.getText(), clienteCpfField.getText());
                        // Limpa os campos de entrada após a operação de edição
                        clienteNomeField.setText("");
                        clienteIdadeField.setText("");
                        clienteSexoField.setText("");
                        clienteRgField.setText("");
                        clienteCpfField.setText("");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida", 2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente", "Informação Inválida", 2);
            }

        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {

            // Chama o método "apagar" do objeto operacoes com o Cpf do campo de entrada
            // "Rg"

            boolean camposCadastroVazio = clienteNomeField.getText().isEmpty() || clienteIdadeField.getText().isEmpty()
                    || clienteRgField.getText().isEmpty();

            if (camposCadastroVazio) {
                JOptionPane.showMessageDialog(null, "Não é possível dados vazios", "Informação Inválida",
                        2);
            } else if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse carro?",
                    "Excluindo Tarefa...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                operacoes.apagar(clienteRgField.getText());

                // Limpa os campos de entrada após a operação de exclusão
                clienteNomeField.setText("");
                clienteIdadeField.setText("");
                clienteSexoField.setText("");
                clienteRgField.setText("");
                clienteCpfField.setText("");

            }
        });

    };

    // Métodos (Atualizar Tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos();
        // Obtém os Clientes atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getIdade(),

                    cliente.getSexo(), cliente.getRg(), cliente.getCpf() });
        }
    }
}