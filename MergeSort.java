class MergeSort
{
    public static void main(String[] args) {
        int a[] = new int[]{1,4,5,3,2,1,2,2,1,6,45,-2,-9,-8,0};
        sort(a);
        for(int i:a)
        System.out.print(i+" ");
        System.out.println();
    }
    public static void sort(int a[])
    {
        msort(a,0,a.length-1);
    }
    private static void msort(int a[],int l,int r)
    {
        if (l>=r)
        return;
        int m=(l+r)/2;
        msort(a,l,m);
        msort(a,m+1,r);
        merge(a,l,r);
    }
    private static void merge(int a[],int l,int r)
    {
        if (l>=r)
        return;
        int m = (l+r)/2;
        int i=l,j=m+1,k=0;
        int b[] = new int[r-l+1];
        while(i<=m && j<=r)
        {
            if (a[i]<a[j])
            b[k++] = a[i++];
            else
            b[k++] = a[j++];

        }
        while(i<=m)
        b[k++] = a[i++];
        while(j<=r)
        b[k++] = a[j++];
        k=0;
        for(i=l;i<=r;i++)
        a[i] = b[k++];
    }
}