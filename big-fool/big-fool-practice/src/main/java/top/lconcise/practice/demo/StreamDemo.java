package top.lconcise.practice.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 使用及技巧.
 *
 * @author liusj
 * @date 2020/12/18
 */
public class StreamDemo {

    public static void main(String[] args) {

        // Lambda 表达式
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(19.3);
        doubleList.add(13.3);
        doubleList.add(14.3);
        doubleList.add(15.3);
        doubleList.add(16.3);
        doubleList.add(17.3);


        /**
         *  使用Comparator对其从小到大排序
         */
        Collections.sort(doubleList, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });

        /**
         * Comparator 接口是一个函数式表达式，函数描述为(T,T)->int,
         *
         * jAVA8 可以使用Lambda改造上面的方法
         */
        Collections.sort(doubleList, (o1, o2) -> o1.compareTo(o2));

        /**
         * Java8对list 提供了sort方法，可以替代Comparator.sort()
         */
        doubleList.sort((o1, o2) -> o1.compareTo(o2));

        /**
         * 进一步优化：方法引用
         */
        doubleList.sort(Double::compareTo);

        doubleList.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();

        /**
         *  java8对Comparator 增加了reversed 结果反转
         */
        Comparator<Double> comparator = Double::compareTo;
        doubleList.sort(comparator.reversed());

        /*
         * 流的操作过程.
         *
         *
         */
        // 创建流
        // 1. 集合
        List<String> list = new ArrayList<>();
        list.stream();

        // 2. 数组
        String[] names = {"java", "python", "javascript"};
        Arrays.stream(names);

        // 3. 值
        Stream.of("java", "python", "javascript");

        // 4. 文件
        try (Stream lines = Files.lines(Paths.get("文件名称"), Charset.defaultCharset())) {
            //可对lines做一些操作
        } catch (IOException e) {
        }

        // 5. iterator
        System.out.println("5. iterator ---------");
        Stream.iterate(2, n -> n + 2)
                .limit(5)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        List<Integer> collect = Stream.iterate(1, n -> n + 1)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("size: " + collect.size());

        // 6. 筛选
        System.out.println("6. 筛选 ---------");
        Stream.of("java", "python", "javascript")
                .filter(str -> str.length() > 4)
                .forEach(str -> System.out.println(str + " "));
        // 7. distinct

        // 8. 截取
        System.out.println("8. 截取 ---------");
        Map<String, List<Integer>> numMap = Stream.iterate(1, n -> n + 1)
                .limit(10)
                .collect(Collectors.groupingBy(num -> {
                    if (num % 2 == 1) {
                        return "奇数";
                    } else {
                        return "偶数";
                    }
                }));
        numMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toArray().toString());
        });

        // 9. 跳过 skip

        // 10.映射
        /**
         * 对流中的每个元素执行一个函数，使得元素转换成另一种类型输出。
         * 流会将每一个元素输送给map函数，并执行map中的Lambda表达式，最后将执行结果存入一个新的流中。
         */
        List<String> numList = Stream.iterate(1, n -> n + 1)
                .limit(10)
                .map(String::valueOf)
                .collect(Collectors.toList());

        // 11. 合并多个流
        System.out.println("11. 合并多个流 ---------");
        List<String> strList = new ArrayList<>();
        strList.add("I am a boy");
        strList.add("I love the girl");
        strList.add("Bug the girl loves another girl");

        strList.stream()
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(str -> System.out.print(str + " "));
        System.out.println();

        // 12. 匹配
        System.out.println("12. 匹配 ---------");
        List<Integer> integers = Stream.iterate(1, n -> n + 1).limit(10).collect(Collectors.toList());
        boolean isMatch = integers.stream().allMatch(n -> {
            if (n > 5) {
                return true;
            } else {
                return false;
            }
        });
        System.out.println(isMatch);

        // 13. 归约
        System.out.println("13. 归约 ---------");
        Integer integer = Stream.iterate(1, n -> n + 1)
                .limit(5)
                .reduce(5,Integer::sum);
        System.out.println(integer);


        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("段奕宏", 27, "汉族"));
        projectList.add(new Project("邓超", 28, "汉族"));
        projectList.add(new Project("成龙", 29, "满族"));
        projectList.add(new Project("孙俪", 30, "藏族"));

        // 终端操作：分组
        System.out.println("终端操作：分组 ---------");
        Map<String, List<Project>> map = projectList.stream().collect(Collectors.groupingBy(Project::getNation));
        for (Map.Entry<String, List<Project>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().size());
        }
    }

    /**
     * Java8流： https://www.yuque.com/pig4cloud/pig/yewg8z#02225aab
     *
     */
}
