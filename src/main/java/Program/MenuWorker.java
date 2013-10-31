package Program;

import Readers.ArrayWriter;
import Sorters.BubbleSort;
import Sorters.InsertSort;
import Sorters.Sort;

import java.util.Scanner;

public class MenuWorker {
    public static Scanner sc;
    public static void printMenuAboutSaving(Sort sort)
    {
        sc = new Scanner(System.in);
        System.out.println("Желаете сохранить отчет в файл?? (y/n)");
        String ans = sc.nextLine();
        if (ans.toLowerCase().equals("y"))
        {
            System.out.println("Введите имя файла:");
            String filename = sc.nextLine();
            sort.reportInFile(filename);

        }
    }

    public static String gimmeFileName()
    {
        sc = new Scanner(System.in);
        System.out.println("Введите пожалуйста имя файла из папки Arrays:");
        String filename = sc.nextLine();
        return filename;
    }

    public static void testAlgs()
    {
        String filename = MenuWorker.gimmeFileName();
        int[]x = null;
        Sort[] sortTypes = new Sort[]{new BubbleSort(0,x), new InsertSort(0,x)};

        for (int k=0;k<sortTypes.length; k++)
        {

            sortTypes[k].getFromFile(filename);
            sortTypes[k].run();
            MenuWorker.printMenuAboutSaving(sortTypes[k]);
        }
    }

    public static void fileArrayCreator()
    {
        sc = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i=0; i<size; i++)
        {
            System.out.println("Введите "+(i+1)+"-й элемент массива:");
            int element = sc.nextInt();
            array[i]=element;
        }
        sc = new Scanner(System.in);
        System.out.println("Введите имя файла, куда желаете сохранить массив:");
        String filename = sc.nextLine();
        ArrayWriter.writeArrayIn(array, filename);
        System.out.println("Спасибо! Файл создан.");
    }

    public static int userTask()
    {
        sc = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("1 - ввести массив в файл");
        System.out.println("2 - провести анализ сортировки");
        System.out.println("0 - выход");
        System.out.println("==========================================");
        System.out.println("Ваш выбор?");
        int answer = sc.nextInt();
        return answer;

    }

    public static void mainMenu()
    {
        while (true)
        {
            int task = userTask();
            switch (task)
            {
                case 1: fileArrayCreator(); break;
                case 2: testAlgs(); break;
                default: System.out.println("Спасибо за использование приложения!");
                    System.exit(0);
            }
        }
    }

}
