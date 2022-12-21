/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.msmanagement;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.white;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author ramki
 */
public class ShowWholeStock {
    
    ShowWholeStock()
    {
    featchStock();
    }
    private static JPanel addTextBoxes(int i,String name,int quantity)
    {
    int height=45,leaveUpperHeight=70;
    JPanel p1=new JPanel();
    p1.setBounds(0, i*height+leaveUpperHeight, 772, 40);
    //p1.setBackground(Color.red);
    p1.setLayout(null);
    
    
    JTextField textField0=new JTextField();
    textField0.setBackground(white);
    textField0.setBounds(0, 3, 30, 34);
    textField0.setText(i+"");  
    textField0.setEditable(false);
    p1.add(textField0);
    
   
    JTextField textField1=new JTextField();
    textField1.setBackground(white);
    textField1.setBounds(30, 3, 100, 34);
    textField1.setText(name+"");
    textField1.setEditable(false);
    p1.add(textField1);
    
     JTextField textField2=new JTextField();
    textField2.setBackground(white);
    textField2.setBounds(130, 3, 100, 34);
    textField2.setText(quantity+"");
    textField2.setEditable(false);
    p1.add(textField2);
    
     
    
    
//    JTextField textField4=new JTextField();
//    textField4.setBackground(white);
//    textField4.setBounds(230, 5, 50, 20);
//    //textField4.setText(fourth+"");
//    p1.add(textField4);
    
    return p1;
    
    }
    
    
    public void featchStock()
    {
        JFrame jf=new JFrame("Ram");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setBounds(0, 0, 772, 404);
    jf.setLayout(null);
    jf.setVisible(true);
    
    JPanel upperPanel=new JPanel();
    upperPanel.setBounds(0, 0, 772, 50);
    upperPanel.setBackground(Color.red);
    upperPanel.setLayout(null);
    jf.add(upperPanel);
    
    JTextField textField3=new JTextField();
    textField3.setBackground(white);
    textField3.setBounds(350, 10, 85, 30);
    textField3.setText("Overall Stock");
    textField3.setEditable(false);
    upperPanel.add(textField3);
    
    
            
        try{
       Connection conn=new GetConnection().getConnection();
       PreparedStatement ps;
       ps=conn.prepareStatement("select name,available from Medicine");
       ResultSet rs=ps.executeQuery();
       //rs.next();
        ArrayList<String> alName=new ArrayList<>();
        ArrayList<Integer> alQuantity=new ArrayList<>();
       while(rs.next())
       {
           String name=rs.getString("name");
           alName.add(name);
           int quantity=rs.getInt("available");
           alQuantity.add(quantity);
           //System.out.print(name + " " + quantity +"\n");
           
           //panel6MedicineName.setText(rs.getString("name"));
           //int available=rs.getInt("available");
           //String availableString=available.toString();
                   
           //panel6Stock.setText(availableString);
           
       }
       
       Integer []quantityArray=new Integer[alQuantity.size()];
       String []nameArray=new String[alName.size()];
       JPanel []panelArray=new JPanel[alName.size()];
       alQuantity.toArray(quantityArray);
       alName.toArray(nameArray);
       
       for(int i=0;i<alName.size();i++)
       {
           panelArray[i]=addTextBoxes(i,nameArray[i],quantityArray[i]);
        
        jf.add(panelArray[i]);
       
       }
       
        }
        catch(Exception e)
        {
            System.out.println(e);
        
        }
       
    }
    
}
