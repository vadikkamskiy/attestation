package com.gridnine.testing.filters;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

public class GroundTimeMoreThanTwoHoursFilter implements FlightFilter {
    private static final Duration MAX_TOTAL_GROUND_TIME = Duration.ofHours(2);

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
            .filter(flight -> {
                List<Segment> segments = flight.getSegments();
                Duration totalGroundTime = Duration.ZERO;

                for (int i = 0; i < segments.size() - 1; i++) {
                    Duration groundTime = Duration.between(
                        segments.get(i).getArrivalDate(),
                        segments.get(i + 1).getDepartureDate());
                    totalGroundTime = totalGroundTime.plus(groundTime);

                    if (totalGroundTime.compareTo(MAX_TOTAL_GROUND_TIME) > 0) {
                        return false;
                    }
                }
                return true;
            })
            .collect(Collectors.toList());
    }
}
