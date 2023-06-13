import java.io.*;

public class MainActivity {

    public static void main(String[] args) {

        // student object
        Student student = new Student("John", 20, 789456);
        // file name
        // String fileName = "student.ser";
        String fileName = "student.dat";

        // serialize
        try {
            // file output stream to write file
            FileOutputStream file = new FileOutputStream(fileName);

            // object output stream to write object to file
            ObjectOutputStream out = new ObjectOutputStream(file);

            // method for serialization of object
            out.writeObject(student);

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
            Student student2 = (Student) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            System.out.println("Name = " + student2.name);
            System.out.println("Age = " + student2.age);
            System.out.println("RegNo Transient = " + student2.regNo);
            System.out.println("Static Transient = " + Student.staticField);
            System.out.println("Final = " + student2.studentNo);
            System.out.println("Transient Final = " + student2.indexNo);

        } catch (Exception e) {
            // print
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
