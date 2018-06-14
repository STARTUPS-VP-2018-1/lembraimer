package br.com.lembraimer.business.interfaces;

import br.com.lembraimer.dominio.Usuario;
import br.com.lembraimer.tela.TelaMobile;

public interface UsuarioInterface {
    
    public  boolean checkLogin(String nome, String nomeResponsavel);
    
    public Usuario usuarioLogado(Usuario usuario, Usuario senha, TelaMobile tl);
}
