  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.msmanagement;

import java.sql.*;

/*
 *
 * @author ramki
 */
public class GetConnection {
    private Connection conn= null;
    Connection getConnection()
    {
         try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","1234");
            System.out.println( "Connection successeed");
        } catch (Exception ex) {
            System.out.println(ex);
        }
         return conn;
    }
    
    
    
    
}
