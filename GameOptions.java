import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * OPTIONS of the Game
 * @version 1.10
 * @author Wagner Rodriguez
**/

public class GameOptions extends JFrame implements ActionListener{

	private final JLayeredPane LAYERED;
	private final JPanel BLACK;
	private final JPanel OPTIONS;
	private final Dimension SIZE1;
	private final JLabel LABEL1,LABEL2,LABEL3,LABEL4;
	private final int X=(int)(Toolkit.getDefaultToolkit().getScreenSize().width/2.48);
	private final int Y=(int)(Toolkit.getDefaultToolkit().getScreenSize().height/2.6);
	private final ImageIcon INFINITE,WALL,HOLEWALL,FALLWALL,INFINITESELECTED,WALLSELECTED,HOLEWALLSELECTED,FALLWALLSELECTED;
	private final ImageIcon COULEUR1,COULEUR2,COULEUR3,COULEUR4,COULEUR2SELECTED;
	private final ImageIcon IMAGE1,IMAGE2,IMAGE3,IMAGE4;
	private final JRadioButton INFINITO,PARED,HOLLOPARED,PAREDCAE;
	private final JRadioButton COLOR1,COLOR2,COLOR3,COLOR4;
	private final JRadioButton IMAGEN1,IMAGEN2,IMAGEN3,IMAGEN4;
	private final ButtonGroup GROUP,GROUP2,GROUP3,GROUP4;
	private final FlowLayout LAYOUT,LAYOUT2,LAYOUT3,LAYOUT4;

	//APARENTEMENTE PARA JPANEL SETVISIBLE() LO PONE AUTOMATICAMENTE OPAQUE(TRUE)
	//PARA JLABEL SIN EMBARGO TUVE QUE PONER FORSADAMENTE (QUE ESTA DENTRO DE UN GUIDLAYOUT) TENGO QUE FORZADAMENTE PONER OPAQUE(TRUE)

	public GameOptions() {
		LAYOUT=new FlowLayout();
		LAYOUT2=new FlowLayout();
		LAYOUT3=new FlowLayout();
		LAYOUT4=new FlowLayout();
		LAYOUT.setVgap(15);
		LAYOUT.setHgap(12);
		GROUP=new ButtonGroup();
		GROUP2=new ButtonGroup();
		GROUP3=new ButtonGroup();
		GROUP4=new ButtonGroup();

		INFINITE=new ImageIcon("images/OPTIONS/Infinity.png");
		WALL=new ImageIcon("images/OPTIONS/WALL.png");
		HOLEWALL=new ImageIcon("images/OPTIONS/WALLHole.png");
		FALLWALL=new ImageIcon("images/OPTIONS/WALLFalling.png");
		INFINITESELECTED=new ImageIcon("images/OPTIONS/InfinitySelected.png");
		WALLSELECTED=new ImageIcon("images/OPTIONS/WALLSELECTED.png");
		HOLEWALLSELECTED=new ImageIcon("images/OPTIONS/WALLHoleSelected.png");
		FALLWALLSELECTED=new ImageIcon("images/OPTIONS/WALLFallingSelected.png");
		INFINITO=new JRadioButton("INFINITE");
		INFINITO.setBackground(Color.GRAY);
		INFINITO.setIcon(INFINITE);
		INFINITO.setHorizontalTextPosition(SwingConstants.CENTER);
		INFINITO.setVerticalTextPosition(SwingConstants.BOTTOM);
		INFINITO.addActionListener(this);
		PARED=new JRadioButton("WALL");
		PARED.setBackground(Color.GRAY);
		PARED.setIcon(WALL);
		PARED.setHorizontalTextPosition(JRadioButton.CENTER);
		PARED.setVerticalTextPosition(JRadioButton.BOTTOM);
		PARED.addActionListener(this);
		HOLLOPARED=new JRadioButton("HOLES");
		HOLLOPARED.setBackground(Color.GRAY);
		HOLLOPARED.setIcon(HOLEWALL);
		HOLLOPARED.setHorizontalTextPosition(JRadioButton.CENTER);
		HOLLOPARED.setVerticalTextPosition(JRadioButton.BOTTOM);
		HOLLOPARED.addActionListener(this);
		PAREDCAE=new JRadioButton("DEBRIS");
		PAREDCAE.setBackground(Color.GRAY);
		PAREDCAE.setIcon(FALLWALL);
		PAREDCAE.setHorizontalTextPosition(JRadioButton.CENTER);
		PAREDCAE.setVerticalTextPosition(JRadioButton.BOTTOM);
		PAREDCAE.addActionListener(this);
		LABEL1=new JLabel();
		LABEL1.setBackground(Color.GRAY);
		LABEL1.setOpaque(true);
		LABEL1.setLayout(LAYOUT);
		LAYOUT.setAlignment(FlowLayout.LEFT);
		LABEL1.add(INFINITO);
		LABEL1.add(PARED);
		LABEL1.add(HOLLOPARED);
		LABEL1.add(PAREDCAE);

		LAYOUT2.setVgap(25);
		COULEUR1=new ImageIcon("images/OPTIONS/GrayBandedKingSnake.png");
		COULEUR2=new ImageIcon("images/OPTIONS/BLACKYellowGreen.png");
		COULEUR3=new ImageIcon("images/OPTIONS/BlueCoral.png");
		COULEUR4=new ImageIcon("images/OPTIONS/GrayBandedKingSnake.png");
		COULEUR2SELECTED=new ImageIcon("images/OPTIONS/ThreeGray.png");
		COLOR1=new JRadioButton("King Snake");
		COLOR1.setBackground(Color.GRAY);
		COLOR1.setIcon(COULEUR1);
		COLOR1.setHorizontalTextPosition(JRadioButton.CENTER);
		COLOR1.setVerticalTextPosition(JRadioButton.BOTTOM);
		COLOR1.addActionListener(this);
		COLOR2=new JRadioButton("BLACK/Yellow");
		COLOR2.setBackground(Color.GRAY);
		COLOR2.setIcon(COULEUR2);
		COLOR2.setHorizontalTextPosition(JRadioButton.CENTER);
		COLOR2.setVerticalTextPosition(JRadioButton.BOTTOM);
		COLOR2.addActionListener(this);
		COLOR3=new JRadioButton("ExoticSnake");
		COLOR3.setBackground(Color.GRAY);
		COLOR3.setIcon(COULEUR3);
		COLOR3.setHorizontalTextPosition(JRadioButton.CENTER);
		COLOR3.setVerticalTextPosition(JRadioButton.BOTTOM);
		COLOR3.addActionListener(this);
		COLOR4=new JRadioButton("BlueCoral");
		COLOR4.setBackground(Color.GRAY);
		COLOR4.setIcon(COULEUR4);
		COLOR4.setHorizontalTextPosition(JRadioButton.CENTER);
		COLOR4.setVerticalTextPosition(JRadioButton.BOTTOM);
		COLOR4.addActionListener(this);
		LABEL2=new JLabel();
		LABEL2.setBackground(Color.GRAY);
		LABEL2.setOpaque(true);
		LABEL2.setLayout(LAYOUT2);
		LABEL2.add(COLOR1);
		LABEL2.add(COLOR2);
		LABEL2.add(COLOR3);

		LAYOUT3.setVgap(5);
		LAYOUT3.setHgap(7);
		LAYOUT3.setAlignment(FlowLayout.LEFT);
		IMAGE1=new ImageIcon("images/OPTIONS/iGramaBackground.jpg");
		IMAGE2=new ImageIcon("images/OPTIONS/iSnakeBackground.jpg");
		IMAGE3=new ImageIcon("images/OPTIONS/iSandBackground.jpg");
		IMAGE4=new ImageIcon("images/OPTIONS/iBackgroundRed.jpg");
		IMAGEN1=new JRadioButton("Grama");
		IMAGEN1.setVerticalTextPosition(JRadioButton.BOTTOM);
		IMAGEN1.setHorizontalTextPosition(JRadioButton.CENTER);
		IMAGEN1.setIcon(IMAGE1);
		IMAGEN1.setBackground(Color.GRAY);
		IMAGEN1.addActionListener(this);
		IMAGEN2=new JRadioButton("Snake");
		IMAGEN2.setVerticalTextPosition(JRadioButton.BOTTOM);
		IMAGEN2.setHorizontalTextPosition(JRadioButton.CENTER);
		IMAGEN2.setIcon(IMAGE2);
		IMAGEN2.setBackground(Color.GRAY);
		IMAGEN2.addActionListener(this);
		IMAGEN3=new JRadioButton("Sand");
		IMAGEN3.setVerticalTextPosition(JRadioButton.BOTTOM);
		IMAGEN3.setHorizontalTextPosition(JRadioButton.CENTER);
		IMAGEN3.setIcon(IMAGE3);
		IMAGEN3.setBackground(Color.GRAY);
		IMAGEN3.addActionListener(this);
		IMAGEN4=new JRadioButton("Rocks");
		IMAGEN4.setVerticalTextPosition(JRadioButton.BOTTOM);
		IMAGEN4.setHorizontalTextPosition(JRadioButton.CENTER);
		IMAGEN4.setIcon(IMAGE4);
		IMAGEN4.setBackground(Color.GRAY);
		IMAGEN4.addActionListener(this);
		LABEL3=new JLabel();
		LABEL3.setBackground(Color.GRAY);
		LABEL3.setOpaque(true);
		LABEL3.setLayout(LAYOUT3);
		LABEL3.add(IMAGEN1);
		LABEL3.add(IMAGEN2);
		LABEL3.add(IMAGEN3);
		LABEL3.add(IMAGEN4);


		SIZE1=new Dimension(300,400);
		LAYERED=getLayeredPane();
		BLACK=new JPanel();
		BLACK.setBackground(Color.RED);
		BLACK.setBounds(0,0,SIZE1.width,SIZE1.height);
		BLACK.setVisible(true);
		GROUP.add(INFINITO);
		GROUP.add(PARED);
		GROUP.add(HOLLOPARED);
		GROUP.add(PAREDCAE);
		GROUP2.add(COLOR1);
		GROUP2.add(COLOR2);
		GROUP2.add(COLOR3);
		GROUP2.add(COLOR4);
		GROUP2.add(IMAGEN1);
		GROUP2.add(IMAGEN2);
		GROUP3.add(IMAGEN3);
		GROUP3.add(IMAGEN4);

		LABEL4=new JLabel();
		LABEL4.setBackground(Color.DARK_GRAY);
		LABEL4.setOpaque(true);
		LABEL4.setVisible(true);

		OPTIONS=new JPanel();
		OPTIONS.setLayout(new GridLayout(4,1));
		OPTIONS.add(LABEL1);
		OPTIONS.add(LABEL2);
		OPTIONS.add(LABEL3);
		OPTIONS.add(LABEL4);
		OPTIONS.setBounds(0, 0, SIZE1.width, SIZE1.height-36);
		OPTIONS.setOpaque(true);
		OPTIONS.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(X,Y);
		setSize(SIZE1.width,SIZE1.height);
		LAYERED.add(BLACK,JLayeredPane.DEFAULT_LAYER);
		LAYERED.add(OPTIONS,JLayeredPane.MODAL_LAYER);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==INFINITO) {
			INFINITO.setEnabled(false);
			PARED.setEnabled(true);
			HOLLOPARED.setEnabled(true);
			PAREDCAE.setEnabled(true);
			SnakeFrame.setWall(false);
			SnakeFrame.setInfinito(true);
			SnakeFrame.setHollosWall(false);
			LoginFrame.s.repaint();
			SnakeFrame.removeWall();
		}else if(e.getSource()==PARED) {
			PARED.setEnabled(false);
			INFINITO.setEnabled(true);
			HOLLOPARED.setEnabled(true);
			PAREDCAE.setEnabled(true);
			SnakeFrame.setWall(true);
			SnakeFrame.setInfinito(false);
			SnakeFrame.setHollosWall(false);
			SnakeFrame.paintWall();
			LoginFrame.s.repaint();
		}else if(e.getSource()==HOLLOPARED) {
			HOLLOPARED.setEnabled(false);
			INFINITO.setEnabled(true);
			PARED.setEnabled(true);
			PAREDCAE.setEnabled(true);
			SnakeFrame.setHollosWall(true);
			SnakeFrame.setWall(false);
			SnakeFrame.setInfinito(false);
			SnakeFrame.paintWall();
			LoginFrame.s.repaint();
		}else if(e.getSource()==PAREDCAE) {
			PAREDCAE.setEnabled(false);
			INFINITO.setEnabled(true);
			PARED.setEnabled(true);
			HOLLOPARED.setEnabled(true);
		}else if(e.getSource()==COLOR1) {
			COLOR1.setEnabled(false);
			COLOR2.setEnabled(true);
			COLOR3.setEnabled(true);
			COLOR4.setEnabled(true);
			ImagenSnake.changeColors(Color.BLACK, Color.RED, Color.LIGHT_GRAY.brighter());
		}else if(e.getSource()==COLOR2) {
			COLOR2.setEnabled(false);
			COLOR1.setEnabled(true);
			COLOR3.setEnabled(true);
			COLOR4.setEnabled(true);
			ImagenSnake.changeColors(Color.BLACK, Color.LIGHT_GRAY, Color.GREEN.darker());
		}else if(e.getSource()==COLOR3) {
			COLOR3.setEnabled(false);
			COLOR1.setEnabled(true);
			COLOR2.setEnabled(true);
			COLOR4.setEnabled(true);
			ImagenSnake.changeColors(Color.RED, Color.CYAN, Color.BLACK);
		}else if(e.getSource()==IMAGEN1) {
			IMAGEN1.setEnabled(false);
			IMAGEN2.setEnabled(true);
			IMAGEN3.setEnabled(true);
			IMAGEN4.setEnabled(true);
			SnakeFrame.changeBackground((byte)1);
		}else if(e.getSource()==IMAGEN2) {
			IMAGEN1.setEnabled(true);
			IMAGEN2.setEnabled(false);
			IMAGEN3.setEnabled(true);
			IMAGEN4.setEnabled(true);
			SnakeFrame.changeBackground((byte)2);
		}else if(e.getSource()==IMAGEN3) {
			IMAGEN1.setEnabled(true);
			IMAGEN2.setEnabled(true);
			IMAGEN3.setEnabled(false);
			IMAGEN4.setEnabled(true);
			SnakeFrame.changeBackground((byte)3);
		}else if(e.getSource()==IMAGEN4) {
			IMAGEN1.setEnabled(true);
			IMAGEN2.setEnabled(true);
			IMAGEN3.setEnabled(true);
			IMAGEN4.setEnabled(false);
			SnakeFrame.changeBackground((byte)4);
		}
	}

}
