# RailMate API 🚆🎫

This is a  train ticket booking API built with Spring Boot, using Hibernate, JPA, and MySQL for managing ticket reservations. The system allows users to book and cancel seats for train journeys, ensuring seat availability and managing bookings via PNR numbers.

## Features ✨

- **Book Tickets**: Allows users to book available seats for a given journey. 🎟️
- **Cancel Tickets**: Users can cancel their booked tickets and free up seats. ❌
- **Seat Availability Check**: Provides available seats for booking or cancellation based on source and destination. 📊
- **PNR Generation**: A unique PNR number is generated for each booking. 📑
- **Real-Time Updates**: Updates the status of bookings and cancellations in the database. 🔄

## Tech Stack 🧰

- **Backend**: Spring Boot 🌱
- **Programming Language**: Java (Spring Framework) 🖥️
- **Persistence**: Hibernate, JPA 🛠️
- **Database**: MySQL 🗄️
- **Web Framework**: Spring MVC 🕸️
- **Transaction Management**: `@Transactional` annotations for database transactions 🔄

## Endpoints 📡

### Book Tickets 🎫
**Endpoint:**
` POST /TCApp/book`

 **Description:**  
Books the selected seats for a given journey.  


Request Body:
```json
{
  "from": "A", 
  "to": "B", 
  "seatList": [1, 2, 3]
}
```

Response

{
  "message": "Ticket booked successfully with the pnrNumber 12345"
}


### Cancel Tickets ❌

**Endpoint:**  
 `POST /TCApp/cancelSeat`
 
 **Description:**  
Cancels the selected tickets using the PNR number.

Request Body:
```json

{
  "pnrNo": 12345,
  "seatList": [1, 2]
}

```
Response

```json
{
  "message": "Ticket Cancelled"
}
```
### Get Available Seats for Booking 📊

**Endpoint:**  
`GET /TCApp/getAllSeatsBooking`

**Description:**  
Fetches available seats between a source and destination.


**Response:**
```json
[1, 2, 3, 4, 5]

```

### Get Available Seats for Cancelling ❌

**Endpoint:**  
`GET /TCApp/getAllSeatsCancelling`

**Description:**  
Fetches the booked seats for a given PNR number.



**Response:**
```json
[1, 2]
