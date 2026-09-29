public class StudentList {

    class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
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
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public Student searchStudent(String studentNumber) {
        Node current = head;

        while (current != null) {
            if (current.student.studentNumber.equals(studentNumber)) {
                return current.student;
            }
            current = current.next;
        }

        return null;
    }

    public boolean deleteStudent(String studentNumber) {
        if (head == null) {
            return false;
        }

        if (head.student.studentNumber.equals(studentNumber)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.student.studentNumber.equals(studentNumber)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("There are no student records.");
            return;
        }

        Node current = head;
        int number = 1;

        System.out.println("\nStudent service records:");

        while (current != null) {
            System.out.println(number + ". " + current.student);
            current = current.next;
            number++;
        }
    }
}
