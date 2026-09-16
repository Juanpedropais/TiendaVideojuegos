package main;

public class Purchase {
	Customer customer;
	Game game;
	int quantity;
	double totalPrice=0;
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
