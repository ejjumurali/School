package com.school.service;

import com.school.dto.StudentDTO;
import com.school.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public StudentDTO getStudent(Long id) {
        List<StudentDTO> studentList = studentMapper.getObjectFromJson(StudentDTO.class);
        Optional<StudentDTO> studentOptional = studentList.stream()
                .filter(student -> student.getId().equals(id)).findFirst();
        return studentOptional.orElse(null);
    }
    public List<StudentDTO>  getStudentList() {
        return studentMapper.getObjectFromJson(StudentDTO.class);
    }

    public StudentDTO create(StudentDTO dto) {
        StudentDTO studentDTOS = studentMapper.addObjectToJsonFile(dto,StudentDTO.class);
        return studentDTOS;
    }

    public void delete(Long id) {
        studentMapper.delete(getStudent(id));
    }
}
