class ParkingSystem {
    private int[] spaces;
    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[] {-1, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (spaces[carType] > 0) {
            spaces[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */