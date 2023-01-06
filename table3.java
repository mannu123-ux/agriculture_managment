package agriculture;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class table3 extends Frame
{
	JTable j;
	ResultSet rs=null;
	String [][] data=new String[100][100];
	int i=0;
	table3()
	{
		addWindowListener (new WindowAdapter() {    
			 public void windowClosing (WindowEvent e) {    
				 dispose();   
			    }    
			 });    
		setLocation(200,50);
    	setResizable(false);
    	setBackground(new Color(152,251,152));
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/myproject";
		String usr="root";
		String psw="1234";
		Connection con=DriverManager.getConnection(url,usr,psw);
		System.out.println("Connection Successfully ");
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from authorities");
		while(rs.next())
		{
			data[i][0]=rs.getString("Aid");
			data[i][1]=rs.getString("name");
			data[i][2]=rs.getString("degisnation");
			data[i][3]=rs.getString("contact_no");
			data[i][4]=rs.getString("office_add");
			data[i][5]=rs.getString("working_hr");
			data[i][6]=rs.getString("email");
			data[i][7]=rs.getString("gender");
			data[i][8]=rs.getString("age");
			i++;
		}
	
}
	catch(Exception e) {}
	
	String[] columnNames = {"ID","Name","Degisnation","Contact_no","Office_add","Working_hr","Email","Gender","Age"};
	j = new JTable(data, columnNames);
	//j.setBounds(30, 40, 200, 300);

	JScrollPane sp = new JScrollPane(j);
	
	 add(sp);
	setSize(800,600);
	setLayout(new FlowLayout(FlowLayout.CENTER));
	setVisible(true);
}
	public static void main(String[] args)
	{
	new table3();
	}			
}

