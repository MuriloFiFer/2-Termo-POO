import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoList extends JFrame {
    // atributos
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;
    private Timer doubleClickTimer;

    // construtor
    public TodoList() {
        // Configuração da janela principal (JFrame)
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // Tratamento de Eventos
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });

        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });

        clearCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCompletedTasks();
            }
        });

        // Inicializa a lista de tarefas e atualiza a exibição
        updateTaskList();

        // Exibe a janela
        run();

        taskInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        });
         doubleClickTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
                    Task task = tasks.get(selectedIndex);
                    if (!task.isDone()) {
                        task.setDone(true);
                        updateTaskList();
                    }
                }
            }
        });
        doubleClickTimer.setRepeats(false);

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    doubleClickTimer.restart();
                }
            }
        });
        
    }

    // métodos (crud)
    private void addTask() {
        String description = taskInputField.getText().trim();

        if (!description.isEmpty()) { // Verifica se a descrição não está vazia
            // Crie uma nova tarefa com a descrição inserida
            Task newTask = new Task(description);
            tasks.add(newTask);

            // Atualize a lista de tarefas e limpe o campo de entrada
            updateTaskList();
            taskInputField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Digite uma Tarefa", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
            // Mensagem caso n digite nada na tarefa
        }
    }

   
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();

        if (selectedIndex == -1) {
            // Nenhum item selecionado para excluir
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja excluir esta tarefa?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            // O usuário confirmou a exclusão
            tasks.remove(selectedIndex);
            updateTaskList();
        } else if (option == JOptionPane.NO_OPTION) {
            CustomDialog customDialog = new CustomDialog(this, "Exclusão cancelada", 1000); // Tempo em milissegundos (5 segundos)
            customDialog.setVisible(true);
            // O usuário escolheu não excluir a tarefa, não é necessário fazer nada aqui
        } else {
            // Exibe a janela de diálogo personalizada com um temporizador para fechar
             CustomDialog customDialog = new CustomDialog(this, "Exclusão cancelada", 1000); // Tempo em milissegundos (5 segundos)
            customDialog.setVisible(true);
            
        }
    }

    //
    public class CustomDialog extends JDialog {
        public CustomDialog(JFrame parent, String message, int delay) {
            super(parent, "Confirmação de Exclusão", true);
            
            // Cria uma etiqueta com a mensagem
            JLabel label = new JLabel(message);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(label, BorderLayout.CENTER);
    
            // Cria um temporizador para fechar a janela após um atraso
            Timer timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Fecha a janela de diálogo
                }
            });
            timer.setRepeats(false);
            timer.start();
    
            pack();
            setLocationRelativeTo(parent);
        }
    }

    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
            }
        }
    }

    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    public void run() {
        this.setVisible(true);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoList();
            }
        });
    }
}
