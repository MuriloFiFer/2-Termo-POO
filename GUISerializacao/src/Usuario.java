import java.io.Serializable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import java.io.Serializable;
//atributos
public class Usuario implements Serializable {
private String nome;
private int idade;
public Usuario(String nome, int idade) {
this.nome = nome;
this.idade = idade;
}
public String getNome() {
return nome;
}
public int getIdade() {
return idade;
}
}
