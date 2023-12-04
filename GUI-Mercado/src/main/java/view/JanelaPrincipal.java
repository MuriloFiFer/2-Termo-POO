package View;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//classe

public class JanelaPrincipal extends JFrame {
    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        
        Painelvendas tab1 = new Painelvendas();
       PainelEstoque tab2 = new PainelEstoque();
    //    PainelRegisVenda tab3 = new PainelRegisVenda();

        jTPane.add("Venda", tab1);
        // jTPane.add("Estoque", tab2);
        // jTPane.add("Registro", tab3);
        setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar a aplicação?",
                        "Fechar Aplicação", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose(); // Fecha a janela
                }
            }
        });
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}
