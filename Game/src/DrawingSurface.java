import java.awt.Color;
import java.util.ArrayList;

import processing.core.*;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private static ArrayList<Bullet> bullets;
	private Player player1;
	private Player player2;
	
	//	private Barrier p;

	public DrawingSurface() {
		keys = new ArrayList<Integer>();
//		player1 = new Player(250, 400, 50, 50, 1, 0, 0, width, height/2);
//		player2 = new Player(250,50,50,50,2, 0, height/2, width, height);
		//		p = new Barrier(225,200,50,100);
		bullets = new ArrayList<Bullet>();
		
	}

	public void draw() {
//		System.out.println(width + " " + height);

		clear();
		background(255);
		player1 = new Player(250, 400, 50, 50, 1, 0, 0, width, height/2);
		player2 = new Player(250,50,50,50,2, 0, height/2, width, height);
		System.out.println(width);
		
		if (checkKey(RIGHT)) {
//			System.out.println("Move Player1 Right");
			player1.setX(player1.getX()+5);
		} if (checkKey(LEFT)) {
//			System.out.println("Move Player1 Left");
			player1.setX(player1.getX()-5);
		} if (checkKey(UP)) {
//			System.out.println("Move Player1 Up");
			player1.setY(player1.getY()-5);
		} if (checkKey(DOWN)) {
//			System.out.println("Move Player1 Down");
			player1.setY(player1.getY()+5);
		}

		if (checkKey(87)) { //W key
//			System.out.println("Move Player2 Up");
			player2.setY(player2.getY()-5);
		} 
		if (checkKey(65)) { //A
//			System.out.println("Move Player2 Left");
			player2.setX(player2.getX()-5);
		} if (checkKey(83)) { //S
//			System.out.println("Move Player2 Down");
			player2.setY(player2.getY()+5);
		} if (checkKey(68)) { //D
//			System.out.println("Move Player2 Right");
			player2.setX(player2.getX()+5);
		}
		if (checkKey(16)) { // Shift
//			if(player2.isAbleToShoot())
			player2.shoot();
//			System.out.println("Shoot by Player2");
		}
		if (checkKey(32)) { //Space
//			if(player1.isAbleToShoot())
			player1.shoot();
//			System.out.println("Shoot by Player1");
		}
		if(!checkKey(32)) {
			player1.setShooting(false);
		}
		if(!checkKey(16)) {
			player2.setShooting(false);
		}
		
		player1.draw(this);
		player2.draw(this);
			
		for(Bullet b: bullets) {
			b.draw(this);
		}
		
		textSize(14);
		fill(0);
		text(player1.getShots() + " player1", 10, 20);
		text(player2.getShots() + " player2", 10, 40);

	}

	public void keyPressed() {
		keys.add(keyCode);



//		if(checkKey(18)) { //OPTION to rotate bullet direction of player1
//			player1.setDirection(player1.getDirection() +1);
//		}
//		if(checkKey(9)) { //TAB to rotate bullet direction of player2
//			player2.setDirection(player2.getDirection() +1);
//		}

	}

		public void keyReleased() {
			while (checkKey(keyCode))
				keys.remove(new Integer(keyCode));
			
			if (checkKey(16)) { // Shift
				player2.setShooting(false);
			}
			if (checkKey(32)) { //Space
				player1.setShooting(false);
			}
		}

		private boolean checkKey(int i) {
			return keys.contains(i);
		}

		public static void addBullet(Bullet b) {
			bullets.add(b);
		}

}
