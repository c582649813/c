package coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Spring;

@SuppressWarnings("unused")
public class CheckAddress {

	/**
     * 解析地址
     * @author 
     * @param address
     * @return
     */
    public static Map<String,String> addressResolution(String s){
        //String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        //Matcher m=Pattern.compile(regex).matcher(address);
        //Pattern p =Pattern.compile(regex);
        //Matcher m =p.matcher(s);
        //String province=null,city=null,county=null,town=null,village=null;
        //while(m.find())
        //{
        	//String group = m.group();
        	//System.out.println(group);
        	
        //}
		//return null;
    	        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<district>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
    	        Matcher m = Pattern.compile(regex).matcher(s);
    	        String province, city, district, town, village;
    	        Map<String, String> map = new HashMap<>(16);
    	        while (m.find()) {
    	            province = m.group("province");
    	            map.put("province", province == null ? "" : province.trim());
    	            city = m.group("city");
    	            map.put("city", city == null ? "" : city.trim());
    	            district = m.group("district");
    	            map.put("district", district == null ? "" : district.trim());
    	            town = m.group("town");
    	            map.put("town", town == null ? "" : town.trim());
    	            village = m.group("village");
    	            map.put("village", village == null ? "" : village.trim());
    	        }
    	        return map;
    	    }
}
