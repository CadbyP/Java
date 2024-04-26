import java.util.Scanner;

class Tree {
    int[][] a = new int[20][20];
    int l, u, w, i, j, v, e;
    int[] visited = new int[20];

    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the no. of branches: ");
        v = input.nextInt();

        for (i = 0; i < v; i++) {
            visited[i] = 0;
            for (j = 0; j < v; j++) {
                a[i][j] = 999;
            }
        }

        System.out.println("\nEnter the no. of connections: ");
        e = input.nextInt();

        for (i = 0; i < e; i++) {
            System.out.println("Enter the end branches of connections: ");
            l = input.nextInt();
            u = input.nextInt();
            System.out.println("Enter the phone company charges for this connection: ");
            w = input.nextInt();
            a[l - 1][u - 1] = a[u - 1][l - 1] = w;
        }
    }

    public void display() {
        System.out.println("\nAdjacency matrix:");
        for (i = 0; i < v; i++) {
            System.out.println();
            for (j = 0; j < v; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public void minimum() {
        int p = 0, q = 0, total = 0, min;
        visited[0] = 1;
        for (int count = 0; count < (v - 1); count++) {
            min = 999;
            for (i = 0; i < v; i++) {
                if (visited[i] == 1) {
                    for (j = 0; j < v; j++) {
                        if (visited[j] != 1) {
                            if (min > a[i][j]) {
                                min = a[i][j];
                                p = i;
                                q = j;
                            }
                        }
                    }
                }
            }
            visited[p] = 1;
            visited[q] = 1;
            total = total + min;
            System.out.println("Minimum cost connection is " + (p + 1) + " -> " + (q + 1) + "  with charge : " + min);
        }
        System.out.println("The minimum total cost of connections of all branches is: " + total);
    }

    public static void main(String[] args) {
        int ch;
        Tree t = new Tree();
        try (Scanner input = new Scanner(System.in)) {
            do {
                System.out.println("==========PRIM'S ALGORITHM=================");
                System.out.println("\n1.INPUT\n \n2.DISPLAY\n \n3.MINIMUM\n");
                System.out.println("Enter your choice :");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("*******INPUT YOUR VALUES*******");
                        t.input();
                        break;

                    case 2:
                        System.out.println("*******DISPLAY THE CONTENTS********");
                        t.display();
                        break;

                    case 3:
                        System.out.println("*********MINIMUM************");
                        t.minimum();
                        break;
                }

            } while (ch != 4);
        }
    }
}