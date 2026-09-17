package main;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Bienvenido al sistema de Tienda Videojuego por favor pulse una opción:"+
	"add game <titulo><genero><precio><cantidad>-Añadir un juego "+
				"add client <nombre><saldo>-Añadir un cliente "+
	"delete game <id>-Eliminar un juego "+
				"delete client <id>-Eliminar un cliente "+
				"games-Mostrar todos los videojuegos "+
				"clients-Mostrar todos los clientes "+
				"game <id>-Buscar Videojuego por ID "+
				"client <id>-Buscar Cliente por ID "+
				"game <titulo>-Buscar Videojuego por nombre "+
	"game <genero>-Buscar Videojuego por genero "+
				"buy <id>-Comprar Videojuego por ID "+
	"buy <titulo>-Comprar Videojuego por nombre "+
				"buy <genero>-Comprar Videojuego por genero");
	}

}
