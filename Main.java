import javax.swing.JFrame;


//TODO: Add colour calibration bar
//		Add max iterations number changer
//		Add abs limit changer



public class Main extends JFrame{
	private static final long serialVersionUID = 1L;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mandelbrot Set");
		setSize(Constants.width, Constants.height);
		setResizable(false);
		
		DrawingPanel panel = new DrawingPanel();
		add(panel);
	}
	
	public static void main(String[] args) {
		Main app = new Main();
		app.setVisible(true);		
	}
}
