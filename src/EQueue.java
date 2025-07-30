public class EQueue<T> extends Node<T> {
    Node<T> head; 
    Node<T> tail; 
    int size; 

    public EQueue(){
        head = null;
        tail = null; 
        size = 0;
    }

    public EQueue(Node<T> head, Node<T> tail, int size){
        this.head = head;
        this.tail = tail; 
        this.size = size;
    }

    public void enqueue(T data){
        Node<T> temp = new Node<T>(data);
        if(tail == null){
            temp = tail; 
            head = tail; 
            size++;
            return; 
        } 
        tail.next = temp; 
        tail = temp; 
        size++; 
        return; 

    }

    public T dequeue(){
        if(head == null){
            return null; 
        }
        T temp = head.data;
        head = head.next; 
        return temp; 
    }

    public int getSize(){
        return size;
    }
}
