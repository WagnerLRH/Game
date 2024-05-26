//SNAKEMINE

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.ArrayList;
import javax.imageio.*;

public class SnakeFrame extends JFrame implements ActionListener{

	static int width=640;
	static int height=480;
	static MyPoint snake; //snake siempre es la cabecita
	static Point comida;
	static ArrayList<MyPoint> lista=new ArrayList<MyPoint>();
	static int widthPoint=10;
	static int heightPoint=10;
	static long frecuencia=60;
	static ImagenSnake imagenSnake;
	static JLabel imagenfondo;
	static int direccion=KeyEvent.VK_LEFT;
	//static Momento momento;
	static Momento momento=new Momento();
	static Thread trid= new Thread(momento);
	static long timea,timeb;
	static int clicks=0;
	static int speed =0;
	static boolean primera=true;
	static Teclas teclas;
	static int incremento;
	static int speedlimit;
	static ImageIcon image,image2,image3,image4;
	static JButton button;
	static JPanel info;
	static JLayeredPane pane;
	static GraphicsEnvironment g;
	static Font[] fonts;
	static JLabel label1,label2,label3;
	static int manzanas;
	static byte vidas;
	static Dimension snakeD;
	static boolean running=true;
	static boolean actualizar=true;
	static private WallLabel wallLabel;
	static private boolean infinito,wall,holloswall,fallingwall;

	public SnakeFrame() {
		wallLabel=new WallLabel();
		infinito=true;
		wall=false;
		holloswall=false;
		manzanas=0;
		g=GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts=g.getAllFonts();
		//ACA ESTABA TRATANDO DE MOSTRAR FUENTES PERO ME QUEDE A LA MITAD Y DECIDI ENTRE Gill Sans Ultra Bold
		//O Snap ITC
		incremento=5;
		speedlimit=7;
		setTitle("Snake");
		setSize(width+4, height+77);//OFFSET SO SNAKE FITS PERFECTLY
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-width/2,dim.height/2-height/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teclas=new Teclas();
		this.addKeyListener(teclas);
		startGame();
		//System.out.println();
		label1=new JLabel("SPEED "+(speed+1)*20+"km/h",JLabel.CENTER);
		label1.setFont(new Font("Magneto Bold",Font.PLAIN,18));
		label1.setForeground(Color.red);
		label1.setBackground(Color.DARK_GRAY);
		label1.setBorder(BorderFactory.createLoweredBevelBorder());
		label1.setPreferredSize(new Dimension(190,40));
		label1.setOpaque(true);
		label2=new JLabel("APPLES "+manzanas,JLabel.CENTER);
		label2.setFont(new Font("Magneto Bold",Font.PLAIN,18));
		label2.setForeground(Color.RED);
		label2.setPreferredSize(new Dimension(190,40));
		label2.setBackground(Color.DARK_GRAY);
		label2.setBorder(BorderFactory.createLoweredBevelBorder());
		label2.setOpaque(true);
		label3=new JLabel("VIDAS "+vidas,JLabel.CENTER);
		label3.setFont(new Font("Magneto Bold",Font.PLAIN,18));
		label3.setForeground(Color.red);
		label3.setPreferredSize(new Dimension(190,40));
		label3.setBackground(Color.DARK_GRAY);
		label3.setBorder(BorderFactory.createLoweredBevelBorder());
		label3.setOpaque(true);
		info=new JPanel();
		info.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
		info.setPreferredSize(new Dimension(100,80));
		info.setBackground(Color.GRAY);
		info.setVisible(true);
		info.setOpaque(true);
		info.setBorder(BorderFactory.createLoweredBevelBorder());
		info.add(label1);
		info.add(label2);
		info.add(label3);
		this.add(info,BorderLayout.NORTH);
		pane=new JLayeredPane();
		this.add(pane,BorderLayout.CENTER);
		///////////////7//////////////
		imagenfondo=new JLabel();
		imagenfondo.setBounds(0, 0, width, height); //ES POR ESTO QUE SOBRA UN CACHO DE ABAJO
		image=new ImageIcon("images/GRAMA.jpg");
		image2=new ImageIcon("images/SnakeBackground.jpg");
		image3=new ImageIcon("images/SandBackground.jpg");
		image4=new ImageIcon("images/BACKGROUND.jpg");
		imagenfondo.setIcon(image);
		//this.getContentPane().add(imagenfondo);
		pane.add(imagenfondo, JLayeredPane.DEFAULT_LAYER);
		imagenSnake=new ImagenSnake();
		imagenSnake.setBounds(0,0,width,height);
		//this.getContentPane().add(imagenSnake);
		pane.add(imagenSnake,JLayeredPane.MODAL_LAYER);

		button=new JButton();
		button.setText("RESTART GAME");
		button.setFont(new Font("Comic Sans",Font.BOLD,25));
		button.setForeground(Color.ORANGE);
		button.setBounds((width/2)-125, (height/2)-75, 250, 100);
		button.setVisible(false);
		button.addActionListener(this);
		button.setBackground(Color.GREEN.darker().darker().darker());
		button.setForeground(Color.ORANGE.darker());
		pane.add(button,JLayeredPane.DRAG_LAYER); //PORQUE AGREGAR EL BOTON ACA? TALVEZ POR ESO DA ISSUES AVECES
		///////////////////////////////////////////////////
		setVisible(true);
		setResizable(false);
		trid.start();
		//momento=new Momento(this);
	}

	public static void setInfinito(boolean infinito2) {
		infinito=infinito2;
	}

	public static boolean getInfinito() {
		return infinito;
	}

	public static void setWall(boolean wall2) {
		wall=wall2;
	}

	public static boolean getWall() {
		return wall;
	}

	public static void setHollosWall(boolean wall2) {
		holloswall=wall2;
	}

	public static boolean getHollosWall() {
		return holloswall;
	}

	public static WallLabel getWallLabel() {
		return wallLabel;
	}

	public static void paintWall() {
		pane.add(wallLabel,JLayeredPane.POPUP_LAYER);
		wallLabel.setBounds(0, 0, width, height);
	}

	public static WallLabel getwallLabel() {
		return wallLabel;
	}

	public static void removeWall() {
		pane.remove(wallLabel);
	}

	public static void changeBackground(byte option) {
		if(option==1) {
			imagenfondo.setIcon(image);
		}else if(option==2) {
			imagenfondo.setIcon(image2);
		}else if(option==3) {
			imagenfondo.setIcon(image3);
		}else if(option==4) {
			imagenfondo.setIcon(image4);
		}
	}

	public static void startGame() {
		snakeD=new Dimension(widthPoint,heightPoint);
		comida=new Point();
		snake=new MyPoint(snakeD,(width/2)+widthPoint*1,((height-(heightPoint*5))/2)-5,direccion);
		lista.add(snake);
		snake=new MyPoint(snakeD,(width/2)+widthPoint*2,((height-(heightPoint*5))/2)-5,direccion);
		lista.add(snake);
		snake=new MyPoint(snakeD,(width/2)+widthPoint*3,((height-(heightPoint*5))/2)-5,direccion);
		lista.add(snake);
		snake=new MyPoint(snakeD,(width/2)+widthPoint*4,((height-(heightPoint*5))/2)-5,direccion);
		snake.setantePenultima(true);
		lista.add(snake);
		snake=new MyPoint(new Dimension(widthPoint,heightPoint-4),(width/2)+widthPoint*5,(((height-(heightPoint*5))/2)-5)+2,direccion);
		snake.setPenultima(true);
		lista.add(snake);
		snake=new MyPoint(new Dimension(widthPoint,heightPoint-6),(width/2)+widthPoint*6,(((height-(heightPoint*5))/2)-5)+3,direccion);
		lista.add(snake);
		snake=new MyPoint(lista.get(0).x,lista.get(0).y);
		crearComida();
	}

	public static void crearComida() {
		Random rnd=new Random();
		comida.x=rnd.nextInt(width-(widthPoint*2));
		//comida.x=610;
		if((comida.x%10)>0) {
			comida.x=comida.x-(comida.x%10);
		}

		if(comida.x<=0) {
			comida.x=comida.x+10;
		}

		comida.y=rnd.nextInt(height-(heightPoint*5));
		if((comida.y%10)>0) {
			comida.y=((comida.y-(comida.y%10))); //PORQUE EN EL CODIGO DE POSICION INICIAL DE COMIDA ESTA OFF 3 PIXELES
		}
		if(comida.y<=0) {
			comida.y=comida.y+10;
		}
		//System.out.println("CX:"+comida.x+"-CY:"+comida.y);
	}

	public static void actualizar() {
		imagenSnake.repaint();

		lista.add(0, new MyPoint(new Dimension(widthPoint,heightPoint),snake.x,snake.y, direccion));
		lista.remove(lista.size()-1);

		imagenSnake.repaint();

		if(snake.x==comida.x&&snake.y==comida.y) {
			manzanas++;
			label2.setText("APPLES "+manzanas);
			primera=false;
			lista.add(0,new MyPoint(new Dimension(widthPoint+8,heightPoint+8), snake.x-4,snake.y-4));
			crearComida();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			synchronized(trid) {
				System.out.println("ENTERED ACTION PERFORMED");
				frecuencia=60;
				manzanas=0;
				speed=0;
				label1.setText("SPEED "+(speed+1)*20+"km/h");
				label2.setText("APPLES "+manzanas);
				direccion=KeyEvent.VK_LEFT;
				primera=true;
				button.setVisible(false);
				lista.clear();
				startGame();
				System.out.println("Paso el setVisible");
				LoginFrame.s.requestFocus();
				System.out.println(trid.getState());
				running=true;
				synchronized(teclas) {
					teclas.notify();
					teclas.runTeclas=true;
				}
				//trid=new Momento(this);
				momento=new Momento();
				trid=momento;
				actualizar=true;
				trid.start();
				actualizar();
			}

		}
	}

}
