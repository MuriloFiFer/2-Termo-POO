package Controller;

import java.util.List;
import Model.Produtos;
import Model.Registro;

public class RegisControll {
    private List<Produtos> produtosVendidos;
    private Registro registroPagamento;

    public RegisControll(List<Produtos> produtosVendidos, Registro registroPagamento) {
        this.produtosVendidos = produtosVendidos;
        this.registroPagamento = registroPagamento;
    }

    public List<Produtos> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<Produtos> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public Registro getRegistroPagamento() {
        return registroPagamento;
    }

    public void setRegistroPagamento(Registro registroPagamento) {
        this.registroPagamento = registroPagamento;
    }

    public int calcularTotalVenda() {
        int total = 0;
        for (Produtos produto : produtosVendidos) {
            // Certifique-se de que a string seja um número inteiro antes de adicioná-la ao total
            total += Integer.parseInt(produto.getValor());
        }
        return total;
    }

    public void exibirRecibo() {
        System.out.println("----- Recibo de Venda -----");
        System.out.println("Produtos Vendidos:");
        for (Produtos produto : produtosVendidos) {
            System.out.println(" - " + produto.getNomeProduto() + ": R$" + produto.getValor());
        }
        System.out.println("Total: R$" + calcularTotalVenda());
        System.out.println("Método de Pagamento: " + registroPagamento.getCartao());
        System.out.println("---------------------------");
    }
}
