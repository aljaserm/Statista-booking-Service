package com.statista.code.challenge.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a booking with necessary details.
 */
@Schema(description = "Represents a booking with necessary details.")
public class Booking {
    @NotBlank
    @Schema(description = "Unique identifier for the booking", example = "1")
    private String bookingId;

    @Schema(description = "Description of the booking", example = "Test booking")
    private String description;

    @NotNull
    @Schema(description = "Price of the booking", example = "100.00")
    private BigDecimal price;

    @NotBlank
    @Schema(description = "Currency of the booking price", example = "USD")
    private String currency;

    @NotNull
    @Schema(description = "Subscription start date", example = "2023-01-01")
    private LocalDate subscriptionStartDate;

    @Email
    @NotBlank
    @Schema(description = "Email of the person making the booking", example = "test@example.com")
    private String email;

    @NotBlank
    @Schema(description = "Department associated with the booking", example = "sales")
    private String department;

    // Getters and Setters

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
