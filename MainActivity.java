package com.example.gpa_dorchs1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    private double totalGrade = 0;
    private double totalUnits = 0;

    EditText[] editTextGrades;
    TextView textViewGPA;
    Button computeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGrades = new EditText[]{
                findViewById(R.id.e1),
                findViewById(R.id.e2),
                findViewById(R.id.e3),
                findViewById(R.id.e4),
                findViewById(R.id.e5)
        };

        TextView resultTextView = findViewById(R.id.t);

        textViewGPA = findViewById(R.id.t);
        computeButton = findViewById(R.id.b);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGPA();
            }
        });
    }

    private void calculateGPA() {
        totalGrade = 0;
        totalUnits = 0;

        for (int i = 0; i < editTextGrades.length; i++) {
            EditText editText = editTextGrades[i];
            String gradeText = editText.getText().toString();
            if (!gradeText.isEmpty()) {
                double grade = Double.parseDouble(gradeText);
                totalGrade += grade;
                totalUnits++;
            }
        }

        if (totalUnits == 0) {
            textViewGPA.setText("GPA cannot be calculated since no units have been entered.");
        } else {
            double gpa = totalGrade / totalUnits;
            textViewGPA.setText("Current GPA is " + gpa);
        }

        // Your added code begins here
        float grade1, grade2, grade3, grade4, grade5;

        if (areFieldsEmpty()) {
            textViewGPA.setText("");
        } else {
            grade1 = Float.parseFloat(editTextGrades[0].getText().toString());
            grade2 = Float.parseFloat(editTextGrades[1].getText().toString());
            grade3 = Float.parseFloat(editTextGrades[2].getText().toString());
            grade4 = Float.parseFloat(editTextGrades[3].getText().toString());
            grade5 = Float.parseFloat(editTextGrades[4].getText().toString());

            float average = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;

            if (average < 60) {
                textViewGPA.setText(String.valueOf(average));
                textViewGPA.setBackgroundColor(Color.RED);
            } else if (average >= 60 && average < 80) {
                textViewGPA.setText(String.valueOf(average));
                textViewGPA.setBackgroundColor(Color.YELLOW);
            } else if (average >= 80 && average <= 100) {
                textViewGPA.setText(String.valueOf(average));
                textViewGPA.setBackgroundColor(Color.GREEN);
            }

            computeButton.setText("Clear");
        }
        // Your added code ends here
    }

    private boolean areFieldsEmpty() {
        for (EditText editText : editTextGrades) {
            if (editText.getText().toString().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
