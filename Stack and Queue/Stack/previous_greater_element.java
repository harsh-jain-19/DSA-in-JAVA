// Monotonic Stack
// When we stores element in stack in some specific order then it is konwn as monotonic stack.

// Previous Greater Element
// In this problem we will be given an array.
// We have to tell previous greater element of all elements in array.
// If their is not a smaller element in array return -1.

import java.util.*;
public class previous_greater_element
{
    public static List<Integer> find_pse(int [] arr)
    {
        int n = arr.length;
        List<Integer> pge = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(! st.isEmpty() && st.peek() <= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pge.add(-1);
            }
            else
            {
                pge.add(st.peek());
            }
            st.push(arr[i]);
        }
        return pge;
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


        List<Integer> pge = new ArrayList<>();
        pge = find_pse(arr);

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

        System.out.println("\n Previous Greater Element of each element is given below:-");
        System.out.println(pge);
    }
}