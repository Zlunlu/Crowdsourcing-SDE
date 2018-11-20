package com.websystique.springmvc.CStable_interface;

import java.util.List;

import com.websystique.springmvc.CStable.Newtask;
import com.websystique.springmvc.CStable.Task;

import net.sf.json.JSONObject;

import org.apache.ibatis.annotations.Delete;  
import org.apache.ibatis.annotations.Insert;  
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;  
import org.apache.ibatis.annotations.Update; 
public interface Newtask_inter {
	
	//���һ������
	@Insert("insert into newtask(tid,longitude,altitude,location,description,publictime,question,status,answercount,tasktype,deadline) values(#{tid},#{longitude},#{altitude},#{location},#{description},#{publictime},#{question,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note},#{status},#{answercount},#{tasktype},#{deadline})")
	public  Integer addTask(Newtask task);
	
	//����һ������
	@Update(" update newtask set tasktype=#{tasktype:VARCHAR} , longitude=#{longitude:DECIMAL},altitude=#{altitude:DECIMAL}, location=#{location:VARCHAR}, status=#{status:VARCHAR},answercount=#{answercount:INTEGER},description=#{description:VARCHAR},publictime=#{publictime:TIMESTAMP}, deadline=#{deadline:TIMESTAMP}, question=#{question,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note} where tid=#{tid:INTEGER}") 
    public boolean updateTask(Newtask task);  
	
	//ɾ��һ������
    @Delete(" delete from newtask where tid= #{tid:INTEGER}")
    public  boolean deleteTask(Integer TID);
    
    //����һ������
    @Select("select * from newtask where tid = #{tid:INTEGER} ")
    public  Newtask findTask(Integer TID);
    
    //�����������
    @Select("select count(*) from newtask")
    public int countTask();
    
    //������������
    @Select("select * from newtask ")
    public List<Newtask> listTask(); 
    
    //����ĳ����ַ������
    @Select("select * from newtask where location like '%${location}%'")
    public List<Newtask> findTask_location(@Param(value="location")String location);//by ygj ������ͨ��ƥ��location�ַ�����һ��task���б�
    
}
