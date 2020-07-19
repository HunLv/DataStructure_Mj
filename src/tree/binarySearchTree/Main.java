package tree.binarySearchTree;

import tree.binarySearchTree.data.Person;
import tree.binarySearchTree.printer.BinaryTrees;

public class Main {

    public static void main(String[] args) {
        test2();
    }
    /**
     * 测试 Person 数据
     */
    public static void test2(){
        Integer[] data = {7,4,9,2,5,8,11,3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length ; i++) {
            bst.add(new Person(data[i]));
        }
        BinaryTrees.println(bst);
    }
    /**
     * 测试 Integer 数据
     */
    public static void test1(){
        Integer[] data = {7,4,9,2,5,8,11,3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length ; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
    }
}
