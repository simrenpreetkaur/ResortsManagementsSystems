
package resort.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class employeeInfo extends JFrame implements ActionListener{
    
    JTable text1;
    JButton button1,button2;
    
    employeeInfo(){
        text1 = new JTable();
        text1.setBounds(1,50,1000,500);
        add(text1);
        
        JLabel label1 = new JLabel("Name");
        label1.setBounds(40,10,70,20);
        add(label1);
        
        JLabel label2 = new JLabel("Age");
        label2.setBounds(170,10,70,20);
        add(label2);
        
        JLabel label3 = new JLabel("Gender");
        label3.setBounds(280,10,70,20);
        add(label3);
        
        JLabel label4 = new JLabel("Department");
        label4.setBounds(400,10,70,20);
        add(label4);
          
        JLabel label5 = new JLabel("Salary");
        label5.setBounds(540,10,70,20);
        add(label5);
        
        JLabel label6 = new JLabel("Phone");
        label6.setBounds(660,10,70,20);
        add(label6);
        
        JLabel label7 = new JLabel("IC");
        label7.setBounds(790,10,70,20);
        add(label7);
        
        JLabel label8 = new JLabel("Email Address");
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
        setBounds(0,40,1025,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            try{
                com c = new com();
                String str = "select * from employee";
                ResultSet rs = c.s.executeQuery(str);
                text1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                
            }
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new employeeInfo().setVisible(true);
    }
}
