
//HERE ARE SOME CHANGES!!!

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JumpDemo extends JPanel implements ActionListener, KeyListener {

	// 1. Create static final variables for the width and height of your screen
	static final int frameWidth = 500;
	static final int frameHeight = 500;
	// 2. create a JFrame for your window
	JFrame frame = new JFrame();
	// Create a timer variable (we will initialize it later)
	Timer timer;
	// 3. Create an instance of a Player.
	Player p1;
	// 4. Create an instance of a platform
	Platform geoff = new Platform(100, 100, 100, 100);

	public static void main(String[] args) {
		// 5.Call the Run method.
		JumpDemo george = new JumpDemo();
		george.run();
	}

	public void run() {

		// 6. Add this Panel to your frame
		frame.add(this);
		// 7. Set the preferred size of your frame and make it show up.
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		// 8. Set the default close operation of your frame.
		System.exit(0);
		// 9. Initialize your timer.

		// 10. Start you timer

		// 11.Fill in the paintComponent and actionPerformed methods

		// 16. Add a keyListener to your frame

		// Fill in the implemented methods to make you character move left,
		// right and jump!

	}

	public void paintComponent(Graphics g) {
		// 12. Draw your player using the graphics object.

		// 13. Draw your platform

	}

	public void actionPerformed(ActionEvent e) {
		// 14 use the check collision method.

		// 15. call the update method for you player and Platform

		repaint();

	}

	private void checkCollision() {
		// if the player in collision box intersects with the platform call the
		// handleCollision method.

		// Otherwise, use the setYlimit method to choose your players lowest
		// point.

	}

	private void handleCollision(Platform p) {
		if (p1.getYVelocity() >= 0 && p1.getY() + p1.getHeight() < p.getY() + 25) {
			p1.setYLimit(p.getY() - p1.getHeight());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p1.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p1.right = false;
		}
	}
}

class Platform {
	private int x;
	private int y;
	private int width;
	private int height;

	private Rectangle cBox = new Rectangle();

	public Platform(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;

		cBox.setBounds(x, y, width, height);
	}

	public void update() {
		cBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

	public Rectangle getCBox() {
		return cBox;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

class Player {
	private int x;
	private int y;
	private int width;
	private int height;

	private Rectangle cBox = new Rectangle();

	public boolean left = false;
	public boolean right = false;

	private int xVelocity = 5;

	private int gravity = 1;
	private int yVelocity = 0;
	private int jumpPower = 20;

	private int yLimit = 500;

	boolean canJump = false;

	public Player(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;

		cBox.setBounds(x, y, width, height);
	}

	public void jump() {
		if (canJump) {
			yVelocity -= jumpPower;
			canJump = false;
		}
	}

	public void update() {
		if (left) {
			x -= xVelocity;
		}
		if (right) {
			x += xVelocity;
		}

		yVelocity += gravity;
		y += yVelocity;

		if (y >= yLimit + 1) {
			y = yLimit + 1;
			yVelocity = 0;
			canJump = true;
		}

		cBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public Rectangle getCBox() {
		return cBox;
	}

	public void setYLimit(int l) {
		yLimit = l;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getYVelocity() {
		return yVelocity;
	}
}
