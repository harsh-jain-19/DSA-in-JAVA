// In this problem you will be given an array containing n items.
// Value and weight of each item will be given to you.
// You will be given a bag of specific weight w.
// Now you have to return a maximum value you can have in the bag.
// NOTE : As it is a fractional knapsack you break the item.

import java.util.*;
class item
{
    int value;
    int weight;
    item(int valuee, int weightt)
    {
        this.value = valuee;
        this.weight = weightt;
    }
}
public class fractional_knapsack
{
    // Comparator function to sort items by value/weight ratio
    static class ItemComparator implements Comparator<item> {
        public int compare(item a, item b) {
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            return Double.compare(r2, r1);  // Return comparison based on value/weight ratio
        }
    }
    public static double find_max_val(item items[], int w, int n)
    {
        Arrays.sort(items, new ItemComparator());
        double total_val = 0.0;
        for(int i = 0; i < n; i++)
        {
            if(items[i].weight < w)
            {
                total_val += items[i].value;
                w = w - items[i].weight;
            }
            else
            {
                double rem_val = (double) items[i].value / items[i].weight;
                rem_val = rem_val * w;
                total_val = total_val + rem_val;
                break;
            }
        }
        return total_val;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items you have.");
        int n = sc.nextInt();
        item [] items = new item[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the value and weight of "+i+" item.");
            int v = sc.nextInt();
            int w = sc.nextInt();
            items[i] = new item(v,w);
        }

        System.out.println("Enter the weight of your bag.");
        int w = sc.nextInt();
        double max_val = find_max_val(items,w,n);
        System.out.println("Maximum value you can have in "+w+" weighted bag = "+max_val);

        for(int i = 0; i < n; i++)
        {
            System.out.println(items[i].value+" , "+items[i].weight);
        }
    }
}