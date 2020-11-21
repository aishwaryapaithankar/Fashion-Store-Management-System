
import java.awt.BorderLayout;
import java.sql.*;

import javax.swing.*;

public class ListStock extends JFrame
{
 ListStock()
 {
	final String DB_URL="jdbc:mysql://localhost:3306/FashionStore";
	final String driver="com.mysql.jdbc.Driver";
	final String USER="root";
	final String PASS="Root@123";
	Connection conn;
	Statement stmt;
	try
	{
		  Class.forName(driver);
		  conn=DriverManager.getConnection(DB_URL,USER,PASS);
		  stmt=conn.createStatement();
		  String query = "select * from Stock"; 
	      PreparedStatement prep_stmt;
	      prep_stmt=conn.prepareStatement(query);
	      ResultSet rs=prep_stmt.executeQuery();
	      int cols=rs.getMetaData().getColumnCount();
  	
  		Object [] [] data= new Object[50][50];
  	 	int i=0;
	    	 	while(rs.next())
	    	 	{
	    	 		data[i][0]=rs.getString("name");
	    	 		data[i][1]=rs.getString("price");
	    	 		data[i][2]=rs.getString("qty");
	    	 		data[i][3]=rs.getString("style");
	    	 		data[i][4]=rs.getString("category");
	    	 		i++;
	    	 	}
	      conn.close();
	      setLayout(new BorderLayout());
	    	String[] colHeads={"Name","Price","Quantity","Style","Category"};

	    	JTable table=new JTable(data,colHeads);
	    	int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	    	JScrollPane sp=new JScrollPane(table,v,h);
	    	add(sp,BorderLayout.CENTER);
	    	setSize(800,500);
	    	setVisible(true);
	    	setResizable(false);
	}
	catch(Exception e1)
	{
		System.out.println(e1);
	}
}
}