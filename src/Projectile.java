import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed = 10;

	void update() {

		super.update();
		y -= speed;
		if (y <= 0) {

			isAlive = false;

		}

	}

	void draw(Graphics g) {

		// g.setColor(Color.RED);
		// g.drawRect(x, y, height, width);
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);

	}

	Projectile(int x, int y, int height, int width) {

		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

	}
}
