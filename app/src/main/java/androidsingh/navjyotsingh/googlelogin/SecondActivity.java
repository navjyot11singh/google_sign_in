package androidsingh.navjyotsingh.googlelogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    Button button;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button=findViewById(R.id.logout);
        mAuth=FirebaseAuth.getInstance();

        mAuthListner= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    startActivity(new Intent(SecondActivity.this,MainActivity.class));
                }
            }

        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mAuth.signOut();
            }
        });
    }
}
