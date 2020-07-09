import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class Scene extends JFrame implements InterfaceGraph{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private Menu menu;
	private Tool tool;
	private Open open;
	private Prograss prograss;

	public Scene() {
		super(title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(func));
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.canvas=new Canvas(this);
		this.canvas.repaint();
		this.menu=new Menu(this);
		this.tool=new Tool(this);
		this.prograss=new Prograss(this);
		this.prograss.setVisible(false);
		setVisible(true);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public Open getOpen() {
		return open;
	}

	public void setOpen(Open open) {
		this.open = open;
	}

	public Prograss getPrograss() {
		return prograss;
	}

	public void setPrograss(Prograss prograss) {
		this.prograss = prograss;
	}
	

}
