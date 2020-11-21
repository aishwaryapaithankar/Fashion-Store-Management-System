import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
public class AddNewEmployee {
AddNewEmployee()
{
	JFrame f1=new JFrame();
	f1.setBounds(00,00,100,100);
	f1.setLayout(null);
	JLabel label=new JLabel("ADD NEW EMPLOYEE");
	label.setFont(new Font("Century Gothic", Font.BOLD,50));
	label.setBounds(00,20,700,70);
	f1.add(label);
	JLabel label1=new JLabel("Name");
	JLabel label2=new JLabel("Address");
	JLabel label3=new JLabel("Contact Number");
	JLabel label4=new JLabel("Gender");
	JLabel label5=new JLabel("Salary");
	JLabel label6=new JLabel("DOB - YYYY-MM-DD");
	JTextField text1=new JTextField();
	JTextArea text2=new JTextArea();
	JTextField text3=new JTextField();
	JRadioButton rb1=new JRadioButton("Male");
	JRadioButton rb2=new JRadioButton("Female");
	JTextField text4=new JTextField();
	JTextField text5=new JTextField();
	JButton button1=new JButton("Add");
	JButton button2=new JButton("Cancell");
	ButtonGroup group = new ButtonGroup();
	group.add(rb1);
	group.add(rb2);
	rb1.setBackground(Color.white);
	rb2.setBackground(Color.white);
	label1.setBounds(10, 50, 150, 100);
	label2.setBounds(10, 90, 150, 100);
	label3.setBounds(10,160,150,100);
	label4.setBounds(10,200,150,100);
	label5.setBounds(10,240,150,100);
	label6.setBounds(10,280,150,100);
	text1.setBounds(200,90,150,30);
	text2.setBounds(200,130,150,30);
	text3.setBounds(200,200,150,30);
	rb1.setBounds(200,240,70,30);
	rb2.setBounds(300,240,150,30);
	text4.setBounds(200,280,150,30);
	text5.setBounds(200,320,150,30);
	button1.setBounds(100,370,100,30);
	button2.setBounds(230,370,100,30);
	f1.add(label1);
	f1.add(label2);
	f1.add(label3);
	f1.add(label4);
	f1.add(label5);
	f1.add(label6);
	f1.add(text1);
	f1.add(text2);
	f1.add(text3);
	f1.add(text4);
	f1.add(text5);
	f1.add(rb1);
	f1.add(rb2);
	f1.add(button1);
	f1.add(button2);
	button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Add")) 
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
						  String query = "insert into Employee(id,name,address,contactno,gender,salary,DOB)"+" values (null,?,?,?,?,?,?)";
						  String name=text1.getText();
						  String address=text2.getText();
						  String contactno=text3.getText();
						  String gender=new String();
						  if(rb1.isSelected())
							  gender="Male";
						  else
							  gender="Female";
						  int salary=Integer.parseInt(text4.getText());
						  String DOB=text5.getText();
					      PreparedStatement prep_stmt;
					      prep_stmt=conn.prepareStatement(query);
					      prep_stmt.setString(1,name);
					      prep_stmt.setString(2,address);
					      prep_stmt.setString(3,contactno);
					      prep_stmt.setString(4,gender);
					      prep_stmt.setInt(5,salary);		
					      prep_stmt.setString(6, DOB);
					      prep_stmt.execute();
					      conn.close();
					      JOptionPane.showMessageDialog(f1,"Employee Added Successfully");
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
				}	
    }});
	button2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Cancell")) 
			{
				f1.setVisible(false);
			}
			}});
	f1.setBackground(Color.white);
	JLabel mainlabel=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/bg4.jpg"));
	  mainlabel.setBounds(00,00,800,500);
	     f1.add(mainlabel);
	     f1.setResizable(false);
	f1.setVisible(true);
	f1.setSize(800,500);

}
}
