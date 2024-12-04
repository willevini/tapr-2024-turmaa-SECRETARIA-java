package br.univille.microservsecretaria;

import com.azure.spring.data.cosmos.core.mapping.EnableCosmosAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCosmosAuditing
@SpringBootApplication
public class MicroservsecretariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservsecretariaApplication.class, args);

		String asciiArt =
				"""
						╔════════════════════════════════════════════════════════════════════════════╗
						║                                                                            ║
						║    🚀 Server is running!                                                   ║
						║    🌐 Access: http://localhost:8080/swagger-ui/index.html                  ║
						║                                                                            ║
						╟────────────────────────────────────────────────────────────────────────────╢
						║                                                                            ║
						║ _                                             _ _            \s             ║
						║ | |                                           | (_)           \s            ║
						║ | |__   __ _ _ __  _ __  _   _    ___ ___   __| |_ _ __   __ _\s            ║
						║ | '_ \\ / _` | '_ \\| '_ \\| | | |  / __/ _ \\ / _` | | '_ \\ / _` |            ║
						║ | | | | (_| | |_) | |_) | |_| | | (_| (_) | (_| | | | | | (_| |            ║
						║ |_| |_|\\__,_| .__/| .__/ \\__, |  \\___\\___/ \\__,_|_|_| |_|\\__, |            ║
						║            | |   | |     __/ |                           __/ |             ║
						║            |_|   |_|    |___/                           |___/\s             ║
						╚════════════════════════════════════════════════════════════════════════════╝
				""";

		System.out.println(asciiArt);
	}

}
