public class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public CircularQueue(int size) {
        maxSize = size + 1; // One extra space for the rear pointer to point to empty slot
        front = 0;
        rear = 0;
        queueArray = new int[maxSize];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            queueArray[rear] = data;
            rear = (rear + 1) % maxSize;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int data = queueArray[front];
            front = (front + 1) % maxSize;
            return data;
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            int i = front;
            while (i != rear) {
                System.out.print(queueArray[i] + " ");
                i = (i + 1) % maxSize;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

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

