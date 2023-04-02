package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que gerencia a votação.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Cadastra pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      int numeroExistente = pessoaCandidata.getNumero();
      if (numeroExistente == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }

    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * Cadastra pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      String cpfExistente = pessoaEleitora.getCpf();
      if (cpfExistente.equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }

    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * Implementa a lógica de fazer votação.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfComputado) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
        this.totalVotos += 1;
        cpfComputado.add(cpfPessoaEleitora);
        break;
      }
    }
  }

  /**
   * Mostra o resukltado.
   */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (int index = 0; index < pessoasCandidatas.size(); index++) {
      double percentualVotos = calcularPorcentagemVotos(index);
      PessoaCandidata pessoaCandidata = pessoasCandidatas.get(index);
      System.out.println("Nome: " + pessoaCandidata.getNome() + " - " + pessoaCandidata.getVotos()
          + " votos ( " + percentualVotos + " )");
    }

    System.out.println("Total de votos: " + this.totalVotos);
  }

  private double calcularPorcentagemVotos(int index) {
    int votos = pessoasCandidatas.get(index).getVotos();
    float percentualVotos = (float) votos / (float) this.totalVotos;
    return Math.round(percentualVotos * 100);
  }
}
