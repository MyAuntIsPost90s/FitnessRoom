package fitnessroom.base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Usercourses {
    private String usercourseid;

    private String courseid;

    private String userid;

    private String teacherid;

    private String equipmentid;

    private String usercoursepoints;

    @JSONField(format = "yyyy-MM-dd")
   	@DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date usercourseendtime;

    @JSONField(format = "yyyy-MM-dd")
   	@DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date usercoursebegintime;
    
    /** DTO **/
    private Courses course;

    public String getUsercourseid() {
        return usercourseid;
    }

    public void setUsercourseid(String usercourseid) {
        this.usercourseid = usercourseid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getUsercoursepoints() {
        return usercoursepoints;
    }

    public void setUsercoursepoints(String usercoursepoints) {
        this.usercoursepoints = usercoursepoints;
    }

    public Date getUsercourseendtime() {
        return usercourseendtime;
    }

    public void setUsercourseendtime(Date usercourseendtime) {
        this.usercourseendtime = usercourseendtime;
    }

    public Date getUsercoursebegintime() {
        return usercoursebegintime;
    }

    public void setUsercoursebegintime(Date usercoursebegintime) {
        this.usercoursebegintime = usercoursebegintime;
    }
    
    public Courses getCourse() {
		return course;
	}
    
    public void setCourse(Courses course) {
		this.course = course;
	}
    
}