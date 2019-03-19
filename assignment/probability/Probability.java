package bootCamp.assignment.probability;

class Probability {
    private static final int UPPER_BOUND = 1;
    private static final int LOWER_BOUND = 0;
    private double probability;

    Probability(double probability) throws Exception {
        validate(probability);
        this.probability = probability;
    }

    private void validate(double probability) throws Exception {
        if (probability > UPPER_BOUND || probability < LOWER_BOUND) {
            throw new Exception();
        }
    }

    Probability not() throws Exception {
        double notGettingProbability = UPPER_BOUND - probability;
        return new Probability(notGettingProbability);
    }

    Probability and(Probability probability) throws Exception {
        double newProbability = probability.probability;
        return new Probability(newProbability * this.probability);
    }

    Probability or(Probability probability) throws Exception {
        Probability andProbability = this.and(probability);
        return new Probability(UPPER_BOUND - andProbability.probability);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Probability that = (Probability) obj;
        return Double.compare(that.probability, probability) == 0;
    }
}
