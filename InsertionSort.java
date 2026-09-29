public class InsertionSort {

    public static int comparisons = 0;
    public static int shifts = 0;

    public static void sort(int[] array) {

        comparisons = 0;
        shifts = 0;

        for (int i = 1; i < array.length; i++) {

            int key = array[i];
            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (array[j] > key) {
                    array[j + 1] = array[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }

            array[j + 1] = key;

            if (i <= 3) {
                System.out.print("Insertion Sort pass " + i + ": ");
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
