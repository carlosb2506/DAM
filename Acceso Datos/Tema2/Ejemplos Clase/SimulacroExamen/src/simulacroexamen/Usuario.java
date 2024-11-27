package simulacroexamen;

public class Usuario {
	private String userid;
	private String email;
	private String dni;
	private int edad;
	private float saldo;
	
	public Usuario() {
		super();
	}

	public Usuario(String userid, String email, String dni, int edad, float saldo) {
		super();
		this.userid = userid;
		this.email = email;
		this.dni = dni;
		this.edad = edad;
		this.saldo = saldo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Usuario [userid=" + userid + ", email=" + email + ", dni=" + dni + ", edad=" + edad + ", saldo=" + saldo
				+ "]";
	}
	
	
	
}
