package my.fore_end.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import my.common.utils.ImgUtil;
import my.common.utils.JedisUtil;
import my.fore_end.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{
		
	public List<Map<String,String>> doGetAllImgs() {
		List<Map<String,String>> lists = new ArrayList<Map<String,String>>();
		lists.add (ImgUtil.addHeadImgForMap (JedisUtil.getAllMap ("index_line1")));
		lists.add (ImgUtil.addHeadImgForMap (JedisUtil.getAllMap ("index_line2")));
		lists.add (ImgUtil.addHeadImgForMap (JedisUtil.getAllMap ("index_line3")));
		lists.add (ImgUtil.addHeadImgForMap (JedisUtil.getAllMap ("index_line4")));
		lists.add (ImgUtil.addHeadImgForMap (JedisUtil.getAllMap ("index_line5")));
		return lists;
	}
}
