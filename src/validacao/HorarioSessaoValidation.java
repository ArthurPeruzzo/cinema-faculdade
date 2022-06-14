package validacao;

import model.HorarioSessao;
import processo.HorarioSessaoCalculaAssentos;

public class HorarioSessaoValidation extends Validation<HorarioSessao> {

    @Override
    public Boolean validar(HorarioSessao object) {
        return calcular();
    }

    public boolean calcular(){
        HorarioSessaoCalculaAssentos horarioSessaoCalculaAssentos = new HorarioSessaoCalculaAssentos();
       return horarioSessaoCalculaAssentos.queryNativa();
    }

}
