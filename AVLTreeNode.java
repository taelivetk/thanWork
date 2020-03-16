public class AVLTreeNode<T>
{
    private T element;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private AVLTreeNode<T> parent;
    private  int balanceFactor;
    private  int size;
    private int height;

    //constructor
    AVLTreeNode(T element)
    {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }

    public AVLTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(AVLTreeNode<T> parent) {
        this.parent = parent;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //Method to calculate size of the node and its descendants
    public int size(AVLTreeNode<T> node)
    {
        if(node==null)
        {
            return 0;
        }
        return size(node.getLeft())+size(node.getRight())+1;
    }
    //Method to calculate height
    private boolean isLeaf()
    {
        return this.getLeft()==null&&this.getRight()==null;
    }

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
    //Method to calculate Balance Factor
    public int bFactor()
    {
        if(this.isLeaf())
        {
            return 0;
        }
        else if (this.getLeft() != null && this.getRight() == null)
        {
            int heightOfLeftSide = this.getLeft().height();
            return -1 - heightOfLeftSide;
        }
        else if(this.getLeft()==null&&this.getRight()!=null)
        {
            return this.getRight().height()-(-1);
        }
        else
        {
            return this.getRight().height()-this.getLeft().height();
        }

    }

    //Pre and Post-order of the node
    //Pre-order
    //Pre: passing the parameter node to initialize traverse
    //Post: Traversing through the tree with Pre-order
    public void preOrder(AVLTreeNode<T> node)
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
    public void postOrder(AVLTreeNode<T> node)
    {
        if(node==null)
        {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getElement());

    }
    //left rotation
    public AVLTreeNode<T> rotateLeft(AVLTreeNode<T>node)
    {
        AVLTreeNode<T> x = node.right;
        AVLTreeNode<T> z = x.left;
        x.left = node;
        node.right = z;
        node.setHeight(node.height());
        x.setHeight(x.height());
        return x;
    }
    //right rotation
    public AVLTreeNode<T> rotateRight(AVLTreeNode<T> node) {
        AVLTreeNode<T> x = node.left;
        AVLTreeNode<T> z = x.right;
        x.right = node;
        node.left = z;
        node.setHeight(node.height());
        x.setHeight(x.height());
        return x;
    }
    // Right-left rotation
        public AVLTreeNode<T> rightLeftRotate(AVLTreeNode<T> node)
        {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            return node;
        }
        //Left-Right rotation
    public AVLTreeNode<T> leftRightRotate(AVLTreeNode<T> node)
    {
        node.left = rotateLeft(node.left);
        node = rotateRight(node);
        return node;
    }



}
