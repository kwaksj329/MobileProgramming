package kr.co.company.animationservice_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.co.company.animationservice_hw.R;

public class MainActivity extends AppCompatActivity {

    private MyGLSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGLView = (MyGLSurfaceView) findViewById(R.id.myGLSurfaceView);
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this, AnimationService.class);
        intent.putExtra("ValueMessenger", mGLView.getmAngleReceiver());

        startService(intent);
    }
}