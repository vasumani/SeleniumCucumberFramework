package DailyBase;

import java.util.HashMap;
import java.util.Map;

public class HashmapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  
        HashMap<String, Integer> map = new HashMap<String, Integer>(); 
  
        print(map); 
        map.put("vishal", 10); 
        map.put("sachin", 30); 
        map.put("vaibhav", 20); 
  
        System.out.println("Size of map is:- " + map.size());
                            
          print(map); 
        if (map.containsKey("vishal")) { 
            Integer a = map.get("vishal"); 
            System.out.println("value for key"  + " \"vishal\" is:- "  + a); 
             
          } 
  
        map.clear(); 
        print(map); 
    } 
  
    public static void print(Map<String, Integer> map) 
    { 
        if (map.isEmpty()) { 
            System.out.println("map is empty"); 
        } 
  
        else { 
            System.out.println(map); 
        } 

	}

}
