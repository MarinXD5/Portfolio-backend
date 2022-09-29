package com.example.Portfolio.entities.projects;

import lombok.Data;

@Data
public class ProjectsDTO {

    private String title;
    private String href;
    private String description;
    private String dateCreated;
    private String dateModified;

    public ProjectsDTO(String title, String href, String description, String dateCreated, String dateModified){
        super();
        this.title = title;
        this.href = href;
        this.description = description;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public ProjectsDTO() {

    }
}
