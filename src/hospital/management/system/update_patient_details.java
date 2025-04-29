package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    update_patient_details(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label =new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2=new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("Select * from Patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField txt=new JTextField();
        txt.setBounds(248,129,140,20);
        panel.add(txt);

        JLabel label4=new JLabel("IN-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField txt1=new JTextField();
        txt1.setBounds(248,174,140,20);
        panel.add(txt1);

        JLabel label5=new JLabel("Amount Paid(RS) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField txt2=new JTextField();
        txt2.setBounds(248,216,140,20);
        panel.add(txt2);

        JLabel label6=new JLabel("Pending Amount(RS) :");
        label6.setBounds(25,261,200,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField txt3=new JTextField();
        txt3.setBounds(248,261,140,20);
        panel.add(txt3);

        JButton check =new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="Select * from Patient_info where name='"+id+"' ";
                try{
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while(resultSet.next()){
                        txt.setText(resultSet.getString("Room_Number"));
                        txt1.setText(resultSet.getString("Time"));
                        txt2.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1=c.statement.executeQuery("Select * from room where romm_no='"+txt.getText()+"' ");
                    while(resultSet1.next()){
                        String price=resultSet1.getString("Price");
                        int amt_paid=Integer.parseInt(price)-Integer.parseInt(txt2.getText());
                        txt3.setText(""+amt_paid);


                    }


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton update =new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c=new conn();
                    String q=choice.getSelectedItem();
                    String  room=txt.getText();
                    String time=txt1.getText();
                    String amount=txt2.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number='"+room+"', Time='"+time+"',Deposite='"+amount+"'where name='"+q+"' ");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back =new JButton("BACK");
        back.setBounds(168,378,89,23);
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
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new update_patient_details();

    }
}
