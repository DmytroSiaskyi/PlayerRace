public class Racer {
    int id;
    private double distance_to_finish;
    Racer(int id, int distance_to_finish)
    {
        this.id = id;
        this.distance_to_finish = distance_to_finish;
    }
    public void run(double distance)
    {
        distance_to_finish -= distance;
        System.out.println("Дистанция гонщика " + id + " до финиша " + distance_to_finish);
    }
    public boolean finished()
    {
        if(distance_to_finish <= 0)
            return true;
        return false;
    }
    public double current_distance()
    {
        return distance_to_finish;
    }
    public void set_on_start(int d)
    {
        distance_to_finish = d;
    }
}
