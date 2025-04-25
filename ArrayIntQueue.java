public class ArrayIntQueue implements IntQueue {

    private int size;
    private int[] elementData;

    public ArrayIntQueue(){
        this.size = 0;
        this.elementData = new int[10];
    }

    public int peek(){
        if(size == 0){
            throw new IllegalStateException("cannot peek from an empty queue!");
        }
        return elementData[0];
    }

    public int remove(){
        if(size == 0){
            throw new IllegalStateException("cannot remove from an empty queue!");
        }
        int first = elementData[0];
        for(int i = 0; i < size-1; i++){
            elementData[i] = elementData[i+1];
        }
        size--;
        return first;
    }

    public void add(int value){
        if(size >= elementData.length){
            int[] bigger = new int[size*2];
            for(int i = 0; i < size; i++){
                bigger[i] = elementData[i];
            }
            elementData = bigger;
        }
        elementData[size] = value;
        size++;
    }

}
