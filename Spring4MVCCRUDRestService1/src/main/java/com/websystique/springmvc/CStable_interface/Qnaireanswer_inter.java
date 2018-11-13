package com.websystique.springmvc.CStable_interface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.websystique.springmvc.CStable.Qnaireanswer;

public interface Qnaireanswer_inter {

		
		   //���һ����
		   @Insert(" insert into qnaireanswer(aid,tid,username,longitude,latitude,location,picpath,time,qnanswer) values(#{aid},#{tid},#{username},#{longitude},#{latitude},#{location},#{picpath},#{time},#{qnanswer,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note})")
			public  Integer addQnireanswer(Qnaireanswer answer); 
		    
		    //���ݻش�id����һ����
		    @Update("update qnaireanswer set longitude=#{longitude:DECIMAL},latitude=#{latitude:DECIMAL}, location=#{location:LONGVARCHAR},picpath=#{picpath:LONGVARCHAR},time=#{time:TIMESTAMP},qnanswer=#{qnanswer,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note} where  aid=#{aid} ")
		    public boolean updateAnswer(Qnaireanswer answer);
		    
		    //ɾ��һ���û���ĳ������Ĵ�
		    @Delete(" delete from qnaireanswer where username=#{arg1} and tid=#{arg0}")
		    public  boolean deleteAnswer(Integer TID,String username);
		    
		    //����һ������������û��Ĵ�
		    @Select("select * from qnaireanswer where tid=#{tid}")
		    public  List<Qnaireanswer> findAnswer_tid(Integer TID);
		    
		    //����ĳ���û�����������Ļش�
		    @Select("select * from qnaireanswer where username=#{username}")
		    public  List<Qnaireanswer> findAnswer_username(String username);
		    
		    //����ĳ���û���ĳ������Ļش�
		    @Select("select * from qnaireanswer where username=#{arg1}and tid=#{arg0}")
		    public  List<Qnaireanswer> findAnswer(Integer TID,String username);
		    
		    //����ĳ������Ļش����
		    @Select("select count(*) from qnaireanswer where tid=#{tid}")
		    public int countAnswer(Integer TID);
		    
		    //�������д�
		    @Select("select * from qnaireanswer")
		    public List<Qnaireanswer> listAnswer(); 
		    
		   //����ĳ���û�����ĳ������Ļش�ı�ǩ����
		  @Select("select  row_to_json(t)->'qnanswer'#>>'{${arg2},label}' as label,username from  qnaireanswer as t where tid=#{arg0} and username=#{arg1}")
		  public String getAnswer_label(Integer tid,String username,Integer index); 
		  
		  //����ĳ���û�����ĳ������Ļش�Ļش���
		  @Select("select  row_to_json(t)->'qnanswer'#>>'{${arg2},qid}' as qid,username from  qnaireanswer as t where tid=#{arg0} and username=#{arg1}")
		  public String getAnswer_qid(Integer tid,String username,Integer index); 
		  
		  //����ĳ���û�����ĳ������Ļش�
		  @Select("select  row_to_json(t)->>'qnanswer' from  qnaireanswer as t where tid=#{arg0} and username=#{arg1}")
		  public String getAnswer(Integer tid,String username);
	
}
