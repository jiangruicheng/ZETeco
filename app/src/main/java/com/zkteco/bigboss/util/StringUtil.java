package com.zkteco.bigboss.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class StringUtil {
    /**
     * 判断是否为浮点数或者整数
     *
     * @param str
     * @return true Or false
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否为正确的邮件格式
     *
     * @param str
     * @return boolean
     */
    public static boolean isEmail(String str) {
        if (isEmpty(str))
            return false;
        return str.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
    }

    /**
     * 判断字符串是否为合法手机号 11位 13 14 15 18开头
     *
     * @param str
     * @return boolean
     */
    public static boolean isMobile(String str) {
        if (isEmpty(str))
            return false;
        /*return str.matches("^(13|14|15|18)\\d{9}$");*/
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        return str.matches(telRegex);

    }

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    /**
     * 判断字符串是否为非空(包含null与"")
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if (str == null || "".equals(str))
            return false;
        return true;
    }

    /**
     * 判断字符串是否为非空(包含null与"","    ")
     *
     * @param str
     * @return
     */
    public static boolean isNotEmptyIgnoreBlank(String str) {
        if (str == null || "".equals(str) || "".equals(str.trim()))
            return false;
        return true;
    }

    /**
     * 判断字符串是否为空(包含null与"")
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str))
            return true;
        return false;
    }

    /**
     * 判断字符串是否为空(包含null与"","    ")
     *
     * @param str
     * @return
     */
    public static boolean isEmptyIgnoreBlank(String str) {
        if (str == null || "".equals(str) || "".equals(str.trim()))
            return true;
        return false;
    }

}
