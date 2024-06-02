package main;

import java.util.*;

public class Usuario {
    ArrayList<String[]> usuarios  = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Funcao funcao = new Funcao();

    //===== ▼ FUNÇÕES DE UTILIDADE ▼ =====
    void fazerCadastro(){
        String email = getEmail();
        if(email.equals("0")){
        }
        else{
            String senha = getSenha();
            String uNome = getUsuarioNome();
            System.out.println("\nUsuário cadastrado com sucesso!");
            String[] infoUsuario = {email, senha, uNome};
            usuarios.add(infoUsuario);
        }
    }

    void modificarUsuario(){
        listarUsuarios();
        System.out.print("Qual usuário você deseja modificar? (Ex.: 1, 2, 3...): ");
        while(true){
            int modificar = getNumberSpecial(scanner);
            scanner.nextLine();
            if(modificar>usuarios.size() || modificar<=0){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else{
                System.out.print("\nDigite o novo email.");
                String newEmail = getEmail();
                if(newEmail.equals("0")){
                    break;
                }
                else{
                    System.out.print("\nDigite a nova senha.");
                    String newSenha = getSenha();
                    System.out.print("\nDigite o novo nome de usuário.");
                    String newUsuario = getUsuarioNome();
                    String[] infoUsuario = {newEmail, newSenha, newUsuario};
                    usuarios.set(modificar-1, infoUsuario);
                    System.out.println("\nUsuário modificado com sucesso!");
                    break;
                }
            }
        }
    }

    void removerUsuario(){
        listarUsuarios();
        System.out.print("Qual usuário você deseja remover? (Ex.: 1, 2, 3...): ");
        while(true){
            boolean sairDoLoop = false;
            int opcao = getNumberSpecial(scanner);
            if(opcao>usuarios.size()){
                System.out.print("\nOpção inválida, tente novamente: ");
            }
            else{
                System.out.print("\nTem certeza que deseja remover este usuário? [1] Sim     [2] Não remover: ");
                while(true){
                    int opcaoRemover = getNumberSpecial(scanner);
                    if(opcaoRemover==2){
                        System.out.println("\nCancelando remoção...");
                        sairDoLoop = true;
                        break;
                    }
                    else if(opcaoRemover==1){
                        usuarios.remove(opcao-1);
                        System.out.println("\nUsuário removido com sucesso!");
                        sairDoLoop = true;
                        break;
                    }
                    else{
                        System.out.print("\nOpção inválida, tente novamente: ");
                    }
                }
            }
            if(sairDoLoop){
                break;
            }
        }
        scanner.nextLine();
    }

    void listarUsuarios(){
        System.out.println();
        int indexUsuario = 1;
        for(String[] infoUsuario : usuarios){
            System.out.println("//===== ===== =====");
            System.out.println();
            System.out.println(indexUsuario+": "+infoUsuario[2]);
            System.out.println("Email: "+infoUsuario[0]);
            System.out.println("Senha: "+infoUsuario[1]);
            System.out.println();
            indexUsuario++;
        }
    }

    //===== ▼ FUNÇÕES PARA PEGAR ALGUM VALOR ▼ =====
    boolean fazerLoginADM(){
        String loginADM = "admin";
        String senhaADM = "123456";

        System.out.print("\nLogin: ");
        String login = scanner.nextLine();
        System.out.print("\nSenha: ");
        String senha = scanner.nextLine();

        boolean validarADM = false;
        if(login.equals(loginADM) && senha.equals(senhaADM)){
            validarADM = true;
        }

        if(validarADM){
            return true;
        }
        else{
            return false;
        }
    }

    boolean fazerLogin(){
        String tryEmail;
        String trySenha;
        System.out.print("\nDigite seu email: ");
        while(true){
            tryEmail = scanner.nextLine();
            if(tryEmail=="0"){
                break;
            }
            else if(tryEmail.contains("@") && tryEmail.contains(".com")){
                break;       
            }
            else{
                System.out.print("\nEmail inválido, tente novamente: ");
            }
        }
        System.out.print("\nDigite sua senha: ");
        trySenha = scanner.nextLine();
        
        boolean loginSucesso = false;
    
        for (String[] infoUsuario : usuarios) {
            if (infoUsuario[0].equals(tryEmail) && infoUsuario[1].equals(trySenha)) {
                loginSucesso = true;
                break;
            }
        }
        if (loginSucesso) {
            System.out.println("\nLogin bem-sucedido!");
            return true;
        } else {
            System.out.println("\nEmail ou senha incorretos. Tente novamente.");
        }
        return false;
    }

    String getEmail(){
        System.out.print("\nDigite seu email [0] Voltar: ");
        String email;
        while(true){
            email = scanner.nextLine();
            if(email.equals("0")){
                break;
            }
            else if(email.contains("@") && email.contains(".com")){
                break;
            }
            else{
                System.out.print("\nEmail inválido, tente novamente: ");
            }
        }
        return email;
    }

    String getSenha(){
        System.out.print("\nDigite sua senha: ");
        String senha;
        while(true){
            senha = scanner.nextLine();
            if(senha.isEmpty()){
                System.out.print("\nEspaço em branco! Digite uma senha válida: ");
            }
            else if(senha.contains(" ")){
                System.out.print("\nA senha não pode conter espaços em branco, tente novamente: ");
            }
            else if(senha.length()<5){
                System.out.print("\nA senha deve conter mais de 5 caracteres, tente novamente: ");
            }
            else{
                break;
            }
        }
        return senha;
    }

    String getUsuarioNome(){
        String uNome;
        System.out.print("\nDigite um nome de usuário para sua conta: ");
        while(true){
            uNome = scanner.nextLine();
            if(uNome.isEmpty() || uNome.isBlank()){
                System.out.print("\nEspaço em branco! Digite um nome de usuário válido: ");
            }
            else{
                break;
            }
        }
        return uNome;
    }

    int getNumberSpecial(Scanner scanner){
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
                System.out.print("\nOpção inválida! tente novamente: ");
                scanner.nextLine();
            }
        }
    }

    //===== ▼ CONTAS PREMIUM JÁ CADASTRADAS ▼ =====
    void adicionarContasPremium(){
        contaTiagoLucas();
        contaDanilloPatricio();
        contaTiagoFelipe();
    }

    void contaTiagoLucas(){
        String[] infoUsuario = {"tiagolucas@gmail.com","tiagolucas","Tiago Lucas"};
        usuarios.add(infoUsuario);
    }

    void contaDanilloPatricio(){
        String[] infoUsuario = {"danillopatricio@gmail.com","danillo","Danillo Patricio"};
        usuarios.add(infoUsuario);
    }

    void contaTiagoFelipe(){
        String[] infoUsuario = {"tiagofelipe@gmail.com","tiagofelipe","Tiago Felipe"};
        usuarios.add(infoUsuario);
    }
}
