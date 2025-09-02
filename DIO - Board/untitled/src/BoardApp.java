import model.Task;
import java.util.*;

public class BoardApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1-Criar | 2-Listar | 3-Mover | 4-Remover | 5-Sair");
            switch (scanner.nextLine()) {
                case "1" -> create();
                case "2" -> list();
                case "3" -> move();
                case "4" -> remove();
                case "5" -> { System.out.println("Saindo..."); return; }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void create() {
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(nextId++, title, desc));
    }

    private static void list() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private static void move() {
        System.out.print("ID da tarefa: ");
        int id = Integer.parseInt(scanner.nextLine());
        tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .ifPresentOrElse(Task::moveNext, () -> System.out.println("Tarefa não encontrada."));
    }

    private static void remove() {
        System.out.print("ID da tarefa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (tasks.removeIf(t -> t.getId() == id)) {
            System.out.println("✅ Removida.");
        } else {
            System.out.println("⚠️ Tarefa não encontrada.");
        }
    }
}
