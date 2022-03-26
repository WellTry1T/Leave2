package com.innovation.user.leave;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView bg;
    private ObjectAnimator objectanimator;
    private Button button_choice1;
    private Button button_choice2;
    private Button button_choice_country;
    private boolean show_anim = false;
    private ConstraintLayout cc1;
    boolean main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cc1 = findViewById(R.id.cc1);
        button_choice1 = findViewById(R.id.button_choice1);
        button_choice2 = findViewById(R.id.button_choice2);
        button_choice_country = findViewById(R.id.button_choice_country);
        bg = findViewById(R.id.bg);

        button_choice1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (show_anim){
                    main = true;
                    revertAnimation();
                    bg.setImageResource(R.drawable.bg_main);
                    ObjectAnimator.ofFloat(bg, "alpha", 0.0f, 1.0f).start();
                }
                else {
                    main = false;
                    showAnimation();
                    bg.setImageResource(R.drawable.bg_change1);
                    ObjectAnimator.ofFloat(bg, "alpha", 0.0f, 1.0f).start();
                }
            }
        });

        button_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Coming soon", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



        button_choice_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ChoiceCountry.class);
                    startActivity(intent);
            }
        });
    }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        private void showAnimation() {
            show_anim = true;

            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this, R.layout.change_1);

            ChangeBounds transition = new ChangeBounds();
            transition.setInterpolator(new AnticipateInterpolator(1.0f));
            transition.setDuration(600);

            TransitionManager.beginDelayedTransition(cc1, transition);
            constraintSet.applyTo(cc1);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        private void revertAnimation() {
            show_anim = false;

            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this, R.layout.activity_main);

            ChangeBounds transition = new ChangeBounds();
            transition.setInterpolator(new AnticipateInterpolator(1.0f));
            transition.setDuration(600);

            TransitionManager.beginDelayedTransition(cc1, transition);
            constraintSet.applyTo(cc1);

        }
}