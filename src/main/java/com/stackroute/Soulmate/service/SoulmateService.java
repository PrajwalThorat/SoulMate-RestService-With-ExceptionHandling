package com.stackroute.Soulmate.service;

import com.stackroute.Soulmate.exception.SoulmateAlreadyExistException;
import com.stackroute.Soulmate.exception.SoulmateNotFoundException;
import com.stackroute.Soulmate.model.Soulmate;

import java.util.List;

public interface SoulmateService {

    public Soulmate addProfile(Soulmate soulmate) throws SoulmateAlreadyExistException;

    public Soulmate deleteProfile(int id) throws SoulmateNotFoundException;

    public Soulmate updateProfile(Soulmate soulmate) throws SoulmateNotFoundException;

    public List<Soulmate> getAllProfile();

    public List<Soulmate> getListByName(String name) throws SoulmateNotFoundException;

    public List<Soulmate> getListByGenderAndAge(String gender , int age) throws SoulmateNotFoundException;
}
