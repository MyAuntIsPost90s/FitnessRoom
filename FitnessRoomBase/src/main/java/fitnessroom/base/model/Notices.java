package fitnessroom.base.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Notices {
    private String noticeid;

    private String noticetitle;

    @JSONField(format = "yyyy-MM-dd")
    private Date noticetime;

    private String noticecontent;

    public String getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(String noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticetitle() {
        return noticetitle;
    }

    public void setNoticetitle(String noticetitle) {
        this.noticetitle = noticetitle;
    }

    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent;
    }
}