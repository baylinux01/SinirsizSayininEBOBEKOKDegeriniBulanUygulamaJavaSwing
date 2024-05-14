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
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Data_giris extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JLabel label1;
	protected JTextField tf1;
	protected JButton btn1,btn2;
	protected Robot robot;
	protected ArrayList<String> arStrList1=new ArrayList<String>();
	protected ArrayList<String> arStrList2=new ArrayList<String>();
	protected ArrayList<Long> ardizi=new ArrayList<Long>();
	protected ArrayList<String> hataList=new ArrayList<String>();
	protected static Data_giris frame;
	protected long girilecekSayi=1;
	protected long arStrList1ElemanNo=0;
	protected long ebob=0;
	protected long ekok=0;
	protected boolean hata=false;
	
	public long getEbob() {
		return ebob;
	}

	public void setEbob(long ebob) {
		this.ebob = ebob;
	}

	public long getEkok() {
		return ekok;
	}

	public void setEkok(long ekok) {
		this.ekok = ekok;
	}

	
	
	public static boolean isSpacedEnded(String s)
	{
		return s!=null && Character.isWhitespace(s.charAt(s.length()-1));
	}
	
	public boolean isFractional(String s) {  
	    return s != null && (s.matches("[-+]?\\d+\\.+") || s.matches("[-+]?\\d+[^0-9.]") || s.matches("[-+]?\\d+\\.+0*[1-9]*+[^0-9]+"));  
	}  
	
	public boolean isFractionalNumeric(String s) {  
	    return s != null && (s.matches("[-+]?\\d+\\.+0*[1-9]+"));  
	}  
	
	public boolean isPositiveExactNumeric(String s) {  
	    return s != null && s.matches("[+]?\\d*\\.?0*");  
	}  
	
	public boolean isNegativeExactNumeric(String s) {  
	    return s != null && s.matches("[-]\\d*\\.?0*");  
	}  
	
	public boolean isExactNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?0*");  
	}  
	
	public boolean isNegativeNumeric(String s) {  
	    return s != null && s.matches("[-]\\d*\\.?\\d+");  
	} 
	
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public long ikiSayiEbobBul(long deger, long deger2)
	{
		long num1,num2,ebob = 0;
		int count1=0;
		if(deger>=deger2) {num2=deger; num1=deger2;}
		else 			  {num1=deger; num2=deger2;}
		
		
		int i=1;
		while (i<=num1) 
		{
			if(num1%i==0) count1++;
			i++;
		}
		
		
		
		long[] dizi1=new long [count1];
		
		i=1;
		int k=0;
		while (i<=num1) 
		{
			if(num1%i==0) 
				{dizi1[k]=i; k++;}
			i++;
		}
			
		i=count1-1;
		k=0;
		while (i<=num2) 
		{
			if(num2%dizi1[i]==0) 
				{
					ebob=dizi1[i];
					break;
				 
				}
			i--;
		}
		return ebob;
	}
	
	public void dataAl()
	{
		
		try {
			
			if(!tf1.getText().equals("") && !tf1.getText().equals("+") && !tf1.getText().equals("-"))
			{	
				
				
				arStrList1.add(tf1.getText());
				while(isSpacedEnded(arStrList1.get((int) arStrList1ElemanNo))) 
				{
					arStrList1.add((int) arStrList1ElemanNo,arStrList1.get((int) arStrList1ElemanNo).substring(0,arStrList1.get((int) arStrList1ElemanNo).length()-1));
					arStrList1.remove(arStrList1.get((int) arStrList1ElemanNo+1));
				}
				
				
				
				if(isExactNumeric(arStrList1.get((int) arStrList1ElemanNo)))
				{
					 ardizi.add(Long.valueOf(arStrList1.get((int) arStrList1ElemanNo)));
					 arStrList1ElemanNo++;
					 girilecekSayi++;
					 tf1.setText("");
					 label1.setText("EBOB ve EKOK'unu bulmak istediğiniz "+girilecekSayi+". sayıyı giriniz");	
					 
				}
				else 
				{   hataList.add(arStrList1.get((int) arStrList1ElemanNo));
					arStrList1.remove((int) arStrList1ElemanNo); tf1.setText(""); hata=true;
				}
			} 
		} catch (NumberFormatException f) {
			
		}
		tf1.requestFocus();
	}
	
	public void ebobVeEkokHesapla() 
	{
		ebob=0;
		ekok=0;
		arStrList1ElemanNo=0;
		girilecekSayi=1;
		
		Collections.sort(ardizi);
		
		long num1;
		long num2;
		
		
		try 
		{
			
				num1 = ardizi.get(0);
				num2 = ardizi.get(1);
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
			num1=2;
			num2=num1;
		}
		
			
		
		
		int i=1;
		int count1=0;
		while (i<=num1) 
		{
			if(num1%i==0) count1++;
			i++;
		}
		
		
		
		long[] dizi1=new long [count1];
		
		i=1;
		int k=0;
		while (i<=num1) 
		{
			if(num1%i==0) 
				{dizi1[k]=i; k++;}
			i++;
		}
			
		i=count1-1;
		k=0;
		int count2=0;
		
		while (i<=num2) 
		{
			count2=0;
			try {
				for(int j=2;j<ardizi.size();j++) 
				{
					if(ardizi.get(j)%dizi1[i]!=0)
					count2++;
				}
			} catch (Exception e) {
				
			}
			
			if(num2%dizi1[i]==0 && count2==0) 
				{
					
					
					ebob=dizi1[i];
					break;
					
				 
				}
			i--;
		}
		
		ArrayList<Long> ardizi2=new ArrayList<Long>();
		
		
		for(i=0;i<ardizi.size();i++)
		{
			ardizi2.add(ardizi.get(i));
		}
		
		for(i=1;i<ardizi.size();i++)
		{
			long ret=ikiSayiEbobBul(ardizi.get(0),ardizi.get(i));
			ekok=(ardizi.get(0)*ardizi.get(i))/ret;
			ardizi.remove(0);
			ardizi.add(0, ekok);
		}
		
		
		
		
		new EbobEkokGoster(frame,ebob,ekok,hata,ardizi2,hataList).setVisible(true);
		
		for(int l=0;l<arStrList1.size();l++)
		{
			arStrList1.remove(l);
		}
		for(int j=0;j<ardizi.size();j++)
		{
			ardizi.remove(j);
		}
		for(i=0;i<ardizi.size();i++)
		{
			ardizi2.remove(i);
		}
		
		dispose();
		
		
		
	}
	
	
		
	
	
	
	DocumentListener dl1=new DocumentListener() 
	{

		public void insertUpdate(DocumentEvent e) 
		{
			if(!tf1.getText().matches("[1-9]+[0-9]*") && !tf1.getText().matches("")) 
			{
	
				tf1.requestFocus();
				tf1.setCaretPosition(tf1.getText().length()); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			
		}

		public void removeUpdate(DocumentEvent e) 
		{
			if(!tf1.getText().matches("[1-9]+[0-9]*") && !tf1.getText().matches("")) 
			{
	
				tf1.requestFocus();
				tf1.setCaretPosition(tf1.getText().length());
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			
		}

		public void changedUpdate(DocumentEvent e) 
		{
			if(!tf1.getText().matches("[1-9]+[0-9]*") && !tf1.getText().matches("")) 
			{
	
				tf1.requestFocus();
				tf1.setCaretPosition(tf1.getText().length()); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			
		}
	};
	
	ActionListener al1=new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{
			dataAl();
			
		}
	};
	
	ActionListener al2=new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{
			dataAl();
			ebobVeEkokHesapla();
			
		}
	};
	
	FocusListener fl1=new FocusListener() 
	{

		public void focusGained(FocusEvent e) {
			btn1.setBackground(Color.white);
			
		}

		
		public void focusLost(FocusEvent e) {
			btn1.setBackground(Color.lightGray);
			
		}
	};
	
	FocusListener fl2=new FocusListener() 
	{

		
		public void focusGained(FocusEvent e) {
			btn2.setBackground(Color.white);
			
		}

		
		public void focusLost(FocusEvent e) {
			btn2.setBackground(Color.lightGray);
			
		}
	};
	
	MouseListener ml1=new MouseListener() 
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
			btn1.setBackground(Color.white);
			//Butonu esas buton yapan ve enter tuşuna cevap veren hale de getiren kod
			getRootPane().setDefaultButton(btn1);
			if(btn2.getBackground().equals(Color.white)) btn1.setBackground(Color.lightGray);
			
			
			
		}

		public void mouseExited(MouseEvent e) 
		{
			btn1.setBackground(Color.lightGray);
			//Butonu esas buton yapan ve enter tuşuna cevap veren hale de getiren kodu iptal eden kod
			getRootPane().setDefaultButton(null);
			
			
		}
	};
	
	MouseListener ml2=new MouseListener() 
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
			btn2.setBackground(Color.white);
			//Butonu esas buton yapan ve enter tuşuna cevap veren hale de getiren kod
			getRootPane().setDefaultButton(btn2);
			if(btn1.getBackground().equals(Color.white)) btn1.setBackground(Color.lightGray);
			
			
			
			
		}

		public void mouseExited(MouseEvent e) 
		{
			btn2.setBackground(Color.lightGray);
			//Butonu esas buton yapan ve enter tuşuna cevap veren hale de getiren kodu iptal eden kod
			getRootPane().setDefaultButton(null);
			
			
		}
	};
	
	KeyListener kl1=new KeyListener() 
	{

		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
				dataAl();
				
            }
			
		}

		public void keyReleased(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}
	};
	
	KeyListener kl2=new KeyListener() 
	{

		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
				dataAl();
				ebobVeEkokHesapla();
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
					frame = new Data_giris();
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
	public Data_giris() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("EBOB ve EKOK'unu bulmak istediğiniz ilk sayıyı giriniz");
		label1.setSize(400,20);
		label1.setLocation(70,40);
		contentPane.add(label1);
		
		tf1 = new JTextField();
		tf1.setSize(400,20);
		tf1.setLocation(70,60);
		contentPane.add(tf1);
		tf1.getDocument().addDocumentListener(dl1);
		
		
		btn1 = new JButton("Sayıyı gir");
		btn1.setHorizontalAlignment(SwingConstants.LEFT);
		btn1.setSize(200,20);
		btn1.setLocation(70,100);
		contentPane.add(btn1);
		btn1.addActionListener(al1);
		//focus sırasında noktalı görünümü yok ederek focusun belli olmamasını sağlayan kod
		btn1.setFocusPainted(false);
		//hover effectini kaldıran kod
		btn1.setBorderPainted(false);
		btn1.setBackground(Color.lightGray);
		btn1.addFocusListener(fl1);
		btn1.addMouseListener(ml1);
		btn1.addKeyListener(kl1);
		
		btn2 = new JButton("Son sayıyı gir ve hesapla");
		btn2.setHorizontalAlignment(SwingConstants.LEFT);
		btn2.setSize(200,20);
		btn2.setLocation(70,140);
		contentPane.add(btn2);
		btn2.addActionListener(al2);
		//focus sırasında noktalı görünümü yok ederek focusun belli olmamasını sağlayan kod
		btn2.setFocusPainted(false);
		//hover effectini kaldıran kod
		btn2.setBorderPainted(false);
		btn2.setBackground(Color.lightGray);
		btn2.addFocusListener(fl2);
		btn2.addMouseListener(ml2);
		btn2.addKeyListener(kl2);
		
		
		
		
		
	}
	
	

}
