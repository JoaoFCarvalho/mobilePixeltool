package br.unibh.sdm.backend_usuario.Application.activities.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class apppixeltool implements Serializable{

    private String codigo;
    private String nome;
    private String descricao;
    private Date dataCriacao;

    public apppixeltool(String _codigo, String _nome, String _descricao, Date _dataCriacao){

        setCodigo(_codigo); setNome(_nome); setDescricao(_descricao); setDataCriacao(_dataCriacao);

    }

    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    private void setNome(String nome){
        this.nome = nome;
    }

    private void setDescricao(String descricao){
        this.descricao = descricao;
    }

    private void setDataCriacao(Date dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "apppixeltool{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof apppixeltool)) return false;
        apppixeltool that = (apppixeltool) o;
        return Objects.equals(getCodigo(), that.getCodigo()) &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getDataCriacao(), that.getDataCriacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNome(), getDescricao(), getDataCriacao());
    }
}
