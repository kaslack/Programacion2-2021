package hercules;
import robocode.*;
import java.awt.Color;

public class Hercules extends Robot{

	public void run() {

		setColors(Color.red,Color.red,Color.black); // body,gun,radar
		while(true) {
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

	public void onScannedRobot(ScannedRobotEvent e) {

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

	public void onHitByBullet(HitByBulletEvent e){
		// aca la e es la información de la bala 
		turnRight((e.getBearing())-90);
		back(280);
	}

	public void onHitWall(HitWallEvent e){
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