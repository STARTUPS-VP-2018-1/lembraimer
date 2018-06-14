package br.com.lembraimer.business.interfaces;

import java.util.List;
import br.com.lembraimer.dominio.Responsavel;

public interface ResponsavelInterface {
   
    public Responsavel salvarResponsavel(Responsavel responsavel);
    
    public List<Responsavel> buscarResponsavelPorNome(String nome);
    
}
