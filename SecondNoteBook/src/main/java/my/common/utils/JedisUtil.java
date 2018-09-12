package my.common.utils;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
/**
 * redis集群工具
 * type comments here.
 * @author yryangh25016
 * @version 1.0
 * @history
 */
public class JedisUtil {
	private static JedisPoolConfig poolConfig;
	private static JedisCluster cluster;
	static{
		try{
				poolConfig = new JedisPoolConfig ();
				poolConfig.setMaxTotal(1);
				poolConfig.setMaxIdle(1);
				poolConfig.setMaxWaitMillis(1000);
				Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
				nodes.add(new HostAndPort("192.168.19.128", 7001));
				nodes.add(new HostAndPort("192.168.19.128", 7002));
				nodes.add(new HostAndPort("192.168.19.128", 7003));
				nodes.add(new HostAndPort("192.168.19.129", 7004));
				nodes.add(new HostAndPort("192.168.19.129", 7005));
				nodes.add(new HostAndPort("192.168.19.129", 7006));
				cluster = new JedisCluster(nodes, poolConfig);
		}catch(Exception e){
			e.printStackTrace ();
		}
	}
		
		public static void saveDate(String name,String value){
			cluster.set(name, value);
		} 
		public static String getDate(String name){
			return cluster.get (name);
		}
		public static void saveMap(String name,Map<String,String> map){
			cluster.hmset (name, map);
		}
		public static Map<String,String> getAllMap(String name){
			return cluster.hgetAll (name);
		}
		public static List<String> getMapValue(String name,String mapKey){
			
			return cluster.hmget (name, mapKey);
		}
		
		public static void close(){
			if(cluster!=null){
				try {
					cluster.close ();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
