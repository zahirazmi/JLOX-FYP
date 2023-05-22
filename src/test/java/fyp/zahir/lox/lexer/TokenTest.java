package fyp.zahir.lox.lexer;

import org.junit.jupiter.api.Test;

import static fyp.zahir.lox.lexer.TokenObjectMother.bang;
import static fyp.zahir.lox.lexer.TokenObjectMother.bangEqual;
import static fyp.zahir.lox.lexer.TokenObjectMother.one;
import static org.assertj.core.api.Assertions.assertThat;

class TokenTest {

    @Test
    void printsNicely() {
        assertThat(bang().toString()).isEqualTo("BANG ! null");
        assertThat(bangEqual().toString()).isEqualTo("BANG_EQUAL != null");
        assertThat(one().toString()).isEqualTo("NUMBER 1 1.0");
    }

}