package ejercicioEntradas;

public class Entrada {
	private int codEnt;
	private int dni;
	private int codEv;
	private int codComp;

	// Constructores
	public Entrada() {

	}

	public Entrada(int codEnt, int dni, int codEv, int codComp) {
		this.codEnt = codEnt;
		this.dni = dni;
		this.codEv = codEv;
		this.codComp = codComp;
	}

	// Getters y Setters
	public int getCodEnt() {
		return codEnt;
	}

	public void setCodEnt(int codEnt) {
		this.codEnt = codEnt;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCodEv() {
		return codEv;
	}

	public void setCodEv(int codEv) {
		this.codEv = codEv;
	}

	public int getCodComp() {
		return codComp;
	}

	public void setCodComp(int codComp) {
		this.codComp = codComp;
	}

	// Método toString para mostrar la información de la entrada
	@Override
	public String toString() {
		return "Entrada{" + "codEnt=" + codEnt + ", dni=" + dni + ", codEv=" + codEv + ", codComp=" + codComp + '}';
	}
}
