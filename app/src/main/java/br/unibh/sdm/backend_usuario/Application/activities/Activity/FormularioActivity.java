package br.unibh.sdm.backend_usuario.Application.activities.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import br.unibh.sdm.backend_usuario.Application.R;
import br.unibh.sdm.backend_usuario.Application.activities.Api.PixeltoolService;
import br.unibh.sdm.backend_usuario.Application.activities.Api.RestServiceGenerator;
import br.unibh.sdm.backend_usuario.Application.activities.Entidades.apppixeltool;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormularioActivity extends AppCompatActivity {

    @NotNull
    private apppixeltool recuperaInformacoesFormulario(){
        EditText codigo = findViewById(R.id.editTextCodigo);
        EditText nome = findViewById(R.id.editTextNome);
        EditText descricao = findViewById(R.id.editTextTextDescricao);
        return new apppixeltool(codigo.getText().toString(),
                nome.getText().toString(),
                descricao.getText().toString(),
                new Date());
    }


    private PixeltoolService service = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        setTitle("Lista de Apppixeltool");
        service = RestServiceGenerator.createService(PixeltoolService.class);
        configurarBotaoSalvar();
    }
    private void configurarBotaoSalvar(){
        Button botaoSalvar = findViewById(R.id.btnSalvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FormulaCripto", "Clicou em Salvar");
                apppixeltool Apppixeltool = recuperaInformacoesFormulario();
                salvaApppixeltool(Apppixeltool);
            }
        });
    }
    private void salvaApppixeltool(apppixeltool Apppixeltool){
        Call<apppixeltool> call = service.criaApppixeltool(Apppixeltool);
        call.enqueue(new Callback<apppixeltool>() {
            @Override
            public void onResponse(Call<apppixeltool> call, Response<apppixeltool> response) {
                if (response.isSuccessful()){
                    Log.i("FormularioPixeltool", "Salvou a Pixeltool " + Apppixeltool.getCodigo());
                    Toast.makeText(getApplicationContext(), "Salvou a PixelTool " + Apppixeltool.getCodigo(), Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Log.e("FormularioPixeltool", "Erro (" + response.code()+ "): Verifique novamente os valores");
                    Toast.makeText(getApplicationContext(), "Erro (" + response.code()+"): Verifique novamente os valores", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<apppixeltool> call, Throwable t) {
            Log.e("FormularioPixelTool", "Erro: " +t.getMessage());
            }
        });

        }
    }