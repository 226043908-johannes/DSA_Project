import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static ServiceQueue queue = new ServiceQueue();
    static StudentList studentList = new StudentList();

    static int[] serviceTimes = new int[1000];
    static int serviceCount = 0;

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n================================");
            System.out.println("     CAMPUS SERVICE CENTRE");
            System.out.println("================================");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student service record");
            System.out.println("5. Display student service records");
            System.out.println("6. Search for student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");

            System.out.print("Select option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                Student student = enterStudent();
                queue.enqueue(student);

            } else if (choice == 2) {

                Student student = queue.dequeue();

                if (student == null) {
                    System.out.println("No students are waiting.");
                } else {

                    System.out.println("Serving: " + student);

                    studentList.insertStudent(student);

                    serviceTimes[serviceCount] =
                            student.serviceTime;

                    serviceCount++;
                }

            } else if (choice == 3) {

                queue.displayQueue();

            } else if (choice == 4) {

                Student student = enterStudent();

                studentList.insertStudent(student);

                serviceTimes[serviceCount] =
                        student.serviceTime;

                serviceCount++;

                System.out.println("Record added.");

            } else if (choice == 5) {

                studentList.displayStudents();

            } else if (choice == 6) {

                System.out.print("Enter student number: ");
                String number = input.nextLine();

                Student found =
                        studentList.searchStudent(number);

                if (found == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Student found:");
                    System.out.println(found);
                }

            } else if (choice == 7) {

                System.out.print("Enter student number: ");
                String number = input.nextLine();

                boolean removed =
                        studentList.deleteStudent(number);

                if (removed) {
                    System.out.println("Student record removed.");
                } else {
                    System.out.println("Student not found.");
                }

            } else if (choice == 8) {

                ArrayStatistics.showStatistics(
                        serviceTimes, serviceCount);

            } else if (choice == 9) {

                sortServiceTimes();

            } else if (choice == 10) {

                SortingExperiment.run();

            } else if (choice == 11) {

                running = false;
                System.out.println("Goodbye.");

            } else {

                System.out.println("Invalid option.");
            }
        }

        input.close();
    }

    public static Student enterStudent() {

        System.out.print("Student number: ");
        String number = input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Service type: ");
        String service = input.nextLine();

        System.out.print("Estimated service time: ");
        int time = input.nextInt();
        input.nextLine();

        return new Student(number, name, service, time);
    }

    public static void sortServiceTimes() {

        if (serviceCount == 0) {
            System.out.println("There are no service times.");
            return;
        }

        int[] copy =
                SortingExperiment.copyArray(
                        serviceTimes);

        System.out.println("\n1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");

        System.out.print("Choose: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {

            SelectionSort.sort(copy);
            System.out.println("Selection Sort");
            System.out.println("Comparisons: "
                    + SelectionSort.comparisons);
            SelectionSort.printArray(copy);

        } else if (choice == 2) {

            InsertionSort.sort(copy);
            System.out.println("Insertion Sort");
            System.out.println("Comparisons: "
                    + InsertionSort.comparisons);
            InsertionSort.printArray(copy);

        } else if (choice == 3) {

            MergeSort.sort(copy);
            System.out.println("Merge Sort");
            System.out.println("Comparisons: "
                    + MergeSort.comparisons);
            printArray(copy);

        } else if (choice == 4) {

            QuickSort.sort(copy);
            System.out.println("Quick Sort");
            System.out.println("Comparisons: "
                    + QuickSort.comparisons);
            QuickSort.printArray(copy);

        } else {

            System.out.println("Wrong choice.");
        }
    }

    public static void printArray(int[] array) {

        System.out.print("[");

        for (int i = 0; i < serviceCount; i++) {
            System.out.print(array[i]);

            if (i < serviceCount - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
