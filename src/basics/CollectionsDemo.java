package basics;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Saravanan");
        names.add("Vignesh");
        names.add("Viji");
        System.out.println("ArrayList : ");
        System.out.println(names);

        Set<Integer> nums = new HashSet<>();
        nums.add(7);
        nums.add(5);
        nums.add(7);
        System.out.println("HashSet : ");
        System.out.println(nums);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Saravanan", 100);
        scores.put("Vignesh", 97);
        scores.put("Viji", 100);
        System.out.println("HashMap : ");
        System.out.println(scores);

        Queue<String> queue = new LinkedList<>();
        queue.add("Task 1");
        queue.add("Task 2");
        queue.add("Task 3");
        System.out.println("Queue : ");
        System.out.println(queue);

        Stack<Integer> stack = new Stack<>();
        stack.add(20);
        stack.add(30);
        System.out.println("Stack : ");
        System.out.println(stack);
    }
}
