package com.example.demo.demo2.sms.bean;
import java.io.Serializable;

import com.google.gson.Gson;

public class QueryOrderBean implements Serializable{

	private static final long serialVersionUID = 2540182109601488811L;
	//�̻����
	private String merchId;
	//�̻�������
	private String orderId;
	//��������
	private String settleDate;
	//ǩ��
	private String sign;
	
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getOrderId() {
		return orderId;
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
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

    @Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
