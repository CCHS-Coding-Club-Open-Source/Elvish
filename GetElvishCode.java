import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class GetElvlishCode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GetElvishCode
{
    public String getCode()
    {
        /*
         * @show("hello world")|
         * @show("again")|
         * job = @get("What is your job?")|
         * name = @get("What is your name?")|
         * @show("Your name and job is:")|
         * @show(job)|
         * @show(name)|
         */

        String code = "@show(\"Hello world\")|" +
            "\n@show(\"...again\")|" + 
            "\n@show(\"CCHS coding is the best or not depending on if it's monday\")|"+
            "\njob = @get(\"What is your job?\")|" +
            "\nname = @get(\"What is your name?\")|" +
            "\n@show(\"Your name and job: \")|"+
            "\n@show(name)" +
            "\n@show(job)";
        return code;
    }

    /**
     * Gets all Elvish code from external file
     *
     * @author Tal Kronrod
     * @param fileName a .elv file
     * @return the entire text of the file
     */
    public String getCodeFromFile(String fileName)
    {

        File file = new File(fileName);
        byte[] data = new byte[0];
        try 
        {
            FileInputStream fis = new FileInputStream(file);
            data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
        }
        catch (Exception e) {System.out.println("NO CODE FOUND");}

        String str = "";
        try 
        {
            str = new String(data, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {}

        return str;
    }
}
