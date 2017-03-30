package com.example.uljan.dailylabs.beans.labs;

import java.io.Serializable;

public class Lab implements Serializable {

    private String name;

    private boolean passed;

    private String description;

    private Subject subject;

    public Lab() { }

    public Lab(String name, boolean passed, String description, Subject subject) {
        this.name = name;
        this.passed = passed;
        this.description = description;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lab lab = (Lab) o;

        if (passed != lab.passed) return false;
        if (name != null ? !name.equals(lab.name) : lab.name != null) return false;
        if (description != null ? !description.equals(lab.description) : lab.description != null)
            return false;
        return subject != null ? subject.equals(lab.subject) : lab.subject == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passed ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "name='" + name + '\'' +
                ", passed=" + passed +
                ", description='" + description + '\'' +
                ", subject=" + subject +
                '}';
    }
}
