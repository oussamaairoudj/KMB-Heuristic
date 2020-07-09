import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Open extends JFileChooser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scene scene;
	private int show;
	private File file;
	
	public Open(Scene scene) {
		super("./graph");
		this.scene=scene;
		setFileFilter(new FileNameExtensionFilter("File Graph", "stp"));
		show=showOpenDialog(this.scene);
		if(this.show==JFileChooser.APPROVE_OPTION){
			this.scene.setTitle(this.scene.getTitle()+" ** "+getSelectedFile().getName());
			this.file=new File(getSelectedFile().getPath(),this.scene);	
		}	
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
