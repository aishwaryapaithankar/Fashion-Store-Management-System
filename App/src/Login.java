import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
public class Login {
	private JFrame f = new JFrame("Classy Missy Login");
	ImageIcon img=new ImageIcon("/home/ccoew/3961/FashionStore/logo.png");
	private JLabel mainlabel=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/bg1.jpg"));
	public Login(){
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setIconImage(img.getImage());
		f.setVisible(true);
        f.getContentPane().setBackground( Color.pink );
        mainlabel.setSize(1880,800);
        mainlabel.setBounds(0,0,1880,800);
        f.add(mainlabel);
        JLabel label1=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/logo.png"));
        JLabel label2 =new JLabel("Username:");
        JLabel label3 =new JLabel("Password:");
        final JTextField text1=new JTextField();
        final JPasswordField text2=new JPasswordField();
        JButton button1=new JButton("Login");
        label1.setBounds(500,10,350,400);
        label2.setBounds(400,200,300,300);
        label2.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        label3.setBounds(400,300,300,300);
        label3.setFont(new Font("Century Gothic", Font.PLAIN, 30));
       text1.setBounds(600, 330, 300, 50);
         text2.setBounds(600, 430, 300, 50);
        button1.setBounds(510,550,310,100);
        button1.setIcon(new ImageIcon("/home/ccoew/workspace/FashionStore/images/login.jpg"));
       mainlabel.add(label1);
        mainlabel.add(text1);
       mainlabel.add(text2);
       mainlabel.add(label2);
       mainlabel.add(label3);
       mainlabel.add(button1);
       Image icon = Toolkit.getDefaultToolkit().getImage("/home/ccoew/workspace/FashionStore/images/icon.jpg");
       f.setIconImage(icon);    
        f.setSize(1880,800);
       button1.addActionListener(new ActionListener(){  
    	    public void actionPerformed(ActionEvent e){  
    	    	if(text1.getText().equals("admin") && text2.getText().equals("admin"))
    	    		{
    	    		f.setVisible(false);	
    	    		new Module();	
    	    		}
    	    	else
    	    	JOptionPane.showMessageDialog(f,"Please Enter correct username and pasword !");
    	    } });
      
	}
	public static void main(String[] args){
		new Login();
		
	}
}