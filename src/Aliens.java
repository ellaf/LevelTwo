import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {

	void update() {

		y += 1;

	}

	void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.drawRect(x, y, height, width);

	}

	Aliens(int x, int y, int height, int width) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

	}
}
