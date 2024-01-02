package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Professor;
import util.MybatisConnection;

public class Main03Professor2Xml {
	static final String namespace="xml.professor2.";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SqlSession sqlSession = MybatisConnection.getConnection();
		List<Integer> datas = Arrays.asList(101,102,103);		
		Map map = new HashMap();
	//	map.put("position","정교수");
		map.put("datas",datas);
		System.out.println("select<script>=============");
		List<Professor> li = sqlSession.selectList(namespace+"select",map );
		print(li);
		
		map.clear();
	//	map.put("deptno", 103);
		map.put("profno", 1002);
		System.out.println("select all==========");
		li = sqlSession.selectList(namespace+"select",map);
		print(li);
		
		Professor p = li.get(0);
		p.setName("새로운");
		p.setPosition("임시직");
		
		int num = sqlSession.insert(namespace+"insertProfessor",p);
		sqlSession.commit();
		System.out.println(num+"=========");
		System.out.println((int)sqlSession.selectOne("xml.professor1.count"));
	}
	public static void print(List li) {
		for (Object o: li) {
			System.out.println(o);
			
		}
	}

}
