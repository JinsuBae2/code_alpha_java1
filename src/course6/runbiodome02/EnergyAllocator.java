package course6.runbiodome02;

@FunctionalInterface
public interface EnergyAllocator {
    void allocate(String zone, int amount);
}
