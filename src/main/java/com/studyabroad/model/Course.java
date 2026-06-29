package com.studyabroad.model;

public class Course {
    private String courseName;
    private int ects;
    private int courseId;
    private String courseURL;
    private String diplom;

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getEcts() { return ects; }
    public void setEcts(int ects) { this.ects = ects; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseURL() { return courseURL; }
    public void setCourseURL(String courseURL) { this.courseURL = courseURL; }

    public String getDiplom() { return diplom; }
    public void setDiplom(String diplom) { this.diplom = diplom; }

    @Override
    public String toString() {
        return "courseName='" + courseName + "'" +
            ", ects=" + ects +
            ", courseId=" + courseId +
            ", courseURL='" + courseURL + "'" +
            ", diplom='" + diplom + "'";
    }
}
