import java.awt.Event;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scene scene;
	private JMenu file,help;
	private JMenuItem New,open,exit,about;
	

	public Menu(Scene scene) {
		this.setScene(scene);
		this.file=new JMenu("File");add(file);
		this.help=new JMenu("Help");add(help);
		this.New=new JMenuItem("New",new ImageIcon(InterfaceGraph.New));this.file.add(this.New);this.file.addSeparator();
		this.New.addActionListener(new Click(this.scene, 0));
		this.New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK, true));
		this.open=new JMenuItem("Open",new ImageIcon(InterfaceGraph.open));this.file.add(this.open);this.file.addSeparator();
		this.open.addActionListener(new Click(this.scene, 1));
		this.open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK, true));
		this.exit=new JMenuItem("Exit",new ImageIcon(InterfaceGraph.exit));this.file.add(this.exit);
		this.exit.addActionListener(new Click(this.scene, 2));
		this.exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, Event.ALT_MASK, true));
		this.about=new JMenuItem("About",new ImageIcon(InterfaceGraph.about));this.help.add(this.about);
		this.about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK, true));
		this.about.addActionListener(new Click(this.scene, 3));
		this.scene.setJMenuBar(this);
		
	}


	public Scene getScene() {
		return scene;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}


	public JMenu getFile() {
		return file;
	}


	public void setFile(JMenu file) {
		this.file = file;
	}


	public JMenu getHelp() {
		return help;
	}


	public void setHelp(JMenu help) {
		this.help = help;
	}


	public JMenuItem getAbout() {
		return about;
	}


	public void setAbout(JMenuItem about) {
		this.about = about;
	}


	public JMenuItem getNew() {
		return New;
	}


	public void setNew(JMenuItem new1) {
		New = new1;
	}


	public JMenuItem getOpen() {
		return open;
	}


	public void setOpen(JMenuItem open) {
		this.open = open;
	}


	public JMenuItem getExit() {
		return exit;
	}


	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}


}
