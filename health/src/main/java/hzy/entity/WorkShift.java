package hzy.entity;

import java.util.List;

public class WorkShift {
    private Integer id;

    private String name;

    private Short mon;

    private Short tue;

    private Short wed;

    private Short thu;

    private Short fri;

    private Short sat;

    private Short sun;

    private List<Schedule> schedules;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getMon() {
        return mon;
    }

    public void setMon(Short mon) {
        this.mon = mon;
    }

    public Short getTue() {
        return tue;
    }

    public void setTue(Short tue) {
        this.tue = tue;
    }

    public Short getWed() {
        return wed;
    }

    public void setWed(Short wed) {
        this.wed = wed;
    }

    public Short getThu() {
        return thu;
    }

    public void setThu(Short thu) {
        this.thu = thu;
    }

    public Short getFri() {
        return fri;
    }

    public void setFri(Short fri) {
        this.fri = fri;
    }

    public Short getSat() {
        return sat;
    }

    public void setSat(Short sat) {
        this.sat = sat;
    }

    public Short getSun() {
        return sun;
    }

    public void setSun(Short sun) {
        this.sun = sun;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}