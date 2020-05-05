import java.util.*;
import java.io.*;

public class LRU
{
    public static void main(String args[])
    {
        try
        {
            File file = new File("String.txt");
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            int arr[] = new int[30];
            for (int i = 0; i < data.length(); i++) {
                arr[i] = Character.getNumericValue(data.charAt(i));
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("What is the capacity(3-6)");
            int capacity = scan.nextInt();
            int pagefault = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < arr.length; i++)
            {
                if(map.size() < capacity)
                {
                    if(!map.containsKey(arr[i]))
                    {
                        pagefault++;
                      //  System.out.print("~");
                    }
                    map.put(arr[i], i);
                }
                else if(!map.containsKey(arr[i]))
                {
                    int lru = Integer.MAX_VALUE;
                    int val = Integer.MIN_VALUE;
                    for(int j: map.keySet())
                    {
                        if(map.get(j) < lru)
                        {
                            lru = map.get(j);
                            val = j;
                        }
                    }

                    pagefault++;
                   // System.out.print("~");
                    map.remove(val);


                }
                map.put(arr[i],i);
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