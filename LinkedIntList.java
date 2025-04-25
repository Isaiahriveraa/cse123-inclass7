public class LinkedIntList {
    private ListNode front;
    
    // post: constructs an empty LinkedIntList
    public LinkedIntList() {
        this(null);
    }

    // post: constructs a LinkedIntList from the given int[] nums
    //       constructs an empty LinkedIntList if nums is null or has a size of 0
    public LinkedIntList(int[] nums) {
        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                this.add(i, nums[i]);
            }
        }
    }

    // post: returns the number of elements in this list
    public int size() {
        int size = 0;
        ListNode curr = front;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    // post: returns the index of the first occurence of the provided value
    //       within this list, -1 if not present
    public int indexOf(int value) {
        int index = 0;
        ListNode curr = front;
        while (curr != null) {
            if (curr.data == value) {
                return index;
            }
            index++;
            curr = curr.next;
        }
        return -1;
    }

    // post: returns a comma-separated String representation of this list
    //       surrounded by square brackets
    public String toString() {
        if (this.front == null) {
            return "[]";
        }
        String ret = "[" + this.front.data;
        ListNode curr = this.front.next;
        while (curr != null) {
            ret += ", " + curr.data;
            curr = curr.next;
        }
        return ret + "]";
    }

    // post: Adds the given value to the end of this list
    public void add(int value) {
        add(size(), value);
    }

    // post: Adds the given value at the given index of this list
    //       throws an IllegalArgumentException if the index is out of bounds
    public void add(int index, int value) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("Provided index invalid: " + index);
        }
        
        if (index == 0) {
            this.front = new ListNode(value, this.front);
        } else {
            ListNode curr = front;
            while (index != 1) {
                index--;
                curr = curr.next;
            }
            curr.next = new ListNode(value, curr.next);
        }
    }

    // post: returns the value of the element at the given int index of the list
    //       throws an IllegalArgumentException if the index is out of bounds
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Provided index invalid: " + index);
        }
        ListNode curr = front;
        while (index != 0) {
            curr = curr.next;
            index--;
        }
        return curr.data;
    }

    // post: removes the first occurence of the given value from the list.
    public void remove(int value) {
        if (this.front.data == value) {
            this.front = this.front.next;
        } else {
            ListNode curr = front;
            while (curr.next != null && curr.next.data != value) {
                curr = curr.next;
            }
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }
    }
    
    // Inner class that represents a single node containing an
    // integer value.
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
