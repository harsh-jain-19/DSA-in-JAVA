import java.util.*;
public class sum_3
{
    public static void quickly(int [] arr, int lb, int ub)
    {
        int partition;
        if(lb < ub)
        {
            partition = sort(arr,lb,ub);
            quickly(arr,lb,partition-1);
            quickly(arr,partition+1,ub);
        }
    }
    public static int sort(int arr[], int lb, int ub)
    {
        int pivot,i,j,temp;
        pivot = arr[lb];
        i = lb;
        j = ub;
        while(i < j)
        {
            while(arr[i] <= pivot && i < ub)
            {
                i++;
            }
            while(arr[j] >= pivot && j > lb)
            {
                j--;
            }
            if(i < j)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[lb];
        arr[lb] = arr[j];
        arr[j] = temp;

        return (j);
    }
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
        // FINDING THREE ELEMENTS 
        
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>(); // HERE WE USING LIST OF LISTS.
        int sum;
        System.out.println("Enter the sum you want to find");
        sum = sc.nextInt();
        // We sort the given array first to ensure no duplicates.
        int lb,ub;
        lb = 0;
        ub = n-1;
        quickly(arr,lb,ub);

        for(int i = 0; i < n; i++)
        {
            if(i > 0 && arr[i] == arr[i-1])
            {
                continue;
            }
            int j = i+1;
            int k = n-1;
            while( j < k)
            {
                if((arr[i] + arr[j] + arr[k]) < sum)
                {
                    j++;
                }
                else if((arr[i] + arr[j] + arr[k]) > sum)
                {
                    k--;
                }
                else
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    
                    ans.add(temp);

                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1])
                    {
                        j++;
                    }
                    while(j < k && arr[k] == arr[j+1])
                    {
                        k--;
                    }
                }
            }
        }
        System.out.println(ans);

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
    }
}