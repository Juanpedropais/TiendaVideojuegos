package main;

public class Game {
	 private int id=0;
	 private String title;
	 private Genre genre;
	 private double price;
	private int stock;
	public Game(String title,Genre genre,double price,int stock) {
		this.id=id+1;
		this.title=title;
		this.genre=genre;
		this.price=price;
		this.stock=stock;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Genre getGenre() {
		return genre;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		if(stock>=0) {
			this.stock = stock;
		} else {
			System.out.println("El stock no puede ser menor a 0");
		}
	}
	public void sumStock(int sum) {
		if(sum>=0) {
			this.stock = sum+stock;
		} else {
			System.out.println("La suma no puede ser menor a 0");
		}
	}
	public void restStock(int rest) {
		if(rest>=0) {
			if(rest>this.stock) {
				System.out.println("No hay suficiente stock");
			}else {
				this.stock = stock-rest;
			}
		} else {
			System.out.println("La resta no puede ser menor a 0");
		}
	}
	public void ComprobarStock(int id) {
		if(id>this.id) {
			System.out.println("No existe un juego con ese ID");
		}else {
			for(int i=0;i<=this.id;i++){
				if(i==id) {
					System.out.println("El stocke del juego:"+this.id+" es:"+this.stock);
				}
			}
		}
	}
	public String toString() {
		return "El videojuego:"+this.id+" cuyo titulo es:"+this.title+" que es del genero:"+this.genre+
				" con el siguiente precio:"+this.price+" y hay la siguiente cantidad:"+this.stock;
	}
}
