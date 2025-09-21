package com.gridnine.testing;

import java.util.List;

import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.DepartureBeforeNowFilter;
import com.gridnine.testing.filters.GroundTimeMoreThanTwoHoursFilter;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;

public class App {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter departureBeforeNowFilter = new DepartureBeforeNowFilter();
        printFilteredFlights("Filtered flights with departure before now:", departureBeforeNowFilter.filter(flights));

        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        printFilteredFlights("Filtered flights with segment arrival before departure:", arrivalBeforeDepartureFilter.filter(flights));

        FlightFilter groundTimeMoreThanTwoHoursFilter = new GroundTimeMoreThanTwoHoursFilter();
        printFilteredFlights("Filtered flights with ground time more than 2 hours:", groundTimeMoreThanTwoHoursFilter.filter(flights));
    }

    private static void printFilteredFlights(String header, List<Flight> flights) {
        System.out.println(header);
        flights.forEach(f -> System.out.println(f));
        System.out.println("--------------------------------------------------------");
    }
}
