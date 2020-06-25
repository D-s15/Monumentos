package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText editTextCreateEmail;
    private EditText editTextCreatePassword;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        this.editTextCreateEmail = findViewById(R.id.editTextRegisterEmail);
        this.editTextCreatePassword = findViewById(R.id.editTextRegisterPassword);
    }

    public void onClickCreateAccount(View view) {

        this.userDao = AppDatabase.getInstance(this).getUserDao();
        String email = editTextCreateEmail.getText().toString();
        String password = editTextCreatePassword.getText().toString();

        if (email.isEmpty()){
            Toast.makeText(this,"o Email não pode estar vazio", Toast.LENGTH_LONG).show();
            return;
        }else if(password.isEmpty()){
            Toast.makeText(this,"a palavra-passe não pode estar vazio", Toast.LENGTH_LONG).show();
            return;
        }
        User user = new User(0,email,password);
        userDao.insert(user);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}