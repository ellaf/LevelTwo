import javax.swing.JFrame;

public class LeagueInvaders {

	final int height = 800;
	final int width = 500;
	JFrame frame = new JFrame();
	GamePanel lisa = new GamePanel();

	public static void main(String[] args) {

		LeagueInvaders george = new LeagueInvaders();

	}

	LeagueInvaders() {

		frame.setSize(width, height);
		this.frame = frame;
		setup();

	}

	void setup() {

		frame.add(lisa);
		frame.addKeyListener(lisa);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lisa.startGame();

	}
}
