import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

class Student {
    int id;
    String name;
    int age;
    String gender;
    String engDepartment;
    int yearOfEnrollment;
    double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + gender + ", " + engDepartment + ", " + yearOfEnrollment + ", " + perTillDate + "%)";
    }
}

public class StreamAssignment {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
                new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
                new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
                new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
                new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
                new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
                new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
                new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
                new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
                new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
                new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
                new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
                new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
                new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
                new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
                new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
                new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );

        // 1️⃣ Print the name of all departments in the college
        System.out.println("1. Departments:");
        students.stream()
                .map(s -> s.engDepartment)
                .distinct()
                .forEach(System.out::println);

        // 2️⃣ Get names of all students who have enrolled after 2018
        System.out.println("\n2. Students enrolled after 2018:");
        students.stream()
                .filter(s -> s.yearOfEnrollment > 2018)
                .map(s -> s.name)
                .forEach(System.out::println);

        // 3️⃣ Get details of all male students in the Computer Science department
        System.out.println("\n3. Male students in Computer Science:");
        students.stream()
                .filter(s -> s.gender.equalsIgnoreCase("Male") && s.engDepartment.equalsIgnoreCase("Computer Science"))
                .forEach(System.out::println);

        // 4️⃣ Count of male and female students
        System.out.println("\n4. Count of male and female students:");
        Map<String, Long> genderCount = students.stream()
                .collect(Collectors.groupingBy(s -> s.gender, Collectors.counting()));
        System.out.println(genderCount);

        // 5️⃣ Average age of male and female students
        System.out.println("\n5. Average age of male and female students:");
        Map<String, Double> avgAge = students.stream()
                .collect(Collectors.groupingBy(s -> s.gender, Collectors.averagingInt(s -> s.age)));
        System.out.println(avgAge);

        // 6️⃣ Student with highest percentage
        System.out.println("\n6. Student with highest percentage:");
        Optional<Student> topper = students.stream()
                .max(Comparator.comparingDouble(s -> s.perTillDate));
        topper.ifPresent(System.out::println);

        // 7️⃣ Count of students in each department
        System.out.println("\n7. Student count per department:");
        Map<String, Long> deptCount = students.stream()
                .collect(Collectors.groupingBy(s -> s.engDepartment, Collectors.counting()));
        deptCount.forEach((dept, count) -> System.out.println(dept + " : " + count));

        // 8️⃣ Average percentage in each department
        System.out.println("\n8. Average percentage per department:");
        Map<String, Double> avgPercent = students.stream()
                .collect(Collectors.groupingBy(s -> s.engDepartment, Collectors.averagingDouble(s -> s.perTillDate)));
        avgPercent.forEach((dept, avg) -> System.out.println(dept + " : " + avg));

        // 9️⃣ Youngest male student in Electronic department
        System.out.println("\n9. Youngest male student in Electronic department:");
        Optional<Student> youngestMaleElectronic = students.stream()
                .filter(s -> s.gender.equalsIgnoreCase("Male") && s.engDepartment.equalsIgnoreCase("Electronic"))
                .min(Comparator.comparingInt(s -> s.age));
        youngestMaleElectronic.ifPresent(System.out::println);

        // 🔟 Male and female count in Computer Science department
        System.out.println("\n10. Male and female count in Computer Science department:");
        Map<String, Long> csGenderCount = students.stream()
                .filter(s -> s.engDepartment.equalsIgnoreCase("Computer Science"))
                .collect(Collectors.groupingBy(s -> s.gender, Collectors.counting()));
        System.out.println(csGenderCount);
    }
}
