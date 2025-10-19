package DSA.LinkedList;

public class CircularLL {
    public static class Node {
        int data;
        Node next;
    }

    static Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }

        Node newNode = new Node();//create new Node
        newNode.data = data;//Assign data in newNode
        last = newNode;// to make last using newNode
        newNode.next = last; // newNode of next point again last 
        return last;
    }

    // addFirst
    static Node addFirst(Node last, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        Node newNode = new Node(); //create new Node
        newNode.data = data; //Assign data in newNode
        newNode.next = last.next; // newNode move one step to the last of next
        last.next = newNode;// to make last of next node using newNode
        return last;
    }

    // addEnd
    static Node addLast(Node last, int data){
        if(last == null){
            return addToEmpty(last, data);
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    // addAfter
    static Node addAfter(Node last, int data, int item){
        if(last == null){
            return null;
        }

        Node newNode = new Node();
        Node temp = last.next;
        do {
            if(temp.data == item){
                newNode = new Node();
                newNode.data = data;
                newNode.next = temp.next;
                temp.next = newNode;
                if(temp == last){
                    last = newNode;
                    return last;
                }
            }
            temp = temp.next;
        }while(temp != last.next);{
            System.out.print(item + "The given node is not present in the list");
            return last;
        }
    }

    // delete Node
    static Node deleteNode(Node last, int key){
        if(last == null){
            return null;
        }

        if(last.data == key && last.next == last){
            last = null;
            return last;
        }

        Node temp = last, d = new Node();
        if(last.data == key){
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }

        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }

        if(temp.next.data == key){
            d = temp.next;
            temp.next =d.next;
        }

        return last;
    }

    // Print LL
    static void print(Node last){
        if(last == null){
            System.out.println("LL is Empty");
            return;
        }

        Node temp = last.next;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while(temp != last.next);
    }

    public static void main(String[] args) {
        Node last = null;
        last = addToEmpty(last, 6);
        last = addLast(last, 8);
        last = addFirst(last, 2);
        last = addAfter(last, 10, 2);
        print(last);
        deleteNode(last, 8);
        print(last);

    }
}