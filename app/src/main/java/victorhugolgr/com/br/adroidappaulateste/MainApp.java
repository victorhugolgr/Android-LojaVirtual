package victorhugolgr.com.br.adroidappaulateste;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by vandame on 29/10/16.
 */

public class MainApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(3000);
    }
}
