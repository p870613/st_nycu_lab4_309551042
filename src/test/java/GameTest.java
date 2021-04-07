import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    static Stream<Arguments> p1w_p2l(){
        return Stream.of(
                arguments("rock","scissors"),
                arguments("paper","rock"),
                arguments("scissors","paper")
        );
    }

    static Stream<Arguments> p1l_p2w(){
        return Stream.of(
                arguments("rock","paper"),
                arguments("paper","scissors"),
                arguments("scissors","rock")
        );
    }
    static Stream<Arguments> p1_p2_draw(){
        return Stream.of(
                arguments("rock","rock"),
                arguments("paper","paper"),
                arguments("scissors","scissors")
        );
    }

    @ParameterizedTest
    @MethodSource("p1w_p2l")
    public void p1_win_p2_lose_case(String p1,String p2){
        String want = "Player 1 win!";
        String got = Game.Result(p1, p2);
        assertEquals(want, got);
    }

    @ParameterizedTest
    @MethodSource("p1l_p2w")
    public void p1_losep2_win_case(String p1,String p2){
        String want = "Player 2 win!";
        String got = Game.Result(p1, p2);
        assertEquals(want, got);
    }

    @ParameterizedTest
    @MethodSource("p1_p2_draw")
    public void p1_p2_draw_case(String p1,String p2){
        String want = "Draw!";
        String got = Game.Result(p1, p2);
        assertEquals(want, got);
    }


    @Test
    void valid_input_case() {
        String valid = "rock";
        assertDoesNotThrow(()->{Game.Check_input(valid);});
    }

    @Test
    void Invalid_input_case() {
        String invalid="助教好帥";
        assertThrows(IllegalArgumentException.class,()->{
            Game.Check_input(invalid);
        });
    }
}