import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IllegalArgumentException {
        Scanner in=new Scanner(System.in);
        Game game=new Game();
        String p1,p2;
        try{
            System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
            System.out.println("Enter Player 1 choice (rock, paper or scissors):");
            p1=in.nextLine();
            game.Check_input(p1);
            System.out.println("Enter Player 2 choice (rock, paper or scissors):");
            p2=in.nextLine();
            game.Check_input(p2);
            System.out.println(game.Result(p1,p2));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
