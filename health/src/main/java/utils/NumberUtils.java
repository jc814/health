package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字工具类
 *
 * @author hzy
 * @date 2018/02/13
 */
public class NumberUtils {
    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    /**
     * 判断字符串是否是由数字组成（除逗号外，格式: 1,2,3,4,51,6）
     * @param target
     * @return
     */
    public static boolean isNumber (String target){
        String[] a = target.split(",");
        Matcher isNum = null;
        for(String temp : a){
            isNum = NUMBER_PATTERN.matcher(temp);
            if(!isNum.matches()){
                return false;
            }
        }
        return true;
    }
}
