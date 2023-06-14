import java.io.*;

public class Person implements Externalizable {
    // age, name, salary(double)
    public int age;
    public String name;
    public double salary;

    // transient
    public transient int regNo;

    // no arg constructor
    public Person() {
    }

    // constructor
    public Person(String name, int age, double salary, int regNo) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.regNo = regNo;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        // write
        out.writeObject(name);
        out.writeInt(age);
        out.writeInt(regNo);
        out.writeDouble(salary);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // read
        // name = (String) in.readObject();
        this.name = (String) in.readObject();
        age = in.readInt();
        regNo = in.readInt();
        salary = in.readDouble();
    }
}
