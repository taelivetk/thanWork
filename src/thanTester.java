//Thanisorn Jarujinda COS226 Assignment2
//The program is designed to insert and remove nodes in AVL tree (where rotation applied).
public class thanTester
{
    public static void main(String args[])
    {

     AVLTree root1 = new AVLTree(null);
     System.out.println("Insertion:");
     root1.insert(58);
     root1.insert(77);
     root1.insert(34);
     root1.insert(10);

     //show case left-right rotation
        root1.insert(11);
        System.out.println("left-right rotation case-->");
        System.out.println("pre-order:");
        root1.preOrderRoot();
        System.out.println("\n"+"post-order:");
        root1.postOrderRoot();
        //show case left-rotation
        root1.insert(78);
        root1.insert(79);
        System.out.println("\n"+"left rotation case-->");
        System.out.println("pre-order:");
        root1.preOrderRoot();
        System.out.println("\n"+"post-order:");
        root1.postOrderRoot();
        //show case of right-rotation
        root1.insert(9);
        root1.insert(8);
        System.out.println("\n"+"right   rotation case-->");
        System.out.println("pre-order:");
        root1.preOrderRoot();
        System.out.println("\n"+"post-order:");
        root1.postOrderRoot();
        //show case of right-left rotation
        root1.insert(81);
        root1.insert(80);
        System.out.println("\n"+"right-left rotation case-->");
        System.out.println("pre-order:");
        root1.preOrderRoot();
        System.out.println("\n"+"post-order:");
        root1.postOrderRoot();

        System.out.println("\n\n"+"Deletion:");
        System.out.println("Remove: 58(the root), 81: ");
        root1.delete(58);
        root1.delete(81);
        System.out.println("pre-order:");
        root1.preOrderRoot();
        System.out.println("\n"+"post-order:");
        root1.postOrderRoot();
        System.out.println("\n\n"+"Remove: 77, 8, 10, 34 ");
        root1.delete(77);
        root1.delete(8);
        root1.delete(10);
        root1.delete(34);
        System.out.println("pre-order:");
        root1.preOrderRoot();
        System.out.println("\n"+"post-order:");
        root1.postOrderRoot();

    }
}