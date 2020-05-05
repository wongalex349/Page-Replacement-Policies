import java.util.*;
import java.io.*;
public class CreateString
{

    public static void main(String[] args)
    {

        try
        {
            FileWriter file = new FileWriter("String.txt");
            Random rand = new Random();
            for (int i = 0; i < 30; i++) {
                int random = rand.nextInt(10);
                file.write(random + "");

            }
            file.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}