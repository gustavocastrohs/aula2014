/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Controle.Interfaces.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Gustavo
 */
public class Projeto implements IProjeto {

    private ArrayList<IFila> lista_filas = new ArrayList<>();
    private ArrayList<IServidor> lista_servidores = new ArrayList<>();
    private ArrayList<IItemAgenda> agenda = new ArrayList<>();
    private double perda;
    private ArrayList<IItemAgenda> comeco = new ArrayList<>();
    private IContabilizador contabilizador;
    private GeraRandomico g;
    //static double valortotal = 0;


    @Override
    public void executa(double quantidadeDeExecucoes) {
        g = GeraRandomico.getInstance();
        contabilizador  = Contabilizador.getInstance();
        double i = 0;
        DecimalFormat fmt = new DecimalFormat("0.0000");  
        
        for (IItemAgenda item : comeco) {
            selecionaTipo(item.getObjetoASerExecutado(), 0);
        }
        while (i <= quantidadeDeExecucoes) {
            if (agenda.size() > 0) {
                IItemAgenda a = agenda.get(0);
                
                String string = fmt.format(i);
                String[] part = string.split("[,]");
                String string2 = part[0] + "." + part[1];
                i = Double.parseDouble(string2);

                
                if ( i == a.getTempo()) {
                    selecionaTipo(a.getObjetoASerExecutado(), i);
                }
            }
            i = i + 0.0001;

        }

    }

    @Override
    public double calculaRandomicoProblema(double a, double b) {
        
        //U(A,B) = (B – A) * U(0,1) + A

        return (b - a) * g.proximoRandomico() + a;
    }

    public void selecionaTipo(IFilaServidor itemASerProcessado, double tempo) {
        if (itemASerProcessado.getFila().getTipoDeFila() == 0) {
            processaFilaChegada(itemASerProcessado, tempo);
            System.out.println("oi");
        }
        if (itemASerProcessado.getFila().getTipoDeFila() == 1) {
            processaFilaPassagem(itemASerProcessado, tempo);
        }
        if (itemASerProcessado.getFila().getTipoDeFila() == 2) {
            processaFilaSaida(itemASerProcessado, tempo);
        }

    }

    @Override
    public void processaFilaChegada(IFilaServidor evento, double tempo) {
        IServidor aux;
        IGeraRandomico g = GeraRandomico.getInstance();
        if (evento.getServidor().getCapacidadeUsada() < evento.getServidor().getCapacidade()) {
            for (IServidor s : lista_servidores) {
                if (s.getNome().equalsIgnoreCase(evento.getServidor().getNome())) {
                    aux = s;
                    s.aumentaACapacidadeEm1();
                    if (s.getCapacidadeUsada() <= s.getQuantidadeDeServidores()) {
                        for (IFilaServidor fs : evento.getFila().getEventosDeSaida()) {
                            if (g.proximoRandomico() > fs.getProbabilidade1() && g.proximoRandomico() < fs.getProbabilidade2()) {
                                adicionaNaAgenda(new ItemAgenda(calculaRandomicoProblema(fs.getFila().getTempo1(), fs.getFila().getTempo2()) + tempo, fs));
                            }
                        }
                    }
                    // contabiliza tempos
                    contabilizador.contabilia(aux, s, tempo);
                    break;
                }

            }

        }
        perda++;

    }

    @Override
    public void processaFilaPassagem(IFilaServidor evento, double tempo) {

        IServidor aux;
        for (IServidor s : lista_servidores) {
            if (s.getNome().equalsIgnoreCase(evento.getServidor().getNome())) {
                aux = s;
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
                break;
            }

        }

    }

    @Override
    public void processaFilaSaida(IFilaServidor evento, double tempo) {
        IServidor aux;
        for (IServidor s : lista_servidores) {
            if (s.getNome().equalsIgnoreCase(evento.getServidor().getNome())) {
                aux = s;
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
                break;
            }

        }
    }

    @Override
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

    public ArrayList<IFila> getLista_filas() {
        return lista_filas;
    }

    public void setLista_filas(ArrayList<IFila> lista_filas) {
        this.lista_filas = lista_filas;
    }

    public ArrayList<IServidor> getLista_servidores() {
        return lista_servidores;
    }

    public void setLista_servidores(ArrayList<IServidor> lista_servidores) {
        this.lista_servidores = lista_servidores;
    }

    public ArrayList<IItemAgenda> getComeco() {
        return comeco;
    }

    public void setComeco(ArrayList<IItemAgenda> comeco) {
        this.comeco = comeco;
    }
    
    @Override
    public void adicionaServidor(String nomeServidor, String nomeAresta, int capacidade, int quantidadeDeServidores) {

        lista_servidores.add(new Servidor(nomeServidor, capacidade, quantidadeDeServidores));
        perda = 0;
    }
    public void adicionaFila(String nome,int tempo1, int tempo2,int tipo){
       lista_filas.add(new Fila(nome,tempo1,tempo2,tipo));
    }
    public void adicionaServidor(IServidor servidor) {

        lista_servidores.add(servidor);
        perda = 0;
    }
}
