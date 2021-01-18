package top.lconcise.practice.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
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

        doubleList.stream().forEach(System.out::println);

        /**
         *  java8对Comparator 增加了reversed 结果反转
         */
        Comparator<Double> comparator = Double::compareTo;
        doubleList.sort(comparator.reversed());

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
        Stream.iterate(1, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("段奕宏",27,"汉族"));
        projectList.add(new Project("邓超",28,"汉族"));
        projectList.add(new Project("成龙",29,"满族"));
        projectList.add(new Project("孙俪",30,"藏族"));

        // 终端操作：分组
        Map<String, List<Project>> map = projectList.stream().collect(Collectors.groupingBy(Project::getNation));

        map.values().stream().forEach(value->{

        });
    }

    /**
     * Java8流： https://www.yuque.com/pig4cloud/pig/yewg8z#02225aab
     *
     */
}
