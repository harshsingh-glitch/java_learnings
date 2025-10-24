package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(3, "Dog");
        map.put(5, "Cat");
        map.put(10, "Tiger");
        map.put(14, "Lion");
        map.put(72, "Elephant");
        map.put(5, "Tortoise");

        String animal = map.get(5);
        System.out.println(animal);

        for (Map.Entry<Integer, String> myAnimals : map.entrySet()) {

            int key = myAnimals.getKey();
            String value = myAnimals.getValue();

            System.out.println(key + ": " + value);
        }

    }

}
//import java.util.HashSet;
//import java.util.TreeSet;

//public class Application {
//
//    public static void main(String[] args) {
//
//        // HashSet<String> test1 = new HashSet<String>();
//        // LinkedHashSet<String> test1 = new LinkedHashSet<String>();
//        TreeSet<String> test1 = new TreeSet<String>();
//
//        if (test1.isEmpty()) {
//            System.out.println("Set is empty before adding the items");
//        }
//
//        test1.add("red");
//        test1.add("blue");
//        test1.add("yellow");
//        test1.add("black");
//        test1.add("grey");
//        test1.add("green");
//        test1.add("green");
//
//        if (test1.isEmpty()) {
//            System.out.println("Set is empty after adding the items");
//        }
//
//        System.out.println(test1);
//
//        for (String items : test1) {
//            System.out.println(items);
//        }
//
//        if (test1.contains("purple")) {
//            System.out.println("Contains purple");
//        }
//        if (test1.contains("blue")) {
//            System.out.println("Contains blue");
//        }
//
//        HashSet<String> test2 = new HashSet<String>();
//
//        test2.add("red");
//        test2.add("blue");
//        test2.add("yellow");
//        test2.add("black");
//        test2.add("white");
//        test2.add("beige");

//		HashSet<String> commonItems = new HashSet<String>(test1);
//		commonItems.retainAll(test2);
//		System.out.println(commonItems);

//        HashSet<String> differentItems = new HashSet<String>(test2);
//        differentItems.removeAll(test1);
//        System.out.println(differentItems);
//    }
//
//}
