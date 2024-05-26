import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;

public class Momento extends Thread {

	private SnakeFrame snake;
	private final WallLabel WALLLABEL=SnakeFrame.getWallLabel();

	/*public Momento(SnakeFrame snake) {
		this.snake=snake;
	}*/

		long last=0;
		public void run() {
			while(SnakeFrame.running) {
				if((java.lang.System.currentTimeMillis()-last)>SnakeFrame.frecuencia) {
					//System.out.println("CTM="+java.lang.System.currentTimeMillis());
					//System.out.println("Las="+last);

					synchronized(SnakeFrame.teclas) {
						SnakeFrame.teclas.notify();
						SnakeFrame.teclas.runTeclas=true;
						}

					if(SnakeFrame.direccion==KeyEvent.VK_UP) {
						SnakeFrame.snake.y=SnakeFrame.snake.y-SnakeFrame.heightPoint;
						for(int i=0; i<SnakeFrame.lista.size();i++) {
							if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x&&!SnakeFrame.primera&&i!=0&&i!=1) {
								SnakeFrame.teclas.runTeclas=false;
								System.out.println("SnakeFrame.direccion==KeyEvent.VK_UP-primera");
								SnakeFrame.button.setVisible(true);
								LoginFrame.s.repaint();
								SnakeFrame.actualizar=false;
								synchronized(SnakeFrame.trid) {
									try {
										SnakeFrame.trid.wait();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								SnakeFrame.running=false;

							}

							if(SnakeFrame.lista.get(i).isPenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y-2&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x) {
									System.out.println("ENTRO PENULTIMA UP");
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_UP-isPenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							if(SnakeFrame.lista.get(i).isantePenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y-1&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_UP-isantePenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							if(SnakeFrame.getInfinito()) {
								if(SnakeFrame.snake.y<10) {
									SnakeFrame.snake.y=SnakeFrame.height-(SnakeFrame.heightPoint*5);
								}
							}else if(SnakeFrame.getWall()) {
								if(SnakeFrame.snake.y<10) {
									SnakeFrame.teclas.runTeclas=false;
									SnakeFrame.button.setVisible(true);
									System.out.println("Entro al getWall UP");
									SnakeFrame.button.requestFocus();
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}else if(SnakeFrame.getHollosWall()) {
								for(int j=0;j<SnakeFrame.getWallLabel().bricks.size();j++) {
									if(SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(j).y&&(SnakeFrame.snake.x==SnakeFrame.getwallLabel().bricks.get(j).x||SnakeFrame.snake.x==SnakeFrame.getwallLabel().bricks.get(j).x+10)) {
										System.out.println("SnakeFrame.direccion==KeyEvent.VK_UP-getHollosWall()");
										SnakeFrame.button.setVisible(true);
										LoginFrame.s.repaint();
										SnakeFrame.actualizar=false;
										synchronized(SnakeFrame.teclas) {
											SnakeFrame.teclas.notify();
											SnakeFrame.teclas.runTeclas=true;
											}
										synchronized(this) {
											try {
												SnakeFrame.running=false;
												wait();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXUP[0]&&SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(i).y-SnakeFrame.heightPoint) {
										System.out.println("ENTRO AL IF ADECUADO");
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricksDown.get(i).y+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXDOWN[2];
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXUP[0]+10&&SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(i).y-SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricksDown.get(i).y+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXDOWN[2]+10;
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXUP[1]&&SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(i).y-SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricksDown.get(i).y+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXDOWN[1];
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXUP[1]+10&&SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(i).y-SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricksDown.get(i).y+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXDOWN[1]+10;
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXUP[2]&&SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(i).y-SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricksDown.get(i).y+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXDOWN[0];
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXUP[2]+10&&SnakeFrame.snake.y<SnakeFrame.getwallLabel().bricks.get(i).y-SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricksDown.get(i).y+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXDOWN[0]+10;
									}
								}
							}

						}

					}else if(SnakeFrame.direccion==KeyEvent.VK_DOWN) {
						SnakeFrame.snake.y=SnakeFrame.snake.y+SnakeFrame.heightPoint;
						for(int i=0;i<SnakeFrame.lista.size();i++) {
							if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x&&!SnakeFrame.primera&&i!=0&&i!=1) {
								SnakeFrame.teclas.runTeclas=false;
								System.out.println("SnakeFrame.direccion==KeyEvent.VK_DOWN-primera");
								SnakeFrame.button.setVisible(true);
								LoginFrame.s.repaint();
								SnakeFrame.actualizar=false;
								synchronized(SnakeFrame.trid) {
									try {
										SnakeFrame.trid.wait();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								SnakeFrame.running=false;
							}

							if(SnakeFrame.lista.get(i).isPenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y-2&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_DOWN-isPeultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							if(SnakeFrame.lista.get(i).isantePenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y-1&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_DOWN-isantePenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							if(SnakeFrame.getInfinito()) {
								if(SnakeFrame.snake.y>SnakeFrame.height-(SnakeFrame.heightPoint*5)) {
									SnakeFrame.snake.y=0;
								}
							}else if(SnakeFrame.getWall()) {
								if(SnakeFrame.snake.y>(SnakeFrame.height-(SnakeFrame.heightPoint*5))-SnakeFrame.heightPoint) {
									SnakeFrame.teclas.runTeclas=false;
									SnakeFrame.button.setVisible(true);
									SnakeFrame.button.requestFocus();
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}else if(SnakeFrame.getHollosWall()) {
								for(int j=0;j<SnakeFrame.getWallLabel().bricksDown.size();j++) {
									if(SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(j).y&&(SnakeFrame.snake.x==SnakeFrame.getwallLabel().bricksDown.get(j).x||SnakeFrame.snake.x==SnakeFrame.getwallLabel().bricksDown.get(j).x+10)) {
											/*synchronized(SnakeFrame.teclas) {
											SnakeFrame.teclas.notify();
											SnakeFrame.teclas.runTeclas=true;
											}*/
										System.out.println("SnakeFrame.direccion==KeyEvent.VK_DOWN-getHollosWall()");
										SnakeFrame.button.setVisible(true);
										LoginFrame.s.repaint();
										SnakeFrame.actualizar=false;
										synchronized(SnakeFrame.teclas) {
											SnakeFrame.teclas.notify();
											SnakeFrame.teclas.runTeclas=true;
											}
										synchronized(this) {
											try {
												SnakeFrame.running=false;
												wait();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXDOWN[0]&&SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(i).y+SnakeFrame.heightPoint) {
										System.out.println("ENTRO AL IF ADECUADO");
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricks.get(i).y-10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXUP[2];
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXDOWN[0]+10&&SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(i).y+SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricks.get(i).y-10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXUP[2]+10;
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXDOWN[1]&&SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(i).y+SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricks.get(i).y-10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXUP[1];
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXDOWN[1]+10&&SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(i).y+SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricks.get(i).y-10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXUP[1]+10;
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXDOWN[2]&&SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(i).y+SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricks.get(i).y-10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXUP[0];
									}else if(SnakeFrame.snake.x==SnakeFrame.getwallLabel().arrayXDOWN[2]+10&&SnakeFrame.snake.y>SnakeFrame.getwallLabel().bricksDown.get(i).y+SnakeFrame.heightPoint) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().bricks.get(i).y-10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().arrayXUP[0]+10;
									}
								}
							}
						}



					}else if(SnakeFrame.direccion==KeyEvent.VK_RIGHT)  {
						SnakeFrame.snake.x=SnakeFrame.snake.x+SnakeFrame.widthPoint;
						for(int i=0;i<SnakeFrame.lista.size();i++) {
							if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x&&!SnakeFrame.primera&&i!=0&&i!=1) {
								SnakeFrame.teclas.runTeclas=false;
								System.out.println("SnakeFrame.direccion==KeyEvent.VK_RIGHT-primera");
								SnakeFrame.button.setVisible(true);
								LoginFrame.s.repaint();///EVIDENTEMENT PORQUE LO CAMBIE DE CLASE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1111111
								SnakeFrame.actualizar=false;
								synchronized(SnakeFrame.trid) {
									try {
										SnakeFrame.trid.wait();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								SnakeFrame.running=false;
							}

							if(SnakeFrame.lista.get(i).isPenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x-2) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_RIGHT-isPenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							if(SnakeFrame.lista.get(i).isantePenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x-1) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_RIGHT-isantePenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							if(SnakeFrame.getInfinito()) {
								if(SnakeFrame.snake.x>SnakeFrame.width-(SnakeFrame.widthPoint*2)) {
									SnakeFrame.snake.x=0;
								}
							}else if(SnakeFrame.getWall()) {
								if(SnakeFrame.snake.x>(SnakeFrame.width-(SnakeFrame.widthPoint*2))-SnakeFrame.widthPoint) {
									SnakeFrame.teclas.runTeclas=false;
									SnakeFrame.button.setVisible(true);
									SnakeFrame.button.requestFocus();
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}else if(SnakeFrame.getHollosWall()) {
								for(int j=0;j<SnakeFrame.getWallLabel().bricksRight.size();j++) {
									if(SnakeFrame.snake.x+SnakeFrame.widthPoint>SnakeFrame.getwallLabel().bricksRight.get(j).x&&(SnakeFrame.snake.y==SnakeFrame.getwallLabel().bricksRight.get(j).y||SnakeFrame.snake.y==SnakeFrame.getwallLabel().bricksRight.get(j).y+10)) {
										/*synchronized(SnakeFrame.teclas) {
											SnakeFrame.teclas.notify();
										 }*/
										SnakeFrame.button.setVisible(true);
										LoginFrame.s.repaint();
										SnakeFrame.actualizar=false;
										synchronized(SnakeFrame.teclas) {
											SnakeFrame.teclas.notify();
											SnakeFrame.teclas.runTeclas=true;
											}
										synchronized(this) {
											try {
												SnakeFrame.running=false;
												wait();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYRIGHT[0]&&SnakeFrame.snake.x>SnakeFrame.getwallLabel().bricksRight.get(i).x+10) {
										System.out.println("Entro al if right");
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYLEFT[1];
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksLeft.get(i).x;
									}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYRIGHT[0]+10&&SnakeFrame.snake.x>SnakeFrame.getwallLabel().bricksRight.get(i).x+10) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYLEFT[1]+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksLeft.get(i).x;
									}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYRIGHT[1]&&SnakeFrame.snake.x>SnakeFrame.getwallLabel().bricksRight.get(i).x+10) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYLEFT[0];
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksLeft.get(i).x;
									}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYRIGHT[1]+10&&SnakeFrame.snake.x>SnakeFrame.getwallLabel().bricksRight.get(i).x+10) {
										SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYLEFT[0]+10;
										SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksLeft.get(i).x;
									}
								}
							}
						}
					}else if(SnakeFrame.direccion==KeyEvent.VK_LEFT) {
						SnakeFrame.snake.x=SnakeFrame.snake.x-SnakeFrame.widthPoint;
						for(int i=0;i<SnakeFrame.lista.size();i++) {
							if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x&&!SnakeFrame.primera&&i!=0&&i!=1) {
								SnakeFrame.teclas.runTeclas=false;
								System.out.println("SnakeFrame.direccion==KeyEvent.VK_LEFT-primera");
								SnakeFrame.button.setVisible(true);
								LoginFrame.s.repaint();
								SnakeFrame.actualizar=false;
								synchronized(SnakeFrame.trid) {
									try {
										SnakeFrame.trid.wait();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								SnakeFrame.running=false;
								}

							if(SnakeFrame.lista.get(i).isPenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x-2) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_LEFT-isPenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							  if(SnakeFrame.lista.get(i).isantePenultima()) {
								if(SnakeFrame.snake.y==SnakeFrame.lista.get(i).y&&SnakeFrame.snake.x==SnakeFrame.lista.get(i).x-1) {
									synchronized(SnakeFrame.teclas) {
										SnakeFrame.teclas.notify();
										}
									System.out.println("SnakeFrame.direccion==KeyEvent.VK_LEFT-isantePenultima()");
									SnakeFrame.button.setVisible(true);
									LoginFrame.s.repaint();
									SnakeFrame.actualizar=false;
									synchronized(SnakeFrame.trid) {
										try {
											SnakeFrame.trid.wait();
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									SnakeFrame.running=false;
								}
							}

							  if(SnakeFrame.getInfinito()) {
									if(SnakeFrame.snake.x<0) {
										SnakeFrame.snake.x=SnakeFrame.width-(SnakeFrame.widthPoint*2);
									}
								}else if(SnakeFrame.getWall()) {
									if(SnakeFrame.snake.x<10) {
										SnakeFrame.teclas.runTeclas=false;
										SnakeFrame.button.setVisible(true);
										SnakeFrame.button.requestFocus();
										LoginFrame.s.repaint();
										SnakeFrame.actualizar=false;
										synchronized(this) {
											try {
												wait();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										SnakeFrame.running=false;
									}
								}else if(SnakeFrame.getHollosWall()) {
									for(int j=0;j<SnakeFrame.getWallLabel().bricksLeft.size();j++) {
										if(SnakeFrame.snake.x-SnakeFrame.heightPoint<SnakeFrame.getwallLabel().bricksLeft.get(j).x&&(SnakeFrame.snake.y==SnakeFrame.getwallLabel().bricksLeft.get(j).y||SnakeFrame.snake.y==SnakeFrame.getwallLabel().bricksLeft.get(j).y+10)) {
											/*synchronized(SnakeFrame.teclas) {
												SnakeFrame.teclas.notify();
											}*/
											SnakeFrame.button.setVisible(true);
											LoginFrame.s.repaint();
											SnakeFrame.actualizar=false;
											synchronized(SnakeFrame.teclas) {
												SnakeFrame.teclas.notify();
												SnakeFrame.teclas.runTeclas=true;
												}
											synchronized(this) {
												try {
													SnakeFrame.running=false;
													wait();
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
										}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYLEFT[0]&&SnakeFrame.snake.x<SnakeFrame.getwallLabel().bricksLeft.get(i).x-10) {
											System.out.println("Entro al if right");
											SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYRIGHT[1];
											SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksRight.get(i).x;
										}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYLEFT[0]+10&&SnakeFrame.snake.x<SnakeFrame.getwallLabel().bricksLeft.get(i).x-10) {
											SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYRIGHT[1]+10;
											SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksRight.get(i).x;
										}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYLEFT[1]&&SnakeFrame.snake.x<SnakeFrame.getwallLabel().bricksLeft.get(i).x-10) {
											SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYRIGHT[0];
											SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksRight.get(i).x;
										}else if(SnakeFrame.snake.y==SnakeFrame.getwallLabel().arrayYLEFT[1]+10&&SnakeFrame.snake.x<SnakeFrame.getwallLabel().bricksLeft.get(i).x-10) {
											SnakeFrame.snake.y=SnakeFrame.getwallLabel().arrayYRIGHT[0]+10;
											SnakeFrame.snake.x=SnakeFrame.getwallLabel().bricksRight.get(i).x;
										}

									}
								}

						  }

					}else if(SnakeFrame.direccion==KeyEvent.VK_SPACE) {
						synchronized(this){
							try {
								wait();
							}catch(InterruptedException ie) {
								ie.printStackTrace();
							}
						}
					}
					if(SnakeFrame.actualizar) SnakeFrame.actualizar();
					/*synchronized(SnakeFrame.teclas) {
					SnakeFrame.teclas.notify();
					SnakeFrame.teclas.runTeclas=true;
					}*/
					last=java.lang.System.currentTimeMillis();
				}
			}
		}

	}
