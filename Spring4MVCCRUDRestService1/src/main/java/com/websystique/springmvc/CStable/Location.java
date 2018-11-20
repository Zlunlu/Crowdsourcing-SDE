package com.websystique.springmvc.CStable;

import java.util.ArrayList;
import java.util.List;

import java.math.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.websystique.springmvc.CStable_interface.Task_inter;
import com.websystique.springmvc.MybatisUtil.MybatisUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Location {
	public double longitude;
	public double Latitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongtitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public List<Task> findtask(double lt,double alt){
		SqlSessionFactory sqlSessionFactory= MybatisUtil.getInstance();   //����sqlSession�Ĺ�����sqlSessionFactory���Ƕ�cof1.xml�ļ����д����
        SqlSession sqlSession = sqlSessionFactory.openSession();  
		Task_inter task_inter = sqlSession.getMapper(Task_inter.class);
		List<Task> tasks=task_inter.listTask();
		List<Task> list = new ArrayList<Task>();
	
		int t=tasks.size();
		for(int a=0;a<t;a++)
		{	
		
			double x=tasks.get(a).getLongitude();
			double y=tasks.get(a).getLatitude();
			
			double m=algorithm(x,y,lt,alt);
			
			if(Math.abs(m)<=3000)
			{
				JSONArray json=new JSONArray();
				JSONArray jsonarray=JSONArray.fromObject(tasks.get(a).getQuestion());
				
				tasks.get(a).setQuestion(jsonarray);
				list.add(tasks.get(a));
			
			}
		}
		System.out.println(list);
	return list;
	}
	public  double algorithm(double longitude1, double latitude1, double longitude2, double latitude2) {

        double Lat1 = rad(latitude1); // γ��

        double Lat2 = rad(latitude2);

        double a = Lat1 - Lat2;//����γ��֮��

        double b = rad(longitude1) - rad(longitude2); //����֮��

        double s = 2 * Math.asin(Math

                      .sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(Lat1) * Math.cos(Lat2) * Math.pow(Math.sin(b / 2), 2)));//�����������Ĺ�ʽ

        s = s * 6378137.0;//�����˵���뾶���뾶Ϊ�ף�

        s = Math.round(s * 10000d) / 10000d;//��ȷ�������ֵ

        return s;

 }


	public  double rad(double d) {

        return d * Math.PI / 180.00; //�Ƕ�ת���ɻ���

	}
	
	
	
 
}
