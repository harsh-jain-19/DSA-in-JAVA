for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                System.out.println(i+" devides "+n);
                a++;
            }
        }
        System.out.println("Total "+a+" numbers devides "+n);