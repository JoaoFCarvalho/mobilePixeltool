package br.unibh.sdm.backend_usuario.Application.activities.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import br.unibh.sdm.backend_usuario.Application.R;
import br.unibh.sdm.backend_usuario.Application.activities.Api.PixeltoolService;
import br.unibh.sdm.backend_usuario.Application.activities.Api.RestServiceGenerator;
import br.unibh.sdm.backend_usuario.Application.activities.Entidades.apppixeltool;


public class FormularioActivity extends AppCompatActivity {

    @NotNull
    private apppixeltool recuperaInformacoesFormulario(){
        EditText codigo = findViewById(R.id.editTextCodigo);
        EditText nome = findViewById(R.id.editTextNome);
        EditText descricao = findViewById(R.id.editTextTextDescricao);
        apppixeltool Apppixeltool = new apppixeltool();
        apppixeltool.setCodigo(codigo.getText().toString());
        apppixeltool.setNome(nome.getText().toString());
        apppixeltool.setDescricao(descricao.getText().toString());
        apppixeltool.setDataCriacao(new Date());
        return Apppixeltool;
    }


    private PixeltoolService service = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        setTitle("Lista de Apppixeltool");
        service = RestServiceGenerator.createService(PixeltoolService.class);
    }

}