package br.edu.ifc.videira.crud.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class preferences {

    private Context context;
    private SharedPreferences preferences;
    private String name_File = "ProjetoFirebase.Preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "identificadorUsuarioLogado";
    private final String CHAVE_NOME = "NomeUsuarioLogado";

    public preferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(name_File, MODE);

        editor = preferences.edit();
    }

    public void SaveUserPreferences(String identificadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    public String getIdentificador(){
        return preferences.getString(CHAVE_IDENTIFICADOR,null);
    }

    public String getNome(){
        return preferences.getString(CHAVE_NOME,null);
    }

}
