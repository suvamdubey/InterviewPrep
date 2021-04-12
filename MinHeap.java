import java.util.*;


public class MinHeap {
    public static void main(String[] args) {
        int a[] = new int[]{1,4,5,3,2,1,2,2,1,6,45,-2,-9,-8,0};
        MinHeap minHeap = new MinHeap(a);
        minHeap.display();
        while(minHeap.heap.size()>0)
        {
            minHeap.extractMin();
        }
        for (int i:a)
        {
            minHeap.insert(i);
        }
        minHeap.display();
    }
    
    ArrayList<Integer> heap;
    MinHeap(int a[])
    {
        heap = new ArrayList<>();
        for(int i:a)
        heap.add(i);
        heapify();
    }
    private void heapify()
    {
        for (int i=heap.size()-1;i>=0;i--)
        {
            heapifyHelper(i);
        }
    }
    private void heapifyHelper(int p)
    {
        if (p>=heap.size())
        return;
        
        
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int a = heap.get(p);
        if (2*p+1<heap.size())
        x = heap.get(2*p+1);
        if (2*p+2<heap.size())
        y = heap.get(2*p+2);
        if (x<=y&&x<a)
        {
            
            heap.set(p,x);
            heap.set(2*p+1,a);
            heapifyHelper(2*p+1);
        }
        else if (y<=x&&y<a)
        {
            heap.set(p,y);
            heap.set(2*p+2,a);
            heapifyHelper(2*p+2);
        }

    }
    private void display()
    {
        int i = 1,j=0;
        while(j<heap.size())
        {
            for(int k=0;k<i&&j<heap.size();j++,k++)
            System.out.print(heap.get(j)+" ");
            i=i*2;
            System.out.println();
        }
    }
    private int getMin()
    {
        return heap.get(0);
    }
    private int extractMin()
    {
        int r = getMin();
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapifyHelper(0);
        return r;
    }
    private void insert(int x)
    {
        heap.add(x);
        int i = heap.size();
        while(i/2>0)
        {
           int p = heap.get(i/2-1);
           if (p>x)
           {
               heap.set(i/2-1,x);
               heap.set(i-1,p);
               i=i/2;
           }
           else
           break;
        }
    }
}
