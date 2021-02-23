
import java.util.ArrayList;

/**
 *
 * @author ea
 */
public class Buffer {

    public int row;
    public int col;
    private final int[][] result;   // Listenin sürekli değiştirilmemesi için final olarak tanımladım.

    public Buffer(int row, int col) {
        this.row = row;
        this.col = col;
        result = new int[row][col];  // Verilen Satır ve Sutun sayısı kadar sonuç matrisimizi oluşturduk.
    }

    public synchronized void put(int row, int col, int value) throws InterruptedException {
        result[row][col] = value;   // Put metodu ile belirli satır ve sütundaki 
    }

    public void printResult() {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
                System.out.print('\t');
            }
            System.out.println("\n");
        }
    }
}