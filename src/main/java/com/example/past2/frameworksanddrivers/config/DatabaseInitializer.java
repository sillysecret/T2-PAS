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
            EmpresarialEntity empresarial1 = new EmpresarialEntity();
            empresarial1.setNome("Empresa Alpha");
            empresarial1.setEndereco("Avenida Industrial, 1000");
            empresarial1.setNomeFantasia("Alpha Tech");
            empresarial1.setCnpj("11.222.333/0001-44");

            EmpresarialEntity empresarial2 = new EmpresarialEntity();
            empresarial2.setNome("Empresa Beta");
            empresarial2.setEndereco("Rua Comercial, 456");
            empresarial2.setNomeFantasia("Beta Softwares");
            empresarial2.setCnpj("22.333.444/0001-55");

            IndividualEntity cliente1 = new IndividualEntity();
            cliente1.setNome("Carlos Silva");
            cliente1.setEndereco("Rua das Flores, 123");
            cliente1.setCpf("123.456.789-10");

            IndividualEntity cliente2 = new IndividualEntity();
            cliente2.setNome("Ana Oliveira");
            cliente2.setEndereco("Avenida Brasil, 789");
            cliente2.setCpf("987.654.321-00");

            clienteRepository.save(empresarial1);
            clienteRepository.save(empresarial2);
            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);

            System.out.println("Clientes populados no banco.");

            JogoMesaEntity xadrez = new JogoMesaEntity();
            xadrez.setNome("Xadrez Profissional");
            xadrez.setValorBase(150.0);
            xadrez.setTipo(TipoMesa.TABULEIRO);
            xadrez.setNumeroPecas(32);

            JogoMesaEntity dama = new JogoMesaEntity();
            dama.setNome("Damas Clássico");
            dama.setValorBase(100.0);
            dama.setTipo(TipoMesa.TABULEIRO);
            dama.setNumeroPecas(24);

            JogoEletronicoEntity fifa = new JogoEletronicoEntity();
            fifa.setNome("FIFA 24");
            fifa.setValorBase(299.90);
            fifa.setTipo(TipoEletronico.ESTRATEGIA);
            fifa.setPlataforma("PS5");

            JogoEletronicoEntity zelda = new JogoEletronicoEntity();
            zelda.setNome("Zelda: Breath of the Wild");
            zelda.setValorBase(349.90);
            zelda.setTipo(TipoEletronico.AVENTURA);
            zelda.setPlataforma("Nintendo Switch");

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

            AluguelEntity aluguel3 = new AluguelEntity();
            aluguel3.setCliente(clientes.get(2));
            aluguel3.setJogo(jogos.get(2));
            aluguel3.setDataInicial(LocalDate.now());
            aluguel3.setPeriodo(3);

            aluguelRepository.save(aluguel1);
            aluguelRepository.save(aluguel2);
            aluguelRepository.save(aluguel3);

            System.out.println("Aluguéis populados no banco.");
        };
    }
}
