package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.Faculty;

import java.util.List;

public interface FacultyService {
    public void add(Faculty faculty);
    public void addAll(List<Faculty> facultys);
}
