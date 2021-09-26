package com.example.exampletest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exampletest.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStoreActivity extends AppCompatActivity {
    private EditText et_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_store);
        et_text = findViewById(R.id.et_text);

        String inputText = load();
        if (!TextUtils.isEmpty(inputText)) {
            et_text.setText(inputText);
            //将输入光标移动到文本的末尾以便于继续输入
//            et_text.setSelection(inputText.length());
            Toast.makeText(this, "恢复成功！", Toast.LENGTH_SHORT).show();
        }

    }

    private String load() {
        FileInputStream fis = null;
        BufferedReader reader = null;
        //线程安全的，效率低
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fis = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //获取输入框中的存储到文件中
        String data = et_text.getText().toString();
        SaveData(data);
    }

    private void SaveData(String data) {
        FileOutputStream fos = null;
        BufferedWriter bfw = null;
        try {
            fos = openFileOutput("data", MODE_PRIVATE);
            bfw = new BufferedWriter(new OutputStreamWriter(fos));
            bfw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfw != null) {
                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}