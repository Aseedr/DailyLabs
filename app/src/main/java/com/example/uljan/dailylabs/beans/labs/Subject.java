package com.example.uljan.dailylabs.beans.labs;


import java.io.Serializable;
import java.util.List;

public class Subject implements Serializable {

    private String name;

    private String description;

    private List<Lab> labs;

    private Diary diary;

    public Subject() { }

    public Subject(String name, String description, List<Lab> labs, Diary diary) {
        this.name = name;
        this.description = description;
        this.labs = labs;
        this.diary = diary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (description != null ? !description.equals(subject.description) : subject.description != null)
            return false;
        if (labs != null ? !labs.equals(subject.labs) : subject.labs != null) return false;
        return diary != null ? diary.equals(subject.diary) : subject.diary == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (labs != null ? labs.hashCode() : 0);
        result = 31 * result + (diary != null ? diary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", labs=" + labs +
                '}';
    }

}
