
import java.util.*;

public class SplitStack {

    // Method to split stack into negatives and non-negatives
    public static void splitStack(Stack<Integer> stack) {
        // Queue to temporarily hold elements from the stack
        Queue<Integer> queue = new LinkedList<>();

        // Separate negative and non-negative elements
        while (!stack.isEmpty()) {
            int element = stack.pop();
            if (element < 0) {
                queue.add(element);  // Add negative numbers to the queue
            } else {
                stack.push(element);  // Keep non-negative numbers in the stack
            }
        }

        // Refill the stack with negatives from the queue
        while (!queue.isEmpty()) {
            stack.push(queue.poll());  // Push negative numbers to the bottom
        }
    }

    // Main method to test the splitStack method
    public static void main(String[] args) {
        // Test case 1
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(-5);
        stack1.push(67);
        stack1.push(-45);
        stack1.push(67);
        stack1.push(9);
        stack1.push(0);
        stack1.push(-42);
        stack1.push(56);
        stack1.push(-7);

        System.out.println("Original Stack 1: " + stack1);
        splitStack(stack1);
        System.out.println("Modified Stack 1: " + stack1); // Expected output: [-5, -45, -42, -7, 5, 67, 67, 9, 0, 56]

        // Test case 2
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(-2);
        stack2.push(-3);
        stack2.push(4);
        stack2.push(-5);
        stack2.push(6);
        stack2.push(-7);
        stack2.push(8);
        stack2.push(9);

        System.out.println("Original Stack 2: " + stack2);
        splitStack(stack2);
        System.out.println("Modified Stack 2: " + stack2); // Expected output: [-2, -3, -5, -7, 1, 4, 6, 8, 9]
    }
}
