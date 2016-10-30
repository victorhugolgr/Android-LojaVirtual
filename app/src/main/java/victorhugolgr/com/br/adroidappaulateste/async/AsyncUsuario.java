package victorhugolgr.com.br.adroidappaulateste.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by vandame on 30/10/16.
 */

public class AsyncUsuario extends AsyncTask<String, String, String>{

    private Activity activity;

    public AsyncUsuario(Activity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... url) {
        StringBuilder resultado = new StringBuilder();
        try {

            URL urlNet = new URL(url[0]);
            HttpURLConnection con = (HttpURLConnection) urlNet.openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.connect();

            InputStream inp = con.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inp));

            String linha = "";
            while ((linha = bufferedReader.readLine()) !=  null){
                resultado.append(linha);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado.toString();
    }

    @Override
    protected void onPostExecute(String resultado) {
        Toast.makeText(activity, resultado, Toast.LENGTH_SHORT).show();
    }
}
