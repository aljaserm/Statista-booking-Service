package com.statista.code.challenge.tests;

import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.services.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BookingService class.
 */
class BookingServiceTest {

    private BookingService bookingService;

    /**
     * Sets up the BookingService instance before each test.
     */
    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
    }

    /**
     * Tests adding and retrieving a booking.
     *
     * This test creates a booking, adds it to the service, and then retrieves it
     * to verify that the addition was successful and the data is correct.
     */
    @Test
    void testAddAndGetBooking() {
        Booking booking = createTestBooking("1", "Test booking", BigDecimal.valueOf(100), "USD", LocalDate.now(), "test@example.com", "sales");

        bookingService.addBooking(booking);

        Booking retrieved = bookingService.getBooking("1");
        assertNotNull(retrieved);
        assertEquals("Test booking", retrieved.getDescription());
    }

    /**
     * Tests updating an existing booking.
     *
     * This test creates a booking, adds it to the service, updates it with new data,
     * and then retrieves it to verify that the update was successful and the data is correct.
     */
    @Test
    void testUpdateBooking() {
        Booking booking = createTestBooking("1", "Test booking", BigDecimal.valueOf(100), "USD", LocalDate.now(), "test@example.com", "sales");

        bookingService.addBooking(booking);

        booking.setDescription("Updated description");
        bookingService.updateBooking("1", booking);

        Booking retrieved = bookingService.getBooking("1");
        assertNotNull(retrieved);
        assertEquals("Updated description", retrieved.getDescription());
    }

    /**
     * Tests retrieving bookings by department.
     *
     * This test creates two bookings in different departments, adds them to the service,
     * and then retrieves bookings by department to verify that the correct bookings are returned.
     */
    @Test
    void testGetBookingsByDepartment() {
        Booking booking1 = createTestBooking("1", "Test booking 1", BigDecimal.valueOf(100), "USD", LocalDate.now(), "test1@example.com", "sales");
        Booking booking2 = createTestBooking("2", "Test booking 2", BigDecimal.valueOf(200), "USD", LocalDate.now(), "test2@example.com", "marketing");

        bookingService.addBooking(booking1);
        bookingService.addBooking(booking2);

        assertEquals(1, bookingService.getBookingsByDepartment("sales").size());
        assertEquals(1, bookingService.getBookingsByDepartment("marketing").size());
    }

    /**
     * Tests retrieving all available currencies.
     *
     * This test creates two bookings with different currencies, adds them to the service,
     * and then retrieves the set of currencies to verify that both currencies are included.
     */
    @Test
    void testGetCurrencies() {
        Booking booking1 = createTestBooking("1", "Test booking 1", BigDecimal.valueOf(100), "USD", LocalDate.now(), "test1@example.com", "sales");
        Booking booking2 = createTestBooking("2", "Test booking 2", BigDecimal.valueOf(200), "EUR", LocalDate.now(), "test2@example.com", "marketing");

        bookingService.addBooking(booking1);
        bookingService.addBooking(booking2);

        assertEquals(2, bookingService.getCurrencies().size());
    }

    /**
     * Tests retrieving the sum of bookings by currency.
     *
     * This test creates two bookings with the same currency, adds them to the service,
     * and then retrieves the sum of prices by currency to verify that the sum is correct.
     */
    @Test
    void testGetSumByCurrency() {
        Booking booking1 = createTestBooking("1", "Test booking 1", BigDecimal.valueOf(100), "USD", LocalDate.now(), "test1@example.com", "sales");
        Booking booking2 = createTestBooking("2", "Test booking 2", BigDecimal.valueOf(200), "USD", LocalDate.now(), "test2@example.com", "marketing");

        bookingService.addBooking(booking1);
        bookingService.addBooking(booking2);

        assertEquals(BigDecimal.valueOf(300), bookingService.getSumByCurrency("USD"));
    }

    /**
     * Tests performing business logic based on booking ID.
     *
     * This test creates a booking, adds it to the service, and then performs business logic
     * based on the booking ID to verify that the correct logic is executed.
     */
    @Test
    void testDoBusiness() {
        Booking booking1 = createTestBooking("1", "Test booking 1", BigDecimal.valueOf(100), "USD", LocalDate.now(), "test1@example.com", "sales");

        bookingService.addBooking(booking1);

        assertEquals("Performing sales business logic", bookingService.doBusiness("1"));
    }


    /**
     * Helper method to create a test booking.
     *
     * @param bookingId the booking ID
     * @param description the booking description
     * @param price the booking price
     * @param currency the booking currency
     * @param subscriptionStartDate the booking subscription start date
     * @param email the booking email
     * @param department the booking department
     * @return a Booking object with the specified properties
     */
    private Booking createTestBooking(String bookingId, String description, BigDecimal price, String currency, LocalDate subscriptionStartDate, String email, String department) {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        booking.setDescription(description);
        booking.setPrice(price);
        booking.setCurrency(currency);
        booking.setSubscriptionStartDate(subscriptionStartDate);
        booking.setEmail(email);
        booking.setDepartment(department);
        return booking;
    }
}
