package com.example.alexcutschall.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexcutschall.interactivestory.R;
import com.example.alexcutschall.interactivestory.model.Page;
import com.example.alexcutschall.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public final static String TAG = StoryActivity.class.getSimpleName();
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if (name == "null" || name.isEmpty()) {
            name = "Friend";
        }
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImageId());

        storyImageView.setImageDrawable(image);
    }
}
