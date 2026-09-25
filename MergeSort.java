public class MergeSort {
    public static int comparisons = 0;

    public static void sort(int[] array) {
        comparisons = 0;
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int[] temp, int left, int right) {
        // Base case
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(array, temp, left, middle);
        mergeSort(array, temp, middle + 1, right);
        merge(array, temp, left, middle, right);
    }

    public static void merge(int[] array, int[] temp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            comparisons++;

            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }

            k++;
        }

        while (i <= middle) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for (int x = left; x <= right; x++) {
            array[x] = temp[x];
        }
    }
}
