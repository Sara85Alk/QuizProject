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
    RadioButton answerQ1,answerQ2;
    CheckBox answerQ3,answerQ32,answerQ33,answerQ4,answerQ42,answerQ43;
    EditText answerQ5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerQ1 = findViewById(R.id.question1_answer2_correct);
        answerQ2 = findViewById(R.id.question2_answer1_correct);
        answerQ3 = findViewById(R.id.question3_answer1);
        answerQ32 = findViewById(R.id.question3_answer2_correct);
        answerQ33 = findViewById(R.id.question3_answer3_correct);
        answerQ4 = findViewById(R.id.question4_answer1_correct);
        answerQ42 = findViewById(R.id.question4_answer2_correct);
        answerQ43 = findViewById(R.id.question4_answer3_correct);
        answerQ5 = findViewById(R.id.country_iraq);
    }

    /* This method called when Score button clicked */

    public void calcScore(View view) {
        score = numberOfCorrectAnswers();
        if (score == 35) {
            Toast.makeText(this,  "Your score is " + score + " out of 35" + "\n Perfect", Toast.LENGTH_LONG).show();
        }
        if ((score <= 30) && (score >= 20)) {
            Toast.makeText(this, "\n your score is " + score + " out of 35" + "\n excellent", Toast.LENGTH_LONG).show();
        }
        if ((score <= 20) && (score >= 5)) {
            Toast.makeText(this, "\n your score is " + score + " out of 35" + "\n Well done", Toast.LENGTH_LONG).show();
        } else if (score <= 5) {
            Toast.makeText(this, "\n your score is " + score + " out of 35" + "\n Not bad", Toast.LENGTH_LONG).show();
        }
    }
    public int numberOfCorrectAnswers() {
        boolean hasAnswerQuestion1 = answerQ1.isChecked();
        boolean hasAnswerQuestion2 = answerQ2.isChecked();
        boolean hasAnswerQuestion3 = answerQ3.isChecked();
        boolean hasAnswerQuestion32 = answerQ32.isChecked();
        boolean hasAnswerQuestion33 = answerQ33.isChecked();
        boolean hasAnswerQuestion4 = answerQ4.isChecked();
        boolean hasAnswerQuestion42 = answerQ42.isChecked();
        boolean hasAnswerQuestion43 = answerQ43.isChecked();
        String hasAnswerQuestion5 = answerQ5.getText().toString().trim();
        int numberOfCorrectAnswers = 0;

        if (hasAnswerQuestion1) {
            numberOfCorrectAnswers += 5;
        }
        if (hasAnswerQuestion2) {
            numberOfCorrectAnswers += 5;
        }
        if (hasAnswerQuestion32 && hasAnswerQuestion33 && !hasAnswerQuestion3 ) {
            numberOfCorrectAnswers += 10;
        }
        if (hasAnswerQuestion4 && hasAnswerQuestion43 && !hasAnswerQuestion42 ) {
            numberOfCorrectAnswers += 10;
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
