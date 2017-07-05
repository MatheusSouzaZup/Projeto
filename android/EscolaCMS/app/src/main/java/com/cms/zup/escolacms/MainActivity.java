package com.cms.zup.escolacms;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.android.volley.Response.*;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText data_nasc;
    Button btn_save;
    Button btn_list;
    String resposta;
    List<Aluno> myList = new ArrayList<Aluno>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText2);
        data_nasc = (EditText) findViewById(R.id.editText);
        btn_save = (Button) findViewById(R.id.button);
        btn_list = (Button) findViewById(R.id.button2);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callService();
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAlunosFromService();
                AlunoFragment fra;
                fra = new AlunoFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_content,fra,"mainFrag").commit();

                //setContentView(R.layout.fragment_alunos);
            }
        });
    }
    public void getAlunosFromService() {
        String url = "http://10.0.3.108.8083/cms/controller/selecionaAluno.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    myList = Arrays.asList(new Gson().fromJson(response.getJSONArray("").toString(),Aluno[].class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        AppControler.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
    public List<Aluno> getMyList() {
        return myList;
    }
    public void callService() {
        String nome = String.valueOf(name.getText());
        String data = String.valueOf(data_nasc.getText());
        String url = "http://10.0.3.108:8083/cms/controller/insertAluno.php?nome=" + nome + "&data_nasc=" + data;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                resposta = response;
                Toast.makeText(MainActivity.this, resposta, Toast.LENGTH_SHORT).show();
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        AppControler.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

}
