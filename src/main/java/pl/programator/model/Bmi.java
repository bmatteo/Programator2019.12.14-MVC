package pl.programator.model;

import javax.persistence.*;

@Entity
public class Bmi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int weight;
    private int height;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private double bmiValue;

    public Bmi() {
    }

    public Bmi(int weight, int height, Sex sex, double bmiValue) {
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.bmiValue = bmiValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getBmiValue() {
        return bmiValue;
    }

    public void setBmiValue(double bmiValue) {
        this.bmiValue = bmiValue;
    }

    @Override
    public String toString() {
        return "Bmi{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", sex=" + sex +
                ", bmiValue=" + bmiValue +
                '}';
    }
}
