import java.awt.Graphics;

public class Aliens extends GameObject {

	void update() {

		super.update();
		y += 1;

	}

	void draw(Graphics g) {

		// g.setColor(Color.YELLOW);
		// g.drawRect(x, y, height, width);
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}

	Aliens(int x, int y, int height, int width) {

		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

	}
}
