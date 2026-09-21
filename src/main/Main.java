package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NoExisteID  {
		Store store=new Store();
		try(Scanner sc=new Scanner(System.in)){
			String input="";
			while(!input.equals("quit")) {
				input = sc.nextLine();
				String[] command=input.split(" ");
				switch(command[0]) {
				case "game":
					int id= Integer.parseInt(command [1]);
					System.out.println(store.BuscarVideojuegos(id).toString());
					break;
				case "games":
					store.MostrarVideojuegos();
					break;
				case "customers":
					store.MostrarClientes();
					break;
				case "search":
					System.out.println(store.BuscarPorTitulo(command [1]));
					break;
				
				}
			}
		}
	}
}
