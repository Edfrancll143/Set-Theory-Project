import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements of Set A (comma-separated): ");
        String[] inputA = scanner.nextLine().split(",");
        Set<String> setA = new HashSet<>();
        for (String element : inputA) {
            setA.add(element.trim());
        }

        System.out.println("Enter elements of Set B (comma-separated): ");
        String[] inputB = scanner.nextLine().split(",");
        Set<String> setB = new HashSet<>();
        for (String element : inputB) {
            setB.add(element.trim());
        }

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Union (A ∪ B)");
            System.out.println("2. Intersection (A ∩ B)");
            System.out.println("3. Difference (A - B and B - A)");
            System.out.println("4. Subset Check (A ⊆ B and B ⊆ A)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Set<String> union = new HashSet<>(setA);
                    union.addAll(setB);
                    System.out.println("Union (A ∪ B): " + formatSet(union));
                    break;

                case 2:
                    Set<String> intersection = new HashSet<>(setA);
                    intersection.retainAll(setB);
                    System.out.println("Intersection (A ∩ B): " + formatSet(intersection));
                    break;

                case 3:
                    Set<String> differenceA = new HashSet<>(setA);
                    differenceA.removeAll(setB);
                    Set<String> differenceB = new HashSet<>(setB);
                    differenceB.removeAll(setA);
                    System.out.println("Difference (A - B): " + formatSet(differenceA));
                    System.out.println("Difference (B - A): " + formatSet(differenceB));
                    break;

                case 4:
                    boolean isSubsetA = setB.containsAll(setA);
                    boolean isSubsetB = setA.containsAll(setB);
                    System.out.println("Is A a subset of B? " + (isSubsetA ? "Yes" : "No"));
                    System.out.println("Is B a subset of A? " + (isSubsetB ? "Yes" : "No"));
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static String formatSet(Set<String> set) {
        StringBuilder sb = new StringBuilder("{");
        for (String element : set) {
            sb.append("'").append(element).append("'").append(", ");
        }
        if (!set.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }
}
