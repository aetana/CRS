package miu.edu.CourseRegistration1.service.impl;

import miu.edu.CourseRegistration1.entity.AcademicBlock;
import miu.edu.CourseRegistration1.repository.AcademicBlockRepo;
import miu.edu.CourseRegistration1.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AcademicBlockServiceImpl implements AcademicBlockService {

    @Autowired
    private AcademicBlockRepo academicBlockRepo;
    public void save(AcademicBlock academicBlock){
        academicBlockRepo.save(academicBlock);
    }
    public void saveAll(List<AcademicBlock> academicBlocks){
        academicBlockRepo.saveAll(academicBlocks);
    }
}
