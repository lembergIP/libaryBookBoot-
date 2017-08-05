package ua.lvivl.libary.entity;


public enum Genre {

ADVENTURES("ADVENTURES"),
  BUSINESS("BUSINESS"),
    COMPUTERS("COMPUTERS"),
    DETECTIVE("DETECTIVE"),
    FAMALY("FAMALY"),
    HISTORICAL("HISTORICAL"),
    MYSTICISM("MYSTICISM"),
    NOVEL("NOVEL"),
    PSYCHOLOGY("PSYCHOLOGY"),
    RELIGION("RELIGION"),
    SCIENCE("SCIENCE"),
    TALES("TALES"),
    THRILLER("THRILLER");

    String name;
    Genre(final String name){
        this.name=name;
    }
}
