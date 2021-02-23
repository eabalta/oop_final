
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ea
 */
public class Soru1Deneme {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file1 = new File("matris1.txt");
        File file2 = new File("matris2.txt");
        Scanner mat1 = new Scanner(file1);
        Scanner mat2 = new Scanner(file2);

        ArrayList<int[]> matris1 = new ArrayList<>();

        while (mat1.hasNextLine()) {
            matris1.add(Arrays.stream(mat1.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        ArrayList<int[]> matris2 = new ArrayList<>();

        while (mat2.hasNextLine()) {
            matris2.add(Arrays.stream(mat2.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        Buffer buffer = new Buffer(matris1.size(), matris2.get(0).length);

        ArrayList<MultiplyWorker> workerArray = new ArrayList<>();

        for (int i = 0; i < matris1.size(); i++) {
            workerArray.add(new MultiplyWorker(i, buffer, matris1.get(i), matris2));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < workerArray.size(); i++) {
            executorService.execute(workerArray.get(i));
        }

        executorService.shutdown();

        try {
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) {
                buffer.printResult();
            } else {
                System.out.println("Fail");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
