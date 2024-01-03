package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Student;
import util.MybatisConnection;

public class Main05Student2Xml {
//xml : student2.xml
//namespace:xml.student2
	static final String NS="xml.student2.";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisConnection.getConnection();
		System.out.println("selectIf=============");
		Map map = new HashMap();
		map.put("height", 180);
		List<Student> li = sqlSession.selectList(NS+"selectIf",map);
		
		
		System.out.println("selectChoose==============");
		map.clear();
		map.put("height", 180);
		li = sqlSession.selectList(NS+"selectChoose",map);
        Main02Professor1Xml.print(li);
        
        
        System.out.println("selectCollection===========");
        
        List<Integer> ali = Arrays.asList(101,102);
        map.clear();
		map.put("col", "deptno1");
		map.put("datas", ali);	
		li = sqlSession.selectList(NS+"selectCollection",map);
		print(li);
	}
	public static void print(List li) {
		for (Object o: li) {
			System.out.println(o);
			
		}
	}

}
