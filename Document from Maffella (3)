import java.util.Random;

public class SortingExperiment {

    public static void runExperiment() {
        int[] sizes = {20, 50, 100, 500};
        Random random = new Random();

        System.out.println("\n==============================");
        System.out.println("SORTING EXPERIMENT");
        System.out.println("==============================");

        for (int s = 0; s < sizes.length; s++) {
            int size = sizes[s];
            int[] original = new int[size];

            for (int i = 0; i < size; i++) {
                original[i] = random.nextInt(1000);
            }

            int[] a1 = copyArray(original);
            int[] a2 = copyArray(original);
            int[] a3 = copyArray(original);
            int[] a4 = copyArray(original);

            long start1 = System.nanoTime();
            SelectionSort.sort(a1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            InsertionSort.sort(a2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            MergeSort.sort(a3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            QuickSort.sort(a4);
            long end4 = System.nanoTime();

            System.out.println("\nInput size: " + size);
            System.out.println("Selection Sort - Comparisons: "
                    + SelectionSort.comparisons + "  Time: "
                    + (end1 - start1) + " ns");
            System.out.println("Insertion Sort - Comparisons: "
                    + InsertionSort.comparisons + "  Time: "
                    + (end2 - start2) + " ns");
            System.out.println("Merge Sort - Comparisons: "
                    + MergeSort.comparisons + "  Time: "
                    + (end3 - start3) + " ns");
            System.out.println("Quick Sort - Comparisons: "
                    + QuickSort.comparisons + "  Time: "
                    + (end4 - start4) + " ns");
        }

        runAlmostSortedTest();
    }

    public static void runAlmostSortedTest() {
        Random random = new Random();
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // First sort the array.
        MergeSort.sort(array);

        // Swap five neighbouring pairs.
        for (int i = 0; i < 5; i++) {
            int position = i * 2;

            int temp = array[position];
            array[position] = array[position + 1];
            array[position + 1] = temp;
        }

        int[] a1 = copyArray(array);
        int[] a2 = copyArray(array);
        int[] a3 = copyArray(array);
        int[] a4 = copyArray(array);

        long start1 = System.nanoTime();
        SelectionSort.sort(a1);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        InsertionSort.sort(a2);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        MergeSort.sort(a3);
        long end3 = System.nanoTime();

        long start4 = System.nanoTime();
        QuickSort.sort(a4);
        long end4 = System.nanoTime();

        System.out.println("\n==============================");
        System.out.println("ALMOST-SORTED 100 ARRAY");
        System.out.println("==============================");

        System.out.println("Selection Sort - Comparisons: "
                + SelectionSort.comparisons + "  Time: "
                + (end1 - start1) + " ns");
        System.out.println("Insertion Sort - Comparisons: "
                + InsertionSort.comparisons + "  Time: "
                + (end2 - start2) + " ns");
        System.out.println("Merge Sort - Comparisons: "
                + MergeSort.comparisons + "  Time: "
                + (end3 - start3) + " ns");
        System.out.println("Quick Sort - Comparisons: "
                + QuickSort.comparisons + "  Time: "
                + (end4 - start4) + " ns");
    }

    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }
}
