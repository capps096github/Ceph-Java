import java.io.*;

public class Worker {

    public static void main(String[] args) {
        // worker object
        Person person = new Person("james", 20, 1000.0);
        // file name
        String fileName = "person.txt";

        // serialize
        try {
            // file output stream to write file
            FileOutputStream file = new FileOutputStream(fileName);

            // object output stream to write object to file
            ObjectOutputStream out = new ObjectOutputStream(file);

            // method for serialization of object
            out.writeObject(person);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (Exception e) {
            // print
            System.out.println("Exception: " + e.getMessage());
        }

        // deserialize
        try {
            // file input stream to read file
            FileInputStream file = new FileInputStream(fileName);

            // object input stream to read object from file
            ObjectInputStream in = new ObjectInputStream(file);

            // method for deserialization of object
            Person person2 = (Person) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            System.out.println("Name = " + person2.name);
            System.out.println("Age = " + person2.age);
            System.out.println("RegNo Transient = " + person2.regNo);
            System.out.println("Salary = " + person2.salary);

        } catch (Exception e) {
            // print
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
