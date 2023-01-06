package agriculture;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Farmer extends Frame implements ActionListener
{
	MenuBar mb;
	Menu m1,m2;
	MenuItem  mi1,mi2, mi3,mi4,mi5,mi7,mi8;
	JLabel lab1;
	TextField t2,t3,t4,t5,t7,t8,t10,t11,t13,t14,t15,t16;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	Checkbox c1,c2;
	CheckboxGroup cbg;
	Choice ch1;
	
	Farmer()
	{
		addWindowListener(new WindowAdapter() {    
	            public void windowClosing (WindowEvent e) {    
	                dispose();    
	            }    
	        });    
		  
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setTitle("Agriculture Management System");
		ImageIcon ic=new ImageIcon("C:/Users/DELL/Desktop/farmer1.jfif");
		lab1=new JLabel(ic);
		lab1.setBounds(10,10,screenSize.width,screenSize.height);
		add(lab1);
		
		mb=new MenuBar();
		setMenuBar(mb);
		m1=new Menu("Registration");
		m2=new Menu("Details");
		
		mb.add(m1);
		mb.add(m2);
		
		mi1=new MenuItem("Farmer");
		mi1.addActionListener(this);
		mi2=new MenuItem("Insurance");
		mi2.addActionListener(this);
		mi3=new MenuItem("Authority");
		mi3.addActionListener(this);
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		
		mi4=new MenuItem("Farmer List");
		mi4.addActionListener(this);
		mi5=new MenuItem("Insured Farmer List");
		mi5.addActionListener(this);
		
		mi7=new MenuItem("Domestic Animals ");
		mi7.addActionListener(this);
		mi8=new MenuItem("Authority list ");
		mi8.addActionListener(this);
		
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi7);
		m2.add(mi8);
	
		setSize(screenSize.width,screenSize.height);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mi1)
			new farmer1(); 
		if(ae.getSource()==mi2)
			new Insurance();
		if(ae.getSource()==mi3)
			new authorities();
		if(ae.getSource()==mi4)
			new table1();
		if(ae.getSource()==mi5)
			new table2();
		if(ae.getSource()==mi7)
			new table4();
		if(ae.getSource()==mi8)
			new table3();
		
		
	}
	public static void main(String[] arr)
	{
		new Farmer();
	}
}
	
