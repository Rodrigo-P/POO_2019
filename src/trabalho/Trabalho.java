/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Classe que contém a main
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 * @version 1.0
 */

public class Trabalho {
	/**
	 * @param args the command line arguments
	 */

	private static final Texto TEXTO = new Texto();

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		Pilha pilhaZ = new Pilha(); //pilhaZ realiza a função de desfazer comandos feitos anteriormente
		Pilha pilhaY = new Pilha(); //pilhaY realiza a função de refazer os comandos
		
		String buffer="";
		
		String tmpStr;
		Elem tmpEl;
		int tmpInt;
		
		while(!buffer.equals("4")){
			TEXTO.print();
			//Interface no terminal feita para que seja possível acessar os comandos na linha de comando
			System.out.println("|--------------------------------|");
			System.out.println("|(0)Inserir       |    (1)Remover|");
			System.out.println("|(2)Desfazer      |    (3)Refazer|");
			System.out.println("|              (4)Sair           |");
			System.out.println("|--------------------------------|");

			buffer=input.nextLine();
			
			switch(buffer){
				case "0":   //Insere o texto escrito na linha de comando
					tmpStr=input.nextLine();

					tmpInt=TEXTO.insere(tmpStr);
					
					if(tmpInt!=0){
						pilhaZ.push("",tmpInt);
						pilhaY.clear();
					}

					break;

				case "1":   //Remove os últimos chars adicionados no texto
					try{
						tmpInt=input.nextInt();
					}catch(InputMismatchException e){
						input.nextLine();
						tmpInt=0;
					}
					
					tmpStr=TEXTO.remove(tmpInt);
					
					if(!tmpStr.equals("")){	
						pilhaZ.push(tmpStr,0);
						pilhaY.clear();
					}
					
					break;

				case "2": //Desfaz o último comando realizado pelo usuário
					tmpEl = pilhaZ.pop();

					if(tmpEl==null){    //Se isso ocorrer, então não há um comando anterior para ser realizado
						break;
					}

					tmpInt=tmpEl.getSize();
					tmpStr=tmpEl.getMod();
					
					if(tmpInt==0){  //Caso seja zero, significa que o último comando realizado foi uma remoção
						tmpInt = TEXTO.insere(tmpStr);  //Então é inserido o texto removido anteriormente
						tmpStr = "";
					}else{  //Se for diferente de zero, então o último comando realizado foi uma inserção
						tmpStr = TEXTO.remove(tmpInt);  //Então é removido o texto inserido anteriormente
						tmpInt = 0;
					}

					pilhaY.push(tmpStr,tmpInt);
					break;

				case "3": //Refaz o último comando realizado pelo usuário
					tmpEl = pilhaY.pop();
					if(tmpEl==null){    //Caso não tenha ocorrido nenhuma modificação anterior, ele não realiza nada
						break;
					}

					tmpInt=tmpEl.getSize();
					tmpStr=tmpEl.getMod();
					
					if(tmpInt==0){ //Caso seja zero, então é inserido o texto que foi removido anteriormente
						tmpInt = TEXTO.insere(tmpStr);
						tmpStr = "";
					}else{
						tmpStr = TEXTO.remove(tmpInt);
						tmpInt = 0;
					}

					pilhaZ.push(tmpStr,tmpInt);

					break;
			}
		}
	}
	
}
