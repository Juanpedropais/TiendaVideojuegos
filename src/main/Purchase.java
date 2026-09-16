package main;

public class Purchase {
	Customer customer;
	Game game;
	int quantity;
	double totalPrice;
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
		totalPrice=game.getPrice()*quantity;
		return totalPrice;
	}
}
