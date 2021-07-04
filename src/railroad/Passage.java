/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railroad;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The class representing the passage of a {@link Train} though a {@link Station}.
 * <p>
 * The class has:<br> An id<br>A date and time of passage (dateHour)
 * <br>A boolean representing whether or not the {@link Train} stopped a the {@link Station} (withStop)
 * <br>The line number that the {@link Train} passed the {@link Station on} (line)
 * <br>The {@link Station} (station)
 * <br>The {@link Train} (train)
 * 
 * 
 * </p>
 *
 * @author Richard Jonker (a40527)
 * @author Paolo Cagol (a40956)
 */
public class Passage {

    private int id;
    private Date dateHour;
    private boolean withStop;
    private int line;
    private Station station;
    private Train train;
    

    /**
     * Initializes all variables
     * <p>dateHour is initialized with the current date</p>
     * @param id  The id of the passage
     * @param to  A boolean representing whether or not the {@link Train} stopped a the {@link Station}
     * @param lin The line number that the {@link Train} passed the {@link Station on} (line)
     * @param s The {@link Station} (station)
     * @param t The {@link Train} (train)
     */
    public Passage(int id, boolean to, int lin, Station s, Train t) {
        this.id = id;
        withStop = to;
        line = lin;
        station = s;
        train = t;
        dateHour = new Date();
    }

    /**
     * Getter for the withStop variable.
     * @return A boolean representing whether or not the {@link Train} stopped a the {@link Station}     
     */
    public boolean hasStop() {
        return withStop;
    }
    
/**
 * Getter for the {@link Station}.
 * @return {@link Station station}
 */
    public Station getStation() {
        return station;
    }
/**
 * The toString for the Passage
 * @return A String containing the information for the {@link Passage}
 */
    @Override
    public String toString() {
        String dhFormat = (new SimpleDateFormat("dd/MM/yyyy 'at' kk:mm:ss")).format(dateHour);
        if (withStop) {
            return "Train " + train.getAcronym() + " stopped at station " + station.getLocation() + " on line " + line + " on " + dhFormat;
        } else {
            return "Train " + train.getAcronym() + " passed station " + station.getLocation() + " on line " + line + " on " + dhFormat;
        }
    }

}
