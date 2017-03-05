import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	void update() {

	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

	Rocketship(int x, int y, int width, int height, int speed) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;

	}
}
