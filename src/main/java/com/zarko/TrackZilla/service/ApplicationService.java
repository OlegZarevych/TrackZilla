package com.zarko.TrackZilla.service;

import com.zarko.TrackZilla.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();

    Application findApplication(long id);
}
