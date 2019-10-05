/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Gabriela Vidal
 * @author Rodrigo Piva
 */
public class Trabalho {
	/**
	 * @param args the command line arguments
	 */

	private static final Texto TEXTO = new Texto();

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		Pilha pilhaZ = new Pilha();
		Pilha pilhaY = new Pilha();
		
		String buffer="";
		
		String tmpStr;
		Elem tmpEl;
		int tmpInt;
		
		while(!buffer.equals("4")){
			TEXTO.print();
			System.out.println("|--------------------------------|");
			System.out.println("|(0)Inserir       |    (1)Remover|");
			System.out.println("|(2)Desfazer      |    (3)Refazer|");
			System.out.println("|              (4)Sair           |");
			System.out.println("|--------------------------------|");
			buffer=input.nextLine();
			
			switch(buffer){
				case "0":
					tmpStr=input.nextLine();

					tmpInt=TEXTO.insere(tmpStr);
					
					if(tmpInt!=0){
						pilhaZ.push("",tmpInt);
						pilhaY.clear();
					}

					break;

				case "1":
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

				case "2":
					tmpEl = pilhaZ.pop();

					if(tmpEl==null){
						break;
					}

					tmpInt=tmpEl.getSize();
					tmpStr=tmpEl.getMod();
					
					if(tmpInt==0){
						tmpInt = TEXTO.insere(tmpStr);
						tmpStr = "";
					}else{
						tmpStr = TEXTO.remove(tmpInt);
						tmpInt = 0;
					}

					pilhaY.push(tmpStr,tmpInt);
					break;

				case "3":
					tmpEl = pilhaY.pop();
					if(tmpEl==null){
						break;
					}

					tmpInt=tmpEl.getSize();
					tmpStr=tmpEl.getMod();
					
					if(tmpInt==0){
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
