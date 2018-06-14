package br.com.lembraimer.interfaces.test;

import java.util.List;
import br.com.lembraimer.dominio.Responsavel;

public interface ResponsavelInterfaceMock {
   
    public Responsavel salvarResponsavel(Responsavel responsavel);
    
    public List<Responsavel> buscarResponsavelPorNome(String nome);
    
}
