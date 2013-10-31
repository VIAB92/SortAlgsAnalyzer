package Readers;
import java.io.*;
/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 25.10.13
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class ArrayWriter {
    public static void writeArrayIn(int[] array, String filename)
    {
        try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("Arrays/"+filename+".dat")))
        {
            dout.writeInt(array.length);
            for (int i=0; i<array.length; i++)
            {
                dout.writeInt(array[i]);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot open output file!");
            return;
        }
        catch(IOException ex)
        {
            System.out.println("IO Exception: "+ex.toString());
        }
    }
}
