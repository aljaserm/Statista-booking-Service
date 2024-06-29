package com.statista.code.challenge.controllers;

import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.services.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST controller for managing bookings.
 */
@RestController
@RequestMapping("/bookingservice")
@Tag(name = "Booking Service API", description = "API for managing bookings")
public class BookingController {

    @Autowired
    private BookingServiceInterface bookingService;

    /**
     * Creates a new booking.
     *
     * @param booking the booking to create
     * @return the response entity with the status and message
     */
    @PostMapping("/bookings")
    @Operation(summary = "Create a new booking")
    public ResponseEntity<String> createBooking(@Valid @RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return new ResponseEntity<>("Booking created", HttpStatus.CREATED);
    }

    /**
     * Updates an existing booking.
     *
     * @param bookingId the ID of the booking to update
     * @param booking the updated booking details
     * @return the response entity with the status and message
     */
    @PutMapping("/bookings/{bookingId}")
    @Operation(summary = "Update an existing booking")
    public ResponseEntity<String> updateBooking(@PathVariable String bookingId, @Valid @RequestBody Booking booking) {
        bookingService.updateBooking(bookingId, booking);
        return new ResponseEntity<>("Booking updated", HttpStatus.OK);
    }

    /**
     * Retrieves a booking by ID.
     *
     * @param bookingId the ID of the booking to retrieve
     * @return the response entity with the booking details
     */
    @GetMapping("/bookings/{bookingId}")
    @Operation(summary = "Get a booking by ID")
    public ResponseEntity<Booking> getBooking(@PathVariable String bookingId) {
        Booking booking = bookingService.getBooking(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    /**
     * Retrieves bookings by department.
     *
     * @param department the department to filter bookings by
     * @return the response entity with the list of bookings
     */
    @GetMapping("/bookings/department/{department}")
    @Operation(summary = "Get bookings by department")
    public ResponseEntity<List<String>> getBookingsByDepartment(@PathVariable String department) {
        List<String> bookings = bookingService.getBookingsByDepartment(department);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    /**
     * Retrieves all available currencies.
     *
     * @return the response entity with the set of currencies
     */
    @GetMapping("/bookings/currencies")
    @Operation(summary = "Get all available currencies")
    public ResponseEntity<Set<String>> getCurrencies() {
        Set<String> currencies = bookingService.getCurrencies();
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }

    /**
     * Retrieves the sum of bookings by currency.
     *
     * @param currency the currency to sum bookings by
     * @return the response entity with the sum
     */
    @GetMapping("/sum/{currency}")
    @Operation(summary = "Get sum of bookings by currency")
    public ResponseEntity<BigDecimal> getSumByCurrency(@PathVariable String currency) {
        BigDecimal sum = bookingService.getSumByCurrency(currency);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    /**
     * Performs business logic based on booking ID.
     *
     * @param bookingId the ID of the booking to perform business logic on
     * @return the response entity with the result
     */
    @GetMapping("/bookings/dobusiness/{bookingId}")
    @Operation(summary = "Perform business logic on a booking")
    public ResponseEntity<String> doBusiness(@PathVariable String bookingId) {
        String result = bookingService.doBusiness(bookingId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
