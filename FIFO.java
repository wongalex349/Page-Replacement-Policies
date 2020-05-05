import java.util.*;
import java.io.*;

public class FIFO
{
    public static void main(String args[])
    {
        try {
            File file = new File("String.txt");
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            int arr[] = new int[30];
            for (int i = 0; i < data.length(); i++) {
                arr[i] = Character.getNumericValue(data.charAt(i));
            }
            System.out.println("What is the capacity(3-6)");
            HashSet<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            Scanner scan = new Scanner(System.in);
            int capacity = scan.nextInt();
            int pagefault = 0;
            for(int i = 0; i < arr.length; i++)
            {
                if(set.size() < capacity && !set.contains(arr[i]))
                {
                    pagefault++;
                    queue.add(arr[i]);
                    set.add(arr[i]);
                  //  System.out.print("~");
                }
                else if(!set.contains(arr[i]))
                {
                    int val = queue.peek();
                    queue.poll();
                    set.remove(val);
                    set.add(arr[i]);
                    queue.add(arr[i]);
                    pagefault++;
                   // System.out.print("~");
                }
               // System.out.println(set);
            }
            System.out.println("Page Fault: " + pagefault);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}