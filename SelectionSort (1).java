public class SelectionSort {

    public static int comparisons = 0;
    public static int swaps = 0;

    public static void sort(int[] array) {

        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < array.length - 1; i++) {

            int smallest = i;

            for (int j = i + 1; j < array.length; j++) {

                comparisons++;

                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }

            if (smallest != i) {

                int temp = array[i];
                array[i] = array[smallest];
                array[smallest] = temp;

                swaps++;
            }

            if (i < 3) {
                System.out.print("Selection Sort pass " + (i + 1) + ": ");
                printArray(array);
            }
        }
    }

    public static void printArray(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
