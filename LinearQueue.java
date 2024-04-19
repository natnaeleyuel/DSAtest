public class LinearQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public LinearQueue(int size) {
        maxSize = size;
        front = 0;
        rear = -1;
        queueArray = new int[maxSize];
    }

    public void enqueue(int data) {
        if (rear == maxSize - 1) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            queueArray[++rear] = data;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int data = queueArray[front++];
            if (front > rear) {
                front = 0;
                rear = -1;
            }
            return data;
        }
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Queue is full
    }
}

