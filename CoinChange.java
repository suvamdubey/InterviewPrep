import java.util.*;
public class CoinChange {
    public static void main(String[] args) {
        double a[] = {3.5,5.25,7.8,8.9};
        double c[] = {0.25f,0.75f,2,5};
        for(double i:a)
        {
            coins(i, c);
        }
    }
    static void coins(double n, double c[])
    {
        Arrays.sort(c);
        double t = c[c.length-1], k  =n;
        double s = 0;
        for(int i=c.length-1;i>=0;i--)
        { t = c[i];
        while(n>=t)
        {   n = n-t;
            s = s + t;
            System.out.print(t+" ");

        }
        if (n<=0)
        break;
        }
        System.out.println("Value="+s+"Given="+k);
    }
}
