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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* This method called when Score button clicked */

    public void calcScore(View view) {

        RadioButton AnswerQ1 = findViewById(R.id.question1_answer2_correct);
        boolean hasAnswerQuestion1 = AnswerQ1.isChecked();

        RadioButton AnswerQ2 = findViewById(R.id.question2_answer1_correct);
        boolean hasAnswerQuestion2 = AnswerQ2.isChecked();

        CheckBox AnswerQ3 = findViewById(R.id.question3_answer3_correct);
        boolean hasAnswerQuestion3 = AnswerQ3.isChecked();

        CheckBox AnswerQ32 = findViewById(R.id.question3_answer2_correct);
        boolean hasAnswerQuestion32 = AnswerQ32.isChecked();

        CheckBox AnswerQ4 = findViewById(R.id.question4_answer1_correct);
        boolean hasAnswerQuestion4 = AnswerQ4.isChecked();

        CheckBox AnswerQ42 = findViewById(R.id.question4_answer2_correct);
        boolean hasAnswerQuestion42 = AnswerQ42.isChecked();

        CheckBox AnswerQ43 = findViewById(R.id.question4_answer3_correct);
        boolean hasAnswerQuestion43 = AnswerQ43.isChecked();

       EditText AnswerQ5 = findViewById(R.id.country_iraq);
       String hasAnswerQuestion5 = AnswerQ5.getText().toString().trim();

        int score = numberOfCorrectAnswers(hasAnswerQuestion1
                , hasAnswerQuestion2, hasAnswerQuestion3,hasAnswerQuestion32
                , hasAnswerQuestion4,hasAnswerQuestion42,hasAnswerQuestion43,hasAnswerQuestion5);
        if (score == 40) {
            Toast.makeText(this,  "Your score is " + score + " out of 30" + "\n Perfect", Toast.LENGTH_LONG).show();
        }
        if ((score <= 35) && (score >= 25)) {
            Toast.makeText(this, "\n your score is " + score + " out of 30" + "\n excellent", Toast.LENGTH_LONG).show();
        }
        if ((score <= 25) && (score >= 5)) {
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
        if (AnswerQuestion4 || AnswerQuestion42 || AnswerQuestion43 ) {
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
