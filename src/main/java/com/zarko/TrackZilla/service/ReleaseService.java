package com.zarko.TrackZilla.service;

import com.zarko.TrackZilla.entity.Release;

public interface ReleaseService {
    Iterable<Release> listReleases();
}
