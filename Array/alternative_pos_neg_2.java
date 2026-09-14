// It is same as first
// But in this number of positive and negative elements will not be equal.
import java.util.*;
public class alternative_pos_neg_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // Arranging 
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int index;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] < 0)
            {
                neg.add(arr[i]);
            }
            else
            {
                pos.add(arr[i]);
            }
        }
        if(pos.size() < neg.size())
        {
            for(int i = 0; i < pos.size(); i++)
            {
                arr[i*2] = pos.get(i);
                arr[(i*2)+1] = neg.get(i);
            }
            index = pos.size()*2;
            for(int i = pos.size(); i < neg.size(); i++)
            {
                arr[index] = neg.get(i);
                index++;
            }
        }
        else
        {
            for(int i = 0; i < neg.size(); i++)
            {
                arr[i*2] = pos.get(i);
                arr[(i*2)+1] = neg.get(i);
            }
            index = neg.size()*2;
            for(int i = neg.size(); i < pos.size(); i++)
            {
                arr[index] = pos.get(i);
                index++;
            }
        }
        // Printing
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }
    }
}
