/* Team: UnBEARables
 * Course: CSI 3471
 * Project: CruiseLink
 * Filename: TravelPathTester.java
 * Creation Date: 10/18/2023
 * Modified Date: 10/18/2023
 * Description: Tests TravelPath
 *
 */

import Domain.TravelPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TravelPathTester {

    protected TravelPath travelpath = null;

    @BeforeEach
    void init() {
        travelpath = new TravelPath();
    }


    @Test
    void addCountry() {

        //Country c = new Country("Mexico");
        travelpath.addCountry(null);
    }

}