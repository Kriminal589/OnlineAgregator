import app.App;

import java.util.Timer;
import java.util.TimerTask;

public class WebApplication {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new JThread(args).start();
            }
        }, 0L, 86400000L);

        App.main(args);
    }
}
