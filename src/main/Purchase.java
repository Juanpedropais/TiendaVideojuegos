package main;

public class Purchase {
	Customer customer;
	Game game;
	int quantity;
	double totalPrice=0;
	public Purchase(Customer customer, Game game, int quantity) {
		this.customer=customer;
		this.game=game;
		this.quantity=quantity;
		this.totalPrice=game.getPrice()*quantity;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Game getGame() {
		return game;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
}
