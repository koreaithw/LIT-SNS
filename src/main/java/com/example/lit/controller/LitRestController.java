package com.example.lit.controller;

import com.example.lit.domain.vo.ListDTO;
import com.example.lit.domain.vo.project.ProjectDTO;
import com.example.lit.domain.vo.project.ProjectFileVO;
import com.example.lit.service.project.LitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/lit/*")
public class LitRestController {
    private final LitService litService;

    @PostMapping("/upload")
    public List<ProjectFileVO> upload(MultipartFile[] uploadFiles) throws IOException {
        String uploadFolder = "C:/upload";
        ArrayList<ProjectFileVO> files = new ArrayList<>();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            ProjectFileVO ProjectFileVO = new ProjectFileVO();
            String uploadFileName = file.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            ProjectFileVO.setName(uploadFileName);
            ProjectFileVO.setUuid(uuid.toString());
            ProjectFileVO.setUploadPath(getFolder());

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("--------------------------------");
            log.info("Upload File Name : " + uploadFileName);

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

            if(checkImageType(saveFile)){
                ProjectFileVO.setImage("1");
            }
            files.add(ProjectFileVO);
        }
        return files;
    }

    @GetMapping("/display")
    public byte[] getFile(String fileName) throws IOException{
        File file = new File("C:/upload/", fileName);
        log.info(file.toString());
        return FileCopyUtils.copyToByteArray(file);
    }

    private boolean checkImageType(File file) throws IOException{
        String contentType = Files.probeContentType(file.toPath());
        return contentType.startsWith("image");
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }

    @PostMapping("/getMainList")
    public List<ProjectDTO> getMainList(@RequestBody ListDTO listDTO){
        log.info("***************************");
        log.info("LitRestController : getMainList(post)");
        log.info("***************************");
//        litService.getMainList(listDTO).stream().map(ProjectDTO::toString).forEach(log::info);
        listDTO.setAmount(6);
        return litService.getMainList(listDTO);
    }

}
