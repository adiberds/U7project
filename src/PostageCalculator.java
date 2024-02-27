public class PostageCalculator {
    private double weightCostLimit = 10.0;
    private double baseCost = 0.50;
    private double oversize = 2.0;

    public double calculatePostage(Package pkg) {
        double weightCost;
        if (pkg.getWeight() <= weightCostLimit) {
            weightCost = baseCost;
        } else {
            weightCost = 2 * baseCost;
        }

        double sizeCost;
        if (pkg.getLength() * pkg.getWidth() * pkg.getHeight() > 100) {
            sizeCost = oversize * baseCost;
        } else {
            sizeCost = baseCost;
        }

        return weightCost + sizeCost;
    }

    public double getWeightCostLimit() {
        return weightCostLimit;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getOversize() {
        return oversize;
    }
}
