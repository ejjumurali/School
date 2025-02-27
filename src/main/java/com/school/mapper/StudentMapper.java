package com.school.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    @Autowired
    ObjectMapper objectMapper;

    @Value("classpath:data/StudentData.json")
    Resource resourceFile;

    public <T> List<StudentDTO> getObjectFromJson(Class<T> valueType) {
        try {
            String contentAsByteArray = resourceFile.getContentAsString(Charset.defaultCharset());
            return objectMapper.readValue(contentAsByteArray, new TypeReference<List<StudentDTO>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public <T> StudentDTO addObjectToJsonFile(StudentDTO student, Class<T> valueType) {
        try {
            List<StudentDTO> list = getObjectFromJson(valueType);
            if (list != null) {
                list.add(student);
            } else {
                list = List.of(student); // Initialize list with the new object if the file was empty or invalid
            }
            File jsonFile = resourceFile.getFile();
            objectMapper.writeValue(jsonFile, list);
            String contentAsString = resourceFile.getContentAsString(Charset.defaultCharset());
            System.out.println("Updated JSON file: " + jsonFile.getAbsolutePath());
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(StudentDTO requestStudent) {
        try {
            List<StudentDTO> list = getObjectFromJson(requestStudent.getClass());
            List<StudentDTO> finalList = list.stream().filter(student -> !requestStudent.getId().equals(student.getId())).toList();
            File jsonFile = resourceFile.getFile();
            objectMapper.writeValue(jsonFile, list);
            System.out.println("Updated JSON file: " + jsonFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
