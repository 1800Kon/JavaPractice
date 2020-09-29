import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlUtilityTest {

    @Test //This works
    void urlMaker() {
        assertEquals("jeff", UrlUtility.urlMaker("Jeff8 76//(&% ^*$&%# @!$ "));
    }
}