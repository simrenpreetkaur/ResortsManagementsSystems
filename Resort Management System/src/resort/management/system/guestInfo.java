
package resort.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class guestInfo extends JFrame implements ActionListener{
    
    JTable table1;
    JButton button1,button2;
    
    guestInfo(){
        table1 = new JTable();
        table1.setBounds(1,50,1000,500);
        add(table1);
        
        JLabel label1 = new JLabel("ID Type");
        label1.setBounds(40,10,70,20);
        add(label1);
        
        JLabel label2 = new JLabel("ID Number");
        label2.setBounds(150,10,70,20);
        add(label2);
        
        JLabel label3 = new JLabel("Name");
        label3.setBounds(280,10,70,20);
        add(label3);
        
        JLabel label4 = new JLabel("Gender");
        label4.setBounds(400,10,70,20);
        add(label4);
          
        JLabel label5 = new JLabel("Country");
        label5.setBounds(530,10,70,20);
        add(label5);
        
        JLabel label6 = new JLabel("Room Allocated");
        label6.setBounds(640,10,100,20);
        add(label6);
        
        JLabel label7 = new JLabel("Checked In");
        label7.setBounds(770,10,70,20);
        add(label7);
        
        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(890,10,90,20);
        add(label8);
                
        button1 = new JButton("Load Data");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(350,560,120,30);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Back");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(530,560,120,30);
        button2.addActionListener(this);
        add(button2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(0,40,1000,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            try{
                com c = new com();
                String str = "select * from guest";
                ResultSet rs = c.s.executeQuery(str);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                
            }
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new guestInfo().setVisible(true);
    }
}
