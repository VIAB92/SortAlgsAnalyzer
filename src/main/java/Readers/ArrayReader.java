package Readers;

import java.io.*;

public class ArrayReader {
    public static int[] readFromFile(String filename)
    {
        int[] array=null;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filename+".dat")))
        {
            int length = dis.readInt();
            array = new int[length];
            for (int i=0; i<length; i++)
            {
                array[i]=dis.readInt();
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Input File Not Found");
            System.exit(1);
        }
        catch (IOException ex)
        {
            System.out.println("IO Exception: "+ex.toString());
            System.exit(1);
        }
        return array;
    }
}
