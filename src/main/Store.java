package main;

import java.util.ArrayList;

public class Store {
	ArrayList<Game> games=new ArrayList<>();
	ArrayList<Customer> customers=new ArrayList<>();
	ArrayList<Purchase> purchases=new ArrayList<>();
	public void AñadirVideojuego(String tittle,Genre genre,double price,int stock) {
		games.add(new Game(tittle,genre,price,stock));
	}
	public void BuscarVideojuegos(int id) throws NoExisteContenido {
		boolean videojuegoEncontrado=false;
		if(id<=games.size() && id>0) {
			for(Game g:games) {
				if(g.getId()==id) {
					System.out.println("El juego:"+g.getId()+" tiene como titulo:"+g.getTitle()+
							" que es del siguiente genero:"+g.getGenre()+" con el siguiente precio:"+
							g.getPrice()+" y hay la siguiente cantidad:"+g.getStock());
					videojuegoEncontrado=true;
					break;
				}
			}
			if(videojuegoEncontrado == false) {
				System.out.println("No se encontro ningún videojuego con ese ID");
			}
		}else {
			throw new NoExisteContenido("El id no puede ser menor a 0 y debe estar dentro de los ids creados");
		}
	}
	public void BuscarClientes(int id) throws NoExisteContenido {
		boolean clienteEncontrado=false;
		if(id<=customers.size() && id>0) {
			for(Customer c:customers) {
				if(c.getId()==id) {
					System.out.println("El cliente:"+c.getId()+" tiene como nombre:"+c.getName()+
							" con un saldo de:"+c.getBalance());
					clienteEncontrado=true;
					break;
				}
			}
			if(clienteEncontrado == false) {
				System.out.println("No se encontro ningún cliente con ese ID");
			}
		}else {
			throw new NoExisteContenido("El id no puede ser menor a 0 y debe estar dentro de los ids creados");
		}
	}
	public void BuscarTexto(String tittle) {
		for(Game g:games) {
			if(g.getTitle().equalsIgnoreCase(tittle)) {
				System.out.println(g.getTitle());
			}
		}
	}
	public void BuscarGenero(Genre genre) {
		for(Game g:games) {
			if(g.getGenre().equals(genre)) {
				System.out.println("El juego:"+g.getId()+" tiene como titulo:"+g.getTitle()+
						" que es del siguiente genero:"+g.getGenre()+" con el siguiente precio:"+
						g.getPrice()+" y hay la siguiente cantidad:"+g.getStock());
			}
		}
	}
	public void ComprarVideojuego(int id_cliente,int id_videojuego,int stock) throws NoExisteContenido, SaldoInsuficiente {
		BuscarVideojuegos(id_videojuego);
		BuscarClientes(id_cliente);
		if(stock>0) {
			for(Game g:games) {
				if(g.getId()==id_videojuego) {
					if(g.getStock()>=stock) {
						for(Customer c:customers) {
							if(c.getId()==id_cliente) {
								if(c.getBalance()>=g.getPrice()*stock) {
									g.restStock(stock);
									c.restBalance(g.getPrice()*stock);
									Purchase p=new Purchase(c,g,stock);
									purchases.add(p);
								}else {
									System.out.println("No existe saldo suficiente");
								}
							}
						}
					}else {
						System.out.println("No existe stock suficiente");
					}
				}
			}
		} else {
			System.out.println("La cantidad no puede ser igual o menor a 0");
		}
	}
}
