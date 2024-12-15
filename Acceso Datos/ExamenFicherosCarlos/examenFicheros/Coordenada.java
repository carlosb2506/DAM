package examenFicheros;

public class Coordenada {
	private int axisX;
	private int axisY;
	
	public int getAxisX() {
		return axisX;
	}
	public void setAxisX(int axisX) {
		this.axisX = axisX;
	}
	public int getAxisY() {
		return axisY;
	}
	public void setAxisY(int axisY) {
		this.axisY = axisY;
	}
	
	
	public Coordenada(int axisX, int axisY) {
		this.axisX = axisX;
		this.axisY = axisY;
	}
	@Override
	public String toString() {
		return axisX+", "+axisY+"";
		
	}
	
	
	
	
}
