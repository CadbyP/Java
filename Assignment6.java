import java.util.Scanner;

class Tnode {
    public int data;
    public Tnode left;
    public Tnode right;
    public int lbit, rbit;
}

class TBT {
    private Tnode root, head;

    public TBT() {
        root = null;
        head = null;
    }

    public void createTBT() {
        int flag = 0;
        char ans;
        Tnode new_node, temp;
        head = new Tnode();
        head.data = -1;
        head.left = head;
        head.right = head;
        head.lbit = 0;
        head.rbit = 0;
        root = new Tnode();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root node : ");
        root.data = sc.nextInt();
        head.left = root;
        head.lbit = 1;
        root.left = head;
        root.right = head;
        root.lbit = 0;
        root.rbit = 0;
        do {
            new_node = new Tnode();
            System.out.print("\nEnter new node : ");
            new_node.data = sc.nextInt();
            new_node.lbit = 0;
            new_node.rbit = 0;
            temp = root;
            flag = 0;
            while (flag == 0) {
                if (new_node.data < temp.data) {
                    if (temp.lbit == 0) {
                        new_node.left = temp.left;
                        temp.left = new_node;
                        temp.lbit = 1;
                        new_node.right = temp;
                        flag = 1;
                    } else {
                        temp = temp.left;
                    }
                } else if (new_node.data > temp.data) {
                    if (temp.rbit == 0) {
                        new_node.right = temp.right;
                        temp.right = new_node;
                        temp.rbit = 1;
                        new_node.left = temp;
                        flag = 1;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    System.out.println("\n Data is already exist");
                }
            }
            System.out.print("\nDo you want to continue : ");
            ans = sc.next().charAt(0);
        } while (ans == 'Y' || ans == 'y');
    }

    public void inorder() {
        Tnode temp;
        temp = root;
        int flag = 0;
        if (root == null) {
            System.out.println("\nTree is empty");
        } else {
            while (temp != head) {
                if (temp.lbit == 1 && flag == 0) {
                    temp = temp.left;
                } else {
                    System.out.print(" " + temp.data);
                    if (temp.rbit == 1) {
                        temp = temp.right;
                        flag = 0;
                    } else {
                        temp = temp.right;
                        flag = 1;
                    }
                }
            }
        }
    }

    public void preorder() {
        Tnode temp;
        temp = root;
        int flag = 0;
        if (root == null) {
            System.out.println("\nTree is empty");
        } else {
            while (temp != head) {
                if (flag == 0) {
                    System.out.print(" " + temp.data);
                }
                if (temp.lbit == 1 && flag == 0) {
                    temp = temp.left;
                } else {
                    if (temp.rbit == 1) {
                        temp = temp.right;
                        flag = 0;
                    } else {
                        temp = temp.right;
                        flag = 1;
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TBT T = new TBT();
        T.createTBT();
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n1. Inorder Display of Threaded Binary Tree ");
            System.out.println("2. Preorder Display of Threaded Binary Tree ");
            System.out.println("3. Exit");
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    T.inorder();
                    break;
                case 2:
                    T.preorder();
                    break;
                default:
                    System.out.println("\nEnter correct choice");
                    break;
            }
        } while (ch != 3);
    }
}
