package com.example.career;

public class Notes {
    private String notesId;
    private String subjectName;
    private String topicName;
    private String description;
    private String link;
    private String branch;

    public Notes() {
        //For Firebase
    }

    public Notes(String branch, String notesId, String subjectName, String name, String description, String link) {
        this.branch=branch;
        this.notesId=notesId;
        this.subjectName=subjectName;
        this.topicName = name;
        this.description = description;
        this.link=link;
    }

    public String getBranch() {
        return branch;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getDescription() {
        return description;
    }

    public String getCourseId() {
        return notesId;
    }

    public String getLink() {
        return link;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
