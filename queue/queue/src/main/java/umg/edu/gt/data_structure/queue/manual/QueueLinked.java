package umg.edu.gt.data_structure.queue.manual;

public class QueueLinked<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public QueueLinked() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Agrega al final (O(1))
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    // Quita del inicio (O(1))
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        T data = head.getData();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return data;
    }

    // Mira el primero sin quitarlo
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}