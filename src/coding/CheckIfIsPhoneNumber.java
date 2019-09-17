package coding;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressWarnings("unused")
public class CheckIfIsPhoneNumber {
	public static String isPhoneRegexp()
    {
        String regexp = "1\\d{10}";
        return regexp;
    }
    
    /**
     * 从dataStr中获取出所有的电话号码（固话和移动电话），将其放入Set
     * @param dataStr    待查找的字符串
     * @param phoneSet    dataStr中的电话号码
     */
    public static void getPhoneNumFromStrIntoSet(String dataStr,Set<String> phoneSet)
    {
        //获得固定电话和移动电话的正则表达式
        String regexp = isPhoneRegexp();
        Pattern pattern = Pattern.compile(regexp); 
        Matcher matcher = pattern.matcher(dataStr); 
        //找与该模式匹配的输入序列的下一个子序列
        while (matcher.find()) 
        { 
            //获取到之前查找到的字符串，并将其添加入set中
            System.out.print(matcher.group());
            System.out.print("\",\"地址\":[");
            dataStr= dataStr.replace(matcher.group(),"");//去掉手机号
            String ss= CheckAddress.addressResolution(dataStr).toString();
            ss=ss.replace("{", "");
            ss=ss.replace("=", "");
            ss=ss.replace("}", "");
            ss=ss.replace("province","");
            ss=ss.replace("town","");
            ss=ss.replace("city","");
            ss=ss.replace("district","");
            ss=ss.replace("village","");
            ss=ss.replace(",","\",\"");
            ss=ss.replace(" ","");
            System.out.print("\"");
            System.out.print(ss);
            System.out.print("\"");
	        //System.out.print(CheckAddress.addressResolution(dataStr));//打地址
        } 
        //System.out.println(phoneSet);
    }
}
