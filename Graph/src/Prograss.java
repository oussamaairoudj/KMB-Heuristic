import javax.swing.JProgressBar;

public class Prograss extends JProgressBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scene scene;
	private Thread thread;
	public Prograss(Scene scene) {
		this.setScene(scene);
		scene.add("South",this);
		setString("wait ..");
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void start() {
		thread=new Thread(new Runnable() {
			@Override
			public void run() {
				int x=0;
				setVisible(true);
				setStringPainted(true);
				setIndeterminate(true);
				scene.getCanvas().setPaintArete(true);
				scene.getCanvas().repaint();
				while (true) {
					try {
						Thread.sleep(100);
						setValue(x+=10);
					} catch (Exception e) {
						
					}
				}
				
			}
		});
		thread.start();
	}
	
	@SuppressWarnings("deprecation")
	public void stop() {
		thread.stop();
		setVisible(false);
		setValue(0);
		setStringPainted(false);
		setIndeterminate(false);
		try {
			Thread.sleep(100);
			scene.getCanvas().setPaintArete(true);
			scene.getCanvas().repaint();
		} catch (Exception e) {
		}
		
	}
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}

}
