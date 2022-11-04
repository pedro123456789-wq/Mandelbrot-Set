import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;



public class DrawingPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private double zoom = 4;
	private int xOffSet = 0;
	private int yOffset = 0;
	
	
	public DrawingPanel() {
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(new InputHandler(this));
		
		JTextField iterationInput = new JTextField(4);
		iterationInput.setBackground(Color.black);
		iterationInput.setForeground(Color.white);
		add(iterationInput);
		
		Timer timer = new Timer(1000 / Constants.FPS, this);
		timer.start();
	}

	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.updateFrame(g);
	}

	
	
	public void shiftX(int shift) {
		this.xOffSet += shift;
	}
	
	
	public void shiftY(int shift) {
		this.yOffset += shift;
	}
	
	
	public void zoomIn(double zoom) {
		this.zoom += zoom;
	}
	
	
	public void updateFrame(Graphics g) {
		Graphics2D graphicsManager = (Graphics2D) g;
		
		

		for (int x = this.xOffSet; x < Constants.width + this.xOffSet; x++) {
			for (int y = this.yOffset; y < Constants.height + this.yOffset; y++) {
				double halfWidth = (double)Constants.width / 2;
				double halfHeight = (double)Constants.height / 2;
				
				double quarterWidth = (double)Constants.width / this.zoom;
				double quarterHeight = (double)Constants.height / this.zoom;
				
				double xCoord = ((double)x - halfWidth) / quarterWidth;
				double yCoord = ((double)y - halfHeight) / quarterHeight;
				
				
				
				ComplexNumber number = new ComplexNumber(xCoord, yCoord);
				int iterationNumber = SetGenerator.iterationNumber(number);
				graphicsManager.setColor(Color.getHSBColor(100 * iterationNumber, 100 * iterationNumber, 100 * iterationNumber));
				graphicsManager.fillRect(x - this.xOffSet, y - this.yOffset, 1, 1);
			}
		}

		Toolkit.getDefaultToolkit().sync();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
}
