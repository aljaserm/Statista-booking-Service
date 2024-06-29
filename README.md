# Booking Service API

This is a RESTful web service for managing bookings, developed by the Statista PIT team. It allows you to create, update, and retrieve booking information, perform business logic based on the booking details, and more.

## Prerequisites

- JDK 21
- Maven
- IntelliJ IDEA (recommended) or your preferred Java IDE
- Bash environment with 'curl' or Postman for testing

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/aljaserm/Statista-booking-Service.git
cd Statista-booking-Service
```

### Build the Project

```sh
mvn clean install
```

### Run the Application

```sh
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Documentation

### Swagger UI

The API is documented using Swagger. After starting the application, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

This interface allows you to interact with the API, see the available endpoints, and test them directly from your browser.

## API Endpoints

### Create a Booking

- **Endpoint**: `POST /bookingservice/bookings`
- **Description**: Creates a new booking and sends an email with the details.

### Update a Booking

- **Endpoint**: `PUT /bookingservice/bookings/{bookingId}`
- **Description**: Inserts or replaces an existing booking.

### Get a Booking by ID

- **Endpoint**: `GET /bookingservice/bookings/{bookingId}`
- **Description**: Returns the specified booking as JSON.

### Get Bookings by Department

- **Endpoint**: `GET /bookingservice/bookings/department/{department}`
- **Description**: Returns a JSON list of all booking IDs with the given department.

### Get All Currencies

- **Endpoint**: `GET /bookingservice/bookings/currencies`
- **Description**: Returns a JSON list with all used currencies in the existing bookings.

### Get Sum of Bookings by Currency

- **Endpoint**: `GET /bookingservice/sum/{currency}`
- **Description**: Returns the sum of all booking prices with the given currency.

### Perform Business Logic on a Booking

- **Endpoint**: `GET /bookingservice/bookings/dobusiness/{bookingId}`
- **Description**: Returns the result of `doBusiness()` for the given booking's corresponding department.

## Testing

You can test the API endpoints using `curl`, Postman, or Swagger UI.

### Using `curl`

Example to create a new booking:
```sh
curl -X POST http://localhost:8080/bookingservice/bookings \
-H "Content-Type: application/json" \
-d '{
  "bookingId": "1",
  "description": "Test booking",
  "price": 100.00,
  "currency": "USD",
  "subscriptionStartDate": "2023-01-01",
  "email": "test@example.com",
  "department": "sales"
}'
```

### Using Postman

Import the API endpoints into Postman using the Swagger JSON from `http://localhost:8080/v3/api-docs`.

### Using Swagger UI

Navigate to `http://localhost:8080/swagger-ui.html` and interact with the API directly through the Swagger interface.

---
