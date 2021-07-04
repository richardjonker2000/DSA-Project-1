/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railroad;

import java.util.TreeMap;

/**
 * The application class for a RailRoad system, all functionalities of the program
 * can be accessed here.
 * <p>
 * The application uses two treemaps to store the Trains and Stations that the
 * user creates.</p>
 *
 * @author Richard Jonker (a40527)
 * @author Paolo Cagol (a40956)
 */
public class RR {

    /**
     * The treemap containing all the stations created during runtime
     */
    private TreeMap<String, Station> stations;
    /**
     * The treemap containing all the trains created during runtime
     */
    private TreeMap<String, Train> trains;

    /**
     * Default constructor for the class. Initializes the two treemaps stations
     * and trains
     */
    public RR() {
        stations = new TreeMap<>();
        trains = new TreeMap<>();
    }

    /**
     * Adds a {@link Train} to the trains treemap, checking that the Train does
     * not already exist in the trains treemap
     * <p>
     * First checks that the trains treemap does not contain the {@link Train}.
     * It then uses
     * {@link java.util.TreeMap#put(java.lang.Object, java.lang.Object) put()}
     * to add the {@link Train} to the treemap It then checks if the
     * {@link Train} is now inside the collection, and returns True, if it is
     * inside. Returns False in all other scenarios
     * </P>
     *
     * @param acr The {@link Train} of the Train to be created
     * @return True if the {@link Train} was added successfully, False if it was
     * not added.
     */
    public boolean addTrain(String acr) {
        if (trains.containsKey(acr)) {
            System.out.println("Train " + acr + " already exists");
            return false;
        } else {
            trains.put(acr, new Train(acr));
            if (trains.containsKey(acr)) {
                return true;
            } else {
                System.out.println("Train not inserted");
                return false;

            }
        }
    }

    /**
     * Adds a {@link Station} to the stations treemap, checking that the Station
     * does not already exist in the station treemap
     * <p>
     * First checks that the stations treemap does not contain the
     * {@link Station}. It then uses
     * {@link java.util.TreeMap#put(java.lang.Object, java.lang.Object) put()}
     * to add the {@link Station} to the treemap It then checks if the
     * {@link Station} is now inside the collection, and returns True, if it is
     * inside. Returns False in all other scenarios
     * </P>
     *
     * @param acr The acronym of the {@link Station} to be created
     * @param loc The location of the {@link Station} to be created
     * @return True if the {@link Station} was added successfully, False if it
     * was not added.
     */
    public boolean addstation(String acr, String loc) {
        if (stations.containsKey(acr)) {
            System.out.println("Station " + acr + " already exists");
            return false;
        } else {
            stations.put(acr, new Station(acr, loc));
            if (stations.containsKey(acr)) {
                return true;
            } else {
                System.out.println("Station not inserted");
                return false;
            }
        }
    }

    /**
     * Creates a Connection between two {@link Station Stations}, checking if
     * they are both present in the stations treemap
     * <p>
     * The function first checks that both of the stations are present in the
     * treemap. If they are both present, the function then returns the
     * {@link Station#addConnection(Station) addConnection()} method The
     * function returns false in all other scenarios.
     * </p>
     *
     * @param st The acronym of the first {@link Station}
     * @param stOfConnection The acronym of the {@link Station} you wish to
     * create a connection with
     * @return True if the connection was added successfully, False if it was
     * not added.
     */
    public boolean addConnectiontoStation(String st, String stOfConnection) {
        Station stat = stations.get(st);
        if (stat != null) {
            Station statOfConnection = stations.get(stOfConnection);
            if (statOfConnection != null) {
                return stat.addConnection(statOfConnection);
            } else {
                System.out.println("Station " + stOfConnection + " does not exisit");
                return false;
            }
        } else {
            System.out.println("Station " + st + " does not exisit");
            return false;
        }

    }

    /**
     * Creates a {@link Passage} between a Train and a Station, checking if they
     * are both present in the stations and trains treemap respectively
     * <p>
     * The function first checks that train and station are inside their
     * respective treemaps. If they are, the function returns
     * {@link Train#passByStation(Station, int, boolean) passByStation()}. The
     * function returns false in all other scenarios.
     * </p>
     *
     * @param tra The acronym of the {@link Train} that passes the
     * {@link Station}
     * @param sta The acronym of the {@link Station}
     * @param lin The line number that the {@link Train} passes the
     * {@link Station} on
     * @param to True if the {@link Train} stopped at the {@link Station}; False
     * if it did not stop
     * @return True if the {@link Passage} was created; False if it was not
     */
    public boolean crossTrainByStation(String tra, String sta, int lin, boolean to) {
        Station stat = stations.get(sta);
        if (stat != null) {
            Train train = trains.get(tra);
            if (train != null) {
                return train.passByStation(stat, lin, to);
            } else {
                System.out.println("Train " + tra + " does not exisit");
                return false;
            }
        } else {
            System.out.println("Station " + sta + " does not exisit");
            return false;
        }

    }

    /**
     * Creates a String with all the {@link Passage Passages} at a
     * {@link Station}, using the
     * {@link Station#passagesToString() passagesToString()}
     * <p>The method checks if the {@link Station} is inside the stations treemap 
     * first, and returns an appropriate String if it is not.</p>
     *
     * @param acr The acronym of the {@link Station}
     * @return A String containing all the {@link Passage Passages} at a
     * {@link Station}
     */
    public String crossesStationToString(String acr) {
        Station stat = stations.get(acr);
        if (stat != null) {
            return stat.passagesToString();
        } else {
            return "The station " + acr + " does not exist";
        }

    }

    /**
     * Creates a String with all the {@link Passage Passages} on a
     * {@link Train}, where the {@link Train} stopped at the {@link Station},
     * using the {@link Train#stopsToString() stopsToString()}
     * <p>The method checks if the {@link Train} is inside the trains treemap 
     * first, and returns an appropriate String if it is not.</p>
     *
     * @param acr The acronym of the {@link Train}
     * @return A String with all the {@link Passage Passages} on a
     * {@link Train}, where the {@link Train} stopped at the {@link Station}
     */
    public String stopTrainToString(String acr) {
        Train tra = trains.get(acr);
        if (tra != null) {
            return tra.stopsToString();
        } else {
            return "The train " + acr + " does not exist";
        }
    }

}
