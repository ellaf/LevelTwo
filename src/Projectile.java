import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed = 10;

	void update() {

		y -= speed;
		if (y <= 0) {

			isAlive = false;

		}

	}

	void draw(Graphics g) {

		g.setColor(Color.RED);
		g.drawRect(x, y, height, width);

	}

	Projectile(int x, int y, int height, int width) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

	}
}
