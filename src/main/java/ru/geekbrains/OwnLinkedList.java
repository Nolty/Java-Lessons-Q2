package ru.geekbrains;

public class OwnLinkedList<T> {
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public OwnLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public void add(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node inserted = new Node(data);

        if (index == 0) {
            inserted.next = head;
            head = inserted;
        } else if (index >= size) {
            tail.next = inserted;
        } else {
            Node curr = head;
            Node prev = head;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    prev.next = inserted;
                    inserted.next = curr;
                    break;
                }

                prev = curr;
                curr = curr.next;
            }
        }

        size++;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    public void delete(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            Node prev = head;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    if (tail == curr) {
                        tail = prev;
                    }

                    prev.next = curr.next;
                    curr.next = null;
                    break;
                }

                prev = curr;
                curr = curr.next;
            }
        }

        size--;
    }

    public int getSize() {
        return this.size;
    }

    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("Односвязный список пуст");
            return;
        }

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void display(int index) {
        System.out.println(get(index));
    }
}
