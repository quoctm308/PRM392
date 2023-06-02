package com.example.android_image;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ImageView ivPicture = (ImageView)
                findViewById(R.id.ivPicture);
        ivPicture.setImageResource(R.drawable.android_image);
        ivPicture.setContentDescription("Description:" +
                R.string.my_image_description);
    }
}
