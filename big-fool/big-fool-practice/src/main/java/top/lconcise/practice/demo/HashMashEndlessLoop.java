package top.lconcise.practice.demo;

import java.util.HashMap;

/**
 * HashMap(JDK7) 死链.
 * <p>
 * 启动10万个线程，以System.nanoTime()返回的Long值为Key,自定义对象EasyCoding为Value,运行环境是JDK7。
 *
 * @author liusj
 * @date 2020/12/11
 */
public class HashMashEndlessLoop {

    private static HashMap<Long, EasyCoding> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            (new Thread() {
                @Override
                public void run() {
                    map.put(System.nanoTime(), new EasyCoding());
                }
            }).start();
        }
    }
}

class EasyCoding {
}
