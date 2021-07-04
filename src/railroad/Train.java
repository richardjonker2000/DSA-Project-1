/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railroad;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *This is the class that represents a Train.
 * <p>
 * The acronym is its only variable, and it also has a linkedHashSet, {@link Passage passages}
 * for each train.
 * </p>
 * @author Richard Jonker (a40527)
 * @author Paolo Cagol (a40956)
 */
public class Train {
    /**
     * Stores the acronym of the {@link Train}
     */
    private String acronym;
    private LinkedHashSet<Passage> passages;

    /**
     * Creates a {@link Train} and initializes the LinkedHashSet of 
     * {@link Passage passages}, as well as the acronym of the {@link Train}.
     * @param acr The acronym of the {@link Train}.
     */
    public Train(String acr) {
        acronym = acr;
        passages = new LinkedHashSet<>();
    }

    /**
     * Getter for the acronym of the {@link Train}.
     * @return The acronym of the {@link Train}.
     */
    public String getAcronym() {
        return acronym;
    }
    

    /**
     * Returns the last {@link Station} that the {@link Train} {@link Passage passed} through. 
     * <p>
     * First checks that the {@link Train} has {@link Passage passed} through a
     * {@link Station}. If it has, then it finds the last {@link Passage} and returns 
     * the {@link Station} in that {@link Passage}.
     * </p>
     * @return The last {@link Station} that the {@link Train} {@link Passage passed} through, otherwise it returns NULL. 
     */
    public Station lastStation() {
        if (passages.size() - 1 < 0) {
            return null;
        }
        Passage last = (Passage) (passages.toArray()[passages.size() - 1]);
        return last.getStation();

    }
    
    /**
     * {@link Passage Passes} a {@link Train} through a {@link Station}.
     * <p>
     * First, the function calculates the {@link Passage} ID, unique for each {@link Train}.
     * <br>The function then gets the {@link Train#lastStation() last station}, 
     * checks that either it has no previous {@link Passage passages} or that the {@link Station}
     * has a Connection with the provided {@link Station}, as {@link Train trains} 
     * need to come from another {@link Station}.
     * <br>After, it creates a {@link Passage} with the {@link Station}, adds it to the LinkedHashSet passages, 
     * for the {@link Train}, and if it is successful it adds it to the {@link Station} using {@link Station#addPassage(Passage)}, and returns.
     * </p>
     * @param st The {@link Station} the {@link Train} {@link Passage passes}.
     * @param lin The line which the {@link Train} {@link Passage passes} the {@link Station} on.
     * @param to True if the {@link Train} stopped at the {@link Station}, False if it just Passed though.
     * @return True if the {@link Passage} was added successfully to both {@link Train} and {@link Station},
     * False if it failed at any point.
     */

    public boolean passByStation(Station st, int lin, boolean to) {
        int id = passages.size() + 1;
        Station stat = this.lastStation();
        if (stat == null || stat.hasConnectionWith(st)) {
            Passage p = new Passage(id, to, lin, st, this);
            if (passages.add(p)) {
                return st.addPassage(p);
            } else {
                return false;
            }
        } else {
            System.out.println("Connection is missing between "+stat.getLocation()+" and "+st.getLocation());
            return false;
        }

    }
    
    /**
     * Returns a String containing all the stops of a {@link Train}.
     * <p>Using an Iterator and a while loop, the function runs the 
     * {@link Passage#toString() toString()} for each {@link Passage}, and creates a string with it</p>
     * @return String containing all the stops of a {@link Train}.
     */

    public String stopsToString() {
        String stops = "Train " + acronym + ":\n";
        Iterator it = passages.iterator();
        while (it.hasNext()) {
            Passage p = (Passage) it.next();
            if (p.hasStop()) {
                stops += "" + p.toString() + "\n";
            }

        }
        return stops;
    }

}
