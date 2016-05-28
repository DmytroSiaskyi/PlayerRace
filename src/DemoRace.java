import java.io.BufferedReader;
import java.io.InputStreamReader;
import  java.util.Random;
public class DemoRace {
    static int choise_winner(Racer...r)
    {
        int winner_id = 0;
        double dist = 1;
        for(int i = 0; i < r.length; i++)
        {
            if(r[i].current_distance() < dist)
            {
                dist = r[i].current_distance();
                winner_id = r[i].id;
            }
        }
        return winner_id;
    }
    public static void main(String...args) throws java.io.IOException
    {
        int PRICE = 100;
        int racer_id;
        int winner;
        int distance;
        Random rn = new Random();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("   Race Game   ");
        System.out.print(" Введите имя игрока: ");
        Player player = new Player(rd.readLine(),1000);
        System.out.println(" Игрок: " + player.name + " Баланс: " + player.cash);
        Racer r1 = new Racer(1,1);
        Racer r2 = new Racer(2,1);
        Racer r3 = new Racer(3,1);
        while(player.have_money())
        {
            racer_id = player.play(PRICE);
            distance = rn.nextInt(15) + 5;
            r1.set_on_start(distance);
            r2.set_on_start(distance);
            r3.set_on_start(distance);
            System.out.println("Длина гонки " + distance + " km");
            while(!r1.finished() && !r2.finished() && !r3.finished()) {
                r1.run(rn.nextDouble() * 3 + 1);
                r2.run(rn.nextDouble() * 3 + 1);
                r3.run(rn.nextDouble() * 3 + 1);
                System.out.println("");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван.");
                }
            }
            winner = choise_winner(r1,r2,r3);
            System.out.println("Гонка завершена! Первым приехал гонщик " + winner);
            if(winner == racer_id)
            {
                player.win(3 * PRICE);
            }
            System.out.println("Баланс игрока " + player.name + ": " + player.cash);
        }
        System.out.println("У игрока " + player.name + " закончились деньги.");
    }
}
