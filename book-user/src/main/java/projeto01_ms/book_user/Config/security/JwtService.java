package projeto01_ms.book_user.Config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.public}")
    private String publicaKey;

    public String generateToken(UserDetails userDetails){
        Date now = new Date();

    }

}
