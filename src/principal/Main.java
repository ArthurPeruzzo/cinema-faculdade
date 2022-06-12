package principal;

import dao.FilmeDao;
import model.Filme;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme("nome2", LocalDateTime.now(), LocalDateTime.now());
        FilmeDao filmeDao = new FilmeDao();
        filmeDao.insert(filme);
        List<Filme> all = filmeDao.findAll();
    }
}
