package miu.edu.CourseRegistration1.service.impl;

import miu.edu.CourseRegistration1.entity.Address;
import miu.edu.CourseRegistration1.repository.AddressRepo;
import miu.edu.CourseRegistration1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public void createAddsress(Address address){
        addressRepo.save(address);
    }


}
