package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Questao3 {

    // Classe para representar o faturamento diário
    static class Faturamento {
        public int dia;
        public double faturamento;

        public Faturamento() {}

        public int getDia() {
            return dia;
        }

        public double getFaturamento() {
            return faturamento;
        }
    }

    public static void main(String[] args) {
        try {
            // Ler o arquivo JSON
            InputStream inputStream = Questao3.class.getClassLoader().getResourceAsStream("faturamento.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Faturamento> faturamentoList = mapper.readValue(inputStream, new TypeReference<List<Faturamento>>() {});


            // Inicializando variáveis para cálculo
            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            // Loop para calcular menor, maior e soma dos faturamentos
            for (Faturamento f : faturamentoList) {
                if (f.getFaturamento() > 0) {  // Ignorar dias sem faturamento
                    if (f.getFaturamento() < menorFaturamento) {
                        menorFaturamento = f.getFaturamento();
                    }
                    if (f.getFaturamento() > maiorFaturamento) {
                        maiorFaturamento = f.getFaturamento();
                    }
                    somaFaturamento += f.getFaturamento();
                    diasComFaturamento++;
                }
            }

            // Cálculo da média mensal
            double mediaFaturamento = somaFaturamento / diasComFaturamento;

            // Contar quantos dias tiveram faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (Faturamento f : faturamentoList) {
                if (f.getFaturamento() > mediaFaturamento) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibir os resultados
            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

