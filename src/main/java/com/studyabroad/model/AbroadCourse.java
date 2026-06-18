package com.studyabroad.model;

// Will model the students abroad class etc.

public class AbroadCourse {
    private String university; 
    private String city; 
    private String country; 
    private int courseId; 
    private String courseName; 
    private Integer erasmusID;
    private int ects; 
    private String courseURL; 
    private String diplom; 


    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Integer getErasmusID() { return erasmusID; }
    public void setErasmusID(Integer erasmusID) { this.erasmusID = erasmusID; }

    public int getEcts() { return ects; }
    public void setEcts(int ects) { this.ects = ects; }

    public String getCourseURL() { return courseURL; }
    public void setCourseURL(String courseURL) { this.courseURL = courseURL; }

    public String getDiplom() { return diplom; }
    public void setDiplom(String diplom) { this.diplom = diplom; }

    @Override
    public String toString() {
        return "AbroadCourse{" +
            "university='" + university + "'" +
            ", city='" + city + "'" +
            ", country='" + country + "'" +
            ", courseId=" + courseId +
            ", courseName='" + courseName + "'" +
            ", erasmusID=" + erasmusID +
            ", ects=" + ects +
            ", courseURL='" + courseURL + "'" +
            ", diplom='" + diplom + "'" +
            "}";
    }
}