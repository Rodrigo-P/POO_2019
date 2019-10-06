/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/** Classe que contém algumas implementações das funções Refaz e Desfaz
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 */

public class Pilha {
	private Elem topo;
	
	public Pilha(){
		topo=null;
	}

	public Elem pop(){  //retira o elemento do topo da pilha
		Elem topoAt = topo;
		if(topo != null){
			topo = topo.prv;
		}
		return topoAt;
	}

	public void push(String palavra, int tam){  //Insere um elemento no topo da pilha
		topo = new Elem(tam, palavra, topo);
	}
	
	public void clear (){   //Limpa toda a pilha
		topo = null;
	}
}
