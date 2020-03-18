package com.testes.spring.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Faz o Spring mapear essa classe
@ComponentScan("com.testes.spring.mongodb") // Indica onde o Spring deve procurar novos componentes
@EnableWebMvc // Ativa o suporte básico do Spring para uma aplicação MVC. Ele, por exemplo,
				// mapeia os controllers, ativa o suporte de validação, os handlers de
				// exception, entre outras coisas...
public class WebConfig implements WebMvcConfigurer // Essa implementação permite que nós alteremos qualquer configuração
													// do @EnableWebMvc nessa classe (de uma olhada nas sobreescritas
													// possíveis)
{

}
