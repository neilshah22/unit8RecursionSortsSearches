import java.util.Scanner;
import java.io.File;

public class WC
{ 
    public static void main(String[] args)
    {
        try
        {
            Scanner in = new Scanner(System.in);
            System.out.println("File Name");
            String fileName = temp.next();
            
            File inputFile = new File(fileName);
            Scanner in = new Scanner(inputFile);
            
            in.useDelimiter("");
            int counter = 0;
            
            while( in.hasNext())
            {
                counter +=1;
            }
            System.out.println("Number of Characters;=: " + counter);
            
        }
        catch (Exception e)
        {
            
        }
    }
}  