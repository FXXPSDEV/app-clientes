package br.edu.ifc.videira.crud;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifc.videira.crud.view_models.UserViewModel;

public class NewUserActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        final TextView txtEmail = findViewById(R.id.editTextUserEmail);
        final TextView txtPasswrod = findViewById(R.id.editTextUserPassword);

        final Button button = findViewById(R.id.btnSaveUser);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(txtEmail.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String email = txtEmail.getText().toString();
                    String password = txtPasswrod.getText().toString();

                    replyIntent.putExtra("email", email);
                    replyIntent.putExtra("password", password);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
