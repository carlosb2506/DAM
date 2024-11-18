package ejercicioEntradas;

public class Compra {
	private int codComp; // Código de la compra
	private double precio; // Precio total de la compra

	// Constructores
	public Compra() {

	}

	public Compra(int codComp, double precio) {
		this.codComp = codComp;
		this.precio = precio;
	}

	// Getters y setters
	public int getCodComp() {
		return codComp;
	}

	public void setCodComp(int codComp) {
		this.codComp = codComp;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Compra{" + "codComp=" + codComp + ", precio=" + precio + '}';
	}
}