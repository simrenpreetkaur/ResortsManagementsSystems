
package resort.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JLabel label1,label2;
    JTextField text1;
    JPasswordField text2;
    JButton button1,button2;

    login(){
    label1 = new JLabel("Username");
    label1.setBounds(40,20,100,30);
    add(label1);
        
    label2 = new JLabel("Password");
    label2.setBounds(40,70,100,30);
    add(label2);
    
    text1 = new JTextField();
    text1.setBounds(150,20,150,30);
    add(text1);

    text2=new JPasswordField();
    text2.setBounds(150,70,150,30);
    add(text2);
    
    button1 = new JButton("Log In");
    button1.setBounds(40,140,120,30);
    button1.setFont(new Font("serif",Font.BOLD,15));
    button1.addActionListener(this);
    button1.setBackground(Color.BLACK);
    button1.setForeground(Color.WHITE);
    add(button1); 
    
    button2 = new JButton("Cancel");
    button2.setBounds(180,140,120,30);
    button2.setFont(new Font("serif",Font.BOLD,15));
    button2.setBackground(Color.BLACK);
    button2.setForeground(Color.WHITE);
    button2.addActionListener(this);
    add(button2);
    
    ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/two.png"));
    Image image2 = image1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
    ImageIcon image3 =  new ImageIcon(image2);
    JLabel label3 = new JLabel(image3);
    label3.setBounds(370,20,150,150);
    add(label3);
    
     getContentPane().setBackground(Color.WHITE);
     
      setLayout(null);
      setBounds(500,300,600,300);
      setVisible(true);
    }
                
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == button1 ){
                String username = text1.getText();
                String password = text2.getText();
                com c = new com();
                
                String str = "select * from login where username = '"+username+"' and password = '"+password+"' ";
                try{
                    ResultSet rs = c.s.executeQuery(str);
                    if (rs.next()){
                        new mainPage().setVisible(true);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null,"The Entry is Invalid!");
                        this.setVisible(false);
                    }
                }catch(Exception e){
                    
                }
            }else if(ae.getSource() == button2){
                System.exit(0);
            }
        }
                
	public static void main (String [] args)
	{
		new login();
	}
}    

