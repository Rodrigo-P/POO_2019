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
public class Elem {
	private final int size;
	private final String mod;
	private elem prv;

	public elem(int i, String s){
		size=i;
		mod=s;
	}
	
	public elem getPrv(){
		
	}

	public int getSize(){
		return size;
	}
	
	public String getMod(){
		return new String(mod);
	}	
}
