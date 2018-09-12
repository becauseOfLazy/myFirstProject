package my;

import org.junit.Test;
import my.common.utils.LuceneUtil;

public class Test1 {
	@Test
	public void ttt(){
		try {
			System.out.println (LuceneUtil.search ("联想-小"));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
