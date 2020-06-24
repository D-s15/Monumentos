package pt.ipbeja.estig.ip.monumentosdiocesebeja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText editTextCreateEmail;
    private EditText editTextCreatePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void onClickCreateAccount(View view) {
        this.editTextCreateEmail = findViewById(R.id.editTextRegisterEmail);
        this.editTextCreatePassword = findViewById(R.id.editTextRegisterPassword);

        String email = editTextCreateEmail.getText().toString();
        String password = editTextCreatePassword.getText().toString();

        User user = new User(0,email,password);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}