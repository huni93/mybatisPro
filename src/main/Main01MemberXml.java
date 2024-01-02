package main;

import org.apache.ibatis.session.SqlSession;

import model.KicMember;
import util.MybatisConnection;

public class Main01MemberXml {
    static final String namespace="xml.kicmember.";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SqlSession sqlSession = MybatisConnection.getConnection();
		KicMember member = new KicMember();
		member.setEmail("edmail");
		member.setGender(1);
		member.setId("id3");
		member.setName("name01");
		member.setPass("1111");
		member.setTel("123-1234");
		member.setPicture("aaa.png");
		System.out.println(member);
		sqlSession.insert(namespace+"memberInsert",member);//kicmember.xml
		MybatisConnection.close(sqlSession);
	}

}
