/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author rodrigo
 */
public class Texto {
	private final LinkedList<String> lista = new LinkedList<String>();
	private final Scanner in = new Scanner(System.in);	

	public Texto(){
		lista.add("kk ABCDEFGHIJKLMNOPQRSTUVWXYZ Afersons");	
	}


	public String remove(){
		int i;
		int pos = lista.size()-1;
		int length = lista.get(pos).length();
		String ret="";

		i=in.nextInt();

		while(true){
			if(length>i){
				ret=lista.get(pos).substring(length-i,length-1);
				lista.set(pos,lista.get(pos).substring(0,length-i-1));
				return ret;
			}else if(length==i){
				ret=lista.get(pos);
				lista.remove(pos);
				return ret;
			}else{
				ret=ret.concat(lista.get(pos));
				if(pos!=0){
					lista.remove(pos);
					i-=length;
					pos--;
				}else{
					lista.set(pos,"");
					i=0;
				}
			}
		}
	}

	public void print(){
		for (int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
	}
}