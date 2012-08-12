import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel panel = new JPanel();
	private JButton button;
	
	Random rand = new Random();
	
	public Window(){
		super();
		
		this.setSize(180, 120);
		
		Dimension dim = this.getToolkit().getScreenSize();
		Rectangle bounds = this.getBounds();
		this.setLocation(rand.nextInt(dim.width - bounds.width),rand.nextInt(dim.height - bounds.height));
		
		button = new JButton("Ok");
		button.addActionListener(new ButtonListener());
		button.addKeyListener(new KeyboardListener());
		panel.addKeyListener(new KeyboardListener());
		this.addKeyListener(new KeyboardListener());
		
		panel.add(button);
		this.add(panel);
		
		
		
		Timer timer = new Timer(3000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				createWindow();
			}
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	protected class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			createWindow();
		}
		
	}
	
	protected class KeyboardListener implements KeyListener {
		
		private int count = 0;

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
		if(count == 3){
			System.exit(0);
		} else if(e.getKeyCode() == 68){
				count++;
		}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	
	private void createWindow(){
		Window newWindow = new Window();
		newWindow.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		newWindow.setVisible(true);
	}

	


}
