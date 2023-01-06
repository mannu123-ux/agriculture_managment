package agriculture;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insurance extends Frame implements ActionListener,ItemListener{
    
	Label l1,l2,l3,l4,l5,l6,l7,l8;
    TextField tf1,tf2,tf3,tf4,tf5,tf6;
    Checkbox c1,c2,c3;
    CheckboxGroup cbg;
    Button b1,b2,b4;
    Choice ch1,ch2,ch3;
   
    Connection con=null;
	Statement st=null;
	String name,radio,amt,sdate,edate,edu;
	
	
    Insurance()
    {
    	addWindowListener(new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
            	 dispose();    
            }    
        });  
    	setLocation(270,50);
    	setResizable(false);
    	 setBackground(new Color(152,251,152));
    	try
    	{
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ myproject","root","1234");  
		Statement st=con.createStatement();
		System.out.println("Databse Conneccted ");
		ResultSet rs=st.executeQuery("select * from farmer_registration");
		ch2=new Choice();
		ch3=new Choice();
		while(rs.next())
        {
        	ch2.add(rs.getString("fid"));
        	ch3.add(rs.getString("fname"));
        }
    	}
		catch (Exception e) {}
    	
		l1 = new Label("INSURANCE",Label.CENTER);
		l1.setBounds(0,30,800,40);
        l1.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(50,205,50));
        Font f1=new Font("serif",Font.BOLD,25);
        l1.setFont(f1);
        add(l1);

        l8=new Label("Farmer Id");
        l8.setForeground(new Color(240,248,255));
        l8.setBounds(220,100,150,30);
        add(l8);
       // ch2=new Choice();
        Font f2=new Font("serif",Font.BOLD,20);
        l8.setFont(f2);
        ch2.addItemListener(this);
        ch2.setBackground(new Color(211,211,211));
        ch2.setBounds(420,100,150,30);
        add(ch2);
        
        l2=new Label("Farmer Name : ");
        l2.setForeground(new Color(240,248,255));
        l2.setFont(f2);
        l2.setBounds(220,150,150,30);
        add(l2);
        //ch3=new Choice();
        ch3.setBackground(new Color(211,211,211));
      //  ch3.setBorder(new LineBorder(Color.red,1));
        ch3.setBounds(420,150,150,30);
        add(ch3);

        l3=new Label("Insurance Type : ");
        l3.setForeground(new Color(240,248,255));
        l3.setFont(f2);
        l3.setBounds(220,200,150,30);
        add(l3);
        cbg=new CheckboxGroup();
        c1=new Checkbox("individual",false,cbg);
        c1.setFont(f2);
        //c1.setForeground(new Color(211,211,211));
        
        c1.setBounds(420,200,100,30);
        c2=new Checkbox("crop",false,cbg);
        c2.setFont(f2);
       // c2.setForeground(new Color(211,211,211));
        c2.setBounds(530,200,60,30);
        c3=new Checkbox("land",false,cbg);
        c3.setFont(f2);
       // c3.setForeground(new Color(211,211,211));
        c3.setBounds(600,200,60,30);
        add(c1);
        add(c2);
        add(c3);

        

        l4=new Label("Price / Amount : ");
        l4.setFont(f2);
        l4.setForeground(new Color(240,248,255));
        l4.setBounds(220,250,150,30);
        add(l4);
        tf2=new TextField(20);
        tf2.setBackground(new Color(211,211,211));
        tf2.setBounds(420,250,150,30);
        add(tf2);

        l5=new Label("Star Date  : ");
        l5.setFont(f2);
        l5.setForeground(new Color(240,248,255));
        l5.setBounds(220,300,150,30);
        add(l5);
        tf3=new TextField(20);
        tf3.setBackground(new Color(211,211,211));
        tf3.setBounds(420,300,150,30);
        add(tf3);

        l6=new Label("Star Date  : ");
        l6.setFont(f2);
        l6.setForeground(new Color(240,248,255));
        l6.setBounds(220,350,150,30);
        add(l6);
        tf4=new TextField(20);
        tf4.setBackground(new Color(211,211,211));
        tf4.setBounds(420,350,150,30);
        add(tf4);

        l7=new Label("Insurance Firm : ");
        l7.setFont(f2);
        l7.setForeground(new Color(240,248,255));
        l7.setBounds(220,400,150,30);
        add(l7);
        ch1=new Choice();
        ch1.setBackground(new Color(211,211,211));
        ch1.add("Select");
		ch1.add("SBI");
		ch1.add("BOB");
		ch1.add("HDFC");
		ch1.add("PNP");
        ch1.setBounds(420,400,150,30);
        add(ch1);


        b1=new Button("Submit");
        b1.setFont(f2);
        b1.setForeground(new Color(0,0,0));
        b1.setBounds(300,470,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new Button("Reset");
        b2.setFont(f2);
        b2.setForeground(new Color(0,0,0));
        b2.setBounds(450,470,100,30);
        b2.addActionListener(this);
        add(b2);
        setSize(800,600);
        setLayout(null);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent ie)
    {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String url="jdbc:mysql://localhost:3306/myproject";
    		String usr="root";
    		String psw="1234";
    		Connection con=DriverManager.getConnection(url,usr,psw);
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("select *from farmer_registration where fid="+ch2.getSelectedItem());
    		
    		if(rs.next())
    		{
	            ch3.select(rs.getString("fname"));
    	    }
    	}
    	catch(Exception e) {}
    	
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	{
    		name=ch3.getSelectedItem();
			int fid = Integer.parseInt(ch2.getSelectedItem());
			
    		if(c1.getState())
				radio=c1.getLabel();
			else if(c2.getState())
				radio=c2.getLabel();
			else if(c3.getState())
				radio=c3.getLabel();
	
			amt=tf2.getText();
			sdate=tf3.getText();
			edate=tf4.getText();
			edu=ch1.getSelectedItem();
    		
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ myproject","root","1234");  
				st=con.createStatement();
				System.out.println("Databse Conneccted ");
				st.executeUpdate("insert into insurance(farmer_name,insurance_form,price,start_date,end_date,insurance_type,farmer_id) values('"+name+"','"+radio+"','"+amt+"','"+sdate+"','"+edate+"','"+edu+"',"+fid+")");
				System.out.println("Database Inserted Successfully ");
			}
			catch(Exception e) {}
			
		}
    	if(ae.getSource()==b2)
    	{
    		ch2.select(0);
    		ch1.select(0);
            tf2.setText("");
            ch3.select(0);
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
           
    	}
    }

    public static void main(String[] args)
    {
        new Insurance();
    }
    
}