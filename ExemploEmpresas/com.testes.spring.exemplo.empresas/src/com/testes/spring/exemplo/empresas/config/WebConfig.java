package com.testes.spring.exemplo.empresas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Faz o Spring mapear essa classe
@ComponentScan("com.testes.spring.exemplo.empresas") // Indica onde o Spring deve procurar novos componentes
@EnableWebMvc // Ativa o suporte b�sico do Spring para uma aplica��o MVC. Ele, por exemplo,
				// mapeia os controllers, ativa o suporte de valida��o, os handlers de
				// exception, entre outras coisas...
public class WebConfig implements WebMvcConfigurer // Essa implementa��o permite que n�s alteremos qualquer configura��o
													// do @EnableWebMvc nessa classe (de uma olhada nas sobreescritas
													// poss�veis)
{
	{
		System.out.println("WebConfig - Iniciado");
	}

}
