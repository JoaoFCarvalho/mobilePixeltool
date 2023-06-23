package br.unibh.sdm.backend_usuario.Application.activities.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import br.unibh.sdm.backend_usuario.Application.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.unibh.sdm.backend_usuario.Application.R;
import br.unibh.sdm.backend_usuario.Application.activities.Api.PixeltoolService;
import br.unibh.sdm.backend_usuario.Application.activities.Api.RestServiceGenerator;
import br.unibh.sdm.backend_usuario.Application.activities.Entidades.apppixeltool;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private PixeltoolService service = null;

    final private MainActivity mainActivity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista Pixeltools");
        setContentView(R.layout.activity_main);
        service = RestServiceGenerator.createService((PixeltoolService.class));
        buscaApppixeltool();
        criaAcaoBotaoFlutuante();
    }
    private void criaAcaoBotaoFlutuante(){
        FloatingActionButton botaoNovo = findViewById(R.id.floatingActionButton);
        botaoNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Main Activity", "Clicou no botão para adicionar novo Pixel tool");
                startActivities(new Intent[]{new Intent(MainActivity.this, FormularioActivity.class)});
            }
        });
    }

    @Override
    protected void onResume(){
    super.onResume();
    buscaApppixeltool();
    }
    private void buscaApppixeltool() {
        PixeltoolService service = RestServiceGenerator.createService(PixeltoolService.class);
        Call<List<apppixeltool>> call = service.getApppixeltool();
        call.enqueue(new Callback<List<apppixeltool>>() {
            @Override
            public void onResponse(Call<List<apppixeltool>> call, Response<List<apppixeltool>> response) {
                if (response.isSuccessful()) {
                    Log.i("ApppixeltoolDAO", "Retornou " + response.body().size() + "Pixel Tool!");
                    List<String> lista2 = new ArrayList<>();
                    for (apppixeltool item : response.body()) {
                        lista2.add(item.getNome());
                    }
                    Log.i("MainActivity", lista2.toArray().toString());
                    ListView listView = findViewById(R.id.listViewListaPixeltool);
                    listView.setAdapter(new ArrayAdapter<String>(mainActivity,
                            android.R.layout.simple_list_item_1,
                            lista2));
                } else {
                    Log.e("ApppixeltoolDAO", "" + response.message());
                    Toast.makeText(getApplicationContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<apppixeltool>> call, Throwable t) {
                Log.e("Error", "" + t.getMessage());
            }
        });

    }
}