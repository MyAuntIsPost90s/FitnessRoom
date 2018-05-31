package fitnessroom.base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Teachers {
	private String teacherid;

	private String teachername;

	private Integer teachersex;

	@JSONField(format = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date teacherbirthday;

	private String teacherheadurl;

	private String teachercontent;

	private String teacherphone;

	private String teacherpassword;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Integer getTeachersex() {
		return teachersex;
	}

	public void setTeachersex(Integer teachersex) {
		this.teachersex = teachersex;
	}

	public Date getTeacherbirthday() {
		return teacherbirthday;
	}

	public void setTeacherbirthday(Date teacherbirthday) {
		this.teacherbirthday = teacherbirthday;
	}

	public String getTeacherheadurl() {
		return teacherheadurl;
	}

	public void setTeacherheadurl(String teacherheadurl) {
		this.teacherheadurl = teacherheadurl;
	}

	public String getTeachercontent() {
		return teachercontent;
	}

	public void setTeachercontent(String teachercontent) {
		this.teachercontent = teachercontent;
	}

	public String getTeacherphone() {
		return teacherphone;
	}

	public void setTeacherphone(String teacherphone) {
		this.teacherphone = teacherphone;
	}

	public String getTeacherpassword() {
		return teacherpassword;
	}

	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}
}