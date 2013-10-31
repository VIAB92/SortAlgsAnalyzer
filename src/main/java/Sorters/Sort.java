package Sorters;

import Readers.ArrayReader;

import java.io.FileWriter;
import java.io.IOException;


public abstract class Sort {
    private long start;
    private long end;
    protected int n;
    protected long algTime;
    protected int[] x;
    protected  int swapNum;
    protected  int memEval;
    protected long memUsed;
    protected long memFree;
    protected long memTotal;
    boolean countSwaps;
    String algName;

    public Sort()
    {
        this.setSize(0);
        this.swapNum=0;
        this.memEval=0;
    }

    public Sort(int n, int x[])
    {
        this.setArr(x);
        this.setSize(n);
        this.swapNum=0;
        this.memEval=0;
        this.countSwaps=true;
        this.algName="Default Sort";
    }

    public abstract void run();

    public int[] getArr()
    {
        return this.x;
    }

    public void setArr(int[] x)
    {
        this.swapNum=0;
        this.x=x;

    }

    public int getSize()
    {
        return this.n;
    }

    public void getFromFile(String filename)
    {
        this.swapNum=0;
        this.x = ArrayReader.readFromFile("Arrays/"+filename);
        this.setSize(x.length);
    }

    protected void setSize(int n)
    {
        this.n=n;
    }

    public String getName()
    {
        return this.algName;
    }

    public int getSwapNum()
    {
        return this.swapNum;
    }

    public void disableSwapCount()
    {
        this.countSwaps=false;
    }

    public void countSwap()
    {
        if (this.countSwaps)
        {
            this.swapNum++;
        }
    }

    public void print()
    {
        for (int i=0; i<this.n; i++)
        {
            System.out.print(this.x[i]+" ");
        }
        System.out.println();
    }

    public void swap(int i, int j)
    {
        int tmp;
        tmp = this.x[i];
        this.x[i]=this.x[j];
        this.x[j]=tmp;
        this.countSwap();
    }

    public long getAlgTime()
    {
        return this.algTime;
    }

    protected void printReport()
    {
        String str = this.makeReport();
        System.out.println(str);
    }

    public void reportInFile(String filename)
    {
        String str = this.makeReport();
        char[] buffer = new char[str.length()];
        str.getChars(0, str.length(),buffer,0);
        try(FileWriter fw = new FileWriter("Reports/"+filename+"_"+this.algName+".txt"))
        {
            fw.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String makeReport()
    {
        StringBuilder stringToPrint = new StringBuilder();
        stringToPrint.append("=================Information about "+this.algName+"=================\n");
        stringToPrint.append("Elapsed time: "+this.algTime+" nanosec\n");
        stringToPrint.append("Memory used: "+this.memUsed+" bytes\n");
        stringToPrint.append("Memory total: "+this.memTotal+" bytes\n");
        stringToPrint.append("Memory free: "+this.memFree+" bytes \n");
        stringToPrint.append("Total swaps: "+this.swapNum+"\n");

        return stringToPrint.toString();
    }

    protected void beginMeasurement()
    {
        System.gc();
        this.memTotal=Runtime.getRuntime().totalMemory();
        this.memUsed = memTotal;
        this.start = System.nanoTime();
    }

    protected void finishMeasurement()
    {
        this.memFree = Runtime.getRuntime().freeMemory();
        this.memUsed=this.memUsed-memFree;
        this.end = System.nanoTime();
        this.algTime = end-start;
    }
}
