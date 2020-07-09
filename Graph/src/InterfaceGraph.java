import java.util.ArrayList;

public interface InterfaceGraph {
	final String title="Graph";
	final String New="./icon/new.png";
	final String open="./icon/open.png";
	final String exit="./icon/exit.png";
	final String about="./icon/about.png";
	final String toolopen="./icon/toolopen.png";
	final String func="./icon/func.png";
	final int width=900;
	final int height=600;
	public Graph New();
	public void open();
	public void help();
	public Dijkstra dijkstra(int graph[][],Sommet sommet);
	public ArrayList<Arete> kruskal(ArrayList<Sommet>sommets,ArrayList<Arete>aretes);
	public void kmb();
	public default void exit() {System.exit(0);}
	
	

}
