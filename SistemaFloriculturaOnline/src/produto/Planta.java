package produto;

public class Planta extends Produto implements Interface{

    private String especie;

    public Planta(String nome, double preco, int estoque, String especie){
        super(nome, preco, estoque);
        this.setEspecie(especie);
    }
    public Planta(String nome, double preco, int estoque){
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

    public String getEspecie(){
        return this.especie;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    @Override
    public void getDescricao(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Preço: "+this.getPreco()+"0R$");
        System.out.println("Estoque: "+this.getEstoque()+" Unidade(s)");
        System.out.println("Espécie: "+this.getEspecie());
    }
}
