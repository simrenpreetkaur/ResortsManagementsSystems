
package resort.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class addEmployee extends JFrame implements ActionListener {
    
    JTextField text1,text2,text3,text4,text5,text6;
    JRadioButton radio1,radio2;
    JComboBox combo1;
    JButton button1;
    
    addEmployee(){
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60,30,120,30);
        add(name);
        
        text1 = new JTextField();
        text1.setBounds(200,30,135,30);
        add(text1);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age.setBounds(60,80,120,30);
        add(age);
        
        text2 = new JTextField();
        text2.setBounds(200,80,135,30);
        add(text2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setBounds(60,130,120,30);
        add(gender);
        
        radio1 = new JRadioButton("Male");
        radio1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radio1.setBounds(200,130,70,30);
        radio1.setBackground(Color.WHITE);
        add(radio1);
        
        radio2 = new JRadioButton("Female");
        radio2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        radio2.setBounds(270,130,70,30);
        radio2.setBackground(Color.WHITE);
        add(radio2);
        
        JLabel job = new JLabel("Job");
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setBounds(60,180,120,30);
        add(job);
        
        String str[] = {"Receptionist","Room Service","Waiting Staff","Kitchen Staff","Head Chef","Maintenance/Cleaning","Housekeeping","Porter"}; 
        combo1 = new JComboBox(str);
        combo1.setBounds(200,180,135,30);
        combo1.setBackground(Color.WHITE);
        add(combo1);
                
        JLabel salary = new JLabel("Salary (RM)");
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary.setBounds(60,230,120,30);
        add(salary);
        
        text3 = new JTextField();
        text3.setBounds(200,230,135,30);
        add(text3);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone.setBounds(60,280,120,30);
        add(phone);
        
        text4 = new JTextField();
        text4.setBounds(200,280,135,30);
        add(text4);
        
        JLabel IC = new JLabel("IC Number");
        IC.setFont(new Font("Tahoma", Font.PLAIN, 17));
        IC.setBounds(60,330,120,30);
        add(IC);
        
        text5 = new JTextField();
        text5.setBounds(200,330,135,30);
        add(text5);
        
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60,380,120,30);
        add(email);
        
        text6 = new JTextField();
        text6.setBounds(200,380,135,30);
        add(text6);
        
        JButton b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(185,430,150,30);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resort/management/system/images/four.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel l1 = new JLabel(i3);
        l1.setBounds(370,40,450,450);
        add(l1);
        
        JLabel label2 = new JLabel("ADD EMPLOYEE DETAILS");
        label2.setForeground(Color.BLACK);
        label2.setBounds(430,10,400,30);
        label2.setFont(new Font("Monospaced", Font.PLAIN, 30));
        add(label2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = text1.getText();
        String age = text2.getText();
        String salary = text3.getText();
        String phone = text4.getText();
        String IC = text5.getText();
        String email = text6.getText();
        
        String gender = null;
        
        if(radio1.isSelected()){
            gender = "Male";
        }else if(radio2.isSelected()){
            gender = "Female";
        }
        
        String job = (String)combo1.getSelectedItem();
        com c = new com();
        String str = "insert into employee values('"+name+"', '"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+IC+"','"+email+"')";
        
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new addEmployee().setVisible(true);
    }
}
