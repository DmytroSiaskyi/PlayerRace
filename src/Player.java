import  java.util.Random;
public class Player {
    int cash;
    String name;
    Player(String name, int cash)
    {
        this.cash = cash;
        this.name = name;
    }
    public int play(int price)
    {
        cash -= price;
        Random rd = new Random();
        int id = rd.nextInt(3) + 1;
        System.out.println("Игрок " + name + " сделал ставку " + price + " на игрока " + id );
        System.out.println("Баланс игрока  " + name + ": " + cash );
        return id;
    }
    public void win(int money)
    {
        cash += money;
        System.out.println("Игрок выиграл ставку +" + money );
    }
    public boolean have_money()
    {
        if(cash > 0)
            return true;
        return false;
    }
}
