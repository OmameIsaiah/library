package com.library.app.demo;

import java.util.*;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;


public class ChefSchedulerTest {
/*
    @Test

 */
    public void itShouldWorkOnBasicExamples() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        new String[] {"mon", "tue", "wed", "fri", "sat", "sun"}
                ))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        new String[] {"tue", "wed", "thu", "sun"}
                ))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        new String[] {"mon", "sat"}
                ))
        );
        requests.put(
                "zach", new ArrayList<>(Arrays.asList(new String[] {}))
        );
        /*
        assertEquals(
                "it should work on a basic example.",
                true, ChefScheduler.schedulable(requests)
        );

         */

        requests.clear();

    }
}