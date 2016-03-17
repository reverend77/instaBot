package pl.edu.agh.components;

import lombok.Getter;
import lombok.Setter;
import org.jinstagram.auth.model.Token;
import org.springframework.stereotype.Component;

/**
 * Created by lmarek on 17.03.16.
 */
@Component
public class TokenContainer {

    @Getter
    @Setter
    protected Token token;
}
