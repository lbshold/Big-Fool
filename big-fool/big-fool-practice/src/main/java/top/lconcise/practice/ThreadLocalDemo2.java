package top.lconcise.practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liusj
 * @date 2020/11/18
 */
public class ThreadLocalDemo2 {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    public static void main(String[] args){
        System.out.println(df.get().format(new Date()));
        System.out.println(df.get().format(new Date()));
        System.out.println(df.get().format(new Date()));
    }
}
