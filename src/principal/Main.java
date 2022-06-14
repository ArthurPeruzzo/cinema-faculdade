package principal;

import dao.*;
import model.*;
import validacao.HorarioSessaoValidation;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        FilmeDao filmeDao = new FilmeDao();
        Filme filme = new Filme(1L, "nome2", LocalDateTime.now(), LocalDateTime.now());
//        Filme filmee = filmeDao.insert(filme);

//        EstadoDao estadoDao = new EstadoDao();
        Estado estado = new Estado(1L, "PR");
//        Estado estadoo = estadoDao.insert(estado);

//        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = new Cidade(1L, "nome", estado);
//        Cidade insertCidade = cidadeDao.insert(cidade);

//        SalaDao salaDao = new SalaDao();
        Sala sala = new Sala(1L, "codigo1", cidade);
//        Sala insertSala = salaDao.insert(sala);

        Pessoa pessoa = new Pessoa(1L, "Arthur", "teste@gmail.com", "senha", "930219321");


//        HorarioDao horarioDao = new HorarioDao();
        HorarioSessao horario = new HorarioSessao(LocalDateTime.now(), sala, filme);
//        horarioDao.insert(horario);

        Pedido pedido = new Pedido(1L, horario, StatusPedido.PAGO, pessoa);

        HorarioSessaoValidation horarioSessaoValidation = new HorarioSessaoValidation();
        Boolean validar = horarioSessaoValidation.validar(horario);



    }
}
