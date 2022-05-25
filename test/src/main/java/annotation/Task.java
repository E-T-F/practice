package annotation;

public class Task {

    @PersonProvider(name = "哈哈哈", gender = "male")
    private String person;

    public Task(String person) {
        this.person = person;
    }

    public Task() {
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
