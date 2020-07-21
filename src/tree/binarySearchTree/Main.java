package tree.binarySearchTree;

import tree.binarySearchTree.data.Person;
import tree.binarySearchTree.printer.BinaryTrees;

public class Main {

    public static void main(String[] args) {
        test5_traversal_interface();
    }

    /**
     * 测试 遍历到指定节点, 对应的方法 后缀是 _enhance
     */
    public static void test5_traversal_interface() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }
        BinaryTrees.println(bst);

        // 层序遍历 正常
        bst.levelOrder_enhance(new BinarySearchTree.Vistor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print("**"+element+"**");
                return  (element.getAge() == 4) ?true:false;
            }
        });

        System.out.println();

        // 前序遍历
        bst.preorder_enhance(new BinarySearchTree.Abstract_Vistor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print("**" + element + "**");
                return (element.getAge() == 9) ? true : false;
            }
        });
        System.out.println();

        // 中序遍历
        bst.inorder_enhance(new BinarySearchTree.Abstract_Vistor<Person>() {
            @Override
            boolean visit(Person element) {
                System.out.print("**" + element + "**");
                return (element.getAge() == 7) ? true : false; // 预期 7 以及 7 的右子树都不输出
            }
        });
        System.out.println();

        // 后序遍历
        bst.postorder_enhance(new BinarySearchTree.Abstract_Vistor<Person>() {
            @Override
            boolean visit(Person element) {
                System.out.print("**" + element + "**");
                return (element.getAge() == 8) ? true : false; // 预期 7 以及 7 的右子树都不输出
            }
        });
    }

    /**
     * 测试 用户自定义 节点处理 方法 levelOrder_flexible()
     * 如果要测试，请先恢复对应 返回值 为 void 的方法
     */
    public static void test4_traversal_interface() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }
        BinaryTrees.println(bst);

//        bst.levelOrder_flexible(new BinarySearchTree.Vistor<Person>() {
//            @Override
//            public void visit(Person element) {
//                System.out.print("**"+element+"**");
//            }
//        });
    }

    /**
     * 测试 4 种遍历方式
     */
    public static void test3_traversal() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }
        BinaryTrees.println(bst);
/*********************************************普通实现（节点处理逻辑是写死了的）*****************************************************/
//        // 前序遍历
//        bst.preorderTraversal();

//        // 中序遍历
//        bst.inorderTraversal();

//        // 后序遍历
//        bst.postorderTraversal();

//        // 层序遍历
//        bst.levelOrderTraversal();
    }

    /**
     * 测试 添加 Person 数据 到 bst
     */
    public static void test2_printPersonTree() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }
        BinaryTrees.println(bst);
    }

     /**
     * 测试 添加 Integer 数据 到 bst
     */
    public static void test1_printIntegerTree() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
    }
}
