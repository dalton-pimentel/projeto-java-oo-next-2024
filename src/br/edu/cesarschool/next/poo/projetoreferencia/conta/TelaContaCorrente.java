package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import java.util.Scanner;

public class TelaContaCorrente {
	private static final String SIM = "S";
	private Scanner entrada = new Scanner(System.in);
	private MediatorContaCorrente mediator = new MediatorContaCorrente();
	public void iniciar() {
		while(true) {
			System.out.println("1- Incluir");
			System.out.println("2- Creditar");
			System.out.println("3- Debitar");
			System.out.println("4- Buscar");
			System.out.println("5- Relatório");
			System.out.println("6- Sair");
			System.out.println("Selecione a operação");
			int operacao = entrada.nextInt();
//			if (operacao == 1) {
//				rodarIncluir();
//			} else if (operacao == 2) {
//				rodarAtualizarEstoque();
//			} else if (operacao == 3) {
//				rodarConsultarPrecoTotal();
//			} else if (operacao == 4) {
//				rodarConsultarProduto();
//			} else if (operacao == 5) {
//				rodarRelatorioGeral();
//			} else if (operacao == 6) {
//				rodarSair();
//			} else {
//				System.out.println("Opera��o inv�lida");
//			}
		}	
	}
	private void rodarIcluir() {
		ContaCorrente conta = null;
		System.out.println("Informe o nome: ");
		String nomeCorrentista = entrada.next();
		System.out.println("Agência: ");
		int agencia = entrada.nextInt();
		System.out.println("Número da conta: ");
		String numero = entrada.next();
		System.out.println("É uma Conta Poupança? (S/N)");
		String contaPoupanca = entrada.next();
		if(contaPoupanca.equals(SIM)) {
			
		}
	}
}
