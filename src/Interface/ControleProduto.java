package Interface;

public interface ControleProduto {

    public int vendaProduto();

    public void atualizarProduto();

    public void adicionarProduto();

    public void listarProdutos();

    public void verCarrinho(int quant);

    public void finalizarPedido(int quant);


}
