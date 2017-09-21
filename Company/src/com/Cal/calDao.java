package com.Cal;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class calDao {
Logger logger = Logger.getLogger(calDao.class);
	
	//MapperConfig.xml문서 스캔
	SqlSessionFactory sqlMapper = null; // mapperConfig 정보를 읽어들임
	
	//오라클 서버 커넥션 맺음 - commit, rollback
	SqlSession sqlSes = null;
	String resource = "Final/mybatis/MapperConfig.xml";
	
	public List<Map<String, Object>> getCalList(String emp_no) {
		List<Map<String,Object>> calList = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);; // 2byte 단위로 읽어들이는 IO 클래스 ( 입출력에서 입력과 관련 )	
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			calList = sqlSes.selectList("getCalList",emp_no);
			logger.info("size : "+calList.size());
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception : "+e.getMessage());
		}
		return calList;
	}

	public int calInsert(Map<String, Object> pMap) {
		logger.info("calInsert 호출 성공");
		int result = 0;
		try {
			Reader reader = Resources.getResourceAsReader(resource);; // 2byte 단위로 읽어들이는 IO 클래스 ( 입출력에서 입력과 관련 )	
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			result = sqlSes.insert("calInsert",pMap);
			sqlSes.commit();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception : "+e.getMessage());
		}
		return result;
	}

	public int calUpdate(Map<String, Object> pMap) {
		logger.info("calUpdate 호출 성공");
		int result = 0;
		try {
			Reader reader = Resources.getResourceAsReader(resource);; // 2byte 단위로 읽어들이는 IO 클래스 ( 입출력에서 입력과 관련 )	
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			result = sqlSes.update("calUpdate",pMap);
			sqlSes.commit();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception : "+e.getMessage());
		}
		return result;
	}

	public int calDelete(Map<String, Object> pMap) {
		logger.info("calDelete 호출 성공");
		int result = 0;
		try {
			Reader reader = Resources.getResourceAsReader(resource);; // 2byte 단위로 읽어들이는 IO 클래스 ( 입출력에서 입력과 관련 )	
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			result = sqlSes.delete("calDelete",pMap);
			sqlSes.commit();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception : "+e.getMessage());
		}
		return result;
	}
}
