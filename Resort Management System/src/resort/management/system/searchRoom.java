
package resort.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class searchRoom extends JFrame implements ActionListener {
    JComboBox combo1;
    JCheckBox check1;
    JButton button1,button2;
    JTable table1;
    
    searchRoom(){
        JLabel label1 = new JLabel("Search Room");
        label1.setFont(new Font("Monospaced", Font.PLAIN, 30));
        label1.setBounds(390,10,250,50);
        add(label1);
        
        JLabel label2 = new JLabel("Room Type");
        label2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label2.setBounds(50,100,150,20);
        add(label2);
        
        combo1 = new JComboBox(new String [] {"Single", "Double","Triple","Suite","Villa"});
        combo1.setBounds(200,100,150,25);
        combo1.setBackground(Color.WHITE);
        add(combo1);
        
        check1 = new JCheckBox("Only Display Available");
        //c2.setBackground(Color.WHITE);
        check1.setBounds(650,100,150,25);
        add(check1);
        
        table1 = new JTable();
        table1.setBounds(0,200,1000,300);
        add(table1);
        
        JLabel label3 = new JLabel("Room Number");
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setBounds(50,170,100,20);
        add(label3);
        
        JLabel label4 = new JLabel("Availability");
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setBounds(280,170,100,20);
        add(label4);
        
        JLabel label5 = new JLabel("Cleaning Status");
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setBounds(450,170,100,20);
        add(label5);
        
        JLabel label6 = new JLabel("Price");
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setBounds(650,170,100,20);
        add(label6);
        
        JLabel label7 = new JLabel("Room Type");
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setBounds(850,170,100,20);
        add(label7);
        
        button1 = new JButton("Submit");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(300,520,120,30);
        button1.addActionListener(this);
         add(button1);
        
        button2 = new JButton("Back");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);   
        button2.setBounds(500,520,120,30);
        button2.addActionListener(this);
        add(button2);
        
        //getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            try{
                String str = "select * from room where room_type = '"+combo1.getSelectedItem()+"'";
                String str2 = "select * from room where available = 'Available' AND room_type = '"+combo1.getSelectedItem()+"'";
                com c = new com();
                ResultSet rs;
                
                if(check1.isSelected()){
                    rs = c.s.executeQuery(str2);
                    table1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs = c.s.executeQuery(str);
                    table1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == button2){
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new searchRoom().setVisible(true);
    }
    
}
