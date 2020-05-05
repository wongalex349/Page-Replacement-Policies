import java.util.*;
import java.io.*;

public class Optimal
{
    public static void main(String args[])
    {
        try
        {

            File file = new File("String.txt");
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            int arr[] = new int[30];
            int pagefault = 0;
            for (int i = 0; i < data.length(); i++) {
                arr[i] = Character.getNumericValue(data.charAt(i));
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("What is the capacity(3-6)");
            int capacity = scan.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < arr.length; i++)
            {
                for(int x: map.keySet())
                {
                    for(int j = i+1; j < arr.length; j++)
                    {
                        if(arr[j] == x)
                        {
                            map.put(x, j);
                            break;
                        }
                        else map.put(x,Integer.MAX_VALUE);
                    }
                }
                if(map.size() < capacity)
                {
                    if(!map.containsKey(arr[i]))
                    {
                   //     System.out.print("~");
                        pagefault++;
                    }
                    map.put(arr[i], Integer.MAX_VALUE);
                    for(int x: map.keySet())
                    {
                        for(int j = i+1; j < arr.length; j++)
                        {
                            if(arr[j] == x)
                            {
                                map.put(x, j);
                                break;
                            }
                            else map.put(x,Integer.MAX_VALUE);
                        }
                    }
                }
                else if(!map.containsKey(arr[i]))
                {

                    int max = 0;
                    int remove = 0;
                    for(int x: map.keySet())
                    {
                        if(map.get(x) > max)
                        {
                            max = map.get(x);
                            remove = x;
                        }
                        map.put(x,Integer.MAX_VALUE);

                    }
                    map.remove(remove);
                    map.put(arr[i], Integer.MAX_VALUE);
                 //   System.out.print("~");
                    pagefault++;
                }

              //  System.out.println(map.keySet());
            }
            System.out.println("Page Fault: " + pagefault);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


}