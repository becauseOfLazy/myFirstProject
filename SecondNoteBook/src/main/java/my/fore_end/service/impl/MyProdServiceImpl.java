package my.fore_end.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import my.common.entity.Product;
import my.common.utils.ImgUtil;
import my.common.utils.JedisUtil;
import my.fore_end.dao.MyProdDao;
import my.fore_end.dao.UserDao;

import my.fore_end.exception.ServiceException;
import my.fore_end.service.MyProdService;
@Service
public class MyProdServiceImpl implements MyProdService{
	@Resource
	private UserDao userDao;
	@Resource
	private MyProdDao myDao;
	public List<Product> doGetMyProdObject(String userName) {
		int uId = userDao.findIdbyUserName(userName);
		List<Product> lists = myDao.doGetMyProdObject(uId);
		for(Product prod : lists){
			prod.setImgUrl (ImgUtil.addHeadImg (JedisUtil.getMapValue ("prod_"+prod.getId (), "img_0").get (0)));
		}
		return lists;
	}
	public void doUpdateMyProdObject(Product product) {
		int row = myDao.doUpdateMyProdObject(product);
		if(row < 1){
			throw new ServiceException("�޸�ʧ��");
		}
	}
	public Product doGetProdInfoById(Integer id,String userName) {
		int uId = userDao.findIdbyUserName(userName);
		return myDao.doGetProdInfoById(id,uId);
	}
	
}
