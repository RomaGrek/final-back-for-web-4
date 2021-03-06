package main.web.entity;

import lombok.Data;

import javax.persistence.*;


/* аннотации, которые используются в стандарте JPA и в различных фреймворках вроде Hibernate(кроме).
 * @Entity – Указывает, что данный бин (класс) является сущностью.
 * @Table – указывает на имя таблицы, которая будет отображаться в этой сущности.
 * @id - id колонки
 * @GeneratedValue - указывает, что данное свойство будет создаваться согласно указанной стратегии.*/
@Data
@Entity
@Table(name = "pip_point")
public class Point {
    private @Id @GeneratedValue Long id;
    private Double x;
    private Double y;
    private Double r;
    private Boolean isInArea;

    @ManyToOne
    private User user;

    public Point() {}

    public Point(double x, double y, double r, boolean isInArea) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInArea;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }

    public Boolean getInArea() {
        return isInArea;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setInArea(Boolean inArea) {
        isInArea = inArea;
    }

    /* метод который делает ответ более простым чтобы вернуть его на клиент */
    public AnswerPoint convertToSimplePoint(){
        return new AnswerPoint(x,y,r,isInArea);
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", isInArea=" + isInArea +
                ", user=" + user +
                '}';
    }
}