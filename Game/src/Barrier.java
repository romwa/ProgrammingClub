import java.awt.Color;

import processing.core.PApplet;

public class Barrier {

	int x = 0;
	int y = 0;
	int width = 0;
	int height = 0;
	boolean drawRect = true;
	public Barrier(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		drawRect = true;
	}
	
	/* Initialize platform when you take in an image
	   public Platform(String filename, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		drawRect= false;
	}*/
	
	public void draw(PApplet g) {
		g.pushMatrix();
		g.pushStyle();
		if(drawRect) {
			g.fill(Color.blue.darker().getRGB());
			g.rect(x,y,width,height);
		}
		/* Draw image version of platform
		  else {
			
		}*/
		
		g.popMatrix();
		g.popStyle();
	}
	//returns the x value of the barrier
	public int getX() {
		return x;
	}
	//returns the y value of the barrier
	public int getY() {
		return y;
	}
	// returns the width of the barrier
	public int getWidth() {
		return width;
	}
	// returns the height of the barrier
	public int getHeight() {
		return height;
	}
}
