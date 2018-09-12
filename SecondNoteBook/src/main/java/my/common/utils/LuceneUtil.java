package my.common.utils;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import my.common.entity.LuceneObject;

/**
 * 索引工具类
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class LuceneUtil {
		public static final String INDEXPATH = "D://lucene";
		private static Directory dir;
		
		/**
		 * 获取IndexWriter实例
		 * @return
		 * @throws Exception
		 */
		public static IndexWriter getWriter()throws Exception{
			//Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
			SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
			IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
			IndexWriter writer=new IndexWriter(dir, iwc);
			return writer;
		}
		
		/**
		 * 生成索引
		 * @param indexDir
		 * @throws Exception
		 */
		public static void index(List<LuceneObject> lists)throws Exception{
			dir=FSDirectory.open(Paths.get(INDEXPATH));
			IndexWriter writer=getWriter();
			for(LuceneObject obj : lists){
				Document doc=new Document();
				doc.add(new IntField("id", obj.getId (), Field.Store.YES));
				doc.add(new TextField("name",obj.getProdName (),Field.Store.YES));
				writer.addDocument(doc); // 添加文档
			}
			writer.close();
		}
		/**
		 * 查询
		 * method comments here
		 * @param q
		 * @throws Exception
		 */
		public static List<Integer> search(String q)throws Exception{
			Directory dir=FSDirectory.open(Paths.get(INDEXPATH));
			IndexReader reader=DirectoryReader.open(dir);
			IndexSearcher search=new IndexSearcher(reader);
			
			// Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
			SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
			QueryParser parser=new QueryParser("name", analyzer);
			Query query=parser.parse(q);
			System.out.println (query);
			TopDocs hits=search.search(query, 10);
			System.out.println (hits.totalHits);
			List<Integer> ids = new ArrayList<Integer>();
			for(ScoreDoc scoreDoc:hits.scoreDocs){
				Document doc=search.doc(scoreDoc.doc);
				ids.add (Integer.parseInt (doc.get("id")));
			}
			reader.close();
			return ids;
		}
}
