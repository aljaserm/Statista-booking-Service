package com.statista.code.challenge.services;

import com.statista.code.challenge.models.Booking;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService implements BookingServiceInterface {

    private final Map<String, Booking> bookings = new HashMap<>();

    @Override
    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        // Simulate sending an email
        System.out.println("Sending email to: " + booking.getEmail());
    }

    @Override
    public void updateBooking(String bookingId, Booking booking) {
        bookings.put(bookingId, booking);
    }

    @Override
    public Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    @Override
    public List<String> getBookingsByDepartment(String department) {
        return bookings.values().stream()
                .filter(b -> b.getDepartment().equalsIgnoreCase(department))
                .map(Booking::getBookingId)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getCurrencies() {
        return bookings.values().stream()
                .map(Booking::getCurrency)
                .collect(Collectors.toSet());
    }

    @Override
    public BigDecimal getSumByCurrency(String currency) {
        return bookings.values().stream()
                .filter(b -> b.getCurrency().equalsIgnoreCase(currency))
                .map(Booking::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String doBusiness(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            switch (booking.getDepartment().toLowerCase()) {
                case "sales":
                    return "Performing sales business logic";
                case "marketing":
                    return "Performing marketing business logic";
                case "finance":
                    return "Performing finance business logic";
                default:
                    return "Performing generic business logic";
            }
        }
        return "Booking not found";
    }
}
