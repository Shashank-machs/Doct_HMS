package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class search_room extends JFrame {
    Choice choice;
    JTable table;
    search_room(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For=new JLabel("Search For Room");
        For.setBounds(250,11,180,31);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        For.setForeground(Color.WHITE);
        panel.add(For);

        JLabel status=new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        Choice choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Availabile");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c=new conn();
            String q="Select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel Roomno=new JLabel("Room Number");
        Roomno.setBounds(5,162,150,20);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        Roomno.setForeground(Color.WHITE);
        panel.add(Roomno);

        JLabel available=new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel price=new JLabel("Price");
        price.setBounds(350,162,150,20);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(520,162,150,20);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);

        JButton search=new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from Room where Availability='"+choice.getSelectedItem()+"' ";
                try{
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);

                    table.setModel(DbUtils.resultSetToTableModel(resultSet));



                }catch (Exception E){
                    E.printStackTrace();
                }


            }
        });

        JButton back=new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });








        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);

    }
    public static void main(String[] args) {
        new search_room();
    }

}
