package sinirsiz_sayi_ebob_ekok;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EbobEkokGoster extends JFrame {

	private JPanel contentPane;
	protected JLabel label2,label3;
	protected JTextField tf2,tf3;
	protected JButton btn3,btn4;
	protected Data_giris yframe;
	protected static EbobEkokGoster frame;
	protected JScrollPane sp1;
	protected JEditorPane ep1;

	/**
	 * Launch the application.
	 */
	DocumentListener dl=new DocumentListener() {

		public void insertUpdate(DocumentEvent e) 
		{
			
			
		}

		public void removeUpdate(DocumentEvent e) 
		{
			
			
		}

		public void changedUpdate(DocumentEvent e) 
		{
			
			
		}
	};
	
	ActionListener al3=new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{
			tf2.setText("");
			tf3.setText("");
			new Data_giris().setVisible(true);
			dispose();
			
			
			
		}
	};
	
	
	
	ActionListener al4=new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
			
		}
	};
	
	FocusListener fl3=new FocusListener() 
	{

		public void focusGained(FocusEvent e) {
			btn3.setBackground(Color.white);
			
		}

		
		public void focusLost(FocusEvent e) {
			btn3.setBackground(Color.lightGray);
			
		}
	};
	
	FocusListener fl4=new FocusListener() 
	{

		
		public void focusGained(FocusEvent e) {
			btn4.setBackground(Color.white);
			
		}

		
		public void focusLost(FocusEvent e) {
			btn4.setBackground(Color.lightGray);
			
		}
	};
	
	MouseListener ml3=new MouseListener() 
	{

		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) 
		{
			btn3.setBackground(Color.white);
			getRootPane().setDefaultButton(btn3);
			if(btn4.getBackground().equals(Color.white)) btn3.setBackground(Color.lightGray);
			
		}

		public void mouseExited(MouseEvent e) 
		{
			btn3.setBackground(Color.lightGray);
			getRootPane().setDefaultButton(null);
			
		}
	};
	
	MouseListener ml4=new MouseListener() 
	{

		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) 
		{
			btn4.setBackground(Color.white);
			getRootPane().setDefaultButton(btn4);
			if(btn3.getBackground().equals(Color.white)) btn3.setBackground(Color.lightGray);
			
		}

		public void mouseExited(MouseEvent e) 
		{
			btn4.setBackground(Color.lightGray);
			getRootPane().setDefaultButton(null);
			
		}
	};
	
	KeyListener kl3=new KeyListener() 
	{

		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
				tf2.setText("");
				tf3.setText("");
				new Data_giris().setVisible(true);
				dispose();
				
            }
			
		}

		public void keyReleased(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}
	};
	
	KeyListener kl4=new KeyListener() 
	{

		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
				System.exit(0);
            }
			
		}

		public void keyReleased(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}
	};
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EbobEkokGoster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EbobEkokGoster() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900,400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		label2 = new JLabel("Girdiğiniz sayıların EBOB değeri şudur");
		label2.setSize(400,20);
		label2.setLocation(70,40);
		contentPane.add(label2);
		
		tf2 = new JTextField();
		tf2.setSize(400,20);
		tf2.setLocation(70,60);
		contentPane.add(tf2);
		
		label3 = new JLabel("Girdiğiniz sayıların EKOK değeri şudur");
		label3.setSize(400,20);
		label3.setLocation(70,100);
		contentPane.add(label3);
		
		tf3 = new JTextField();
		tf3.setSize(400,20);
		tf3.setLocation(70,120);
		contentPane.add(tf3);
		
		btn3 = new JButton("Başa Dön");
		btn3.setSize(100,20);
		btn3.setLocation(70,160);
		contentPane.add(btn3);
		btn3.addActionListener(al3);
		//focus sırasında noktalı görünümü yok ederek focusun belli olmamasını sağlayan kod
		btn3.setFocusPainted(false);
		//hover effectini kaldıran kod
		btn3.setBorderPainted(false);
		btn3.setBackground(Color.lightGray);
		btn3.addFocusListener(fl3);
		btn3.addMouseListener(ml3);
		btn3.addKeyListener(kl3);
		
		
		btn4 = new JButton("ÇIKIŞ");
		btn4.setSize(100,20);
		btn4.setLocation(70,200);
		contentPane.add(btn4);
		btn4.addActionListener(al4);
		//focus sırasında noktalı görünümü yok ederek focusun belli olmamasını sağlayan kod
		btn4.setFocusPainted(false);
		//hover effectini kaldıran kod
		btn4.setBorderPainted(false);
		btn4.setBackground(Color.lightGray);
		btn4.addFocusListener(fl4);
		btn4.addMouseListener(ml4);
		btn4.addKeyListener(kl4);
		
		tf2.setFocusable(false);
		tf3.setFocusable(false);
		sp1=new JScrollPane();
		sp1.setSize(300,280);
		sp1.setLocation(500,60);
		
		ep1=new JEditorPane();
		sp1.setViewportView(ep1);
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(sp1);
	}
	
	public EbobEkokGoster(Data_giris yframe,long ebob,long ekok,boolean hata,ArrayList<Long> ardizi2,ArrayList<String> hataList) 
	{
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900,400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		label2 = new JLabel("Girdiğiniz sayıların EBOB değeri şudur");
		label2.setSize(400,20);
		label2.setLocation(70,40);
		contentPane.add(label2);
		
		tf2 = new JTextField();
		tf2.setSize(400,20);
		tf2.setLocation(70,60);
		tf2.setFocusable(false);
		contentPane.add(tf2);
		
		label3 = new JLabel("Girdiğiniz sayıların EKOK değeri şudur");
		label3.setSize(400,20);
		label3.setLocation(70,100);
		contentPane.add(label3);
		
		tf3 = new JTextField();
		tf3.setSize(400,20);
		tf3.setLocation(70,120);
		tf3.setFocusable(false);
		contentPane.add(tf3);
		
		btn3 = new JButton("Başa Dön");
		btn3.setSize(100,20);
		btn3.setLocation(70,160);
		contentPane.add(btn3);
		btn3.addActionListener(al3);
		//focus sırasında noktalı görünümü yok ederek focusun belli olmamasını sağlayan kod
		btn3.setFocusPainted(false);
		//hover effectini kaldıran kod
		btn3.setBorderPainted(false);
		btn3.setBackground(Color.lightGray);
		btn3.addFocusListener(fl3);
		btn3.addMouseListener(ml3);
		btn3.addKeyListener(kl3);
		
		
		btn4 = new JButton("ÇIKIŞ");
		btn4.setSize(100,20);
		btn4.setLocation(70,200);
		contentPane.add(btn4);
		btn4.addActionListener(al4);
		//focus sırasında noktalı görünümü yok ederek focusun belli olmamasını sağlayan kod
		btn4.setFocusPainted(false);
		//hover effectini kaldıran kod
		btn4.setBorderPainted(false);
		btn4.setBackground(Color.lightGray);
		btn4.addFocusListener(fl4);
		btn4.addMouseListener(ml4);
		btn4.addKeyListener(kl4);
		
		tf2.setFocusable(false);
		tf3.setFocusable(false);
		sp1=new JScrollPane();
		sp1.setSize(300,280);
		sp1.setLocation(500,60);
		
		ep1=new JEditorPane();
		ep1.setFocusable(false);
		sp1.setViewportView(ep1);
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(sp1);
		
		
		
		if(ekok==0) 
		{
			tf2.setText("Eksik veya hatalı değer");
			tf3.setText("Eksik veya hatalı değer");
		}
		else if(hata==true) 
		{
			
			ep1.setText("Girdiğiniz "+ardizi2.size()+" adet sayı aşağıdadır\n");
			for(int i=0;i<ardizi2.size();i++)
			{
				ep1.setText(ep1.getText()+ardizi2.get(i)+"\n");
			}
			ep1.setText(ep1.getText()+"Girdiğiniz "+hataList.size()+" adet hatalı değer aşağıdadır\n");
			for(int i=0;i<hataList.size();i++)
			{
				ep1.setText(ep1.getText()+hataList.get(i)+"\n");
			}
			tf2.setText(ebob+"");
			tf3.setText(ekok+"");
		}
		else
		{
		ep1.setText("Girdiğiniz "+ardizi2.size()+" adet sayı aşağıdadır\n");
		for(int i=0;i<ardizi2.size();i++)
		{
			ep1.setText(ep1.getText()+ardizi2.get(i)+"\n");
		}
		tf2.setText(ebob+"");
		tf3.setText(ekok+"");
		
		}
		
		
		
    }
}
