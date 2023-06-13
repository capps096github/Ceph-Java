public class MainApp {
    public static void main(String[] args) {
        // Regular Inner Class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.innerMethod();

        // Static Nested Class
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.nestedMethod();

        // Local Class
        outer.outerMethod();

        // Anonymous Class
        MyInterface anonymous = new MyInterface() {
            public void interfaceMethod() {
                System.out.println("Anonymous method");
            }
        };
        anonymous.interfaceMethod();
    }
}

interface MyInterface {
    void interfaceMethod();
}

class OuterClass {
    private int outerField;

    public void outerMethod() {
        final int localVar = 10;

        class LocalClass {
            public void localMethod() {
                System.out.println("Local method");
                System.out.println("Local variable: " + localVar); // Accessing local variable
            }
        }

        LocalClass local = new LocalClass();
        local.localMethod();
    }

    class InnerClass {
        private int innerField;

        public void innerMethod() {
            outerField = 10; // Accessing outer class field
            System.out.println("Inner method");
        }
    }

    static class StaticNestedClass {
        private int nestedField;

        public void nestedMethod() {
            System.out.println("Nested method");
        }
    }
}
