package my.fore_end.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import my.common.entity.Product;
import my.common.enums.ProdStatus;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.fore_end.dao.ReleaseProdDao;
import my.fore_end.dao.UserDao;

import my.fore_end.service.ReleaseProdService;
@Service
public class ReleaseProdServiceImpl implements ReleaseProdService{
	@Resource
	private UserDao userDao;
	@Resource
	private ReleaseProdDao shelveDao;
	
	public Integer saveProdObject(Product product, String userName) {
		int uId = userDao.findIdbyUserName(userName);
		product.setuId(uId);
		product.setBeginDate (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		product.setEndDate (DateTransformUtils.TimestampToString (DateUtils.getNextTime (0, 3, 0,0,0,0)));
		product.setAttenNum (0);
		product.setStatus (ProdStatus.PUBLISHED.getCode ());
		product.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		shelveDao.saveProdObject(product);
		int prodId = shelveDao.findIdByProdName(product.getProdName(), uId);
		return prodId;
	}


}
