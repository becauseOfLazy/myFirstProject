package my;


import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import my.common.entity.LuceneObject;
import my.common.utils.LuceneUtil;
import my.fore_end.dao.ProdDao;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})  
public class BaseTest{
	@Resource  
  private ProdDao prodDao;  
  @Test  
  public void testLucene() {  
      List<LuceneObject> lists = prodDao.toGetAllLuceneObject ();
      try {
				//LuceneUtil.index (lists);
				List<Integer> ids = LuceneUtil.search ("联想");
				System.out.println (ids);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
  }  
    
} 