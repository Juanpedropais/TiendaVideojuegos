package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NoExisteContenido, SaldoInsuficiente {
		System.out.println("Bienvenido al sistema de Tienda Videojuego por favor pulse una opción:"+
	"add game-Añadir un juego "+
				"add client-Añadir un cliente "+
	"delete game-Eliminar un juego "+
				"delete client-Eliminar un cliente "+
				"games-Mostrar todos los videojuegos "+
				"clients-Mostrar todos los clientes "+
				"game id-Buscar Videojuego por ID "+
				"client id-Buscar Cliente por ID "+
				"game titulo-Buscar Videojuego por nombre "+
	"game genero-Buscar Videojuego por genero "+
				"buy id-Comprar Videojuego por ID "+
	"buy titulo-Comprar Videojuego por nombre "+
				"buy genero-Comprar Videojuego por genero");
		Scanner sc=new Scanner(System.in);
		Store s=new Store();
		String contestacion=sc.nextLine();
		if(contestacion=="add game") {
			System.out.println("Por favor dame el nombre,el genero,el precio y la cantidad");
			String nombre=sc.nextLine();
			String genero=sc.nextLine().toUpperCase();
			Genre genero2=Genre.valueOf(genero);
			double precio=sc.nextDouble();
			int cantidad=sc.nextInt();
			s.AñadirVideojuego(nombre, genero2, precio, cantidad);
		} else if(contestacion=="add client") {
			System.out.println("Por favor dame el nombre y el saldo");
			String nombre=sc.nextLine();
			double saldo=sc.nextDouble();
			s.AñadirCliente(nombre, saldo);
		} else if(contestacion=="delete game") {
			System.out.println("Por favor dame el ID");
			int ID=sc.nextInt();
			s.EliminarVideojuego(ID);
		} else if(contestacion=="delete client") {
			System.out.println("Por favor dame el ID");
			int ID=sc.nextInt();
			s.EliminarCliente(ID);
		} else if(contestacion=="games") {
			s.MostrarVideojuegos();
		} else if(contestacion=="clients") {
			s.MostrarClientes();
		} else if(contestacion=="game id") {
			System.out.println("Por favor dame el ID");
			int ID=sc.nextInt();
			s.BuscarVideojuegos(ID);
		} else if(contestacion=="client id") {
			System.out.println("Por favor dame el ID");
			int ID=sc.nextInt();
			s.BuscarClientes(ID);
		} else if(contestacion=="game titulo") {
			System.out.println("Por favor dame el nombre");
			String nombre=sc.nextLine();
			s.BuscarTexto(nombre);
		} else if(contestacion=="game genero") {
			System.out.println("Por favor dame el genero");
			String genero=sc.nextLine().toUpperCase();
			Genre genero2=Genre.valueOf(genero);
			s.BuscarGenero(genero2);
		} else if(contestacion=="buy id") {
			System.out.println("Por favor dame el ID del videojuego,el ID del cliente,y la cantidad");
			int ID_cliente=sc.nextInt();
			int ID_videojuego=sc.nextInt();
			int cantidad=sc.nextInt();
			s.ComprarVideojuego(ID_cliente, ID_videojuego, cantidad);
		} else if(contestacion=="buy titulo") {
			System.out.println("Por favor dame el nombre del videojuego,el ID del cliente,y la cantidad");
			int ID_cliente=sc.nextInt();
			String nombre=sc.nextLine();
			int cantidad=sc.nextInt();
			s.ComprarVideojuegoTexto(ID_cliente, nombre, cantidad);
		} else if(contestacion=="buy genero") {
			System.out.println("Por favor dame el genero del videojuego,el ID del cliente,y la cantidad");
			int ID_cliente=sc.nextInt();
			String genero=sc.nextLine().toUpperCase();
			Genre genero2=Genre.valueOf(genero);
			int cantidad=sc.nextInt();
			s.ComprarVideojuegoGenero(ID_cliente, genero2, cantidad);
		} else {
			System.out.println("Por favor conteste escribiendo una de las opciones");
		}
	}
}
