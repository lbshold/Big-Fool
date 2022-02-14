package top.lconcise.practice.stack_demo;

/**
 * 基于数组实现的顺序栈.
 *
 * @author: liusj
 * @date: 2021/12/29
 */
public class ArrayStack {
    // 数组
    private String[] items;
    // 栈中元素的个数
    private int count;
    // 栈的大小
    private int n;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈.
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        if (count == n) return false;
        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈.
     *
     * @return
     */
    public String pop() {
        // 栈为空，返回null
        if (count == 0) return null;
        // 返回下标为count-1的数组元素，并且栈中元素个数count减一
        String item = items[count - 1];
        --count;
        return item;
    }
}
