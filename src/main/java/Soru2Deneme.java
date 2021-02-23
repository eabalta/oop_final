
/**
 *
 * @author ea
 */
import java.util.Random;

public class Soru2Deneme {

    // İkinci sorumuzun gerçekleştirimini Strategy Patternı ile sağladık.
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int[] arr1 = new int[25];
        int[] arr2 = new int[25];
        int[] arr3 = new int[25];



        for (int i = 0; i < arr1.length; i++) {
            
            int x = rand.nextInt(100);
            arr1[i] = x;
            arr2[i] = x;
            arr3[i] = x;

        }

        
        System.out.println("\nSorting işlemi yapılmadan önce listelerimizin ilk hali :");
        
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("%d ",arr1[i]);
        }
        System.out.println("\n");



        long start = System.nanoTime();

        Context context = new Context(new BubbleSort());
        context.sort(arr1);

        long finish = System.nanoTime();
        long time = finish - start;

        System.out.println("\nBubble Sort işlemi yapıldıktan sonra listemizin hali :");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("%d ",arr1[i]);
        }
        System.out.println("\n");
        
        System.out.println("Bubble Sort Süre : " + time + " ns");


        start = System.nanoTime();

        context = new Context(new QuickSort());
        context.sort(arr2);

        finish = System.nanoTime();
        time = finish - start;

        System.out.println("\nQuick Sort işlemi yapıldıktan sonra listemizin hali :");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("%d ",arr1[i]);
        }
        System.out.println("\n");
        System.out.println("Quick Sort Süre : " + time+" ns");
        
        
        
        start = System.nanoTime();

        context = new Context(new InsertionSort());
        context.sort(arr3);

        finish = System.nanoTime();
        time = finish - start;

        System.out.println("\nInsertiom Sort işlemi yapıldıktan sonra listemizin hali :");
        for (int i = 0; i < arr3.length; i++) {

            System.out.printf("%d ",arr1[i]);

        }
        System.out.println("\n");
        System.out.println("Insertion Sort Süre : " + time+" ns");

    }

}
