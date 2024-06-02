package main;
import java.util.*;
import produto.*;

public class Funcao {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;

    //===== ▼ FUNÇÕES DE LISTA ▼ ===== (Essas funções só servem para imprimir alguma coisa no terminal.)
    void getLista(){
        System.out.println("\n[1] Flores     [2] Decorações     [3] Perfumes     [4] Plantas     [5] Vasos     [0] Voltar");
        System.out.print("\nSelecione a opção: ");
    }

    void menu(){
        System.out.println("\n   ~ Floricultura Baronne de Fleur ~   \n");
        System.out.println("[1] Log-in     [3] Verificar Produtos     [5] Sair\n");
        System.out.println("[2] Cadastro   [4] Entrar como ADM");
    }

    void menuLogado(){
        System.out.println("\n   ~ Floricultura Baronne de Fleur ~   \n");
        System.out.println("[1] Comprar             [3] Suporte ao Cliente\n");
        System.out.println("[2] Verificar Estoque   [4] Sair da Conta");
    }

    void menuADM(){
        System.out.println("\n===== MENU DO ADM =====\n");
        System.out.println("[1] Adicionar Produto     [4] Cadastrar Usuário     [7] Modificar Usuário\n");
        System.out.println("[2] Remover Produto       [5] Remover Usuário       [8] Modificar Produto\n");
        System.out.println("[3] Listar Produtos       [6] Listar Usuários       [9] Sair da Conta");
    }

    //===== ▼ FUNÇÕES DE UTILIDADE ▼ =====
    int switchCaseUsuario(ArrayList<ArrayList<? extends Produto>> produtos){
        menuLogado();
        System.out.print("\nSelecione a opção: ");
        while(true){
            int opcao = getNumber(scanner);
            if(opcao<1 || opcao>4){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else{
                scanner.nextLine();
                switch(opcao){
                    case 1:
                    fazerCompra(produtos);
                    menuLogado();
                    System.out.print("\nSelecione a opção: ");
                    break;

                    case 2:
                    verDescricao(produtos);
                    menuLogado();
                    System.out.print("\nSelecione a opção: ");
                    break;

                    case 3:
                    suporteCliente();
                    menuLogado();
                    System.out.print("\nSelecione a opção: ");
                    break;

                    case 4:
                    return 4;

                    default:
                    System.out.print("\nOpção inválida, tente novamente: ");
                    break;
                }
            }
        }
    }

    int switchCaseADM(ArrayList<ArrayList<? extends Produto>> produtos, ArrayList<Flor> flor, ArrayList<Decoracao> decoracao, 
    ArrayList<Perfume> perfume, ArrayList<Planta> planta, ArrayList<Vaso> vaso, Usuario usuario){

        menuADM();
        while(true){
            System.out.print("\nSelecione a opção: ");
            int opcaoMenu;
            while(true){
                opcaoMenu = getNumber(scanner);
                if(opcaoMenu<1 || opcaoMenu>9){
                    System.out.print("\nOpção inválida, tente novamente: ");
                }
                else{
                    break;
                }
            }
            switch(opcaoMenu){
                case 1:
                getLista();
                int opcaoProduto = getNumber(scanner);
                scanner.nextLine();
                switch(opcaoProduto){
                    case 0:
                    menuADM();
                    break;

                    case 1:
                    adicionarFlor(flor);
                    break;

                    case 2:
                    adicionarDecoracao(decoracao);
                    break;

                    case 3:
                    adicionarPerfume(perfume);
                    break;

                    case 4:
                    adicionarPlanta(planta);
                    break;

                    case 5:
                    adicionarVaso(vaso);
                    break;

                    default:
                    System.out.print("Opção inválida, tente novamente: ");
                    break;
                }
                menuADM();
                break;
    
                case 2:
                System.out.println("\nQual tipo de produto você deseja remover?:");
                removerProduto(produtos);
                menuADM();
                break;
    
                case 3:
                verDescricao(produtos);
                menuADM();
                break;
    
                case 4:
                usuario.fazerCadastro();
                menuADM();
                break;
    
                case 5:
                usuario.removerUsuario();
                menuADM();
                break;
    
                case 6:
                usuario.listarUsuarios();
                menuADM();
                break;
    
                case 7:
                usuario.modificarUsuario();
                menuADM();
                break;

                case 8:
                modificarProduto(produtos, flor, decoracao, perfume, planta, vaso);
                menuADM();
                break;

                case 9:
                return 7;
    
                default:
                System.out.print("Opção inválida, tente novamente: ");
                break;
            }
        }
    }

    void suporteCliente(){
        System.out.println("\nEnvie um email para baronnefleurnet@gmail.com: \n");
        scanner.nextLine();
        System.out.println("\nEmail enviado! aguarde por uma resposta no Inbox do seu email.");
    }

    void verDescricao(ArrayList<ArrayList<? extends Produto>> produtos){
        getLista();
        int indexProduto;
        while(true){
            int opcao = getIndexLista(produtos);
            indexProduto = opcao;
            if(opcao==0){break;}
            System.out.println();
            if(produtos.get(opcao-1).size()<1){
                System.out.println("Ops! Parece que não temos mais esse tipo de produto no estoque, tente novamente mais tarde.");
                break;
            }
            for(int i=0; i<produtos.get(opcao-1).size(); i++){
                System.out.println(i+1+": "+produtos.get(opcao-1).get(i).getNome());
            }
            int look = getIndexProduto(produtos, indexProduto);
            System.out.println();
            produtos.get(opcao-1).get(look-1).getDescricao();
            break;
        }
    }

    void fazerCompra(ArrayList<ArrayList<? extends Produto>> produtos){
        getLista();
        while(true){
            int opcao = getIndexLista(produtos);
            int indexProduto = opcao;
            if(opcao==0){break;}
            System.out.println();
            for(int i=0; i<produtos.get(opcao-1).size(); i++){
                System.out.println(i+1+": "+produtos.get(opcao-1).get(i).getNome());
            }
            int look = getIndexProduto(produtos, indexProduto);
            System.out.println();
            produtos.get(opcao-1).get(look-1).getDescricao();
            System.out.print("\nQuantas unidades você deseja comprar?: ");
            while(true){
                int quantidade = getNumber(scanner);
                if(quantidade<0){
                    System.out.print("\nQuantidade inválida, tente novamente: ");
                }
                else if(quantidade>produtos.get(opcao-1).get(look-1).getEstoque()){
                    System.out.println("\nOps! Parece que só temos "+produtos.get(opcao-1).get(look-1).getEstoque()+" "+produtos.get(opcao-1).get(look-1).getNome()+"(s) no Estoque.");
                    System.out.print("\nTente novamente: ");
                }
                else{
                    boolean continuarCompra = getMetodoPagamento(scanner);
                    if(!continuarCompra){
                        break;
                    }
                    else{
                        produtos.get(opcao-1).get(look-1).setEstoque(produtos.get(opcao-1).get(look-1).getEstoque() - quantidade);
                        double precoFinal = produtos.get(opcao-1).get(look-1).getPreco() * quantidade;
                        String nomeProduto = produtos.get(opcao-1).get(look-1).getNome();
                        System.out.println("\nVocê comprou "+quantidade+" "+nomeProduto+"(s) por R$"+precoFinal+"0.");
                        break;
                    }
                }
            }
            break;
        }
    }

    void modificarProduto(ArrayList<ArrayList<? extends Produto>> produtos, ArrayList<Flor> flor, ArrayList<Decoracao> decoracao, ArrayList<Perfume> perfume,
    ArrayList<Planta> planta, ArrayList<Vaso> vaso){
        System.out.println("\nSelecione o produto que deseja modificar.");
        getLista();
        int indexProduto;
        while(true){
            int opcao = getIndexLista(produtos);
            indexProduto = opcao;
            if(opcao==0){break;}
            System.out.println();
            if(produtos.get(opcao-1).size()<1){
                System.out.println("Ops! Parece que não temos mais esse tipo de produto no estoque, tente novamente mais tarde.");
                break;
            }
            for(int i=0; i<produtos.get(opcao-1).size(); i++){
                System.out.println(i+1+": "+produtos.get(opcao-1).get(i).getNome());
            }
            int look = getIndexProduto(produtos, indexProduto);
            System.out.println();
            produtos.get(opcao-1).get(look-1).getDescricao();
            System.out.print("\nTem certeza que deseja modificar esse produto? [1] Sim     [2] Cancelar modificação: ");
            while(true){
                int opcaoModificarProduto = getNumber(scanner);
                scanner.nextLine();
                if(opcaoModificarProduto == 2){
                    System.out.println("\nCancelando...");
                    break;
                }
                else if(opcaoModificarProduto<1 || opcaoModificarProduto>2){
                    System.out.print("\nOpção inválida, tente novamente: ");
                }
                else{
                    System.out.println("\nDefina os novos atributos abaixo.");
                    String newNome;
                    double newPreco;
                    int newEV;
                    int newVolume;
                    String newCEEM;
                    switch(opcao){
                        case 1:
                        System.out.print("\nDigite o novo nome: ");
                        newNome = getString(scanner);
                        System.out.print("\nDigite o novo preço: ");
                        newPreco = getDouble(scanner);
                        System.out.print("\nDigite o novo estoque: ");
                        newEV = getNumber(scanner);
                        scanner.nextLine();
                        System.out.print("\nDigite a nova cor: ");
                        newCEEM = getString(scanner);
                        flor.set(look-1, (new Flor(newNome, newPreco, newEV, newCEEM)));
                        System.out.println("\nFlor modificada com sucesso!");
                        break;

                        case 2:
                        System.out.print("\nDigite o novo nome: ");
                        newNome = getString(scanner);
                        System.out.print("\nDigite o novo preço: ");
                        newPreco = getDouble(scanner);
                        System.out.print("\nDigite o novo estoque: ");
                        newEV = getNumber(scanner);
                        scanner.nextLine();
                        System.out.print("\nDigite o novo estilo: ");
                        newCEEM = getString(scanner);
                        decoracao.set(look-1, (new Decoracao(newNome, newPreco, newEV, newCEEM)));
                        System.out.println("\nDecoração modificada com sucesso!");
                        break;

                        case 3:
                        System.out.print("\nDigite o novo nome: ");
                        newNome = getString(scanner);
                        System.out.print("\nDigite o novo preço: ");
                        newPreco = getDouble(scanner);
                        System.out.print("\nDigite o novo estoque: ");
                        newEV = getNumber(scanner);
                        scanner.nextLine();
                        System.out.print("\nDigite o novo volume: ");
                        newVolume = getNumber(scanner);
                        perfume.set(look-1, (new Perfume(newNome, newPreco, newEV, newVolume)));
                        System.out.println("\nPerfume modificado com sucesso!");
                        break;

                        case 4:
                        System.out.print("\nDigite o novo nome: ");
                        newNome = getString(scanner);
                        System.out.print("\nDigite o novo preço: ");
                        newPreco = getDouble(scanner);
                        System.out.print("\nDigite o novo estoque: ");
                        newEV = getNumber(scanner);
                        scanner.nextLine();
                        System.out.print("\nDigite a nova espécie: ");
                        newCEEM = getString(scanner);
                        planta.set(look-1, (new Planta(newNome, newPreco, newEV, newCEEM)));
                        System.out.println("\nPlanta modificada com sucesso!");
                        break;

                        case 5:
                        System.out.print("\nDigite o novo nome: ");
                        newNome = getString(scanner);
                        System.out.print("\nDigite o novo preço: ");
                        newPreco = getDouble(scanner);
                        System.out.print("\nDigite o novo estoque: ");
                        newEV = getNumber(scanner);
                        scanner.nextLine();
                        System.out.print("\nDigite a novo material: ");
                        newCEEM = getString(scanner);
                        vaso.set(look-1, (new Vaso(newNome, newPreco, newEV, newCEEM)));
                        System.out.println("\nVaso modificado com sucesso!");
                        break;

                        default:
                        System.out.print("\nOpção inválida, tente novamente: ");
                        break;
                    }
                    break;
                }
            }
            break;
        }
    }

    //===== ▼ FUNÇÕES MODIFICAR INSTÂNCIA ▼ =====


    //===== ▼ FUNÇÕES ADICIONAR INSTÂNCIA ▼ =====
    void adicionarFlor(ArrayList<Flor> flor){
        String nome;
        double preco;
        int estoque;
        String cor;

        System.out.print("\nNome: ");
        nome = getString(scanner);
        System.out.print("\nPreço: ");
        preco = getDouble(scanner);
        System.out.print("\nEstoque: ");
        estoque = getNumber(scanner);
        scanner.nextLine();
        System.out.print("\nCor: ");
        cor = getString(scanner);
        flor.add(new Flor(nome, preco, estoque, cor));
        System.out.println("Flor adicionada com sucesso!\n");
    }

    void adicionarDecoracao(ArrayList<Decoracao> decoracao){
        String nome;
        double preco;
        int estoque;
        String estilo;

        System.out.print("\nNome: ");
        nome = getString(scanner);
        System.out.print("\nPreço: ");
        preco = getDouble(scanner);
        System.out.print("\nEstoque: ");
        estoque = getNumber(scanner);
        scanner.nextLine();
        System.out.print("\nEstilo: ");
        estilo = getString(scanner);
        decoracao.add(new Decoracao(nome, preco, estoque, estilo));
        System.out.println("Decoração adicionada com sucesso!\n");
    }

    void adicionarPerfume(ArrayList<Perfume> perfume){
        String nome;
        double preco;
        int estoque;
        int volume;

        System.out.print("\nNome: ");
        nome = getString(scanner);
        System.out.print("\nPreço: ");
        preco = getDouble(scanner);
        System.out.print("\nEstoque: ");
        estoque = getNumber(scanner);
        scanner.nextLine();
        System.out.print("\nVolume(Em ml): ");
        volume = getNumber(scanner);
        perfume.add(new Perfume(nome, preco, estoque, volume));
        System.out.println("Perfume adicionado com sucesso!\n");
    }

    void adicionarPlanta(ArrayList<Planta> planta){
        String nome;
        double preco;
        int estoque;
        String especie;

        System.out.print("\nNome: ");
        nome = getString(scanner);
        System.out.print("\nPreço: ");
        preco = getDouble(scanner);
        System.out.print("\nEstoque: ");
        estoque = getNumber(scanner);
        scanner.nextLine();
        System.out.print("\nEspécie: ");
        especie = getString(scanner);
        planta.add(new Planta(nome, preco, estoque, especie));
        System.out.println("Planta adicionada com sucesso!\n");
    }

    void adicionarVaso(ArrayList<Vaso> vaso){
        String nome;
        double preco;
        int estoque;
        String material;

        System.out.print("\nNome: ");
        nome = getString(scanner);
        System.out.print("\nPreço: ");
        preco = getDouble(scanner);
        System.out.print("\nEstoque: ");
        estoque = getNumber(scanner);
        scanner.nextLine();
        System.out.print("\nMaterial: ");
        material = getString(scanner);
        vaso.add(new Vaso(nome, preco, estoque, material));
        System.out.println("Vaso adicionada com sucesso!\n");
    }

    //===== ▼ FUNÇÕES REMOVER INSTÂNCIA ▼ =====
    void removerProduto(ArrayList<ArrayList<? extends Produto>> produtos){
        getLista();
        int indexProduto;
        while(true){
            int opcao = getIndexLista(produtos);
            indexProduto = opcao;
            if(opcao==0){break;}
            System.out.println();
            if(produtos.get(opcao-1).size()<1){
                System.out.println("Ops! Parece que não temos mais esse tipo de produto no estoque, tente novamente mais tarde.");
                break;
            }
            for(int i=0; i<produtos.get(opcao-1).size(); i++){
                System.out.println(i+1+": "+produtos.get(opcao-1).get(i).getNome());
            }
            int look = getIndexProduto(produtos, indexProduto);
            System.out.println();
            produtos.get(opcao-1).get(look-1).getDescricao();
            System.out.print("\nTem certeza que deseja remover esse produto? [1] Sim     [2] Não remover: ");
            while(true){
                int x = getNumber(scanner);
                if(x==1){
                    produtos.get(opcao-1).remove(look-1);
                    System.out.println("\nProduto removido com sucesso!");
                    break;
                }
                else if(x==2){
                    break;
                }
                else{
                    System.out.print("\nOpção inválida, tente novamente: ");
                }
            }
            break;
        }
    }

    //===== ▼ FUNÇÕES PARA PEGAR ALGUM VALOR ▼ =====
    int getIndexLista(ArrayList<ArrayList<? extends Produto>> produtos){
        int indexLista;
        while(true){
            indexLista = getNumber(scanner);
            if(indexLista > produtos.size() || indexLista < 0){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else{
                break;
            }
        }
        return indexLista;
    }

    int getIndexProduto(ArrayList<ArrayList<? extends Produto>> produtos, int indexProduto){
        System.out.print("\nSelecione a opção: ");
        int lookIndex;
        while(true){
            lookIndex = getNumber(scanner);
            if(lookIndex > produtos.get(indexProduto-1).size() || lookIndex <= 0){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else{
                break;
            }
        }
        return lookIndex;
    }

    int getNumber(Scanner scanner){
        while(true){
            try{
                int number = scanner.nextInt();
                if(number<0){
                    System.out.print("\nOpção inválida, tente novamente: ");
                }
                else{
                    return number;
                }
            }
            catch(InputMismatchException e){
                System.out.print("\nOpção inválida, tente novamente: ");
                scanner.nextLine();
            }
        }
    }

    boolean getMetodoPagamento(Scanner scanner){
        System.out.println("\n[1] Cartão     [2] Pix     [3] Boleto Bancário     [4] PayPal     [0] Cancelar Compra");
        System.out.print("\nQual método de pagamento você deseja usar?: ");
        while(true){
            int metodoPagamento = getNumber(scanner);
            if(metodoPagamento<0 || metodoPagamento>4){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else if(metodoPagamento==0){
                System.out.println("\nCancelando compra...");
                return false;
            }
            else{
                return true;
            }
        }
    }

    double getDouble(Scanner scanner){
        while(true){
            try{
                double number = scanner.nextDouble();
                if(number<0){
                    System.out.print("\nNúmero inválido, tente novamente: ");
                }
                else{
                    return number;
                }
            }
            catch(InputMismatchException e){
                System.out.print("\nOpção inválida, tente novamente: ");
                scanner.nextLine();
            }
        }
    }

    String getString(Scanner scanner){
        while(true){
            String string = scanner.nextLine();
            if(string.isBlank() || string.isEmpty()){
                System.out.print("Erro! Espaço em branco. Tente novamente: ");
            }
            else{
                return string;
            }
        }
    }



}
