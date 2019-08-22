package utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiBracketValidationTest {

    @Test
    public void testMultiBracketValidation_resultTrue1() {
        boolean result = MultiBracketValidation.multiBracketValidation("{}");
        assertTrue(result);
    }

    @Test
    public void testMultiBracketValidation_resultTrue2() {
        boolean result = MultiBracketValidation.multiBracketValidation("{}(){}");
        assertTrue(result);
    }

    @Test
    public void testMultiBracketValidation_resultTrue3() {
        boolean result = MultiBracketValidation.multiBracketValidation("()[[Extra Characters]]");
        assertTrue(result);
    }

    @Test
    public void testMultiBracketValidation_resultTrue4() {
        boolean result = MultiBracketValidation.multiBracketValidation("(){}[[]]");
        assertTrue(result);
    }

    @Test
    public void testMultiBracketValidation_resultTrue5() {
        boolean result = MultiBracketValidation.multiBracketValidation("{}{Code}[Fellows](())");
        assertTrue(result);
    }

    @Test
    public void testMultiBracketValidation_resultFalse1() {
        boolean result = MultiBracketValidation.multiBracketValidation("[({}]");
        assertFalse(result);
    }

    @Test
    public void testMultiBracketValidation_resultFalse2() {
        boolean result = MultiBracketValidation.multiBracketValidation("(](");
        assertFalse(result);
    }

    @Test
    public void testMultiBracketValidation_resultFalse3() {
        boolean result = MultiBracketValidation.multiBracketValidation("{(})");
        assertFalse(result);
    }
}