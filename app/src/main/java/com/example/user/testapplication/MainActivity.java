package com.example.user.testapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.testapplication.Api.PostApi;
import com.example.user.testapplication.Model.Post;
import com.example.user.testapplication.Service.PostService;
import com.example.user.testapplication.Tools.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btntest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntest = (Button) findViewById(R.id.btnTest);

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostService service = new PostService();

                final ProgressDialog progress = new ProgressDialog(MainActivity.this);
                try {

                    progress.setMessage("Wait while loading...");
                    progress.setCancelable(false);
                    progress.show();

                    /*final PostApi api = RetroClient.getClient().create(PostApi.class);
                    final Call<List<Post>> call = api.GetPostList();*/

                    service.GetPostList().enqueue(new Callback<List<Post>>() {
                        @Override
                        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                            progress.dismiss();
                            if (response.isSuccessful()) {
                                List<Post> list = response.body();

                                Toast.makeText(getApplicationContext(), "Sonuc => " + String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Post>> call, Throwable t) {
                            progress.dismiss();

                            Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                catch (Exception e){
                    progress.dismiss();
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
