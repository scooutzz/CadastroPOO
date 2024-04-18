/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author User
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "João", "12345678901", 30);
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Maria", "98765432101", 20);
        
        repo1.inserir(pessoaFisica1);
        repo1.inserir(pessoaFisica2);
        
        // Compilador não compila com try-catch. erro: exception IOException is never thrown in body of corresponding try statement
//        try {
        repo1.persistir("pessoas_fisicas.dat");
//        } catch (IOException ex) {
//            System.out.println("Erro ao persistir dados de pessoas físicas: " + ex.getMessage());
//        }
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        
        // Compilador não compila com try-catch. erro: exception IOException is never thrown in body of corresponding try statement
//        try {
        repo2.recuperar("pessoas_fisicas.dat");
//        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("Erro ao recuperar dados de pessoas físicas: " + ex.getMessage());
//        }
        
        System.out.println("Pessoas físicas recuperadas:");
        for (PessoaFisica pessoa : repo2.obterTodos()) {
            pessoa.exibir();
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "Empresa 1", "12345678901234");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2, "Empresa 2", "98765432109876");
        
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);
        
        // Compilador não compila com try-catch. erro: exception IOException is never thrown in body of corresponding try statement
//        try {
        repo3.persistir("pessoas_juridicas.dat");
//        } catch (IOException ex) {
//            System.out.println("Erro ao persistir dados de pessoas jurídicas: " + ex.getMessage());
//        }
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        
        // Compilador não compila com try-catch. erro: exception IOException is never thrown in body of corresponding try statement
//        try {
        repo4.recuperar("pessoas_juridicas.dat");
//        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("Erro ao recuperar dados de pessoas jurídicas: " + ex.getMessage());
//        }
        
        System.out.println("Pessoas jurídicas recuperadas:");
        for (PessoaJuridica pessoa : repo4.obterTodos()) {
            pessoa.exibir();
        }
    }
    
}
