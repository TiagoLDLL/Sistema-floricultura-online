package produto;

public class Flor extends Produto implements Interface{

    private String cor;

    public Flor(String nome, double preco, int estoque, String cor){
        super(nome, preco, estoque);
        this.setCor(cor);
    }
    public Flor(String nome, double preco, int estoque){
        super(nome, preco, estoque);
    }

    @Override
    public String getNome(){
        return this.nome;
    }

    @Override
    public double getPreco(){
        return this.preco;
    }

    @Override
    public int getEstoque(){
        return this.estoque;
    }

    @Override
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public void setPreco(double preco){
        this.preco = preco;
    }

    @Override
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    @Override
    public void getDescricao(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Preço: "+this.getPreco()+"0R$");
        System.out.println("Estoque: "+this.getEstoque()+" Unidade(s)");
        System.out.println("Cor: "+this.getCor());
    }
}


