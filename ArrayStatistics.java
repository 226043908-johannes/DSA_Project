public class ArrayStatistics {

    public static void showStatistics(int[] times, int count) {
        if (count == 0) {
            System.out.println("No service times available.");
            return;
        }

        int total = 0;
        int highest = times[0];
        int lowest = times[0];
        int longerThan10 = 0;

        for (int i = 0; i < count; i++) {
            total = total + times[i];

            if (times[i] > highest) {
                highest = times[i];
            }

            if (times[i] < lowest) {
                lowest = times[i];
            }

            if (times[i] > 10) {
                longerThan10++;
            }
        }

        double average = (double) total / count;

        System.out.println("\n--- Daily Statistics ---");
        System.out.println("Total students served: " + count);
        System.out.println("Total service time: " + total + " minutes");
        System.out.println("Average service time: " + average + " minutes");
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Services longer than 10 minutes: " + longerThan10);
    }
}
