package java.raj.mynotesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText nameTxt;
    Spinner sp;
    Button addBtn,deleteBtn,updateBtn,clearBtn;
    ArrayList<String> names= new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameTxt=findViewById(R.id.editText);
        sp=findViewById(R.id.spinner);
        addBtn=findViewById(R.id.button3);
        deleteBtn=findViewById(R.id.button4);
        updateBtn=findViewById(R.id.button5);
        clearBtn=findViewById(R.id.button6);

        //adapter
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, names);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> argo, View v, int pos, long id)
            {
                ///NSET SELECTED ITEM TO EDITTEXT
                nameTxt.setText(names.get(pos));

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //todo auto generated method stub

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //todo auto generated method stub
                add();

            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //todo auto generated method stub
                update();

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //todo auto generated method stub
                delete();

            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //todo auto generated method stub
                clear();

            }
        });

    }
    //crud operation
    private void add()
    {
        String name=nameTxt.getText().toString();
        if(!name.isEmpty()&& name.length()>0) {
            //add
            adapter.add(name);
            //refresh
            adapter.notifyDataSetChanged();
            nameTxt.setText(" ");
            Toast.makeText(getApplicationContext(), "added" + name, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "!! Nothing to added",
                    Toast.LENGTH_LONG).show();
        }

        }
        //update
    private void update()
    {
        String name=nameTxt.getText().toString();
        //get selected pos
        int pos=sp.getSelectedItemPosition();
        if (!name.isEmpty()&& name.length()>0) {
            //remove
            adapter.remove(names.get(pos));
            //insert
            adapter.insert(name, pos);
            //refresh
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Update" + name, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "!! Not updated", Toast.LENGTH_LONG).show();
        }
        }
        //delete
    private void delete()
    {
        String name=nameTxt.getText().toString();
        //get selected pos
        int pos=sp.getSelectedItemPosition();
        if (pos > - 1) {
            //remove
            adapter.remove(names.get(pos));
            //refresh
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Delete" + name, Toast.LENGTH_LONG).show();
            nameTxt.setText(" ");
        }else {
            Toast.makeText(getApplicationContext(), "Nothing to added", Toast.LENGTH_LONG).show();
        }

        }
        //clear
    private void clear()
    {
        adapter.clear();
    }
    }




