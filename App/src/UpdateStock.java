import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStock {
	UpdateStock()
	{
		 JFrame f1=new JFrame();
			f1.setBounds(00,00,100,100);
			f1.setLayout(null);
			JLabel label=new JLabel("Update STOCK");
			label.setFont(new Font("Century Gothic", Font.BOLD,50));
			label.setBounds(00,20,700,70);
			f1.add(label);
			JButton button1=new JButton("Update");
			JButton button2=new JButton("Search");
			JLabel label1=new JLabel("Select categary");
			JLabel label2=new JLabel("Select Style");
			JLabel label3=new JLabel("Name");
			JLabel label4=new JLabel("Price");
			JLabel label5=new JLabel("Quantity");
			label1.setBounds(10, 50, 150, 100);
			label2.setBounds(10, 90, 150, 100);
			label3.setBounds(10, 140, 150, 100);
			label4.setBounds(10, 180, 150, 100);
			label5.setBounds(10, 220, 150, 100);
			String[] options = new String[] {"Clothing","Footwear","Accessories"};
			String[] options1 = new String[] {"Tops","Bottomwear","Ethnic","Sportswear"};
			String[] options2 = new String[] {"Heels","Casual Shoes & Flats","Sports Shoes"};
			String[] options3 = new String[] {"Scarves","Caps/Hats","Hair Accessories"};
			JComboBox cb = new JComboBox(options);
			JComboBox<String> cb1 = new JComboBox();
			JTextField text1=new JTextField();
			JTextField text2=new JTextField();
			JTextField text3=new JTextField();
			text1.setBounds(200,180,150,30);
			text2.setBounds(200,220,150,30);
			text3.setBounds(200,260,150,30);
			cb.setBounds(200,90,150,30);
			cb1.setBounds(200,130,150,30);
			button1.setBounds(150,300,100,50);
			f1.add(cb);
			f1.add(cb1);
			f1.add(text1);
			f1.add(text2);
			f1.add(text3);
			f1.add(label1);
			f1.add(label2);
			f1.add(label3);
			f1.add(label4);
			f1.add(label5);
			f1.add(button1);
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
			button1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("Update")) 
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
							  String query = "update Stock set price=? ,qty=? ,style=? ,category=? where name =? ;";
							  int price=Integer.parseInt(text2.getText());
							  int qty=Integer.parseInt(text3.getText());
							  String name=text1.getText();
							  String category=(String)cb.getSelectedItem();
							  String style=(String)cb1.getSelectedItem();
						      PreparedStatement prep_stmt;
						      prep_stmt=conn.prepareStatement(query);
						      prep_stmt.setInt(1, price);
						      prep_stmt.setInt(2, qty);
						      prep_stmt.setString(3, style);
						      prep_stmt.setString(4, category);
						      prep_stmt.setString(5, name);
						   
						      prep_stmt.executeUpdate();
						      conn.close();
						      JOptionPane.showMessageDialog(f1,"Updated Successfully");
						}
						catch(Exception e1)
						{
							System.out.println(e1);
						}
					}	
					}});
			
						f1.setBackground(Color.white);
			JLabel mainlabel=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/bg5.jpg"));
			  mainlabel.setBounds(00,00,800,500);
			     f1.add(mainlabel);
			     f1.setResizable(false);
			f1.setVisible(true);
			f1.setSize(800,500);
	}
}
