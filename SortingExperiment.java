import java.util.Random;

public class SortingExperiment {

    public static void run() {

        int[] sizes = {20, 50, 100, 500};
        Random random = new Random();

        System.out.println("\nSorting experiment");

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

            long start;
            long end;

            start = System.nanoTime();
            SelectionSort.sort(a1);
            end = System.nanoTime();

            System.out.println("\nInput size: " + size);
            System.out.println("Selection Sort comparisons: "
                    + SelectionSort.comparisons);
            System.out.println("Selection Sort time: "
                    + (end - start) + " ns");

            start = System.nanoTime();
            InsertionSort.sort(a2);
            end = System.nanoTime();

            System.out.println("Insertion Sort comparisons: "
                    + InsertionSort.comparisons);
            System.out.println("Insertion Sort time: "
                    + (end - start) + " ns");

            start = System.nanoTime();
            MergeSort.sort(a3);
            end = System.nanoTime();

            System.out.println("Merge Sort comparisons: "
                    + MergeSort.comparisons);
            System.out.println("Merge Sort time: "
                    + (end - start) + " ns");

            start = System.nanoTime();
            QuickSort.sort(a4);
            end = System.nanoTime();

            System.out.println("Quick Sort comparisons: "
                    + QuickSort.comparisons);
            System.out.println("Quick Sort time: "
                    + (end - start) + " ns");
        }

        almostSortedTest();
    }

    public static void almostSortedTest() {

        int[] array = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(1000);
        }

        MergeSort.sort(array);

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

        long start;
        long end;

        System.out.println("\nAlmost-sorted 100 element test");

        start = System.nanoTime();
        SelectionSort.sort(a1);
        end = System.nanoTime();

        System.out.println("Selection Sort comparisons: "
                + SelectionSort.comparisons);
        System.out.println("Selection Sort time: "
                + (end - start) + " ns");

        start = System.nanoTime();
        InsertionSort.sort(a2);
        end = System.nanoTime();

        System.out.println("Insertion Sort comparisons: "
                + InsertionSort.comparisons);
        System.out.println("Insertion Sort time: "
                + (end - start) + " ns");

        start = System.nanoTime();
        MergeSort.sort(a3);
        end = System.nanoTime();

        System.out.println("Merge Sort comparisons: "
                + MergeSort.comparisons);
        System.out.println("Merge Sort time: "
                + (end - start) + " ns");

        start = System.nanoTime();
        QuickSort.sort(a4);
        end = System.nanoTime();

        System.out.println("Quick Sort comparisons: "
                + QuickSort.comparisons);
        System.out.println("Quick Sort time: "
                + (end - start) + " ns");
    }

    public static int[] copyArray(int[] original) {

        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }
}
