import java.util.Stack;

public class LinearQueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public LinearQueueUsingStacks () {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int data) {
        stack1.push(data);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        LinearQueueUsingStacks queue = new LinearQueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20

        queue.enqueue(40);

        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.dequeue()); // 40

        System.out.println(queue.dequeue()); // Queue is empty
    }
}

