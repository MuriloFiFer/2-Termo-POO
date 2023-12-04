package Model;

public class Produtos {

    private int promocao;
    private int codBarra;
    private int quantiProduto;
    private String nomeProduto;
    private int valor;

    public Produtos(int promocao, int codBarra, int quantiProduto, String nomeProduto, int valor) {
        this.promocao = promocao;
        this.codBarra = codBarra;
        this.quantiProduto = quantiProduto;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }

    public int getPromocao() {
        return promocao;
    }

    public void setPromocao(int promocao) {
        this.promocao = promocao;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(int codBarra) {
        this.codBarra = codBarra;
    }

    public int getQuantiProduto() {
        return quantiProduto;
    }

    public void setQuantiProduto(int quantiProduto) {
        this.quantiProduto = quantiProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return null;
    }

    public String getModelo() {
        return null;
    }

    public String getPlaca() {
        return null;
    }

    public Object getCpf() {
        return null;
    }
}
