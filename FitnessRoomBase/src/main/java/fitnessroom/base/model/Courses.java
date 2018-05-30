package fitnessroom.base.model;

public class Courses {
    private String courseid;

    private String coursename;

    private String coursecontent;

    private Float coursetotaltime;

    private Float coursetime;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(String coursecontent) {
        this.coursecontent = coursecontent;
    }

    public Float getCoursetotaltime() {
        return coursetotaltime;
    }

    public void setCoursetotaltime(Float coursetotaltime) {
        this.coursetotaltime = coursetotaltime;
    }

    public Float getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(Float coursetime) {
        this.coursetime = coursetime;
    }
}