package main;

public class SaldoInsuficiente extends Exception {
	public SaldoInsuficiente() {
		super();
	}
	
	public SaldoInsuficiente(String mensaje){
		super(mensaje);
	}

}
