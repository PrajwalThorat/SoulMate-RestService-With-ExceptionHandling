package com.stackroute.Soulmate.service;

import com.stackroute.Soulmate.exception.SoulmateAlreadyExistException;
import com.stackroute.Soulmate.exception.SoulmateNotFoundException;
import com.stackroute.Soulmate.model.Soulmate;
import com.stackroute.Soulmate.repo.SoulmateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoulmateServiceImpl implements SoulmateService {

    private SoulmateRepo soulmateRepo;

    @Autowired
    public SoulmateServiceImpl(SoulmateRepo soulmateRepo) {
        this.soulmateRepo = soulmateRepo;
    }

    @Override
    public Soulmate addProfile(Soulmate soulmate) throws SoulmateAlreadyExistException {
        if (soulmateRepo.existsById(soulmate.getId())) {
            throw new SoulmateAlreadyExistException();
        }
        return soulmateRepo.save(soulmate);
    }

    @Override
    public Soulmate deleteProfile(int id) throws SoulmateNotFoundException {
        Soulmate delSoulmate = null;
        Optional optional = soulmateRepo.findById(id);
        if (!optional.isPresent()) {
            throw new SoulmateNotFoundException();
        } else {
            delSoulmate = soulmateRepo.findById(id).get();
            soulmateRepo.deleteById(id);
        }
        return delSoulmate;
    }

    @Override
    public Soulmate updateProfile(Soulmate soulmate) throws SoulmateNotFoundException {
        Soulmate existSoulmate = null;
        Soulmate optional = soulmateRepo.getById(soulmate.getId());
        if (optional==null) {
            throw new SoulmateNotFoundException();
        } else {
            Soulmate getSoulmate = soulmateRepo.findById(soulmate.getId()).get();
            getSoulmate.setName(soulmate.getName());
            getSoulmate.setGender(soulmate.getGender());
            getSoulmate.setAge(soulmate.getAge());
            existSoulmate = soulmateRepo.save(getSoulmate);
        }
        return existSoulmate;
    }

    @Override
    public List<Soulmate> getAllProfile() {
        return soulmateRepo.findAll();
    }

    @Override
    public List<Soulmate> getListByName(String name) throws SoulmateNotFoundException {
        Soulmate existSoulmate = (Soulmate) soulmateRepo.findByName(name);
        if (existSoulmate==null){
            throw new SoulmateNotFoundException();
        }
        return (List<Soulmate>) existSoulmate;
    }

    @Override
    public List<Soulmate> getListByGenderAndAge(String gender, int age) throws SoulmateNotFoundException {
        Soulmate soulmate = (Soulmate) soulmateRepo.findByGenderAndAge(gender, age);
        if (soulmate==null){
            throw new SoulmateNotFoundException();
        }
        return (List<Soulmate>) soulmate;
    }


}
