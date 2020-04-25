package com.zarko.TrackZilla.service;

import com.zarko.TrackZilla.entity.Application;
import com.zarko.TrackZilla.exception.ApplicationNotFoundException;
import com.zarko.TrackZilla.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        Optional<Application> app = applicationRepository.findById(id);

        if (app.isPresent())
            return app.get();
        else
            throw new ApplicationNotFoundException("No application with ID " + id + "was found");
    }
}
