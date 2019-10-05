/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.InputMismatchException;
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
		lista.add("kk");
		lista.add(" | ");
		lista.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		lista.add(" | ");
		lista.add("Afersons");
	}


	public String remove(){
		int i;
		int pos = lista.size()-1;
		int length = lista.get(pos).length();
		String ret="";

		try{
			i=in.nextInt();
		}catch(InputMismatchException e){
			in.nextLine();
			i=0;
		}
		

		if(i<1){
			return "";
		}

		while(true){
			if(length>i){
				ret=ret.concat(lista.get(pos).substring(length-i,length));
				lista.set(pos,lista.get(pos).substring(0,length-i));
				return ret;
			}else if(length==i){
				ret=ret.concat(lista.get(pos));
				lista.remove(pos);
				return ret;
			}else{
				ret=ret.concat(lista.get(pos));
				if(pos==0){
					lista.set(pos,"");
					return ret;
				}else{
					lista.remove(pos);
					i-=length;
					pos--;
					length = lista.get(pos).length();
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