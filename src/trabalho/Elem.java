/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 */
public class Elem {
	private final int size;
	private final String mod;
	public final Elem prv;

	public Elem(int i, String s,Elem e){
		size = i;
		mod = s;
		prv = e;
	}
	
	public Elem getPrv(){
		return prv;
	}

	public int getSize(){
		return size;
	}
	
	public String getMod(){
		return new String(mod);
	}
}
