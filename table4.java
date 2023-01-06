package agriculture;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class table4  extends Frame implements ItemListener
{

    JTable j;
    JScrollPane sp;
    Choice ch1,ch2,ch3,ch4;
	Label l1,l2,l3,l4,l5;
    ResultSet rs=null;
    String[][] data = new String[100][100];
    int i=0;
   
    table4()
    {
    		addWindowListener (new WindowAdapter() {    
    		public void windowClosing (WindowEvent e) {    
    			 dispose();   
	    }    
	 });    
		  
    		setLocation(200,50);
        	setResizable(false);
        	setBackground(new Color(216,191,216));
    try
    {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/myproject";
	String usr="root";
	String psw="1234";
	Connection con=DriverManager.getConnection(url,usr,psw);
	System.out.println("Connection Successfully ");
	Statement st=con.createStatement();
	rs=st.executeQuery("select * from  farmer_registration");
	while(rs.next())
	{
		data[i][0]=rs.getString("fid");
		data[i][1]=rs.getString("fname");
		data[i][2]=rs.getString("cows");
		data[i][3]=rs.getString("buffalo");
		data[i][4]=rs.getString("bell");
		data[i][5]=rs.getString("goat");
		i++;
	}
    }
	catch (Exception e) {}
	String[] columnNames= {"ID","Name","Cows","buffalo","Bell","Goat"};
	j = new JTable(data, columnNames);
	//j.setBounds(30, 40, 200, 300);

	 sp = new JScrollPane(j);
	sp.setBounds(50,120,800,500);
	add(sp);
	 l4=new Label("Filter");
	 Font f1=new Font("serif",Font.BOLD,30);
     l4.setFont(f1);
	 l4.setBounds(50,30,80,30);
	 add(l4);
	 
	 l1=new Label("Cows");
	 Font f2=new Font("serif",Font.BOLD,20);
	 l1.setFont(f2);
	 l1.setBounds(50,80,60,30);
	 add(l1);
	 ch1=new Choice();
     ch1.add("select");
     ch1.addItemListener(this);
     ch1.setBounds(130,80,100,30);
     add(ch1);
     
     try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/myproject";
			String usr="root";
			String psw="1234";
			Connection con=DriverManager.getConnection(url,usr,psw);
			System.out.println("Connection Successfully ");
			Statement st=con.createStatement();
			rs=st.executeQuery("select * from  farmer_registration group by cows order by cows  asc");
			while(rs.next())
			{
				ch1.add(rs.getString("cows"));
			}
			con.close();
		}
	 catch (Exception e) {}


     
     
     l2=new Label("Buffalo");
     Font f3=new Font("serif",Font.BOLD,20);
     l2.setBounds(260,80,70,30);
	 l2.setFont(f3);
	 add(l2);
	 ch2=new Choice();
     ch2.add("select");
     ch2.addItemListener(this);
     ch2.setBounds(340,80,100,30);
     add(ch2);
     
     try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/myproject";
			String usr="root";
			String psw="1234";
			Connection con=DriverManager.getConnection(url,usr,psw);
			System.out.println("Connection Successfully ");
			Statement st=con.createStatement();
			rs=st.executeQuery("select * from  farmer_registration group by buffalo order by buffalo asc");
			while(rs.next())
			{
				ch2.add(rs.getString("buffalo"));
			}
			con.close();
		}
	 catch (Exception e) {}

     
     l3=new Label("bell");
     Font f4=new Font("serif",Font.BOLD,20);
	 l3.setFont(f4);
     l3.setBounds(470,80,40,30);
     add(l3);
	 ch3=new Choice();
     ch3.add("select");
     ch3.addItemListener(this);
     ch3.setBounds(530,80,100,30);
     add(ch3);
     
     try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/myproject";
			String usr="root";
			String psw="1234";
			Connection con=DriverManager.getConnection(url,usr,psw);
			System.out.println("Connection Successfully ");
			Statement st=con.createStatement();
			rs=st.executeQuery("select * from  farmer_registration group by bell order by bell asc");
			while(rs.next())
			{
				ch3.add(rs.getString("bell"));
			}
			con.close();
		}
	 catch (Exception e) {}

     
     
     l5=new Label("Goat");
     Font f5=new Font("serif",Font.BOLD,20);
	 l5.setFont(f5);
     l5.setBounds(660,80,50,30);
     add(l5);
	 ch4=new Choice();
     ch4.add("select");
     ch4.addItemListener(this);
     ch4.setBounds(730,80,100,30);
     add(ch4);
     
     try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/myproject";
			String usr="root";
			String psw="1234";
			Connection con=DriverManager.getConnection(url,usr,psw);
			System.out.println("Connection Successfully ");
			Statement st=con.createStatement();
			rs=st.executeQuery("select * from  farmer_registration group by goat order by goat asc");
			while(rs.next())
			{
				ch4.add(rs.getString("goat"));
			}
			con.close();
		}
	 catch (Exception e) {}

  
     
     
	setSize(900,650);
	setLayout(null);
	setVisible(true);
}
    
    public void itemStateChanged(ItemEvent ie)
	{
		String data1[][]=new String[100][100];
		
		//Cows
		 if(ie.getSource()==ch1)
		 {
			 //System.out.println("Function called ");
			 try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/myproject";
					String usr="root";
					String psw="1234";
					Connection con=DriverManager.getConnection(url,usr,psw);
					System.out.println("Connection Successfully ");
					Statement st=con.createStatement();
					rs=st.executeQuery("select * from  farmer_registration where cows="+ch1.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("cows");
						data1[i][3]=rs.getString("buffalo");
						data1[i][4]=rs.getString("bell");
						data1[i][5]=rs.getString("goat");
						
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames= {"ID","Name","Cows","buffalo","Bell","Goat"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(50,120,800,500);
				add(sp);
		 }
		 
		 //buffalo
		 if(ie.getSource()==ch2)
		 {
			 //System.out.println("Function called ");
			 try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/myproject";
					String usr="root";
					String psw="1234";
					Connection con=DriverManager.getConnection(url,usr,psw);
					System.out.println("Connection Successfully ");
					Statement st=con.createStatement();
					rs=st.executeQuery("select * from  farmer_registration where buffalo="+ch2.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("cows");
						data1[i][3]=rs.getString("buffalo");
						data1[i][4]=rs.getString("bell");
						data1[i][5]=rs.getString("goat");
						
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames= {"ID","Name","Cows","buffalo","Bell","Goat"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(50,120,800,500);
				add(sp);
		 }
		 
		 //bell
		 if(ie.getSource()==ch3)
		 {
			 //System.out.println("Function called ");
			 try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/myproject";
					String usr="root";
					String psw="1234";
					Connection con=DriverManager.getConnection(url,usr,psw);
					System.out.println("Connection Successfully ");
					Statement st=con.createStatement();
					rs=st.executeQuery("select * from  farmer_registration where bell="+ch3.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("cows");
						data1[i][3]=rs.getString("buffalo");
						data1[i][4]=rs.getString("bell");
						data1[i][5]=rs.getString("goat");
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames=  {"ID","Name","Cows","buffalo","Bell","Goat"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(50,120,800,500);
				add(sp);
		 }
		 
		 //Goat
		 if(ie.getSource()==ch4)
		 {
			 //System.out.println("Function called ");
			 try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/myproject";
					String usr="root";
					String psw="1234";
					Connection con=DriverManager.getConnection(url,usr,psw);
					System.out.println("Connection Successfully ");
					Statement st=con.createStatement();
					rs=st.executeQuery("select * from  farmer_registration where goat="+ch4.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("cows");
						data1[i][3]=rs.getString("buffalo");
						data1[i][4]=rs.getString("bell");
						data1[i][5]=rs.getString("goat");
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames=  {"ID","Name","Cows","buffalo","Bell","Goat"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(50,120,800,500);
				add(sp);
		 }
	}

	public static void main(String[] args)
	{
	new table4();
	}			
}
