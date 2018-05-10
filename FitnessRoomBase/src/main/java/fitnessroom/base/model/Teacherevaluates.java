package fitnessroom.base.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Teacherevaluates {
    private String teacherevaluateid;

    private String teacherid;

    private String userid;

    private Integer teacherscore;

    @JSONField(format = "yyyy-MM-dd")
    private Date teacherevaluatetime;

    public String getTeacherevaluateid() {
        return teacherevaluateid;
    }

    public void setTeacherevaluateid(String teacherevaluateid) {
        this.teacherevaluateid = teacherevaluateid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getTeacherscore() {
        return teacherscore;
    }

    public void setTeacherscore(Integer teacherscore) {
        this.teacherscore = teacherscore;
    }

    public Date getTeacherevaluatetime() {
        return teacherevaluatetime;
    }

    public void setTeacherevaluatetime(Date teacherevaluatetime) {
        this.teacherevaluatetime = teacherevaluatetime;
    }
}