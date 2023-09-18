package com.ravi.learn.learningspring.WebServiceController;

import com.ravi.learn.learningspring.Data.Guest;
import com.ravi.learn.learningspring.business.ReservationService;
import com.ravi.learn.learningspring.business.RoomReservation;
import com.ravi.learn.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WerbServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WerbServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required=false) String dateString, Model model){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations  = this.reservationService.getRoomReservationsForDate(date);
       return roomReservations;
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuests(){
       return this.reservationService.getGuests();
    }

    @RequestMapping(path = "/guests", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void putGuests(@RequestBody Guest guest){
       this.reservationService.putGuests(guest);
    }
}
