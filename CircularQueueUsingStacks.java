import java.util.Stack;

public class CircularQueueUsingStacks {
    private Stack<Integer> inbox;
    private Stack<Integer> outbox;

    public CircularQueueUsingStacks() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }

    public void enqueue(int data) {
        inbox.push(data);
    }

    public int dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        if (outbox.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            return outbox.pop();
        }
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = outbox.size() - 1; i >= 0; i--) {
                System.out.print(outbox.get(i) + " ");
            }
            for (int i = 0; i < inbox.size(); i++) {
                System.out.print(inbox.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueueUsingStacks queue = new CircularQueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.displayQueue();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.displayQueue();
    }
}

