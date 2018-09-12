package my.fore_end.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import my.common.entity.Images;
import my.common.entity.Product;
import my.common.utils.FtpUtils;
import my.common.utils.JedisUtil;
import my.common.utils.JsonResult;

import my.fore_end.service.ReleaseProdService;

@Controller
@RequestMapping("/fore_end/")
public class ReleaseProdController {
	@Resource
	private HttpServletRequest request;
	@Resource
	private ReleaseProdService service;
	/**
	 * 上架商品页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetReleaseProdPage.do")
	public String toGetReleaseProdPage(){
		return "fore_end/release/releaseMyProd";
	}
	
	/**
	 * 提交发布商品
	 * method comments here
	 * @param title
	 * @param prodType
	 * @param prodName
	 * @param price
	 * @param textarea
	 * @param old
	 * @param provice
	 * @param city
	 * @param phone
	 * @param person
	 * @param imgs
	 * @return
	 */
	//
	@RequestMapping("toSubmitProd.do")
	@RequiresUser
	@ResponseBody
	public JsonResult toSubmitData(Product product){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		return new JsonResult (service.saveProdObject(product, userName));
	}
	/**
	 * 上传图片
	 * method comments here
	 * @param imgs
	 * @return
	 */
	@RequestMapping("uploadImgs.do")
	@RequiresUser
	@ResponseBody
	public JsonResult uploadImgs(Images imgs){
		Map<String ,String> maps = new HashMap<String,String> ();
		saveImgToMap(imgs.getImg0 (),imgs.getId (),maps,0);
		saveImgToMap(imgs.getImg1 (),imgs.getId (),maps,1);
		saveImgToMap(imgs.getImg2 (),imgs.getId (),maps,2);
		saveImgToMap(imgs.getImg3 (),imgs.getId (),maps,3);
		saveImgToMap(imgs.getImg4 (),imgs.getId (),maps,4);
		saveImgToMap(imgs.getImg5 (),imgs.getId (),maps,5);
		saveImgToMap(imgs.getImg6 (),imgs.getId (),maps,6);
		saveImgToMap(imgs.getImg7 (),imgs.getId (),maps,7);
		String name = "prod_"+imgs.getId ();
	  JedisUtil.saveMap (name,maps);
	  JedisUtil.close ();
		return new JsonResult ();
	}

	private void saveImgToMap(MultipartFile img,int id,Map<String ,String> maps,int index) {
		if(img==null){
			return;
		}
		if (!img.isEmpty()) { 
      try { 
        String filePath = request.getSession().getServletContext().getRealPath("/") + "static/img/prodlist/prod_"+id+"/"+img.getOriginalFilename();
        System.out.println("上传图片地址为："+filePath);
        File file = new File(filePath);
        if(!file.exists()){
        	file.mkdirs();
        }
        
        img.transferTo(file); 
    
        String savePath = "ftpFile/data/images/prodlist/prod_"+id;
        System.out.println ("上传图片保存地址:"+savePath);
        String imgName = img.getOriginalFilename();
        String imgPath = filePath;
        FtpUtils.uploadFile (savePath, imgName, imgPath);
       
        String urlName = "img_"+index;
        String imgUrl = "prodlist/prod_"+id+"/"+imgName;
        maps.put (urlName, imgUrl);
      } catch (Exception e) { 
        e.printStackTrace(); 
      }
    }
	}
}
