package models;


import lombok.Builder;
import lombok.Data;

@Builder
public @Data class Booking {
    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public BookingDates bookingdates;
    public String additionalneeds;
}
