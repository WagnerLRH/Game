import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*
;
public class LoginFrame extends JFrame implements ActionListener{

	static SnakeFrame s;
	private final JLabel LABELUSERNAME,LABELPASSWORD;
	private final JTextField USERNAME;
	private final JPasswordField PASSWORD;
	private final Dimension SIZE;
	private final JButton SUBMIT,FUN;
	private final JLayeredPane PANEL;
	private final JPanel BLACK;
	private final int X=(int)(Toolkit.getDefaultToolkit().getScreenSize().width/2.40);
	private final int Y=(int)(Toolkit.getDefaultToolkit().getScreenSize().height/2.5);

	public LoginFrame() {
		PANEL=this.getLayeredPane();
		SIZE=new Dimension((int)(SnakeFrame.width/2.45),(int)(SnakeFrame.height/3.50));
		LABELUSERNAME=new JLabel("Enter USERNAME");
		LABELPASSWORD=new JLabel("Enter PASSWORD");
		USERNAME=new JTextField();
		PASSWORD=new JPasswordField();
		SUBMIT=new JButton("SUBMIT");
		FUN=new JButton("Just 4 FUN");
		BLACK=new JPanel();
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(X,Y);
		setSize(SIZE);
		setLayout(null);
		s=new SnakeFrame();
		BLACK.setBackground(Color.DARK_GRAY);
		BLACK.setOpaque(true);
		BLACK.setBounds(0, 0, getWidth(), getHeight());
		LABELUSERNAME.setBounds(SIZE.width/12,(int)(SIZE.height/10.08),100,15);
		LABELUSERNAME.setFont(new Font("Times New Roman",Font.PLAIN,15));
		LABELUSERNAME.setForeground(Color.LIGHT_GRAY);
		LABELPASSWORD.setBounds(SIZE.width/12,(int)(SIZE.height/3.58),100,15);
		LABELPASSWORD.setFont(new Font("Times New Roman",Font.PLAIN,15));
		LABELPASSWORD.setForeground(Color.LIGHT_GRAY);
		USERNAME.setBounds(SIZE.width/2, (int)(SIZE.height/10.08), 100, 18);
		USERNAME.setFont(new Font("Times New Roman",Font.PLAIN,15));
		USERNAME.setBackground(Color.GRAY.darker());
		USERNAME.setForeground(Color.LIGHT_GRAY);
		PASSWORD.setBounds((int)(SIZE.width/1.99),(int)(SIZE.height/3.68),100,18);
		PASSWORD.setBackground(Color.GRAY.darker());
		PASSWORD.setForeground(Color.LIGHT_GRAY);
		SUBMIT.setBounds((int)(SIZE.height/4.5),(int)(SIZE.height/2.1),75,25);
		SUBMIT.setBackground(Color.GRAY.darker());
		SUBMIT.setBorder(BorderFactory.createEtchedBorder());
		SUBMIT.setForeground(Color.LIGHT_GRAY);
		SUBMIT.addActionListener(this);
		System.out.println(Thread.currentThread()+" Inside LoginFrame Constructor");
		FUN.setBounds((int)(SIZE.width/2.2), (int)(SIZE.height/2.1), 100, 25);
		FUN.setBackground(Color.GRAY.darker());
		FUN.setBorder(BorderFactory.createEtchedBorder());
		FUN.setForeground(Color.LIGHT_GRAY);
		FUN.addActionListener(this);
		s.setFocusable(true);
		//setAlwaysOnTop(true);
		PANEL.add(LABELUSERNAME,JLayeredPane.MODAL_LAYER);
		PANEL.add(LABELPASSWORD,JLayeredPane.MODAL_LAYER);
		PANEL.add(USERNAME,JLayeredPane.MODAL_LAYER);
		PANEL.add(PASSWORD,JLayeredPane.MODAL_LAYER);
		PANEL.add(SUBMIT,JLayeredPane.MODAL_LAYER);
		PANEL.add(FUN,JLayeredPane.MODAL_LAYER);
		PANEL.add(BLACK,JLayeredPane.DEFAULT_LAYER);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==SUBMIT) {
			s.setFocusable(true);
			System.out.println(Thread.currentThread());
			System.out.println(SwingUtilities.isEventDispatchThread());
			this.dispose();
		}else if(e.getSource()==FUN){
			this.dispose();
			new GameOptions();
		}
	}

}
