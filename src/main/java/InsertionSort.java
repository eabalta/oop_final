
/**
 *
 * @author ea
 */
public class InsertionSort implements SortInterface {

    @Override
    public void execute(int[] arr) {

        int size = arr.length;

        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }

    }

}
