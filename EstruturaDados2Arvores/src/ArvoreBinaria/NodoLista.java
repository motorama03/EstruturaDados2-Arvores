package ArvoreBinaria;

public class NodoLista {
	private int dado;
	private NodoLista prox;
	
	public NodoLista(int dado) {
		this.dado = dado;
		prox = null;
	}
	public NodoLista() {
		prox = null;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public NodoLista getProx() {
		return prox;
	}

	public void setProx(NodoLista prox) {
		this.prox = prox;
	}
	
	
}
