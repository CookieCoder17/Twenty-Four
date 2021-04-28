import javax.swing.JFrame;

/**
 * Displays 24-point game. 
 * @author Qi Wang
 * @version 1.0
 */
public class TwentyFourPointsFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an interface of 24-point game. 
	 */
	public TwentyFourPointsFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Twenty-Four!");
		TwentyFourPointsPanel panel = new TwentyFourPointsPanel();
		this.getContentPane().add(panel);
		
		this.pack();
		this.setVisible(true);
	}
}
