package com.example.demo.demo2.sms.bean;
import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Ԥ��ֵ��ѯ�������Bean
 * @author swang
 *
 */
public class QueryMobileBean implements Serializable{

	private static final long serialVersionUID = -8514606983731648634L;
	//�̻����
	private String merchId;
	//�ֻ�����
	private String phone;
	//��ֵ
	private String parval;
	//��ֵ����1:���ѣ�2:����������Ĭ��Ϊ1��������ǩ��
	private String type;
	//ʹ�÷�Χ1:ȫ����2:ʡ�ڣ�����Ĭ��Ϊ1��������ǩ��
	private String range;
	//ǩ��
	private String sign;
	
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getParval() {
		return parval;
	}
	public void setParval(String parval) {
		this.parval = parval;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
