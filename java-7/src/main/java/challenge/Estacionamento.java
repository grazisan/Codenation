package challenge;

import java.util.ArrayList;
import java.util.List;


public class Estacionamento {

    private static final int LIMITE = 10;
    private List<Carro> listaCarros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(listaCarros.size() < LIMITE) {
            if(carro.getMotorista() != null && carro.getMotorista().getIdade() > 18 && carro.getMotorista().getPontos() < 21) {
                listaCarros.add(carro);
            }else {
                throw new EstacionamentoException("não pode estacionar");
            }

        }else if(listaCarros.size() == LIMITE) {
            for (int i = 0; i < 10; i++) {
                if(listaCarros.get(i).getMotorista().getIdade() < 55) {
                    listaCarros.remove(i);
                    listaCarros.add(carro);
                }else {
                    throw new EstacionamentoException("não pode estacionar");
                }
            }
        }
    }

    public int carrosEstacionados(){

        return listaCarros.size();
    }

    public boolean carroEstacionado(Carro carro){

        return listaCarros.contains(carro);

    }

}
