public class QuickSort {
    public static void main(String[] args) {
        int a[] = new int[]{1,4,5,3,2,1,2,2,1,6,45,-2,-9,-8,0};
        sort(a);
        for(int i:a)
        System.out.print(i+" ");
        System.out.println("");

    }
    public static void sort(int a[])
    {
        qsort(a,0,a.length-1);
    }
    private static void qsort(int a[],int l,int r)
    {
        if (l>=r)
        return;
        int p = partition(a,l,r);
        qsort(a,l,p-1);
        qsort(a,p+1,r);
    }
    private static int partition(int a[], int l,int r)
    {
        if (l>=r)
        return l;
        int pivot = a[l];
        int i=l,j=r;
        while(i<j)
        {
            while(i<=r&&a[i]<=pivot)
            i++;
            while(j>l&&a[j]>=pivot)
            j--;
            if (i<j)
            {int t = a[i];
            a[i] = a[j];
            a[j] = t;
            }
        }
        a[l] = a[j];
        a[j] = pivot;
        return j;
    }
}
