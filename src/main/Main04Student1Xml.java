package main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Student;
import util.MybatisConnection;

public class Main04Student1Xml {
	static final String NS="xml.student1.";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisConnection.getConnection();
		System.out.println("student insert========");
		Student s =new Student();
		s.setStudno(1111);
		s.setName("새로운");
		s.setGrade(1);
		s.setJumin("kic01");
		s.setId("1111111111");
		s.setMajor1(101);
		int num = sqlSession.insert(NS+"insert",s );
		//sqlSession.commit();
		List<Student> li = sqlSession.selectList(NS+"select");
		Main02Professor1Xml.print(li);
		System.out.println();
		s= new Student();
		s.setGrade(2);
		s.setWeight(60);
		s.setHeight(80);
		s.setProfno(2222);
		s.setStudno(1111);
		num = sqlSession.insert(NS+"update",s);
		li = sqlSession.selectList(NS+"selectRMap");
		Main02Professor1Xml.print(li);
		
		System.out.println("delete=========");
		num = sqlSession.insert(NS+"delete",1111);
		li = sqlSession.selectList(NS+"selectRMap");
		Main02Professor1Xml.print(li);
				

	}
	public static void print(List li) {
		for (Object o: li) {
			System.out.println(o);
			
		}
	}

}
