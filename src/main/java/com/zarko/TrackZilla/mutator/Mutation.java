package com.zarko.TrackZilla.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.zarko.TrackZilla.entity.Application;
import com.zarko.TrackZilla.exception.ApplicationNotFoundException;
import com.zarko.TrackZilla.repository.ApplicationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ApplicationRepository appRepository;

    public Mutation (ApplicationRepository appRepository){
        this.appRepository = appRepository;
    }

    public Application newApplication(String name, String description, String owner){
        Application application = new Application(name, owner, description);
        appRepository.save(application);
        return application;
    }

    public boolean deleteApplication(long id){
        appRepository.deleteById(id);
        return true;
    }

    public Application updateApplicationOwner(String newOwner, long id){
        Optional<Application> app = appRepository.findById(id);

        if (app.isPresent()) {
            Application application = app.get();
            application.setOwner(newOwner);
            appRepository.save(application);
            return application;
        }
        else
            throw new ApplicationNotFoundException("Application with Id:" + id + "not found");
    }
}
