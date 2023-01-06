package agriculture;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;

import org.w3c.dom.html.HTMLAreaElement;

public class farmer1 extends Frame implements ActionListener{
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf9,tf10,tf13,tf14,tf15,tf16;
    Checkbox c1,c2;
    CheckboxGroup cbg;
    Button b1,b2,b3;
    Choice ch8;
    String edu[]={"Select","10th","12th","Graduation","Post Graduation"};

    Connection con=null;
    Statement st=null;
    String name,gender,adhar,address,cont,landowns,qualification,annual_income,member;
    int age,cow,buffalo,bull,goat;
    
    farmer1()
    {
    	setLocation(100,100);
    	addWindowListener(new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
            	 dispose();     
            }    
        }); 
        setBackground(new Color(85,107,47));
        l11=new Label("Farmer Registration",Label.CENTER);
        l11.setBounds(0,30,1000,40);
        l11.setForeground(new Color(240,248,255));
        l11.setBackground(new Color(143,188,143));
        Font f1=new Font("serif",Font.BOLD,30);
        l11.setFont(f1);
        add(l11);
        
        
        l1=new Label("Name : ");
        l1.setForeground(new Color(240,248,255));
        l1.setBounds(50,110,150,25);
        Font f2=new Font("serif",Font.BOLD,15);
        l1.setFont(f2);
        add(l1);
        tf1=new TextField(20);
        tf1.setBounds(250,110,150,20);
        tf1.setBackground(Color.LIGHT_GRAY);
        add(tf1);



        l2=new Label("Gender : ");
        l2.setForeground(new Color(240,248,255));
        l2.setBounds(50,140,150,25);
        l2.setFont(f2);
        add(l2);
        cbg = new CheckboxGroup();
        c1 = new Checkbox("Male",false,cbg);
        c1.setForeground(new Color(240,248,255));
        c1.setBounds(250,140,100,25);
        
        add(c1);
        c2 = new Checkbox("Female",false,cbg);
        c2.setForeground(new Color(240,248,255));
        c2.setBounds(350,140,100,25);
        add(c2);


        l3=new Label("Aadhar no. :");
        l3.setBounds(50,170,150,25);
        l3.setForeground(new Color(240,248,255));
        l3.setFont(f2);
        add(l3);
        tf3=new TextField(20);
        tf3.setBounds(250,170,150,20);
        tf3.setBackground(Color.LIGHT_GRAY);
        add(tf3);


        l4=new Label("Address : ");
        l4.setBounds(50,200,150,25);
        l4.setForeground(new Color(240,248,255));
        l4.setFont(f2);
        add(l4);
        tf4=new TextField(20);
        tf4.setBounds(250,200,150,20);
        tf4.setBackground(Color.LIGHT_GRAY);
        add(tf4);


        l5=new Label("Contact no. :");
        l5.setForeground(new Color(240,248,255));
        l5.setBounds(50,230,150,25);
        l5.setFont(f2);
        add(l5);
        tf5=new TextField(20);
        tf5.setBounds(250,230,150,20);
        tf5.setBackground(Color.LIGHT_GRAY);
        add(tf5);


        l6=new Label("Land Owans (acre): ");
        l6.setForeground(new Color(240,248,255));
        l6.setBounds(50,260,150,25);
        l6.setFont(f2);
        add(l6);
        tf6=new TextField(20);
        tf6.setBounds(250,260,150,20);
        tf6.setBackground(Color.LIGHT_GRAY);
        add(tf6);


        l7=new Label("Age : ");
        l7.setForeground(new Color(240,248,255));
        l7.setBounds(50,290,150,25);
        l7.setFont(f2);
        add(l7);
        tf7=new TextField(20);
        tf7.setBounds(250,290,150,20);
        tf7.setBackground(Color.LIGHT_GRAY);
        add(tf7);


        l8=new Label("Qualification : ");
        l8.setForeground(new Color(240,248,255));
        l8.setBounds(50,320,100,25);
        add(l8);
        l8.setFont(f2);
        ch8=new Choice();
        for(int i=0;i<edu.length;i++)
        {
            ch8.add(edu[i]);
        }
        ch8.setBounds(250,320,100,25);
        ch8.setBackground(Color.LIGHT_GRAY);
        add(ch8);


        l9=new Label("Annual Income : ");
        l9.setForeground(new Color(240,248,255));
        l9.setBounds(50,350,150,25);
        l9.setFont(f2);
        add(l9);
        tf9=new TextField(20);
        tf9.setBounds(250,350,150,20);
        tf9.setBackground(Color.LIGHT_GRAY);
        add(tf9);

        
        l10=new Label("No of Member : ");
        l10.setForeground(new Color(240,248,255));
        l10.setBounds(50,380,150,25);
        l10.setFont(f2);
        add(l10);
        tf10=new TextField(20);
        tf10.setBounds(250,380,150,20);
        tf10.setBackground(Color.LIGHT_GRAY);
        add(tf10);

        b1=new Button("Submit");
        b1.setForeground(new Color(0,0,0));
        Font f4=new Font("serif",Font.BOLD,18);
        b1.setFont(f4);
        b1.addActionListener(this);
        b1.setBounds(100,450,150,25);
        add(b1);

        b2=new Button("Reset");
        b2.setForeground(new Color(0,0,0));
        b2.setFont(f4);
        b2.addActionListener(this);
        b2.setBounds(400,450,150,25);
        add(b2);

        b3=new Button("Exit");
        b3.setForeground(new Color(0,0,0));
        b3.setFont(f4);
        b3.addActionListener(this);
        b3.addActionListener(this);
        b3.setBounds(700,450,150,25);
        add(b3);



        l12=new Label("Domestic Animal",Label.CENTER);
        l12.setForeground(new Color(240,248,255));
        l12.setBounds(670,110,300,20);
        Font f3=new Font("serif",Font.BOLD,25);
        l12.setFont(f3);
        add(l12);

        l13=new Label("Cow : ");
        l13.setForeground(new Color(240,248,255));
        l13.setBounds(600,170,150,25);
        l13.setFont(f2);
        add(l13);
        tf13=new TextField(20);
        tf13.setBounds(770,170,200,20);
        tf13.setBackground(Color.LIGHT_GRAY);
        add(tf13);


        l14=new Label("Buffalo : ");
        l14.setForeground(new Color(240,248,255));
        l14.setBounds(600,200,150,25);
        l14.setFont(f2);
        add(l14);
        tf14=new TextField(20);
        tf14.setBounds(770,200,200,20);
        tf14.setBackground(Color.LIGHT_GRAY);
        add(tf14);


        l15=new Label("Bull : ");
        l15.setForeground(new Color(240,248,255));
        l15.setBounds(600,230,150,25);
        l15.setFont(f2);
        add(l15);
        tf15=new TextField(20);
        tf15.setBounds(770,230,200,20);
        tf15.setBackground(Color.LIGHT_GRAY);
        add(tf15);


        l16=new Label("Goat : ");
        l16.setForeground(new Color(240,248,255));
        l16.setBounds(600,260,150,25);
        l16.setFont(f2);
        add(l16);
        tf16=new TextField(20);
        tf16.setBounds(770,260,200,20);
        tf16.setBackground(Color.LIGHT_GRAY);
        add(tf16);



        setSize(1000,550);
        setLayout(null);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	{
    		name=tf1.getText();
    		if(c1.getState())
    			gender=c1.getLabel();
    		if(c1.getState())
    			gender=c1.getLabel();
    		adhar=tf3.getText();
    		address=tf4.getText();
    		cont=tf5.getText();
    		landowns=tf6.getText();
    		age=Integer.parseInt(tf7.getText());
    		qualification=ch8.getSelectedItem();
    		annual_income=tf9.getText();
    		member=tf10.getText();
    		cow=Integer.parseInt(tf13.getText());
    		buffalo=Integer.parseInt(tf14.getText());
    		bull=Integer.parseInt(tf15.getText());
    		goat=Integer.parseInt(tf16.getText());
    		
    		
    		try
    		{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","1234");
    			st=con.createStatement();
    			System.out.println("Database Connected");
    			st.executeUpdate("insert into farmer_registration (fname,adhar,address,contact,land_owns, gender,age,qualification,annual,no_of_member, cows, buffalo,bell,goat) values('"+name+"','"+adhar+"','"+address+"','"+cont+"','"+landowns+"','"+gender+"',"+age+",'"+qualification+"','"+annual_income+"','"+member+"',"+cow+","+buffalo+","+bull+","+goat+")");
    			System.out.println("Database Inserted Successfully ");
			}
			catch(Exception e) {}
			
		}
    	if(ae.getSource()==b2)
    	{
    		tf1.setText("");
            //tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf9.setText("");
            tf10.setText("");
            tf13.setText("");
            tf14.setText("");
            tf15.setText("");
            tf16.setText("");
    		ch8.select(0);
    		
    	}
    	if(ae.getSource()==b3)
    	{
    			dispose();
        }
    }
    		
    public static void main(String[] args)
    {
        new farmer1();   
    }
 }