/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.InputMismatchException;
import java.util.LinkedList;

/** Classe que contém as funções inserir e remover, assim como uma função adicional, chamada print
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 */
public class Texto {
	private final LinkedList<String> lista = new LinkedList<String>();	

	public Texto(){
		lista.add("");
	}

	public int insere(String palavra){  //Insere o texto
		
		int tamanhoLista=lista.size()-1;
		String atual;
		int tamPalavra;
		
		tamPalavra=palavra.length();
		atual = lista.get(tamanhoLista);
		atual = atual + palavra;
		if(atual.length()>400){ //Escolhemos que cada elemento da lista encadeada tenha, no máximo, 400 chars
			lista.set(tamanhoLista, atual.substring(0, 401)); //insere os valores da string de 0 a 400
                        atual = atual.substring(401);
		}
		
		while (atual.length()>400){ //caso o tamanho da string atual seja maior do que 400, são criados outros componentes da lista encadeada contendo as strings com, no máximo, 400 chars
			lista.add(atual.substring(0, 401));
			atual = atual.substring(401); //string atual é atualizada constantemente para adicionar nos próximos elementos da lista encadeada
		}
		
		lista.add(atual);
		
		return tamPalavra; //função retorna o tamanho do texto que foi adicionado
	}
		
	public String remove(int i){ //Função que remove a quantidade de chars que recebeu como parâmetro
		int pos = lista.size()-1;
		int length = lista.get(pos).length();
		String ret="";
		
		if(i<1){ //Caso não haja elementos na lista encadeada, então não é possível apagar nada
			return "";
		}

		while(true){
			if(length>i){ //Caso o tamanho de strings da lista seja maior do que o tamanho de elementos que se deseja apagar
				ret=ret.concat(lista.get(pos).substring(length-i,length));  //São apagadas as últimas letras desse elemento da lista
				lista.set(pos,lista.get(pos).substring(0,length-i));
				return ret;
			}else if(length==i){ //Caso o tamanho da lista seja exatamente igual ao tamanho de elementos que se deseja apagar
				ret=ret.concat(lista.get(pos)); // É apagado o elemento inteiro da lista encadeada
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

	public void print(){    //Função que printa o texto inteiro
		for (int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
	}
}