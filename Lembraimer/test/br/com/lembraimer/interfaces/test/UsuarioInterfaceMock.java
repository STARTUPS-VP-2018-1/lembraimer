package br.com.lembraimer.interfaces.test;

import br.com.lembraimer.dominio.test.UsuarioMock;
import br.com.lembraimer.tela.test.TelaMobileMock;

public interface UsuarioInterfaceMock {
    
    public  boolean checkLogin(String nome, String nomeResponsavel);
    
    public UsuarioMock usuarioLogado(UsuarioMock usuario, UsuarioMock senha, TelaMobileMock tl);
}
