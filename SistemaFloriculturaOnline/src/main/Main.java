package main;

import produto.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        Funcao funcao = new Funcao();
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Flor> flor = new ArrayList<>();

        flor.add(new Flor("Rosa", 5, 118, "Vermelha"));
        flor.add(new Flor("Girassol", 3, 53, "Amarelo"));
        flor.add(new Flor("Tulipa", 4.5, 75, "Vermelha"));
        flor.add(new Flor("Margarida", 2.5, 82, "Branca"));
        
        ArrayList<Decoracao> decoracao = new ArrayList<>();
        decoracao.add(new Decoracao("Escultura", 400, 5, "Clássico"));
        decoracao.add(new Decoracao("Tapete", 80, 20, "Persa"));
        decoracao.add(new Decoracao("Pedra Ornamental", 40, 80, "Contemporâneo"));
        decoracao.add(new Decoracao("Urso de Pelúcia", 30, 50, "Contemporâneo"));
        
        ArrayList<Perfume> perfume = new ArrayList<>();
        perfume.add(new Perfume("Solitária Flor", 170, 12, 75));
        perfume.add(new Perfume("Pétala Única", 125, 26, 100));
        perfume.add(new Perfume("Tulipa em Flor", 155, 14, 75));
        perfume.add(new Perfume("Orquídea Radiante", 225, 16, 75));
        
        ArrayList<Planta> planta = new ArrayList<>();
        planta.add(new Planta("Luca", 60, 23, "Yucca Aloifolia"));
        planta.add(new Planta("Cacto Ouriço", 15, 50, "Echinocereus reichenbachii"));
        planta.add(new Planta("Dasilírio", 150, 11, "Dasylirion Acrotrichum"));
        planta.add(new Planta("Ficus", 85, 15, "Ficus Pumila"));
        
        ArrayList<Vaso> vaso = new ArrayList<>();
        vaso.add(new Vaso("Vaso Aurora", 35, 61, "Cerâmica"));
        vaso.add(new Vaso("Vaso Primavera", 300, 12, "Madeira"));
        vaso.add(new Vaso("Vaso Harmonia", 60, 31, "Plástico"));
        vaso.add(new Vaso("Vaso Serenidade", 50, 48, "Barro"));

        ArrayList<ArrayList<? extends Produto>> produtos = new ArrayList<>();
        produtos.add(flor);
        produtos.add(decoracao);
        produtos.add(perfume);
        produtos.add(planta);
        produtos.add(vaso);

        //===== ▼ PROGRAMA ▼ =====
        
        /*  Conta do ADM:
            Login: admin
            Senha: 123456   */

        usuario.adicionarContasPremium();
        funcao.menu();
        while(true){
            System.out.print("\nSelecione a opção: ");
            boolean desligarPrograma = false;
            int opcao = getOpcaoMenu(funcao, scanner);
            
            switch(opcao){
                case 1:
                boolean logado = usuario.fazerLogin();
                if(logado){
                    while(true){
                        int deslogar = funcao.switchCaseUsuario(produtos);
                        if(deslogar == 4){
                            System.out.println("\nDeslogando...");
                            break;
                        }
                    }
                }
                funcao.menu();
                break;
        
                case 2:
                usuario.fazerCadastro();
                funcao.menu();
                break;
        
                case 3:
                funcao.verDescricao(produtos);
                funcao.menu();
                break;
        
                case 4:
                boolean logadoADM = usuario.fazerLoginADM();
                if(logadoADM){
                    System.out.println("\nEntrando como administrador...");
                    while(true){
                        int sair = funcao.switchCaseADM(produtos, flor, decoracao, perfume, planta, vaso, usuario);
                        if(sair == 7){
                            break;
                        }
                    }
                }
                else{
                    System.out.println("\nLogin ou senha incorretos.");
                }
                funcao.menu();
                break;
        
                case 5:
                System.out.println("\nDesligando...");
                desligarPrograma = true;
                break;
        
                default:
                System.out.println("Opção inválida, tente novamente: ");
                break;
            }
            if(desligarPrograma){
                break;
            }
       }

        //===== ▲ PROGRAMA ▲ =====



    }

    static int getOpcaoMenu(Funcao funcao, Scanner scanner){
        int opcaoMenu;
        while(true){
            opcaoMenu = funcao.getNumber(scanner);
            if(opcaoMenu<1 || opcaoMenu>5){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else{
                break;
            }
        }
        return opcaoMenu;
    }

}


