package model;
// Thồng kê
public class CourseStat {
    private int courseId;
    private String courseName;
    private int totalStudent;

    public CourseStat(int courseId, String courseName, int totalStudent) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.totalStudent = totalStudent;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTotalStudent() {
        return totalStudent;
    }
}
