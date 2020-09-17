package data_structure.tree.threaded_binary_tree;

import data_structure.tree.threaded_binary_tree.data.Person;
import data_structure.tree.threaded_binary_tree.printer.BinaryTrees;

/**
 * @description:
 * @create: 2020-08-29-21:06
 **/
public class Main {
    public static void main(String[] args) {
//        test1_travelsal();
        test2_thread();
    }


    public static void test2_thread() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }
        System.out.println("未中序遍历线索化前:");
        BinaryTrees.println(bst);
        // 线索化
        bst.inorderTraversal();
        System.out.println("中序遍历线索化后:");
        bst.threadTraversal();


//        Node pre = null;
//        bst.inorderTraversal(new BinarySearchTree.Vistor() {
//            @Override
//            public void visit(Node currentNode) {
////检查当前节点——左指针是否为 NULL，如果是，就设置前继索引，修改左指针为 Pre，并将当前节点的左索引标志位  置为 1，
//                if (currentNode.leftChild == null) {
//                    currentNode.leftChild = pre;
//                    currentNode.Lflag = true;
//                }
////检查前一个节点—— Pre 是否存在,且右指针是否为 NULL，如果是，则设置后继索引，修改右指针为 当前指针，并将 其右索引位置为   1，
//                if (pre != null && pre.rightChild == null) {
//                    pre.rightChild = currentNode;
//                    pre.Rflag = true;
//                }
////Pre 指向当前遍历的结点，开始遍历下一个结点，
//                pre = currentNode;
//            }
//        });
//
//        // 线索化 TODO lambda 写法遇到问题
//        Node pre = null;
//        bst.inorderTraversal(
//                (Node currentNode) -> {
////检查当前节点——左指针是否为 NULL，如果是，就设置前继索引，修改左指针为 Pre，并将当前节点的左索引标志位  置为 1，
//                    if (currentNode.leftChild == null) {
//                        currentNode.leftChild = pre;
//                        currentNode.Lflag = true;
//                    }
////检查前一个节点—— Pre 是否存在,且右指针是否为 NULL，如果是，则设置后继索引，修改右指针为 当前指针，并将 其右索引位置为   1，
//                    if (pre != null && pre.rightChild == null) {
//                        pre.rightChild = currentNode;
//                        pre.Rflag = true;
//                    }
////Pre 指向当前遍历的结点，开始遍历下一个结点，
//                    pre = currentNode;
//                }
//        );
//
//        System.out.println("中序遍历线索化后:");
//        BinaryTrees.println(bst);
    }

    public static void test1_travelsal() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }
        System.out.println(bst.size());
        BinaryTrees.println(bst);

//        System.out.println("层序:");
//        bst.levelOrder_flexible(
//                (Person element) -> {
//                    System.out.print(element+" ");
//                }
//        );

//        System.out.println();
//        System.out.println("前序");
//        bst.preorderTraversal(
//                (Node node) -> {
//                    System.out.print(node.element + " ");
//                }
//        );
        System.out.println();
        System.out.println("中序");
        bst.inorderTraversal(
                (Node node) -> {
                    System.out.print(node.element + " ");
                }
        );
//        System.out.println();
//        System.out.println("后序");
//        bst.postorderTraversal(
//                (Person element) -> {
//                    System.out.print(element+" ");
//                }
//        );
    }
}
