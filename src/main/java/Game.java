public class Game {
    public static void Check_input(String user_input) throws IllegalArgumentException{
        if(!(user_input.equals("rock") || user_input.equals("paper") || user_input.equals("scissors")))
            throw new IllegalArgumentException("Bad Choice!");
    }
    public static String Result(String p1, String p2){
        String result="";
        if((p1.equals("rock") && p2.equals("paper")) ||
                (p1.equals("scissors") && p2.equals("rock")) ||
                (p1.equals("paper") && p2.equals("scissors")))
        {
            result = "Player 2 win!";
        }else if((p1.equals("paper") && p2.equals("paper")) ||
                 (p1.equals("rock") && p2.equals("rock")) ||
                 (p1.equals("scissors") && p2.equals("scissors")))
        {
            result = "Draw!";
        }else if((p2.equals("rock") && p1.equals("paper")) ||
                (p2.equals("scissors") && p1.equals("rock")) ||
                (p2.equals("paper") && p1.equals("scissors")))
        {
            result = "Player 1 win!";
        }
        return result;
    }
}
