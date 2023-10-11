package Model.Data;

import java.util.Objects;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int dropChance;

    public Toy(int id, String name, int count, int dropChance) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.dropChance = dropChance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDropChance() {
        return dropChance;
    }

    public void setDropChance(int dropChance) {
        this.dropChance = dropChance;
    }

    @Override
    public String toString() {
        return "Model.Data.Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", dropChance=" + dropChance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
