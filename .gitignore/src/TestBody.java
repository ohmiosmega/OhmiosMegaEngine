
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 6/04/2019
 **/
public class TestBody {
	public static void main(String[] args) {
		int fwidth = 1000, fheight = 700;
		CircleBody body = new CircleBody();

		body.setWidth(50);
		body.setHeight(50);
//		body.setX((1000 - body.getWidth()) / 2);
		body.setX(body.getWidth());
		body.setY(body.getHeight() / 2);

		JPanel jPanel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				body.draw(g);
				g.drawLine(0, 100, 1000, 600);
			}
		};

		JFrame f = new JFrame();
		f.add(jPanel);
		f.setSize(fwidth, fheight);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		body.startGravity();

		new Timer(42, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanel.repaint();
			}
		}).start();

	}
}
