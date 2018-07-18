/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programminglanguagesproject;

import java.io.Serializable;
import java.util.regex.*;

/**
 *
 * @author Dosha
 */

public class Main {
    
    static MainFrame mainFrame;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        
    }

        
 
    static boolean FilterInput(String input)
    {
        //This is a regex to check if the input is written in the correct way
        
        // the general form is <Variable> = <anything> ; also any white space is allowed 
        Pattern p = Pattern.compile("[a-z]\\s?=\\s?(.*?)\\s?;\\n?");
        Matcher m = p.matcher(input);
        
        return m.matches();
    }
    

    
    
       
        static String startCompile(String input_txt){
        //split the string by line
        String[] statements = input_txt.split("\\n");
        int lineNumber = 0;
        //iterate through each line
        for(String statement : statements)
        {
           if(! FilterInput(statement.trim()))
            return lineNumber + " | " + statement.trim() +" <= Incorrect expersion";
           
           //Statement is correct so Start compiling :)
          
           
           
           
           
           //to keep the current line in variable
           lineNumber++;
        }
            return "Correct expersion";
        }
}
        

