package rs.ac.bg.matf.risk.androidintrocourse01.quiz;

/**
 * Created by termninja on 11/4/17.
 */

public class QuizQuestion
{
    private String mQuestion;
    private String mAnswer1, mAnswer2, mAnswer3;
    private int mCorrectAnswer;

    public QuizQuestion(String question, String answer1, String answer2, String answer3, int correctAnswer)
    {
        mQuestion = question;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
        mAnswer3 = answer3;
        mCorrectAnswer = correctAnswer;
    }

    public String getQuestion()
    {
        return mQuestion;
    }

    public String getAnswer1()
    {
        return mAnswer1;
    }

    public String getAnswer2()
    {
        return mAnswer2;
    }

    public String getAnswer3()
    {
        return mAnswer3;
    }

    public int getCorrectAnswer()
    {
        return mCorrectAnswer;
    }

    @Override
    public String toString()
    {
        return "QuizQuestion{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mAnswer1='" + mAnswer1 + '\'' +
                ", mAnswer2='" + mAnswer2 + '\'' +
                ", mAnswer3='" + mAnswer3 + '\'' +
                ", mCorrectAnswer=" + mCorrectAnswer +
                '}';
    }


}
