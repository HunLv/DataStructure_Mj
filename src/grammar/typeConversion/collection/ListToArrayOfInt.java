package grammar.typeConversion.collection;

import java.util.*;

/**
 * @description: list——>array
 * @create: 2020-07-27-23:49
 * @finish:
 **/
public class ListToArrayOfInt {
    public static void main(String[] args) {
        solution_java_8();
    }

    public static void solution_java_6() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 33));

        // 使用 toArray(T[] a) 方法
        Integer[] listArray = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listArray));
    }

    public static void solution_java_8() {
//        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 33, 44));

//        List<Integer> list = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        Vector<Integer> vector = new Vector<>();

//        Queue<Integer> queue = new LinkedList<>();
//        Queue<Integer> queue = new PriorityQueue<>();
//        Deque<Integer> queue = new LinkedList<>();
//        Deque<Integer> deque = new ArrayDeque<>();


//        Set<Integer> set = new HashSet<>();
//        Set<Integer> set = new TreeSet<>();
//        Set<Integer> set = new LinkedHashSet<>();

//        Map<Integer,String> map = new HashMap<>();
//        Map<Integer,String> map = new TreeMap<>();
//        Map<Integer,String> map = new Hashtable<>();
//        Map<Integer,String> map = new LinkedHashMap<>();



        /*
        Integer[] listArray = list
                .stream()
                .toArray(Integer[]::new);

        String[] longs = list
                .stream()
                .map(var ->String.valueOf(var))
                .toArray(String[]::new);
        int[] listArray = list
                .stream()
                .mapToInt(Integer::valueOf)
         */


//        System.out.println(Arrays.toString(listArray));
//        System.out.println(Arrays.toString(longs));
    }
}
