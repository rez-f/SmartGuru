package apps.rez.com.smartguru;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    ImageView appLogo;
    EditText username,password;
    boolean cek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        cek = false;

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        loginButton = (Button) findViewById(R.id.btnLogin);

        if (!TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(password.getText().toString())){
            cek = true;
            String user = username.getText().toString();
            String pass = password.getText().toString();
        }

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
            }
        });

        appLogo = (ImageView) findViewById(R.id.appLogo);

        TextDrawable drawable = TextDrawable.builder()
                .buildRound("S", getResources().getColor(R.color.colorPrimaryDark));
        appLogo.setImageDrawable(drawable);
    }
}
