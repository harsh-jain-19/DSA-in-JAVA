// Monotonic Stack
// When we stores element in stack in some specific order then it is konwn as monotonic stack.

// Previous Smaller Element
// In this problem we will be given an array.
// We have to tell previous smaller element of all elements in array.
// If their is not a smaller element in array return -1.

import java.util.*;
public class previous_smaller_element
{
    public static List<Integer> find_pse(int [] arr)
    {
        int n = arr.length;
        List<Integer> pse = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(! st.isEmpty() && st.peek() >= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pse.add(-1);
            }
            else
            {
                pse.add(st.peek());
            }
            st.push(arr[i]);
        }
        return pse;
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


        List<Integer> pse = new ArrayList<>();
        pse = find_pse(arr);

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
        System.out.println(pse);
    }
}