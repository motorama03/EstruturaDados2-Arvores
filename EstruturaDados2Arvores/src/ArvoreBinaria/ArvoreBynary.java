package ArvoreBinaria;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBynary {
	private class Nodo{
		private int chave;
		private Nodo dir,esq;
		
		public Nodo(int item) {
			this.chave = item;
			dir = esq = null;
		}
	}
	
	ListaEncadeada listaEncadeada = new ListaEncadeada();
	private int tamanho_arvore = 0;
	Nodo raiz = null;
	
	public void mostraTabela() {
		NodoLista aux = inicio;
		do{
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}while(aux.getProx() != null);
		return;
	}
	
	// Inserir sem recursividade
	
	public void inserirSemRecursividade(int valor) {
	    Nodo novoNodo = new Nodo(valor);

	    if (raiz == null) {
	        raiz = novoNodo;
	        tamanho_arvore++;
	        return;
	    }

	    Nodo nodo = raiz;
	    Nodo aux;

	    while (true) {
	        aux = nodo;
	        if (valor < nodo.chave) {
	            nodo = nodo.esq;
	            if (nodo == null) {
	                aux.esq = novoNodo;
	                tamanho_arvore++;
	                return;
	            }
	        } else if (valor > nodo.chave) {
	            nodo = nodo.dir;
	            if (nodo == null) {
	                aux.dir = novoNodo;
	                tamanho_arvore++;
	                return;
	            }
	        } else {
	            // O valor já existe na árvore, então não é inserido novamente
	            return;
	        }
	    }
	}

	
	// Inserir arvore na lista encadeada
	public ListaEncadeada converterParaListaEncadeada() {
    	  converterLista(raiz);
    	  System.out.println("Árvore tranformada em lista encadeada");
    	  return listaEncadeada;
	 }

	private void converterLista(Nodo raiz) {
		if (raiz == null) {
			return;
		}
	    converterLista(raiz.esq);
	    listaEncadeada.InserirInicio(raiz.chave);   
	    listaEncadeada.getInicio();
	    converterLista(raiz.dir);
	}
	
	// Insiri um dado na árvore
	
	public void inserir(int chave) {
	    raiz = inserirDado(raiz, chave);
	}

	private Nodo inserirDado(Nodo raiz, int chave) {
	    if (raiz == null) {
	        raiz = new Nodo(chave);
	        InserirInicio(chave);
	        return raiz;
	    }
	    if (chave < raiz.chave) {
	        raiz.esq = inserirDado(raiz.esq, chave);
	    } else if (chave > raiz.chave) {
	        raiz.dir = inserirDado(raiz.dir, chave);
	    }
	    return raiz;
	}

	public void InserirInicio(int dado) {
	    NodoLista novoNodo = new NodoLista(dado);
	    novoNodo.setProx(inicio);
	    inicio = novoNodo;
	}
	
	// Mostra a altura da árvore
	
	public void encontraAlt() {
	    int tamTotal = encontraMaiorAltura(raiz);
	    System.out.println("A altura da árvore é: " + tamTotal);
	}

	private int encontraMaiorAltura(Nodo raiz) {
	    if (raiz == null) {
	        return 0;
	    }

	    int tamEsquerdo = encontraMaiorAltura(raiz.esq);
	    int tamDireito = encontraMaiorAltura(raiz.dir);

	    return Math.max(tamEsquerdo, tamDireito) + 1;
	}
	
	// Mostra o tamanho da árvore
	
	public void encontraTam() {
	    int tamTotal = encontraTam(raiz);
	    System.out.println("O tamanho da árvore é: " + tamTotal);
	}

	private int encontraTam(Nodo raiz) {
	    if (raiz == null) {
	        return 0;
	    }

	    int tamEsquerdo = encontraTam(raiz.esq);
	    int tamDireito = encontraTam(raiz.dir);

	    return (tamEsquerdo + tamDireito) + 1;
	}
	
	// Mostra o nivel do nó
	
	public int retornaNivel(int numero) {
        return retornaNv(raiz, numero, 0);
	 }
	
	private int retornaNv(Nodo nodo, int numero, int nivel) {
        if (nodo == null) {
            return -1;
        }
        if (nodo.chave == numero) {
            return nivel; 
        }

        int nivelEsquerda = retornaNv(nodo.esq, numero, nivel + 1);
        if (nivelEsquerda != -1) {
            return nivelEsquerda;
        }
        return retornaNv(nodo.dir, numero, nivel + 1);		       
 
	 }
	
	// Mostra os nós anteriores
	
	public void mostrarNósAnteriores(int chave) {
        System.out.print("Anteriores: ");
        mostrarNodosAnteriores(raiz, chave);
        System.out.println();
    }

    private boolean mostrarNodosAnteriores(Nodo raiz, int chave) {
        if (raiz == null) {
            return false;
        }

        if (raiz.chave == chave) {
            return true;
        }

        if (mostrarNodosAnteriores(raiz.esq, chave) || mostrarNodosAnteriores(raiz.dir, chave)) {
            System.out.print(raiz.chave + "; ");
            return true;
        }

        return false;
    }

    // Apresenta os nós sucessores
    // Apresenta juntamente as ramificações a esquerda e a direita
    
    public void mostrarNósSucessores(int chave) {
        System.out.println("\n");
        mostrarNodosSucessores(raiz, chave);
    }

    private void mostrarNodosSucessores(Nodo raiz, int chave) {
        if (raiz == null) {
            return;
        }

        if (raiz.chave == chave) {
            System.out.print("Sucessores a esquerda: ");
            acharNodosSuc(raiz.esq);
            System.out.print("\nSucessores a direita: ");
            acharNodosSuc(raiz.dir);
            return;
        }

        if (chave < raiz.chave) {
            mostrarNodosSucessores(raiz.esq, chave);
        } else {
            mostrarNodosSucessores(raiz.dir, chave);
        }
    }

    private void acharNodosSuc(Nodo nodo) {
        if (nodo != null) {
            acharNodosSuc(nodo.esq);
            System.out.print(nodo.chave + " ");
            acharNodosSuc(nodo.dir);
        }
    }

//	if(raiz.chave == noP) {
//		achouD = true;
//		return;
//	}
    
    // Procura as folhas da árvore
	
	public void descobreFolhas() {
		descobrindoFolhas(raiz);
	}
	
	private void descobrindoFolhas(Nodo raiz) {
		if(raiz != null) {
			descobrindoFolhas(raiz.esq);
			if(raiz.dir == null && raiz.esq == null) {
				System.out.println(raiz.chave+" é folha");
			}
			descobrindoFolhas(raiz.dir);
		}
		else
			return;
	}
	
	// Retorna o nó maior e o menor
	
	public void DescobreMaiorMenor() {
        if (raiz == null) {
            System.out.println("Árvore vazia!");
            return;
        }
        int menor = encontrarMenor(raiz);
        int maior = encontrarMaior(raiz);
        System.out.println("O maior Nodo é: " + maior + "\nE o menor é: " + menor);
    }

    private int encontrarMenor(Nodo raiz) {
        if (raiz.esq == null) {
            return raiz.chave;
        }
        return encontrarMenor(raiz.esq);
    }

    private int encontrarMaior(Nodo raiz) {
        if (raiz.dir == null) {
            return raiz.chave;
        }
        return encontrarMaior(raiz.dir);
    }
	
	public void showTreeInOrderUp() {
		showOrderUp(raiz);
	}
	
	private void showOrderUp(Nodo raiz) {		
		if(raiz != null) {
			showOrderUp(raiz.esq);
			showOrderUp(raiz.dir);
		}
	}
	
	// Mostra a árvore 
	
	public void showTreeInOrderDown() {
		showOrderDown(raiz);
	}
	
	private void showOrderDown(Nodo raiz) {
		if(raiz != null) {
			showDown(raiz.dir);
			System.out.println(raiz.chave);
			showDown(raiz.esq);
		}
	}
	
	private void showDown(Nodo raiz) {
		if(raiz != null) {
			showDown(raiz.esq);
			System.out.println(raiz.chave);
			showDown(raiz.dir);
		}
	}
	
	// Mostra os pares 
	
	public void retornaPar() {
		retornaPares(raiz);
	}
	
	private void retornaPares(Nodo raiz) {
		if(raiz != null) {
			retornaP(raiz.dir);
			if(raiz.chave % 2 == 0)
				System.out.println(raiz.chave);
			retornaP(raiz.esq);
		}
	}
	
	private void retornaP(Nodo raiz) {
		if(raiz != null) {
			retornaP(raiz.esq);
			if(raiz.chave % 2 == 0)
				System.out.println(raiz.chave);
			retornaP(raiz.dir);
		}
	}
	
	public void showInLevel() {
		if(raiz == null) {
			System.out.println("Árvore vazia!");
			return;
		}
		Queue<Nodo>fila = new LinkedList<>();
		fila.add(raiz);
		
		while(!fila.isEmpty()) {
			int tamanhoNivel = fila.size();
			for(int i=0;i<tamanhoNivel;i++) {
				Nodo nodoAtual = fila.poll();
				if(nodoAtual != null) {
					System.out.print(nodoAtual.chave + " ");
					fila.add(nodoAtual.esq);
					fila.add(nodoAtual.dir);
				}
				else {
					System.out.println("");
				}
			}
		}
	}
	
	public void remove(int chave) {
		raiz = removeItem(raiz,chave);
	}
	
	public Nodo removeItem(Nodo raiz, int chave) {
		if(raiz == null) {
			// Nó não encontrado, não faz nada
			return null;
		}
		if(chave < raiz.chave) {
			// Chave a ser removida está à esquerda
			raiz.esq = removeItem(raiz.esq, chave);
		}else if(chave > raiz.chave) {
			// chave a ser removida está a direita 
			raiz.dir = removeItem(raiz.dir, chave);
		}
		else {
			// Encontramos o nó a ser removido
			if(raiz.esq == null) {
				// Caso em que o nó não possui filho a esquerda
				return raiz.dir;
			}else if (raiz.dir == null) {
				// Caso em que o nó não possui filho a direita
				return raiz.esq;
			}else {
				// Caso em que o nó possui ambos os filhos 
				// Nó sucessor será o menor da subarvore a direita
				Nodo next = findNext(raiz.dir);
				// Substituindo o valor do Nó a ser removido pelo valor sucessor
				raiz.chave = next.chave;
				raiz.dir = removeItem(raiz.dir, next.chave);
			}
		}
		return raiz;
	}
	
	private Nodo findNext(Nodo nodo) {
		while(nodo.esq != null) {
			nodo = nodo.esq;
		}
		return nodo;
	}
	
	public void inserirLista(int chave) {
		raiz=inserirDado(raiz,chave);
	}
	
	private static NodoLista inicio = null; 
	
}
