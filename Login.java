package com;
import javax.swing.*;  import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.awt.*;  
import java.awt.event.*;  
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
  
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class Login extends JFrame implements ActionListener  
{ 
    //initialize button, panel, label, and text field  
    JButton b1,b;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
    JFrame frame;
    //calling constructor  
    Login()  
    {    
         
        //create label for usern ame   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
        b = new JButton("REGISTER");
        //create panel to put form elements  
//        newPanel = new JPanel(new GridLayout(3, 1));  
//        newPanel.add(userLabel);    //set username label to panel  
//        newPanel.add(textField1);   //set text field to panel  
//        newPanel.add(passLabel);    //set password label to panel  
//        newPanel.add(textField2);   //set text field to panel  
//        newPanel.add(b1);           //set button to panel  
//          
//        //set border to panel   
//        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);  
        b.addActionListener(this);//add action listener to button  
        setTitle("LOGIN FORM");    
        
  	  createWindow();
      setLocationAndSize();
        addComponentsToFrame();//set title to the login form  
    }  
      
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Login Form");
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
        userLabel.setBounds(20,20,40,70);
       
     passLabel.setBounds(20,120,100,70);
       
       textField1.setBounds(180,43,165,23);
       
        
        textField2.setBounds(180,193,165,23);
        
        b1.setBounds(20,400,200,70);
        b.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        //Adding components to Frame
        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(textField1);
        frame.add(textField2);
        
        frame.add(b1);
        frame.add(b);
        
    
    }
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
    	
    	if(ae.getActionCommand() == "REGISTER") {
    		//System.out.println(1);
    		Login log=new Login();
    		log.setVisible(false);
    		RegistrationForm reg=new RegistrationForm();
    		
    	
    	}
    	

    	if(ae.getActionCommand() == "SUBMIT") {
    		Connection con=null;

            String userValue = textField1.getText();        //get user entered username from the textField1  
            String passValue = textField2.getText(); 
    try {
    	con= jdbc.jdbcConnection();
		
    	
		Statement stmt=con.createStatement();  
		PreparedStatement ps=con.prepareStatement("select * from student where name = ?");
		
		ps.setString(1, userValue);
		ResultSet rs=ps.executeQuery();  
		while(rs.next())  
		{
			//System.out.println(rs.getString(4));
			  if (passValue.equals(rs.getString(4))) {
	            	 welcome page = new welcome();         
                //make page visible to the user  
                page.setVisible(true);  
                  
                //create a welcome label and set it to the new page  
                JLabel wel_label = new JLabel("Welcome: "+userValue);  
                page.getContentPane().add(wel_label);  
            }  
            else{  
                //show error message  
                System.out.println("Please enter valid username and password");  
            }  
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
    		
    		

            //get user entered pasword from the textField2  
              String data[]= new String[5];
              int i=0;
            //check whether the credentials are authentic or not  
            
//              BufferedReader br=null;
//            	  try {  File file =new File("data.txt");
//            	br = new BufferedReader(new FileReader(file));
//            	      String line;
//            	      while ((line = br.readLine()) != null) {
//            	        data[i]=line.split(":")[1];
//            	        i++;
//            	      }
//            	  }
//              
//              catch(IOException e)
//              {
//            	  
//              }
//              finally {
//        	//      br.close();
//        	  } 
//            if (userValue.equals(data[2]) && passValue.equals(data[0])) {  //if authentic, navigate user to a new page  
//                  
//            
//            	 welcome page = new welcome();         
//                //make page visible to the user  
//                page.setVisible(true);  
//                  
//                //create a welcome label and set it to the new page  
//                JLabel wel_label = new JLabel("Welcome: "+userValue);  
//                page.getContentPane().add(wel_label);  
//            }  
//            else{  
//                //show error message  
//                System.out.println("Please enter valid username and password");  
//            }  
    	}
    	
    }  
}  