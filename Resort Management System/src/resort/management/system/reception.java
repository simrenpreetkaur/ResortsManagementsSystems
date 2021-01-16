
package resort.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class reception extends JFrame implements ActionListener{
    
    JButton button1,button2,button3,button4,button5,button6,button7,button8,button9;
    
    reception(){
        
        button1 = new JButton("New Guest Form");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(40,60,200,30);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Room Info");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(40,100,200,30);
        button2.addActionListener(this);
        add(button2);
        
        button3 = new JButton("Employees Info");
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.setBounds(40,140,200,30);
        button3.addActionListener(this);
        add(button3);
        
        button4 = new JButton("Guest Info");
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.WHITE);
        button4.setBounds(40,180,200,30);
        button4.addActionListener(this);
        add(button4);
        
        button5 = new JButton("Check Out");
        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.WHITE);
        button5.setBounds(40,220,200,30);
        button5.addActionListener(this);
        add(button5);
        
        button6 = new JButton("Check-In Details");
        button6.setBackground(Color.BLACK);
        button6.setForeground(Color.WHITE);
        button6.setBounds(40,260,200,30);
        button6.addActionListener(this);
        add(button6);
        
        button7 = new JButton("Upadate Room Status");
        button7.setBackground(Color.BLACK);
        button7.setForeground(Color.WHITE);
        button7.setBounds(40,300,200,30);
        button7.addActionListener(this);
        add(button7);
        
        button8 = new JButton("Search Room");
        button8.setBackground(Color.BLACK);
        button8.setForeground(Color.WHITE);
        button8.setBounds(40,340,200,30);
        button8.addActionListener(this);
        add(button8);
        
        button9 = new JButton("Log Out");
        button9.setBackground(Color.BLACK);
        button9.setForeground(Color.WHITE);
        button9.setBounds(40,380,200,30);
        button9.addActionListener(this);
        add(button9);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/six.jpg"));
        Image i2 = i1.getImage().getScaledInstance(490, 490,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel l1 = new JLabel(i3);
        l1.setBounds(270,0,470,500);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,800,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            new addGuest().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button2){
            new roomInfo().setVisible(true);
            this.setVisible(false);
                    
        }else if(ae.getSource() == button3){
            new employeeInfo().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button4){
            new guestInfo().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button5){
            new checkout().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button6){
            new checkInDetails().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button7){
            new updateRoom().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button8){
            new searchRoom().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == button9){
            setVisible(false);
        }  
    }
    
    public static void main(String[] args){
        new reception().setVisible(true);
    }
}
