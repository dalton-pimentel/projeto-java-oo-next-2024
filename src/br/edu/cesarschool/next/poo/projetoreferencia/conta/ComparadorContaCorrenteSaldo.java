package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import java.util.Comparator;

import br.edu.cesarschool.next.poo.projetoreferencia.produto.Produto;

public class ComparadorContaCorrenteSaldo implements Comparator {

	public ComparadorContaCorrenteSaldo() {
	}


	
	
	
	public int compare(ContaCorrente o1, ContaCorrente o2) {
		if(o1.getSaldo() > o2.getSaldo()) {
			return 1;
		}
		if(o1.getSaldo() < o2.getSaldo()) {
			return -1;
		}else {
			return 0;
		}
	}


	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
