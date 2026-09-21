package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
	ArrayList<Game> games=new ArrayList<>();
	ArrayList<Customer> customers=new ArrayList<>();
	ArrayList<Purchase> purchases=new ArrayList<>();
	public Store() {
		Game j1 = new Game(1,"Uncharted",Genre.ADVENTURE,81.79,200);
		Game j2 = new Game(2,"Call Of Duty",Genre.ACTION,100.99,200);
		Game j3 = new Game(3,"Mario Bros",Genre.PLATFORM,59.01,200);
		int a=0;
		games.add(j1);
		games.add(j2);
		games.add(j3);
	}
	public void loadGames(String filename) {
		File file = new File(filename);
		try(Scanner sc = new Scanner(file)){
			String line = null;
			while(sc.hasNextLine()) {
				line=sc.nextLine();
				String[] splitline=line.split(";");
				int id=Integer.parseInt(splitline[0]);
				String name=splitline[1];
				Genre genre=Genre.valueOf(splitline[2]);
				double price=Double.parseDouble(splitline[3]);
				int stock=Integer.parseInt(splitline[4]);
				Game g=new Game(id,name,genre,price,stock);
				games.add(g);
			}
		}catch(Exception e) {
			System.out.println("El archivo no se cargo correctamente");
		}
	}
	public void loadCustomers(String filename) {
		File file = new File(filename);
		try(Scanner sc = new Scanner(file)){
			String line = null;
			while(sc.hasNextLine()) {
				line=sc.nextLine();
				String[] splitline=line.split(";");
				int id=Integer.parseInt(splitline[0]);
				String name=splitline[1];
				double balance=Double.parseDouble(splitline[2]);
				Customer c=new Customer(id,name,balance);
				customers.add(c);
			}
		}catch(Exception e) {
			System.out.println("El archivo no se cargo correctamente");
		}
	}
	public void AñadirVideojuegos(Game g) throws NoExisteID {
		for(Game videojuego:games) {
			if(g.equals(videojuego)) throw new NoExisteID("El juego con id x ya existe");
		}
		games.add(g);
	}
	public void AñadirCliente(Customer c) throws NoExisteID {
		for(Customer cliente:customers) {
			if(c.equals(cliente)) throw new NoExisteID("El cliente con id x ya existe");
		}
	}
	public Game BuscarVideojuegos(int id) throws NoExisteID {
		for(Game videojuego:games) {
			if(videojuego.getId()==id) return videojuego;
		}
		throw new NoExisteID("No existe ID");
	}
	public Customer BuscarClientes(int id) throws NoExisteID {
		for(Customer clientes:customers) {
			if(clientes.getId()==id) return clientes;
		}
		throw new NoExisteID("No existe ID");
	}
	public ArrayList<Game> BuscarPorTitulo(String title){
		String LowerTitle = title.toLowerCase();
		ArrayList<Game> videojuegos=new ArrayList<Game>();
		for(Game videojuego: games) {
			if(videojuego.getTitle().toLowerCase().contains(LowerTitle)) videojuegos.add(videojuego);
		}
		return videojuegos;
	}
	public ArrayList<Game> BuscarPorGenero(Genre genre){
		ArrayList<Game> videojuegos=new ArrayList<Game>();
		for(Game videojuego: games) {
			if(videojuego.getGenre() == genre) videojuegos.add(videojuego);
		}
		return videojuegos;
	}
	public void MostrarVideojuegos() {
		for(Game g:games) {
			g.toString();
		}
	}
	public void MostrarClientes() {
		for(Customer c:customers) {
			c.toString();
		}
	}
	public void ComprarVideojuego(int IDcliente,int IDvideojuego,int stock) throws CantidadInvalida, NoExisteID {
		Game g = BuscarVideojuegos(IDvideojuego);
		if(g==null) throw new CantidadInvalida("No existe el juego");
		Customer c=BuscarClientes(IDcliente);
		if(c==null) throw new CantidadInvalida("No existe el juego");
		if(stock < 1) throw new CantidadInvalida("Cantidad no valida");
		if(!g.ComprobarStock(stock))throw new CantidadInvalida("No hay stock suficiente");
		double precio=g.getPrice() * stock;
		if(c.dispone(stock))throw new CantidadInvalida("No hay stock suficiente");
		Purchase p = new Purchase(c,g,stock);
		purchases.add(p);
		g.restStock(-stock);
		c.restBalance(precio);
		
	}
	public void ComprarVideojuegoTexto(int id_cliente,String titulo_Videojuego,int stock) throws NoExisteID, CantidadInvalida  {
		BuscarPorTitulo(titulo_Videojuego);
		BuscarClientes(id_cliente);
		if(stock>0) {
			for(Game g:games) {
				if(g.getTitle().equalsIgnoreCase(titulo_Videojuego)) {
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
	public void ComprarVideojuegoGenero(int id_cliente,Genre genero_Videojuego,int stock) throws NoExisteID, CantidadInvalida {
		BuscarPorGenero(genero_Videojuego);
		BuscarClientes(id_cliente);
		if(stock>0) {
			for(Game g:games) {
				if(g.getTitle().equals(genero_Videojuego)) {
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
	public void EliminarVideojuego(int id) {
		boolean videojuegoEliminado=false;
		if(id<games.size() &&id>0) {
			for(Game g:games) {
				if(g.getId()==id) {
					games.remove(id);
					videojuegoEliminado=true;
				}
				if(videojuegoEliminado==true) {
					for(int i=0;i<games.size();i++) {
						if(games.get(i)==null) {
							for(int j=i;j<games.size();j++) {
								if(games.get(j)!=null) {
									games.get(j).restId();
								}
							}
						}
					}
				}
			}
		}else {
			System.out.println("El ID no puede ser menor a 0 y debe de estar dentro de los ids creados");
		}
	}
	public void EliminarCliente(int id) {
		boolean clienteEliminado=false;
		if(id<customers.size() &&id>0) {
			for(Customer c:customers) {
				if(c.getId()==id) {
					customers.remove(id);
					clienteEliminado=true;
				}
				if(clienteEliminado==true) {
					for(int i=0;i<customers.size();i++) {
						if(customers.get(i)==null) {
							for(int j=i;j<customers.size();j++) {
								if(customers.get(j)!=null) {
									customers.get(j).restId();
								}
							}
						}
					}
				}
			}
		}else {
			System.out.println("El ID no puede ser menor a 0 y debe de estar dentro de los ids creados");
		}
	}
}

