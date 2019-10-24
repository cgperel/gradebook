package database;

public class Student {
    private String username;
    private Double average;
    private String classname;
    private String lettergrade;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getLettergrade() {
        return lettergrade;
    }

    public void setLettergrade(String lettergrade) {
        this.lettergrade = lettergrade;
    }
}
