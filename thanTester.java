public class thanTester
{
    public static void main(String args[])
    {
        AVLTree root = new AVLTree(null);
        root.insert(10);
        root.insert(11);
        root.insert(6);
        root.insert(3);
        root.insert(7);
        root.insert(8);
        root.delete(8);
        root.delete(6);
       root.preOrderRoot();
    }
}
