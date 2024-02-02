public class Main {
    static Bicycle bike1 = new Bicycle(1, 10);
    static Bicycle bike2 = new Bicycle(2,20);

    public static void main(String[] args) {

        System.out.println(bike1);
        bike1.changeGear(2);
        System.out.println(bike2);
        System.out.println(bike1);
        Main2.test();
    }

    static class Bicycle {
        private int gear;
        int speed;

        Bicycle(int gear,int speed) {
            this.gear = gear;
            this.speed = speed;
        }
        public void changeGear(int newGear) {
            this.gear = newGear;
        }
        @Override
        public String toString() {
            return "This bike is in " + gear + " gear, going at " + speed + " kph.";
        }
    }
}

class Main2 {
    static Main.Bicycle bike1 = new Main.Bicycle(3,25);

    public static void test() {
        System.out.println(bike1);
    }
}