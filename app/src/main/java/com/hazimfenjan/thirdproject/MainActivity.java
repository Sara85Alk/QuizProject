package com.hazimfenjan.thirdproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RadioButton answerQ1 = findViewById(R.id.question1_answer2_correct);
        boolean hasAnswerQuestion1 = answerQ1.isChecked();

        RadioButton answerQ2 = findViewById(R.id.question2_answer1_correct);
        boolean hasAnswerQuestion2 = answerQ2.isChecked();

        CheckBox answerQ3 = findViewById(R.id.question3_answer3_correct);
        boolean hasAnswerQuestion3 = answerQ3.isChecked();

        CheckBox answerQ32 = findViewById(R.id.question3_answer2_correct);
        boolean hasAnswerQuestion32 = answerQ32.isChecked();

        CheckBox answerQ4 = findViewById(R.id.question4_answer1_correct);
        boolean hasAnswerQuestion4 = answerQ4.isChecked();

        CheckBox answerQ42 = findViewById(R.id.question4_answer2_correct);
        boolean hasAnswerQuestion42 = answerQ42.isChecked();

        CheckBox answerQ43 = findViewById(R.id.question4_answer3_correct);
        boolean hasAnswerQuestion43 = answerQ43.isChecked();

        EditText answerQ5 = findViewById(R.id.country_iraq);
        String hasAnswerQuestion5 = answerQ5.getText().toString().trim();

        score = numberOfCorrectAnswers(hasAnswerQuestion1
                , hasAnswerQuestion2, hasAnswerQuestion3,hasAnswerQuestion32
                , hasAnswerQuestion4,hasAnswerQuestion42,hasAnswerQuestion43,hasAnswerQuestion5);
    }

    /* This method called when Score button clicked */

    public void calcScore(View view) {
        if (score == 30) {
            Toast.makeText(this,  "Your score is " + score + " out of 30" + "\n Perfect", Toast.LENGTH_LONG).show();
        }
        if ((score <= 25) && (score >= 20)) {
            Toast.makeText(this, "\n your score is " + score + " out of 30" + "\n excellent", Toast.LENGTH_LONG).show();
        }
        if ((score <= 20) && (score >= 5)) {
            Toast.makeText(this, "\n your score is " + score + " out of 30" + "\n Well done", Toast.LENGTH_LONG).show();
        } else if (score <= 5) {
            Toast.makeText(this, "\n your score is " + score + " out of 30" + "\n Not bad", Toast.LENGTH_LONG).show();
        }
    }
    public int numberOfCorrectAnswers(boolean AnswerQuestion1, boolean AnswerQuestion2, boolean AnswerQuestion3,
                                      boolean AnswerQuestion31, boolean AnswerQuestion4, boolean AnswerQuestion42,
                                      boolean AnswerQuestion43, String hasAnswerQuestion5) {

        int numberOfCorrectAnswers = 0;

        if (AnswerQuestion1) {
            numberOfCorrectAnswers += 5;
        }
        if (AnswerQuestion2) {
            numberOfCorrectAnswers += 5;
        }
        if (AnswerQuestion3) {
            numberOfCorrectAnswers += 5;
        }
        if (AnswerQuestion31) {
            numberOfCorrectAnswers += 5;
        }
        if (AnswerQuestion4 && AnswerQuestion43 && !AnswerQuestion42 ) {
            numberOfCorrectAnswers += 5;
        }
        if(hasAnswerQuestion5.equalsIgnoreCase("Iraq")) {
            numberOfCorrectAnswers += 5;
        }
        return numberOfCorrectAnswers;
    }
    /**
     * This method resets all the Radio Buttons in a given Radio Group.
     * @param radioGroupID the id of a radio group
     */
    public void resetQuestions(int radioGroupID) {
        RadioGroup radioGroup = findViewById(radioGroupID);
        radioGroup.clearCheck();
    }
    /* This method resets all the CheckBoxes in the quiz.*/
    public void resetCheckBoxes() {
        CheckBox checkbox1 = findViewById(R.id.question3_answer1);
        CheckBox checkbox2 = findViewById(R.id.question3_answer2_correct);
        CheckBox checkbox3 = findViewById(R.id.question3_answer3_correct);
        CheckBox checkbox11 = findViewById(R.id.question4_answer1_correct);
        CheckBox checkbox12 = findViewById(R.id.question4_answer2_correct);
        CheckBox checkbox13 = findViewById(R.id.question4_answer3_correct);

        checkbox1.setChecked(false);
        checkbox2.setChecked(false);
        checkbox3.setChecked(false);
        checkbox11.setChecked(false);
        checkbox12.setChecked(false);
        checkbox13.setChecked(false);
    }
    /* This method resets EditText in the quiz.*/
    public  void resetEditText() {
        EditText editText = findViewById(R.id.country_iraq);
        editText.getText().clear();
    }
    public void reset(View view) {
        resetQuestions(R.id.radioGroupQ1);
        resetQuestions(R.id.radioGroupQ2);
        resetCheckBoxes();
        resetEditText();
    }
}
