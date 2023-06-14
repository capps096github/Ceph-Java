import java.util.List;

public class GenPorgramm {

}

class Example {
    public <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    public <T> void printListx(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}
class Example2<T> {
    public  void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

}