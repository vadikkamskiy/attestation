package com.gridnine.testing.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.gridnine.testing.models.Flight;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
            .filter(flight -> flight.getSegments().stream()
                .allMatch(segment -> !segment.getArrivalDate().isBefore(segment.getDepartureDate())))
            .collect(Collectors.toList());
    }
}
