import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class ImagenSnake extends JPanel{

		private boolean hole1,hole2,hole3;
		private boolean primersnake;
		private static Color color1,color2,color3;

		public ImagenSnake() {
			primersnake=true;
			hole1=true;
			hole2=false;
			hole3=false;
			color1=Color.BLACK;
			color2=Color.RED;
			color3=Color.LIGHT_GRAY.brighter();
			setOpaque(false);
			setVisible(true);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			for(int i=0;i<SnakeFrame.lista.size();i++) {

				if(i==SnakeFrame.lista.size()-1) {
					if(SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_LEFT||SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_RIGHT) {
						SnakeFrame.lista.get(i).setSize(new Dimension(SnakeFrame.widthPoint,SnakeFrame.heightPoint-6));
						SnakeFrame.lista.get(i).y=SnakeFrame.lista.get(i).y+1;
					}else if(SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_UP||SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_DOWN) {
						SnakeFrame.lista.get(i).setSize(new Dimension(SnakeFrame.widthPoint-6,SnakeFrame.heightPoint));
						SnakeFrame.lista.get(i).x=SnakeFrame.lista.get(i).x+1;
					}
				}

				else if(i==SnakeFrame.lista.size()-2) {
					SnakeFrame.lista.get(i).setPenultima(true);
					if(SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_LEFT||SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_RIGHT) {
						SnakeFrame.lista.get(i).setSize(new Dimension(SnakeFrame.widthPoint,SnakeFrame.heightPoint-4));
						SnakeFrame.lista.get(i).y=SnakeFrame.lista.get(i).y+1;
					}else if(SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_UP||SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_DOWN) {
						SnakeFrame.lista.get(i).setSize(new Dimension(SnakeFrame.widthPoint-4,SnakeFrame.heightPoint));
						SnakeFrame.lista.get(i).x=SnakeFrame.lista.get(i).x+1;
					}
				}

				else if(i==SnakeFrame.lista.size()-3) {
					SnakeFrame.lista.get(i).setantePenultima(true);
					if(SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_LEFT||SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_RIGHT) {
						SnakeFrame.lista.get(i).setSize(new Dimension(SnakeFrame.widthPoint,SnakeFrame.heightPoint-2));
						SnakeFrame.lista.get(i).y=SnakeFrame.lista.get(i).y+1;
					}else if(SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_UP||SnakeFrame.lista.get(i).getDireccionPoint()==KeyEvent.VK_DOWN) {
						SnakeFrame.lista.get(i).setSize(new Dimension(SnakeFrame.widthPoint-2,SnakeFrame.heightPoint));
						SnakeFrame.lista.get(i).x=SnakeFrame.lista.get(i).x+1;
					}
				}

				if(hole1) {
					g.setColor(color1);
					g.fillRect(SnakeFrame.lista.get(i).x, SnakeFrame.lista.get(i).y,SnakeFrame.lista.get(i).getWidth(), SnakeFrame.lista.get(i).getHeight());
					hole1=false;
					hole2=true;
				}

				else if(hole2) {
					g.setColor(color2);
					g.fillRect(SnakeFrame.lista.get(i).x, SnakeFrame.lista.get(i).y,SnakeFrame.lista.get(i).getWidth(), SnakeFrame.lista.get(i).getHeight());
					hole2=false;
					hole3=true;
				}

				else if(hole3) {
					g.setColor(color3);
					g.fillRect(SnakeFrame.lista.get(i).x, SnakeFrame.lista.get(i).y,SnakeFrame.lista.get(i).getWidth(), SnakeFrame.lista.get(i).getHeight());
					hole3=false;
					hole1=true;
				}
			}

			//SnakeFrame.widthPoint=10;
			//SnakeFrame.heightPoint=10;
			hole1=true;
			hole2=false;
			hole3=false;

			g.setColor(Color.red);
			g.fillRect(SnakeFrame.comida.x, SnakeFrame.comida.y, SnakeFrame.widthPoint, SnakeFrame.heightPoint);
		}

		public static void changeColors(Color couleur1,Color couleur2,Color couleur3) {
			color1=couleur1;
			color2=couleur2;
			color3=couleur3;
		}

	}
