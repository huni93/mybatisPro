package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import anno.ProfessorAnno;
import model.Professor;
import model.Student;
import util.MybatisConnection;

public class Main06ProfessorAnno {

	public static void main(String[] args) {
	SqlSession sqlSession = MybatisConnection.getConnection();
	int num = sqlSession.getMapper(ProfessorAnno.class).count();
	System.out.println("1.professor count="+num);
	
	System.out.println("2.교수테이블에 등록된 모든 정보를 출력하기");
	List<Professor> li = sqlSession.getMapper(ProfessorAnno.class).list();
	
	System.out.println("3.교수중 101번 학과의 교수 정보를 출력하기");
	li = sqlSession.getMapper(ProfessorAnno.class).selectdeptno(101);
	
	Map map = new HashMap();
	map.put("name", "김");
	map.put("position", "정교수");
	
	System.out.println("4.교수중 성이 김씨인 정교수 정보를 출력하기");
	li = sqlSession.getMapper(ProfessorAnno.class).selectnameposition(map);
	
	System.out.println("5. collection을 이용한 sql");
	List<Integer> datas = Arrays.asList(101,102);
	
	map.clear();
	map.put("position","정교수");
	map.put("datas", datas);
	li = sqlSession.getMapper(ProfessorAnno.class).selectCollection(map);
	
	Main02Professor1Xml.print(li);

	}

}
