package produto;

public abstract class Produto{
    
    protected String nome;
    protected double preco;
    protected int estoque;

    Produto(String nome, double preco, int estoque){
        this.setNome(nome);
        this.setPreco(preco);
        this.setEstoque(estoque);
    }

    public abstract String getNome();

    public abstract double getPreco();

    public abstract int getEstoque();

    public abstract void setNome(String nome);

    public abstract void setPreco(double preco);

    public abstract void setEstoque(int estoque);

    public abstract void getDescricao();

}
