import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MiniStageTest {

    @Test
    public void isSwimLaneExist() {
        MiniStage miniStage = new MiniStage("0", "first");
        assertTrue(miniStage.isSwimLaneExist(miniStage.getDefaultSwimLane().getId()));
        assertFalse(miniStage.isSwimLaneExist("123"));
    }

    @Test
    public void getSwimLaneById() {
        MiniStage miniStage = new MiniStage("0", "first");
        assertEquals(miniStage.getDefaultSwimLane(),
                miniStage.getSwimLaneById(miniStage.getDefaultSwimLane().getId()));
    }

    @Test(expected = RuntimeException.class)
    public void getSwimLaneByIdFail() {
        MiniStage miniStage = new MiniStage("0", "first");
        miniStage.getSwimLaneById("123");
    }

}