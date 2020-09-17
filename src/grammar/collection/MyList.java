package grammar.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 遍历 List
 * @create: 2020-07-27-22:04
 * @finish:
 **/
public class MyList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        /** Java 1.8 Lambda**/
        list.forEach(iterator->{
            System.out.println(iterator);
        });

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        for (Integer value:list){
//            System.out.println(value);
//        }
//
//        for (Iterator iterator = list.iterator(); iterator.hasNext();){
//            System.out.println(iterator.next());
//        }
//
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

    }
}
