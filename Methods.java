import java.util.ArrayList;
import java.util.Scanner;
/**
 * (checking for github)
 * Code for executing elvish methods
 *
 * @author CodingClub
 * @version 0.3
 */
public class Methods
{
    Scanner scan = new Scanner(System.in);
    
    /**
     * Elvish method for displaying to console
     * @param code the entire .elv file
     * @param lParenLoc location of the ( before the @show argument to be printed
     * @param variables list of variables and their contents in case one appears in arg
     * 
     */
    public void show(String code, int lParenLoc, ArrayList<Variable> variables)
    {
        String arg = "";
        int pointer = lParenLoc;
        String finalString = "";
        
        //find second quote symbol:
        int rParenLoc = code.indexOf(")", lParenLoc + 1);
        
        //get the argument being sent to show()
        String contents = code.substring(lParenLoc + 1, rParenLoc);  //@show(contents)|
        
        boolean inString = false;
        boolean inVariable = false;
        
        String varName = "";
        //loop through all characters, finding Strings or String variables:
        for(int i = 0; i < contents.length(); i++)
        {
            //find characters between quotes:
            String c = contents.substring(i, i + 1);

            //if not a quote, add to String:
            if(inString && !c.equals("\"")) arg += c;
            
            if(c.equals("\"") && !inString)
            {
                inString = true;  //beginning of String
            }
            else if(c.equals("\"") && inString) inString = false;

            //start or inside of variable name:
            else if(Character.isAlphabetic(c.charAt(0)))
            {
                //variable name starting:
                if(!inVariable)
                {
                    inVariable = true;
                    varName = c;
                }
                else //adding to variable name:
                {
                    varName += c;
                   // System.out.println(varName);
                }
            }
            //reached end of variable name:
            else if(inVariable)
            {
            //System.out.println("in variable, then for loop");
                //loop through all variables, checking .name
                for(Variable v : variables)
                {
                    if(v.name.equals(varName)) //found the variable object
                    {
                        arg += v.contents;
                       // System.out.println("arg in for loop:  " + arg);
                    }
                }
                inVariable = false;
            }
        }
        System.out.println(arg);

    }

    /**
     * displays message and returns user input
     * 
     * @param code the entire elvish file
     * @param mostRecentPipeLoc location of end of previous line of code
     * @param variables list of variables and their contents
     * @param lParenLoc location of start of message argument
     * 
     * POSTCONDITION: variable has been added with contents
     * TODO: take into account, variable might already have been declared!!!
     */
    public void get(String code, int mostRecentPipeLoc, 
                    int pointer, ArrayList<Variable> variables, int lParenLoc)
    {
        //find the =, which implies variable assignment:
        int equalsLoc = code.indexOf('=', mostRecentPipeLoc);
        //determine variable name:
        String var1name = code.substring(mostRecentPipeLoc + 1, equalsLoc).trim(); 

        //find end of argument to be printed:
        int endQuoteLoc = code.indexOf("\"", lParenLoc + 2);
        String arg = code.substring(pointer + 2, endQuoteLoc);
        
        System.out.println(arg);
        //wait for user input:
        String var1 = scan.nextLine();

        //create new variable (TODO: check for variable already declared)
        Variable v = new Variable(var1name, var1);
        variables.add(v);

    }
}
