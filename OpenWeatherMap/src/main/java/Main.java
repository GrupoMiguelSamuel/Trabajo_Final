import model.Model;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        new WeatherService(model).start();
    }
}
