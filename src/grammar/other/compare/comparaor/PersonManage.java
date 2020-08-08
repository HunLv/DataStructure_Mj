package grammar.other.compare.comparaor;


/**
 * @description: 按照用户个性化需求比较 Person
 * @create: 2020-07-19-10:10
 * @finish:
 **/
public class PersonManage<E>{
    private Comparator<E> comparator;

    public PersonManage() {
        this(null);
    }

    public PersonManage(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int compare(E e1, E e2){
        if (comparator != null){
            return comparator.compare(e1,e2);
        }else {
            return ((Comparable<E>)e1).compareTo(e2);
        }
    }
}
