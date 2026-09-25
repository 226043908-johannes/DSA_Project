import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ServiceQueue queue = new ServiceQueue();
    static StudentList list = new StudentList();

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
                addStudentToQueue();
            } else if (choice == 2) {
                serveStudent();
            } else if (choice == 3) {
                queue.displayQueue();
            } else if (choice == 4) {
                addServiceRecord();
            } else if (choice == 5) {
                list.displayStudents();
            } else if (choice == 6) {
                searchStudent();
            } else if (choice == 7) {
                deleteStudent();
            } else if (choice == 8) {
                ArrayStatistics.showStatistics(serviceTimes, serviceCount);
            } else if (choice == 9) {
                sortServiceTimes();
            } else if (choice == 10) {
                SortingExperiment.runExperiment();
            } else if (choice == 11) {
                running = false;
                System.out.println("Program ended.");
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }

    public static Student enterStudent() {
        System.out.print("Student number: ");
        String number = input.nextLine();

        System.out.print("Student name: ");
        String name = input.nextLine();

        System.out.print("Service type: ");
        String service = input.nextLine();

        System.out.print("Estimated service time: ");
        int time = input.nextInt();
        input.nextLine();

        return new Student(number, name, service, time);
    }

    public static void addStudentToQueue() {
        Student student = enterStudent();
        queue.enqueue(student);
        System.out.println("Student added to queue.");
    }

    public static void serveStudent() {
        Student student = queue.dequeue();

        if (student == null) {
            System.out.println("No students are waiting.");
            return;
        }

        System.out.println("\nServing student:");
        System.out.println(student);

        list.insertStudent(student);
        serviceTimes[serviceCount] = student.serviceTime;
        serviceCount++;

        System.out.println("Student served.");
    }
    public static void addServiceRecord() {
        Student student = enterStudent();
        list.insertStudent(student);
        serviceTimes[serviceCount] = student.serviceTime;
        serviceCount++;
        System.out.println("Service record added.");
    }
    public static void searchStudent() {
        System.out.print("Enter student number: ");
        String number = input.nextLine();

        Student student = list.searchStudent(number);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }
    public static void deleteStudent() {
        System.out.print("Enter student number: ");
        String number = input.nextLine();

        boolean deleted = list.deleteStudent(number);

        if (deleted) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void sortServiceTimes() {
        if (serviceCount == 0) {
            System.out.println("No service times.");
            return;
        }

        int[] copy = new int[serviceCount];

        for (int i = 0; i < serviceCount; i++) {
            copy[i] = serviceTimes[i];
        }

        System.out.println("\nChoose sorting algorithm");
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");

        System.out.print("Choice: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            SelectionSort.sort(copy);
            System.out.println("Selection Sort");
            System.out.println("Comparisons: " + SelectionSort.comparisons);
        } else if (choice == 2) {
            InsertionSort.sort(copy);
            System.out.println("Insertion Sort");
            System.out.println("Comparisons: " + InsertionSort.comparisons);
        } else if (choice == 3) {
            MergeSort.sort(copy);
            System.out.println("Merge Sort");
            System.out.println("Comparisons: " + MergeSort.comparisons);
        } else if (choice == 4) {
            QuickSort.sort(copy);
            System.out.println("Quick Sort");
            System.out.println("Comparisons: " + QuickSort.comparisons);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Sorted array: ");

        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i]);
            if (i < copy.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}
