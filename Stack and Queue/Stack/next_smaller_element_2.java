// Monotonic Stack
// When we stores element in stack in some specific order then it is konwn as monotonic stack.

// Next Smaller Element 2
// In this problem we will be given an array.
// We have to tell next smaller element of all elements in array.
// If their is not a smaller element in array return -1.
// In This Problem The Array Is Circular

import java.util.*;
public class next_smaller_element_2
{
    public static List<Integer> find_nge(int [] arr)
    {
        int n = arr.length;
        List<Integer> nse = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for(int i = (2*n)-1; i >= 0; i--)
        {
            while(! st.isEmpty() && st.peek() >= arr[i % n])
            {
                st.pop();
            } 
            if(i < n)
            {
                if(st.isEmpty())
                {
                    nse.add(-1);
                }
                else
                {
                    nse.add(st.peek());
                }
            }
            st.push(arr[i % n]);
        }
        nse = nse.reversed();
        return nse;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of your array.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }


        List<Integer> nse = new ArrayList<>();
        nse = find_nge(arr);

        // PRINTING
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

        System.out.println("\n Next Greater Element of each element is given below:-");
        System.out.println(nse);
    }
}