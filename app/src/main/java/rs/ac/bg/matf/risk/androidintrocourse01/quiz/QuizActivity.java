package rs.ac.bg.matf.risk.androidintrocourse01.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import rs.ac.bg.matf.risk.androidintrocourse01.R;

public class QuizActivity extends AppCompatActivity
{
    private TextView mQuestion, mStatus;
    private RadioButton mAnswer1, mAnswer2, mAnswer3;
    private Button mSubmit;

    private TheQuiz mQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setTitle("Kviz!");

        extractReferences();
        mQuiz = TheQuiz.build(this);
        bindDataToGUI();
        setEventHandlers();
    }

    private void setEventHandlers()
    {
        mSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int checkedIndex = -1;
                if (mAnswer1.isChecked()) checkedIndex = 0;
                if (mAnswer2.isChecked()) checkedIndex = 1;
                if (mAnswer3.isChecked()) checkedIndex = 2;
                if (checkedIndex == -1) return;

                boolean b = mQuiz.submitAnswer(checkedIndex);
                if (b) showMsgToUser("Vas odgovor je tacan!");
                else showMsgToUser("Zao nam je, tacan odgovor je na indeksu " + mQuiz.getCurrentQuestion().getCorrectAnswer());
                showNextQuestionOrEnd();
            }
        });
    }

    private void showNextQuestionOrEnd()
    {
        mQuiz.nextQuestion();
        if (mQuiz.isEndReached())
        {
            showMsgToUser("Hvala na igranju!");
            mQuiz.resetQuiz();
        }
        bindCurrentQuestionToScreen();
    }

    private void showMsgToUser(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void bindCurrentQuestionToScreen()
    {
        QuizQuestion q = mQuiz.getCurrentQuestion();
        mQuestion.setText(q.getQuestion());
        mAnswer1.setText(q.getAnswer1());
        mAnswer2.setText(q.getAnswer2());
        mAnswer3.setText(q.getAnswer3());
        mStatus.setText(mQuiz.getStatus());
    }

    private void bindDataToGUI()
    {
        bindCurrentQuestionToScreen();
    }

    private void extractReferences()
    {
        mQuestion = (TextView) findViewById(R.id.textViewQuiz);
        mStatus = (TextView) findViewById(R.id.textViewStatus);
        mAnswer1 = (RadioButton) findViewById(R.id.textViewAnswer1);
        mAnswer2 = (RadioButton) findViewById(R.id.textViewAnswer2);
        mAnswer3 = (RadioButton) findViewById(R.id.textViewAnswer3);
        mSubmit = (Button) findViewById(R.id.buttonSubmit);
    }
}

