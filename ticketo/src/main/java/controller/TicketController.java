package controller;

import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.TicketRepository;

import java.util.*;

@RestController
public class TicketController  {


    @Autowired
    TicketRepository ticketRepository;

    @PostMapping("/bookTickets")
    public String bookTickets(@RequestBody List<Ticket> ticket){

        ticketRepository.save(ticket);
        return "Ticket booked"+ ticket.size();
    }

    @GetMapping("/getTickets")
    public List<Ticket> getTickets(){
        return (List<Ticket>) ticketRepository.findAll();
    }

}
