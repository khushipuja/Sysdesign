package PortManagementSystem;

public class LinkedListNode<U> {

    public LinkedListNode next;
    public LinkedListNode prev;
    public U data;
    public LinkedListNode(U data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}
