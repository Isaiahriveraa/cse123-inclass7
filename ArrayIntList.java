public class ArrayIntList {
    private int[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 10;

    public ArrayIntList() {
        this.elementData = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // post: constructs an ArrayIntList from the given int[] nums
    //       constructs an empty ArrayIntList if nums is null or has a size of 0
    public ArrayIntList(int[] nums) {
        this.elementData = new int[DEFAULT_CAPACITY];
        this.size = 0;

        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                this.add(nums[i]);
            }
        }
    }    

    public void add(int value) {
        resizeCheck();
        this.elementData[size] = value;
        this.size++;
    }
    
    public void add(int index, int value) {
        boundsCheck(index);
        resizeCheck();

        for (int i = size; i > index; i--) {
            this.elementData[i] = this.elementData[i - 1];
        }
        this.elementData[index] = value;
        this.size++;
    }    

    public int get(int index) {
        boundsCheck(index);

        return this.elementData[index];
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }

        String ret = "[" + this.elementData[0];
        for (int i = 1; i < size; i++) {
            ret += ", " + elementData[i];
        }
        return ret + "]";
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (this.elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void remove(int value) {
        int index = indexOf(value);

        if (index >= 0) {
            for (int i = index; i < size - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            size--;                
        }
    }

    public int size() {
        return size;
    }
    
    private void boundsCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    private void resizeCheck() {
        if (this.size == this.elementData.length) {
            int[] newData = new int[this.elementData.length * 2];
            for (int i = 0; i < this.elementData.length; i++) {
                newData[i] = this.elementData[i];
            }
            this.elementData = newData;
        }
    }    
}
