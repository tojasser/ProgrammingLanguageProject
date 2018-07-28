/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programminglanguagesproject;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.regex.*;

/**
 *
 * @author Dosha
 */

public class Main {
    
    static MainJFrame mainFrame;
    static LinkedList lexeme = new LinkedList();
    static LinkedList token = new LinkedList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    
     
       
        
        mainFrame= new MainJFrame();
         mainFrame.setVisible(true);
       
   
       
      
    }

    
        
 
    static boolean FilterInput(String input)
    {
        //This is a regex to check if the input is written in the correct way
        // the general form is <Variable> = <anything> ; also any white space is allowed 
        Pattern p = Pattern.compile("[a-z]*\\s?=\\s?(.*?)\\s?;\\n?");
        Matcher m = p.matcher(input);
        return m.matches();
    }
    
    static void compile(String statement){
        
        String [] list = statement.split(" ");
        Pattern p = Pattern.compile("\\d+");
        
        for (int i = 0; i < list.length; i++) {
            String s = list[i];
            Matcher m = p.matcher(s);
            lexeme.add(i,s);
            
            
        
            if (m.find())//if find number
                token.add(i,"INT_LIT");
            else{
            switch (s){
                case "=":
                    token.add(i,"ASSIGN_OP");
                    break;
                case "(":
                    token.add(i,"LEFT_PAREN");    
                    break;
                case "-":
                    token.add(i,"SUB_OP");
                    break;
                case ")":
                    token.add(i,"RIGHT_PAREN");
                    break;
                case "*":
                    token.add(i,"MULT_OP");
                    break;
                case "[0-9]+":
                    token.add(i,"INT_LIT");
                    break;
                case ";":
                    token.add(i,"SEMI_COL");
                    break;
                default:
                    token.add(i, "IDENT");
                    
                }               
            }
        }
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
           compile(statement);
           
           
           
           
           //to keep the current line in variable
           lineNumber++;
        }
            return "Correct expersion";
        }
        
        
 
      
}
        

