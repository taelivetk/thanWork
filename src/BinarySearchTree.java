//To mention this is BinaryTreeNode wrapper class
public class BinarySearchTree {
    //Initialize root object
    private static BinarySearchTreeNode<Integer> root;
    //Constructor
    public BinarySearchTree(BinarySearchTreeNode<Integer> node) {
        root = node;
    }
    //Getter() and Setter() for root
    public BinarySearchTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode<Integer> root) {
        this.root = root;
    }

    //method to calculate sized based on root
    public int rootSize(BinarySearchTreeNode rootNode) {
        return root.nodeSize(rootNode);

    }

    //method to calculate height based on root
    public int rootHeight() {
        return root.height();
    }

    //Pre-order for root
    public void preOrderRoot() {

        if (root == null) {
            return;
        }
        root.preOrder(root);
    }

    //Post-order for root
    public void postOrderRoot() {
        if (root == null) {
            return;
        }
       root.postOrder(root);

    }


    //method to searchTree this will further finding the target node.
    public int nodeSearch(BinarySearchTreeNode<Integer> node, int targetNumber) {


        if (node == null) {
            return 0;
        }
        if (node.getElement() == null) {
            return 0;
        } else if (node.getElement() == (targetNumber)) {
            return 1;
        }

        if (node.getLeft() != null) {
            if (nodeSearch(node.getLeft(), targetNumber) == (targetNumber)) {
                return nodeSearch(node.getLeft(), targetNumber);
            }
        }
        if (node.getRight() != null) {
            if (nodeSearch(node.getRight(), targetNumber) == (targetNumber)) {
                return nodeSearch(node.getRight(), targetNumber);
            }
        }
        return 0;
    }

    //method to calculate height based on a node that is passed in as a parameter
    public int nodeHeight(BinarySearchTreeNode<Integer> node, int targetNumber) {
        if (nodeSearch(node, targetNumber) == 1) {
            return node.height();
        } else {
            System.out.println("This node does not exist");
            return -1;

        }

    }

    //method to calculate depth based on a node that is passed in as a parameter
    public int nodeDepth(BinarySearchTreeNode<Integer> node, int targetNumber, int depth) {

        if(depth==0)
        {
            node=root;
        }
        if (node == null)
            return 0;

        if (node.getElement() == targetNumber)
            return depth;

        int downDepth = nodeDepth(node.getLeft(), targetNumber, depth + 1);
        if (downDepth != 0)
            return downDepth;

        downDepth = nodeDepth(node.getRight(), targetNumber, depth + 1);
        return downDepth;
    }

    //Continuation of depth method. Returns the depth of the node
    public int getDepth(BinarySearchTreeNode<Integer> node, int targetNumber) {
        if(nodeSearch(node,targetNumber)==1) {
            return nodeDepth(node, targetNumber, 0);
        }
        else
        {
            System.out.println("This node doest not exist");
            return -1;

        }
    }

    //Methods for preOrder and postOrder on a node that is passed in as a parameter
    public void nodePreOrder(BinarySearchTreeNode<Integer> node, int targetNumber)
    {
        if (node == null) {
        return;
    }
        if(nodeSearch(node,targetNumber)==1) {
        node.preOrder(node);
    }
        else {
        System.out.println("The node doest not exist.");
    }
}
    public void nodePostOrder(BinarySearchTreeNode<Integer> node,int targetNumber)
    {
        if (node == null) {
            return ;
        }
        if(nodeSearch(node,targetNumber)==1)
        {
         node.postOrder(node);
        }
        else
        {
            System.out.println("The node does not exist.");
        }
    }





}




