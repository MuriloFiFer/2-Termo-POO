package Model;

public class Clientes {
    private String cpf;
    private String nome;
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Clientes(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    public Object getNomeCliente() {
        return null;
    }
    
}
