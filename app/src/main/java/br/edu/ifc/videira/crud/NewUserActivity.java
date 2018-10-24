package br.edu.ifc.videira.crud;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.edu.ifc.videira.crud.dao.configFirebase;
import br.edu.ifc.videira.crud.entities.User;
import br.edu.ifc.videira.crud.view_models.UserViewModel;

public class NewUserActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private UserViewModel mUserViewModel;

    //Mudeando aq//
    private FirebaseAuth autenticacao;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        final TextView txtEmail = findViewById(R.id.editTextUserEmail);
        final TextView txtPasswrod = findViewById(R.id.editTextUserPassword);
        final TextView txtName = findViewById(R.id.editTextName);
        final TextView txtTel = findViewById(R.id.editTextPhone);


        final Button button = findViewById(R.id.btnSaveUser);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(txtEmail.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String email = txtEmail.getText().toString();
                    String password = txtPasswrod.getText().toString();
                    String name = txtName.getText().toString();
                    String phone = txtTel.getText().toString();

                    //aq
                    user = new User(email, password, name, phone);

                }
                finish();
            }
        });
    }
    //aq tbm
    private void validarLogin(){
        autenticacao = configFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(NewUserActivity.this,"Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(NewUserActivity.this,"Login incorreto!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
