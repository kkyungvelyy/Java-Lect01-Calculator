package lect01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class CalculatorUI 
{
	private static JFrame frame;
	private static CalcListener memory = new CalcListener(0);
	private static char action;
	private static byte counter=0;
	private static JTextField screen;
	private static JTextField topScreen;
	private static int error = 0;
	private static byte asnwear = 0;
	private static JButton zero;
	private static JButton one;
	private static JButton two;
	private static JButton three;
	private static JButton four;
	private static JButton five;
	private static JButton six;
	private static JButton seven;
	private static JButton eigth;
	private static JButton nine;
	private static JButton mc;
	private static JButton mr;
	private static JButton mplus;
	private static JButton minus;
	private static JButton mminus;
	private static JButton ms;
	private static JButton mstar;
	private static JButton percentage;
	private static JButton squereRoot;
	private static JButton square;
	private static JButton oneperx;
	private static JButton ce;
	private static JButton c;
	private static JButton del;
	private static JButton div;
	private static JButton multiply;
	private static JButton minuss;
	private static JButton pluss;
	private static JButton dot;
	private static JButton equals;
	
	public void counter()
	{
		counter++;
	}
	
	public static void main(String args[]) throws IOException
	{
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(300,530));
		frame.setLocation(400, 20);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				char ch = e.getKeyChar();
				
				if(e.getKeyChar() == KeyEvent.VK_DELETE){
					ch = 'd';
				}
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					ch = 'e';
				}
				if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
					ch = 'b';
				}
				switch(ch)
				{
					case '0':screenControl("" + ch);zero.setBackground(Color.GRAY);break;
					case '1':screenControl("" + ch);one.setBackground(Color.GRAY);break;
					case '2':screenControl("" + ch);two.setBackground(Color.GRAY);break;
					case '3':screenControl("" + ch);three.setBackground(Color.GRAY);break;
					case '4':screenControl("" + ch);four.setBackground(Color.GRAY);break;
					case '5':screenControl("" + ch);five.setBackground(Color.GRAY);break;
					case '6':screenControl("" + ch);six.setBackground(Color.GRAY);break;
					case '7':screenControl("" + ch);seven.setBackground(Color.GRAY);break;
					case '8':screenControl("" + ch);eigth.setBackground(Color.GRAY);break;
					case '9':screenControl("" + ch);nine.setBackground(Color.GRAY);break;
					case '.':dotControl(ch);dot.setBackground(Color.GRAY);break;
					case '/':divControl();div.setBackground(Color.GRAY);setAction('/');break;
					case '*':mulControl();multiply.setBackground(Color.GRAY);setAction('*');break;
					case '-':minControl();minus.setBackground(Color.GRAY);setAction('-');break;
					case '+':addControl();pluss.setBackground(Color.GRAY);setAction('+');break;
					case 'e':cOperator(getAction());equals.setBackground(Color.GRAY);break;
					case 'b':delControl();del.setBackground(Color.GRAY);break;
					case 'd':ceControl();ce.setBackground(Color.GRAY);break;
					case 'c':mcControl();mc.setBackground(Color.GRAY);break;
				
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				char ch = e.getKeyChar();
				if(e.getKeyChar() == KeyEvent.VK_DELETE){
					ch = 'd';
				}
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					ch = 'e';
				}
				if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
					ch = 'b';
				}
				switch(ch)
				{
					case '0':zero.setBackground(Color.LIGHT_GRAY);break;
					case '1':one.setBackground(Color.LIGHT_GRAY);break;
					case '2':two.setBackground(Color.LIGHT_GRAY);break;
					case '3':three.setBackground(Color.LIGHT_GRAY);break;
					case '4':four.setBackground(Color.LIGHT_GRAY);break;
					case '5':five.setBackground(Color.LIGHT_GRAY);break;
					case '6':six.setBackground(Color.LIGHT_GRAY);break;
					case '7':seven.setBackground(Color.LIGHT_GRAY);break;
					case '8':eigth.setBackground(Color.LIGHT_GRAY);break;
					case '9':nine.setBackground(Color.LIGHT_GRAY);break;
					case '.':dotControl(ch);dot.setBackground(Color.LIGHT_GRAY);break;
					case '/':div.setBackground(Color.LIGHT_GRAY);break;
					case '*':multiply.setBackground(Color.LIGHT_GRAY);break;
					case '-':minus.setBackground(Color.LIGHT_GRAY);break;
					case '+':pluss.setBackground(Color.LIGHT_GRAY);break;
					case 'e':equals.setBackground(Color.LIGHT_GRAY);break;
					case 'b':del.setBackground(Color.LIGHT_GRAY);break;
					case 'd':ce.setBackground(Color.LIGHT_GRAY);break;
					case 'c':mc.setBackground(Color.LIGHT_GRAY);break;
				
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		draw();
	}
	
	public static void draw() throws IOException
	{
		Color myNewColor1 = new Color (226, 226, 226);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel buttonLine = new JPanel();
		buttonLine.setLayout(new GridLayout(1,6));
		topScreen = new JTextField();
		topScreen.setEditable(false);
		topScreen.setFocusable(false);
		topScreen.setHorizontalAlignment(SwingConstants.RIGHT);
		topScreen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		topScreen.setFont(new Font("Arial", Font.PLAIN, 20));
		screen = new JTextField("0");
		screen.setPreferredSize(new Dimension(150, 150));
		screen.setBackground(myNewColor1);
		screen.setFont(new Font("Arial", Font.PLAIN, 20));
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		screen.setEditable(false);
		screen.setFocusable(false);
		screen.setFont(new Font("Arial", Font.PLAIN, 30));
		mc = new JButton("MC");
		mc.setFocusPainted(false);
		mc.setBorder(null);
		mc.setFocusable(false);
		mc.setBackground(myNewColor1);
		mc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mcControl();	
			}
		});
		mc.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mc.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mc.setBackground(myNewColor1);
		    }
		});
		mr = new JButton("MR");
		mr.setFocusPainted(false);
		mr.setBorder(null);
		mr.setFocusable(false);
		mr.setBackground(myNewColor1);
		mr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screen.setText("" + memory.getMemory());
			}
		});
		mr.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mr.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mr.setBackground(myNewColor1);
		    }
		});
		mplus = new JButton("M+");
		mplus.setFocusPainted(false);
		mplus.setBorder(null);
		mplus.setFocusable(false);
		mplus.setBackground(myNewColor1);
		mplus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memory.addToMemory(Double.parseDouble(screen.getText().toString()));
			}
		});
		mplus.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mplus.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mplus.setBackground(myNewColor1);
		    }
		});
		mminus = new JButton("M-");
		mminus.setFocusPainted(false);
		mminus.setBorder(null);
		mminus.setFocusable(false);
		mminus.setBackground(myNewColor1);
		mminus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memory.substractFromMemory(Double.parseDouble(screen.getText().toString()));
			}
		});
		mminus.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mminus.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mminus.setBackground(myNewColor1);
		    }
		});
		ms = new JButton("MS");
		ms.setFocusPainted(false);
		ms.setBorder(null);
		ms.setFocusable(false);
		ms.setBackground(myNewColor1);
		ms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memory.setMemoryPluss(Double.parseDouble(screen.getText().toString()));
				topScreen.setText("" + Double.parseDouble(screen.getText().toString()));
			}
		});
		ms.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ms.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	ms.setBackground(myNewColor1);
		    }
		});
		mstar = new JButton("M*");
		mstar.setFocusPainted(false);
		mstar.setBorder(null);
		mstar.setFocusable(false);
		mstar.setBackground(myNewColor1);
		mstar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	mstar.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	mstar.setBackground(myNewColor1);
		    }
		});
		buttonLine.add(mc);
		buttonLine.add(mr);
		buttonLine.add(mplus);
		buttonLine.add(mminus);
		buttonLine.add(ms);
		buttonLine.add(mstar);
		buttonLine.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		

		percentage = new JButton("%");
		percentage.setFocusPainted(false);
		percentage.setBorder(null);
		percentage.setFocusable(false);
		percentage.setBackground(myNewColor1);
		percentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memory.setMemoryPluss(memory.getMemory());
				topScreen.setText("percentage(" + screen.getText()+ " of " + memory.getMemoryPluss()+ ")");
				screen.setText("" + memory.percentage(Double.parseDouble(screen.getText())));
				
			}
		});
		percentage.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	percentage.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	percentage.setBackground(myNewColor1);
		    }
		});
		char ch = '\u221A';
		squereRoot = new JButton("" +ch);
		squereRoot.setFocusPainted(false);
		squereRoot.setBorder(null);
		squereRoot.setFocusable(false);
		squereRoot.setBackground(myNewColor1);
		squereRoot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				topScreen.setText("sqrt(" + screen.getText()+")");
				screen.setText("" + memory.squareRoot(Double.parseDouble(screen.getText())));
				
			}
		});
		squereRoot.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	squereRoot.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	squereRoot.setBackground(myNewColor1);
		    }
		});
		square = new JButton("x2");
		square.setFocusPainted(false);
		square.setBorder(null);
		square.setFocusable(false);
		square.setBackground(myNewColor1);
		square.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				screen.setText("" + memory.square(Double.parseDouble(screen.getText().toString())));
				topScreen.setText(screen.getText());
			}
		});
		square.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	square.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	square.setBackground(myNewColor1);
		    }
		});
		
		 	 
		del = new JButton("Del");
		del.setFocusPainted(false);
		del.setBorder(null);
		del.setFocusable(false);
		del.setFont(new Font("Arial", Font.PLAIN, 20));
		del.setBackground(Color.LIGHT_GRAY);
		del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					delControl();
					
			}
		});
		del.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	del.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	del.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		oneperx = new JButton("1/x");
		oneperx.setFocusPainted(false);
		oneperx.setBorder(null);
		oneperx.setFocusable(false);
		oneperx.setBackground(myNewColor1);
		oneperx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topScreen.setText("reciproc(" + screen.getText()+")");
				screen.setText("" + memory.reciproc(Double.parseDouble(screen.getText())));
				
			}
		});
		oneperx.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	oneperx.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	oneperx.setBackground(myNewColor1);
		    }
		});
		ce = new JButton("CE");
		ce.setFocusPainted(false);
		ce.setBorder(null);
		ce.setFocusable(false);
		ce.setFont(new Font("Arial", Font.PLAIN, 20));
		ce.setBackground(Color.LIGHT_GRAY);
		ce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ceControl();
				
			}
		});
		ce.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ce.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	ce.setBackground(Color.LIGHT_GRAY);
		    }
		});
		c = new JButton("C");
		c.setFocusPainted(false);
		c.setBorder(null);
		c.setFocusable(false);
		c.setFont(new Font("Arial", Font.PLAIN, 20));
		c.setBackground(Color.LIGHT_GRAY);
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				counter = 0;
				screen.setText("0");
				topScreen.setText("0");
			}
		});
		c.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	c.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	c.setBackground(Color.LIGHT_GRAY);
		    }
		});

		div = new JButton("÷");
		div.setFocusPainted(false);
		div.setBorder(null);
		div.setFocusable(false);
		div.setFont(new Font("Arial", Font.PLAIN, 25));
		div.setBackground(Color.LIGHT_GRAY);
		div.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				divControl();
			}
		});
		div.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	div.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	div.setBackground(Color.LIGHT_GRAY);
		    }
		});
		seven = new JButton("7");
		seven.setFocusPainted(false);
		seven.setBorder(null);
		seven.setFocusable(false);
		seven.setFont(new Font("Arial", Font.PLAIN, 20));
		seven.setBackground(Color.LIGHT_GRAY);
		seven.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			screenControl("7");
				
			}
		});
		seven.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	seven.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	seven.setBackground(Color.LIGHT_GRAY);
		    }
		});
		eigth = new JButton("8");
		eigth.setFocusPainted(false);
		eigth.setBorder(null);
		eigth.setFocusable(false);
		eigth.setFont(new Font("Arial", Font.PLAIN, 20));
		eigth.setBackground(Color.LIGHT_GRAY);
		eigth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("8");
				
			}
		});
		eigth.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	eigth.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	eigth.setBackground(Color.LIGHT_GRAY);
		    }
		});
		nine = new JButton("9");
		nine.setFocusPainted(false);
		nine.setBackground(Color.LIGHT_GRAY);
		nine.setBorder(null);
		nine.setFocusable(false);
		nine.setFont(new Font("Arial", Font.PLAIN, 20));
		nine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("9");
				
			}
		});
		nine.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	nine.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	nine.setBackground(Color.LIGHT_GRAY);
		    }
		});
		multiply = new JButton("x");
		multiply.setFocusPainted(false);
		multiply.setBorder(null);
		multiply.setFocusable(false);
		multiply.setFont(new Font("Arial", Font.PLAIN, 20));
		multiply.setBackground(Color.LIGHT_GRAY);
		multiply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mulControl();
			}
		});
		multiply.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	multiply.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	multiply.setBackground(Color.LIGHT_GRAY);
		    }
		});
		four = new JButton("4");
		four.setFocusPainted(false);
		four.setBorder(null);
		four.setFocusable(false);
		four.setFont(new Font("Arial", Font.PLAIN, 20));
		four.setBackground(Color.LIGHT_GRAY);
		four.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("4");
			}
		});
		four.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	four.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	four.setBackground(Color.LIGHT_GRAY);
		    }
		});
		five = new JButton("5");
		five.setFocusPainted(false);
		five.setBorder(null);
		five.setFocusable(false);
		five.setFont(new Font("Arial", Font.PLAIN, 20));
		five.setBackground(Color.LIGHT_GRAY);
		five.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("5");
			}
		});
		five.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	five.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	five.setBackground(Color.LIGHT_GRAY);
		    }
		});
		six = new JButton("6");
		six.setFocusPainted(false);
		six.setBorder(null);
		six.setFocusable(false);
		six.setFont(new Font("Arial", Font.PLAIN, 20));
		six.setBackground(Color.LIGHT_GRAY);
		six.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("6");
			}
		});
		six.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	six.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	six.setBackground(Color.LIGHT_GRAY);
		    }
		});
		minus = new JButton("-");
		minus.setFocusPainted(false);
		minus.setBorder(null);
		minus.setFocusable(false);
		minus.setFont(new Font("Arial", Font.PLAIN, 25));
		minus.setBackground(Color.LIGHT_GRAY);
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				minControl();
			}
		});
		minus.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	minus.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	minus.setBackground(Color.LIGHT_GRAY);
		    }
		});
		one = new JButton("1");
		one.setFocusPainted(false);
		one.setBorder(null);
		one.setFocusable(false);
		one.setFont(new Font("Arial", Font.PLAIN, 20));
		one.setBackground(Color.LIGHT_GRAY);
		one.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("1");
			}
		});
		one.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	one.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	one.setBackground(Color.LIGHT_GRAY);
		    }
		});
		two = new JButton("2");
		two.setFocusPainted(false);
		two.setBorder(null);
		two.setFocusable(false);
		two.setFont(new Font("Arial", Font.PLAIN, 20));
		two.setBackground(Color.LIGHT_GRAY);
		two.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("2");
			}
		});
		two.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	two.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	two.setBackground(Color.LIGHT_GRAY);
		    }
		});
		three = new JButton("3");
		three.setFocusPainted(false);
		three.setBorder(null);
		three.setFocusable(false);
		three.setFont(new Font("Arial", Font.PLAIN, 20));
		three.setBackground(Color.LIGHT_GRAY);
		three.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenControl("3");
			}
		});
		three.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	three.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	three.setBackground(Color.LIGHT_GRAY);
		    }
		});
		pluss = new JButton("+");
		pluss.setFocusPainted(false);
		pluss.setBorder(null);
		pluss.setFocusable(false);
		pluss.setFont(new Font("Arial", Font.PLAIN, 25));
		pluss.setBackground(Color.LIGHT_GRAY);
		pluss.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addControl();
			}
		});
		pluss.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	pluss.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	pluss.setBackground(Color.LIGHT_GRAY);
		    }
		});
		
		
		minuss = new JButton("±");
		minus.setFocusPainted(false);
		minuss.setBorder(null);
		minuss.setFocusPainted(false);
		minuss.setFocusable(false);
		minuss.setFont(new Font("Arial", Font.PLAIN, 25));
		minuss.setBackground(Color.LIGHT_GRAY);
		minuss.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(screen.getText().length()>0)
				{
					String str = screen.getText();
					if(str.length()==1&&str.charAt(0)=='0')
					{
						
					}
					else if(str.length()<2&&str.substring(0, 1).equalsIgnoreCase("0."))
					{
						minusControll();
					}
					else if(str.length()==2&&str.substring(0, 2).equalsIgnoreCase("-0"))
					{
						minusControll();
					}
					else if(str.length()>=3&&str.substring(0, 3).equalsIgnoreCase("-0."))
					{
						minusControll();
					}
					else
					{
						minusControll();
					}
				}
			}
		});
		minuss.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	minuss.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	minuss.setBackground(Color.LIGHT_GRAY);
		    }
		});
		zero = new JButton("0");
		zero.setFocusPainted(false);
		zero.setBorder(null);
		zero.setFocusable(false);
		zero.setFont(new Font("Arial", Font.PLAIN, 20));
		zero.setBackground(Color.LIGHT_GRAY);
		zero.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				screenControl("0");
				
			}
		});
		zero.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	zero.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	zero.setBackground(Color.LIGHT_GRAY);
		    }
		});
		dot = new JButton(".");
		dot.setFocusPainted(false);
		dot.setBorder(null);
		dot.setFocusable(false);
		dot.setFont(new Font("Arial", Font.PLAIN, 25));
		dot.setBackground(Color.LIGHT_GRAY);
		dot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dotControl('.');
				
			}
		});
		dot.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	dot.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	dot.setBackground(Color.LIGHT_GRAY);
		    }
		});
		equals = new JButton("=");
		equals.setFocusPainted(false);
		equals.setBorder(null);
		equals.setFocusable(false);
		equals.setFont(new Font("Arial", Font.PLAIN, 20));
		equals.setBackground(Color.LIGHT_GRAY);
		equals.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				char cha = getAction();
				cOperator(cha);
			}
		});
	
		equals.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	equals.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	equals.setBackground(Color.LIGHT_GRAY);
		    }
		    
		});
		
		JPanel center = new JPanel();
	
	
		center.setLayout(new GridLayout(6,4));
		
		//배치 
		center.add(percentage);
		center.add(ce);
		center.add(c);
		center.add(del);
		center.add(oneperx);
		center.add(square);
		center.add(squereRoot);
		center.add(div);
		center.add(seven);
		center.add(eigth);
		center.add(nine);
		center.add(multiply);
		center.add(four);
		center.add(five);
		center.add(six);
		center.add(minus);
		center.add(one);
		center.add(two);
		center.add(three);
		center.add(pluss);
		center.add(minuss);
		center.add(zero);
		center.add(dot);
		center.add(equals);
		
		mainPanel.add(topScreen,BorderLayout.NORTH);
		mainPanel.add(screen, BorderLayout.CENTER);
		mainPanel.add(buttonLine, BorderLayout.SOUTH);
		frame.setBackground(myNewColor1);
		frame.getContentPane().add(center,BorderLayout.CENTER);
		frame.getContentPane().add(mainPanel,BorderLayout.NORTH);
		frame.setVisible(true);
	}
	
	public static void ceControl()
	{
		screen.setText("0");
		counter = 0;	
		topScreen.setText("" + memory.getMemory());
	}
	
	public static void mcControl()
	{
		if(counter>0)
		{
			memory.setMemory(0);
			memory.setMemoryPluss(0);
			topScreen.setText("Memory Clear");
		}
	}
	public static void setAction(char ch)
	{
		if(ch == '+')
		{
			action = '+';
		}
		else if(ch == '/')
		{
			action = '/';
		}
		else if(ch =='*')
		{
			action = '*';
		}
		else if(ch =='-')
		{
			action = '-';
		}
		else if(ch == '%')
		{
			
		}
	}
	
	public static void minusControll()
	{
		String str = screen.getText();
		for(int i = 0 ; i < screen.getText().length() ; i++)
		{
			if(str.charAt(i) == '-')
				error++;
		}
		if(error==0)
		{
			screen.setText("-" + screen.getText());
			counter++;
		}
		else
		{
			String str1 = screen.getText();
			screen.setText(str1.substring(1, str1.length()));
			counter--;
		}
		error = 0 ;	
	}
	public static void screenControl(String numberFromScreen)
	{
		if(asnwear>0)
		{
			screen.setText("0");
			asnwear = 0;
			counter = 0;
		}
		if(counter==0&&numberFromScreen.equalsIgnoreCase("0"))
		{
			counter++;
		}

		else if(counter==1&&numberFromScreen.equalsIgnoreCase("."))
		{
			screen.setText(screen.getText() + ".");
		}
		else if(counter>1&&screen.getText().charAt(0)=='0'&&screen.getText().charAt(1)=='.')
		{
			screen.setText(screen.getText() + numberFromScreen);
			counter++;
		}
		else
		{
			if(counter==0&&!numberFromScreen.equalsIgnoreCase("0"))
			{
				if(counter==0)
					screen.setText("");
				screen.setText(screen.getText() + numberFromScreen);
				if(!numberFromScreen.equalsIgnoreCase("0"))
					counter++;
			}
			else if(counter>0&&screen.getText().charAt(0)=='0')
			{
				screen.setText("");
				screen.setText(screen.getText() + numberFromScreen);
				
			}
			else
			{
				screen.setText(screen.getText() + numberFromScreen);
				counter++;
			}
		}
	}
	public static char getAction()
	{
		return action;
	}
	
	public static void dotControl(char ch)
	{
		int error = 0;
		if(screen.getText().length() == 0)
			screen.setText("0");
		counter++;
		if(screen.getText().length()>=0)
		{
			String str = screen.getText();
			for(int i = 0 ; i < screen.getText().length() ; i++)
			{
				if(str.charAt(i) == '.')
					error++;
			}
			if(error==0)
				screen.setText(screen.getText() + ".");
			counter++;
		}
	}
	
	public static void mulControl()
	{
		if(counter>0)
		{
		memory.setMemoryPluss(memory.getMemory());
			 topScreen.setText(screen.getText() + "*");
			 setAction('*');
			 memory.setMemory(Double.parseDouble(screen.getText()));
			 screen.setText("");
			 counter = 0;
		}
	}
	
	public static void delControl()
	{
		if(screen.getText().length()>1)
		{
			screen.setText(""+screen.getText().substring(0, screen.getText().length() - 1));//????????????
			counter--;
		}	
		else
		{
			screen.setText("0");
			counter = 0;
		}
	}
	
	public static void minControl()
	{
		if(counter>0)
		{
		memory.setMemoryPluss(memory.getMemory());	
			 topScreen.setText(screen.getText() + "-");
			 setAction('-');
			 memory.setMemory(Double.parseDouble(screen.getText()));
			 screen.setText("");
			 counter = 0;
		}
	}
	
	public static void divControl()
	{
		if(counter>0)
		{
		memory.setMemoryPluss(memory.getMemory());
			 topScreen.setText(screen.getText() + "/");
			 setAction('/');
			 memory.setMemory(Double.parseDouble(screen.getText()));
			 screen.setText("");
			 counter = 0;
		}
	}
	
	public static void addControl()
	{
		if(counter>0)
		{
		memory.setMemoryPluss(memory.getMemory());
			 topScreen.setText(screen.getText() + "+");
			 setAction('+');
			 memory.setMemory(Double.parseDouble(screen.getText()));
			 screen.setText("");
			 counter = 0;
		}
	}
	
	public static void backControl()
	{
		
	}
	
	public static void cOperator(char cha)
	{
		if(action == '/')
		{
			screen.setText("" + memory.divid(Double.parseDouble(screen.getText().toString())));
			memory.setMemoryPluss(Double.parseDouble(screen.getText().toString()));
			memory.setMemory(Double.parseDouble(screen.getText().toString()));
			asnwear++;
			topScreen.setText("" + memory.getMemoryPluss());
		}
		if(action == '*')
		{
			screen.setText("" + memory.multiply(Double.parseDouble(screen.getText().toString())));
			memory.setMemoryPluss(Double.parseDouble(screen.getText().toString()));
			memory.setMemory(Double.parseDouble(screen.getText().toString()));
			asnwear++;
			topScreen.setText("" + memory.getMemoryPluss());
		}
		if(action == '-')
		{
			memory.setMemoryPluss(Double.parseDouble(screen.getText().toString()));
			screen.setText("" + memory.subtract(memory.getMemoryPluss()));
			memory.setMemoryPluss(Double.parseDouble(screen.getText().toString()));
			memory.setMemory(Double.parseDouble(screen.getText().toString()));
			asnwear++;
			topScreen.setText("" + memory.getMemoryPluss());
		}
		if(action == '+')
		{
			screen.setText("" + memory.add(Double.parseDouble(screen.getText().toString())));
			memory.setMemoryPluss(Double.parseDouble(screen.getText().toString()));
			memory.setMemory(Double.parseDouble(screen.getText().toString()));
			asnwear++;
			topScreen.setText("" + memory.getMemoryPluss());
		}
	}


}