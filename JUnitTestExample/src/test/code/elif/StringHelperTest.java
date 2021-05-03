package code.elif;

import org.junit.Test;


import static org.junit.Assert.*;

public class StringHelperTest {

    @Test
    public void truncateAInFirst2Positions() {
        StringHelper stringHelper = new StringHelper();
        String result = stringHelper.truncateAInFirst2Positions("ASDC");
        assertEquals("SDC", result);
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSame() {
        fail("Test is fail!");
    }


}