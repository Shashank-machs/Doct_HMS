package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,350);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        JLabel lable=new JLabel("Name");
        lable.setBounds(10,5,100,20);
        lable.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lable);

        JLabel lable2=new JLabel("Age");
        lable2.setBounds(180,5,100,20);
        lable2.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lable2);

        JLabel lable3=new JLabel("Phone No");
        lable3.setBounds(330,5,100,20);
        lable3.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lable3);

        JLabel lable5=new JLabel("Salary");
        lable5.setBounds(500,5,100,20);
        lable5.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lable5);

        JLabel lable6=new JLabel("Gmail ID");
        lable6.setBounds(660,5,100,20);
        lable6.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lable6);

        JLabel lable7=new JLabel("Adhar No");
        lable7.setBounds(830,5,100,20);
        lable7.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(lable7);

        try{
            conn c=new conn();
            String q="Select * from EMP_INFO";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }
        JButton button=new JButton("Back");
        button.setBounds(450,400,150,25);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setSize(1000,600);
        setLocation(350,200);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}
