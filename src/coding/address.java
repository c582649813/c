package coding;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused")
public class address {
    /**
     * 从dataStr中获取出所有的电话号码（固话和移动电话），将其放入Set
     * @param dataStr    待查找的字符串
     * @param phoneSet    dataStr中的电话号码
     */
	 public static Set<String> getPhoneNumFromFile(String filePath)
	  {
	    Set<String> phoneSet = new HashSet<String>();
	    try
	    {
	      String encoding = "UTF-8";
	      File file = new File(filePath);
	      if (file.isFile() && file.exists())
	      { // 判断文件是否存在
	        InputStreamReader read = new InputStreamReader(
	            new FileInputStream(file), encoding);// 考虑到编码格
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	        while ((lineTxt = bufferedReader.readLine()) != null)
	        {
	          //读取文件中的一行，将其中的电话号码添加到phoneSet中
	          CheckIfIsPhoneNumber.getPhoneNumFromStrIntoSet(lineTxt, phoneSet);
	        }
	        read.close();
	      }
	      else
	      {
	        System.out.println("找不到指定的文件");
	      }
	    }
	    catch (Exception e)
	    {
	      System.out.println("读取文件内容出错");
	      e.printStackTrace();
	    }
	    return phoneSet;
	  }
	 public static void main(String argv[])
	 {
	   String filePath = "D:\\java\\three.txt";	
	   Set<String> phoneSet = getPhoneNumFromFile(filePath);
	   System.out.println(phoneSet);
	 }
}
