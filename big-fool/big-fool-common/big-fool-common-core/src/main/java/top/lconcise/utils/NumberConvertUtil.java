package top.lconcise.utils;

/**
 * 数字转汉字-工具类.
 *
 * @author liusj
 * @date 2020/12/9
 */
public class NumberConvertUtil {

    public static final String[] S1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    public static final String[] S2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static String toChinese(String str) {
        String result = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int num = str.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                result += S1[num] + S2[n - 2 - i];
            } else {
                result += S1[num];
            }
        }
        return result;
    }

    public static String toSimpleChinese(String str) {
        StringBuffer sb = new StringBuffer();
        for (char c : str.toCharArray()) {
            sb.append(S1[Integer.parseInt(String.valueOf(c))]);
        }
        return sb.toString();
    }
}
