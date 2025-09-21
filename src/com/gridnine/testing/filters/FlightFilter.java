package com.gridnine.testing.filters;

import java.util.List;

import com.gridnine.testing.models.Flight;

public interface FlightFilter {
    public List<Flight> filter(List<Flight> flights);
}
