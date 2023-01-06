package agriculture;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class table1 extends Frame implements ItemListener
{
	JTable j;
	JScrollPane sp;
	Choice ch1,ch2,ch3;
	Label l1,l2,l3,l4;
	ResultSet rs=null;
	String[][] data=new String[100][100];
	int i=0;
	table1()
	{
	     
		addWindowListener (new WindowAdapter() {    
			 public void windowClosing (WindowEvent e) {    
				 dispose();     
			    }    
			 });   
		setLocation(200,50);
    	setResizable(false);
    	setBackground(new Color(255,218,185));
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
				data[i][2]=rs.getString("adhar");
				data[i][3]=rs.getString("address");
				data[i][4]=rs.getString("contact");
				data[i][5]=rs.getString("land_owns");
				data[i][6]=rs.getString("gender");
				data[i][7]=rs.getString("no_of_member");
				data[i][8]=rs.getString("annual");
				
				i++;
			}
			con.close();
		}
		catch (Exception e) {}
		
		
		
		String[] columnNames= {"ID","Name","Adhar_no","Address","Contact","Land_owns","Gender","no_of_member","Annual_Income"};
		j = new JTable(data, columnNames);
		//j.setBounds(30, 40, 200, 300);
	
		sp = new JScrollPane(j);
		sp.setBounds(70,120,860,500);
		add(sp);
		
		
		l4=new Label("Filter");
		Font f1=new Font("serif",Font.BOLD,30);
        l4.setFont(f1);
		l4.setBounds(50,30,80,30);
		add(l4);
		
		
		l1=new Label("Land Owns");
		Font f2=new Font("serif",Font.BOLD,20);
        l1.setFont(f2);
		l1.setBounds(50,80,100,30);
		add(l1);
		ch1=new Choice();
	    ch1.add("select");
	    ch1.addItemListener(this);
	    ch1.setBounds(170,80,100,30);
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
				rs=st.executeQuery("select * from  farmer_registration group by land_owns order by land_owns  asc");
				while(rs.next())
				{
					ch1.add(rs.getString("Land_owns"));
				}
				con.close();
			}
		 catch (Exception e) {}
	 
	 
		 
		 
	     
		 l2=new Label("Annual Income");
	     l2.setBounds(300,80,150,30);
	     Font f3=new Font("serif",Font.BOLD,20);
	     l2.setFont(f3);
	     add(l2);
		 ch2=new Choice();
	     ch2.add("select");
	     ch2.addItemListener(this);
	     ch2.setBounds(470,80,100,30);
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
				rs=st.executeQuery("select * from  farmer_registration group by annual order by annual asc");
				while(rs.next())
				{
					ch2.add(rs.getString("annual"));
				}
				con.close();
			}
		 catch (Exception e) {}
	 
	
     
     l3=new Label("No. of member");
     l3.setBounds(600,80,150,30);
     Font f4=new Font("serif",Font.BOLD,20);
     l3.setFont(f4);
     add(l3);
	 ch3=new Choice();
     ch3.add("select");
     ch3.addItemListener(this);
     ch3.setBounds(770,80,100,30);
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
			rs=st.executeQuery("select * from  farmer_registration group by no_of_member order by no_of_member asc ");
			while(rs.next())
			{
				ch3.add(rs.getString("no_of_member"));
			}
			con.close();
		}
	 catch (Exception e) {}
    
     
     
     
	setSize(1000,650);
	setLayout(null);
	setVisible(true);
	}

	
	
	public void itemStateChanged(ItemEvent ie)
	{
		String data1[][]=new String[100][100];
		
		//Land_owns
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
					rs=st.executeQuery("select * from  farmer_registration where land_owns="+ch1.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("adhar");
						data1[i][3]=rs.getString("address");
						data1[i][4]=rs.getString("contact");
						data1[i][5]=rs.getString("land_owns");
						data1[i][6]=rs.getString("gender");
						data1[i][7]=rs.getString("no_of_member");
						data1[i][8]=rs.getString("annual");
						
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames= {"ID","Name","Adhar_no","Address","Contact","Land_owns","Gender","no_of_member","Annual_Income"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(70,120,860,500);
				add(sp);
		 }
		 
		 //annual_income
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
					rs=st.executeQuery("select * from  farmer_registration where annual="+ch2.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("adhar");
						data1[i][3]=rs.getString("address");
						data1[i][4]=rs.getString("contact");
						data1[i][5]=rs.getString("land_owns");
						data1[i][6]=rs.getString("gender");
						data1[i][7]=rs.getString("no_of_member");
						data1[i][8]=rs.getString("annual");
						
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames= {"ID","Name","Adhar_no","Address","Contact","Land_owns","Gender","no_of_member","Annual_Income"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(70,120,860,500);
				add(sp);
		 }
		 
		 //no_of_member
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
					rs=st.executeQuery("select * from  farmer_registration where no_of_member="+ch3.getSelectedItem());
					i=0;
					while(rs.next())
					{
						data1[i][0]=rs.getString("fid");
						data1[i][1]=rs.getString("fname");
						data1[i][2]=rs.getString("adhar");
						data1[i][3]=rs.getString("address");
						data1[i][4]=rs.getString("contact");
						data1[i][5]=rs.getString("land_owns");
						data1[i][6]=rs.getString("gender");
						data1[i][7]=rs.getString("no_of_member");
						data1[i][8]=rs.getString("annual");
						
						i++;
					}
					con.close();
				}
				catch (Exception e) {}
			 	String[] columnNames= {"ID","Name","Adhar_no","Address","Contact","Land_owns","Gender","no_of_member","Annual_Income"};
			 	remove(j);
			 	remove(sp);
			 	j = new JTable(data1, columnNames);
			 	j.setEnabled(false);
				sp = new JScrollPane(j);
				sp.setBounds(70,120,860,500);
				add(sp);
		 }
		 
	}

	
	
	public static void main(String[] args)
	{
	new table1();
	}			
}



