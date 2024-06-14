class Solution {
    public int wateringPlants(int[] plants, int capacity) {
       int steps = 0;
       int N=plants.length;
    int waterInCan = capacity;
    int currentPos = -1; 

    for (int i = 0; i < N; i++) {
        if (waterInCan >= plants[i]) {
            waterInCan -= plants[i];
        } else {
              steps += (i-1); // Move back to the water source
            steps += (i + 1); // Move back to the current plant
            waterInCan = capacity - plants[i]; // Refill and water the current plant
        }
        //Moving to next plant
        steps++;
    }
    return steps;   
    }
}