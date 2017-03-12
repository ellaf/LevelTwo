import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;
	static boolean up;
	static boolean down;
	static boolean right;
	static boolean left;

	void update() {

		super.update();

		if (left == true) {

			x -= speed;

		}
		if (right == true) {

			x += speed;

		}
		if (up == true) {

			y -= speed;

		}
		if (down == true) {

			y += speed;

		}

	}

	void draw(Graphics g) {

		// g.setColor(Color.BLUE);
		// g.fillRect(x, y, width, height);
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}

	Rocketship(int x, int y, int width, int height, int speed) {

		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;

	}
}
