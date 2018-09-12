package my.back_end.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;
import org.springframework.stereotype.Service;
import my.back_end.dao.ProdManageDao;
import my.back_end.service.ProdManageService;
import my.common.entity.Page;
import my.common.entity.Product;
import my.common.utils.DateTransformUtils;
import my.common.utils.DateUtils;
import my.common.utils.PageUtils;
import my.fore_end.exception.ServiceException;


@Service
public class ProdManageServiceImpl implements ProdManageService{
	@Resource
	private ProdManageDao manageDao;
	
	public Map<String,Object> dogetAllProdsObject(Page page) {
		Integer pageSize = PageUtils.PAGE_SIZE_5;
		int prodCount = manageDao.dogetAllProdNumber();
		int pageCount = (prodCount-1)/pageSize+1;
		int start = (page.getPageCurrent ()-1)*pageSize;
		page.setPageSize (pageSize);
		page.setPageCount (pageCount);
		page.setStart (start);
		List<Product> lists = manageDao.dogetAllProdsObject(page);
		if(lists==null){
			throw new ServiceException("分页查询商品对象失败");
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put ("page", page);
		map.put ("lists", lists);
		return map;
	}
	
	
	public Product doFindObjectById(Integer id) {
		return manageDao.doFindObjectById(id);
	}
	public void doUpdateObject(Product product) {
		product.setUpdateTime (DateTransformUtils.TimestampToString (DateUtils.getCurrentTime ()));
		manageDao.doUpdateObject(product);
	}

	public List<Product> doSearchProdObject(String searchName,Integer status) {
		
		return manageDao.doSearchProdObject(searchName,status);
	}


}
