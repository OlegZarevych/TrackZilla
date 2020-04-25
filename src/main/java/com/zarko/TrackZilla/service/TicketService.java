package com.zarko.TrackZilla.service;

import com.zarko.TrackZilla.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}
