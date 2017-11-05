package rs.ac.bg.matf.risk.androidintrocourse01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import rs.ac.bg.matf.risk.androidintrocourse01.quiz.QuizActivity;

public class MainActivity extends AppCompatActivity
{
    private ImageView mNavQuiz, mNavBlog, mNavCalculator, mNavTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extractReferences();
        setOnClickListeners();
    }

    private void setOnClickListeners()
    {
        mNavQuiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent quizIntent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(quizIntent);
            }
        });

        mNavBlog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMsgToUser("Not yet implemented.");
            }
        });

        mNavCalculator.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMsgToUser("Not yet implemented.");
            }
        });

        mNavTimer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMsgToUser("Not yet implemented.");
            }
        });
    }

    private void extractReferences()
    {
        mNavQuiz = (ImageView) findViewById(R.id.navQuiz);
        mNavBlog = (ImageView) findViewById(R.id.navBlog);
        mNavCalculator = (ImageView) findViewById(R.id.navCalculator);
        mNavTimer = (ImageView) findViewById(R.id.navTimer);
    }

    private void showMsgToUser(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

