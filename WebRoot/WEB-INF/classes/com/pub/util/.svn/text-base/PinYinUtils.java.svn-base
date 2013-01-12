/**   
 * 文件名：Cn2Spell.java   
 * 日期：2010-10-20   
 * Copyright 商旅 Corporation 2010    
 * 版权所有   
 *   
 */
package com.pub.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


/**   
 *    
 * 项目名称：flight   
 * 类名称：Cn2Spell   
 * 类描述：   
 * 创建人：HO274591   
 * 创建时间：2010-10-20 上午10:11:17   
 * 修改人：HO274591   
 * 修改时间：2010-10-20 上午10:11:17   
 * @version     *    
 */
public class PinYinUtils {
    
   private PinYinUtils(){
       
   }
    
      /**   
         * 汉字转换位汉语拼音首字母，英文字符不变   
         * @param chines 汉字   
         * @return 拼音   
         */    
         public static String converterToFirstSpell(String chines){            
             String pinyinName = "";     
             char[] nameChar = chines.toCharArray();     
             HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();     
             defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);     
             defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);     
             for (int i = 0; i < nameChar.length; i++) {     
                 if (nameChar[i] > 128) {     
                     try {     
                         pinyinName += PinyinHelper.
                         toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);     
                     } catch (BadHanyuPinyinOutputFormatCombination e) {     
                         e.printStackTrace();     
                     }     
                 }else{     
                     pinyinName += nameChar[i];     
                 }     
             }     
             return pinyinName;     
         }     
           
         /**   
         * 汉字转换位汉语拼音，英文字符不变   
         * @param chines 汉字   
         * @return 拼音   
         */    
         public static String converterToSpell(String chines){             
             String pinyinName = "";     
             char[] nameChar = chines.toCharArray();     
             HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();     
             defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);     
             defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);     
             for (int i = 0; i < nameChar.length; i++) {     
                 if (nameChar[i] > 128) {     
                     try {     
                         pinyinName += PinyinHelper.
                         toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];     
                     } catch (BadHanyuPinyinOutputFormatCombination e) {     
                         e.printStackTrace();     
                     }     
                 }else{     
                     pinyinName += nameChar[i];     
                 }     
             }     
             return pinyinName;     
         }      
}
