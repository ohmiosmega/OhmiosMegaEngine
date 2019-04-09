
/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 30/03/2019
 **/
public class GravityThread extends Thread {
	private Body body;

	public GravityThread(Body body) {
		this.body = body;
		this.body.setAccelerationY(UniversalConstants.GRAVITY);
	}

	@Override
	public void run() {
		float time = UniversalConstants.TIME_PERIOD;
		while (true) {
			body.setY(Utilities.calculateHeight(body.getY(), body.getSpeedY(), UniversalConstants.GRAVITY, time));
			body.setSpeedY(
					Utilities.finalSpeed(body.getSpeedY(), UniversalConstants.GRAVITY, UniversalConstants.TIME_PERIOD));
			body.setX(body.getX() + body.getSpeedX() * time);
			
			if (body.isInFloor()) {
				if (body.getSpeedX() > 0) {
					body.setSpeedX(body.getSpeedX() - body.getFriction());
					body.setDirection(body.getDirection() + body.getSpeedX() / 180);
				} else if (body.getSpeedX() < 0) {
					body.setSpeedX(body.getSpeedX() + body.getFriction());
					body.setDirection(body.getDirection() + body.getSpeedX() / 180);
				}
			}

			time += UniversalConstants.TIME_PERIOD;
			if (body.isInFloor()) {
				body.setY(body.getCurrentFloor() - body.getHeight());
				time = UniversalConstants.TIME_PERIOD;
				body.setSpeedY(1);
			}
			body.detectFloor();
			try {
				Thread.sleep((long) (UniversalConstants.TIME_PERIOD * 1000));
			} catch (InterruptedException e) {
			}
		}
	}
}
