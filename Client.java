public class Client {
    public static void main(String[] args) {
        int[] nums = {8, 6, 7, 5, 3, 0, 9};
        ArrayIntList list = new ArrayIntList(nums);
        System.out.println(list);

        list.add(100);
        list.add(0, -50);
        System.out.println(list);

        list.remove(7);
        System.out.println(list);

        System.out.println(list.indexOf(3));
    }
}
