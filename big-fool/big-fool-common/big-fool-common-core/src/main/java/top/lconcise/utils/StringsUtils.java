package top.lconcise.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liusj on 2019/4/17
 */
public class StringsUtils {

    /**
     * List<Long> convert String.
     *
     * @param longLists List<Long>
     * @return String   example:"1,2,3,4"
     */
    public static String LongListToString(List<Long> longLists) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, length = longLists.size(); i < length; i++) {
            if (i == length - 1) {
                stringBuilder.append(longLists.get(i));
            } else {
                stringBuilder.append(longLists.get(i)).append(",");
            }
        }

        return stringBuilder.toString();
    }

    /**
     * String convert List<Long>.
     *
     * @param str example:"1,2,3,4"
     * @return List<Long>  List<Long>
     */
    public static List<Long> StringToLongList(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return new ArrayList<>();
        }
        return Arrays.asList(str.split(","))
                .parallelStream()
                .map(a -> Long.parseLong(a.trim()))
                .collect(Collectors.toList());
    }

    /**
     * 修改字符串.
     *
     * @param targetStr
     * @param subtract
     * @return example: "1,2,3,4,5,6,7,8,9,10" 去除"10"  返回 "1,2,3,4,5,6,7,8,9"
     */
    public static String subtractSting(String targetStr, String subtract) {
        if (targetStr.length() == (targetStr.indexOf(subtract) + subtract.length())) {
            return targetStr.substring(0, targetStr.indexOf(subtract) - 1);
        } else {
            return targetStr.replace(subtract + ",", "");
        }
    }
}
