package com.example.uljan.dailylabs.beans.labs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by artifaqiq on 2/8/17.
 */

public class Diary implements Serializable {

    private List<Subject> subjects;

    private Date lastModifiedDate;

    public Diary() { }

    public Diary(List<Subject> subjects, Date lastModifiedDate) {
        this.subjects = subjects;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Diary(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diary diary = (Diary) o;

        if (subjects != null ? !subjects.equals(diary.subjects) : diary.subjects != null)
            return false;
        return lastModifiedDate != null ? lastModifiedDate.equals(diary.lastModifiedDate) : diary.lastModifiedDate == null;

    }

    @Override
    public int hashCode() {
        int result = subjects != null ? subjects.hashCode() : 0;
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "subjects=" + subjects +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
