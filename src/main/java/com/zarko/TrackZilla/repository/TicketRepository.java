package com.zarko.TrackZilla.repository;

import com.zarko.TrackZilla.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
