import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
public class Module {
	protected static JFrame f;
	private JLabel mainlabel=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/bg3.jpg"));
	Module()
	{
		JMenu menu1, menu,menu2,menu3,menu4;  
     JMenuItem i1, i2, i3, i4, i5;  
    f= new JFrame("Classy Missy");  
     mainlabel.setBounds(0,0,1800,800);
     f.add(mainlabel);
     JMenuBar mb=new JMenuBar();  
     menu = new JMenu("Home");
     JMenuItem j1,j2;
     j1=new JMenuItem("Sign Out");
     j2=new JMenuItem("Exit");
     menu1=new JMenu("Empolyee");  
     i1=new JMenuItem("Add new Employee");  
     i2=new JMenuItem("Update Employee Info");  
     i3=new JMenuItem("Show Employees");  
     menu1.add(i1); menu1.add(i2); menu1.add(i3); 
   
     menu3=new JMenu("Stocks");
     JMenuItem l1,l2,l3,l4;
     l1=new JMenuItem("Add New Stock Info");  
     l2=new JMenuItem("Clear Stock");  
     l3=new JMenuItem("Update Stock Info");  
     l4=new JMenuItem("List Of Stock"); 
     menu4=new JMenu("Bill");
    JMenuItem g1=new JMenuItem("Generate Bill");
     menu.add(j1);menu.add(j2);
     menu1.add(i1); menu1.add(i2); menu1.add(i3); 
     menu3.add(l1);menu3.add(l2);menu3.add(l3);menu3.add(l4);
     menu4.add(g1);
     mb.add(menu);
     mb.add(menu1);  
     mb.add(menu3);
     mb.add(menu4);
     f.setJMenuBar(mb);  
     f.setSize(1880,800); 
     j1.addActionListener(new MenuListener());
     j2.addActionListener(new MenuListener());
     i1.addActionListener(new MenuListener() );
     i2.addActionListener(new MenuListener() );
     i3.addActionListener(new MenuListener() );
     l1.addActionListener(new MenuListener() );
     l2.addActionListener(new MenuListener() );
     l3.addActionListener(new MenuListener() );
     l4.addActionListener(new MenuListener());
     g1.addActionListener(new MenuListener());
     Image icon = Toolkit.getDefaultToolkit().getImage("/home/ccoew/workspace/FashionStore/images/icon.jpg");
     f.setIconImage(icon);
     f.setLayout(null);  
     f.setVisible(true);  
     }
	public static void main(String args[])
	{
		new Module();
	}
}
class MenuListener  implements ActionListener {
	  MenuListener() {
	  }

	  public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("Add new Employee")) {
	    		new AddNewEmployee();
	    }
	    else if (e.getActionCommand().equals("Update Employee Info")) {
	    	new UpdateEmployee();
	    }
	    else if (e.getActionCommand().equals("Show Employees")) 
	    {
	    	new ShowEmployee();
	   
	    }
	  
	    else if (e.getActionCommand().equals("Add New Stock Info")) {
	    	new AddStock();
	    }
 else if (e.getActionCommand().equals("Clear Stock")) {
	new ClearStock();
	    }
 else if (e.getActionCommand().equals("Update Stock Info")) {
	new UpdateStock();
 }
 else if (e.getActionCommand().equals("List Of Stock")) {
	new ListStock();
 }
 else if (e.getActionCommand().equals("Generate Bill")) {
	 new Bill();
	 
 }
	    else if (e.getActionCommand().equals("Sign Out")) {
    		Module.f.setVisible(false);
    		new Login();
	    }
	    else   if (e.getActionCommand().equals("Exit")) {
    		System.exit(0);
	    }
	  }
	}
	      