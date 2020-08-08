package data_structure.tree.binarySearchTree;

import data_structure.tree.binarySearchTree.data.Person;
import data_structure.tree.binarySearchTree.printer.BinaryTrees;

public class Main {


    public static void main(String[] args) {
        test9_predecessor();
    }


    public static void test9_predecessor(){ //TODO
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] data = {7, 4, 9, 2, 5, 8, 11,1};
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
//        System.out.println(bst.predecessor());
    }
    /** 测试 判断是否是完全二叉树**/
    public static void test8_calculateHeight(){
        // 手动填充数据
        // 如果想得到一个目标二叉树，就按层序遍历的顺序将其添加到数组中
        //        7
        //     4    9
        //   2  5  8  11
        // 1
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        Integer[] data = {7, 4, 9, 2, 5, 8, 11,1};
//        for (int i = 0; i < data.length; i++) {
//            bst.add(data[i]);
//        }

        // 随机生成数据
        for (int i = 0; i < 10; i++) {
            bst.add((int)(Math.random()*100));
        }


        BinaryTrees.println(bst);
        System.out.println(bst.levelOrderTraversal_isCompleteTree());

    }


    /** 测试计算二叉树的高度**/
    public static void test7_calculateHeight(){
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.levelOrderTraversal_calcu());
    }

    /** 测试 不依赖外界工具打印 二叉树**/
    public static void test6_toString(){
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.toString());
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

        // 中序遍历
        bst.inorderTraversal();
        System.out.println();
        // 后序遍历
        bst.postorderTraversal();

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
