package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.cesarschool.next.poo.projetoreferencia.produto.Produto;
import br.edu.cesarschool.next.poo.projetoreferencia.produto.ProdutoCestaBasica;
import br.edu.cesarschool.next.poo.projetoreferencia.utils.DAOGenerico;
import br.edu.cesarschool.next.poo.projetoreferencia.utils.Registro;
import br.edu.cesarschool.next.poo.projetoreferencia.utils.StringUtils;

public class MediatorContaCorrente {
	private static final String CONTA_NAO_EXISTENTE = "Conta não existe";
	private DAOGenerico dao = new DAOGenerico(ContaCorrente.class);
	
	private String validar(double valor, int agencia, String numero) {
		// TODO Auto-generated method stub
		return null;
	}
	private String validar(ContaCorrente conta) {
		
		if (conta == null) {
			return CONTA_NAO_EXISTENTE;
		}
		
		if (conta.getAgencia() < 1 || conta.getAgencia() > 1000) {
			return "Número da agência inválido";
		}		
		if (StringUtils.stringVazia(conta.getNumero()) || StringUtils.stringEhNumeroInteiro(conta.getNumero()) || conta.getNumero().length() != 5) {
			return "Número invalido";
		}
		if (conta.getSaldo() < 0) {
			return "Saldo inválido";
		}
		if (StringUtils.stringVazia(conta.getNomeCorrentista()) || conta.getNomeCorrentista().length() > 60) {
			return "Nome inválido";
		}
		if (conta instanceof ContaPoupanca) {
			ContaPoupanca contaPouanca = (ContaPoupanca)conta;
			return this.validarContaPoupanca(contaPouanca);		
		}
		return null;
		
	}
	private String validarContaPoupanca(ContaPoupanca contaPoupanca) {
		if (contaPoupanca.isPercentualBonus() < 0) {
			return "Bonus invalido";		
		} 
		return null;
	}
	
	public String incluirContaCorrente(ContaCorrente conta) {
		String mensagem = validar(conta);
		if (mensagem != null) {
			return mensagem;
		}
		boolean sucesso = dao.incluir(conta);
		if(!sucesso) {
			return CONTA_NAO_EXISTENTE;
		}
		return null;
	}
	
	
	public ContaCorrente buscar(int agencia, String numero) {
		return (ContaCorrente)dao.buscar(ContaCorrente.obterChave(agencia, numero));		
	}
	
	public String creditar(double valor, int agencia, String numero) {
		
		String mensagem = validar(valor, agencia, numero);
		if (mensagem != null) {
			return mensagem;
		}
		ContaCorrente conta = (ContaCorrente) buscar(agencia, numero);
		
		if (conta == null) {
			return CONTA_NAO_EXISTENTE;
		}
		if(valor < 0) {
			return "Valor inválido";
		}
		if (agencia < 1 || agencia > 1000) {
			return "Número da agência inválido";
		}
		
		conta.creditar(valor);
		if(!dao.alterar(conta)) {
			return CONTA_NAO_EXISTENTE;
		}
		return null;
	}
	
	
	public String debitar(double valor, int agencia , String numero) {
		
		String msg = validar(valor, agencia, numero);
		if (msg != null) {
			return msg;
		}
		ContaCorrente conta = (ContaCorrente) buscar(agencia, numero);
		
		if (conta == null) {
			return "Conta não existe";
		}
		
		if(valor < 0) {
			return "Valor inválido";
		}
		if (agencia < 1 || agencia > 1000) {
			return "Número da agência inválido";
		}
		
		conta.debitar(valor);
		if(!dao.alterar(conta)) {
			return "Conta não existe";
		}
		return null;
	}
	
	String alterar(ContaCorrente conta) {
		String mensagem = validar(conta);
		if (mensagem == null) {
			boolean retorno = dao.alterar(conta);
			if(!retorno) {
				return "Conta não existe";
			}else {
				return null;
			}
		}else {
			return mensagem;
		}
	}
	
	String excluir(int agencia, String numero) {
		boolean retorno = dao.excluir(ContaCorrente.obterChave(agencia, numero));
		if(!retorno) {
			return "Conta não existente";
		}
		return null;
	}
}
