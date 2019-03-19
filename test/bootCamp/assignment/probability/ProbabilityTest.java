package bootCamp.assignment.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    void getDimensionOfNegativeInteger() {
        assertThrows(Exception.class, () -> new Probability(-1));
    }

    @Test
    void shouldThrowExceptionForValueGreaterThanOne() {
        assertThrows(Exception.class, () -> new Probability(1.1));
    }

    @Test
    void shouldNotThrowExceptionForValidInput() {
        assertDoesNotThrow(() -> new Probability(0.9));
    }

    @Test
    void shouldReturnTheProbabilityOfNotGettingValue() throws Exception {
        Probability probabilityOfGettingHead = new Probability(0.5);
        Probability expected = probabilityOfGettingHead.not();
        Probability actual = new Probability(0.5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldReturnTheAndProbabilityWhenAnExternalProbabilityIsGiven() throws Exception {
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.4);
        Probability actual = probability1.and(probability2);
        Probability expected = new Probability(0.2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheOrProbabilityWhenAnExternalProbabilityIsGiven() throws Exception {
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.5);
        Probability actual = probability1.or(probability2);
        Probability expected = new Probability(0.75);
        assertEquals(actual, expected);
    }
}