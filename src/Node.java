public class Node<T> {
        Node<T> next;
        Node<T> prev; 
        T data;

        public Node(){
            next = null;
            prev = null;
            data = null;
        }

        public Node(Node<T> next, Node<T> prev, T data){
            this.next = next;
            this.prev = prev; 
            this.data = data;
        }

        public Node(T data){
            this.data = data;
        }

        public Node(Node<T> copyNode ) {
            this.next = copyNode.next; 
            this.prev = copyNode.prev; 
            this.data = copyNode.data;
        }

}
