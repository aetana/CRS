package miu.edu.CourseRegistration1.service.impl;

import miu.edu.CourseRegistration1.entity.Faculty;
import miu.edu.CourseRegistration1.repository.FacultyRepo;
import miu.edu.CourseRegistration1.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepo facultyRepo;


    @Override
    public void add(Faculty faculty){
        facultyRepo.save(faculty);
    }
    @Override
    public void addAll(List<Faculty> faculties){
        facultyRepo.saveAll(faculties);
    }

}
