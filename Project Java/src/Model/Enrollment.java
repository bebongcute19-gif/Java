package Model;

import java.time.LocalDateTime;

public class Enrollment {

    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private LocalDateTime registeredAt;
    private String status;
    private LocalDateTime approvedAt;
    private Integer approvedBy;

    public Enrollment() {
    }

    public Enrollment(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Enrollment(Integer id, Integer studentId, Integer courseId,
                      LocalDateTime registeredAt, String status,
                      LocalDateTime approvedAt, Integer approvedBy) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.registeredAt = registeredAt;
        this.status = status;
        this.approvedAt = approvedAt;
        this.approvedBy = approvedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }
}