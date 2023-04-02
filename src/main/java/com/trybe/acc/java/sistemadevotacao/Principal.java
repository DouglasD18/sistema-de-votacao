package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Método princiapl.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    Scanner scanner = new Scanner(System.in);

    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");
    System.out.println();
    short controller = 1;
    short auxiliar = 0;
    while (controller == 1 || auxiliar == 0) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      controller = scanner.nextShort();
      if (controller == 1) {
        auxiliar = 1;
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    }

    System.out.println();
    System.out.println();

    System.out.println("----------- Cadastre as pessoas eleitoras -----------");
    System.out.println();
    auxiliar = 0;
    controller = 1;
    while (controller == 1 || auxiliar == 0) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      controller = scanner.nextShort();
      if (controller == 1) {
        auxiliar = 1;
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    }

    System.out.println();
    System.out.println();

    System.out.println("----------- Votação iniciada! -----------");
    System.out.println();
    auxiliar = 0;
    controller = 1;
    while (controller == 1 || auxiliar == 0) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      controller = scanner.nextShort();
      if (controller == 1) {
        auxiliar = 1;
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfPessoaEleitora = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroPessoaCandidata = scanner.nextInt();
        gerenciamentoVotacao.votar(cpfPessoaEleitora, numeroPessoaCandidata);
      } else if (controller == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }
    }

    gerenciamentoVotacao.mostrarResultado();

    scanner.close();
  }

}
