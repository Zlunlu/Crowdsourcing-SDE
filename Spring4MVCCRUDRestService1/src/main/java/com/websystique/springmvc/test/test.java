package com.websystique.springmvc.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.websystique.springmvc.CStable.*;
import com.websystique.springmvc.CStable_interface.*;
import com.websystique.springmvc.CStable_interface.Answer_inter;

import com.websystique.springmvc.MybatisUtil.*;
import com.websystique.springmvc.handler.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.*;

public class test {
	/** 
     * ���MyBatis SqlSessionFactory�� SqlSessionFactory���𴴽�SqlSession�� 
     * һ�������ɹ����Ϳ�����SqlSessionʵ����ִ��ӳ����䣬commit��rollback��close�ȷ��� 
     */  
    public static void main(String[] args) throws Exception { 
    	SqlSessionFactory sqlSessionFactory= MybatisUtil.getInstance();   //����sqlSession�Ĺ�����sqlSessionFactory���Ƕ�cof1.xml�ļ����д����
        SqlSession sqlSession = sqlSessionFactory.openSession();  
    Worker_inter worker_inter = sqlSession.getMapper(Worker_inter.class);
    
      
       Administrator_inter administrator_inter=sqlSession.getMapper(Administrator_inter.class);
       Answer_inter answer_inter=sqlSession.getMapper(Answer_inter.class);
       Task_inter task_inter=sqlSession.getMapper(Task_inter.class);
      
  
      answer_inter.deleteAnswer(10, "yang");


      // List<Historylist_detail> hd=answer_inter.selectHis_detail("cao");
       //List<Historylist> history= answer_inter.selectHis("cao");
     
       Answer answer =new Answer();
       answer.setTid(2);
       answer.setUsername("abc");
       answer.setLongitude(110.1);
       answer.setLatitude(88.3);
   //  answer_inter.deleteAnswer(12, "cao");
     
     
      
    
    //   answer_inter.addAnswer(answer);
      
 /*     Worker worker = new Worker();
     
       worker.setUsername("abcd33");  
      worker.setPassword("12345");  
      worker.setPhoneno("8888885");
      Integer addworker = worker_inter.addWorker(worker);  
      System.out.println("addWorker, addworker:" + addworker); 
   

       Worker found = worker_inter.findWorker(worker.getUsername());  
        System.out.println("findWorker:" + found);  */
       /* found.setPassword("123456");  
       boolean updateworker = worker_inter.updateWorker(found);  
        System.out.println("updateWorker, updateworker:" + updateworker);  
       Worker found2 = worker_inter.findWorker( worker.getUsername());  
        System.out.println("findWorker:" + found2);  
  /*�ж��û�����
        int count = worker_inter.countWorker();  
        System.out.println("countWorker, count:" + count);  
  ��������Ŀ�г�
       List< Worker> list = worker_inter.listWorker();  
       System.out.println("listWorker, list:" + list);  
  ɾ���û�
        boolean deleteworker = worker_inter.deleteWorker(worker.getId());  
       System.out.println("deleteWorker:" + deleteworker);  
        
 ���һ������Ա
        Administrator administrator= new Administrator();
        administrator.setUsername("zhang");
        administrator.setPassword("1234");
        administrator.setPrivilege("����Ա");
        Integer addAdministrator=administrator_inter.addAdministrator(administrator);
        System.out.println("addAdministrator,addAdministrator:"+addAdministrator);
  /*���һ����*/   
  /*    String date = "2008-01-29T12:05:10"; // <input type="datetime-local"> �������
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
        
        Answer answer=new Answer();
        answer.setId(1);
     
        answer.setUsername("1234" );
        answer.setLocation("�����㳡");
        answer.setPicpath("");
        answer.setAltitude(123.123);
        answer.setLongitude(98.36);
        Map<String, Object> address = new HashMap<String, Object>();
        address.put("country", "china");
        address.put("province", "guangdong");
        address.put("city", "shenzhen");
        
        answer.setAnswer(address);
        try {
        	Date dt = sdf.parse(date);
        	 answer.setTime(new Timestamp(dt.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Integer addAnswer=answer_inter.addAnswer(answer); 
        //System.out.println("addAnswer, addanswer:" + addAnswer); 
        
        Task task = new Task();
        task.setId(123);
        task.setDescription("asldgjsdok");
        task.setTasktype("���н���");
        task.setStatus("����ִ��");
        Map<String, Object> address1 = new HashMap<String, Object>();
        address1.put("country", "china");
        address1.put("province", "guangdong");
        address1.put("city", "shenzhen");
        
       
      
        //System.out.println(answer_inter.listAnswer()); 
      
      //  Historylist history=answer_inter.selectHis("1234"); 
        
        double a1=110,a2=110;
        double b1=110,b2=111;
        Location location=new Location();
        
        Task task2 = new Task();
        task2.setId(6);
        task2.setDescription("��¥�㳡�Ĵ��ۻ2");
        task2.setTasktype("�·�����");
        task2.setStatus("����ִ��");
        task2.setLocation("��¥�㳡");
        task2.setAnswercount(100);
        task2.setLongitude(117.073);
        task2.setAltitude(36.69);
        //��question��json�ĸ�ʽ�������ݿ�
      Map<String, Object> question1 = new HashMap<String, Object>();
         question1.put("qid","q1" );
         question1.put("description", "������Ʒ������");
      List<Map<String, Object>> lable= new ArrayList<Map<String, Object>>();
      Map<String,Object> lable1=new HashMap <String,Object>(); 
      Map<String,Object> lable2=new HashMap <String,Object>(); 
      Map<String,Object> lable3=new HashMap <String,Object>(); 
      	lable1.put("labledescription", "�����");
      	lable1.put("lableid", 1);
        lable2.put("labledescription", "����һ��");
        lable2.put("lableid", 2);
        lable3.put("labledescription", "������");
        lable3.put("lableid", 3);
        lable.add(lable1);
        lable.add(lable2);
        lable.add(lable3);
        question1.put("label", lable);
        Map<String, Object> question2 = new HashMap<String, Object>();
        question2.put("qid","q2" );
        question2.put("description", "���۵��������");
        List<Map<String, Object>> lablee= new ArrayList<Map<String, Object>>();
        Map<String,Object> lablee1=new HashMap <String,Object>(); 
        Map<String,Object> lablee2=new HashMap <String,Object>(); 
        Map<String,Object> lablee3=new HashMap <String,Object>();
    
     lablee1.put("labledescription", "���Ⱥܴ�");
     lablee1.put("lableid", 1);
     lablee2.put("labledescription", "����һ��");
     lablee2.put("lableid", 2);
     lablee3.put("labledescription", "����С");
     lablee3.put("lableid", 3);
     lablee.add(lablee1);
     lablee.add(lablee2);
     lablee.add(lablee3);
       question2.put("label", lablee);
       List<Map<String, Object>> questionlist=new ArrayList<Map<String, Object>>();
       questionlist.add(question1);
       questionlist.add(question2);
        task2.setQuestion(questionlist); */
 // task_inter.addTask(task2);
   
        
     //task_inter.deleteTask(1);
              
        //System.out.println(worker_inter.listWorker());   
        
   sqlSession.commit();
	sqlSession.close();
    }  
}
