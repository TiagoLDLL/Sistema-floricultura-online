package produto;

public class Perfume extends Produto implements Interface{

    private int volume;

    public Perfume(String nome, double preco, int estoque, int volume){
        super(nome, preco, estoque);
        this.setVolume(volume);
    }
    public Perfume(String nome, double preco, int estoque){
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

    public int getVolume(){
        return volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    @Override
    public void getDescricao(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Preço: "+this.getPreco()+"0R$");
        System.out.println("Estoque: "+this.getEstoque()+" Unidade(s)");
        System.out.println("Volume: "+this.getVolume()+"ml");
    }
}
