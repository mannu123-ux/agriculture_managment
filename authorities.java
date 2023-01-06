package agriculture;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;

public class authorities extends Frame implements ActionListener{
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf9,tf10,tf11;
    Button b1,b2;
    Checkbox r1,r2;
    CheckboxGroup cbg;
    Choice ch8;
    String edu[]={"Select","10th","12th","Graduation","Post Graduation"};
    
    Connection con=null;
    Statement st=null;
    String name,degis,cont,office,working,email,gender,age,qualification,annual;

   
   
    authorities()
    {

       /*  this.setBounds(50,50,600,600);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("image1.jpg"));
        l10=new Label(img);
        l10.setBounds(0,0,600,600);
        add(l10); */
    	addWindowListener(new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
            	 dispose(); 
            }    
        });    
    	setLocation(270,50);
    	setResizable(false);
    	setBackground(new Color(143,188,143));
    	
        l1=new Label("Authorities Registration ",Label.CENTER);
        l1.setBounds(0,30,800,40);
        l1.setBackground(new Color(60,179,113));
        l1.setForeground(new Color(240,248,255));
        Font f1=new Font("serif",Font.BOLD,25);
        l1.setFont(f1);
        add(l1);


        l2=new Label("Name : ");
        l2.setForeground(new Color(240,248,255));
        l2.setBounds(220,110,100,30);
        add(l2);
        Font f2=new Font("serif",Font.BOLD,20);
        l2.setFont(f2);
        tf1=new TextField(20);
        tf1.setBounds(400,110,200,30);
        tf1.setBackground(Color.LIGHT_GRAY);
        add(tf1);

        l3=new Label("Designation : ");
        l3.setForeground(new Color(240,248,255));
        l3.setBounds(220,160,100,30);
        add(l3);
        l3.setFont(f2);
        tf2=new TextField(20);
        tf2.setBounds(400,160,200,30);
        tf2.setBackground(Color.LIGHT_GRAY);
        add(tf2);


        l4=new Label("Contact no : ");
        l4.setForeground(new Color(240,248,255));
        l4.setBounds(220,210,100,30);
        add(l4);
        l4.setFont(f2);
        tf3=new TextField(20);
        tf3.setBounds(400,210,200,30);
        tf3.setBackground(Color.LIGHT_GRAY);
        add(tf3);


        l5=new Label("Office Add : ");
        l5.setForeground(new Color(240,248,255));
        l5.setBounds(220,260,100,30);
        add(l5);
        l5.setFont(f2);
        tf4=new TextField(20);
        tf4.setBounds(400,260,200,30);
        tf4.setBackground(Color.LIGHT_GRAY);
        add(tf4);


        l6=new Label("Working hr. :");
        l6.setForeground(new Color(240,248,255));
        l6.setBounds(220,310,100,30);
        add(l6);
        l6.setFont(f2);
        tf5=new TextField(20);
        tf5.setBounds(400,310,200,30);
        tf5.setBackground(Color.LIGHT_GRAY);
        add(tf5);

        l7=new Label("E-mail :");
        l7.setBounds(220,360,100,30);
        l7.setForeground(new Color(240,248,255));
        add(l7);
        l7.setFont(f2);
        tf6=new TextField(20);
        tf6.setBounds(400,360,200,30);
        tf6.setBackground(Color.LIGHT_GRAY);
        add(tf6);
        
        l8=new Label("Gender :");
        l8.setForeground(new Color(240,248,255));
        l8.setBounds(220,410,100,30);
        add(l8);
        
        l8.setFont(f2);
        cbg = new CheckboxGroup();
        r1 = new Checkbox("Male",false,cbg);
        r1.setFont(f2);
        r1.setForeground(new Color(240,248,255));
        r1.setBounds(400,410,60,30);
        
        add(r1);
        r2 = new Checkbox("Female",false,cbg);
        r2.setFont(f2);
        r2.setForeground(new Color(240,248,255));
        r2.setBounds(480,410,100,30);
        add(r2);


        l9=new Label("Age :");
        l9.setForeground(new Color(240,248,255));
        l9.setBounds(220,460,100,30);
        add(l9);
        l9.setFont(f2);
        tf7=new TextField(20);
        tf7.setBounds(400,460,200,30);
        tf7.setBackground(Color.LIGHT_GRAY);
        add(tf7);

        l10=new Label("Qualification :");
        l10.setForeground(new Color(240,248,255));
        l10.setBounds(220,510,100,30);
        add(l10);
        l10.setFont(f2);
        ch8=new Choice();
        for(int i=0;i<edu.length;i++)
        {
            ch8.add(edu[i]);
        }
        ch8.setBounds(400,510,200,30);
        ch8.setBackground(Color.LIGHT_GRAY);
        add(ch8);


      /*  l11=new Label("Annual Income :");
        l11.setBounds(50,380,100,25);
        add(l11);
        Font f11=new Font("serif",Font.BOLD,15);
        l11.setFont(f11);
        tf9=new TextField(20);
        tf9.setBounds(250,380,300,25);
        tf9.setBackground(Color.LIGHT_GRAY);
        add(tf9);
*/


        

        b1=new Button("Submit");
        b1.setBounds(270,570,100,30);
        b1.addActionListener(this);
        
        add(b1);
        b2=new Button("Reset");
        b2.setBounds(430,570,100,30);
        b2.addActionListener(this);
        add(b2);

        setSize(800,650);
        setLayout(null);
        setVisible(true);  
    }

    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	{
    		name=tf1.getText();
    		degis=tf2.getText();
    		cont=tf3.getText();
    		office=tf4.getText();
    		working=tf5.getText();
    		email=tf6.getText();
    		if(r1.getState())
    			gender=r1.getLabel();
    		if(r2.getState())
    			gender=r2.getLabel();
    		qualification =ch8.getSelectedItem();
    		age=tf7.getText();
    		
    		try
    		{
    			Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","1234");  
				st=con.createStatement();
				System.out.println("Databse Conneccted ");
				st.executeUpdate("insert into authorities( name, degisnation, contact_no, office_add, working_hr, email, gender,age) values('"+name+"','"+degis+"','"+cont+"','"+office+"','"+working+"','"+email+"','"+gender+"','"+age+"')");
				
				System.out.println("Database Inserted Successfully ");
			}
			catch(Exception e) {}
			
		}
    	
    	if(ae.getSource()==b2)
    	{
    		tf1.setText("");
    		tf2.setText("");
    		tf3.setText("");
    		tf4.setText("");
    		tf5.setText("");
    		tf6.setText("");
    		tf7.setText("");
    		ch8.select(0);
    		
    		
    	}
    	
    }
    		
    		
   

    public static void main(String[] args)
    {
        new authorities();
    }    
}