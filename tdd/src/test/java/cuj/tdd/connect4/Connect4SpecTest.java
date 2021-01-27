package cuj.tdd.connect4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Connect4SpecTest {

    private Connect4Spec connect4Spec;

    @Before
    public void beforeEachTest(){
        connect4Spec = new Connect4Spec();
    }

    @Test
    public void whenTheGameIsStartedTheBoardIsEmpty(){
        Assert.assertEquals(0,connect4Spec.getNumberOfDiscs());
    }
    @Test(expected = RuntimeException.class)
    public void whenDiscOutsideDiscThenRuntimeException(){
        int column = -1;
        connect4Spec.putDiscInColumn(column);
        column = Connect4Spec.COLUMNS;
        connect4Spec.putDiscInColumn(column);
    }
    @Test(expected = RuntimeException.class)
    public void whenDiscOutsideDiscThenRuntimeException2(){
        int column = Connect4Spec.COLUMNS;
        connect4Spec.putDiscInColumn(column);
    }
    @Test()
    public void whenFirstDiscInsertInColumnThenPositionIsZero(){
        int column = 1;
        Assert.assertEquals(0,connect4Spec.putDiscInColumn(column));
    }
    @Test()
    public void whenSecondDiscInsertInColumnThenPositionIsOne(){
        int column = 1;
        connect4Spec.putDiscInColumn(column);
        Assert.assertEquals(1,connect4Spec.putDiscInColumn(column));
    }

    @Test
    public void whenDiscInsertedThenNumberOfDiscsIncreases(){
        int column = 1;
        connect4Spec.putDiscInColumn(column);
        Assert.assertEquals(1,connect4Spec.getNumberOfDiscs());
    }
    @Test(expected = RuntimeException.class)
    public void whenNoMoreRoomInColumnTheRuntimeException(){
        int column = 0;
        int maxDiscsInColumn = 6;
        for(int time = 0;time<maxDiscsInColumn;time++){
            connect4Spec.putDiscInColumn(column);
        }
        connect4Spec.putDiscInColumn(column);
    }

    @Test
    public void whenFirstPlayerPlaysTheDiscColorIsRed(){
        Assert.assertEquals(Color.RED.toString(),connect4Spec.getCurrentPlayer());
    }
    @Test
    public void whenSecondPlayerPlaysTheDiscColorIsGreen(){
        int column = 1;
        connect4Spec.putDiscInColumn(column);
        Assert.assertEquals(Color.GREEN.toString(),connect4Spec.getCurrentPlayer());
    }
}