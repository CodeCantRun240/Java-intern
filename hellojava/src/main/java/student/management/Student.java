package student.management;

public class Student {
    private String studentId;
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor
    public Student(String studentId, String name, String phoneNumber, String email) {
        this.studentId = studentId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String getStudentId() {return studentId;}
    public void setStudentId(String studentId) {this.studentId = studentId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}