import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class Tool extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scene scene;
	private JLabel toolopen,func;
	JLabel cout,temp,edj,ver,ter;
	
	public Tool(Scene scene) {
		this.scene=scene;
		this.toolopen=new JLabel(new ImageIcon(InterfaceGraph.toolopen));
		this.func=new JLabel(new ImageIcon(InterfaceGraph.func));
		cout=new JLabel();
		temp=new JLabel();
		edj=new JLabel();
		ver=new JLabel();
		ter=new JLabel();
        this.toolopen.addMouseListener(new Click(this.scene, 0));
        this.func.addMouseListener(new Click(this.scene, 1));
		setFloatable(false);
		add(this.toolopen);
		addSeparator();
		add(this.func);
		addSeparator();
		add(ver);
		addSeparator();
		add(edj);
		addSeparator();
		add(ter);
		addSeparator();
		add(cout);
		addSeparator();
		add(temp);
		setBackground(Color.LIGHT_GRAY);
		this.scene.add("North",this);
		
	}

	public JLabel getFunc() {
		return func;
	}

	public void setFunc(JLabel func) {
		this.func = func;
	}

	public JLabel getToolopen() {
		return toolopen;
	}

	public void setToolopen(JLabel toolopen) {
		this.toolopen = toolopen;
	}
	

}
