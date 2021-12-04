package com.example.travellazza;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.ThemedSpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travellazza.config.Config;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }

    public void onClick(View view) throws JSONException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Client client = new Client(Config.AUTH_IP,Config.AUTH_PORT);

                EditText txtUsr = (EditText)findViewById(R.id.txt_username);
                String user =txtUsr.getText().toString();

                EditText txtPass = (EditText)findViewById(R.id.txt_passw);
                String pass =txtPass.getText().toString();;

                if( user.isEmpty())
                {
                    txtUsr.setText("");
                    txtUsr.setHint("Forgot to enter username");
                    return;
                }

                if( user.isEmpty())
                {
                    txtPass.setText("");
                    txtPass.setHint("Forgot to enter username");
                    return;
                }


                client.writeToClient(constructRequest(user, pass));
                JSONObject request = null;
                try {
                    request = new JSONObject(client.readFromClient());
                    String respone = request.getString("message");
                    txtUsr.setText(respone);
                }catch (JSONException e)
                {

                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }finally {
                    client.close();
                }
            }
        });
        thread.start();
    }

    private String constructRequest(String user, String pass)
    {

        return "{action:\"login\",username:\""+user+"\",password:\""+hashPass(pass)+"\"}";
    }

    private String hashPass(String pass)
    {

        return pass;
    }

}
