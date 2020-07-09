

public class Arete{
	private Sommet sommetA;
	private Sommet sommetB;
	private Scene scene;
	private int poid;
	static int nombreAretes;
	
	public Arete(Sommet sommetA, Sommet sommetB, int poid,Scene scene) {
		this.sommetA=sommetA;
		this.sommetB=sommetB;
		this.poid=poid;
		this.scene=scene;
		nombreAretes++;
	}
	
	

	public Sommet getSommetA() {
		return sommetA;
	}

	public void setSommetA(Sommet sommetA) {
		this.sommetA = sommetA;
	}

	public Sommet getSommetB() {
		return sommetB;
	}

	public void setSommetB(Sommet sommetB) {
		this.sommetB = sommetB;
	}

	public int getPoid() {
		return poid;
	}

	public void setPoid(int poid) {
		this.poid = poid;
	}

	public String toString() {
		return " "+this.sommetA+" , "+this.sommetB+" , "+this.poid;
	}



	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}


}
