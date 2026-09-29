public class Student {
    String studentNumber;
    String name;
    String serviceType;
    int serviceTime;

    public Student(String studentNumber, String name, String serviceType, int serviceTime) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    public String toString() {
        return studentNumber + " - " + name + " - "
                + serviceType + " - " + serviceTime + " min";
    }
}
