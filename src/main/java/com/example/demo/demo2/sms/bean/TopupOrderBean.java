package com.example.demo.demo2.sms.bean;
import java.io.Serializable;

import com.google.gson.Gson;

public class TopupOrderBean implements Serializable{

	private static final long serialVersionUID = -5578713787719652140L;
	//�̻����
	private String merchId;
	//�̻�������
	private String orderId;
	//��������
	private String settleDate;
	//�ֻ�����
	private String phone;
	//��ֵ
	private String parval;
	//ʹ�÷�Χ
	private String range;
	//ǩ��
	private String sign;

    public String getOrderId() {
		return orderId;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
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
