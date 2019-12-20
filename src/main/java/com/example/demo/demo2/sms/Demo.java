package com.example.demo.demo2.sms;

import com.example.demo.demo2.sms.bean.QueryMobileBean;
import com.example.demo.demo2.sms.bean.QueryOrderBean;
import com.example.demo.demo2.sms.bean.TopupOrderBean;
import com.example.demo.demo2.sms.util.SignUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Demo {
	
	//�ַ�����
	private String charSet = "UTF-8";
	//�̻����
	private String merchId = "COM_TEST_MER_25";
	//�̻���Կ
	private String key = "4FA435E44BDB4FFEEBA0BF3B2409EB48";
	//�ӿڵ�ַ
	private String url = "http://10.48.171.170:8080";
	
	/**
	 * Ԥ��ֵ��ѯ
	 * @param //url
	 * @param //paraBean
	 * @throws IOException
	 */
	public void queryMobile(String mobile, String parval, String type, String range) throws IOException{
		QueryMobileBean paraBean = new QueryMobileBean();
		paraBean.setMerchId(merchId);
		paraBean.setPhone(mobile);
		paraBean.setParval(parval);
		paraBean.setType(type);
		paraBean.setRange(range);
		paraBean.setSign(SignUtil.getQueryMobileSign(paraBean, key));
		String resultjson = post(url + "/mobileBBC/bbc/queryMobile.action", paraBean.toString());
		System.out.println("���ز���: " + URLDecoder.decode(resultjson, charSet));
	}
	
	/**
	 * �����µ�
	 * @param //url
	 * @param //paraBean
	 * @throws IOException
	 */
	public void order(String merSeq, String merTime, String mobile, String parval) throws IOException{
		TopupOrderBean paraBean = new TopupOrderBean();
		paraBean.setMerchId(merchId);
		paraBean.setOrderId(merSeq);
		paraBean.setSettleDate(merTime);
		paraBean.setPhone(mobile);
		paraBean.setParval(parval);
		paraBean.setSign(SignUtil.getTopupOrderSign(paraBean, key));
		String resultjson = post(url + "/mobileBBC/bbc/order.action", paraBean.toString());
		System.out.println("���ز���: " + URLDecoder.decode(resultjson, charSet));
	}
	
	
	/**
	 * �����µ�
	 * @param //url
	 * @param //paraBean
	 * @throws IOException
	 */
	public void flowOrder(String flowMerSeq, String flowMerTime, String flowMobile, String flowParval, String flowRange) throws IOException{
		TopupOrderBean paraBean = new TopupOrderBean();
		paraBean.setMerchId(merchId);
		paraBean.setOrderId(flowMerSeq);
		paraBean.setSettleDate(flowMerTime);
		paraBean.setPhone(flowMobile);
		paraBean.setParval(flowParval);
		paraBean.setRange(flowRange);
		paraBean.setSign(SignUtil.getTopupOrderSign(paraBean, key));
		String resultjson = post(url + "/mobileBBC/bbc/flowOrder.action", paraBean.toString());
		System.out.println("���ز���: " + URLDecoder.decode(resultjson, charSet));
	}
	
	
	/**
	 * ������ѯ
	 * @param //url
	 * @param //paraBean
	 * @throws IOException
	 */
	public void queryOrder(String merSeq, String merTime) throws IOException{
		QueryOrderBean paraBean = new QueryOrderBean();
		paraBean.setMerchId(merchId);
		paraBean.setOrderId(merSeq);
		paraBean.setSettleDate(merTime);
		paraBean.setSign(SignUtil.getQueryOrderSign(paraBean, key));
		String resultjson = post(url + "/mobileBBC/bbc/queryOrder.action", paraBean.toString());
		System.out.println("���ز���: " + URLDecoder.decode(resultjson, charSet));
	}
	
	/**
	 * �������󣬽��շ��ز���
	 * @param url
	 * @param json
	 * @return
	 * @throws IOException
	 */
	private String post(String url, String json) throws IOException{
		System.out.println();
		System.out.println("�����ַ: " + url);
		System.out.println("�������: " + json);
		HttpClientParams params = new HttpClientParams();
		params.setContentCharset(charSet);
		HttpClient hc = new HttpClient();
		params.setSoTimeout(120000);
		hc.setParams(params);
		PostMethod pm = new PostMethod(url);
		pm.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charSet);
		pm.addParameter("json", json);
		String repMsg = "";
		try {
			hc.executeMethod(pm);
			repMsg = pm.getResponseBodyAsString();
		} finally {
			pm.releaseConnection();
			pm = null;
			hc = null;
		}
		return repMsg;
	}
	
	public static void main(String[] args) throws Exception{
		Demo demo = new Demo();
		
		//���ѳ�ֵ
		String mobile = "13811111111";
		String parval = "100";
		String merSeq = System.currentTimeMillis() + "";
		String merTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		demo.queryMobile(mobile, parval, "", "");
		demo.order(merSeq, merTime, mobile, parval);
		demo.queryOrder(merSeq, merTime);
		
		//������ֵ
		String flowMobile = "14782541880";
		String flowParval = "1024";
		String flowType = "2";
		String flowRange = "1";
		String flowMerSeq = System.currentTimeMillis() + "";
		String flowMerTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		demo.queryMobile(flowMobile, flowParval, flowType, flowRange);
		demo.flowOrder(flowMerSeq, flowMerTime, flowMobile, flowParval, flowRange);
		demo.queryOrder(flowMerSeq, flowMerTime);
		
	}
}
