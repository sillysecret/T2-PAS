package com.example.past2.frameworksanddrivers.config;

import com.example.past2.enterprisebusinessrules.model.TipoEletronico;
import com.example.past2.enterprisebusinessrules.model.TipoMesa;
import com.example.past2.frameworksanddrivers.persistence.IAluguelJpaRepository;
import com.example.past2.frameworksanddrivers.persistence.IClienteJpaRepository;
import com.example.past2.frameworksanddrivers.persistence.IJogoJpaRepository;
import com.example.past2.enterprisebusinessrules.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initDatabase(IClienteJpaRepository clienteRepository, IJogoJpaRepository jogoRepository,
            IAluguelJpaRepository aluguelRepository) {
        return args -> {
            ClienteEntity empresarial1 = new EmpresarialEntity("Empresa Alpha", "Avenida Industrial, 1000",
                    "Alpha Tech", "11.222.333/0001-44");
            ClienteEntity empresarial2 = new EmpresarialEntity("Empresa Beta", "Rua Comercial, 456", "Beta Softwares",
                    "22.333.444/0001-55");
            ClienteEntity empresarial3 = new EmpresarialEntity("Empresa Gamma", "Praça da Inovação, 789",
                    "Gamma Solutions", "33.444.555/0001-66");

            ClienteEntity individual1 = new IndividualEntity("Carlos Silva", "Rua das Flores, 123", "123.456.789-10");
            ClienteEntity individual2 = new IndividualEntity("Ana Oliveira", "Avenida Brasil, 789", "987.654.321-00");
            ClienteEntity individual3 = new IndividualEntity("Pedro Santos", "Travessa dos Coqueiros, 45",
                    "111.222.333-44");

            clienteRepository
                    .saveAll(List.of(empresarial1, empresarial2, empresarial3, individual1, individual2, individual3));
            System.out.println("Clientes populados no banco.");

            JogoEntity xadrez = new JogoMesaEntity("Xadrez Profissional", 15.0, TipoMesa.TABULEIRO, 32);
            JogoEntity dama = new JogoMesaEntity("Damas Clássico", 10.0, TipoMesa.TABULEIRO, 24);
            JogoEntity poker = new JogoMesaEntity("Kit de Poker Profissional", 25.0, TipoMesa.CARTAS, null); // Numero
                                                                                                             // de peças
                                                                                                             // não se
                                                                                                             // aplica
            JogoEntity uno = new JogoMesaEntity("Uno", 8.0, TipoMesa.CARTAS, null);
            JogoEntity war = new JogoMesaEntity("War - Edição Clássica", 20.0, TipoMesa.TABULEIRO, 360);

            JogoEntity fifa = new JogoEletronicoEntity("EA Sports FC 25", 35.0, TipoEletronico.ESTRATEGIA, "PS5");
            JogoEntity zelda = new JogoEletronicoEntity("The Legend of Zelda: Tears of the Kingdom", 40.0,
                    TipoEletronico.AVENTURA, "Nintendo Switch");
            JogoEntity flightSimulator = new JogoEletronicoEntity("Microsoft Flight Simulator", 30.0,
                    TipoEletronico.SIMULACAO, "PC");
            JogoEntity ageOfEmpires = new JogoEletronicoEntity("Age of Empires IV", 28.0, TipoEletronico.ESTRATEGIA,
                    "PC");
            JogoEntity theSims = new JogoEletronicoEntity("The Sims 4", 22.0, TipoEletronico.SIMULACAO,
                    "PC/PS4/Xbox One");

            jogoRepository.saveAll(
                    List.of(xadrez, dama, poker, uno, war, fifa, zelda, flightSimulator, ageOfEmpires, theSims));
            System.out.println("Jogos populados no banco.");

            List<ClienteEntity> clientes = clienteRepository.findAll();
            List<JogoEntity> jogos = jogoRepository.findAll();

            if (clientes.size() < 3 || jogos.size() < 3) {
                System.out.println("Dados de clientes ou jogos insuficientes para criar aluguéis.");
                return;
            }

            AluguelEntity aluguel1 = new AluguelEntity(null, LocalDate.now().minusDays(10), 7, clientes.get(0),
                    jogos.get(5));
            AluguelEntity aluguel2 = new AluguelEntity(null, LocalDate.now().minusDays(5), 10, clientes.get(3),
                    jogos.get(1));
            AluguelEntity aluguel3 = new AluguelEntity(null, LocalDate.now(), 15, clientes.get(4), jogos.get(6));

            aluguelRepository.saveAll(List.of(aluguel1, aluguel2, aluguel3));

            System.out.println("Aluguéis populados no banco.");
        };
    }
}
