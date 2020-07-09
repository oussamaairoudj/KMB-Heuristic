import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JButton;


public class Sommet extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point point;
	private boolean terminal;
	private int nombre;
	private Scene scene;
	int id;
	static int nombreSommets;
	
	public Sommet(Point point,boolean terminal,Scene scene) {
		this.point=point;
		this.terminal=terminal;
		this.scene=scene;
		this.nombre=++nombreSommets;
		this.id=this.nombre;
		setFocusable(false);
        setBorderPainted(false);
        setBackground(Color.BLACK);
        setForeground(Color.red);
        setMargin(new Insets(1, 1, 1, 1));
        setText(""+this.nombre);
        Dimension size=getMinimumSize();
        size.width=size.height=Math.max(size.width,size.height);
        setPreferredSize(size);
        setBounds(this.point.getPosX(), this.point.getPosY(), size.width, size.height);
        setContentAreaFilled(false);
        this.scene.getCanvas().add(this);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
		g.fillOval(0, 0, getSize().width-1, getSize().height-1);
        super.paintComponent(g);
    }
    
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
		setBackground(Color.YELLOW);
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return this.nombre+" , "+this.point+" , "+this.terminal;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
