package com.jb.dronelab.interfaces;

public interface DroneTypes {
    //pojo
    //DJI(air,matrice 300), Parrot, Atul, PixHawk (zm4)
    String groupName();
    String label();
    enum DJI implements DroneTypes{
        Air("Air"),
        M300("Matrice 300");

        private final String label;

        DJI(String label){
            this.label=label;
        }


        @Override
        public String groupName() {
            return null;
        }

        @Override
        public String label() {
            return null;
        }
    }
    enum PX4 implements DroneTypes{
        ZM4("Custom 4 rotor");
        private final String label;

        PX4(String label){this.label=label;}

        @Override
        public String groupName() {
            return null;
        }

        @Override
        public String label() {
            return null;
        }
    }
    enum Elvina implements DroneTypes{
        guci("Fast crashing drone"),
        alice("Advanced and proffesiolnal drone");

        private final String label;
        Elvina(String label){this.label=label;}

        @Override
        public String groupName() {
            return null;
        }

        @Override
        public String label() {
            return null;
        }
    }
}
