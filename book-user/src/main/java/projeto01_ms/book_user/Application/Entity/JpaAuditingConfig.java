package projeto01_ms.book_user.Application.Entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
//esse class auditora jpa, responsavel por gerenciar os registros de
//mudança de qualquer dado da aplicação esta ligada a entity User


}
