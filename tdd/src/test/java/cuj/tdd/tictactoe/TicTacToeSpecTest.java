package cuj.tdd.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpecTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();
    private TicTacToeSpec ticTacToeSpec;

    @Before
    public final void before(){
        ticTacToeSpec = new TicTacToeSpec();
        Assert.assertEquals('X',ticTacToeSpec.nextPlayer());
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        expected.expect(RuntimeException.class);
        ticTacToeSpec.play(5,3);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        expected.expect(RuntimeException.class);
        ticTacToeSpec.play(2,5);
    }

    @Test
    public void whenOccupiedThenRuntimeException(){
        ticTacToeSpec.play(2,1);
        expected.expect(RuntimeException.class);
        ticTacToeSpec.play(2,1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        Assert.assertEquals('X',ticTacToeSpec.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO(){
        ticTacToeSpec.play(1,1);
        Assert.assertEquals('O',ticTacToeSpec.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner(){
        String actual = ticTacToeSpec.play(1,1);
        Assert.assertEquals("No winner",actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){
        ticTacToeSpec.play(1,1);//X
        ticTacToeSpec.play(1,2);//O
        ticTacToeSpec.play(2,1);//X
        ticTacToeSpec.play(2,2);//O
        String actual = ticTacToeSpec.play(3,1);//X
        Assert.assertEquals("X is winner",actual);
    }
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner(){
        ticTacToeSpec.play(2,1);//X
        ticTacToeSpec.play(1,1);//O
        ticTacToeSpec.play(3,1);//X
        ticTacToeSpec.play(1,2);//O
        ticTacToeSpec.play(2,2);//X
        String actual = ticTacToeSpec.play(1,3);//O
        Assert.assertEquals("O is winner",actual);
    }
    @Test
    public void whenPlayAndTopBotBottomDiagonalLineThenWinner(){
        ticTacToeSpec.play(1,1);//X
        ticTacToeSpec.play(1,2);//O
        ticTacToeSpec.play(2,2);//X
        ticTacToeSpec.play(1,3);//O
        String actual = ticTacToeSpec.play(3,3);//X
        Assert.assertEquals("X is winner",actual);
    }
    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner(){
        ticTacToeSpec.play(1,3);//X
        ticTacToeSpec.play(1,1);//O
        ticTacToeSpec.play(2,2);//X
        ticTacToeSpec.play(1,2);//O
        String actual = ticTacToeSpec.play(3,1);//X
        Assert.assertEquals("X is winner",actual);
    }
    @Test
    public void whenAllBoxesAreFiledThenDraw(){
        ticTacToeSpec.play(1,1);//X
        ticTacToeSpec.play(1,2);//O
        ticTacToeSpec.play(1,3);//X
        ticTacToeSpec.play(2,1);//O
        ticTacToeSpec.play(2,3);//X
        ticTacToeSpec.play(2,2);//O
        ticTacToeSpec.play(3,1);//X
        ticTacToeSpec.play(3,3);//O
        String actual = ticTacToeSpec.play(3,2);//X
        Assert.assertEquals("The result is draw",actual);
    }
}
