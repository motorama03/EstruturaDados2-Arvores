package ArvoreBinaria;

public class Pomar {
	
	public static void main(String[] args) {
	
	ArvoreBynary arvore = new ArvoreBynary();
	
//	System.out.println("Lista com recursividade");
//	arvore.inserir(50);
//	arvore.inserir(90);
//	arvore.inserir(38);
//	arvore.inserir(40);
//	arvore.inserir(15);
//	arvore.inserir(92);
//	arvore.inserir(10);
	
	System.out.println("Lista sem recursividade: ");
	arvore.inserirSemRecursividade(50);
	arvore.inserirSemRecursividade(90);
	arvore.inserirSemRecursividade(38);
	arvore.inserirSemRecursividade(40);
	arvore.inserirSemRecursividade(15);
	arvore.inserirSemRecursividade(92);
	arvore.inserirSemRecursividade(10);
	
	arvore.showTreeInOrderDown();
	
	System.out.println("Árvore inteira: ");
	arvore.showTreeInOrderDown();
	System.out.println("Folhas da árvore: ");
	arvore.descobreFolhas();
	System.out.println("Nós maior e menor: ");
	arvore.DescobreMaiorMenor();
	arvore.mostrarNósSucessores(50);
	System.out.println();
	arvore.mostrarNósAnteriores(15);
	
	//arvore.remove(40);
	
	System.out.println("\nAfter remove the leaf's: ");
	arvore.showTreeInOrderDown();
	//System.out.println("\nLista Encadeada: ");
	//arvore.mostraTabela();
	System.out.println("\nNós pares: ");
	arvore.retornaPar();
	System.out.println("Tamanho da árvore: ");
	arvore.encontraTam();
	System.out.println("Altura da árvore");
	arvore.encontraAlt();
	System.out.println(arvore.converterParaListaEncadeada().mostraTabela());
	System.out.println("Retorna o nível: ");
	arvore.retornaNivel(15);
	System.out.println(3);
	}
}
