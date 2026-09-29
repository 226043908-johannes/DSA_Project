public class ServiceQueue {
    Student[] queue = new Student[100];
    int front = 0;
    int rear = -1;

    public void enqueue(Student student) {
        if (rear == 99) {
            System.out.println("Queue is full.");
        } else {
            rear++;
            queue[rear] = student;
            System.out.println("Student added to queue.");
        }
    }

    public Student dequeue() {
        if (rear == -1) {
            return null;
        }

        Student student = queue[front];

        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

        rear--;
        return student;
    }

    public Student peek() {
        if (rear == -1) {
            return null;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void displayQueue() {
        if (rear == -1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("\nWaiting students:");

            for (int i = 0; i <= rear; i++) {
                System.out.println((i + 1) + ". " + queue[i]);
            }
        }
    }
}
