package principal;

import dao.*;
import model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        FilmeDao filmeDao = new FilmeDao();
        Filme filme = new Filme("nome2", LocalDateTime.now(), LocalDateTime.now());
        Filme filmee = filmeDao.insert(filme);

        EstadoDao estadoDao = new EstadoDao();
        Estado estado = new Estado("PR");
        Estado estadoo = estadoDao.insert(estado);

        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = new Cidade("nome", estadoo);
        Cidade insertCidade = cidadeDao.insert(cidade);

        SalaDao salaDao = new SalaDao();
        Sala sala = new Sala("codigo1", insertCidade);
        Sala insertSala = salaDao.insert(sala);

        HorarioDao horarioDao = new HorarioDao();
        Horario horario = new Horario(LocalDateTime.now(), insertSala, filmee);
        horarioDao.insert(horario);

    }
}
