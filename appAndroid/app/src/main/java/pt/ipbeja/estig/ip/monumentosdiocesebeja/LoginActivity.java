package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //TODO: implementar sistema de login para o botão de login
    public void onClickLogin(View view) {
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        UserDao userDao = AppDatabase.getInstance(this).getUserDao();

        User user = userDao.getAccount(email, password);

        if (user != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("email", String.valueOf(user));
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(LoginActivity.this, "email/palavra-passe errada, ou a conta não está registada", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickRegister(View view) {
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
    }

}
