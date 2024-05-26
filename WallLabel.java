import javax.swing.*;
import java.awt.*;
import java.util.*;

public class WallLabel extends JLabel{

	int counter;
	int width,height;
	Random r;
	byte randomUp,randomRight,randomDown,randomLeft;
	byte randomUp2,randomRight2,randomDown2,randomLeft2;
	byte randomUp3,randomDown3;
	byte upMax,rightMax,downMax,leftMax;
	ArrayList<Point> bricks=new ArrayList<Point>();
	ArrayList<Point> bricksDown=new ArrayList<Point>();
	ArrayList<Point> bricksRight=new ArrayList<Point>();
	ArrayList<Point> bricksLeft=new ArrayList<Point>();
	int[] arrayXUP=new int[3];
	int[] arrayXDOWN=new int[3];
	int[] arrayYLEFT=new int[2];
	int[] arrayYRIGHT=new int[2];
	byte xcounter;
	//TENGO QUE CREAR BRICKSDOWN
	//TENGO UN PROBLEMA LUEGO DE PONER PAUSA DESPUES DE HABER RESTAR GAME AUX MOIS UNE FOIS

	public WallLabel() {
		xcounter=0;
		r=new Random();
		upMax=31;
		randomUp=(byte)r.nextInt(1,upMax/3);
		randomUp2=(byte)r.nextInt(upMax/3,(upMax/3)*2);
		randomUp3=(byte)r.nextInt((upMax/3)*2,upMax);
		rightMax=21;
		randomRight=(byte)r.nextInt(1,rightMax/2);
		randomRight2=(byte)r.nextInt(rightMax/2,rightMax);
		downMax=31;
		randomDown=(byte)r.nextInt(1,downMax/3);
		randomDown2=(byte)r.nextInt(downMax/3,(downMax/3)*2);
		randomDown3=(byte)r.nextInt((downMax/3)*2,downMax);
		leftMax=21;
		randomLeft=(byte)r.nextInt(1,leftMax/2);
		randomLeft2=(byte)r.nextInt(leftMax/2,leftMax);
		width=20;
		height=10;
		counter=0;
		setOpaque(false);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		if(SnakeFrame.getWall()) {
			g.setColor(Color.RED.darker());
			g.fillRect(0, 0, 620, 10);
			counter=0;

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<31;i++) {
				g.drawRect(counter, 0, width, height);
				counter=counter+width;
			}
			counter=0;

			g.setColor(Color.RED.darker());
			g.fillRect(620, 0, 10, 430);

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<21;i++) {
				g.drawRect(620, counter, height, width);
				counter=counter+width;
			}
			counter=0;

			g.setColor(Color.RED.darker());
			g.fillRect(height,430,630,height);

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<31;i++) {
				if(i==0) {
					counter=counter+height;
				}else {
					counter=counter+width;
				}
				g.drawRect(counter,430,width,height);
			}
			counter=0;

			g.setColor(Color.RED.darker());
			g.fillRect(0, height, height, 620);

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<21;i++) {
				if(i==0) {
					counter=counter+height;
				}else {
					counter=counter+width;
				}
				g.drawRect(0, counter, height, width);
			}
			counter=0;

		}else if(SnakeFrame.getHollosWall()) {
			g.setColor(Color.RED.darker());
			for(int i=0;i<32;i++) {
				if(i!=randomUp&&i!=randomUp2&&i!=randomUp3) {
					g.fillRect(counter, 0, width, height);
					bricks.add(new Point(counter,height));
					counter=counter+width;
				}else if(i==randomUp||i==randomUp2||i==randomUp3) {
					arrayXUP[xcounter]=counter;
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;


			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<32;i++) {
				if(i!=randomUp&&i!=randomUp2&&i!=randomUp3) {
					g.drawRect(counter, 0, width, height);
					counter=counter+width;
				}else if(i==randomUp||i==randomUp2||i==randomUp3) {
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;

			g.setColor(Color.RED.darker());
			for(int i=0;i<22;i++) {
				if(i!=randomRight&&i!=randomRight2) {
					g.fillRect(620, counter, height, width);
					bricksRight.add(new Point(630-height,counter));
					counter=counter+width;
				}else if(i==randomRight||i==randomRight2) {
					arrayYRIGHT[xcounter]=counter;
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<22;i++) {
				if(i!=randomRight&&i!=randomRight2) {
					g.drawRect(620, counter, height, width);
					counter=counter+width;
				}else if(i==randomRight||i==randomRight2) {
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;

			g.setColor(Color.RED.darker());
			for(int i=0;i<32;i++) {
				if(i!=randomDown&&i!=randomDown2&&i!=randomDown3) {
					g.fillRect(counter, 430, width, height);
					bricksDown.add(new Point(counter,430-height));
					counter=counter+width;
				}else if(i==randomDown||i==randomDown2||i==randomDown3) {
					arrayXDOWN[xcounter]=counter;
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<31;i++) {
				if(i!=randomDown&&i!=randomDown2&&i!=randomDown3) {
					g.drawRect(counter, 430, width, height);
					counter=counter+width;
				}else if(i==randomDown||i==randomDown2||i==randomDown3) {
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;

			g.setColor(Color.RED.darker());
			for(int i=0;i<22;i++) {
				if(i!=randomLeft&&i!=randomLeft2) {
					g.fillRect(0, counter, height, width);
					bricksLeft.add(new Point(0,counter));
					counter=counter+width;
				}else if(i==randomLeft||i==randomLeft2) {
					arrayYLEFT[xcounter]=counter;
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;

			g.setColor(Color.LIGHT_GRAY);
			for(int i=0;i<22;i++) {
				if(i!=randomLeft&&i!=randomLeft2) {
					g.drawRect(0, counter, height, width);
					counter=counter+width;
				}else if(i==randomLeft||i==randomLeft2) {
					counter=counter+width;
					xcounter++;
				}
			}
			counter=0;
			xcounter=0;
		}
	}

	public ArrayList<Point> getBricks(){
		return bricks;
	}

}
