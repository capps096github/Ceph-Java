public class B {
    
    public static void main(String[] args) {
        // objX for static inner class X
        A.X objX = new A.X();

        // objY for inner class Y
    //    object A
    A aa = new A();
    //    object Y
    A.Y objY = aa.new Y();
    }
}
