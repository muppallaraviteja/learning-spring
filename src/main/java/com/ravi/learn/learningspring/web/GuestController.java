package com.ravi.learn.learningspring.web;

import com.ravi.learn.learningspring.Data.Guest;
import com.ravi.learn.learningspring.Data.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    @RequestMapping
    public String findAllGuests(Model model){
        List<Guest> guests = (List<Guest>)guestRepository.findAll();
        System.out.println(guests.get(0).getFirstName());
        model.addAttribute("guests",guests);
        return "guests";
    }

}
