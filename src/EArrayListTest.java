import java.util.Collection;
import java.util.HashSet;

public class EArrayListTest {
    public static void main(String[] args){
        EArrayList<String> test = new EArrayList<String>(); 
        test.add("Hello");
        test.add("World");
        Collection<String> c = new HashSet<String>();
        for(int i = 0; i < 258; i++){
            c.add("" + i);
        }
        for(int i = 0; i < test.size(); i++){
            System.out.println(test.get(i));
        }
        test.clear();
         test.addAll(c);
         System.out.println(test.isEmpty());
        // System.out.println("yooooo");
        // System.out.println(test.size);
    }
}