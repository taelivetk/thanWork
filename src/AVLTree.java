public class AVLTree
{
    public AVLTreeNode<Integer> root;

    //constructor
    public AVLTree(AVLTreeNode<Integer> node)
    {
        root =node;
    }

    //Getter() and Setter()
    public AVLTreeNode<Integer> getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode<Integer> root) {
        this.root = root;
    }
    //Method to insert the node to the root
    public void insert(int element)
    {
        if(root==null)
        {
            root = new AVLTreeNode<Integer>(element);
        }
        root = insertNode(root,element);

    }

    //Method to insert an element
    //PRE: initialize node and element parameter
    //POST: return inserting node
    private AVLTreeNode<Integer> insertNode(AVLTreeNode<Integer> node, int element)
    {
        if (node == null) {
            return new AVLTreeNode<>(element);
        } else if (node.getElement() > element) {
            node.setLeft(insertNode(node.getLeft(), element));
        } else if (node.getElement() < element) {
            node.setRight(insertNode(node.getRight(),element));
        }

        //updating height
        node.setHeight(node.height());
        int balance = node.bFactor();

        if(balance >1)
        {
            if(element>node.getRight().getElement())
           node = node.rotateLeft(node);
            else if(element<node.getRight().getElement())
                node = node.rightLeftRotate(node);


        }
        else if(balance<-1)
        {
            if(element<node.getLeft().getElement())
            node = node.rotateRight(node);
            else if(element>node.getLeft().getElement())
                node = node.leftRightRotate(node);

        }

        return node;

    }
    //To return the minimum node value for deletion
    //PRE: initialize the node parameter
    //POST: return current node(left most)
    public AVLTreeNode<Integer> minValueNode(AVLTreeNode<Integer> node)
    {
        AVLTreeNode<Integer> current = node;

        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();

        return current;
    }

    //Method to deleteNode
    //PRE: initialize node and element parameter
    //POST: return the node
    private AVLTreeNode<Integer> deleteNode(AVLTreeNode<Integer> node, int element) {
        if (element < node.getElement())
            node.setLeft(deleteNode(node.getLeft(), element));
        else if (element > node.getElement())
            node.setRight(deleteNode(node.getRight(), element));
        else {

            // node with only one child or no child
            if ((node.getLeft() == null) || (node.getRight() == null)) {
                AVLTreeNode<Integer> temp = null;
                if (temp == node.getLeft())
                    temp = node.getRight();
                else
                    temp = node.getLeft();

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else // One child case
                    node = temp; // Copy the contents of
                // the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                AVLTreeNode<Integer> temp = minValueNode(node.getRight());

                // Copy the inorder successor's data to this node
                node.setElement(temp.getElement());

                // Delete the inorder successor
                node.setRight(deleteNode(node.getRight(), temp.getElement()));


                node.setHeight(node.height());
                int balance = node.bFactor();

                if (balance > 1) {
                    if (element > node.getRight().getElement())
                        node = node.rotateLeft(node);
                    else if (element < node.getRight().getElement())
                        node = node.rightLeftRotate(node);


                } else if (balance < -1) {
                    if (element < node.getLeft().getElement())
                        node = node.rotateRight(node);
                    else if (element > node.getLeft().getElement())
                        node = node.leftRightRotate(node);

                }

            }
        }
        return node;
    }
    //Calling deletion through the root
    public void delete(int element)
    {
        if(root==null)
        {
            root = new AVLTreeNode<>(element);
        }
        root = deleteNode(root,element);
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

}