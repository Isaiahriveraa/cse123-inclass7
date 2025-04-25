public class LinkedIntQueue implements IntQueue {
    private ListNode front;
    private ListNode back;

    public LinkedIntQueue(){
        front = null;
    }

    public int peek(){
        return front.data;
    }

    public int remove(){
        int first = front.data;
        front = front.next;
        if(front == null){
            back = null;
        }
        return first;
    }

    public void add(int value){
        if(front == null){
            front = new ListNode(value);
            back = front;
        } else{
            back.next = new ListNode(value);
            back = back.next;
        }
    }

    private static class ListNode {
        public final int data;
        public ListNode next;
        
        // Constructs a ListNode with the given data
        public ListNode(int data) {
            // Sets the next field to null, meaning there
            // is no next linked node.
            this(data, null);
        }
        
        // Constructs a ListNode with the given data
        // and given next node.
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
