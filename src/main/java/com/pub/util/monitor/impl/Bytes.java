/**   
 * @Title: Bytes.java 
 * @Package com.pub.util.monitor.impl 
 * @author yangxb  
 * @date 2012-12-26 下午4:10:19 
 * @version V1.0   
 */
package com.pub.util.monitor.impl;

/** 
 * @ClassName: Bytes 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yangxb 
 * @date 2012-12-26 下午4:10:19 
 * @version 1.0 
 */
public class Bytes {  
    public static String substring(String src, int start_idx, int end_idx){  
        byte[] b = src.getBytes();  
        String tgt = "";  
        for(int i=start_idx; i<=end_idx; i++){  
            tgt +=(char)b[i];  
        }  
        return tgt;  
    }  
}
