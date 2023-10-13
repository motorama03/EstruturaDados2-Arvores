package ArvoreBinaria;

public class ListaEncadeada {
	private NodoLista inicio;

	public ListaEncadeada () {
		inicio = null;
	}
	public NodoLista getInicio() {
		return inicio;
	}
	
	
	public void InserirInicio(int dado) {
		NodoLista novoNodo = new NodoLista(dado);
		if(inicio == null) {
			novoNodo.setProx(inicio);
			inicio = novoNodo;
		}else InserirFinal(dado);
	}
	
	public void InserirFinal(int dado) {
		NodoLista novoNodo = new NodoLista(dado);
		if(inicio == null)
			InserirInicio(dado);
		
		NodoLista aux = inicio;
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novoNodo);
		aux.getProx().setProx(null);;
	}
	
	public int QuantidadeNodos() {
		NodoLista aux = inicio;
		int qnt = 0;
		do{
			aux = aux.getProx();
			qnt++;
		}while(aux != null);
		return qnt;
	}
	public String QuantidadeIgualNodoInf(int dado) {
		StringBuilder saida = new StringBuilder();
		NodoLista aux = inicio;
//		Nodo auxPosic = inicio;
		NodoLista posicNodo = new NodoLista();
		int qntNodosI = 0;
		int posic = 0;
		int qntMaior = 0;
		do {
			posic ++;
			if(aux.getDado() > dado)
				qntMaior ++;
			
			if(aux.getDado() == dado) {	
				qntNodosI ++;
				posicNodo.getProx().setDado(posic);
			}
			aux.getProx();
		}while(aux.getProx() != null);
		saida.append("A quantidade de Nodos iguais ao informado é : "+qntNodosI+"\n");
		saida.append("A quantidade de Nodos Maiores que o informado é: "+qntMaior+"\n");
		saida.append("A posição dos Nodos iguais é \n");
		for(int i = 0; i < qntNodosI; i++) {
			saida.append(posicNodo.getDado()+", ");
			posicNodo.getProx();
		}
		return saida.toString();
	}
	public int mostraTabela() {
		NodoLista aux = inicio;
		do{
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}while(aux.getProx() != null);
		return 0;
	}
}
