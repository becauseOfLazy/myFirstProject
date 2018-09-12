package my.fore_end.service;

import my.common.entity.Product;

public interface ReleaseProdService {
	/**
	 * 保存商品信息
	 * @return
	 */
	Integer saveProdObject(Product product,String userName);

}
