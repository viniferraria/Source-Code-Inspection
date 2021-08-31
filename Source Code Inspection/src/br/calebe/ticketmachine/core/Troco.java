package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        // Controle - loop infinito, uma vez que não altera o valor da variável de valor, logo o controle ficará repetindo a mesma instrução infinitamente
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        // Controle - loop infinito, uma vez que não altera o valor da variável de valor, logo o controle ficará repetindo a mesma instrução infinitamente
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;

        // Controle - loop infinito, uma vez que não altera o valor da variável de valor, logo o controle ficará repetindo a mesma instrução infinitamente
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;

        // Controle - loop infinito, uma vez que não altera o valor da variável de valor, logo o controle ficará repetindo a mesma instrução infinitamente
        while (valor % 10 != 0) {
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;

        // Controle - loop infinito, uma vez que não altera o valor da variável de valor, logo o controle ficará repetindo a mesma instrução infinitamente
        while (valor % 5 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;

        // Controle - loop infinito, uma vez que não altera o valor da variável de valor, logo o controle ficará repetindo a mesma instrução infinitamente
        while (valor % 2 != 0) {
            count++;
        }
        //  Computação - Sobrescreve a quatidade de PapelMoeda 5
        papeisMoeda[1] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        // Excesso - trecho de código não é utilizado
        public boolean hasNext() {
            // Interface - faz suposição do tamanho do vetor
            // Dados - o código tentará acessa um índice inexistente Ex: papeisMoeda[6] sendo que o vetor termina em papeisMoeda[5]
            // Controle - parece que o loop era pra ser reverso, uma vez que começa no último número, porém, a cada execução incrementa o valor de i, tornando-o um loop infinito
            // Desempenho - loop desnecessário, pelo nome, o método deveria validar somente se existe um próximo elemento, não validar o vetor inteiro
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            // Controle - parece que o loop era pra ser reverso, uma vez que começa no último número, porém, a cada execução incrementa o valor de i, tornando-o um loop infinito
            // Controle - retorna sempre o último valor
            for (int i = 6; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        // Excesso - método não tem utilidade
        // Comissão - método não executa o que propõem, não remove elementos
        public void remove() {
            next();
        }
    }
}
