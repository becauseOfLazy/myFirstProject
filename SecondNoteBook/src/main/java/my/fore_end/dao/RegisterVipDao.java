package my.fore_end.dao;

import org.apache.ibatis.annotations.Param;
import my.common.entity.MobilePhoneCode;
import my.common.entity.UserDetail;


public interface RegisterVipDao {
		/**
		 * 修改用户角色
		 * method comments here
		 * @param uId
		 * @return
		 */
		public int updateUserRole(@Param("uId")Integer uId);
		/**
		 * 保存用户个人信息
		 * @param 
		 * @return
		 */
		public int saveUserDetailObject(@Param("entity")UserDetail userDetail);
		/**
		 * 保存手机短信验证码
		 * method comments here
		 * @param code
		 * @return
		 */
		public int savePhoneCodeObject(@Param("entity")MobilePhoneCode code);
		/**
		 * 查询验证码
		 * method comments here
		 * @param uuId
		 * @param phoneNumber
		 * @return
		 */
		public String getPhoneCodeMsg(@Param("uuId")String uuId,@Param("phoneNumber")String phoneNumber);
		
}
