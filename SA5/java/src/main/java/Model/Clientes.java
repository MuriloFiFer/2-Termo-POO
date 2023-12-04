package Model;

public class Clientes {
    private int cpf;
    private String nome;
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Clientes(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
}