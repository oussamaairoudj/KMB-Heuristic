
public class Point {
	private int posX;
	private int posY;
	
	public Point(int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public String toString() {
		return this.posX+" , "+this.posY;
	}

}
