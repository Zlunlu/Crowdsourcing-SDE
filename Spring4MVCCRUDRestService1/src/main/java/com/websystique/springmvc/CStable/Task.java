package com.websystique.springmvc.CStable;


import java.sql.Timestamp;

import net.sf.json.JSONObject;



public class Task {
	private Integer tid;   
	private String username;
    private String description; 
    private double longitude;
    private double latitude;
    private String location; 
    private Integer answercount;
    private String status; 
    private String tasktype; 
    private String answersnum;
    private Timestamp publictime;
    private Timestamp deadline;
    private Object question;
    
    public Integer getId() {  
    	
      return tid;
    } 
  
    public void setId(Integer tid) {  
        this.tid=tid;  
    }  
  
    public Object getQuestion() {  
        return question;  
    }  
  
    public void setQuestion(Object question) {  
        this.question = question;  
    }  
  
    public double  getLongitude() {  
        return longitude;  
    }  
  
    public void setLongitude(double longitude) {  
        this.longitude = longitude;  
    }  
 
  
    public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocation() {  
        return location;  
    }  
	
    public void setLocation(String location) {  
        this.location = location;  
    }  
    
    public void setAnswersnum(String answersnum) {  
        this.answersnum = answersnum;  
    }  
    
    public String getAnswersnum(){
    	return answersnum;
    }
    
    public String getDescription() {  
        return description;  
    }  
  
    public void setDescription(String description) {  
        this.description = description;  
    }  
    public Integer getAnswercount() {  
    	
        return answercount;
      }  
    
      public void setAnswercount(Integer answercount) {  
          this.answercount=answercount;  
      }  
      public String getStatus() {  
          return status;  
      }  
    
      public void setStatus(String status) {  
          this.status = status;  
      } 
      public String getTasktype() {  
          return tasktype;  
      }  
    
      public void setTasktype(String tasktype) {  
          this.tasktype = tasktype;  
      } 
    public Timestamp getPublictime() {  
        return publictime;  
    }  
  
    public void setPublictime(Timestamp publictime) {  
        this.publictime = publictime;  
    }  
    public Timestamp getDeadline() {  
        return deadline;  
    }  
  
    public void setDeadline(Timestamp deadline) {  
        this.deadline = deadline;  
    }  
    @Override
	public String toString() {
		return "Task [tid=" + tid + ", username=" + username + ", description=" + description + ", longitude="
				+ longitude + ", latitude=" + latitude + ", location=" + location + ", answercount=" + answercount
				+ ", status=" + status + ", tasktype=" + tasktype + ", answersnum=" + answersnum + ", publictime="
				+ publictime + ", deadline=" + deadline + ", question=" + question + "]";
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}  
}
