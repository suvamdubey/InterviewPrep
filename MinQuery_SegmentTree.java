public class MinQuery_SegmentTree
{
    public static void main(String[] args) {
        int a[] = new int[]{1,4,5,3,2,1,2,2,1,6,45,-2,-9,-8,0};
        MinQuery_SegmentTree minQuery_SegmentTree = new MinQuery_SegmentTree(a);
        System.out.println(minQuery_SegmentTree.getMinRange(0, 7));
        //minQuery_SegmentTree.display();
        minQuery_SegmentTree.update(2, -99);
        System.out.println(minQuery_SegmentTree.getMinRange(0, a.length-1));
        minQuery_SegmentTree.update(2, -6);
        System.out.println(minQuery_SegmentTree.getMinRange(0,4));
        System.out.println(minQuery_SegmentTree.getMinRange(9,12));
        minQuery_SegmentTree.display();
        System.out.println(minQuery_SegmentTree.getMin());
    }
    int a[],s[];
    MinQuery_SegmentTree(int a[])
    {
        this.a = a;
        int n = (int)(Math.pow(2,Math.ceil(Math.log(a.length)/Math.log(2))));
        s = new int[2*n-1];
        buildSegmentTree(0,a.length-1,0);
    }
    private void display()
    {
        int i = 1,j=0;
        while(j<s.length)
        {
            for(int k=0;k<i;j++,k++)
            System.out.print(s[j]+" ");
            i=i*2;
            System.out.println();
        }
    }
    private void buildSegmentTree(int l,int r,int p)
    {
        if (l>r)
        return;
        if (l==r)
        {
            s[p] = a[l];
            return;
        }
        int m = (l+r)/2;
        buildSegmentTree(l, m, 2*p+1);
        buildSegmentTree(m+1, r, 2*p+2);
        s[p] = Math.min(s[2*p+1],s[2*p+2]);
    }
    private int getMin()
    {
        return s[0];
    }
    private int getMinRange(int ql,int qr)
    {
        return minRangeHelper(0,a.length-1,ql,qr,0);
    }
    private int minRangeHelper(int l,int r,int ql,int qr, int p)
    {
        if ((ql>r||qr<l)||l>r)
        return Integer.MAX_VALUE;
        if (l==r)
        return s[p];
        if (ql==l&&qr==r)
        {
            
            
                return s[p];
        }
            //System.out.print("sfv\n");

            int m = (l+r)/2;
            return Math.min(minRangeHelper(l,m,ql,qr,2*p+1),minRangeHelper(m+1, r, ql, qr, 2*p+2));

    }
    private void update(int i,int v)
    {
        a[i] = v;
        updateHelper(0,a.length-1,i,v,0);
    }
    private void updateHelper(int l,int r,int i, int v,int p)
    {
        if (l>r)
        return;
        if (i<l||i>r)
        return;
        if (i>=l&&i<=r)
        {
            if (l==r)
            {
                if (i==l)
                s[p] = v;
                return;

            }
            int m = (l+r)/2;
            updateHelper(l, m, i, v, 2*p+1);
            updateHelper(m+1, r, i, v, 2*p+2);
            s[p] = Math.min(s[2*p+1],s[2*p+2]);
        }
    }
}