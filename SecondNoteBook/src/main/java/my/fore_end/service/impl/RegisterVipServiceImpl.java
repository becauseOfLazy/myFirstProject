package my.fore_end.service.impl;

import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import my.common.entity.MobilePhoneCode;
import my.common.entity.UserDetail;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.fore_end.dao.RegisterVipDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.RegisterVipService;

@Service
public class RegisterVipServiceImpl implements RegisterVipService{
	@Resource
	private UserDao udao;
	@Resource
	private RegisterVipDao rdao;
	public void doRegistVip(UserDetail userDetail, String userName) {
			int uId = udao.findIdbyUserName (userName);
			userDetail.setuId (uId);
			userDetail.setCreatedTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
			userDetail.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
			int row = rdao.saveUserDetailObject (userDetail);
			if(row<1){
				throw new ServiceException ("保存用户信息失败!");
			}
			row = rdao.updateUserRole (uId);
			if(row<1){
				throw new ServiceException ("更改用户角色失败!");
			}
	}
	
	public String getMobilePhoneCode(MobilePhoneCode code) {
		//设置UUID值
		String uuId = UUID.randomUUID ().toString ();
		code.setUuId (uuId);
		int row =  rdao.savePhoneCodeObject (code);
		if(row < 1){
			throw new ServiceException ("保存验证码失败");
		}
	
		return uuId;
	}

	public void toCheckPhoneCode(String phoneNumber, String code,String uuId) {
		
			String msgCode = rdao.getPhoneCodeMsg (uuId, phoneNumber);
		
			if(!code.equals (msgCode)){
				throw new ServiceException ("验证码不对!");
			}
	}

}
