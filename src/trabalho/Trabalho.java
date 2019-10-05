/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.Scanner;

/**
 *
 * @author rodrigo
 */
public class Trabalho {
	/**
	 * @param args the command line arguments
	 */

	private static final Texto texto = new Texto();

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String buffer="";
		String tmpStr;
		int tmpInt;
		
		while(!buffer.equals("4")){
			texto.print();
			System.out.println("|--------------------------------|");
			System.out.println("|(0)Inserir       |    (1)Remover|");
			System.out.println("|(2)Desfazer      |    (3)Refazer|");
			System.out.println("|              (4)Sair           |");
			System.out.println("|--------------------------------|");
			buffer=input.nextLine();
			
			switch(buffer){
				case "0":
					tmpInt=texto.insere();
					break;

				case "1":
					tmpStr=texto.remove();
					System.out.print("Removido: ");
					System.out.println(tmpStr);
					break;

				case "2":
					break;

				case "3":
					break;
			}
		}
	}
	
}
