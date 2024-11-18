package ejercicio1;

import java.util.Random;

public class Cliente {
	private int id; 

	public Cliente(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean intentaEntrar(int intentosMaximos) {
		Random random = new Random();

		for (int i = 0; i < intentosMaximos; i++) {
			if (random.nextBoolean()) {
				return true;
			}
		}
		return false;
	}
}
