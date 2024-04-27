import java.util.Scanner;
import java.util.Stack;
class TreeNode {
char value;
TreeNode left, right;
TreeNode(char item) {
value = item;
left = right = null;
}
}
public class ExpressionTree {
// Function to check if the given character is an operand
private static boolean isOperand(char c) {
return (c >= '0' && c <= '9') || (c >= 'a' && c <=
'z') || (c >= 'A' && c <= 'Z');
}
// Function to build the expression tree
public static TreeNode constructTree(char[] prefix) {
Stack<TreeNode> stack = new Stack<>();
for (int i = prefix.length - 1; i >= 0; i--) {
char ch = prefix[i];
// If the character is an operand, push it to the stack
if (isOperand(ch)) {
stack.push(new TreeNode(ch));
} else {
// Operator node
TreeNode node = new TreeNode(ch);
// If there are at least two nodes in the stack
if (!stack.isEmpty()) {
node.left = stack.pop(); // Assign the top of the stack to the left child
}
if (!stack.isEmpty()) {
node.right = stack.pop(); // Assign the next top of the stack to the right child
}
// Push the operator node to the stack
stack.push(node);
}
}
// The root of the tree is the last element remaining in the stack
return stack.peek();
}
// Function to perform non-recursive postorder traversal on the tree
public static void nonRecursivePostorder(TreeNode root)
{
if (root == null) return;
Stack<TreeNode> stack = new Stack<>();
Stack<TreeNode> output = new Stack<>();
stack.push(root);
while (!stack.isEmpty()) {
TreeNode curr = stack.pop();
output.push(curr);
if (curr.left != null) {
stack.push(curr.left);
}
if (curr.right != null) {
stack.push(curr.right);
}
}
while (!output.isEmpty()) {
TreeNode node = output.pop();
System.out.print(node.value + " ");
}
}
// Function to delete the tree (freeing up resources)
public static void deleteTree(TreeNode node) {
if (node == null) return;
deleteTree(node.left);
deleteTree(node.right);
node.left = null;
node.right = null;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the prefix expression: ");
String expression = scanner.nextLine();
char[] prefixChars = expression.replaceAll("\\s+", "").toCharArray();
TreeNode root = constructTree(prefixChars);
System.out.print("Postorder traversal of the constructed tree: ");
nonRecursivePostorder(root);
System.out.println();
deleteTree(root);
System.out.println("Expression tree has been deleted.");
scanner.close();
}
 }