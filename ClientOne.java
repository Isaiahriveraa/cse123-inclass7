public class ClientOne {
    public static void main(String[] args){
        IntQueue queue = new LinkedIntQueue();
        // IntQueue queue = new ArrayIntQueue();
        for(int i = 0; i < 10; i++){
            queue.add(i);
        }
        System.out.println(queue.peek());
        for(int i = 0; i < 10; i++){
            System.out.println(queue.remove());
        }
    }
}
