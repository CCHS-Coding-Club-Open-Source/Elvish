import java.util.Scanner;
import java.util.ArrayList;

/**
 * The main Elvish interpreter class
 *
 * @author CC Coding Club
 * @version 0.0.3
 */
public class Converter
{
    public static void main(String[] args)
    {
        ArrayList<Variable> variables = new ArrayList<Variable>();
        
        //get elvish code
        GetElvishCode gec = new GetElvishCode();
        String code = gec.getCodeFromFile("textTest.elv");
        
        //think of it as one long string:
        code = code.replaceAll("\n", "");
        
        Methods m = new Methods();
        
        //eventually will be all keywords:
        //KeyWords kw = new KeyWords();

        //make methods object - will have methods

        Scanner scan = new Scanner(System.in);

        int     pointer           = 0;  //tracks which character we are parsing
        int     mostRecentPipeLoc = 0;
        boolean endOfFile         = false;
        boolean method            = false;

        //loop through entire elvish file, looking for method calls:
        while(!endOfFile)
        {
            if(code.charAt(pointer) == '@') method = true;
            else
            {
                pointer++;  //move to next character
                method = false;
            }
            
            if(method)
            {
                //find which method it is!

                //get left paren after @:
                int lParenLoc = code.indexOf("(", pointer + 1);

                //get method name from string
                String methodName = code.substring(pointer + 1, lParenLoc); 

                //point to paren, which is after method name:
                pointer = lParenLoc;

                if(methodName.equals("show"))
                {
                   m.show(code, lParenLoc, variables);
                }
                else if(methodName.equals("get"))
                {
                    m.get(code, mostRecentPipeLoc, pointer, variables, lParenLoc);
                }
                //point to start of next line of code:
                pointer = code.indexOf("|", pointer) + 1;

                //if | not found or if at end of file:
                if(pointer == 0 || pointer == code.length()) endOfFile = true;
                mostRecentPipeLoc = pointer - 1;
            }
        }
    }
}