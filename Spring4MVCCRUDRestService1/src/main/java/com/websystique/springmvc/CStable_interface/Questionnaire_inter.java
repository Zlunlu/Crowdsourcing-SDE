package com.websystique.springmvc.CStable_interface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.websystique.springmvc.CStable.Questionnaire;

public interface Questionnaire_inter {

	//���һ���ʾ�
	@Insert("insert into questionnaire(isshow,linkedtaskid,qnaireid,longitude,latitude,location,description,publictime,content,status,answercount,deadline) values(#{isshow},#{linkedtaskid},#{qnaireid},#{longitude},#{latitude},#{location},#{description},#{publictime},#{content,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note},#{status},#{answercount},#{deadline})")
	public  Integer addQuestionnaire(Questionnaire questionnaire);
	
	//����һ���ʾ�
	@Update("update questionnaire set isshow=#{isshow:INTEGER} , longitude=#{longitude:DECIMAL},latitude=#{latitude:DECIMAL}, location=#{location:VARCHAR}, status=#{status:VARCHAR},answercount=#{answercount:INTEGER},description=#{description:VARCHAR},publictime=#{publictime:TIMESTAMP}, deadline=#{deadline:TIMESTAMP}, content=#{content,typeHandler=com.websystique.springmvc.handler.JsonTypeHandler_note},linkedtaskid=#{linkedtaskid:INTEGER} where qnaireid=#{qnaireid:INTEGER}") 
    public boolean updateQuestionnaire(Questionnaire questionnaire);  
	
	//�����ʾ��isShow״̬,���������ʾ�״̬��Ϊ0
	@Update("update questionnaire set isshow=0 where isshow=1")
	 public boolean updateIsShow(); 
	
	//ɾ��һ���ʾ�
    @Delete(" delete from questionnaire where qnaireid= #{qnaireid:INTEGER}")
    public  boolean deleteQuestionnaire(Integer qnaireid);
  
    
    //�����޹������񵫿�����ʾ���ʾ�
    @Select("select * from questionnaire where isshow=1 and linkedtaskid is null")
    public List<Questionnaire> findNonLinkedIsShow();
    
  //�����й��������ҿ�����ʾ���ʾ�
    @Select("select * from questionnaire where isshow=1 and linkedtaskid=#{linkedtaskid:INTEGER}")
    public  List<Questionnaire> findLinkedIsShow(Integer linkedtaskid);
    
    //��ѯĳ��������Ӧ���ʾ�id
    @Select("select qnaireid from questionnaire where  linkedtaskid=#{linkedtaskid:INTEGER}")
    public List<Integer> findLinkedqn(Integer linkedtaskid);
    //�����ʾ�id��ѯ�ʾ�
    @Select("select * from questionnaire where  qnaireid= #{qnaireid:INTEGER}")
    public Questionnaire findqn_id(Integer qnaireid);
    //��ѯ�û�û�������Ļ�Ծ���ʾ��޹�����
    @Select("select qnaireid from questionnaire where  qnaireid not in(select tid from qnaireanswer where username=#{arg1} and isshow=1)")
   public List<Integer> findQuestionnonlinked(String unsername );
    
    //��ѯ�û�û�������Ļ�Ծ���ʾ��й�����
    @Select("select qnaireid from questionnaire where  linkedtaskid=#{arg0} and qnaireid not in(select tid from qnaireanswer where username=#{arg1} and isshow=1)")
   public List<Integer> findQuestionlinked(int linkedtaskid,String unsername );
   
    //���������ʾ�
    @Select("select count(*) from questionnaire")
    public int countQuestionnaire();
    
    //���������ʾ�
    @Select("select * from questionnaire ")
    public List<Questionnaire> listQuestionnaire(); 
    
    //����ĳ����ַ���ʾ�
   // @Select("select * from questionnaire where location like '%${location}%'")
   // public List<Questionnaire> findQuestionnaire_location(@Param(value="location")String location);//by ygj ������ͨ��ƥ��location�ַ�����һ��task���б�	
}
