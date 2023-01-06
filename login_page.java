package agriculture;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login_page extends Frame implements ActionListener{

    Label l1,l2,l3,l4;
    TextField tf1,tf2;
    Button b1;
    Dialog d1;

    login_page()
    {
    	
    	addWindowListener (new WindowAdapter() {    
			 public void windowClosing (WindowEvent e) {    
				 dispose();   
			    }    
			 });      
    		
    		setLocation(200,50);
        	setResizable(false);
        	setBackground(new Color(224,255,255));
        l1=new Label("Welcome",Label.CENTER);
        l1.setBounds(0,100,700,30);
    
        Font f1=new Font("serif",Font.BOLD,30);
        l1.setFont(f1);
        add(l1);

        b1=new Button("Login");
        b1.addActionListener(this);
        Font f2=new Font("serif",Font.BOLD,20);
        b1.setFont(f2);
        b1.setBounds(250,300,100,30);
        add(b1);

        d1=new Dialog(this);
        d1.setSize(700,700);
        d1.setLayout(null);


       
        
        l3=new Label("User : ");
        l3.setBounds(200,180,100,30);
        l3.setFont(f2);
        add(l3);
        tf1=new TextField(20);
        tf1.setBounds(350,180,150,20);
        add(tf1);
        l4=new Label("Password : ");
        l4.setBounds(200,220,100,20);
        l4.setFont(f2);
        add(l4);
        tf2=new TextField(20);
        tf2.setEchoChar('*');
        tf2.setBounds(350,220,150,20);
        add(tf2);
        


        setSize(700,600);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
    	try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/myproject";
			String usr="root";
			String psw="1234";
			Connection con=DriverManager.getConnection(url,usr,psw);
			System.out.println("Connection Successfully ");
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from login where user='"+tf1.getText()+"' and pass='"+tf2.getText()+"'");
			if(rs.next())
			{
				new Farmer();
				
			}
			else 
				System.out.println("Username & Password Wrong ");
		}
		catch(Exception e) {}
	
		
    }

    public static void main(String[] args)
    {
        new login_page();
    }
}