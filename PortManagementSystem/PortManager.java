package PortManagementSystem;

import java.util.*;
public class PortManager {

    LinkedListNode<Integer> freePortsHead;
    LinkedListNode<Integer> freePortsTail;
    Map<Integer , LinkedListNode> notFreePorts;

    public PortManager() {
        freePortsHead = new LinkedListNode<>(-1);
        freePortsTail = freePortsHead;
        notFreePorts = new HashMap<>();
    }

    public void addPort(int port) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(port);
        freePortsTail.next = newNode;
        newNode.prev = freePortsTail;
        freePortsTail = newNode;
    }

    public void getFreePorts() {
        if(freePortsTail.data == -1) {
            System.out.println("No free ports available");
        }else{
            System.out.println("Free ports available " + freePortsTail.data);
            notFreePorts.put(freePortsTail.data, freePortsTail);
            LinkedListNode prevNode = freePortsTail.prev;
            prevNode.next = null;
            freePortsTail = prevNode;
        }
    }

    public void freePort(int port) {
        if(notFreePorts.containsKey(port)) {
            LinkedListNode currNode = notFreePorts.get(port);
            freePortsTail.next = currNode;
            currNode.prev = freePortsTail;
            freePortsTail = currNode;
            notFreePorts.remove(port);
        }
    }


}
