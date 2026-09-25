public class StudentList {

    class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
        }
    }

    Node head = null;

    public void insertStudent(Student student) {
        insertAtEnd(student);
    }

    public void insertAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
    public void insertAtPosition(Student student, int position) {
        if (position <= 1) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;

        for (int i = 1; i < position - 1; i++) {
            if (current == null || current.next == null) {
                break;
            }
            current = current.next;
        }

        if (current == null) {
            insertAtBeginning(student);
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public Student searchStudent(String studentNo) {
        Node current = head;

        while (current != null) {
            if (current.data.studentNo.equals(studentNo)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public boolean deleteStudent(String studentNo) {
        if (head == null) {
            return false;
        }

        if (head.data.studentNo.equals(studentNo)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data.studentNo.equals(studentNo)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }

        System.out.println("\n--- Student Service Records ---");
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
