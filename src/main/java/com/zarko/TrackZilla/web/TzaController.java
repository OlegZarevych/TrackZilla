package com.zarko.TrackZilla.web;

import com.zarko.TrackZilla.entity.Application;
import com.zarko.TrackZilla.entity.Release;
import com.zarko.TrackZilla.entity.Ticket;
import com.zarko.TrackZilla.exception.ApplicationNotFoundException;
import com.zarko.TrackZilla.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/tza")
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> ticketList = (List<Ticket>) ticketService.listTickets();
        return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications(){
        List<Application> applicationList = (List<Application>) applicationService.listApplications();
        return new ResponseEntity<List<Application>>(applicationList, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public  ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
        try
        {
            var app = applicationService.findApplication(id);
            return new ResponseEntity<Application>(app, HttpStatus.OK);
        }
        catch (ApplicationNotFoundException ex)
        {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "App IS NOT FOUND");
        }
    }

    public ResponseEntity<List<Release>> getAllReleases() {
        List<Release> releaseList = (List<Release>) releaseService.listReleases();
        return new ResponseEntity<List<Release>>(releaseList, HttpStatus.OK);
    }

 /*
    @GetMapping("/applications")
    public String retrieveApplications(Model model) {
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

    @GetMapping("/releases")
    public String retrieveReleases(Model model){
        model.addAttribute("release", releaseService.listReleases());
        return "release";
    }

    @GetMapping("/tickets")
    public String retrieveTickets(Model model){
        model.addAttribute("ticket", ticketService.listTickets());
        return "tickets";
    }

  */
}