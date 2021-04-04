package HashMap_Questions.HashMap_Implementation;

public class Main {
    public static void main(String[] args) {
        HMap<Integer, Integer> map = new HMap<>();
        map.put(10, 10);
        map.put(30, 10);
        map.put(50, 7);
        map.put(47, 3);
        System.out.println(map);
        map.put(20, 40);
        map.put(500, 10);
        map.put(40, 10);
        map.put(890, 7);
        map.put(65, 3);
        map.put(220, 40);
//        System.out.println(map.get(47));
//        map.remove(47);
//        System.out.println(map.keySet());
        System.out.println(map);
    }
}
