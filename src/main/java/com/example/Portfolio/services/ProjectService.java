package com.example.Portfolio.services;

import com.example.Portfolio.consts.Constants;
import com.example.Portfolio.entities.projects.ProjectsDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@Service
public class ProjectService{
    static Logger logger;
    static Constants consts = new Constants();

    public static Set<ProjectsDTO> getProjectsByTitle(String projectName) {

        Set<ProjectsDTO> projectsDTOS = new HashSet<>();
        
        try {
            Document document = Jsoup.connect(consts.getUrl()).get();
            Elements elements = document.getElementsByTag("a");

                for (Element ads : elements) {
                    if (ads.attr("title").equals(projectName)) {
                        ProjectsDTO projectsDTO = new ProjectsDTO();

                        projectsDTO.setTitle(ads.attr("title"));
                        projectsDTO.setHref(consts.getUrl() + "/tree/main/" + projectName);

                        Document connectionMidProject = Jsoup.connect(consts.getUrl() + "/tree/main/" + projectName).get();
                        Elements elementsMidProject = connectionMidProject.getElementsByTag("a");

                        for(Element adsNext : elementsMidProject){
                            if (adsNext.attr("title").equals("readme.md")){
                                Document connectionReadmeMd = Jsoup.connect(consts.getUrl() + "/blob/main/" + projectName + "/readme.md").get();
                                Elements elementsReadmeMd = connectionReadmeMd.select("div#readme");

                                for(Element adsReadme : elementsReadmeMd){
                                    String desc = adsReadme.select("p").toString();
                                    String descFront = desc.substring(14);
                                    String descBack = descFront.substring(0, descFront.length()-4);
                                    projectsDTO.setDescription(descBack);
                                }
                            }
                        }

                        projectsDTOS.add(projectsDTO);
                    }
                }
        } catch (IOException ex) {
            logger.warning("The provided project name is invalid...Try again!");
            ex.printStackTrace();
        }

        return projectsDTOS;
    }

    public static Set<ProjectsDTO> getAllProjects(){

        Set<ProjectsDTO> projectsDTOS = new HashSet<>();

        try{
            Document document = Jsoup.connect(consts.getUrl()).get();
            Elements elements = document.getElementsByTag("a");

            for (Element ads : elements) {
                if (ads.attr("title").equals("") || ads.attr("title").equals("GitHub")){
                    continue;
                }
                else{
                    ProjectsDTO projectsDTO = new ProjectsDTO();

                    projectsDTO.setTitle(ads.attr("title"));
                    projectsDTO.setHref(consts.getUrl() + "/");

                    projectsDTOS.add(projectsDTO);
                }
            }
        }catch(IOException ex){
            logger.warning("The provided project name is invalid...Try again!");
            ex.printStackTrace();
        }
        return projectsDTOS;
    }
}