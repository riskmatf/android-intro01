package rs.ac.bg.matf.risk.androidintrocourse01.quiz;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.matf.risk.androidintrocourse01.R;

/**
 * Created by termninja on 11/4/17.
 */
public class TheQuiz
{
    private static final String LOGTAG = "TheQuiz";

    private List<QuizQuestion> mQuestions;
    private int mCurrentQuestion;
    private int mCorrectAnswers;

    public TheQuiz(List<QuizQuestion> questions)
    {
        mQuestions = questions;
        mCurrentQuestion = 0;
        mCorrectAnswers = 0;
    }

    public void nextQuestion()
    {
        mCurrentQuestion++;
    }

    private boolean tryAnswer(int answer)
    {
        return getCurrentQuestion().getCorrectAnswer() == answer;
    }

    public int getCorrectAnswers()
    {
        return mCorrectAnswers;
    }

    public boolean submitAnswer(int answer)
    {
        boolean b = tryAnswer(answer);
        if (b) mCorrectAnswers++;
        return b;
    }

    public int getQuestionNumber()
    {
        return mQuestions.size();
    }

    public QuizQuestion getCurrentQuestion()
    {
        return isEndReached() ? null : mQuestions.get(mCurrentQuestion);
    }

    public void resetQuiz()
    {
        mCurrentQuestion = 0;
        mCorrectAnswers = 0;
    }

    public String getStatus()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Ukupno pitanja: ").append(mQuestions.size()).append("\n");
        sb.append("Ostalo pitanja: ").append(mQuestions.size() - mCurrentQuestion).append("\n");
        sb.append("Tacnih odgovora: " ).append(mCorrectAnswers).append("\n");
        return sb.toString();
    }

    public boolean isEndReached()
    {
        return mCurrentQuestion >= mQuestions.size();
    }

    public static TheQuiz build(Activity activity)
    {
        List<QuizQuestion> questions = new ArrayList<>();
        String[] data = activity.getResources().getStringArray(R.array.quiz_questions);
        for (String q: data) {
            String[] tokens = q.split(";;");
            int correctAnswer = 0;
            try { correctAnswer = Integer.parseInt(tokens[4]); }
            catch (NumberFormatException e) {
                Log.e(LOGTAG, "Failed parsing " + tokens[4] + " into int.");
            }
            QuizQuestion question = new QuizQuestion(tokens[0], tokens[1], tokens[2], tokens[3], correctAnswer);
            questions.add(question);
        }

        return new TheQuiz(questions);
    }
}
