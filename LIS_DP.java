class LIS_DP
{
    public static void main(String[] args) {
        int a[] = {2,5,3,7,11,8,9,5,5,5,6};
        lis_dp(a);//time = n*n space = n
    }
    static void lis_dp(int a[])
    {
        if (a.length==1)
        System.out.println(1);
        int b[] = new int[a.length];
        for(int i=0;i<b.length;i++)
        b[i] = 1;
        for(int i=1;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if (a[i]>=a[j])
                b[i] = Math.max(b[i],b[j]+1);
            }
        }
        System.out.println(b[b.length-1]);
    }
}