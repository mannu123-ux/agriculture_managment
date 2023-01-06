package agriculture;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class table2 extends Frame
{
	JTable j;
	ResultSet rs=null;
	String[][] data = new String[100][100];
	int i=0;
	table2()
	{
		addWindowListener (new WindowAdapter() {    
		 public void windowClosing (WindowEvent e) {    
			 dispose();    
		    }    
		 });    
			   
		setLocation(200,50);
    	setResizable(false);
    	setBackground(new Color(255,192,203));
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/myproject";
		String usr="root";
		String psw="1234";
		Connection con=DriverManager.getConnection(url,usr,psw);
		System.out.println("Connection Successfully ");
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from  insurance");
		while(rs.next())
		{
				data[i][0] = rs.getString("id");
				data[i][1] = rs.getString("farmer_name");
				data[i][2] = rs.getString("insurance_type");
				data[i][3] = rs.getString("insurance_form");
				data[i][4] = rs.getString("price");
				data[i][5] = rs.getString("start_date");
				data[i][6] = rs.getString("end_date");
				i++;
		}
	}
		catch(Exception e) {}
	
		
		

		String[] columnNames = { "ID", "Farmer Name", "Insurance Type","Insurance Firm","Price","Start Date","End Date"};

		j = new JTable(data, columnNames);
		//j.setBounds(30, 100, 200, 300);
		//j.setEnabled(false);
		JScrollPane sp = new JScrollPane(j);
		sp.setBounds(90,80,700,500);
		
		add(sp);
		setSize(1000,650);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new table2();
	}			
}
