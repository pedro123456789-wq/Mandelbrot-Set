import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class InputHandler extends KeyAdapter {
	private DrawingPanel panel;
	
	public InputHandler(DrawingPanel panel) {
		System.out.println("Listening...");
		this.panel = panel;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT)) {
			this.panel.shiftX(-5);
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.panel.shiftX(5);
		}
		
		if (key == KeyEvent.VK_UP) {
			this.panel.shiftY(-5);
		}
		
		if (key == KeyEvent.VK_DOWN) {
			this.panel.shiftY(5);
		}
		
		if (key == KeyEvent.VK_1) {
			this.panel.zoomIn(-0.5);
		}
		
		if (key == KeyEvent.VK_2) {
			this.panel.zoomIn(0.5);
		}
	}
}
