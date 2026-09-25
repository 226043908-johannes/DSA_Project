public class SelectionSort {
    public static int comparisons = 0;
    public static int swaps = 0;

    public static void sort(int[] array) {
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                comparisons++;

                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
                swaps++;
            }
        }
    }
}
