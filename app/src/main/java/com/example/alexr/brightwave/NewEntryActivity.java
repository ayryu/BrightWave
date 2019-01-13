package com.example.alexr.brightwave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class NewEntryActivity extends AppCompatActivity {
    public static final String EXTRA_EDIT_TITLE = "com.example.android.entrylistsql.EDIT_TITLE";
    public static final String EXTRA_EDIT_DESCRIPTION = "com.example.android.entrylistsql.EDIT_DESCRIPTION";
    public static final String EXTRA_EDIT_EXPIRY_DATE = "com.example.android.entrylistsql.EDIT_EXPIRY_DATE";

    private EditText mEditTitleView;
    private EditText mEditDescriptionView;
    private CalendarView mEditExpiryDateView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        mEditTitleView = findViewById(R.id.edit_title);
        mEditDescriptionView = findViewById(R.id.edit_description);
        mEditExpiryDateView = findViewById(R.id.edit_expirydate);


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTitleView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String title = mEditTitleView.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_TITLE, title);
                    String description = mEditDescriptionView.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_DESCRIPTION, description);
                    long expiryDate = mEditExpiryDateView.getDate();
                    replyIntent.putExtra(EXTRA_EDIT_EXPIRY_DATE, expiryDate);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
