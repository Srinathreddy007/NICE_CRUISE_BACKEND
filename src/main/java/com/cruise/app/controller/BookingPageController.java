package com.cruise.app.controller;

import com.cruise.app.dto.BookingDTO;
import com.cruise.app.model.Passenger;
import com.cruise.app.service.BookingDeleteService;
import com.cruise.app.service.BookingService;
import com.cruise.app.service.PassengerService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class BookingPageController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingDeleteService bookingDeleteService;

    @Autowired
    private PassengerService passengerService;
    @PostMapping("/booking")
    public ResponseEntity<?> bookingPageData(@RequestBody JsonNode bookingData) {
        try {

            // Validates the incoming JSON data before processing
            if (bookingData == null || bookingData.isEmpty()) {
                return ResponseEntity.badRequest().body("Invalid request data");
            }

            Map<String, Object> passAndGroupId = bookingService.savePassengers(bookingData);

            // Check if the returned map is empty or not, based on your service logic
            if (passAndGroupId == null || passAndGroupId.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process booking data");
            }

            // You can customize the response based on the content of passAndGroupId
            return ResponseEntity.ok(passAndGroupId);  // Now returning the actual map to see the results

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }
    @GetMapping("/manage-booking")
    public ResponseEntity<?> readBooking(@RequestParam String email) {
//        List<Passenger> passengerList =
        List<Map<String, Object>> jsonList = passengerService.getBookedList(email);
        return ResponseEntity.ok(jsonList);
    }
    @DeleteMapping("/delete-booking")
    public ResponseEntity<?> deleteBooking(@RequestBody List<BookingDTO> testBooking) {
        for(BookingDTO bookingDTO:testBooking) {
            bookingDeleteService.deleteBooking(bookingDTO);
        }
        System.out.println(testBooking);

        return ResponseEntity.ok("hello world");

    }
    @DeleteMapping("/delete-all")
    public String deleteAllData() {
        passengerService.deleteAllData();
        return "All data deleted successfully";
    }
}
