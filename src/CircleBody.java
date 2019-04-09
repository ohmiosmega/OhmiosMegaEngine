import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 6/04/2019
 **/
public class CircleBody extends Body {
	private double radius;

	@Override
	public void draw(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.translate(x, y);
		g.rotate(direction);
		g.drawOval((int) -width / 2, (int) -height / 2, (int) width, (int) height);
		g.drawOval((int) -width / 2, (int) -height / 4, (int) width / 4, (int) height / 4);
		g.rotate(-direction);
		g.translate(-x, -y);
	}

	@Override
	public void detectFloor() {
		double a = 0.5;
		this.currentFloor = 100 + (int) (x * a) + width / 2;
	}

}
