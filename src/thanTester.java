//Thanisorn Jarujinda COS226 Assignment1
//This is program to test out the BinarySearchTree and BinarySearchTreeNode

public class thanTester {

    public static void main(String args[]) {
        //Creating sample nodes
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(85);
        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<>(35);
        BinarySearchTreeNode<Integer> node3 = new BinarySearchTreeNode<>(92);
        BinarySearchTreeNode<Integer> node4 = new BinarySearchTreeNode<>(43);
        BinarySearchTreeNode<Integer> node5 = new BinarySearchTreeNode<>(42);
        BinarySearchTreeNode<Integer> node6 = new BinarySearchTreeNode<>(52);
        BinarySearchTreeNode<Integer> node7 = new BinarySearchTreeNode<>(98);
        BinarySearchTreeNode<Integer> node8 = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node9 = new BinarySearchTreeNode<>(45);
        BinarySearchTreeNode<Integer> node10 = new BinarySearchTreeNode<>(96);

        //Building sample treeNode to test
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node5.setLeft(node9);
        node6.setLeft(node10);


        //Creating the Binary Search Tree object called it mainNode
        BinarySearchTree mainNode = new BinarySearchTree(node1);

        //Binary Search Tree Node section
        System.out.println("Size of the node: "+ node1.nodeSize(node1));
        System.out.println("Height of the node: "+node1.height());
        System.out.println("Pre-order: ");
        node1.preOrder(node1);
        System.out.println("Post-order: ");
        node1.postOrder(node1);

        //Binary Search Tree section
        System.out.println("Size based on root: "+mainNode.rootSize(node1));
        System.out.println("Height based on root: "+mainNode.rootHeight());
        System.out.println("Pre-order on root: ");
        mainNode.preOrderRoot();
        System.out.println("Post-order on root: ");
        mainNode.postOrderRoot();
        System.out.println("Height based on node test1: "+mainNode.nodeHeight(node3,92));
        System.out.println("");
        System.out.println("Test1 failed for height on node: "+ mainNode.nodeHeight(node3,99));
        System.out.println("");

        System.out.println("Height based on node test2: "+mainNode.nodeHeight(node7,98));
        System.out.println("");
        System.out.println("Test2 failed for height on node: "+ mainNode.nodeHeight(node7,62));
        System.out.println("");

        System.out.println("Depth based on node test1: "+mainNode.getDepth(node8,5));
        System.out.println("");
        System.out.println("Test1 failed for Depth on node: "+ mainNode.getDepth(node8,99));
        System.out.println("");

        System.out.println("Depth based on node test2: "+mainNode.getDepth(node6,52));
        System.out.println("");
        System.out.println("Test2 failed for Depth on node: "+ mainNode.getDepth(node6,77));
        System.out.println("");

        System.out.println("Pre-order node test1: ");
        mainNode.nodePreOrder(node4,43);
        System.out.println("Test1 failed for Pre-order node: ");
        mainNode.nodePreOrder(node4,72);
        System.out.println("");
        System.out.println("Pre-order node test1: ");
        mainNode.nodePreOrder(node2,35);
        System.out.println("Test1 failed for Pre-order node: ");
        mainNode.nodePreOrder(node2,7);
        System.out.println("");

        System.out.println("Post-order node test1: ");
        mainNode.nodePostOrder(node4,43);
        System.out.println("Test1 failed for Post-order node: ");
        mainNode.nodePostOrder(node4,99);
        System.out.println("");
        System.out.println("Post-order node test2: ");
        mainNode.nodePostOrder(node4,43);
        System.out.println("Test2 failed for Post-order node: ");
        mainNode.nodePostOrder(node4,32);



    }

}