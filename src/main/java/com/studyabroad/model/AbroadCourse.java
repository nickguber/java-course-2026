package com.studyabroad.model;

public class AbroadCourse extends Course {
    private String university;
    private String city;
    private String country;
    private Integer erasmusID;
    private boolean hasErasmusId;

    public AbroadCourse() {}

    public AbroadCourse(String university, String city, String country, int courseId,
                        String courseName, Integer erasmusID, int ects, String courseURL, String diplom) {
        setCourseName(courseName);
        setEcts(ects);
        setCourseId(courseId);
        setCourseURL(courseURL);
        setDiplom(diplom);
        this.university = university;
        this.city = city;
        this.country = country;
        setErasmusID(erasmusID);
    }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Integer getErasmusID() { return erasmusID; }
    public void setErasmusID(Integer erasmusID) {
        this.erasmusID = erasmusID;
        this.hasErasmusId = erasmusID != null;
    }

    public boolean isHasErasmusId() { return hasErasmusId; }

    @Override
    public String toString() {
        return "AbroadCourse{" +
            super.toString() +
            ", university='" + university + "'" +
            ", city='" + city + "'" +
            ", country='" + country + "'" +
            ", erasmusID=" + erasmusID +
            "}";
    }
}
