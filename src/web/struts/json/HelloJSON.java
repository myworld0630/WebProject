package web.struts.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONUtil;
import com.opensymphony.xwork2.ActionSupport;

class Current{
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}


public class HelloJSON extends ActionSupport{

	private Current myCurrent; // = new Current(); 這邊很神奇，即使沒有對 myCurrent 做初始化，前端傳到後端也會自動對 myCurrent 做初始化的動作
	
	private String jsonResult; // 定義一個 String 物件用來把 json 字串傳到前端

	public String HelloJsonAJAX() {

		System.out.println("[HelloJsonAJAX] 前端傳遞給後端的參數 current.id is " + myCurrent.getId());
		
		try {

			List<KeyValue> myList = new ArrayList<KeyValue>();
			KeyValue obj_1 = new KeyValue("key1", "value1");
			KeyValue obj_2 = new KeyValue("key2", "value2");
			KeyValue obj_3 = new KeyValue("key3", "value3");
			myList.add(obj_1);
			myList.add(obj_2);
			myList.add(obj_3);

			Map<String, Object> myMap = new HashMap<String, Object>();
			myMap.put("success", false);	//讓 JSONUtil 序列化單一物件
			myMap.put("myList", myList);	//讓 JSONUtil 序列化集合物件
			myMap.put("success", true);

			setJsonResult(JSONUtil.serialize(myMap));	//將集合物件序列化成為一個 String 物件 JSONUtil 預設已經在 struts2-json-plugin.jar 套件中，可以直接使用
			
			Thread.sleep(5000); //故意睡 5 秒凸顯非同步的效果
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;	//這裡仍然是 return SUCCESS，而非序列化後的 JSON 字串
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public Current getMyCurrent() {
		return myCurrent;
	}

	public void setMyCurrent(Current myCurrent) {
		this.myCurrent = myCurrent;
	}
}
