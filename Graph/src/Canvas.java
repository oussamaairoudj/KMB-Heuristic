import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseWheelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scene scene;
	private double zoomFactor = 1;
	private boolean zoomer;
	private boolean paintArete;
	private int eX;
	private int eY;
	
	public Canvas(Scene scene) {
		this.scene=scene;
		setLayout(null);
		setBackground(Color.GRAY);
		scene.add(this);	
		addMouseWheelListener(this);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	

    protected int [] centreArete(Sommet sommetA,Sommet sommetB)
    {
        int[]t=new int[2];
        t[0]=(int)(sommetA.getPoint().getPosX()+sommetB.getPoint().getPosX())/2;
        t[1]=(int)(sommetA.getPoint().getPosY()+sommetB.getPoint().getPosY())/2;
        return t;
    }
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    if (zoomer) {
	        AffineTransform at = new AffineTransform();
	        at.scale(zoomFactor, zoomFactor);
	        g2.transform(at);
	        zoomer = false;}
	    if(paintArete) {
	    	for (int i = 0; i < Graph.aretes.size(); i++) {
				g2.drawLine(Graph.aretes.get(i).getSommetA().getPoint().getPosX()+10, Graph.aretes.get(i).getSommetA().getPoint().getPosY()+10, Graph.aretes.get(i).getSommetB().getPoint().getPosX()+10, Graph.aretes.get(i).getSommetB().getPoint().getPosY()+10);
				g2.drawString(""+Graph.aretes.get(i).getPoid(), centreArete(Graph.aretes.get(i).getSommetA(), Graph.aretes.get(i).getSommetB())[0], centreArete(Graph.aretes.get(i).getSommetA(), Graph.aretes.get(i).getSommetB())[1]);
				paintArete=false;
	    	}
	    }
	    }

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		 zoomer = true;
		 paintArete=true;
		    if (e.getWheelRotation() < 0) {
		        zoomFactor *= 1.1;
		        repaint();
		    }
		    if (e.getWheelRotation() > 0) {
		        zoomFactor /= 1.1;
		        repaint();
		    }
		seteX(e.getX());seteY(e.getY());
	}

	public boolean isPaintArete() {
		return paintArete;
	}

	public void setPaintArete(boolean paintArete) {
		this.paintArete = paintArete;
	}

	public int geteX() {
		return eX;
	}

	public void seteX(int eX) {
		this.eX = eX;
	}

	public int geteY() {
		return eY;
	}

	public void seteY(int eY) {
		this.eY = eY;
	}

}
