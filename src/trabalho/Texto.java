/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.InputMismatchException;
import java.util.LinkedList;

/**
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 */
public class Texto {
	private final LinkedList<String> lista = new LinkedList<String>();	

	public Texto(){
		lista.add("");
	}

        public int insere(String palavra){
            
            int tamanhoLista=lista.size()-1;
            String atual;
            int tamPalavra;
            
            tamPalavra=palavra.length();
            atual = lista.get(tamanhoLista);
            atual = atual + palavra;
            if(atual.length()>400){
                lista.set(tamanhoLista, atual.substring(0, 401));
            }
            
            while (atual.length()>400){
                lista.add(atual.substring(0, 401));
                atual = atual.substring(401);
            }
            
            lista.add(atual);
            
            return tamPalavra;
        }
        
	public String remove(int i){
            int pos = lista.size()-1;
            int length = lista.get(pos).length();
            String ret="";
		

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