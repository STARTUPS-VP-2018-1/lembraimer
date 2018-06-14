package br.com.lembraimer.business.test;

import br.com.lembraimer.interfaces.test.UsuarioInterfaceMock;
import br.com.lembraimer.db.test.DataBaseMock;
import br.com.lembraimer.dominio.test.EnderecoMock;
import br.com.lembraimer.dominio.test.PacienteMock;
import br.com.lembraimer.dominio.test.UsuarioMock;
import br.com.lembraimer.tela.test.TelaMobileMock;
import br.com.lembraimer.tela.test.TelaUsuarioMock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class UsuarioBusinessMock implements UsuarioInterfaceMock{ 
    
    @Override
    public boolean checkLogin(String nomeLogin, String nomeResponsavel) {
        Connection conn;
    PreparedStatement cmd;
    ResultSet rs;
    
    boolean check = false;
    conn = DataBaseMock.conexao();
        try {
            cmd = conn.prepareStatement("SELECT * FROM paciente where nomePaciente = ? and nomeResponsavel = ?");
            cmd.setString(1, "Lucas");
            cmd.setString(2, "Yuri");
            rs = cmd.executeQuery();
            while(rs.next()){
                check = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBusinessMock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    

    @Override
    public UsuarioMock usuarioLogado(UsuarioMock usuario, UsuarioMock senha, TelaMobileMock tl) {
        
        if(this.checkLogin(usuario.getLogin(), senha.getSenha())){
            try {
            PreparedStatement cmd;
            Connection conn;
            ResultSet rs;
            
            conn = DataBaseMock.conexao();
            
            String query = "SELECT * FROM paciente where nomePaciente = ? and nomeResponsavel = ?";

            cmd = conn.prepareStatement(query);
            
            cmd.setString(1, "Lucas");
            cmd.setString(2, "Teste123");
            
            rs = cmd.executeQuery();
            
            PacienteMock paciente = new PacienteMock();
            EnderecoMock endereco = new EnderecoMock();
            
            while(rs.next()){
                  paciente.setId(Integer.parseInt(rs.getString("Id")));
                  paciente.setNomePaciente(rs.getString("nomePaciente"));
                  paciente.setNomeResponsavel(rs.getString("nomeResponsavel"));
                  paciente.setTelefone(Integer.parseInt(rs.getString("telefoneResponsavel")));
                  paciente.setRemedio(rs.getString("medicamento"));
                  paciente.setHorarioMedicamento(rs.getString("horarioMedicamento"));
                  endereco.setRua(rs.getString("endereco"));
                  paciente.setLembrete(rs.getString("lembretes"));
            }
            //teste certo
            TelaUsuarioMock novaTela = new TelaUsuarioMock(paciente.getNomePaciente(), paciente.getNomeResponsavel(), paciente.getTelefone(), endereco.getRua(), paciente.getHorarioMedicamento(), paciente.getLembrete(), paciente.getRemedio());
            novaTela.setVisible(true);
            
            tl.dispose();
            tl.setLocationRelativeTo(null);
            
            DataBaseMock.fecharfecharConexao(conn, cmd, rs);                            
             } catch(SQLException ex){
            System.out.println("Erro de conexão " + ex.getMessage());
        }
     
     }else{
            JOptionPane.showMessageDialog(null, "Erro de usuario");
        }
        return null;
    }
    
}
