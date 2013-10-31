package Sorters;


public class BubbleSort extends Sort{
    public BubbleSort(int n, int[] x)
    {
        super(n,x);
        this.algName="Bubble Sort[base]";
    }

    @Override
    public void run() {
        this.beginMeasurement();
        for (int i=0; i<this.n; i++)
        {
            for (int j=this.n-1; j>i; j--)
            {
                if (this.x[j-1]>this.x[j])
                {
                    this.swap(j-1,j);
                }
            }
        }
        this.finishMeasurement();
        this.printReport();
    }
}
