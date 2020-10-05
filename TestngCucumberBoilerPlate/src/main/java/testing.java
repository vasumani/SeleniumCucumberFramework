import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testing {

	public static void parse() {
		String Value = "";
		Map<String, String> keyVal = new HashMap<String, String>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Map<String, String>> map = mapper.readValue(new File("C:\\Users\\mmeesala\\Desktop\\jsontest.json"),
					new TypeReference<Map<String, Map<String, String>>>() {
					});

					
			System.out.println("Map is " + map);

			String key = "";
			String val = "";
			for (int i = 1; i <= map.size(); i++) {
				Map<String, String> str = map.get("Details");

				for (Entry<String, String> data : str.entrySet()) {
					System.out.println("Key is " + data.getKey() + "; Value is " + data.getValue());
					key = data.getKey();
					val = data.getValue();
					keyVal.put(key, val);
				}
			}
			// Value=keyVal.get(value);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println();
		}
		
	}
	
	public static void main(String ap[])
	{
		parse();
	}
}
