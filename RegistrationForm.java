package com;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.io.File;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
 
public class RegistrationForm implements ActionListener {
    JFrame frame;
    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel fatherNameLabel=new JLabel("FATHER NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel cityLabel=new JLabel("CITY");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField fatherTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField cityTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
 
 
    RegistrationForm()
    {
       //Calling methods from constructor
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        //Setting Location and Size of Each Component
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        fatherNameLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
        confirmPasswordLabel.setBounds(20,220,140,70);
        cityLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        fatherTextField.setBounds(180,143,165,23);
        passwordField.setBounds(180,193,165,23);
        confirmPasswordField.setBounds(180,243,165,23);
        cityTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        //Adding components to Frame
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(fatherNameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(genderComboBox); 
        
        frame.add(fatherTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
 
    public void actionEvent()
    {
       //Adding Action Listener to buttons
        registerButton.addActionListener(this);
      resetButton.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
//    	
//    //    new login().setVisible(true);
//        this.setVisible(false);
    	if(evt.getActionCommand() == "REGISTER") {
    	 String name=nameTextField.getText().trim();
         String father=fatherTextField.getText().trim();
         String pss=new String(passwordField.getPassword());
          String ps2=new String(confirmPasswordField.getPassword());
           String city=cityTextField.getText().trim();
            String email=emailTextField.getText().trim();
            if(pss.equals(ps2)) {
                JOptionPane.showMessageDialog(null,"registration successful");
             
          		Connection con=null;

        try {
        	con= jdbc.jdbcConnection();
    		
        	
    		Statement stmt=con.createStatement();  
    		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
    		
    		ps.setString(1, name);
    		ps.setString(2, "M");
    		ps.setString(3, father);
    		ps.setString(4, pss);
    		ps.setString(5, city);
    		ps.setString(6, email);
    		int rs=ps.executeUpdate(); 
    		if(rs>0)
    		{
    			Login l=new Login();	
    		}
    		else {
    		    JOptionPane.showMessageDialog(null, "Registration failed");
    		}
    		
    		
        }
        catch(Exception e) {}
        finally {
        	try {
    			con.close();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}  
    	}
        	
        
//         l.setVisible(true);
//         l.setSize(300,100);
         
       
         

    	}
            else
                JOptionPane.showMessageDialog(null, "Registration failed");
    	}
    }
}