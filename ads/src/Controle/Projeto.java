/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Projeto {

    private ArrayList<IFila> lista_itens = new ArrayList<>();
    private ArrayList<IServidor> lista_servidores = new ArrayList<>();
    private ArrayList<IItemAgenda> agenda = new ArrayList<>();
    private double perda;
    private ArrayList<IItemAgenda> comeco = new ArrayList<>();

    //static double valortotal = 0;
    public void adicionaServidor(String nomeServidor, String nomeAresta, double capacidade, double quantidadeDeServidores) {

        lista_servidores.add(new Servidor(nomeServidor, capacidade, quantidadeDeServidores));
        perda = 0;
    }

    public void executa(double quantidadeDeExecucoes) {
        GeraRandomico g = GeraRandomico.getInstance();
        double i = 1;
        for (IItemAgenda item : comeco) {
            selecionaTipo(item.getObjetoASerExecutado(), 0);
        }
        while (i <= quantidadeDeExecucoes) {

            i = i + 0.0001;
        }

    }

    public double calculaRandomicoProblema(double a, double b) {
        GeraRandomico g = GeraRandomico.getInstance();
        //U(A,B) = (B – A) * U(0,1) + A

        return (b - a) * g.proximoRandomico() + a;
    }

    public void selecionaTipo(IFilaServidor itemASerProcessado, double tempo) {
        if (itemASerProcessado.getFila().getTipoDeFila() == 0) {
            processaFilaChegada(itemASerProcessado, tempo);
        }
        if (itemASerProcessado.getFila().getTipoDeFila() == 1) {
            processaFilaPassagem(itemASerProcessado, tempo);
        }
        if (itemASerProcessado.getFila().getTipoDeFila() == 2) {
            processaFilaSaida(itemASerProcessado, tempo);
        }

    }

    public void processaFilaChegada(IFilaServidor evento, double tempo) {
        IGeraRandomico g = GeraRandomico.getInstance();
        if (evento.getServidor().getCapacidadeUsada() < evento.getServidor().getCapacidade()) {
            for (IServidor s : lista_servidores) {
                if (s.getNome().equalsIgnoreCase(evento.getServidor().getNome())) {
                    s.aumentaACapacidadeEm1();
                    if (s.getCapacidadeUsada() <= s.getQuantidadeDeServidores()) {
                        for (IFilaServidor fs : evento.getFila().getEventosDeSaida()) {
                            if (g.proximoRandomico() > fs.getProbabilidade1() && g.proximoRandomico() < fs.getProbabilidade2()) {
                                adicionaNaAgenda(new ItemAgenda(calculaRandomicoProblema(fs.getFila().getTempo1(), fs.getFila().getTempo2()) + tempo, fs));
                            }
                        }
                    }
                    // contabiliza tempos
                }

            }

        }
        perda++;
        
    }

    public void processaFilaPassagem(IFilaServidor evento, double tempo) {
    }

    public void processaFilaSaida(IFilaServidor evento, double tempo) {
        
        for (IServidor s : lista_servidores) {
            if (s.getNome().equalsIgnoreCase(evento.getServidor().getNome())) {
                IGeraRandomico g = GeraRandomico.getInstance();
                s.reduzACapacidadeEm1();
                
                if (evento.getServidor().getCapacidadeUsada() < evento.getServidor().getCapacidade()) {

                    
                    if (s.getCapacidadeUsada() <= s.getQuantidadeDeServidores()) {
                        for (IFilaServidor fs : evento.getFila().getEventosDeSaida()) {
                            if (g.proximoRandomico() > fs.getProbabilidade1() && g.proximoRandomico() < fs.getProbabilidade2()) {
                                adicionaNaAgenda(new ItemAgenda(calculaRandomicoProblema(fs.getFila().getTempo1(), fs.getFila().getTempo2()) + tempo, fs));
                            }
                        }
                    }
                    // contabiliza tempos
                }
            }

        }
    }

    public void adicionaNaAgenda(IItemAgenda novoItem) {
        agenda.add(novoItem);
        organizaAgenda();
    }

    private void organizaAgenda() {
        for (int i = 0; i < agenda.size(); i++) {
            for (int j = 0; j < agenda.size() - 1; j++) {
                if (agenda.get(j).getTempo() > agenda.get(j + 1).getTempo()) {
                    IItemAgenda aux = agenda.get(j);
                    agenda.set(j, agenda.get(j));
                    agenda.set(j, aux);
                }
            }
        }

    }

}
