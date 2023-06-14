public class ClonePerson {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * InnerClonePerson
 */
class App {

    public static void main(String[] args) {
        ClonePerson foo = new ClonePerson();

        try {
            ClonePerson bar = (ClonePerson) foo.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}