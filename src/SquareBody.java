import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 6/04/2019
 **/
public class SquareBody extends Body {
	@Override
	public void draw(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.translate(x, y);
		g.drawRect((int) -width / 2, (int) -height / 2, (int) width, (int) height);
		g.translate(-x, -y);
	}

	@Override
	public void detectFloor() {
		this.currentFloor = 600;
	}

}
