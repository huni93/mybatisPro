package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Professor;
import util.MybatisConnection;

public class Main02Professor1Xml {
	static final String namespace="xml.professor1.";
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisConnection.getConnection();
		System.out.println("count=======");
		int num = sqlSession.selectOne(namespace+"count");
		System.out.println(num);
		
		System.out.println("list=========");
		List<Professor> li = sqlSession.selectList(namespace+"list");
		print(li);
		
		System.out.println("selectdeptno=============");
		li = sqlSession.selectList(namespace+"selectdeptno",103 );
		print(li);
			
		Map map = new HashMap();
		map.put("name","명");
		map.put("position","정교수");
		System.out.println("selectnameposition=============");
		li = sqlSession.selectList(namespace+"selectnameposition",map );
		print(li);
	}
	
	public static void print(List li) {
		for (Object o: li) {
			System.out.println(o);
			
		}
	}
}
