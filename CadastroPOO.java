/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastropoo;

/**
 *
 * @author Thomas
 */
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.io.IOException;

public class CadastroPOO {

    public static void main(String[] args) {
        try {
            //a. Instanciar um repositório de pessoas físicas (repo1).
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            PessoaFisica pessoa1 = new PessoaFisica(1, "Thomas Santana", "123.456.789-12", 37);
            PessoaFisica pessoa2 = new PessoaFisica(2, "Joana Oliveira", "321.654.987-21", 53);

            //b. Adicionar duas pessoas físicas
            repo1.inserir(pessoa1);
            repo1.inserir(pessoa2);
            
            System.out.println("Dados de Pessoa Física Armazenados");

            //c. Invocar o método de persistência em repo1, fornecendo um nome de arquivo fixo, através do código.
            repo1.persistir("pessoas_fisicas.dat");

            //d. Instanciar outro repositório de pessoas físicas (repo2)
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            
            //e. Invocar o método de recuperação em repo2, fornecendo o mesmo nome de arquivo utilizado anteriormente.
            repo2.recuperar("pessoas_fisicas.dat");
            
            System.out.println("Dados de Pessoa Física Recuperados");

            //f. Exibir os dados de todas as pessoas físicas recuperadas.
            
            for (PessoaFisica pf : repo2.obterTodos()) {
                System.out.println("Id: " + pf.getId());
                System.out.println("Nome: " + pf.getNome());
                System.out.println("CPF: " + pf.getCpf());
                System.out.println("Idade: " + pf.getIdade());
                System.out.println();  // Quebra de linha para melhor formatação
            }

            //g. Instanciar um repositório de pessoas jurídicas (repo3).
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            PessoaJuridica empresa1 = new PessoaJuridica(1, "Empresa Alpha", "33.333.333/0001-11");
            PessoaJuridica empresa2 = new PessoaJuridica(2, "Empresa Beta", "44.444.444/0001-22");

            //h. Adicionar duas pessoas jurídicas, utilizando o construtor completo.
            repo3.inserir(empresa1);
            repo3.inserir(empresa2);
            
            System.out.println("Dados de Pessoa Jurídica Armazenados");

            //i. Invocar o método de persistência em repo3, fornecendo um nome de arquivo fixo, através do código.
            repo3.persistir("pessoas_juridicas.dat");

            //j. Instanciar outro repositório de pessoas jurídicas (repo4)
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            
            //k. Invocar o método de recuperação em repo4, fornecendo o mesmo nome de arquivo utilizado anteriormente.
            repo4.recuperar("pessoas_juridicas.dat");
            
            System.out.println("Dados de Pessoa Jurídica Recuperados");

            //l. Exibir todas as pessoas jurídicas recuperadas
            
            for (PessoaJuridica pj : repo4.obterTodos()) {
                System.out.println("Id: " + pj.getId());
                System.out.println("Nome: " + pj.getNome());
                System.out.println("CNPJ: " + pj.getCnpj());
                System.out.println();  // Quebra de linha para melhor formatação
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
