/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/** Contém o Elem, utilizado para a pilha
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 */

public class Elem { //
	private final int size;
	private final String mod;
	public final Elem prv;

	public Elem(int i, String s,Elem e){ //Função que cria um novo Elem
		size = i;
		mod = s;
		prv = e;
	}
	
	public Elem getPrv(){   //Função que retorna o elemento anterior
		return prv;
	}

	public int getSize(){ //Função que retorna o parâmetro size de Elem
		return size;
	}
	
	public String getMod(){ //Função que retorna a string de Elem
		return new String(mod);
	}
}
