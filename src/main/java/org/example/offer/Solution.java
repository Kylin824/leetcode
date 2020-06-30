package org.example.offer;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] p1 = new int[num];
        int[] p2 = new int[num];
        for (int i = 0; i < num; i++) {
            p1[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            p2[i] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            System.out.print(p1[i] + " ");
        }



    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ptr = listNode;
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }

        ArrayList<Integer> newList = new ArrayList<>();
        for (int i=list.size() - 1; i>=0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public int Fibonacci(int n) {
        if (n > 39) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int root_val = pre[0];
        TreeNode root = new TreeNode(root_val);
        // 只有一个节点则为叶节点
        if (pre.length == 1 && in.length == 1) {
            root.left = null;
            root.right = null;
            return root;
        }
        // 不止一个节点，则找到根节点 在in中的位置
        int i = 0;
        for (; i<in.length; i++) {
            if (root_val == in[i]) {
                break;
            }
        }
        // 无左子树
        if (i<=0) {
            root.left = null;
            int[] right_pre = Arrays.copyOfRange(pre, i+1, pre.length);
            int[] right_in = Arrays.copyOfRange(in, i+1, pre.length);
            root.right = reConstructBinaryTree(right_pre, right_in);
        }
        // 无右子树
        else if(i>=in.length-1){
            root.right = null;
            int[] left_pre = Arrays.copyOfRange(pre, 1, i+1);
            int[] left_in = Arrays.copyOfRange(in, 0, i);
            root.left = reConstructBinaryTree(left_pre, left_in);
        }
        // 两边都有
        else {
            int[] left_pre = Arrays.copyOfRange(pre, 1, i+1);
            int[] left_in = Arrays.copyOfRange(in, 0, i);
            int[] right_pre = Arrays.copyOfRange(pre, i+1, pre.length);
            int[] right_in = Arrays.copyOfRange(in, i+1, pre.length);
            TreeNode left_root = reConstructBinaryTree(left_pre, left_in);
            TreeNode right_root = reConstructBinaryTree(right_pre, right_in);
            root.left = left_root;
            root.right = right_root;
        }
        return root;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (k <= 0) {
            return null;
        }

        int count = 1;
        ListNode ptr = head;
        ListNode tmp = head;

        // 先走k步
        while (ptr != null && count < k) {
            count++;
            ptr = ptr.next;
        }

        // k步还没到 就已经到结尾 说明k超过长度了 即 k>list.size()
        if (ptr == null) {
            return null;
        }

        // 从第k步开始  快慢指针一起走  走到结尾  慢指针指向的就是倒数第k个
        while (ptr.next != null) {
            tmp = tmp.next;
            ptr = ptr.next;
        }
        return tmp;
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        newHead.next = null;
        ListNode ptr = head.next;
        while (ptr != null) {
            ListNode listNode = new ListNode(ptr.val);
            // 头插法
            listNode.next = newHead;
            newHead = listNode;
            ptr = ptr.next;
        }
        return newHead;
    }

    /**
     * 调整数组位置使奇数位于偶数前面，且奇数与奇数，偶数与偶数相对位置不变
     * @param array
     */
    public void reOrderArray(int [] array) {
        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();

        for (int i=0; i<array.length; i++) {
            if (array[i] % 2 != 0) {
                oddList.add(array[i]);
            }
            else {
                evenList.add(array[i]);
            }
        }
        int j=0;
        for (; j<oddList.size(); j++) {
            array[j] = oddList.get(j);
        }
        for (j=0; j<evenList.size(); j++) {
            array[oddList.size()+j] = evenList.get(j);
        }
    }

    /**
     * 求base的exponent次方
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = 1.0;
        if (exponent == 0) {
            return 1.0;
        }

        for (int i=0; i<Math.abs(exponent); i++) {
            result *= base;
        }

        if (exponent > 0) {
            return result;
        } else {
            return 1/result;
        }
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表（单调不减）
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {

        // list1或list2可能为空
        if (list1 != null && list2 == null) {
            return list1;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 == null && list2 == null) {
            return null;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode head = null;

        // 建头节点
        if (p1.val <= p2.val) {
            head = new ListNode(p1.val);
            p1 = p1.next;
        } else {
            head = new ListNode(p2.val);
            p2 = p2.next;
        }

        ListNode list = head;

        // 遍历直到p1最后一个值  或 p2 最后一个值
        while (p1!=null && p2!=null) {
            if (p1.val <= p2.val) {
                list.next = new ListNode(p1.val);
                list = list.next;
                p1 = p1.next;
            } else {
                list.next = new ListNode(p2.val);
                list = list.next;
                p2 = p2.next;
            }
        }

        // 剩余的直接加入链表
        if (p1 != null) {
            list.next = p1;
        } else if (p2 != null){
            list.next = p2;
        }

        return head;
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构（约定空树不是任意一个树的子结构)
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        ArrayList<Integer> root1List = new ArrayList<>();
        PreOrderTraverse(root1, root1List);
        ArrayList<Integer> root2List = new ArrayList<>();
        PreOrderTraverse(root2, root2List);

        String strA = ArrayListToString(root1List).toString();
        String strB = ArrayListToString(root2List).toString();

        if (strA.indexOf(strB) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 前序遍历二叉树并生成前序序列
     * @param root
     * @param preList
     */
    public void PreOrderTraverse(TreeNode root, ArrayList<Integer> preList) {
        preList.add(root.val);
        if (root.left != null) {
            PreOrderTraverse(root.left, preList);
        }
        if (root.right != null) {
            PreOrderTraverse(root.right, preList);
        }
    }

    /**
     * 二叉树前序序列转为字符串
     * @param list
     * @return
     */
    public StringBuffer ArrayListToString(ArrayList<Integer> list) {
        StringBuffer str = new StringBuffer();
        for (Integer i : list) {
            str.append(i+"");
        }
        return str;
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 即层序遍历二叉树
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        // 新建队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        TreeNode p = null;
        while(queue.peek()!=null) {
            p = queue.poll();
            if (p.left!=null) {
                queue.offer(p.left);
            }
            if (p.right!=null) {
                queue.offer(p.right);
            }
            list.add(p.val);
        }
        return list;

    }

    /**
     * 替换字符串中的空格
     * @param str
     */
    public void ReplaceSpace(String str) {
//        String str = "we are happy";
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                out.append("%20");
            } else {
                out.append(str.charAt(i));
            }
        }
        System.out.println(out.toString());
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        Integer value = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : array) {
            value = map.get(item);
            if (value == null) {
                map.put(item, 1);
            } else {
                map.put(item, value + 1);
            }
        }
        int index = 0;
        Set<Integer> keys = map.keySet();
        for (Integer i : keys) {
            if (map.get(i)*2 >= array.length) {
                index = i;
                return index;
            }
        }
        return index;
    }

    /**
     * 判断该数组是不是某二叉搜索树的后序遍历
     * 另一种思路是后序转中序，然后判断数组是否递增
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i=0;
        for (; i<length; i++) {
            if (sequence[i] >= root) {
                break;
            }
        }
        // 此时i为左子树的根节点位置
        for (int j = i; j<length; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i>0) {
            int[] leftSeq = Arrays.copyOfRange(sequence, 0, i);
            // 判断左子树
            left = VerifySquenceOfBST(leftSeq);
        }

        boolean right = true;
        if (i<length-1) {
            int[] rightSeq = Arrays.copyOfRange(sequence, i, length-1);
            // 判断右子树
            right = VerifySquenceOfBST(rightSeq);
        }

        return left && right;
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<Integer>();

    /**
     * 二叉树中结点值的和为输入整数的所有路径
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return res;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<Integer>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size()-1);
        return res;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。
     * 堆排序，建小根堆，然后调整k次
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if(input==null || input.length<=0 || input.length<k){
            return list;
        }

        // 建小根堆
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            minHeapAdjust(input, i, input.length);
        }
        int tmp = 0;
        for (int j = input.length - 1; j >= 0 && k > 0; j--) {
            // 交换堆头节点和堆尾节点
            tmp = input[0];
            input[0] = input[j];
            input[j] = tmp;

            list.add(input[j]);
            k--;
            //调整剩下的堆
            minHeapAdjust(input, 0, j);
        }

        return list;
    }

    /**
     * 建小根堆
     * @param input
     * @param s
     * @param m
     */
    public void minHeapAdjust(int[] input, int s, int m) {
        // 根节点为 s
        int root = input[s];
        for (int j = 2 * s + 1; j < m; j = j * 2 + 1) {
            // 比较左右子节点的大小， 用 j 定位到小的那个值
            if ( j + 1 < m && input[j] > input[j+1]) {
                j++;
            }
            // 比较 j 与根节点 s 的值  如果比根节点还小  则不用调整， 直接跳出
            if (root < input[j]) {
                break;
            }
            // 否则交换根节点， 然后以i为根节点继续调整
            else {
                input[s] = input[j];
                s = j;
            }
        }
        input[s] = root;
    }

    /**
     * 找到字符串中第一个只出现一次的字符,并返回它的位置
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {

        if (str == null) {
            return -1;
        }

        char[] charArray = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for(int i = 0;i<charArray.length;i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列组合（字符可能重复）
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() <= 0) {
            return list;
        }
        else {
            permutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    public void permutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        }
        else {
            Set<Character> charSet = new HashSet<>();
            for (int j=i; j<chars.length; j++) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    permutationHelper(chars, i+1, list);
                    swap(chars, j, i);
                }
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    /**
     * 找出数组中任意一个重复的数字
     * 有一个特殊条件：所有数字都在0到n-1的范围内
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        int val = 0;
        for (int i=0; i<numbers.length; i++) {
            val = numbers[i];
            if (val >= numbers.length) {
                val = val - numbers.length;
            }
            if (numbers[val] > numbers.length) {
                duplication[0] = val;
                return true;
            } else {
                numbers[val] = numbers[val] + length;
            }
        }
        return false;
    }

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);

        if (firstK == -1 || lastK == -1) {
            return 0;
        }
        return lastK - firstK + 1;
    }

    public int getFirstK(int[] array, int k, int low, int high) {
        int mid = (high - low) / 2;
        while (low <= high) {
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] == k) {
                if (mid == low || array[mid-1] !=k) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int getLastK(int[] array, int k, int low, int high) {
        int mid = (high - low) / 2;
        while (low <= high) {
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] == k) {
                if (mid == high || array[mid+1] !=k) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public String PrintMinNumber(int [] numbers) {
        int n;
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>(){

            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s.append(j);
        }
        return s.toString();
    }
}
