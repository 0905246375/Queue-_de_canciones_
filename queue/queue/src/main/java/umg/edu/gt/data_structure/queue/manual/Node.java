package umg.edu.gt.data_structure.queue.manual;


class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

    T getData() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }
}