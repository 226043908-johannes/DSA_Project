public class QuickSort {
    public static int comparisons = 0;
    public static int swaps = 0;

    public static void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotPosition = partition(array, low, high);
            quickSort(array, low, pivotPosition - 1);
            quickSort(array, pivotPosition + 1, high);
        }
    }

    // Pivot is the last element.
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;

            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swaps++;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        swaps++;

        return i + 1;
    }
}
