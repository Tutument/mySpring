package com.example.demo.demo2.sms.util;

import com.example.demo.demo2.sms.bean.QueryMobileBean;
import com.example.demo.demo2.sms.bean.QueryOrderBean;
import com.example.demo.demo2.sms.bean.TopupOrderBean;

/**
 * ǩ��������
 *
 */
public class SignUtil {

	/**
	 * ��ȡ ��Ԥ��ֵ��ѯ�ӿڡ���ǩ��
	 * MD5(merchId+phone+parval+key)
	 * @param bean
	 * @param key
	 * @return
	 */
	public static String getQueryMobileSign(QueryMobileBean bean, String key){
		StringBuffer bf = new StringBuffer();
		bf.append(bean.getMerchId())
		.append(bean.getPhone())
		.append(bean.getParval())
		.append(key);
		return new MD5().getMD5ofStr(bf.toString()); 
	}
	
	/**
	 * ��ȡ ���µ��ӿڡ���ǩ��
	 * ���ѣ�MD5(merchId+orderId+settleDate+phone+parval+key)
	 * ������MD5(merchId+orderId+settleDate+phone+parval+range+key)
	 * @param bean
	 * @param key
	 * @return
	 */
	public static String getTopupOrderSign(TopupOrderBean bean, String key){
		StringBuffer bf = new StringBuffer();
		bf.append(bean.getMerchId())
		.append(bean.getOrderId())
		.append(bean.getSettleDate())
		.append(bean.getPhone())
		.append(bean.getParval())
		.append(bean.getRange() == null ? "" : bean.getRange())
		.append(key);
		return new MD5().getMD5ofStr(bf.toString()); 
	}
	
	/**
	 * ��ȡ ��������ѯ����ǩ��
	 * MD5(merchId+orderId+settleDate+key)
	 * @param bean
	 * @param key
	 * @return
	 */
	public static String getQueryOrderSign(QueryOrderBean bean, String key){
		StringBuffer bf = new StringBuffer();
		bf.append(bean.getMerchId())
		.append(bean.getOrderId())
		.append(bean.getSettleDate())
		.append(key);
		return new MD5().getMD5ofStr(bf.toString()); 
	}
	
	/**
	 * ǩ��У��
	 * @param srcData 	ǩ��ԭ��
	 * @param sgin		ǩ������
	 * @param key		��Կ
	 * @return
	 */
	public boolean MD5Verify(String srcData, String sgin, String key) {
		String _crpy = MD5Sign(srcData, key);
		return _crpy.equals(sgin);
	}

	/**
	 * ��ȡǩ��
	 * @param srcData	ǩ��ԭ��
	 * @param key		��Կ
	 * @return
	 */
	public String MD5Sign(String srcData, String key) {
		return new MD5().getMD5ofStr(srcData+key);
	}
}
