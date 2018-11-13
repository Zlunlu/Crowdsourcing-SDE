package com.websystique.springmvc.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
	 private static SqlSessionFactory sqlSessionFactory;
	    private static Reader reader;

	    static {
	        try {
	            //mybatis�������ļ�
	            String resource = "conf1.xml";
	            //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
	            //InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
	            reader = Resources.getResourceAsReader(resource);

	            //����sqlSession�Ĺ���
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static SqlSessionFactory getInstance() {
	        return sqlSessionFactory;
	    }
	    
}
