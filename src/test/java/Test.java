import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //List<Integer> a = new ArrayList<>(100);
        //a.add(1234);

        List<Integer> a = new ArrayList<>(Arrays.asList(new Integer[10]));
        a.set(0, 1234);

        System.out.println(a.get(0));
    }
}
