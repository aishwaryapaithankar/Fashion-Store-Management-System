import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Bill {
static int temp;
Bill()
{
	
	
}
public static void main(String args[])
{
	JFrame f1=new JFrame();
	f1.setBounds(00,00,100,100);
	f1.setLayout(null);
	JLabel label=new JLabel("");
	label.setFont(new Font("Century Gothic", Font.BOLD,50));
	label.setBounds(00,20,700,70);
	f1.add(label);
	JButton button1=new JButton("Calculate Total");
	JButton button2=new JButton("Find Qty");
	JButton button3=new JButton("Add to Bill");
	JButton button4=new JButton("Clear Bill");
	JLabel label1=new JLabel("Select categary");
	JLabel label2=new JLabel("Select Style");
	JLabel label3=new JLabel("Name");
	JLabel label4=new JLabel("Quantity to Sell");
	JLabel label5=new JLabel("Total Quantity in Stock");
	JLabel label6=new JLabel("Price per Item");
	label1.setBounds(10, 50, 150, 100);
	label2.setBounds(10, 90, 150, 100);
	label3.setBounds(10, 140, 150, 100);
	label4.setBounds(10, 190, 150, 100);
	label5.setBounds(400, 50, 250, 100);
	label6.setBounds(400, 100, 150, 100);
	String[] options = new String[] {"Clothing","Footwear","Accessories"};
	String[] options1 = new String[] {"Tops","Bottomwear","Ethnic","Sportswear"};
	String[] options2 = new String[] {"Heels","Casual Shoes & Flats","Sports Shoes"};
	String[] options3 = new String[] {"Scarves","Caps/Hats","Hair Accessories"};
	JComboBox cb = new JComboBox(options);
	JComboBox<String> cb1 = new JComboBox();
	JTextField text1=new JTextField();
	JTextField text2=new JTextField();
	JTextField text3=new JTextField();
	JTextField text4=new JTextField();
	text1.setBounds(200,180,150,30);
	text2.setBounds(200,220,150,30);
	text3.setBounds(570,90,150,30);
	text4.setBounds(570,140,150,30);
	cb.setBounds(200,90,150,30);
	cb1.setBounds(200,130,150,30);
	button1.setBounds(400,200,150,20);
	button2.setBounds(600,200,150,20);
	button3.setBounds(400,250,150,20);
	button4.setBounds(600,250,150,20);
	f1.add(cb);
	f1.add(cb1);
	f1.add(text1);
	f1.add(text2);
	f1.add(text3);
	f1.add(text4);
	f1.add(label1);
	f1.add(label2);
	f1.add(label3);
	f1.add(label4);
	f1.add(label5);
	f1.add(label6);
	f1.add(button1);
	f1.add(button2);
	f1.add(button3);
	f1.add(button4);
	text3.setText(String.valueOf(0));
	text4.setText(String.valueOf(0));
	cb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if(cb.getSelectedItem().toString().equals("Clothing"))
			{
				cb1.removeAllItems();
				cb1.addItem("Tops");
				cb1.addItem("Bottomwear");
				cb1.addItem("Ethnic");
			}
			if(cb.getSelectedItem().toString().equals("Footwear"))
			{
				cb1.removeAllItems();
				cb1.addItem("Heels");
				cb1.addItem("Flats");
				cb1.addItem("Shoes");	
			}
			if(cb.getSelectedItem().toString().equals("Accessories"))
			{
				cb1.removeAllItems();
				cb1.addItem("Scarves");
				cb1.addItem("Caps/Hats");
				cb1.addItem("Hair Accessories");		
				
			}
			
		}});
	button2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Find Qty")) 
			{
				String cat=(String)cb.getSelectedItem();
				String style=(String)cb1.getSelectedItem();
				String name=(String)text1.getText();
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
					  String query = "select * from Stock where name = ?"; 
				      PreparedStatement prep_stmt;
					  prep_stmt=conn.prepareStatement(query);
				      prep_stmt.setString(1, name);
				      ResultSet rs=prep_stmt.executeQuery();
				      int price = 0,qty=0;
				     while(rs.next())
				    	 {
				    	 	 price=rs.getInt("price");
				    	 	 qty=rs.getInt("qty");
				    	 }
				     text4.setText(String.valueOf(price));
				     text3.setText(String.valueOf(qty));
				      conn.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}	
				
		}});
	button3.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Add to Bill")) 
			{
				int qtysell=Integer.parseInt(text2.getText());
				int qty=Integer.parseInt(text3.getText());
				if(qtysell>qty)
				{
					JOptionPane.showMessageDialog(f1,"Please Enter valid Quantity");
				}
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
					  String name=text1.getText();
					  String category=(String)cb.getSelectedItem();
					  String style=(String)cb1.getSelectedItem();
					  int price=Integer.parseInt(text4.getText());
					  int newprice=price*qtysell;
					  String query = "insert into Bill(name,qty,price,category,style)"+" values (?,?,?,?,?)";
				      PreparedStatement prep_stmt;
					  prep_stmt=conn.prepareStatement(query);
					  prep_stmt.setString(1, name);
					  prep_stmt.setInt(2, qtysell);
					  prep_stmt.setInt(3, newprice);
					  prep_stmt.setString(4, category);
					  prep_stmt.setString(5, style);
					  prep_stmt.execute();
					  String query1 = "update Stock set qty=?  where name =?";
					  temp=qty-qtysell;
					  PreparedStatement prep_stmt1;
					  prep_stmt1=conn.prepareStatement(query1);
					  prep_stmt1.setString(2, name);
					  prep_stmt1.setInt(1, temp);
					  prep_stmt1.executeUpdate();
				      conn.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}	
				
		}});
	 JTable table=new JTable();
     table.setBounds(50,300,700,300);
     JLabel total=new JLabel("Total Bill");
     JTextField text5=new JTextField();
     JButton button=new JButton("Print Bill");
     total.setBounds(150,600,100,100);
     text5.setBounds(250,640,100,30);
     button.setBounds(450,640,100,30);
     f1.add(total);
     f1.add(table);
     f1.add(text5);
     f1.add(button);
	button.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Print Bill")) 
			{
			
				final String DB_URL="jdbc:mysql://localhost:3306/FashionStore";
				final String driver="com.mysql.jdbc.Driver";
				final String USER="root";
				final String PASS="Root@123";
				Connection conn;
				Statement stmt;
				try
				{
						new PDF();
					Class.forName(driver);
					  conn=DriverManager.getConnection(DB_URL,USER,PASS);
					  stmt=conn.createStatement();
					  String query = "delete  from Bill";
				      PreparedStatement prep_stmt;
					  prep_stmt=conn.prepareStatement(query);
					  //prep_stmt.execute();
				      conn.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}	
				
		}});
	
	button1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Calculate Total")) 
			{
			
				final String DB_URL="jdbc:mysql://localhost:3306/FashionStore";
				final String driver="com.mysql.jdbc.Driver";
				final String USER="root";
				final String PASS="Root@123";
				Connection conn;
				Statement stmt;
				
				try
				{
						String t="";
					  Class.forName(driver);
					  conn=DriverManager.getConnection(DB_URL,USER,PASS);
					  stmt=conn.createStatement();
					  String query = "select sum(price) from Bill";
				      PreparedStatement prep_stmt;
					  prep_stmt=conn.prepareStatement(query);
					  ResultSet rs=prep_stmt.executeQuery();
					  while(rs.next()){
					  t=rs.getString(1);
					  }
					  text5.setText(t);
				      conn.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}	
				
		}});
	f1.setBackground(Color.white);
//	JLabel mainlabel=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/bg5.jpg"));
	//  mainlabel.setBounds(00,00,800,500);
	  //   f1.add(mainlabel);
	     f1.setResizable(false);
	     
	     //--------------------------------------------------------------/
	    
	f1.setVisible(true);
	f1.setSize(1000,800);
	f1.setDefaultCloseOperation(f1.HIDE_ON_CLOSE);
}
}