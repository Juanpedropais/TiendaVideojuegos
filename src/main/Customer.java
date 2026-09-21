package main;

public class Customer {
	int id;
	String name;
	double balance;
	public Customer(int id,String name,double balance) {
		this.id=id;
		this.name=name;
		this.balance=balance;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	public void sumBalance(double sum) {
		balance += sum;
	}
	public void restBalance(double rest) {
		balance -= rest;
	}
	public boolean dispone(double balance) {
		return balance >= balance;
	}
	public String toString() {
		return String.format("""
				ID: %d
				Name: %s
				Balance: %.2f
				""",
				id,name,balance);
	}
}
