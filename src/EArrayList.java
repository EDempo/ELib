import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EArrayList<T>  {
    Object[] array;
    int maxSize;
    int size; 
    final static int DEFAULT_CAPACITY = 256; 

    public EArrayList(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        maxSize = DEFAULT_CAPACITY;
    }

    public EArrayList(int size){
        array = new Object[size]; 
        this.size = size;
        maxSize = DEFAULT_CAPACITY;
    }

    public EArrayList(List<T> other){
        array = other.toArray();
    }

    public int size() {
        return size; 
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            System.out.println(i + "th iteration: checking hashCode of item " + i + " versus the parameter's hashCode");
            System.out.println(array[i].hashCode());
            System.out.println(o.hashCode());
            // if(array[i].equals(o)){
            //     return true;
            // }
        }
        return false; 
    }

    public Iterator<T> iterator() {
        
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    public Object[] toArray() {
        return array;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a) {
        if(a.length < size){
            return null;
         }
       for(int i = 0; i < size; i++){
            a[i] = (T)array[i];
        }
        return a; 
    }

    public void  add(Object item) {
        if (size == maxSize) {
        resize();
        System.out.println(isEmpty());
        array[size] = item; 
        size++; 
        return;
       }
        array[size] = item; 
        size++;
    }

    public void  resize(){
        System.out.println("Size is " + size);
        for(int i = 0; i < size; i++){
            System.out.print("[");
            System.out.print(array[i]);
            System.out.print("]");
        }
        System.out.println("resizing");
        maxSize = size*2; 
        Object[] tempArray = new Object[maxSize];
        for(int i  = 0; i < size; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;  
    }

    public boolean remove(Object item) {
        for(int i = 0; i < size; i++){
            if(array[i] == item){
                array[i] = null;
                size--; 
                return true; 
            }
        }    
        return false;        
    }

    public boolean containsAll(Collection<T> c) {
        for(Object a : c){
           if(!contains(a)){
            return false;
           }
        }
        return true;
    }

    public boolean addAll(Collection<T> c) {
        int i = 0;
        for(Object a : c){
            System.out.println("Adding the " + i + "th item.");
            add(a);
            i++;
        }
        return containsAll(c);
    }

    public boolean addAll(int index, Collection<T> c) {      
        Object[] temp = new Object[c.size()];
        int i = 0;
        for(Object a : c){
            temp[i] = a;
            i++; 
        }
        for(int j = index; j < c.size(); j++){
            if(array.length > maxSize){
                resize();
            }
            array[j+c.size()] = array[j];
            array[j] = temp[i];
            i++;
        }
        return true; 
    }


    public boolean removeAll(Collection<T> c) {
        if(!containsAll(c)){
            return false; 
        } 
        for(Object a: c){
            remove(a);
        }
        return true;

    }

    public boolean retainAll(Collection<T> c) {
        for(int i = 0; i < size; i++){
            if(!c.contains(array[i])){
                remove(array[i]);
                return true;
            }
        }
        return false; 
    }

    public void clear() {
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0; 
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index > (size-1) || array == null){
            return null; 
        }
        return (T)array[index];
    }

    public T set(int index, T element) {
        if(index > (size-1) || array == null){
            return null; 
        } 
        @SuppressWarnings("unchecked")
        T temp = (T) array[index];
        array[index] = element; 
        return temp; 
    }

    public void add(int index, T element) {
        for(int i = size; i < index; i--){
            if(i < maxSize){
                resize();
            }
            array[i] = array[i+1];
        }
        array[index] = element;
    }

    public Object remove(int index) {
        Object o = array[index];
        for(int i = index; i < size; i++){
            if(size > maxSize){
                resize();
            }
            array[i] = array[i+1];
        }
        return o;
    }

    public int indexOf(T o) {
       for(int i = 0; i < size; i++){
            if(array[i].equals(o)){
                return i; 
            }
       }
       return -1; 
    }

    public int lastIndexOf(T o) {
        for(int i = size; i > 0; i--){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1; 
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    public EArrayList<T> subList(int fromIndex, int toIndex) {
        EArrayList<T> sub = new EArrayList<T>();
        for(int i = fromIndex; i < toIndex; i++){
            sub.add(array[i]);
        }
        return sub;
    }
    
}
