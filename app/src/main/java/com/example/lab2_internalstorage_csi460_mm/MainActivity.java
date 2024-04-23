package com.example.lab2_internalstorage_csi460_mm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Creates variables for all the relevant components
    private Button addBtn, showBtn, deleteBtn;
    private EditText addTxt;
    private RecyclerView rclView;
    private RclAdapter rclAdapter;
    private List<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializes the views
        addBtn = findViewById(R.id.addItemBtn);
        showBtn = findViewById(R.id.showListBtn);
        addTxt = findViewById(R.id.addItemTxt);
        rclView = findViewById(R.id.rclView);
        deleteBtn = findViewById(R.id.deleteBtn);

        //Initializes the list
        todoList = new ArrayList<>();

        //Initializes the rcl adapter
        rclAdapter = new RclAdapter(this, todoList);
        rclView.setLayoutManager(new LinearLayoutManager(this));
        rclView.setAdapter(rclAdapter);

        //Functionality for adding a new list item when button is clicked
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gets the new list item
                String item = addTxt.getText().toString().trim();

                //Checks if an list item was created and adds it to the to-do list
                if(!item.isEmpty()){
                    todoList.add(item);

                    //Writes/saves the list to internal storage
                    try{
                        FileOutputStream fileOut = openFileOutput("todo_list.txt", MODE_PRIVATE);

                        for(String listItem : todoList){
                            fileOut.write((listItem + "\n").getBytes());
                        }

                        Toast.makeText(getBaseContext(), "Item Has Been Saved To Your To-Do List", Toast.LENGTH_SHORT).show();

                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    //Use the rcl adapter to refresh the list and clear the add list item EditText view
                    rclAdapter.notifyDataSetChanged();
                    addTxt.setText("");
                }
            }
        });


        //Functionality for showing the To-do list when button is clicked
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoList.clear();

                //Gets/loads the list items from the internal storage
                try (FileInputStream fis = openFileInput("todo_list.txt");
                     BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        todoList.add(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                rclAdapter.notifyDataSetChanged();
            }
        });



        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Gets the internal storage dir. and all its files
                File internalStorage = getFilesDir();
                File listItemsFile = new File(internalStorage, "todo_list.txt");

                //Deletes the files
                if (listItemsFile.exists()) {
                    boolean deletedFile = listItemsFile.delete();

                    if(deletedFile){
                        Toast.makeText(getBaseContext(), "To-Do List Has Been Cleared", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getBaseContext(), "To-Do List File Does Not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}