package hercules;
import robocode.*;
import java.awt.Color;
// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
/**
 * Hercules - a robot by (Kevin Santiago Romero Osorio)
 */
public class Hercules extends Robot{
	/**
	 * run: Hercules's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		setColors(Color.red,Color.red,Color.black); // body,gun,radar
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			if(getOthers() < 3){
				ahead(150);
				turnGunRight(360);
				back(80);
				turnGunRight(360);
				turnRight(50);
			}
			else{
				if(getOthers() > 3){
					ahead(300);
					turnGunLeft(360);
					turnRight(40);
					back(250);
					turnGunRight(360);
					turnRight(50);
				}
			}
		}
	}


	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// acá dispara mientras escanée un robot
		// si le tiro a un enemigo le quito 1, pero si no le doy me lo quitan a mi
		// e es la informacion tanke escaneado
		if(e.getDistance()>700 && getEnergy()>80){
			fire(3);
		}
		else{
			if(e.getDistance()>700 && getEnergy()<=80){
				fire(2);
			}
			else{
				if(e.getDistance()<=700 && e.getDistance()>=500 && getEnergy()>=80){
					fire(3);
				}
				else{
					if(e.getDistance()<500 && getEnergy()>=60){
						fire(3);
					}
					else{
						if(e.getDistance()<500 && getEnergy()<=60){
							fire(2);
						}
						else{
							if(e.getDistance()<300 && getEnergy()<=50){
								fire(3);
							}
							else{
								fire(1);
							}							
						}
					}
				}
			}
		}
	}
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e){
		// Replace the next line with any behavior you would like
		// aca la e es la información de la bala 
		turnRight((e.getBearing())-90);
		back(280);
	}
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e){
		// Replace the next line with any behavior you would like
		// acá son todos los datos o información del muro
		turnRight((e.getBearing())-90);
	}	
	public void onHitRobot(int bearing){
		if(bearing>=0 && bearing<=90){
			turnLeft(180);
			ahead(100);
			turnLeft(225);
			ahead(100);
			turnLeft(270);
			ahead(100);
		}
		else{
			if(bearing>=91 && bearing<=180){
				turnLeft(270);
				ahead(100);
				turnLeft(315);
				ahead(100);
				turnLeft(360);
				ahead(100);
			}
		}
		if(bearing>=181 && bearing<=270){
			turnRight(360);
			ahead(100);
			turnRight(45);
			ahead(100);
			turnRight(90);
			ahead(100);
		}
		else{
			if(bearing>=271 && bearing<=359){
				turnLeft(90);
				ahead(100);
				turnLeft(135);
				ahead(100);
				turnLeft(180);
				ahead(100);
			}
		}
	}
	public void onWin(){
		setColors(Color.blue,Color.blue,Color.blue); // body,gun,radar
		turnRight(360);
		turnLeft(360);
	}
}