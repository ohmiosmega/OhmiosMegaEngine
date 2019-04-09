
import com.ohmiosmega.figure.AbstractFigure;

/**
 * @author Andrés Felipe Chaparro Rosas
 * @date 6/04/2019
 **/
public abstract class Body extends AbstractFigure {
	protected float mass, speedX, speedY, currentFloor, friction;
	protected double accelerationY, direction;
	protected GravityThread gravityThread;

	public Body() {
		this.speedX = this.speedY = 0;
		this.accelerationY = 0;
		this.gravityThread = new GravityThread(this);
		this.detectFloor();
	}

	public abstract void detectFloor();

	public void setMass(float mass) {
		this.mass = mass;
	}

	public void setDirection(double direction) {
		if (direction >= 2 * Math.PI)
			direction = direction - 2 * Math.PI;
		this.direction = direction;
	}

	public void setCurrentFloor(float currentFloor) {
		this.currentFloor = currentFloor;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}

	public float getSpeedX() {
		return speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public double getSpeed() {
		return Math.hypot(speedX, speedY);
	}

	public double getAccelerationY() {
		return accelerationY;
	}

	public float getMass() {
		return mass;
	}

	public double getDirection() {
		return direction;
	}

	public float getCurrentFloor() {
		return currentFloor;
	}

	public void startGravity() {
		this.gravityThread.start();
	}

	public boolean isInFloor() {
		return y + height >= currentFloor;
	}

	public float getFriction() {
		return friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}
}
