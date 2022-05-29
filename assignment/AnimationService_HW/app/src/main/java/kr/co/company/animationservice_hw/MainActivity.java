package kr.co.company.animationservice_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        intent.putExtra("Order", AnimationService.START);
        EditText tensionEditText = findViewById(R.id.tensionEditText);
        String tension = tensionEditText.getText().toString();
        if (tension.length()==0)
            intent.putExtra("Tension", (float)0);
        else intent.putExtra("Tension", Float.parseFloat(tensionEditText.getText().toString()));

        startService(intent);
    }

    public void onClickStop(View view) {
        Intent intent = new Intent(this, AnimationService.class);
        intent.putExtra("ValueMessenger", mGLView.getmAngleReceiver());
        intent.putExtra("Order", AnimationService.STOP);

        startService(intent);
    }
}