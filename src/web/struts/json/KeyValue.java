package web.struts.json;

import java.io.Serializable;

//JSONUtil �̭������O�@�w�n�O public�A���M�|�X�{�U�������~�T���A�ܯ��_�A�ҥH�u�n�t�~�A�g�b�t�@�� class ��
//Class org.apache.struts2.json.JSONWriter can not access a member of class web.struts.json.KeyValue with modifiers "public"

public class KeyValue implements Serializable{ //���S�� implements Serializable ���i�H�ϥ� JSONUtil �ǦC��

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