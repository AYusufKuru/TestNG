package Gun03;

import org.testng.annotations.Test;

public class _01_Dependency {

    //testleri birbirine bağlama
    @Test
    void startCar(){
        System.out.println("startCar");
    }
    @Test(dependsOnMethods = {"startCar"})
    void driveCar(){
        System.out.println("driveCar");
    }
    @Test(dependsOnMethods = {"driveCar", "driveCar"})//birden fazla teste bağlama
    void parkCar(){
        System.out.println("parkCar");
    }
    @Test(dependsOnMethods = {"parkCar"},alwaysRun = true) //bir problem olsada mutlaka çalışsın
    void stopCar(){
        System.out.println("stopCar");
    }
}
