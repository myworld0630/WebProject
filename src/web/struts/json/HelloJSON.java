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

	private Current myCurrent; // = new Current(); �o��ܯ��_�A�Y�ϨS���� myCurrent ����l�ơA�e�ݶǨ��ݤ]�|�۰ʹ� myCurrent ����l�ƪ��ʧ@
	
	private String jsonResult; // �w�q�@�� String ����Ψӧ� json �r��Ǩ�e��

	public String HelloJsonAJAX() {

		System.out.println("[HelloJsonAJAX] �e�ݶǻ�����ݪ��Ѽ� current.id is " + myCurrent.getId());
		
		try {

			List<KeyValue> myList = new ArrayList<KeyValue>();
			KeyValue obj_1 = new KeyValue("key1", "value1");
			KeyValue obj_2 = new KeyValue("key2", "value2");
			KeyValue obj_3 = new KeyValue("key3", "value3");
			myList.add(obj_1);
			myList.add(obj_2);
			myList.add(obj_3);

			Map<String, Object> myMap = new HashMap<String, Object>();
			myMap.put("success", false);	//�� JSONUtil �ǦC�Ƴ�@����
			myMap.put("myList", myList);	//�� JSONUtil �ǦC�ƶ��X����
			myMap.put("success", true);

			setJsonResult(JSONUtil.serialize(myMap));	//�N���X����ǦC�Ʀ����@�� String ���� JSONUtil �w�]�w�g�b struts2-json-plugin.jar �M�󤤡A�i�H�����ϥ�
			
			Thread.sleep(5000); //�G�N�� 5 ��Y��D�P�B���ĪG
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;	//�o�̤��M�O return SUCCESS�A�ӫD�ǦC�ƫ᪺ JSON �r��
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
