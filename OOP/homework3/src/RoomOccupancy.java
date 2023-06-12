public class RoomOccupancy {
    private static int totalNumber = 0;
    private int numberInRoom;

    public RoomOccupancy() {
        numberInRoom = 0;
    }

    public void addOneToRoom() {
        numberInRoom++;
        RoomOccupancy.totalNumber++;
    }

    public void removeOneFromRoom() {
        if (numberInRoom > 0) {
            numberInRoom--;
            RoomOccupancy.totalNumber--;
        }
    }

    public int getNumberInRoom() {
        return numberInRoom;
    }

    public static int getTotal() {
        return totalNumber;
    }
}
