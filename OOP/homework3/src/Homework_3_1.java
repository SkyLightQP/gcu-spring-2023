public class Homework_3_1 {
    public static void main(String[] args) {
        RoomOccupancy roomA = new RoomOccupancy();
        RoomOccupancy roomB = new RoomOccupancy();

        System.out.println("Add one to room a and three to room b");
        roomA.addOneToRoom();
        for (int i = 0; i < 3; i++) roomB.addOneToRoom();
        System.out.println("Room a holds " + roomA.getNumberInRoom());
        System.out.println("Room b holds " + roomB.getNumberInRoom());
        System.out.println("Total in all rooms is " + RoomOccupancy.getTotal());

        System.out.println("Remove one from both rooms.");
        roomA.removeOneFromRoom();
        roomB.removeOneFromRoom();
        System.out.println("Room a holds " + roomA.getNumberInRoom());
        System.out.println("Room b holds " + roomB.getNumberInRoom());
        System.out.println("Total in all rooms is " + RoomOccupancy.getTotal());

        System.out.println("Remove two from room a.");
        for (int i = 0; i < 2; i++) roomA.removeOneFromRoom();
        System.out.println("Room a holds " + roomA.getNumberInRoom());
        System.out.println("Room b holds " + roomB.getNumberInRoom());
        System.out.println("Total in all rooms is " + RoomOccupancy.getTotal());

        System.out.println("Create room c and add three to it");
        RoomOccupancy roomC = new RoomOccupancy();
        for (int i = 0; i < 3; i++) roomC.addOneToRoom();
        System.out.println("Room a holds " + roomA.getNumberInRoom());
        System.out.println("Room b holds " + roomB.getNumberInRoom());
        System.out.println("Room c holds " + roomC.getNumberInRoom());
        System.out.println("Total in all rooms is " + RoomOccupancy.getTotal());
    }
}
