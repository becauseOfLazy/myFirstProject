package my.fore_end.service;

import my.common.entity.MobilePhoneCode;
import my.common.entity.UserDetail;

public interface RegisterVipService {
	/**
	 * 注册vip
	 * @param name
	 * @param idCard
	 * @param phoneNumber
	 * @param userName
	 */
	void doRegistVip(UserDetail userDetail,String userName);
	/**
	 * 产生一个短信验证码
	 * method comments here
	 * @param code
	 */
	String getMobilePhoneCode(MobilePhoneCode code);
	
	/**
	 * 验证短信验证码
	 * method comments here
	 * @param phoneNumber
	 * @param code
	 */
	void toCheckPhoneCode(String phoneNumber,String code,String uuId);
}
