import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class File extends java.io.File{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Scanner scanner;
    private Scene scene;
	private ArrayList<String> arete,terminal,sommet;
	
	public File(String pathname,Scene scene) {
		super(pathname);
		this.scene=scene;
		this.arete=new ArrayList<String>();
		this.terminal=new ArrayList<String>();
		this.sommet=new ArrayList<String>();
		try {
			this.scanner=new Scanner(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scanner.hasNextLine()) {
		   String line = scanner.nextLine();
		   if(line.startsWith("E ")||line.startsWith("T ")||line.startsWith("DD ")) {
			   if(line.startsWith("E ")) {
				   this.arete.add(line);
			   }else {
				   if(line.startsWith("T ")) {
					   this.terminal.add(line);
				   }else {
					   this.sommet.add(line);
				   }
			   }
		   }
		}
		for (int i = 0; i < this.sommet.size(); i++) {
			String t[]=this.sommet.get(i).split(" ");
			Graph.sommets.add(new Sommet(new Point(Integer.parseInt(t[2]), Integer.parseInt(t[3])), false,this.scene));
		}
		for (int i = 0; i < this.terminal.size(); i++) {
			String t[]=this.terminal.get(i).split(" ");
			Graph.sommets.get(Integer.parseInt(t[1])-1).setTerminal(true);
			Graph.terminals.add(Graph.sommets.get(Integer.parseInt(t[1])-1));
		}
		this.scene.getCanvas().setPaintArete(true);
		for (int i = 0; i < this.arete.size(); i++) {
			String t[]=this.arete.get(i).split(" ");
			Graph.aretes.add(new Arete(Graph.sommets.get(Integer.parseInt(t[1])-1),Graph.sommets.get(Integer.parseInt(t[2])-1),Integer.parseInt(t[3]),this.scene));
		}
		this.scene.getTool().ver.setText("Nombre Sommets = "+Graph.sommets.size());
		this.scene.getTool().edj.setText("Nombre Aretes = "+Graph.aretes.size());
		this.scene.getTool().ter.setText("Nombre Terminals = "+Graph.terminals.size());
		this.scene.getCanvas().repaint();
	}

	public ArrayList<String> getSommet() {
		return sommet;
	}

	public void setSommet(ArrayList<String> sommet) {
		this.sommet = sommet;
	}

	public ArrayList<String> getArete() {
		return arete;
	}

	public void setArete(ArrayList<String> arete) {
		this.arete = arete;
	}

	public ArrayList<String> getTerminal() {
		return terminal;
	}

	public void setTerminal(ArrayList<String> terminal) {
		this.terminal = terminal;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	

}
