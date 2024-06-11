package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import br.edu.cesarschool.next.poo.projetoreferencia.utils.Registro;
import br.edu.cesarschool.next.poo.projetoreferencia.utils.StringUtils;

public class ContaCorrente extends Registro{
	
	private int agencia;
	private String numero;
	private String nomeCorrentista;
	private double saldo;
	
	
	public ContaCorrente() {
	}

	public ContaCorrente(int agencia, String numero, String nomeCorrentista, double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.nomeCorrentista = nomeCorrentista;
		this.saldo = saldo;
	}
		
	// Método para creditar saldo na conta
	public void creditar(double valor) {
			saldo += valor;
		
	}
	// Método para debitar saldo da conta
	public void debitar(double valor) {
			saldo -= valor;
		
	}
	
	public static String obterChave(int agencia, String numero) {
		return StringUtils.formatar(agencia, 3) + numero;
				
	}
	
	public String getIdUnico() {
		return obterChave(agencia, numero);
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomeCorrentista() {
		return nomeCorrentista;
	}
	public void setNomeCorrentista(String nomeCorrentista) {
		this.nomeCorrentista = nomeCorrentista;
	}
	public double getSaldo() {
		return saldo;
	}
				
}
