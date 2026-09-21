package main;

public class Game {
	 private int id;
	 private String title;
	 private Genre genre;
	 private double price;
	private int stock;
	public Game(int id,String title,Genre genre,double price,int stock) {
		this.id=id;
		this.title=title;
		this.genre=genre;
		this.price=price;
		this.stock=stock;
	}
	public int getId() {
		return id;
	}
	public void restId() {
		this.id=id-1;
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
	public void sumStock(int sum) throws CantidadInvalida {
		if(sum<0) throw new CantidadInvalida("Cantidad invalida");
			stock += sum;
	}
	public void restStock(int rest) throws CantidadInvalida {
		if(rest<0) throw new CantidadInvalida("Cantidad invalida");
		if(rest>stock) throw new CantidadInvalida("Cantidad invalida");
		stock-=rest;
	}
	public void modStock(int stock) throws CantidadInvalida {
		if(stock>0) sumStock(stock);
		else restStock(-stock);
	}
	public boolean ComprobarStock(int cantidad) {
		return stock >= cantidad;
	}
	public String toString() {
		return String.format("""
				ID: %d
				Title: %s
				Genre: %s
				Price: %.2f
				Stock: %d
				""",
				id,title,genre,price,stock);
	}
}
