import routes.Api;

import seeders.MainSeeder;

public class Main {
    public static int t = 0;

    public static void main(String[] args) {
        MainSeeder.main();
        Api.main();
    }

}