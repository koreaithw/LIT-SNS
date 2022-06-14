package com.example.lit.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectFileVO {
    private String projectFileUuid;
    private String projectFileUploadPath;
    private String projectFileName;
    private String projectFileImage;
    private Long projectNumber;


}
