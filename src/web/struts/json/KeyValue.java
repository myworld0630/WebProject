package web.struts.json;

import java.io.Serializable;

//JSONUtil 裡面的類別一定要是 public，不然會出現下面的錯誤訊息，很神奇，所以只好另外再寫在另一個 class 中
//Class org.apache.struts2.json.JSONWriter can not access a member of class web.struts.json.KeyValue with modifiers "public"

public class KeyValue implements Serializable{ //有沒有 implements Serializable 都可以使用 JSONUtil 序列化

	private Object key;
	private Object value;
	
	KeyValue(Object key, Object value) {
		this.key=key;
		this.value=value;
	}
	
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}