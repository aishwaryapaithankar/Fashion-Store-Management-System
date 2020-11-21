import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class PDF {
	String t;
  PDF()
 {
	 
	 JFrame f1=new JFrame();
	 f1.setSize(500,500);
	 f1.setResizable(false);
	 f1.setVisible(true);
		f1.setLayout(null);
	 JLabel label=new JLabel("ADD Customer Info");
		label.setFont(new java.awt.Font("Century Gothic", Font.BOLD,30));
		label.setBounds(00,20,700,70);
		f1.add(label);
		JLabel label1=new JLabel("Name");
		JLabel label2=new JLabel("Address");
		JLabel label3=new JLabel("Contact Number");
		JTextField text1=new JTextField();
		JTextArea text2=new JTextArea();
		JTextField text3=new JTextField();
		JButton button1=new JButton("OK");
		label1.setBounds(10, 50, 150, 100);
		label2.setBounds(10, 90, 150, 100);
		label3.setBounds(10,160,150,100);
		text1.setBounds(200,90,150,30);
		text2.setBounds(200,130,150,30);
		text3.setBounds(200,200,150,30);
		button1.setBounds(100,370,100,30);
		f1.add(label1);
		f1.add(label2);
		f1.add(label3);
		f1.add(text1);
		f1.add(text2);
		f1.add(text3);
		f1.add(button1);
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("OK")) 
				{
				 String name=(String)text1.getText();
				 String address=(String)text2.getText();;
				 String contactno=(String)text3.getText();
				 Document document=new Document();
				 try{
					 
					 
				 Date date = new Date();
				// PdfWriter.getInstance(document,new FileOutputStream("/home/ccoew/workspace/P/bills/Bill "+date.toString()));
				 PdfWriter.getInstance(document,new FileOutputStream("Bill"));
				 document.open();
				
				 Image img = Image.getInstance("/home/ccoew/workspace/P/src/logo.png");
			     img.setAlignment(Image.MIDDLE);
			     img.scaleAbsoluteHeight(20);
				 img.scaleAbsoluteWidth(20);
				 img.scalePercent(100);
			     document.add(img);
			     Rectangle one = new Rectangle(200,200);
			     document.setPageSize(one);
			     Paragraph p= new Paragraph();
				 p.setAlignment(Paragraph.ALIGN_LEFT);
				 p.setFont(new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN,20,Font.NORMAL,new BaseColor(0,0,0)));
				 p.add("\n\nBILL DETAILS:\n\n");
				 Paragraph p1= new Paragraph();
				 p1.setAlignment(Paragraph.ALIGN_LEFT);
				 p1.setFont(new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN,20,Font.NORMAL,new BaseColor(0,0,0)));
				 p1.add("\nCUSTOMER DETAILS:\n");
				 p1.setFont(new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,new BaseColor(0,0,0)));
				 p1.add("\nName:"+name+"\nAddress:"+address+"\nContact no:"+contactno);
				 
				 PdfPTable table=new PdfPTable(3);
				 table.addCell("Name");
				 table.addCell("Price");
				 table.addCell("Quantity");
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
						  String query = "select * from Bill"; 
					      PreparedStatement prep_stmt;
					      prep_stmt=conn.prepareStatement(query);
					      ResultSet rs=prep_stmt.executeQuery();
					    	 	while(rs.next())
					    	 	{
					    	 		table.addCell(rs.getString("name"));
									 table.addCell(rs.getString("price"));
									 table.addCell(rs.getString("qty"));
					    	 	}
					    	 	document.add(p1);
								 document.add(p);
								 document.add(table);
					    	 	  String query1 = "select sum(price) from Bill";
							      PreparedStatement prep_stmt1;
								  prep_stmt=conn.prepareStatement(query1);
								  ResultSet rs1=prep_stmt.executeQuery();
								  Paragraph p2= new Paragraph();
									 p2.setAlignment(Paragraph.ALIGN_LEFT);
									 p2.setFont(new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN,20,Font.NORMAL,new BaseColor(0,0,0)));
								  while(rs1.next()){
									  String t=rs1.getString(1);
									  
										 
										 p2.add("\n\nTOTAL BILL AMOUNT:"+t+"\n\n");
										 
								  }
								  p2.setFont(new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,new BaseColor(0,0,0)));
									 p2.setAlignment(Paragraph.ALIGN_CENTER);
									 p2.add("THANK YOU FOR SHOPPING WITH US!! PLEASE VISIT AGAIN !! :)");
									 document.add(p2);
					      conn.close();
					}
					catch(Exception e1)
					{
						e1.getStackTrace();
					}
					
					
				 
				
				 document.close();
				 f1.hide();
				 }
				 catch(Exception e1)
				 {
					 e1.printStackTrace();
				 }
				}
			}
		});
	
 }
}
