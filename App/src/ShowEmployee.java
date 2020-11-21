
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ShowEmployee extends JFrame {
ShowEmployee()
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
		  String query = "select * from Employee"; 
	      PreparedStatement prep_stmt;
	      prep_stmt=conn.prepareStatement(query);
	      ResultSet rs=prep_stmt.executeQuery();
	      int cols=rs.getMetaData().getColumnCount();
  	
  		Object [] [] data= new Object[50][50];
  	 	int i=0;
	    	 	while(rs.next())
	    	 	{
	    	 		data[i][0]=rs.getString("name");
	    	 		data[i][1]=rs.getString("address");
	    	 		data[i][2]=rs.getString("contactno");
	    	 		data[i][3]=rs.getString("gender");
	    	 		data[i][4]=rs.getString("salary");
	    	 		data[i][5]=rs.getString("DOB");
	    	 		i++;
	    	 	}
	      conn.close();
	      setLayout(new BorderLayout());
	    	String[] colHeads={"Name","Address","ContactNo","Gender","Salary","DOB"};

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