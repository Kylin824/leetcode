
#### 数组操作
- 排序：Arrays.sort(arr, (a, b) -> a - b);
- 列表转数组：list.toArray(new int[list.size()][]);

#### 数学运算
- 取整：(int) Math.floor(x)
- 开方：Math.sqrt(x)

#### 位运算
- 判断是否为2的n次方：n & (n - 1) == 0 
- 异或（不同为1）：1 ^ 0 == 1; 1 ^ 1 == 0
- 整数取最右一位：x1 = x & 1;
- 计算2的n次方：res = 1 << n; // 把1左移n位

#### 栈操作
- Stack<T> stack = new Stack<>();
- stack.push(x);
- x = stack.pop();

#### 队列操作
- Queue<T> queue = new LinkedList<>();
- queue.offer(x);
- x = queue.poll();
- 优先队列 PriorityQueue<Integer> pq = new PriorityQueue<>(); // 默认小根堆or大根堆？