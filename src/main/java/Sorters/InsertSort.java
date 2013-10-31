package Sorters;


public class InsertSort extends Sort{
    public InsertSort()
    {
        this.algName="Insert Sort";
    }

    public InsertSort(int n, int[] x)
    {
        super(n,x);
        this.algName="Insert Sort";
    }


    @Override
    public void run()
    {
        this.beginMeasurement();
        int t;
        int i,j;
        for (i=1; i<n; i++)
        {
            t=x[i];
            for (j=i; j>0 && x[j-1]>t; j--)
            {
                x[j]=x[j-1];
                this.countSwap();
            }
            x[j]=t;
        }
        this.finishMeasurement();
        this.printReport();
    }
}
