import java.io.Serializable;

public class Student implements Serializable {
    // name, age
    public String name;
    public int age;

    // student no final
    public final int studentNo = 123456;

    // index number final transient
    public final transient String indexNo = "789456";

    // regNo transient
    public transient int regNo;

    // static field
    public static int staticField = 10;

    // constructor
    public Student(String name, int age, int regNo) {
        this.name = name;
        this.age = age;
        this.regNo = regNo;
    }

}
