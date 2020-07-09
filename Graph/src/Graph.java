import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;

public class Graph extends Scene{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<Sommet> sommets=new ArrayList<Sommet>();
	static ArrayList<Arete> aretes=new ArrayList<Arete>();
	static ArrayList<Sommet> terminals=new ArrayList<Sommet>();
	static ArrayList<Arete> graphcomplis=new ArrayList<Arete>();
	static int graph[][];

	@Override
	public Graph New() {
		dispose();
		return new Graph();
	}

	@Override
	public void open() {
		Graph graph=this.New();
		
		sommets=new ArrayList<Sommet>();
		aretes=new ArrayList<Arete>();
		terminals=new ArrayList<Sommet>();
		graphcomplis=new ArrayList<Arete>();
		Sommet.nombreSommets=0;
		Arete.nombreAretes=0;
		new Open(graph);
		 this.graph=new int[this.sommets.size()][this.sommets.size()];
		  for (int i = 0; i < this.graph.length; i++) {
			for (int j = 0; j < this.graph[i].length; j++) {
				this.graph[i][j]=0;
			}
		}
		  for (int i = 0; i < aretes.size(); i++) {
			this.graph[aretes.get(i).getSommetA().id-1][aretes.get(i).getSommetB().id-1]=aretes.get(i).getPoid();
			this.graph[aretes.get(i).getSommetB().id-1][aretes.get(i).getSommetA().id-1]=aretes.get(i).getPoid();
		}
	}

	@Override
	public void help() {
		new Help();	
	}

	@Override
	public void kmb() {
		HashSet<Arete> set=new HashSet<Arete>();
		ArrayList<Chemin>list=new ArrayList<Chemin>();
		for (int i = 0; i < terminals.size()-1; i++) {
			Dijkstra dijkstra=dijkstra(this.graph, terminals.get(i));
			for (int j =i+1; j < terminals.size(); j++) {
				String chemin=dijkstra.chemin[terminals.get(j).id-1];
				Arete arete=new Arete(terminals.get(i), terminals.get(j), dijkstra.cout[terminals.get(j).id-1], this);
				graphcomplis.add(arete);
			    list.add(new Chemin(arete, chemin));
			}
		}
		this.graphcomplis=kruskal(terminals, graphcomplis);
		String chemin="";
		for (int i = 0; i < graphcomplis.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(graphcomplis.get(i).toString().equals(list.get(j).arete.toString())) {
					chemin+="/ "+list.get(j).aretes;
				}
			}
		}
		set.addAll(cheminDijkstra(chemin));
		Object[] a=set.toArray();
		this.aretes=new ArrayList<Arete>();
		for (int i = 0; i < set.size(); i++) {
			this.aretes.add((Arete)a[i]);
		}
		getTool().cout.setText("Le cout : "+mincout(this.aretes));
	}
	
	protected ArrayList<Arete> cheminDijkstra(String s) {
		ArrayList<Arete> aretes=new ArrayList<Arete>();
		String tab[]=s.split("/");
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < this.aretes.size(); j++) {
				String t[]=tab[i].split(",");
				String t1[]=this.aretes.get(j).toString().split(",");
				if(((t[0].equals(t1[0]) && t[4].equals(t1[4])) || (t[0].equals(t1[4]) && t[4].equals(t1[0]))) && t[8].equals(t1[8])) {
					aretes.add(this.aretes.get(j));
				}
			}
		}
		return aretes;
	}
	
	protected boolean exist(int i) {
		boolean b=false;
		for (int j = 0; j < terminals.size(); j++) {
			if(i==terminals.get(j).id-1)b=true;
		}
		return b;
	}
	
	protected int mincout(ArrayList<Arete> aretes) {
		int x=0;
		for (int i = 0; i < aretes.size(); i++) {
			x+=aretes.get(i).getPoid();
		}
		return x;
	}
	
	protected int min(int distance[],boolean visit[]) {
		int index=-1;
		for (int i = 0; i < distance.length; i++) {
			if(!visit[i] && (index==-1 || distance[i]<distance[index])) {
				index=i;	
			}
		}
		return index;
	}

	@Override
	public Dijkstra dijkstra(int graph[][],Sommet sommet) {
	  int v=graph.length;
	  boolean visit[]=new boolean[v];
	  int distance[]=new int[v];
	  String chemin[] = new String[v];
	  for (int i = 0; i < v; i++) {
		distance[i]=Integer.MAX_VALUE;
		chemin[i]="";
	}
	  distance[sommet.id-1]=0;
	  chemin[sommet.id-1]=""+sommet.id;
	  for (int i = 0; i < v-1; i++) {
		int m=min(distance, visit);
		visit[m]=true;
		for (int j = 0; j < v; j++) {
			if(graph[m][j]!=0 && !visit[j] && distance[m]!=Integer.MAX_VALUE) {
				int dist=distance[m]+graph[m][j];
				String s=chemin[m]+"/"+(new Arete(sommets.get(m), sommets.get(j), graph[m][j], this));
				if(dist<distance[j]) {
					distance[j]=dist;
					chemin[j]=s;
				}
			}
		}
	}
	return new Dijkstra(distance, chemin);
}

	@Override
	public ArrayList<Arete> kruskal(ArrayList<Sommet> sommets, ArrayList<Arete> aretes) {
		ArrayList<Arete>cheminKruskal=new ArrayList<Arete>();
		aretes.sort(Comparator.comparingInt(Arete::getPoid));
		int i=0;
		while (cheminKruskal.size()<sommets.size()-1) {
			Arete arete=aretes.get(i++);
			int id=arete.getSommetA().id;
			int id1=arete.getSommetB().id;
			if(id != id1) {
				cheminKruskal.add(arete);
				for(Sommet sommet : sommets) {
					if(sommet.id==id1) {
						sommet.id=id;
					}
				}
			}
			
		}
		for (int j = 0; j < sommets.size(); j++) {
		   sommets.get(j).id=Integer.parseInt(sommets.get(j).getText());	
		}
		return cheminKruskal;
	}
	
	
}
