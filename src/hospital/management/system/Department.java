package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table=new JTable();
        table.setBounds(150,50,500,300);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        JLabel label1=new JLabel("Department Name");
        label1.setBounds(150,20,150,15);
        label1.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Contact No");
        label2.setBounds(400,20,150,15);
        label2.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label2);

        try{
            conn c=new conn();
            String q="Select * from department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JButton b1=new JButton("Back");
        b1.setBounds(300,350,150,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
