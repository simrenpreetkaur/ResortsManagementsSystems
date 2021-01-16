
package resort.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class checkout extends JFrame implements ActionListener {
    Choice choice1;
    JTextField text1;
    JButton button1,button2,button3;
    
    checkout(){
      
       JLabel label1 = new JLabel("Check Out");
       label1.setBounds(140,10,250,50);
       label1.setFont(new Font("Monospaced", Font.PLAIN, 30));
       add(label1);
       
       JLabel label2 = new JLabel("Guest ID");
       label2.setBounds(30,90,100,30);
       add(label2);
       
       choice1 = new Choice();
       try{
           com c = new com();
           ResultSet rs = c.s.executeQuery("select * from guest");
           while(rs.next()){
               choice1.add(rs.getString("number"));
           }
       }catch(Exception e){}
       choice1.setBounds(150,90,150,30);
       add(choice1);
       
       JLabel label3 = new JLabel("Room Number");
       label3.setBounds(30,130,100,30);
       add(label3);
       
       text1 = new JTextField();
       text1.setBounds(150,130,150,25);
       add(text1);
       
       button1 = new JButton("Check Out");
       button1.setBackground(Color.BLACK);
       button1.setForeground(Color.WHITE);
       button1.setBounds(30,180,120,30);
       button1.addActionListener(this);
       add(button1);
        
       button2 = new JButton("Back");
       button2.setBackground(Color.BLACK);
       button2.setForeground(Color.WHITE);   
       button2.setBounds(175,180,120,30);
       button2.addActionListener(this);
       add(button2);
       
       getContentPane().setBackground(Color.WHITE);
       
       ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/tick.png"));
       Image image2 = image1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
       ImageIcon image3 = new ImageIcon(image2); 
       button3 = new JButton(image3);
       button3.setBounds(310,90,20,25);
       button3.addActionListener(this);
       add(button3);
       
       ImageIcon image4 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/eleven.jpg"));
       //Image i5 = i4.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
       //ImageIcon i6 = new ImageIcon(i5); 
       JLabel image = new JLabel(image4);
       image.setBounds(250,5,500,250);
       add(image);
       
       setLayout(null);
       setBounds(500,200,700,300);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            String id = choice1.getSelectedItem();
            String room = text1.getText();
            String str = "delete from guest where number = '"+id+"'";
            String str2 = "update room room set available = 'Available' where room_number = '"+room+"'";
            com c = new com();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Check Out Done");
                new reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
            
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == button3){
            com c = new com();
            String id = choice1.getSelectedItem();
            try{
                ResultSet rs = c.s.executeQuery("select * from guest where number = '"+id+"'");
                while(rs.next()){
                    text1.setText(rs.getString("room"));
                }
            }catch(Exception e){}
        }
    }
    
    public static void main(String[] args){
        new checkout().setVisible(true);
    }
}
