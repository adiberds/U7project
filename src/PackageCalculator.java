import java.util.ArrayList;
import java.util.List;
public class PackageSimulator {
    private List<Package> packages;

    public PackageSimulator() {
        this.packages = new ArrayList<>();
    }

    public void addPackage(Package pkg) {
        packages.add(pkg);
    }

    public void resetSimulation() {
        packages.clear();
    }

    public void simulatePackages() {
        double totalCost = 0.0;
        for (Package pkg : packages) {
            double postageCost = calculatePostage(pkg);
            totalCost += postageCost;
            System.out.println("Package: Weight=" + pkg.getWeight() + ", Length=" + pkg.getLength() +
                    ", Height=" + pkg.getHeight() + ", Width=" + pkg.getWidth() +
                    ", Postage Cost=" + postageCost);
        }
        System.out.println("Total Postage Cost for all packages: " + totalCost);
    }

    private double calculatePostage(Package pkg) {
        double weightCost;
        if (pkg.getWeight() <= pkg.getWeightCostLimit()) {
            weightCost = pkg.getBaseCost();
        } else {
            weightCost = 2 * pkg.getBaseCost();
        }

        double sizeCost;
        if (pkg.getLength() * pkg.getWidth() * pkg.getHeight() > 100) {
            sizeCost = pkg.getOversize() * pkg.getBaseCost();
        } else {
            sizeCost = pkg.getBaseCost();
        }

        return weightCost + sizeCost;
    }
}