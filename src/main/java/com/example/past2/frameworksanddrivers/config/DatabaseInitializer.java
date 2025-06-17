package com.example.past2.frameworksanddrivers.config;

import com.example.past2.enterprisebusinessrules.model.TipoEletronico;
import com.example.past2.enterprisebusinessrules.model.TipoMesa;
import com.example.past2.frameworksanddrivers.persistence.IAluguelJpaRepository;
import com.example.past2.frameworksanddrivers.persistence.IClienteJpaRepository;
import com.example.past2.frameworksanddrivers.persistence.IJogoJpaRepository;
import com.example.past2.interfaceadapters.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initDatabase(IClienteJpaRepository clienteRepository, IJogoJpaRepository jogoRepository, IAluguelJpaRepository aluguelRepository) {
        return args -> {
            EmpresarialEntity empresa1 = new EmpresarialEntity();
            empresa1.setNome("Empresa Alpha");
            empresa1.setEndereco("Avenida Industrial, 1000");
            empresa1.setNomeFantasia("Alpha Tech");
            empresa1.setCnpj("11.222.333/0001-44");

            EmpresarialEntity empresa2 = new EmpresarialEntity();
            empresa2.setNome("Empresa Beta");
            empresa2.setEndereco("Rua Comercial, 456");
            empresa2.setNomeFantasia("Beta Softwares");
            empresa2.setCnpj("22.333.444/0001-55");

            IndividualEntity cliente1 = new IndividualEntity();
            cliente1.setNome("Carlos Silva");
            cliente1.setEndereco("Rua das Flores, 123");
            cliente1.setCpf("123.456.789-10");

            IndividualEntity cliente2 = new IndividualEntity();
            cliente2.setNome("Ana Oliveira");
            cliente2.setEndereco("Avenida Brasil, 789");
            cliente2.setCpf("987.654.321-00");

            clienteRepository.save(empresa1);
            clienteRepository.save(empresa2);
            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);

            System.out.println("Banco populado com dados de exemplo.");

            JogoMesaEntity xadrez = new JogoMesaEntity();
            xadrez.setNome("Xadrez Profissional");
            xadrez.setValorBase(150.0);
            xadrez.setTipo(TipoMesa.TABULEIRO);
            xadrez.setNumeroPecas(32);

            // Jogo de mesa 2
            JogoMesaEntity dama = new JogoMesaEntity();
            dama.setNome("Damas Clássico");
            dama.setValorBase(100.0);
            dama.setTipo(TipoMesa.TABULEIRO);
            dama.setNumeroPecas(24);

            // Jogo eletrônico 1
            JogoEletronicoEntity fifa = new JogoEletronicoEntity();
            fifa.setNome("FIFA 24");
            fifa.setValorBase(299.90);
            fifa.setTipo(TipoEletronico.ESTRATEGIA);
            fifa.setPlataforma("PS5");

            // Jogo eletrônico 2
            JogoEletronicoEntity zelda = new JogoEletronicoEntity();
            zelda.setNome("Zelda: Breath of the Wild");
            zelda.setValorBase(349.90);
            zelda.setTipo(TipoEletronico.AVENTURA);
            zelda.setPlataforma("Nintendo Switch");

            // Salvando todos
            jogoRepository.save(xadrez);
            jogoRepository.save(dama);
            jogoRepository.save(fifa);
            jogoRepository.save(zelda);

            System.out.println("Jogos populados no banco.");

            List<ClienteEntity> clientes = clienteRepository.findAll();
            List<JogoEntity> jogos = jogoRepository.findAll();

            if (clientes.size() < 2 || jogos.size() < 2) {
                System.out.println("Dados insuficientes para criar aluguéis.");
                return;
            }

            // Aluguel 1
            AluguelEntity aluguel1 = new AluguelEntity();
            aluguel1.setCliente(clientes.get(0));
            aluguel1.setJogo(jogos.get(0));
            aluguel1.setDataInicial(LocalDate.now().minusDays(2));
            aluguel1.setPeriodo(5);

            // Aluguel 2
            AluguelEntity aluguel2 = new AluguelEntity();
            aluguel2.setCliente(clientes.get(1));
            aluguel2.setJogo(jogos.get(1));
            aluguel2.setDataInicial(LocalDate.now());
            aluguel2.setPeriodo(3);

            aluguelRepository.save(aluguel1);
            aluguelRepository.save(aluguel2);

            System.out.println("Aluguéis populados no banco.");
        };
    }
}
