package models;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data
class BookingDates {
    public String checkin;
    public String checkout;
}

