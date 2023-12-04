package Model;

public class Registro {
    private int ValorTotal;
    private int quantiItem;
    private String Vip;
    private String dinheiro;
    private String cartao;

    public Registro(int valorTotal, int quantiItem, String vip, String dinheiro, String cartao) {
        ValorTotal = valorTotal;
        this.quantiItem = quantiItem;
        Vip = vip;
        this.dinheiro = dinheiro;
        this.cartao = cartao;
    }

    public int getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(int valorTotal) {
        ValorTotal = valorTotal;
    }

    public int getQuantiItem() {
        return quantiItem;
    }

    public void setQuantiItem(int quantiItem) {
        this.quantiItem = quantiItem;
    }

    public String getVip() {
        return Vip;
    }

    public void setVip(String vip) {
        Vip = vip;
    }

    public String getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

}
