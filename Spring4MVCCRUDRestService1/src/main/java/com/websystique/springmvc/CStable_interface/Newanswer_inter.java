package com.websystique.springmvc.CStable_interface;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.annotations.Delete;  
import org.apache.ibatis.annotations.Insert;  
import org.apache.ibatis.annotations.Select;  
import org.apache.ibatis.annotations.Update;  

import com.websystique.springmvc.CStable.Historylist;
import com.websystique.springmvc.CStable.Newanswer;
import com.websystique.springmvc.CStable.Historylist_detail;
public interface Newanswer_inter {
	
	   //���һ����
	   @Insert(" insert into newanswer(aid,tid,username,longitude,altitude,location,picpath,time,answer) values(#{aid},#{tid},#{username},#{longitude},#{altitude},#{location},#{picpath},#{time},#{answer,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note})")
		public  Integer addAnswer(Newanswer answer); 
	    
	    //���ݻش�id����һ����
	    @Update("update newanswer set longitude=#{longitude:DECIMAL},latitude=#{latitude:DECIMAL}, location=#{location:LONGVARCHAR},picpath=#{picpath:LONGVARCHAR},time=#{time:TIMESTAMP},answer=#{answer,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note} where  aid=#{aid} ")
	    public boolean updateAnswer(Newanswer answer);
	    
	    //ɾ��һ���û���ĳ������Ĵ�
	    @Delete(" delete from newanswer where username=#{arg1} and tid=#{arg0}")
	    public  boolean deleteAnswer(Integer TID,String username);
	    
	    //����һ������������û��Ĵ�
	    @Select("select * from newanswer where tid=#{tid}")
	    public  List<Newanswer> findAnswer_tid(Integer TID);
	    
	    //����ĳ���û�����������Ļش�
	    @Select("select * from newanswer where username=#{username}")
	    public  List<Newanswer> findAnswer_username(String username);
	    
	    //����ĳ���û���ĳ������Ļش�
	    @Select("select * from newanswer where username=#{username}and tid=#{tid}")
	    public  List<Newanswer> findAnswer(Integer TID,String username);
	    
	    //����ĳ������Ļش����
	    @Select("select count(*) from newanswer where tid=#{tid}")
	    public int countAnswer(Integer TID);
	    
	    //�������д�
	    @Select("select * from newanswer")
	    public List<Newanswer> listAnswer(); 
	    
	   //����ĳ���û�����ĳ������Ļش�ı�ǩ����
	  @Select("select  row_to_json(t)->'answer'#>>'{${arg2},label}' as label,username from  newanswer as t where tid=#{arg0} and username=#{arg1}")
	  public String getAnswer_label(Integer tid,String username,Integer index); 
	  
	  //����ĳ���û�����ĳ������Ļش�Ļش���
	  @Select("select  row_to_json(t)->'answer'#>>'{${arg2},qid}' as qid,username from  newanswer as t where tid=#{arg0} and username=#{arg1}")
	  public String getAnswer_qid(Integer tid,String username,Integer index); 
	  
	  //����ĳ���û�����ĳ������Ļش�
	  @Select("select  row_to_json(t)->>'answer' from  newanswer as t where tid=#{arg0} and username=#{arg1}")
	  public String getAnswer(Integer tid,String username);
}
