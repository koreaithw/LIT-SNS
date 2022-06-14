package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class ProjectVO {
    private Long projectNumber;
    private String projectTitle;
    private String projectCategory;
    private String projectContent;
    private String projectAuthentication;
    private String projectStartDate;
    private String projectEndDate;
    private String projectPhoto;
    private Long projectStatus;

    private ProjectFileVO projectFileList;

}
