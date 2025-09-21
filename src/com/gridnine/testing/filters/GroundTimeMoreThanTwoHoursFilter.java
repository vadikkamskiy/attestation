package com.gridnine.testing.filters;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.gridnine.testing.models.Flight;

public class GroundTimeMoreThanTwoHoursFilter implements FlightFilter {
    private static final Duration MAX_GROUND_TIME = Duration.ofHours(2);

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
            .filter(flight ->
                IntStream.range(0, flight.getSegments().size() - 1)
                    .noneMatch(i -> Duration.between(
                        flight.getSegments().get(i).getArrivalDate(),
                        flight.getSegments().get(i + 1).getDepartureDate()
                    ).compareTo(MAX_GROUND_TIME) > 0)
            )
            .collect(Collectors.toList());
    }
}