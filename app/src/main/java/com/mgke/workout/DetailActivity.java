package com.mgke.workout;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment frag = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int workoutId = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            workoutId = extras.getInt(EXTRA_WORKOUT_ID, -1);
        }
        if (workoutId != -1) {
            frag.setWorkout(workoutId);
        } else {
            Log.e("DetailActivity", "Invalid workout ID received!");
        }
    }
}


