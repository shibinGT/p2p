package com.qhcs.ssm.randomcode;

import java.util.Random;

/**
 * 
 *@TODO:产生随机数类
 * @author ：shibin
 *@version:2017年10月21日
 */
public class RandomCode {
	/*** 
     * 产生随机数的方法 
     *  
     * @param length 
     * @return 
     */  
    public static String getCharAndNumr(int length) {  
        if (length >= 3) {  
            String val = "";  
            Random random = new Random();  
            // t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现  
            int t0 = 0;  
            int t1 = 0;  
            int t2 = 0;  
            for (int i = 0; i < length; i++) {  
                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字  
                // 产生的是字母  
                if ("char".equalsIgnoreCase(charOrNum)) // 字符串  
                {  
                    // int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                    // //取得大写字母还是小写字母  
                    int choice = 0;  
                    if (random.nextInt(2) % 2 == 0) {  
                        choice = 65;  
                        t0 = 1;  
                    } else {  
                        choice = 97;  
                        t1 = 1;  
                    }  
                    val += (char) (choice + random.nextInt(26));  
                }  
                // 产生的是数字  
                else if ("num".equalsIgnoreCase(charOrNum)) // 数字  
                {  
                    val += String.valueOf(random.nextInt(10));  
                    t2 = 1;  
                }  
            }  
            // 用于判断是是否包括大写字母、小写字母、数字  
            if (t0 == 0 || t1 == 0 || t2 == 0) {  
                val = getCharAndNumr(length); // 不满足则递归调用该方法  
                return val;  
            }  
  
            else  
                return val;  
  
        } else {  
  
            return null;  
        }  
    }  
  
    /*** 
     * 用来处理长度不符合要求的情况 
     *  
     * @param rcs 
     * @return 
     */  
    public static String tt(String rcs) {  
        int lenth = 0;  
        java.util.Scanner sc = new java.util.Scanner(System.in);  
        String val = null;  
        if (rcs == null) {           
            lenth = sc.nextInt();  
            rcs = getCharAndNumr(lenth); // 调用随机数的方法  
            val = tt(rcs); // 递归调用字符是否符合要求  
        } else {  
            val = rcs;  
        }  
        return val;  
    }  

}
