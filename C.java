/**
 * C
 */
public class C {

    public void outerMethod() {

        // annon class
        Annon an = new Annon() {

            public void printDetails() {
                System.out.println("Annon class");
            }
        };

        // calling he methd
        an.printDetails();
    }


    // 
    public void x() {
        class LocalClass {
            public void localMethod() {
                System.out.println("Local method");
            }
        }   

        // create local objec
        LocalClass local = new LocalClass();
        local.localMethod();
    }
}

// interface
/**
 * InnerC
 */
interface Annon {

    void printDetails();
}