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
     * 从dataStr中获取出所有的电话号码，将其放入Set
     * @param dataStr    待查找的字符串
     * @param phoneSet    dataStr中的电话号码
     */
	 public static Set<String> getFile(String filePath)
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
	        System.out.print("[");
	        while ((lineTxt = bufferedReader.readLine()) != null)
	        {
	          //读取文件中的一行
	        	//System.out.println(AddressUtil.addressResolutionVersion2(split[1],1));
	        	lineTxt = lineTxt.replace(".","");
	        	System.out.print("{\"姓名\":\"");
	        	int begin=0;
	        	int last=lineTxt.indexOf(",");
	        	int len=lineTxt.length();
	        	System.out.print(lineTxt.substring(begin,last));
	        	//String a=lineTxt.substring(0, lineTxt.indexOf(","));
	        	lineTxt= lineTxt.substring(last+1,len);//去掉名字
	        	System.out.print("\",\"手机\":\"");
	          CheckIfIsPhoneNumber.getPhoneNumFromStrIntoSet(lineTxt, phoneSet);//用正则提取出手机号
	          //System.out.print(CheckAddress.addressResolution(lineTxt));
		        System.out.println("]}");
	        }
	        System.out.println("]");
	        read.close();
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
	   String filePath = "D:\\java\\data.txt";	
	   Set<String> phoneSet = getFile(filePath);
	 }
}
