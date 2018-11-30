import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class GetElvlishCode here.
 *
 * @author CC Coding Club
 * @version 0.1
 */
public class GetElvishCode
{
    public String getCodeFromFile(String fileName)
    {
        String str = "";
        File   file = new File(fileName);
        byte[] data = new byte[0];
        
        //gets data from a file:
        try
        {
            FileInputStream fis = new FileInputStream(file);
            data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
        }
        //file not found:
        catch (Exception e)
        {       
            System.out.println("NO CODE FOUND");
        }
        
        //converts data into a string:
        try
        {
            str = new String(data, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {}
        
        return str;
    }
}
