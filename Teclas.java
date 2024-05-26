import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclas extends KeyAdapter{

	boolean runTeclas=true;

		public synchronized void keyPressed(KeyEvent e) {
			//synchronized(teclas) {
				try {
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				System.exit(0);
			}else if((e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)&&runTeclas) {
				SnakeFrame.clicks++;
				if(SnakeFrame.clicks%2>0) {
					SnakeFrame.timea=java.lang.System.currentTimeMillis();
				}else if(SnakeFrame.clicks%2==0) {
					SnakeFrame.timeb=java.lang.System.currentTimeMillis();
				}
				//System.out.println("Char:"+e.getKeyChar());
				if(SnakeFrame.direccion!=KeyEvent.VK_DOWN&&SnakeFrame.trid.getState()==Thread.State.RUNNABLE&&SnakeFrame.direccion!=KeyEvent.VK_UP) {
					SnakeFrame.direccion=KeyEvent.VK_UP;
					wait(); //ESTE ERA EL CULPABLE DE URESPONSIVE KILLED SNAKE
				}else if(SnakeFrame.direccion!=KeyEvent.VK_DOWN&&SnakeFrame.trid.getState()!=Thread.State.RUNNABLE) {
					runTeclas=false;
					synchronized(SnakeFrame.momento) {
					//System.out.println(SnakeFrame.trid.getState());
						SnakeFrame.direccion=KeyEvent.VK_UP;
						SnakeFrame.momento.notify();
					}
					wait();
				}else if(SnakeFrame.direccion==KeyEvent.VK_UP&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed<=SnakeFrame.speedlimit) {
					SnakeFrame.speed++;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia-SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
				}else if(SnakeFrame.direccion==KeyEvent.VK_DOWN&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed>0) {
					SnakeFrame.speed--;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia+SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
				}
			}else if((e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S)&&runTeclas) {
				SnakeFrame.clicks++;
				if(SnakeFrame.clicks%2>0) {
					SnakeFrame.timea=java.lang.System.currentTimeMillis();
				}else if(SnakeFrame.clicks%2==0) {
					SnakeFrame.timeb=java.lang.System.currentTimeMillis();
				}
				if(SnakeFrame.direccion!=KeyEvent.VK_UP&&SnakeFrame.trid.getState()==Thread.State.RUNNABLE&&SnakeFrame.direccion!=KeyEvent.VK_DOWN) {
					SnakeFrame.direccion=KeyEvent.VK_DOWN;
					wait();
				}else if(SnakeFrame.direccion!=KeyEvent.VK_UP&&SnakeFrame.trid.getState()!=Thread.State.RUNNABLE) {
					runTeclas=false;
					synchronized(SnakeFrame.momento) {
					//System.out.println(SnakeFrame.trid.getState());
						SnakeFrame.direccion=KeyEvent.VK_DOWN;
						SnakeFrame.momento.notify();
					}
					wait();
				}else if(SnakeFrame.direccion==KeyEvent.VK_DOWN&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed<=SnakeFrame.speedlimit) {
					SnakeFrame.speed++;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia-SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
				}else if(SnakeFrame.direccion==KeyEvent.VK_UP&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed>0) {
					SnakeFrame.speed--;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia+SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
				}
			}else if((e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)&&runTeclas) {
				SnakeFrame.clicks++;
				if(SnakeFrame.clicks%2>0) {
					SnakeFrame.timea=java.lang.System.currentTimeMillis();
				}else if(SnakeFrame.clicks%2==0) {
					SnakeFrame.timeb=java.lang.System.currentTimeMillis();
				}
				if(SnakeFrame.direccion!=KeyEvent.VK_RIGHT&&SnakeFrame.trid.getState()==Thread.State.RUNNABLE&&SnakeFrame.direccion!=KeyEvent.VK_LEFT) {
					SnakeFrame.direccion=KeyEvent.VK_LEFT;
					wait();
				}else if(SnakeFrame.direccion!=KeyEvent.VK_RIGHT&&SnakeFrame.trid.getState()!=Thread.State.RUNNABLE) {
					runTeclas=false;
					synchronized(SnakeFrame.momento) {
					//System.out.println(SnakeFrame.trid.getState());
						SnakeFrame.direccion=KeyEvent.VK_LEFT;
						SnakeFrame.momento.notify();
					}
					wait();
				}else if(SnakeFrame.direccion==KeyEvent.VK_LEFT&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed<=SnakeFrame.speedlimit) {
					SnakeFrame.speed++;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia-SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
				}else if(SnakeFrame.direccion==KeyEvent.VK_RIGHT&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed>0) {
					SnakeFrame.speed--;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia+SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");

				}
			}else if((e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)&&runTeclas) {
				SnakeFrame.clicks++;
				if(SnakeFrame.clicks%2>0) {
					SnakeFrame.timea=java.lang.System.currentTimeMillis();
				}else if(SnakeFrame.clicks%2==0) {
					SnakeFrame.timeb=java.lang.System.currentTimeMillis();
				}
				/*System.out.println("SnakeFrame.timea="+SnakeFrame.timea);
				System.out.println("SnakeFrame.timeb="+SnakeFrame.timeb);
				System.out.println("Resul="+(SnakeFrame.timea-SnakeFrame.timeb));*/
				if(SnakeFrame.direccion!=KeyEvent.VK_LEFT&&SnakeFrame.trid.getState()==Thread.State.RUNNABLE&&SnakeFrame.direccion!=KeyEvent.VK_RIGHT) {
					SnakeFrame.direccion=KeyEvent.VK_RIGHT;
					wait();
					//System.out.print("IF CAGADALES");
				}else if(SnakeFrame.direccion!=KeyEvent.VK_LEFT&&SnakeFrame.trid.getState()!=Thread.State.RUNNABLE) {
					runTeclas=false;
					synchronized(SnakeFrame.momento) {
					//System.out.println(SnakeFrame.trid.getState());
						SnakeFrame.direccion=KeyEvent.VK_RIGHT;
						SnakeFrame.momento.notify();
					}
					wait();
				}else if(SnakeFrame.direccion==KeyEvent.VK_RIGHT&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed<=SnakeFrame.speedlimit) {
					SnakeFrame.speed++;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia-SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
					//System.out.println("Entered if");
				}else if(SnakeFrame.direccion==KeyEvent.VK_LEFT&&((SnakeFrame.timea-SnakeFrame.timeb)<1000&&(SnakeFrame.timea-SnakeFrame.timeb)>(-1000))&&SnakeFrame.speed>0) {
					SnakeFrame.speed--;
					SnakeFrame.frecuencia=SnakeFrame.frecuencia+SnakeFrame.incremento;
					SnakeFrame.label1.setText("SPEED "+(SnakeFrame.speed+1)*20+"km/h");
				}
			}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				SnakeFrame.direccion=KeyEvent.VK_SPACE;
			}
				}catch(InterruptedException ie) {
					ie.printStackTrace();
				}
		//}//Corchene de synchonized
		}

	}
