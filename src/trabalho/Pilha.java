/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author rodrigo
 */

public class Pilha {
	private Elem topo;
	
	public Pilha(){
		topo=null;
	}

	public Elem pop(){
            Elem topoAt = topo;
            topo = topo.prv;
            return topoAt;
	}

	public void push(String palavra, int tam){
            topo = new Elem(tam, palavra, topo);
	}
        
        public void clear (){
            topo = null;
        }
	
}
