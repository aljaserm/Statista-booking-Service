package com.statista.code.challenge.services;

import com.statista.code.challenge.models.Booking;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Interface for booking services.
 */
public interface BookingServiceInterface {

    /**
     * Adds a new booking.
     *
     * @param booking the booking to add
     */
    void addBooking(Booking booking);

    /**
     * Updates an existing booking.
     *
     * @param bookingId the ID of the booking to update
     * @param booking the updated booking details
     */
    void updateBooking(String bookingId, Booking booking);

    /**
     * Retrieves a booking by ID.
     *
     * @param bookingId the ID of the booking to retrieve
     * @return the booking details
     */
    Booking getBooking(String bookingId);

    /**
     * Retrieves bookings by department.
     *
     * @param department the department to filter bookings by
     * @return the list of bookings
     */
    List<String> getBookingsByDepartment(String department);

    /**
     * Retrieves all available currencies.
     *
     * @return the set of currencies
     */
    Set<String> getCurrencies();

    /**
     * Retrieves the sum of bookings by currency.
     *
     * @param currency the currency to sum bookings by
     * @return the sum of bookings
     */
    BigDecimal getSumByCurrency(String currency);

    /**
     * Performs business logic based on booking ID.
     *
     * @param bookingId the ID of the booking to perform business logic on
     * @return the result of the business logic
     */
    String doBusiness(String bookingId);
}
