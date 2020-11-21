import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
public class Main {
	private JFrame f = new JFrame("Classy Missy");
	//private JLabel label1=new JLabel(new ImageIcon("/home/ccoew/3961/FashionStore/logo.png"));
	private JLabel mainlabel=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/bg2.jpg"));
	private JLabel mainlabel1=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/multiple.png"));
	private JLabel label1=new JLabel(new ImageIcon("/home/ccoew/workspace/FashionStore/images/logo.png"));
	public Main(){
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JProgressBar pb = new JProgressBar();
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setBounds(430,650,500,50);
        mainlabel.setBounds(0,0,2000,800);
        mainlabel.add(pb);
        mainlabel1.setBounds(150,00,1000,800);
        pb.setStringPainted(true);
        label1.setBounds(430,10,500,170);
        pb.setForeground(Color.black);
		mainlabel.add(label1);
		 mainlabel.add(mainlabel1);
		 Image icon = Toolkit.getDefaultToolkit().getImage("/home/ccoew/workspace/FashionStore/images/icon.jpg");
	       f.setIconImage(icon);
	       f.add(mainlabel);
		f.setSize(1880,800);
		f.setVisible(true);
		pb.setString("WELCOME :)");
		Font font=new Font("Century Gothic",Font.ITALIC,20);
		pb.setFont(font);
		 for (int i = 0; i <= 100; i++) {
	            final int currentValue = i;
	            try {
	                SwingUtilities.invokeLater(new Runnable() {
	                    public void run() {
	                        pb.setValue(currentValue);
	                    }
	                });
	                java.lang.Thread.sleep(100);
	            } catch (InterruptedException e) {
	                JOptionPane.showMessageDialog(f, e.getMessage());
	            }
	        }
		 new Login();
		f.setVisible(false);
		
	}
	
	public static void main(String[] args){
		new Main();
		
	}
}