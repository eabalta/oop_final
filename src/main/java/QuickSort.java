
/**
 *
 * @author ea
 */
public class QuickSort implements SortInterface {

    int part(int array[], int low, int high) {

        int pivot = array[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    void quickSort(int array[], int low, int high) {
        if (low < high) {
            int p = part(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    @Override
    public void execute(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

}
