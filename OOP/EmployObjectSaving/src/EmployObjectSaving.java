import java.io.*;

public class EmployObjectSaving {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        System.out.println("Write a object in the " + file);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Hong Gildong");
        employee.setDepartment("Software");
        employee.setExpLevel(1000.50);

        objectOutputStream.writeObject(employee);

        objectOutputStream.close();
        fileOutputStream.close();
        
        System.out.println();
        System.out.println("Read a object in the " + file);

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Employee result = (Employee) objectInputStream.readObject();
        System.out.println("ID: " + result.getId());
        System.out.println("Name: " + result.getName());
        System.out.println("Department: " + result.getDepartment());
        System.out.println("ExpLevel: " + result.getExpLevel());

        objectInputStream.close();
        fileInputStream.close();
    }
}
