package invictus.it.solutions.budgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputName;
    public TextInputEditText inputValue;
    ArrayList<String> list;
    Button addRecord;
    ListView budget_list;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.textInputEditText);
        inputValue = findViewById(R.id.textInputEditText2);
        addRecord = (Button) findViewById(R.id.button);
        budget_list = (ListView) findViewById(R.id.listView);

        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        addRecord.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names=inputName.getText().toString();
                String values=inputValue.getText().toString();

                list.add(names);
                list.add(values);
                budget_list.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();

                inputName.setText("");
                inputValue.setText("");
            }
        }));

    }

    private boolean validateName() {
        String name = inputName.getText().toString().trim();

        if (name.isEmpty()) {
            inputName.setError("Field can't be empty");
            return false;
        }
        else {
            inputName.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateName()) {
            return;
        }

        String input = "Income/Expense: " + inputName.getText().toString();
        input += "\n";

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

    }
}