public class BinaryNode<T> {
    BinaryNode<T> right; 
    BinaryNode<T> left; 
    T data;
    
        public BinaryNode(){
            right = null;
            left = null;
            data = null;
        }

        public BinaryNode(BinaryNode<T> right, BinaryNode<T> left, T data){
            this.right = right;
            this.left = left; 
            this.data = data;
        }

        public BinaryNode(BinaryNode<T> copyNode ) {
            this.right = copyNode.right; 
            this.left = copyNode.left; 
            this.data = copyNode.data;
        }

}
