package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "TODO";
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    public void moveNext() {
        switch (status) {
            case "TODO" -> status = "IN_PROGRESS";
            case "IN_PROGRESS" -> status = "DONE";
            case "DONE" -> System.out.println("⚠️ Tarefa já finalizada.");
        }
    }

    @Override
    public String toString() {
        return id + " | [" + status + "] " + title + ": " + description;
    }
}

