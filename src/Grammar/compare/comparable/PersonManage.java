package Grammar.compare.comparable;

import Grammar.compare.comparaor.Comparator;
import Grammar.compare.comparaor.Person;

/**
 * @description: 要求用户的数据 的类型E 必须实现  Comparable 接口
 * @create: 2020-07-19-10:10
 * @finish:
 **/
public class PersonManage<E extends Comparable> {
    /**
     *  用 E 自己实现的比较函数进行比较
     * @param e1
     * @param e2
     * @return
     */
    public int compare(E e1, E e2){
        return e1.compareTo(e2);
    }
}
