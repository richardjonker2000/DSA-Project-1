/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railroad;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *This is the class that represents a Station.
 * <p>
 * Has 2 variables, both Strings, acronym and local. acronym is the acronym of the {@link Station}
 * and local is the location of the {@link Station}<br>
 * The class also has 2 LinkedHashSet, one for {@link Passage passages} and the other for connections with other {@link Station Stations}
 * 
 * </p>
 * @author Richard Jonker (a40527)
 * @author Paolo Cagol (a40956)
 */
 
public class Station {

    private String acronym;
    private String local;
    private LinkedHashSet<Passage> passages;
    private LinkedHashSet<Station> connections;
    
    /**
     * Initializes all variables and LinkedHashSets
     * @param acr The acronym of the {@link Station}
     * @param loc The location (local) of the {@link Station}
     */

    public Station(String acr, String loc) {
       
        acronym = acr;
        local = loc;
        passages = new LinkedHashSet<>();
        connections = new LinkedHashSet<>();
    }

    /**
     * Getter for local
     * @return local, the location of the {@link Station}
     */
    public String getLocation() {
        return local;
    }

    /**
     * Creates a connection with another {@link Station}
     * <p>
     * The function adds the connection if it does not already exisit. <br>
     * If the other {@link Station} already has this connections, the function returns true,
     * if it does not, the function calls itself from the perspective of the other {@link Station}.
     * </p>
     * @param other The other {@link Station} to create a connection with
     * @return True, if both the {@link Station stations} have the connection after running the function, False in any other situation.
     */
    public boolean addConnection(Station other) {
        if (!this.hasConnectionWith(other)) {
            if (connections.add(other)) {
                if (other.hasConnectionWith(this)) {
                    return true;
                } else {
                    return other.addConnection(this);
                }
            } else {
                
                return false;
            }

        } else {
            System.out.println("Connection between " + this.getLocation() + " and " + other.getLocation() + " already exists");
            return false;
        }

    }
    /**
     * Returns whether or not the {@link Station} has a connection with the other {@link Station}.
     * @param other The other {@link Station}
     * @return True if this {@link Station} has a connection with the other {@link Station}, False if it does not.
     */

    public boolean hasConnectionWith(Station other) {

        return connections.contains(other);
    }

    /**
     * Adds a {@link Passage} to the passages LinkedHashSet
     * @param p The {@link Passage}
     * @return True if the {@link Passage} was added successfully; False if it was not
     */
    public boolean addPassage(Passage p) {
        return passages.add(p);

    }

    /**
     * ToString for the {@link Passage passages} of the {@link Station}
     * @return A String with all the toStrings of the {@link Passage passages} at this {@link Station} 
     */
    public String passagesToString() {
        String pass = "Station " + acronym + ":\n";
        Iterator it = passages.iterator();
        while (it.hasNext()) {
            Passage p = (Passage) it.next();
            pass += "" + p.toString() + "\n";
        }
        return pass;
    }

}
