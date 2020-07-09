import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class Click implements ActionListener,MouseListener{
	private Scene scene;
	private int nbrClick;
	
	public Click(Scene scene,int nbrClick) {
		this.scene=scene;
		this.nbrClick=nbrClick;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (this.nbrClick) {
		case 1:
			this.scene.open();
			break;
		case 2:
			this.scene.exit();
			break;
		case 3:
			this.scene.help();
			break;
		case 5:
			this.scene.kmb();
			break;
		default:
			this.scene.New();
			break;
		}
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public int getNbrClick() {
		return nbrClick;
	}

	public void setNbrClick(int nbrClick) {
		this.nbrClick = nbrClick;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			switch (this.nbrClick) {
			case 1:
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						Date uDate=new Date(System.currentTimeMillis());
						try {
							scene.getPrograss().start();
							scene.kmb();
							scene.getPrograss().stop();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(scene,"Erreur","Erreur Mimoir ", JOptionPane.ERROR_MESSAGE);
						}
						Date fiDate=new Date(System.currentTimeMillis());
						fiDate.setTime(fiDate.getTime()-uDate.getTime());
						long s=fiDate.getTime()/1000;
						long m=s/60;
						scene.getTool().temp.setText("Le temp d' exc : "+m+" : "+s%60+" : "+fiDate.getTime()%1000);
						
					}
				}).start();
				break;

			default:
				this.scene.open();
				break;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

}
