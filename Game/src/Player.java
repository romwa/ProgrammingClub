import processing.core.PApplet;

/**
 * 
 * @author Varun Tandon
 *
 */
public class Player {

	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int direction; //1 = up, 2 = right, 3 = down, 4 = left
	public static final int PLAYER_UP = 1;
	public static final int PLAYER_DOWN = 3;
	public static final int PLAYER_RIGHT = 2;
	public static final int PLAYER_LEFT= 4;
	private Integer[] bounds = new Integer[4];
	private int shots = 60;
	private boolean shooting = false, ableToShoot = true;


	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Player(int xPos, int yPos, int width, int height, int direction, Integer[] bounds) {
		this(xPos, yPos, width, height, direction, bounds[0], bounds[1], bounds[2], bounds[3]);
	}

	public Player(int xPos, int yPos, int width, int height, int direction, int xBound, int yBound, int widthBound, int heightBound) {
		this.setX(xPos);
		this.setY(yPos);
		this.width = width;
		this.height = height;
		if(direction == 1) this.direction = PLAYER_UP;
		if(direction == 2) this.direction = PLAYER_DOWN;
		if(direction == 3) this.direction = PLAYER_RIGHT;
		if(direction == 4) this.direction = PLAYER_LEFT;
		setBounds(xBound, yBound, widthBound, heightBound);
	}

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public void draw(PApplet canvas) {
		canvas.pushMatrix();
		canvas.pushStyle();
		canvas.fill(50);
		canvas.ellipse(xPos, yPos, width, width);
		if(xPos <= bounds[0]) xPos = bounds[0];
		if(yPos <= bounds[1]) yPos = bounds[1];
		if(xPos >= bounds[2]) xPos = bounds[2];
		if(yPos >= bounds[3]) yPos = bounds[3];
		canvas.popMatrix();
		canvas.popStyle();
		recoverShots();
		
		if(shots == 0) {
			ableToShoot = false;
		} else ableToShoot = false;
	}
	
	public void setBounds(int x, int y, int width, int height) {
		bounds[0] = x;
		bounds[1] = y;
		bounds[2] = width;
		bounds[3] = height;
	}

	public void recoverShots() {
		if(!(shots == 60) && !shooting) shots++;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void shoot() {
		if(!(shots == 0)) {
			if(direction == PLAYER_UP) {
				DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 90));
			}else if(direction == PLAYER_RIGHT) {
				DrawingSurface.addBullet(new Bullet( xPos + 30,  yPos, 5, 0));
			}else if(direction == PLAYER_DOWN) {			
				DrawingSurface.addBullet(new Bullet( xPos,  yPos + 30, 5, -90));
			}else {
				System.out.println(4);
				DrawingSurface.addBullet(new Bullet( xPos - 30, yPos, 5, 180));
			}
			setShooting(true);
			shots--;
		}
		
	}

	

	public int getShots() {
		return shots;
	}
	
	public void setShooting(boolean b) {
		shooting = b;
//		System.out.println(shooting);
	}
	
	public boolean isAbleToShoot() {
		return ableToShoot;
	}
}
