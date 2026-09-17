package main;

public class Customer {
	int id=0;
	String name;
	double balance;
	
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
		if(sum>=0) {
			this.balance=balance+sum;
		}else {
			System.out.println("La suma no puede ser menor a 0");
		}
	}
	public void restBalance(double rest) throws SaldoInsuficiente {
		if(rest>=0) {
			if(rest<this.balance) {
				this.balance=balance-rest;
			}else {
				throw new SaldoInsuficiente("No queda el suficiente saldo");
			}
		}else {
			System.out.println("La resta no puede ser menor a 0");
		}
	}
	public void dispone(int id,double balance) {
		if(id>this.id || balance<0) {
			System.out.println("El ID o el saldo del cliente no es correcto");
		}else {
			for(int i=0;i<=this.id;i++) {
				if(i==id) {
					if(balance==this.balance) {
						System.out.println("Si ese es el saldo que el cliente:"+this.name+" posee");
					} else {
						System.out.println("No el saldo del cliente es:"+this.balance);
					}
				}
			}
		}
	}
	public String toString() {
		return "El cliente:"+this.id+" cuyo nombre es:"+this.name+" tiene un saldo de:"+this.balance;
	}
}
