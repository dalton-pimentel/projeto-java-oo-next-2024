package br.edu.cesarschool.next.poo.projetoreferencia.conta;

public class ContaPoupanca extends ContaCorrente {
	private double percentualBonus;
	
	public ContaPoupanca() {
	}

	public ContaPoupanca(int agencia, String numero, String nomeCorrentista, double saldo, double percentualBonus) {
		super(agencia, numero, nomeCorrentista, saldo);
		this.percentualBonus = percentualBonus;
	}
	
	@Override
	public void creditar(double valor) {
		super.creditar(valor * (1 + percentualBonus / 100));
	}
	
	
	public double isPercentualBonus() {
		return percentualBonus;
	}

	public void setPercentualBonus(double percentualBonus) {
		this.percentualBonus = percentualBonus;
	}
	
	
}
