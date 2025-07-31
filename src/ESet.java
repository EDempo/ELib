import EArrayList;
import java.util.Collection;
public class Set<T> {
    EArrayList<T> set;
    final int MAX_CAPACITY = 256;

    public Set() {
        set = new EArrayList<T>();
    }

    public Set(int size) {
        set = new EArrayList<T>(size);
    }

    public void add(Object a) {
        if(set.contains(a)) {
            return;
        }
        set.add(a);
        return; 
    }

    public void addAll(Collection c) {
        for(Object i : c){
            add(i);
        }
    }

    public boolean contains(Object a) {
        return set.contains(a);
    }
}