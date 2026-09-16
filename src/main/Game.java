package main;

public class Game {
	 private int id;
	 private String title;
	 private Genre genre;
	 private double price;
	private int stock;
	
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
		return "Game [id=" + id + ", title=" + title + ", genre=" + genre + ", price=" + price + ", stock=" + stock
				+ "]";
	}
}
