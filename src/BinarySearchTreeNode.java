public class BinarySearchTreeNode<T> {

    //initialize T objects for element,left and right
    private T element;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    //Constructor for element
    public BinarySearchTreeNode(T element)
    {
        this.element = element;
    }

    //getter for element
    public T getElement() {
        return element;
    }
    //setter for element
    public void setElement(T element) {
        this.element = element;
    }
    //getter() and setter() for left and right
    public BinarySearchTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }

    //Pre-order
    //Pre: passing the parameter node to initialize traverse
    //Post: Traversing through the tree with Pre-order
    public void preOrder(BinarySearchTreeNode<T> node)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(node.getElement());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }
    //Post-order
    //Pre: passing the parameter node to initialize traverse
    //Post: Traversing through the tree with Post-order
    public void postOrder(BinarySearchTreeNode<T> node)
    {
        if(node==null)
        {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getElement());

    }

    //method to calculate height of the node
    //To check if the node is leaf then return
    public boolean isLeaf()
    {
        return  this.getLeft()==null&&this.getRight()==null;
    }
    //Finding height of the tree
    public int height()
    {
        if(this.isLeaf())
        {
            return 0;
        }
        else if (this.getLeft()!=null&&this.getRight()==null)
        {
            return this.getLeft().height()+1;
        }
        else if(this.getLeft()==null&&this.getRight()!=null)
        {
            return this.getRight().height()+1;
        }
        else
        {
            return Math.max(this.getLeft().height(),this.getRight().height())+1;
        }
    }
    //Method to calculate size of the node and its descendants as a subtree
    public int nodeSize(BinarySearchTreeNode<T> node)
    {
        if(node==null)
        {
            return 0;
        }
        return nodeSize(node.getLeft())+nodeSize(node.getRight())+1;
    }


}

