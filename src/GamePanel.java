import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer fred = new Timer(1000 / 60, this);
	// GameObject susan = new GameObject();
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font moreFont = new Font("Arial", Font.PLAIN, 25);
	Rocketship becky = new Rocketship(230, 700, 50, 50, 5);
	ObjectManager oliver = new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		repaint();
		// susan.update();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	GamePanel() {

		this.fred = fred;
		// this.susan = susan;
		this.titleFont = titleFont;
		oliver.addObject(becky);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void startGame() {

		fred.start();

	}

	public void paintComponent(Graphics g) {

		// susan.draw(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {

		// becky.update();
		oliver.update();
		oliver.manageEnemies();
		oliver.checkCollision();
		if (becky.isAlive == false) {

			currentState = END_STATE;
			oliver.reset();
			becky = new Rocketship(230, 700, 50, 50, 5);
			oliver.addObject(becky);

		}
		oliver.getScore();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.cyan);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 27, 200);
		g.setFont(moreFont);
		g.drawString("Press ENTER to start", 120, 280);
		g.drawString("Press SPACE for instructions", 80, 370);

	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);

		oliver.draw(g);

	}

	void drawEndState(Graphics g) {

		g.setColor(Color.red);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 95, 120);
		g.setFont(moreFont);
		g.drawString("You killed " + oliver.getScore() + " aliens.", 132, 290);
		g.drawString("Press BACKSPACE to Restart", 76, 490);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState += 1;

		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}

		System.out.println(currentState);

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			Rocketship.left = true;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			Rocketship.right = true;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			Rocketship.up = true;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			Rocketship.down = true;

		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			oliver.addObject(new Projectile(becky.x + 23, becky.y, 10, 10));

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		Rocketship.up = false;
		Rocketship.down = false;
		Rocketship.left = false;
		Rocketship.right = false;

	}

}
