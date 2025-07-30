public class EStack<T> extends Node<T> {
    Node<T> head; 
    int size; 

    public EStack(){
        head = null;
        size = 0;
    }
    
    public EStack(Node<T> head, int size){
        this.head = head; 
        this.size = size;
    }

    public void  add(T data){
        if(head == null){
            head = new Node<T>(data); 
            size++;
            return;
        }
        Node<T> temp = new Node<T>(data);
        temp.next = head;
        head = temp;
        size++;;
    }

    public T remove(){
        if(head == null || head.data == null){
            return null;
        }

        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public T peek(){
        return head == null ? null : head.data;
    }

    public boolean empty(){
        return head == null;
    }

    public int getSize(){
        return size; 
    }

}
