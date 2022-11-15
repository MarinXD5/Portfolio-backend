package com.example.Portfolio.entities.projects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsDTO {

    private String title;
    private String href;
    private String description;
    private String dateCreated;
    private String dateModified;
}
