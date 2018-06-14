package br.com.lembraimer.business.test;
import br.com.lembraimer.business.interfaces.ResponsavelInterface;
import br.com.lembraimer.dominio.Responsavel;
import java.util.List;

public class ResponsavelBusinessMock implements ResponsavelInterface {

    @Override
    public Responsavel salvarResponsavel(Responsavel responsavel) {
            return responsavel;
    }

    @Override
    public List<Responsavel> buscarResponsavelPorNome(String nome) {
        
        return null;
    }
    
}