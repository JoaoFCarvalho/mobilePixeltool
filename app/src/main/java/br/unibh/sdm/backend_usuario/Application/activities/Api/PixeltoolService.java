package br.unibh.sdm.backend_usuario.Application.activities.Api;

import java.util.List;

import br.unibh.sdm.backend_usuario.Application.activities.Entidades.apppixeltool;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PixeltoolService {
    @Headers({
            "Accept: application/json",
            "User-Agent: apppixeltool"
    })
    @GET("apppixeltool")
    Call<List<apppixeltool>> getApppixeltool();

    @GET("apppixeltool/{id}")
    Call<apppixeltool> getApppixeltool(@Path("id") String codigo);

    @POST("apppixeltool")
    Call<apppixeltool> criaApppixeltool(@Body apppixeltool Apppixeltool);

    @PUT("apppixeltool/{id}")
    Call<apppixeltool> atualizaApppixeltool(@Path("id") String codigo, @Body apppixeltool Apppixeltool);

    @DELETE("apppixeltool/{id}")
    Call<Boolean> excluirApppixeltool(@Path("id") String codigo);

}
