package com.camrininfotech.mynotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity {
    EditText et_title, et_note;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        et_title = findViewById(R.id.title);
        et_note = findViewById(R.id.note);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait ...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                String title = et_title.getText().toString().trim();
                String note = et_note.getText().toString().trim();
                int color = -2184710;
                if (title.isEmpty()) {
                    et_title.setError("Please enter a title");
                } else if (note.isEmpty()) {
                    et_note.setError("please enter a note");
                } else {
                    saveNote(title,note,color);
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote(final String title, final String note, final int color) {
        progressDialog.show();
        apiInterface = ApiCilnt.getApiClint().create(ApiInterface.class);
        Call<Note> call = apiInterface.saveNote(title, note, color);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(@NonNull Call<Note> call, @NonNull Response<Note> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();
                    if (success) {
                        Toast.makeText(EditorActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                        finish();

                    } else {
                        Toast.makeText(EditorActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<Note> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EditorActivity.this,
                        t.getLocalizedMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
